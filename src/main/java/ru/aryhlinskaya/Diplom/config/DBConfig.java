package ru.aryhlinskaya.Diplom.config;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import org.bson.Document;

public class DBConfig {
    MongoClient client;
    MongoDatabase database;
    DBConfig(){
        client = MongoClients.create();
        database = client.getDatabase("ElectronicJournal");
    }
}
