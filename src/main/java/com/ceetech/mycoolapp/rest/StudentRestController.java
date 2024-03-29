package com.ceetech.mycoolapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceetech.mycoolapp.entity.Student;
import com.ceetech.mycoolapp.exceptions.StudentNotFoundException;
import com.ceetech.mycoolapp.util.StudentErrorResponse;

@RestController
@RequestMapping("api")
public class StudentRestController {

    List<Student> theStudents;

    @PostMapping
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student(1, "Brian", "Musili"));
        theStudents.add(new Student(2, "Ian", "Mayani"));
        theStudents.add(new Student(3, "Jose", "Kim"));

    }

    @GetMapping("students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("students/{studentId}")
    public Student oneStudent(@PathVariable int studentId) {

        // check id

        if (studentId > theStudents.size() || studentId <= 0) {
            throw new StudentNotFoundException("Student with id " + studentId + " not found");
        }

        return theStudents.get(studentId);
    }

    // add exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        StudentErrorResponse errorResponse = new StudentErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
