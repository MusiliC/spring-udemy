package com.ceetech.mycoolapp;

import com.ceetech.mycoolapp.entity.Course;
import com.ceetech.mycoolapp.entity.Instructor;
import com.ceetech.mycoolapp.entity.InstructorDetail;
import com.ceetech.mycoolapp.service.CourseService;
import com.ceetech.mycoolapp.service.InstructorDetailsService;
import com.ceetech.mycoolapp.service.InstructorService;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.Builder;

@SpringBootApplication

public class MycoolappApplication {
    public static void main(String[] args) {
        SpringApplication.run(MycoolappApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(InstructorService instructorService) {
//        return runner -> {
//            //createInstructor(instructorService);
//            getInstructorById(instructorService);
//        };
//    }

//    @Bean
//    public CommandLineRunner commandLineRunner(InstructorService instructorService) {
//        return runner -> {
//           // createInstructorWithCourse(instructorService);
//           // retrieveInstructorWithCourses(instructorService);
//        };
//    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorService instructorService,CourseService courseService) {
        return runner -> {
            findCoursesForInstructor(instructorService,courseService);
        };
    }

    private void findCoursesForInstructor(InstructorService instructorService,CourseService courseService) {
      Instructor instructor = retrieveInstructorWithCourses(instructorService);

      List<Course> courses = courseService.findByCourseByInstructorId(instructor.getId());

        System.out.println("Found " + courses.size() + " courses");
        System.out.println(courses.size());

    }


    private Instructor retrieveInstructorWithCourses(InstructorService instructorService) {

        Integer id = 1;
       Optional<Instructor> instructor = instructorService.findInstructorById(id);

       // System.out.println(instructorById.get());
        System.out.println("Instructor with courses found: " + instructor.get().getFirstName());

        return instructor.get();


    }

//    private void createInstructorWithCourse(InstructorService instructorService) {
//        Instructor instructor = Instructor.builder().firstName("Cee").lastName("dev").email("cee@gmail.com").build();
//
//        InstructorDetail instructorDetail = InstructorDetail.builder().youtubeChannel("ceecode").hobby("spring").build();
//
//        instructor.setInstructorDetail(instructorDetail);
//
//        System.out.println("::::::::::Instructor creating::::::::::");
//
//        //create some courses
//        Course course = new Course("Data mapping - spring");
//        Course course2 = new Course("JPA mapping - jakarta");
//
//        //add courses to instructor
//
//        instructor.add(course);
//        instructor.add(course2);
//
//        instructorService.saveInstructor(instructor);
//
//        System.out.println("::::::::::Instructor created::::::::::");
//
//    }

//    @Bean
//    public CommandLineRunner commandLineRunner(InstructorDetailsService instructorService) {
//        return runner -> {
//            // createInstructor(instructorService);
//           getInstructorDetailById(instructorService);
//        };
//    }

//    private void getInstructorDetailById(InstructorDetailsService instructorDetailsService) {
//        Integer id = 1;
//        Optional<InstructorDetail> instructorById = instructorDetailsService.findById(id);
//
//        System.out.println("InstructorDetail found: " + instructorById.get().getHobby());
//
//        System.out.println("Associated instructor found: " + instructorById.get().getInstructor().getFirstName());
//    }

//    private void getInstructorById(InstructorService instructorService) {
//        Integer id = 1;
//        Optional<Instructor> instructorById = instructorService.findInstructorById(id);
//
//        System.out.println("Instructor found: " + instructorById.get().getFirstName());
//
//        //System.out.println("Associated instructor details found: " + instructorById.get().getInstructorDetail());
//    }

//    private void createInstructor(InstructorService instructorService) {
//
//        Instructor instructor = Instructor.builder().firstName("Cee").lastName("dev").email("cee@gmail.com").build();
//
//        InstructorDetail instructorDetail = InstructorDetail.builder().youtubeChannel("ceecode").hobby("spring").build();
//
//        instructor.setInstructorDetail(instructorDetail);
//
//        System.out.println("::::::::::Instructor creating::::::::::");
//
//        instructorService.saveInstructor(instructor);
//
//        System.out.println("::::::::::Instructor created::::::::::");
//
//    }


}
