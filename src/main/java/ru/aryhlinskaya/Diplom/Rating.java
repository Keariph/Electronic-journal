package ru.aryhlinskaya.Diplom;

import java.util.Date;
import java.util.List;

public class Rating implements ActionWithDB<Rating>{
    Integer id;
    Integer student;
    Integer rating;
    Date date;

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

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public List<Rating> read(String query) {
        return null;
    }
}
