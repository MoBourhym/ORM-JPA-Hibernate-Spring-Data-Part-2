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

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private final PatientRepository patientRepository;
    private final ConsultationRepository consultationRepository;
    private final MedecineRepository medecinRepository;
    private final RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository,
                               ConsultationRepository consultationRepository,
                               MedecineRepository medecinRepository,
                               RendezVousRepository rendezVousRepository) {
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

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient getPatientByNom(String nom) {
        return patientRepository.findByNom(nom);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Medecin getMedecinByNom(String nom) {
        return medecinRepository.findMedecinByNom(nom);
    }

    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public RendezVous getRendezVousById(Long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public List<RendezVous> getRDVByPatientId(Long patientId) {
        return rendezVousRepository.findByPatientId(patientId);
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }
}
