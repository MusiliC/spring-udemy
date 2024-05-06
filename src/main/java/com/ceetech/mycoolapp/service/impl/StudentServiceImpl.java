package com.ceetech.mycoolapp.service.impl;

import com.ceetech.mycoolapp.entity.Student;
import com.ceetech.mycoolapp.repository.StudentRepository;
import com.ceetech.mycoolapp.service.StudentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private  final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findStudentAndCourseByStudentId(Integer id) {
  return  studentRepository.findByStudentAndCourseByStudentId(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findStudentById(Integer id) {
        return  studentRepository.findByStudentById(id);
    }
}
