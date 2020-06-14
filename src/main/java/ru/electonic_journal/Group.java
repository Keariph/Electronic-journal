package ru.electonic_journal;

import org.springframework.beans.factory.annotation.Autowired;
import ru.aryhlinskaya.Diplom.config.DBConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Group implements ActionWithDB<Group>{
    int id;
    String name;
    ArrayList<Integer> students;
    ArrayList<Integer> items;
    @Autowired
    DBConfig dbConfig;
    public Group(){

    }

    public Group(int id, String name, ArrayList<Integer> students, ArrayList<Integer> items) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.items = items;
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
        return items;
    }

    public void setObjects(ArrayList<Integer> items) {
        this.items = items;
    }

    public String toString()
    {
        return "{\"id\":" + getId() + ", \"name\":\"" + getName() +
                "\", \"students\":" + getStudents() + ", \"objects\":" + getObjects() + "}";
    }

    @Override
    public void create() {
        String query = "insert into public.\"" + this.getClass().getName() +
                "\" (id, name, students, items) " + "(%d, %s, %s, %s)";
        String students = "{", items = "{";
        for(int i = 0; i < this.students.size()-1; i++)
        {
            students += this.students.get(i) + ",";
        }
        students += this.students.get(this.students.size() - 1) + "}";
        for(int i = 0; i < this.items.size()-1; i++)
        {
            items += this.items.get(i) + ",";
        }
        items += this.items.get(this.items.size() - 1) + "}";
        query = String.format(query, id, name, students, items);
        System.out.println(query);
        dbConfig.update(query);
    }

    @Override
    public void update() {
        String query = "update set UPDATE public.\"" + this.getClass().getName() +
                "\"SET id=%d, name=%s, students=%s, items=%s " +
                "WHERE id = %d;";
        String students = "{", items = "{";
        for(int i = 0; i < this.students.size()-1; i++)
        {
            students += this.students.get(i) + ",";
        }
        students += this.students.get(this.students.size() - 1) + "}";
        for(int i = 0; i < this.items.size()-1; i++)
        {
            items += this.items.get(i) + ",";
        }
        items += this.items.get(this.items.size() - 1) + "}";
        query = String.format(query, id, name, students, items);
        dbConfig.update(query);
    }

    @Override
    public void delete() {
        String query = "delete from public.\"" + this.getClass().getName() +"\" where id = " + getId();
        dbConfig.delete(query);
    }

    @Override
    public List<Group> read(String query) {
        ArrayList<Group> groups = new ArrayList<Group>();
        List<Map<String, Object>> resultList = dbConfig.query(query);
        for(Integer i=0;i<resultList.size();i++){
            Integer id = (Integer) resultList.get(i).get("id");
            String name = (String) resultList.get(i).get("name");
            ArrayList<Integer> students = stringToArray((String) resultList.get(i).get("students"));
            ArrayList<Integer> items = stringToArray((String) resultList.get(i).get("items"));
            groups.add((new Group(id,name, students, items)));
        }
        return groups;
    }

    private ArrayList<Integer> stringToArray(String list){
        list = list.replace("{}", "");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        String[] arrey = list.split(",");
        for(int i = 0; i < arrey.length; i++){
            arrayList.add(Integer.parseInt(arrey[i]));
        }
        return arrayList;
    }
}
