package com.hour.carmedy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hour.carmedy.model.ChatResponseModel;
import com.hour.carmedy.model.Conversation;
import com.hour.carmedy.repository.ConversationsRepository;
import org.bson.types.ObjectId;
import org.json.JSONObject; //using the light-weight org.json, as opposed to org.bson, Gson, or Jackson
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DungeonChatService {

    @Value("${chatgpt.api.url}")
    private String apiUrl;

    @Value("${chatgpt.api.model}")
    private String model;

    @Value("${chatgpt.api.max_tokens}")
    private int max_tokens;

    private final RestClient restClient;

    @Autowired
    public DungeonChatService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Autowired
    private ConversationsRepository conversationRepository;

    public String queryCreature(ObjectId userId, String query, String aiDescription) throws JsonProcessingException {
        //todo: move this requestBody logic to RestClientConfig
        //todo: have the aiDescription get pulled from the creature's profile
        JSONObject requestBody = createPayload(aiDescription, query);
        System.out.println(requestBody.toString(2));

        ChatResponseModel response = restClient.post()
                .uri(apiUrl)
                .body(requestBody.toString())
                .retrieve()
                .body(ChatResponseModel.class);

        Optional<String> content = Optional.ofNullable(response)
                .map(chatResponseModel -> chatResponseModel.getChoices())
                .map(choices -> choices[0])
                .map(choice -> choice.getMessage())
                .map(message -> message.getContent());

        System.out.println(response);

        //todo: add functionality to save the conversation
        // saveDialogue(userId, query, content);

        return content.get();
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

    public JSONObject createPayload(String aiDescription, String query){
        JSONObject requestBody = new JSONObject();
        List<JSONObject> messagesList = initPersonality(aiDescription);
        messagesList.add(new JSONObject().put("role", "user").put("content", query));
        requestBody.put("messages", messagesList.toArray());
        requestBody.put("model", model);
        requestBody.put("max_completion_tokens", max_tokens);
        return requestBody;
    }

    public List<JSONObject> initPersonality(String aiDescription){
        List<JSONObject> messagesList = new ArrayList<>();
        messagesList.add( new JSONObject().put("role", "system").put("content", aiDescription));
        return messagesList;
    }
}
