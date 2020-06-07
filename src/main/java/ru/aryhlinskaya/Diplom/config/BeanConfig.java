package ru.aryhlinskaya.Diplom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public DBConfig connect(){
        return new DBConfig();
    }
}
