package ru.aryhlinskaya.Diplom;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Document(collection = "Teachers")
public class Teacher extends User{
    String department;
    ArrayList<Group> groups;
    public Teacher(){

    }

    public Teacher(Integer id, String name, String password, String email, String phone, String department, ArrayList<Group> groups) {
        super(id, name, password, email, phone);
        this.department = department;
        this.groups = groups;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public String toString(){
        return "{\"id\": " + getId() + " ,\"name\":\"" + getName() + "\" ,\"password\":\"" + getPassword() +
                "\",\"email\":\"" + getEmail() + "\" ,\"phone\":\"" + getPhone() + "\" ,\"department\": \"" + getDepartment() +
                "\",\"groups\":" + getGroups() +"}";
    }
}
