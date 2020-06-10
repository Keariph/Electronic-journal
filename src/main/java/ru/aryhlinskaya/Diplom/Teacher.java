package ru.aryhlinskaya.Diplom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Teacher extends User implements ActionWithDB<Teacher>{
    String department;
    ArrayList<Integer> groups;
    public Teacher(){

    }

    public Teacher(Integer id, String name, String password, String email, String phone, String department, ArrayList<Integer> groups) {
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

    public ArrayList<Integer> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Integer> groups) {
        this.groups = groups;
    }

    public String toString(){
        return "{\"id\": " + getId() + " ,\"name\":\"" + getName() + "\" ,\"password\":\"" + getPassword() +
                "\",\"email\":\"" + getEmail() + "\" ,\"phone\":\"" + getPhone() + "\" ,\"department\": \"" + getDepartment() +
                "\",\"groups\":" + getGroups() +"}";
    }

    @Override
    public void create() {
        String query = "insert into public.\"" + this.getClass().getName() +
                "\" (id, name, password, email, phone, department, groups) " +
                "(%d, %s, %s, %s, %s, %s, %s)";
        String groups = "{";
        for(int i = 0; i < this.groups.size() - 1; i++)
            groups += this.groups.get(i) + ',';
        groups += this.groups.get(this.groups.size()-1) + "}";
        query = String.format(query, id,name,password,email,phone, department, groups);
        System.out.println(query);
        dbConfig.update(query);
    }

    @Override
    public void update() {
        String query = "update set UPDATE public.\"" + this.getClass().getName() +
                "\"SET id=%d, name=%s, email=%s, phone=%s, password=%s, department=%s, groups=%s " +
                "WHERE id = %d;";
        String groups = "{";
        for(int i = 0; i < this.groups.size() - 1; i++)
            groups += this.groups.get(i) + ',';
        query = String.format(query, id,name,email,phone, password, department, groups, id);
        dbConfig.update(query);
    }

    @Override
    public void delete() {
        String query = "delete from public.\"" + this.getClass().getName() +"\" where id = " + getId();
        dbConfig.delete(query);
    }

    @Override
    public List<Teacher> read(String query) {
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        List<Map<String, Object>> resultList = dbConfig.query(query);
        for(Integer i=0;i<resultList.size();i++){
            Integer id = (Integer) resultList.get(i).get("id");
            String name = (String) resultList.get(i).get("name");
            String password = (String) resultList.get(i).get("password");
            String email = (String) resultList.get(i).get("email");
            String phone = (String) resultList.get(i).get("phone");
            String department = (String) resultList.get(i).get("department");
            ArrayList<Integer> groups = (ArrayList<Integer>) resultList.get(i).get("groups");
            teachers.add((new Teacher(id, name, password, email, phone, department, groups)));
        }
        return teachers;
    }
}
