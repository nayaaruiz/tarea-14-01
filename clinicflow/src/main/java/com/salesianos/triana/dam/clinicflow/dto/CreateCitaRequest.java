package com.salesianos.triana.dam.clinicflow.dto;

import com.salesianos.triana.dam.clinicflow.model.Estado;
import java.time.LocalDateTime;

public record CreateCitaRequest(
        Long id,
        LocalDateTime fechaHora,
        Estado estado,
        Long consulta_id,
        Long paciente_id,
        Long profesional_id
) {

    /*Transferir los datos básicos necesarios desde el cliente hacia el servicio de persistencia.
    Para optimizar el rendimiento, este DTO debe capturar los IDs de las relaciones, permitiendo que el servidor use
    getReferenceById para establecer asociaciones sin realizar consultas SELECT previas innecesarias*/

}
