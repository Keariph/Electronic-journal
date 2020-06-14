package ru.electronic_journal;

import org.springframework.beans.factory.annotation.Autowired;
import ru.aryhlinskaya.Diplom.config.DBConfig;

import java.util.ArrayList;

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

    protected ArrayList<Integer> stringToArray(String list){
        list = list.replace("{}", "");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        String[] arrey = list.split(",");
        for(int i = 0; i < arrey.length; i++){
            arrayList.add(Integer.parseInt(arrey[i]));
        }
        return arrayList;
    }
}
