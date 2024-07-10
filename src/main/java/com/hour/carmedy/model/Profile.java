package com.hour.carmedy.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserProfiles")
@Data
public class Profile {

    @Id
    public String id;
    public String name;
    public int age;
    public String occupation;
    public String gender;
    public String summary;


}
