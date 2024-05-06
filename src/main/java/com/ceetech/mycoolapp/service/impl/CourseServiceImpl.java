package com.ceetech.mycoolapp.service.impl;

import com.ceetech.mycoolapp.entity.Course;
import com.ceetech.mycoolapp.repository.CourseRepository;
import com.ceetech.mycoolapp.service.CourseService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findByCourseByInstructorId(Integer id) {
        return courseRepository.findByCourseByInstructorId(id);
    }

    @Override
    public void save(Course course) {
    courseRepository.save(course);
    }

    @Override
    public Course findById(Integer id) {
       return courseRepository.findCourseByFetchJoin(id);
    }

    @Override
    public Course findCourseAndStudentById(Integer id) {
        return courseRepository.findByCourseAndStudentByCourseId(id);
    }
}
