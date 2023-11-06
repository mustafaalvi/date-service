package com.hour.carmedy.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "UserProfiles")
@Data
public class UserProfile {

    @Id
    public int id;
    public String name;
    public String occupation;
    public String gender;
    public String summary;


}
