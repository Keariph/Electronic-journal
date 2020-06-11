package ru.aryhlinskaya.Diplom.config;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aryhlinskaya.Diplom.Student;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class WebConfig {
    @GetMapping(value = "/")
    public String HelloWorld() {
        return "Hello, world!";
    }

    @GetMapping(value = "/student", produces = "application/json")
    public String getStudent(Student student){
        String query = "select * from public.\"Student\" where email = $s and password = %s";
        query = String.format(query, student.getEmail(), student.getPassword());
        List<Student> students = student.read(query);
        String str = "";
        if (students.size() > 0) {
            for (Integer i = 0; i < students.size() - 1; i++) {
                str += students.get(i).toString() + ",";
            }
            str += students.get(students.size() - 1);
            return "{\"student\": [ " + str + "]}";
        }
        return "{\"student\";[]}";
    }
}
