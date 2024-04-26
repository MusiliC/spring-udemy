package com.ceetech.mycoolapp.repository;

import com.ceetech.mycoolapp.entity.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Integer> {


    @Query("SELECT c FROM Course c WHERE c.instructor.id = :id")
    List<Course> findByCourseByInstructorId(@Param("id") Integer id);

}
