package com.ceetech.mycoolapp.service;

import com.ceetech.mycoolapp.entity.Course;
import java.util.List;


public interface CourseService {

    List<Course> findByCourseByInstructorId(Integer id);

    void save(Course course);

    Course findById(Integer id);
}
