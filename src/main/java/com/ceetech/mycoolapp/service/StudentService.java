package com.ceetech.mycoolapp.service;


import com.ceetech.mycoolapp.entity.Student;
import java.util.List;

public interface StudentService {
    List<Student> findStudentAndCourseByStudentId(Integer id);

    void save(Student student);

    Student findStudentById(Integer id);


}
