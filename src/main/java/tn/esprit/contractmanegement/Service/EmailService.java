    package tn.esprit.contractmanegement.Service;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.mail.SimpleMailMessage;
    import org.springframework.mail.javamail.JavaMailSender;
    import org.springframework.stereotype.Service;
    import tn.esprit.contractmanegement.Controller.EmailRequest;

    public interface EmailService {
        void sendEmail(EmailRequest emailRequest);
    }

