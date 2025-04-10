package tn.esprit.pisinister.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pisinister.Services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

//    private final EmailService emailService;
//
//    public EmailController(EmailService emailService) {
//        this.emailService = emailService;
//    }
//
//    @GetMapping("/send-reminder")
//    public String sendMeetingReminder(
//            @RequestParam String receiver,
//            @RequestParam String organiserName,
//            @RequestParam String participantName,
//            @RequestParam String meetingDate,
//            @RequestParam String meetingTime,
//            @RequestParam String meetingLink) {
//        emailService.sendMeetingReminder(receiver, organiserName, participantName, meetingDate, meetingTime, meetingLink);
//        return "Meeting reminder email sent to " + receiver;
//    }
//
//    @GetMapping("/send-html")
//    public String sendHtmlEmail(
//            @RequestParam String receiver,
//            @RequestParam String subject,
//            @RequestParam String htmlContent) {
//        emailService.sendHtmlEmail(receiver, subject, htmlContent);
//        return "HTML email sent to " + receiver;
//    }
}
