package tn.esprit.contractmanegement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.contractmanegement.Service.ChatbotService2;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController2 {

    @Autowired
    private ChatbotService2 chatbotService;  // L'injection fonctionne maintenant après l'ajout de @Service

    @PostMapping("/send-message")
    public String envoyerMessage(@RequestBody String message) {
        return chatbotService.envoyerMessage(message);  // Envoie le message à Rasa et retourne la réponse
    }
}
