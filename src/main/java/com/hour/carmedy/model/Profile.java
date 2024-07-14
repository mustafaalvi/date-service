package com.hour.carmedy.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserProfiles")
@Data
public class Profile {

    @Id
    private ObjectId id;
    private ObjectId userId;
    private String name;
    private int age;
    private String occupation;
    private String gender;
    private String summary;


}
