package tn.esprit.contractmanegement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.contractmanegement.Service.ChatBotService;

@RestController
@RequestMapping("/api/chat")
public class ChatBotController {

    @Autowired
    private ChatBotService chatBotService;

    @PostMapping("/")
    public String chat(@RequestBody String userMessage) {
        try {
            return chatBotService.getBotResponse(userMessage);
        } catch (Exception e) {
            return "Désolé, une erreur est survenue lors de la communication avec le chatbot.";
        }
    }
}
