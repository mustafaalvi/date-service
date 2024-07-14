package com.hour.carmedy.model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "conversations")
@Data
@Builder
public class Conversation {

    @Id
    ObjectId id;
    ObjectId userId;
    long conversationId;
    LocalDateTime timestamp;
    List<Message> messages;



    @Data
    public static class Message {

        String sender;
        String message;
        LocalDateTime timestamp;

        public Message(String sender, String message, LocalDateTime timestamp){
            this.sender = sender;
            this.message = message;
            this.timestamp = timestamp;
        }

    }


}
