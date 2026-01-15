package com.salesianos.triana.dam.clinicflow.service;

import com.salesianos.triana.dam.clinicflow.dto.CreateCitaRequest;
import com.salesianos.triana.dam.clinicflow.dto.CreateConsultaRequest;
import com.salesianos.triana.dam.clinicflow.model.*;
import com.salesianos.triana.dam.clinicflow.repository.CitaRepository;
import com.salesianos.triana.dam.clinicflow.repository.PacienteRepository;
import com.salesianos.triana.dam.clinicflow.repository.ProfesionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;
    private final PacienteRepository pacienteRepository;
    private final ProfesionalRepository profesionalRepository;

    public void crearCita(CreateCitaRequest request) {
        if (request.fechaHora().isBefore(LocalDateTime.now())){
            throw new RuntimeException("No se puede crear una cita en el pasado");
        }

        if (citaRepository.exististsByProfesionalIdAndFechaHora(
                request.profesional_id(),
                request.fechaHora())) {
            throw new RuntimeException("Profesional ocupado");
        }

        //Sólo una cita al día
        LocalDate dia = request.fechaHora().toLocalDate();
        if (citaRepository.existsByPacienteIdAndFechaHoraBetween(
                request.paciente_id(),
                dia.atStartOfDay(),
                dia.atTime(LocalTime.MAX))){
            throw new RuntimeException("El paciente ya tiene una cita ese día");
        }

        Paciente paciente = pacienteRepository
                .findById(request.paciente_id())
                .orElseThrow();

        Profesional profesional = profesionalRepository
                .findById(request.profesional_id())
                .orElseThrow();

        Cita cita = new Cita();
        cita.setFechaHora(request.fechaHora());
        cita.setEstado(Estado.PROGRAMADA);
        cita.setPaciente(paciente);
        cita.setProfesional(profesional);

        citaRepository.save(cita);

    }

    public void cancelarCita(Long id) {

        Cita cita = citaRepository.findById().orElseThrow();

        if (cita.getEstado() == Estado.ATENDIDA) {
            throw new RuntimeException("No se puede cancelar una cita atendida");
        }

        cita.setEstado(Estado.CANCELADA);

    }

    public void registrarConsulta (Long id, CreateConsultaRequest request) {

        Cita cita = citaRepository.findById(id).orElseThrow();

        if (cita.getEstado() != Estado.PROGRAMADA) {
            throw new RuntimeException("La cita no está programada");
        }

        Consulta consulta = new Consulta();
        consulta.setFecha(LocalDate.now());
        consulta.setObservaciones(request.observaciones());
        consulta.setDiagnostico(request.diagnostico());
        consulta.set

    }

}
