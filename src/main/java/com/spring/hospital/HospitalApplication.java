package com.spring.hospital;

import com.spring.hospital.Repositories.ConsultationRepository;
import com.spring.hospital.Repositories.MedecineRepository;
import com.spring.hospital.Repositories.PatientRepository;
import com.spring.hospital.Repositories.RendezVousRepository;
import com.spring.hospital.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository, MedecineRepository medecineRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {

        return args -> {
            Stream.of("Sami", "Imad", "Imane","Alae","Kawtar","Nour").forEach(name -> {
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setMalade(true);
                patient.setDateNaissance(new Date());
                patientRepository.save(patient);

            });


            Stream.of("Khouloud","Ayman","Leila","Ayoub","Yahya").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"Wgmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                medecineRepository.save(medecin);
            });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient2 = patientRepository.findByNom("Sami");

            Medecin medecin = medecineRepository.findMedecinByNom("Yahya");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setMedecin(medecin);
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);

            rendezVousRepository.save(rendezVous);

           RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
           Consultation consultation=new Consultation();
           consultation.setDate(new Date());
           consultation.setRendezVous(rendezVous1);

           consultation.setRapport("Rapport de la consultation---------");
           consultationRepository.save(consultation);
        };



    };




}
