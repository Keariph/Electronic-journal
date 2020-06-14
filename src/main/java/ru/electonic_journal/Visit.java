package ru.electonic_journal;

import org.springframework.beans.factory.annotation.Autowired;
import ru.aryhlinskaya.Diplom.config.DBConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        String query = "update set UPDATE public.\"" + this.getClass().getName() +
                "\"SET id=%d, student_id=%d, visit=%d, date=%s" +
                "WHERE id = %d;";
        query = String.format(query, id, student, visit, date, id);
        dbConfig.update(query);
    }

    @Override
    public void delete() {
        String query = "delete from public.\"" + this.getClass().getName() +"\" where id = " + getId();
        dbConfig.delete(query);
    }

    @Override
    public List<Visit> read(String query) {
        ArrayList<Visit> visits = new ArrayList<Visit>();
        List<Map<String, Object>> resultList = dbConfig.query(query);
        for(Integer i=0;i<resultList.size();i++){
            Integer id = (Integer) resultList.get(i).get("id");
            Integer student = (Integer) resultList.get(i).get("student_id");
            Boolean visit = (Boolean) resultList.get(i).get("visit");
            Date date = (Date) resultList.get(i).get("date");
            visits.add((new Visit(id, student, visit, date)));
        }
        return visits;
    }
}
