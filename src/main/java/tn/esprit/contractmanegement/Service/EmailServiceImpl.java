package tn.esprit.contractmanegement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.contractmanegement.Controller.EmailRequest;
import tn.esprit.contractmanegement.Entity.Claims;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());

        try {
            mailSender.send(message);
            System.out.println("Email sent successfully to: " + emailRequest.getTo());
        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    }

    public void sendClaimConfirmationEmail(Claims claim) {
        String to = "user@example.com"; // Remplace par l'email utilisateur récupéré
        String subject = "Confirmation de votre réclamation";
        String body = "Bonjour,\n\n"
                + "Nous avons bien reçu votre réclamation concernant " + claim.getReclamationType() + ".\n"
                + "Description : " + claim.getDescription() + "\n"
                + "Statut actuel : " + claim.getStatus() + "\n\n"
                + "Nous vous tiendrons informé de l'évolution.\n\n"
                + "Cordialement,\nL'équipe Support";

        sendEmail(to, subject, body);
    }

    private void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
