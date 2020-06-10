package ru.aryhlinskaya.Diplom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ru.aryhlinskaya.Diplom")
public class BeanConfig {
    @Bean
    public DBConfig connect(){
        return new DBConfig();
    }
}
