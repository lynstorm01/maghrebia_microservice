package tn.esprit.contractmanegement.Service;

import com.google.cloud.dialogflow.v2.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChatBotService {

    private static final String PROJECT_ID = "my-project-27471-1733791046054";
    private static final String SESSION_ID = UUID.randomUUID().toString(); // UUID généré automatiquement



    public String getBotResponse(String query) throws Exception {
        SessionsClient sessionsClient = SessionsClient.create();
        SessionName session = SessionName.of(PROJECT_ID, SESSION_ID);

        TextInput textInput = TextInput.newBuilder().setText(query).setLanguageCode("fr").build();
        QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

        DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
        String botReply = response.getQueryResult().getFulfillmentText();

        return botReply;
    }
}
