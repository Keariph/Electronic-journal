package ru.electronic_journal;

import org.springframework.stereotype.Component;
import ru.aryhlinskaya.Diplom.config.DBConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Student extends User implements ActionWithDB<Student>{
    Integer course;
    String faculty;

    public Student() {
    }

    public Student(Integer id, String name, String password, String email, String phone, Integer course, String faculty) {
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

    @Override
    public void create() {
        String query = "insert into public.\"" + Student.class.getName() +
                "\" (id, name, password, email, phone, course, faculty) " +
                "(%d, \"%s\", \"%s\", \"%s\", \"%s\", %d, \"%s\")";
        query = String.format(query, id,name,password,email,phone, course, faculty);
        System.out.println(query);
        dbConfig.update(query);
    }

    @Override
    public void update() {
        String query = "update set UPDATE public.\"" + this.getClass().getName() +
                "\"SET id=%d, name=%s, email=%s, phone=%s, password=%s, course=%d, faculty=%s " +
                "WHERE id = %d;";
        query = String.format(query, id,name,email,phone, password, course, faculty, id);
        dbConfig.update(query);
    }

    @Override
    public void delete() {
        String query = "delete from public.\"Student\" where id = " + getId();
        dbConfig.delete(query);
    }

    @Override
    public List<Student> read(String query) {
        ArrayList<Student> students = new ArrayList<Student>();
        List<Map<String, Object>> resultList = dbConfig.query(query);
        for(Integer i=0;i<resultList.size();i++){
            Integer id = (Integer) resultList.get(i).get("id");
            String name = (String) resultList.get(i).get("name");
            String password = (String) resultList.get(i).get("password");
            String email = (String) resultList.get(i).get("email");
            String phone = (String) resultList.get(i).get("phone");
            Integer course = (Integer) resultList.get(i).get("course");
            String faculty = (String) resultList.get(i).get("faculty");
            students.add((new Student(id, name, password, email, phone, course, faculty)));
        }
        return students;
    }

}
