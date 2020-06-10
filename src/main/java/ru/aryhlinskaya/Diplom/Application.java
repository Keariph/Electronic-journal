package ru.aryhlinskaya.Diplom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aryhlinskaya.Diplom.config.BeanConfig;
import ru.aryhlinskaya.Diplom.config.DBConfig;

import java.util.ArrayList;

public class Application {
    public static void main(String args[]){
        SpringApplication.run(Application.class, args);
    }
}
