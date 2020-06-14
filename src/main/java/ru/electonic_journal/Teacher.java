package ru.electonic_journal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Teacher extends User implements ActionWithDB<Teacher>{
    String department;
    ArrayList<Integer> items;
    public Teacher(){

    }

    public Teacher(Integer id, String name, String password, String email, String phone, String department, ArrayList<Integer> items) {
        super(id, name, password, email, phone);
        this.department = department;
        this.items = items;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<Integer> getItems() {
        return items;
    }

    public void setItems(ArrayList<Integer> items) {
        this.items = items;
    }

    public String toString(){
        return "{\"id\": " + getId() + " ,\"name\":\"" + getName() + "\" ,\"password\":\"" + getPassword() +
                "\",\"email\":\"" + getEmail() + "\" ,\"phone\":\"" + getPhone() + "\" ,\"department\": \"" + getDepartment() +
                "\",\"groups\":" + getItems() +"}";
    }

    @Override
    public void create() {
        String query = "insert into public.\"" + this.getClass().getName() +
                "\" (id, name, password, email, phone, department, items) " +
                "(%d, %s, %s, %s, %s, %s, %s)";
        String items = "{";
        for(int i = 0; i < this.items.size() - 1; i++)
            items += this.items.get(i) + ',';
        items += this.items.get(this.items.size()-1) + "}";
        query = String.format(query, id,name,password,email,phone, department, items);
        System.out.println(query);
        dbConfig.update(query);
    }

    @Override
    public void update() {
        String query = "update set UPDATE public.\"" + this.getClass().getName() +
                "\"SET id=%d, name=%s, email=%s, phone=%s, password=%s, department=%s, items=%s " +
                "WHERE id = %d;";
        String items = "{";
        for(int i = 0; i < this.items.size() - 1; i++)
            items += this.items.get(i) + ',';
        query = String.format(query, id,name,email,phone, password, department, items, id);
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
            ArrayList<Integer> items = stringToArray((String) resultList.get(i).get("items"));
            teachers.add((new Teacher(id, name, password, email, phone, department, items)));
        }
        return teachers;
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
