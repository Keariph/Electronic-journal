package ru.aryhlinskaya.Diplom.config;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import org.bson.Document;

public class DBConfig {
    public String connect(){
        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("ElectronicJournal");
        return "hello";
    }
}
