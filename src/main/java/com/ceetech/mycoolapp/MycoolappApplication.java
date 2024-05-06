package com.ceetech.mycoolapp;

import com.ceetech.mycoolapp.entity.Course;
import com.ceetech.mycoolapp.entity.Instructor;
import com.ceetech.mycoolapp.entity.InstructorDetail;
import com.ceetech.mycoolapp.entity.Review;
import com.ceetech.mycoolapp.entity.Student;
import com.ceetech.mycoolapp.service.CourseService;
import com.ceetech.mycoolapp.service.InstructorDetailsService;
import com.ceetech.mycoolapp.service.InstructorService;
import com.ceetech.mycoolapp.service.StudentService;
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
//           // getInstructorById(instructorService);
//            findInstructorWithCourseJoinFetch(instructorService);
//        };
//    }

    //    @Bean
//    public CommandLineRunner commandLineRunner(InstructorService instructorService) {
//        return runner -> {
//           // createInstructorWithCourse(instructorService);
//           // retrieveInstructorWithCourses(instructorService);
//        };
//    }

//    @Bean
//    public CommandLineRunner commandLineRunner(InstructorService instructorService,CourseService courseService) {
//        return runner -> {
//            findCoursesForInstructor(instructorService,courseService);
//        };
//    }


//
//    @Bean
//    public CommandLineRunner commandLineRunner(CourseService courseService) {
//        return runner -> {
//           // createCourseAndReviews(courseService);
//            findCourseJoinFetch(courseService);
//        };
//    }

    @Bean
    public CommandLineRunner commandLineRunner(CourseService courseService, StudentService studentService) {
        return runner -> {
            //  createCourseAndStudents(courseService,studentService);
            //findCourseJoinStudent(courseService, studentService);
           // findStudentJoinCourse(studentService, courseService);
            updateStudent(studentService, courseService);
        };
    }

    private void findStudentJoinCourse(StudentService studentService, CourseService courseService) {
        Integer studentId = 1;

        List<Student> students = studentService.findStudentAndCourseByStudentId(studentId);

        students.stream().map(student -> {
            String fullName = student.getFirstName() + " " + student.getLastName() + " " + student.getId();
            return  fullName;
        }).forEach(student -> {});
    }

    private void findCourseJoinStudent(CourseService courseService, StudentService studentService) {
        Integer courseId = 10;
        Course course = courseService.findCourseAndStudentById(courseId);

        System.out.println("Loaded course " + course.getTitle());

        System.out.println("Associated students");

        System.out.println("Student names:");
        course.getStudents().stream().map(student -> {
            String fullName = student.getFirstName() + " " + student.getLastName();
            System.out.println(fullName); // Print the full name
            return fullName; // Return the full name to be further processed if needed
        }).forEach(fullName -> {
        }); // Terminal operation, needed to trigger stream processing
    }

    private  void  updateStudent(StudentService studentService, CourseService courseService) {
        Course tempCourse2 = Course.builder().title("Course2").build();
        Course tempCourse3 = Course.builder().title("Course3").build();

        //findStudent and add more courses
        Integer studentId = 1;
        Student studentWithId1 = studentService.findStudentById(studentId);
        studentWithId1.addCourse(tempCourse2);
        studentWithId1.addCourse(tempCourse3);
    }

    private void createCourseAndStudents(CourseService courseService, StudentService studentService) {
        //create course
        Course tempCourse = Course.builder().title("Many to many").build();




        //create student

        Student tempStudent = Student.builder().firstName("Elijah").lastName("Kamotho").email("eli@gmail.com").build();
        Student tempStudentTwo = Student.builder().firstName("Dun").lastName("Omo").email("dun@gmail.com").build();



        //add student to course

        tempCourse.addStudent(tempStudent);
        tempCourse.addStudent(tempStudentTwo);

        //save course and associated student

        System.out.println("Saving course " + tempCourse);
        courseService.save(tempCourse);
        System.out.println("Both students saved");
    }

//    private void createCourseAndReviews(CourseService courseService) {
//        Course course = Course.builder().title("Mapping course").build();
//
//        Review review = Review.builder().comment("TRicky advisable course").build();
//        Review reviewTwo = Review.builder().comment("Only two reviews").build();
//
//        course.addReview(review);
//        course.addReview(reviewTwo);
//
//        System.out.println("Saving course");
//        courseService.save(course);
//        System.out.println("Saved course");
//    }


//    private void findInstructorWithCourseJoinFetch(InstructorService instructorService) {
//        Integer id = 1;
//        Instructor instructorById = instructorService.findInstructorByFetchJoin(id);
//
//        System.out.println("Instructor found: " + instructorById.getFirstName() + " " + instructorById.getLastName());
//        System.out.println("All courses: " + instructorById.getCourses().size());
//
//    }

    private void findCourseJoinFetch(CourseService courseService) {
        Integer id = 10;
        Course course = courseService.findById(id);

        System.out.println("Course found: " + course.getTitle());
        System.out.println("All reviews: " + course.getReviews());

    }


    private void findCoursesForInstructor(InstructorService instructorService, CourseService courseService) {
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
