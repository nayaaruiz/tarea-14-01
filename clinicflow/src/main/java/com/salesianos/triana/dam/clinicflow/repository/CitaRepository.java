package com.salesianos.triana.dam.clinicflow.repository;

import com.salesianos.triana.dam.clinicflow.model.Cita;
import com.salesianos.triana.dam.clinicflow.model.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository <Cita, Long> {

    List<Cita> findByPacienteId(Long paciente_id);

    Page<Cita> findByEstado(Estado estado, Pageable pageable);

    boolean exististsByProfesionalIdAndFechaHora(
            Long profesional_id,
            LocalDateTime fechaHora
    );

    boolean existsByPacienteIdAndFechaHoraBetween(
            Long paciente_id,
            LocalDateTime inicio,
            LocalDateTime fin
    )

}
