package com.salesianos.triana.dam.clinicflow.dto;

import java.time.LocalDate;
import java.util.List;

public record CreateConsultaRequest(
        Long id,
        List<String> observaciones,
        String diagnostico,
        LocalDate fecha
) {
    /*
    Los campos deben coincidir exactamente con los nombres de los atributos
    de la entidad para que el motor de ejecución cree las instancias correctamente
     */
}
