package tn.esprit.contractmanegement.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;  // Ajoute cette ligne
import org.springframework.web.client.RestTemplate;

@Service  // Ajoute cette annotation pour que Spring puisse gérer la classe
public class ChatbotService2 {
    private static final String RASA_URL = "http://localhost:5005/webhooks/rest/webhook";

    public String envoyerMessage(String message) {
        RestTemplate restTemplate = new RestTemplate();
        String json = "{\"sender\":\"user\",\"message\":\"" + message + "\"}";

        ResponseEntity<String> response = restTemplate.postForEntity(RASA_URL, json, String.class);
        return response.getBody();
    }
}
