package ru.aryhlinskaya.Diplom;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayDeque;

@Document(collection = "Students")
public class Student extends User{
    Integer course;
    String faculty;

    public Student(){

    }

    public Student(Integer id, String name, String password, String email, String phone, Integer course, String department, String faculty) {
        super(id, name, password, email, phone);
        this.course = course;
        this.faculty = faculty;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String toString(){
        return "{\"id\": " + getId() + " ,\"name\":\"" + getName() + "\" ,\"password\":\"" + getPassword() +
                "\",\"email\":\"" + getEmail() + "\" ,\"phone\":\"" + getPhone() + "\" ,\"course\": " + getCourse() +
                "\",\"faculty\":\"" + getFaculty() +"\"}";
    }
}
