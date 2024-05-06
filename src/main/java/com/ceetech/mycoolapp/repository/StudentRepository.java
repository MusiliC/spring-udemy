package com.ceetech.mycoolapp.repository;


import com.ceetech.mycoolapp.entity.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s join fetch s.courses where s.id = :id")
    List<Student> findByStudentAndCourseByStudentId(@Param("id") Integer id);

    @Query("SELECT s FROM Student s join fetch s.courses where s.id = :id")
    Student findByStudentById(@Param("id") Integer id);
}
