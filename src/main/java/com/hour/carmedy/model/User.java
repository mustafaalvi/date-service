package com.hour.carmedy.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Users")
@Data
public class User {

    @Id
    private ObjectId id;
    private String email;
    private String username;
    private String password_hash;
    private Date created_at;
    private Date updated_at;


}
