package ru.aryhlinskaya.Diplom;

import java.util.ArrayList;

public class Lecture extends Object{
    Integer teacher;
    ArrayList<Rating> ratings;
    ArrayList<Visit> visits;

    public Lecture() {
    }

    public Lecture(Integer id, String name, Integer teacher, ArrayList<Rating> ratings, ArrayList<Visit> visits) {
        super(id, name);
        this.teacher = teacher;
        this.ratings = ratings;
        this.visits = visits;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    public ArrayList<Visit> getVisits() {
        return visits;
    }

    public void setVisits(ArrayList<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "{" +
                "\"teacher\":" + teacher +
                ", \"ratings\":" + ratings +
                ", \"visits\":" + visits +
                ", \"id\":" + id +
                ", \"name\":\'" + name + '\'' +
                '}';
    }
}
