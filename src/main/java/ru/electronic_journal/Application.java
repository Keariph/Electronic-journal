package ru.electronic_journal;

import org.springframework.boot.SpringApplication;
import ru.electronic_journal.config.DBConfig;

public class Application {
    public static void main(String args[]){
        SpringApplication.run(Application.class, args);
        DBConfig dbConfig = new DBConfig();
    }
}
