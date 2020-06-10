package ru.aryhlinskaya.Diplom;

import java.util.ArrayList;
import java.util.List;

public class Lecture extends Items implements ActionWithDB<Lecture>{
    Integer teacher;
    ArrayList<Integer> ratings;
    ArrayList<Integer> visits;

    public Lecture() {
    }

    public Lecture(Integer id, String name, Integer teacher, ArrayList<Integer> ratings, ArrayList<Integer> visits) {
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

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public ArrayList<Integer> getVisits() {
        return visits;
    }

    public void setVisits(ArrayList<Integer> visits) {
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
    public List<Lecture> read(String query) {
        return null;
    }
}
