package com.spring.hospital.Repositories;

import com.spring.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
    List<RendezVous> findByPatientId(Long patientId);
}
