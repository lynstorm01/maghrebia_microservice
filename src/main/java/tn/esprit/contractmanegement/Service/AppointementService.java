package tn.esprit.contractmanegement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.contractmanegement.Entity.Appointement;
import tn.esprit.contractmanegement.Repository.AppointementRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointementService implements IAppointementService {

    private final AppointementRepository appointementRepository;

    @Autowired
    public AppointementService(AppointementRepository appointementRepository) {
        this.appointementRepository = appointementRepository;
    }

    // ✅ Création d'un appointment
    @Override
    public Appointement createAppointment(Appointement appointement) {
       // Vous pouvez ici éventuellement forcer archiver à true si vous le souhaitez
       return appointementRepository.save(appointement);
   }



    // ✅ Récupère tous les appointments dont archiver est true
    @Override
    public List<Appointement> getAllAppointments() {
        List<Appointement> appointments = appointementRepository.findByArchiverTrue();
        return appointments.isEmpty() ? new ArrayList<>() : appointments;
    }

    // ✅ Récupère un appointment par ID
    @Override
    public Optional<Appointement> getAppointmentById(Long id) {
        return appointementRepository.findById(id);
    }

    // ✅ Mise à jour d'un appointment
    @Override
    public Appointement updateAppointment(Long appointementId, Appointement updatedAppointement) {
        return appointementRepository.findById(appointementId).map(existingAppointement -> {
            existingAppointement.setDescription(updatedAppointement.getDescription());
            existingAppointement.setDateSubmitted(updatedAppointement.getDateSubmitted());
            existingAppointement.setStatus(updatedAppointement.getStatus());
            // Mise à jour du champ archiver (visible uniquement si true)
            existingAppointement.setArchiver(updatedAppointement.isArchiver());
            return appointementRepository.save(existingAppointement);
        }).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    // ✅ Suppression d'un appointment
    @Override
    public void deleteAppointment(Long id) {
        if (!appointementRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found");
        }
        appointementRepository.deleteById(id);
    }

    public List<Appointement> getAppointmentsByUserId(Long userId) {
        return appointementRepository.findByUserId(userId);
    }

    public boolean isDateAvailable(LocalDate date) {
        long count = appointementRepository.countByDateSubmitted(date);
        return count < 3; // Vérifie si la date contient moins de 3 rendez-vous
    }

    // Méthode planifiée pour changer le statut à "CONFIRMED" après 1 minute    // Méthode planifiée pour changer le statut à "CONFIRMED" après 1 minute
    @Scheduled(fixedRate = 60000)
    public void confirmPendingAppointments() {
        List<Appointement> appointments = appointementRepository.findByStatus("PENDING");
        Date currentTime = new Date(); // Heure actuelle

        System.out.println("Scheduled task executed at: " + currentTime);

        for (Appointement appointement : appointments) {
            if ("PENDING".equals(appointement.getStatus())) {
                // Vérification de la différence en millisecondes
                long difference = currentTime.getTime() - appointement.getDateSubmitted().getTime();

                // Log pour débogage
                System.out.println("Appointment ID " + appointement.getIdAppointment() + " difference: " + difference);

                if (difference > 60000) { // Si plus de 60 secondes ont passé
                    appointement.setStatus("CONFIRMED");
                    appointementRepository.save(appointement);

                    // Log de confirmation
                    System.out.println("Appointment ID " + appointement.getIdAppointment() + " confirmed");
                }
            }
        }
    }



}
