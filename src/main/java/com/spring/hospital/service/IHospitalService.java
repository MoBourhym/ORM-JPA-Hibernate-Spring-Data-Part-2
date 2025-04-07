package com.spring.hospital.service;

import com.spring.hospital.entities.Consultation;
import com.spring.hospital.entities.Medecin;
import com.spring.hospital.entities.Patient;
import com.spring.hospital.entities.RendezVous;

import java.util.List;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

    Patient getPatientById(Long id);
    Patient getPatientByNom(String nom);
    List<Patient> getAllPatients();
    void deletePatient(Long id);

    Medecin getMedecinByNom(String nom);
    List<Medecin> getAllMedecins();

    RendezVous getRendezVousById(Long id);
    List<RendezVous> getRDVByPatientId(Long patientId);

    List<Consultation> getAllConsultations();
}
