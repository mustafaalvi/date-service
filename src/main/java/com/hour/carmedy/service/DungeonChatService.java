package com.hour.carmedy.service;

import com.hour.carmedy.model.Conversation;
import com.hour.carmedy.repository.ConversationsRepository;
import org.bson.types.ObjectId;
import org.json.JSONObject; //using the light-weight org.json, as opposed to org.bson, Gson, or Jackson
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class DungeonChatService {

    @Value("${chatgpt.api.url}")
    private String apiUrl;

    private final RestClient restClient;

    @Autowired
    public DungeonChatService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Autowired
    private ConversationsRepository conversationRepository;

    public String getCreatureResponse(ObjectId userId, String query) {
        //todo: move this requestBody logic to RestClientConfig
        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("messages", new JSONObject[]{new JSONObject().put("role", "user").put("content", query)});

        String response = restClient.post()
                .uri(apiUrl)
                .body(requestBody)
                .retrieve()
                .body(String.class);

        // Save the conversation
        saveDialogue(userId, query, response);
        return response;
    }

    public void saveDialogue(ObjectId userId, String query, String response){
        Conversation.Message userMessage = new Conversation.Message("user", query, LocalDateTime.now());
        Conversation.Message botMessage = new Conversation.Message("bot", response, LocalDateTime.now());
        Conversation conversation = Conversation.builder()
                .userId(userId)
                .timestamp(LocalDateTime.now())
                .messages(Arrays.asList(userMessage, botMessage))
                .build();
        conversationRepository.save(conversation);
    }
}
