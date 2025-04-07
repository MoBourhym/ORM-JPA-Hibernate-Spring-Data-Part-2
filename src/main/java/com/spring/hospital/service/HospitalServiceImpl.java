package com.spring.hospital.service;

import com.spring.hospital.Repositories.ConsultationRepository;
import com.spring.hospital.Repositories.MedecineRepository;
import com.spring.hospital.Repositories.PatientRepository;
import com.spring.hospital.Repositories.RendezVousRepository;
import com.spring.hospital.entities.Consultation;
import com.spring.hospital.entities.Medecin;
import com.spring.hospital.entities.Patient;
import com.spring.hospital.entities.RendezVous;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private ConsultationRepository consultationRepository;
    private MedecineRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, ConsultationRepository consultationRepository, MedecineRepository medecinRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
