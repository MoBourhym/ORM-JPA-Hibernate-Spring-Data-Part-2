package com.spring.hospital.service;

import com.spring.hospital.entities.Consultation;
import com.spring.hospital.entities.Medecin;
import com.spring.hospital.entities.Patient;
import com.spring.hospital.entities.RendezVous;

import java.util.concurrent.ConcurrentSkipListMap;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
