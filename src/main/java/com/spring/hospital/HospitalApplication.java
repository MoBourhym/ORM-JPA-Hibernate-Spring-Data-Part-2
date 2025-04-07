package com.spring.hospital;

import com.spring.hospital.entities.*;
import com.spring.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService) {
        return args -> {

            System.out.println("▶ Saving Patients...");
            Stream.of("Sami", "Imad", "Imane", "Alae", "Kawtar", "Nour").forEach(name -> {
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setMalade(Math.random() > 0.5);
                patient.setDateNaissance(new Date());
                hospitalService.savePatient(patient);
            });

            System.out.println("▶ Saving Medecins...");
            Stream.of("Khouloud", "Ayman", "Leila", "Ayoub", "Yahya").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name + "@gmail.com");
                medecin.setSpecialite(Math.random() > 0.5 ? "Cardiologue" : "Dentiste");
                hospitalService.saveMedecin(medecin);
            });

            // Get a known patient and medecin
            Patient patient = hospitalService.getPatientByNom("Sami");
            Medecin medecin = hospitalService.getMedecinByNom("Yahya");

            if (patient != null && medecin != null) {
                System.out.println("▶ Creating a RendezVous...");
                RendezVous rendezVous = new RendezVous();
                rendezVous.setDate(new Date());
                rendezVous.setMedecin(medecin);
                rendezVous.setPatient(patient);
                rendezVous.setStatus(StatusRDV.PENDING);
                RendezVous savedRDV = hospitalService.saveRDV(rendezVous);

                System.out.println("▶ Creating Consultation...");
                Consultation consultation = new Consultation();
                consultation.setDate(new Date());
                consultation.setRendezVous(savedRDV);
                consultation.setRapport("Rapport de la consultation initiale.");
                hospitalService.saveConsultation(consultation);
                System.out.println("✅ Consultation saved successfully.");
            } else {
                System.out.println("❌ Patient or Medecin not found. Cannot create RendezVous.");
            }

            System.out.println("▶ Listing all patients:");
            List<Patient> patients = hospitalService.getAllPatients();
            patients.forEach(p -> System.out.println("🧍 Patient: " + p.getNom() + ", malade: " + p.isMalade()));

            System.out.println("▶ Listing all medecins:");
            hospitalService.getAllMedecins().forEach(m -> System.out.println("👨‍⚕️ Medecin: " + m.getNom() + ", spécialité: " + m.getSpecialite()));
        };
    }
}
