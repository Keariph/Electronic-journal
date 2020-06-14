package ru.electronic_journal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        String query = "insert into public.\"" + this.getClass().getName() +
                "\" (id, name, teacher_id, ratings, visits) " + "(%d, %s, %d, %s, %s)";
        String ratings = "{", visits = "{";
        for(int i = 0; i < this.ratings.size()-1; i++)
        {
            ratings += this.ratings.get(i) + ",";
        }
        ratings += this.ratings.get(this.ratings.size() - 1) + "}";
        for(int i = 0; i < this.visits.size()-1; i++)
        {
            visits += this.visits.get(i) + ",";
        }
        visits += this.visits.get(this.visits.size() - 1) + "}";
        query = String.format(query, id, name, teacher, ratings, visits);
        System.out.println(query);
        dbConfig.update(query);
    }

    @Override
    public void update() {
        String query = "update set UPDATE public.\"" + this.getClass().getName() +
                "\"SET id=%d, name=%s, teacher_id=%d, ratings=%s, visit=%s " +
                "WHERE id = %d;";
        String ratings = "{", visits = "{";
        for(int i = 0; i < this.ratings.size()-1; i++)
        {
            ratings += this.ratings.get(i) + ",";
        }
        ratings += this.ratings.get(this.ratings.size() - 1) + "}";
        for(int i = 0; i < this.visits.size()-1; i++)
        {
            visits += this.visits.get(i) + ",";
        }
        visits += this.visits.get(this.visits.size() - 1) + "}";
        query = String.format(query, id, name, teacher, ratings,visits);
        dbConfig.update(query);
    }

    @Override
    public void delete() {
        String query = "delete from public.\"" + this.getClass().getName() +"\" where id = " + getId();
        dbConfig.delete(query);
    }

    @Override
    public List<Lecture> read(String query) {
        ArrayList<Lecture> lectures = new ArrayList<Lecture>();
        List<Map<String, Object>> resultList = dbConfig.query(query);
        for(Integer i=0;i<resultList.size();i++){
            Integer id = (Integer) resultList.get(i).get("id");
            String name = (String) resultList.get(i).get("name");
            Integer teacher = (Integer) resultList.get(i).get("teacher_id");
            ArrayList<Integer> ratings = stringToArray((String) resultList.get(i).get("ratings"));
            ArrayList<Integer> visits = stringToArray((String) resultList.get(i).get("visits"));
            lectures.add((new Lecture(id,name, teacher, ratings,visits)));
        }
        return lectures;
    }
}