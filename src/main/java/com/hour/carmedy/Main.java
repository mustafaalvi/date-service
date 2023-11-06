package com.hour.carmedy;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        String connectionString = "mongodb+srv://mualvi:iloverona@cluster0.fnsv9.gcp.mongodb.net/?retryWrites=true&w=majority";
//        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
//            MongoDatabase database = mongoClient.getDatabase("DateApp");
//            MongoCollection<Document> collection = database.getCollection("UserProfiles");
//        }

    }
}