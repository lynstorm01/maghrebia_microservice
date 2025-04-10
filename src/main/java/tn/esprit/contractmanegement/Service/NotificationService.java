package tn.esprit.contractmanegement.Service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendAlert(String message) {
        // Envoi de l'alerte à l'équipe (peut être un système de notification interne ou par SMS)
        System.out.println("ALERTE : " + message);
    }
}

