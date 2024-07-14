package com.hour.carmedy.model;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class ChatRequestModel {

    private ObjectId userId;
    private String personality;
    private String content;
}
