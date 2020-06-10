package ru.aryhlinskaya.Diplom;

import org.springframework.beans.factory.annotation.Autowired;
import ru.aryhlinskaya.Diplom.config.DBConfig;

public class Items {
    Integer id;
    String name;
    @Autowired
    DBConfig dbConfig;
    public Items() {
    }

    public Items(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
