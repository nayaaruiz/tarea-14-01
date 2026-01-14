package com.salesianos.triana.dam.clinicflow.controller;

import com.salesianos.triana.dam.clinicflow.model.Cita;
import com.salesianos.triana.dam.clinicflow.service.CitaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitaController {

    private CitaService citaService;

    @PostMapping("/citas")
    public void crearCita(Cita cita) {
        citaService.crearCita(cita);
    }

    @PutMapping("/citas/{id}/cancelar")
    public void cancelarCita(Long id) {

    }

    @PostMapping("/citas/{id}/consulta")
    public void obtenerConsulta(Long id) {

    }

    @GetMapping("/citas")
    public void obtenerCitas() {

    }

}
