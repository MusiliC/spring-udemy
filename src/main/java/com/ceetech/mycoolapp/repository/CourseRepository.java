package com.ceetech.mycoolapp.repository;

import com.ceetech.mycoolapp.entity.Course;
import com.ceetech.mycoolapp.entity.Instructor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Integer> {


    @Query("SELECT c FROM Course c WHERE c.instructor.id = :id")
    List<Course> findByCourseByInstructorId(@Param("id") Integer id);

    @Query("SELECT c FROM Course c join fetch c.reviews where c.id = :id")
    Course findCourseByFetchJoin(@Param("id") Integer id);

}
