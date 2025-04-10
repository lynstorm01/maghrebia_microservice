package tn.esprit.pisinister.Util;
//import javax.mail.Session;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;

public class EmailClass {

    private final String username = "mailapitest69@gmail.com";
    private final String password = "vdkp ntrw gamc cqhs";

//    private Session createEmailSession() {
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.ssl.enable", "true");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "false");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "465");
//        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
//
//        return Session.getInstance(props, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//    }
//
//    public void sendMeetingReminder(String receiver, String organiserName, String participantName, String meetingDate, String meetingTime, String meetingLink) {
//        try {
//            Session session = createEmailSession();
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
//            message.setSubject("🔔 Rappel de votre réunion - Jitsi Meet");
//
//            // Use HTML format for better readability
//            String formattedMessage = String.format(
//                    "<html><body>"
//                            + "<h2>📢 Meeting Reminder</h2>"
//                            + "<p>Hello,</p>"
//                            + "<p> Your scheduled meeting is as follows:</p>"
//                            + "<ul>"
//                            + "<li><b>📌 Organizer :</b> %s</li>"
//                            + "<li><b>👤 Participant :</b> %s</li>"
//                            + "</ul>"
//                            + "<p><b>📅 Date :</b> %s</p>"
//                            + "<p><b>⏰ Time :</b> %s</p>"
//                            + "<p><b>🔗 Meeting Link :</b> <a href='%s'>Click here to join</a></p>"
//                            + "<p>Please make sure to log in on time.</p>"
//                            + "<p>Best regards,<br>Almaghrebeya Insurance.</p>"
//                            + "</body></html>",
//                    organiserName, participantName, meetingDate, meetingTime, meetingLink
//            );
//
//            message.setContent(formattedMessage, "text/html; charset=utf-8");
//
//            Transport.send(message);
//            System.out.println("✔️ Email reminder sent to " + receiver);
//        } catch (MessagingException e) {
//            System.err.println("❌ Error sending email to" + receiver + " : " + e.getMessage());
//        }
//    }
//
//
//    public void sendHtmlEmail(String receiver, String subject, String htmlContent) {
//        try {
//            Session session = createEmailSession();
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
//            message.setSubject(subject);
//            message.setContent(htmlContent, "text/html; charset=utf-8");
//
//            Transport.send(message);
//            System.out.println("✔️ Email HTML envoyé à " + receiver);
//        } catch (MessagingException e) {
//            System.err.println("❌ Erreur d'envoi de l'email à " + receiver + " : " + e.getMessage());
//        }
//    }

}