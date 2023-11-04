package com.hour.carmedy;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String connectionString = "mongodb+srv://<username>:<password>@cluster0.mongodb.net/test";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("your-database-name");
            MongoCollection<Document> collection = database.getCollection("your-collection-name");
        }
    }
}