package tn.esprit.contractmanegement.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/api/twilio")
public class TwilioController {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @PostMapping("/sendSms")
    public String sendSms(@RequestBody SmsRequest smsRequest) {
        Twilio.init(accountSid, authToken);

        Message message = Message.creator(
                new PhoneNumber(smsRequest.getTo()),
                new PhoneNumber(twilioPhoneNumber),
                smsRequest.getMessage()
        ).create();

        return "Message envoyé avec SID : " + message.getSid();
    }

    static class SmsRequest {
        private String to;
        private String message;

        public String getTo() { return to; }
        public void setTo(String to) { this.to = to; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }
}

