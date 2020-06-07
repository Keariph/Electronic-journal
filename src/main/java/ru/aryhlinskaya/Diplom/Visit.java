package ru.aryhlinskaya.Diplom;

import java.util.Date;

public class Visit {
    Integer id;
    Integer student;
    Boolean visit;
    Date date;

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
}
