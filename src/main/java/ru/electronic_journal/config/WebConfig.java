package ru.electronic_journal.config;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.electronic_journal.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class WebConfig {
    DBConfig dbConfig = new DBConfig();
    @GetMapping(value = "/student", produces = "application/json")
    public String getStudent(){
        String query = "select * from public.\"Student\" ";//where email = $s and password = %s";
        //query = String.format(query, student.getEmail(), student.getPassword());
        Student student = new Student();
        List<Student> students = student.read(query);
        String str = "";
        if (students.size() > 0) {
            for (Integer i = 0; i < students.size() - 1; i++) {
                str += students.get(i).toString() + ",";
            }
            str += students.get(students.size() - 1);
            return "{\"student\": [ " + str + "]}";
        }
        return "{\"student\":[]}";
    }
    @GetMapping(value = "/student/items", produces = "application/json")
    public String getItems(/*@RequestParam String name*/){
        String query = "Select distinct name from public.\"Items\" where id = ANY((select items from public.\"Group\" where name =\'a\')::INT[])";
        String nameItems = "{\"items\":[";
        List<Map<String, Object>> resultList = dbConfig.query(query);
        for(Integer i=0;i<resultList.size() - 1;i++){
            nameItems += "\"" + (String) resultList.get(i).get("name") + "\",";
        }
        nameItems += "\"" + (String) resultList.get(resultList.size()-1).get("name") + "\"]}";
        return nameItems;
    }

}
