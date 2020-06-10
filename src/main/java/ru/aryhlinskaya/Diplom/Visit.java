package ru.aryhlinskaya.Diplom;

import org.springframework.beans.factory.annotation.Autowired;
import ru.aryhlinskaya.Diplom.config.DBConfig;

import java.util.Date;
import java.util.List;

public class Visit implements ActionWithDB<Visit>{
    Integer id;
    Integer student;
    Boolean visit;
    Date date;
    @Autowired
    DBConfig dbConfig;
    public Visit() {
    }

    public Visit(Integer id, Integer student, Boolean visit, Date date) {
        this.id = id;
        this.student = student;
        this.visit = visit;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Boolean getVisit() {
        return visit;
    }

    public void setVisit(Boolean visit) {
        this.visit = visit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString(){
        return "{\"id\":" + getId() +", \"student\":" + getStudent() +
                ", \"visit\":" + getVisit() + ", \"date\":\'" + getDate() + "\'}";
    }

    @Override
    public void create() {
        String query = "insert into public.\"" + this.getClass().getName() +
                "\" (id, student, visit, date) " + "(%d, %s, %d, %s)";
        query = String.format(query, id, student, visit, date);
        System.out.println(query);
        dbConfig.update(query);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public List<Visit> read(String query) {
        return null;
    }
}
