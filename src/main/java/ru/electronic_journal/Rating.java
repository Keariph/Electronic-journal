package ru.electronic_journal;

import org.springframework.beans.factory.annotation.Autowired;
import ru.electronic_journal.config.DBConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Rating implements ActionWithDB<Rating>{
    Integer id;
    Integer student;
    Integer rating;
    Date date;
    DBConfig dbConfig;
    public Rating() {
    }

    public Rating(Integer id, Integer student, Integer rating, Date date) {
        this.id = id;
        this.student = student;
        this.rating = rating;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString(){
        return "{\"id\":" + getId() +", \"student\":" + getStudent() +
                ", \"rating\":" + getRating() + ", \"date\":\'" + getDate() + "\'}";
    }

    @Override
    public void create() {
        String query = "insert into public.\"" + this.getClass().getName() +
                "\" (id, student, rating, date) " + "(%d, %s, %d, %s)";
        query = String.format(query, id, student, rating, date);
        System.out.println(query);
        dbConfig.update(query);
    }

    @Override
    public void update() {
        String query = "update set UPDATE public.\"" + this.getClass().getName() +
                "\"SET id=%d, student_id=%d, rating=%d, date=%s" +
                "WHERE id = %d;";
        query = String.format(query, id, student, rating, date, id);
        dbConfig.update(query);
    }

    @Override
    public void delete() {
        String query = "delete from public.\"" + this.getClass().getName() +"\" where id = " + getId();
        dbConfig.delete(query);
    }

    @Override
    public List<Rating> read(String query) {
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        List<Map<String, Object>> resultList = dbConfig.query(query);
        for(Integer i=0;i<resultList.size();i++){
            Integer id = (Integer) resultList.get(i).get("id");
            Integer student = (Integer) resultList.get(i).get("student_id");
            Integer rating = (Integer) resultList.get(i).get("visit");
            Date date = (Date) resultList.get(i).get("date");
            ratings.add((new Rating(id, student, rating, date)));
        }
        return ratings;
    }
}
