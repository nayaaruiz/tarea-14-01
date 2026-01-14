package com.salesianos.triana.dam.clinicflow.service;

import com.salesianos.triana.dam.clinicflow.model.Cita;
import com.salesianos.triana.dam.clinicflow.repository.CitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository repository;

    public List<Cita> findAll() { return repository.findAll(); }

    public void crearCita(Cita cita) {
        repository.save(cita);
    }

    public void cancelarCita(Cita cita) {
        repository.delete(cita);
    }

}
