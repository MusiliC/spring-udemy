package com.ceetech.mycoolapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceetech.mycoolapp.entity.Student;

@RestController
@RequestMapping("api")
public class StudentRestController {
    
    @GetMapping("students")
    public List<Student> getStudents(){

        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Brian", "Musili"));
        theStudents.add(new Student("Ian", "Mayani"));
        theStudents.add(new Student("Jose", "Kim"));

        return theStudents;

    }
}
