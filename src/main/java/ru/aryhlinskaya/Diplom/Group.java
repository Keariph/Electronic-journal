package ru.aryhlinskaya.Diplom;

import java.util.ArrayList;
import java.util.List;

public class Group implements ActionWithDB<Group>{
    int id;
    String name;
    ArrayList<Integer> students;
    ArrayList<Integer> objects;

    public Group(){

    }

    public Group(int id, String name, ArrayList<Integer> students, ArrayList<Integer> objects) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.objects = objects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Integer> students) {
        this.students = students;
    }

    public ArrayList<Integer> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<Integer> objects) {
        this.objects = objects;
    }

    public String toString()
    {
        return "{\"id\":" + getId() + ", \"name\":\"" + getName() +
                "\", \"students\":" + getStudents() + ", \"objects\":" + getObjects() + "}";
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
    public List<Group> read(String query) {
        return null;
    }
}
