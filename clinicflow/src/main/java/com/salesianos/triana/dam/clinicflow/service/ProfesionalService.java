package com.salesianos.triana.dam.clinicflow.service;

import com.salesianos.triana.dam.clinicflow.model.Cita;
import com.salesianos.triana.dam.clinicflow.model.Estado;
import com.salesianos.triana.dam.clinicflow.model.Profesional;
import com.salesianos.triana.dam.clinicflow.repository.ProfesionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesionalService {

    private final ProfesionalRepository repository;

    private CitaService citaService;

    public List<Cita> obtenerCitas(Profesional profesional){
        return citaService.findAll()
                .stream()
                .filter(c -> c.getProfesional().equals(profesional))
                .toList();
    }

    public void validar(LocalDateTime nuevaFecha) {
        if(nuevaFecha.)
    }

    public void cancelar(Cita cita) {

        switch (cita.getEstado()) {
            case ATENDIDA ->
                    throw new RuntimeException("No se puede cancelar porque ya se ha completado la cita");
            case CANCELADA ->
                    throw new RuntimeException("La cita ya se ha cancelado anteriormente");
            case PROGRAMADA -> {
                citaService.cancelarCita(cita);
                System.out.println("La cita se ha cancelado correctamente");
            }
            default -> throw new IllegalArgumentException("No se ha encontrado la cita");
        }

    }

}
