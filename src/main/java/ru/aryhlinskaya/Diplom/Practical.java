package ru.aryhlinskaya.Diplom;

import java.util.ArrayList;
import java.util.List;

public class Practical extends Items implements ActionWithDB<Practical>{
    Integer teacher;
    ArrayList<Rating> ratings;
    ArrayList<Visit> visits;

    public Practical() {
    }

    public Practical(Integer id, String name, Integer teacher, ArrayList<Rating> ratings, ArrayList<Visit> visits) {
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
        return "Practical{" +
                "teacher=" + teacher +
                ", ratings=" + ratings +
                ", visits=" + visits +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
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
    public List<Practical> read(String query) {
        return null;
    }
}
