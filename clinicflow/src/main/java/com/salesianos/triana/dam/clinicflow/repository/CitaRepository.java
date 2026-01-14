package com.salesianos.triana.dam.clinicflow.repository;

import com.salesianos.triana.dam.clinicflow.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository <Cita, Long> {
}
