package com.spring.hospital.Repositories;

import com.spring.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecineRepository extends JpaRepository<Medecin,Long> {
    Medecin findMedecinByNom(String nom);

}
