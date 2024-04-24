package com.ceetech.mycoolapp;

import com.ceetech.mycoolapp.entity.Instructor;
import com.ceetech.mycoolapp.entity.InstructorDetail;
import com.ceetech.mycoolapp.service.InstructorDetailsService;
import com.ceetech.mycoolapp.service.InstructorService;
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

  //  @Bean
//    public CommandLineRunner commandLineRunner(InstructorService instructorService) {
//        return runner -> {
//           // createInstructor(instructorService);
//            getInstructorById(instructorService);
//        };
//    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorDetailsService instructorService) {
        return runner -> {
            // createInstructor(instructorService);
           getInstructorDetailById(instructorService);
        };
    }

    private void getInstructorDetailById(InstructorDetailsService instructorDetailsService) {
        Integer id = 1;
        Optional<InstructorDetail> instructorById = instructorDetailsService.findById(id);

        System.out.println("InstructorDetail found: " + instructorById.get().getHobby());

        System.out.println("Associated instructor found: " + instructorById.get().getInstructor().getFirstName());
    }

    private void getInstructorById(InstructorService instructorService) {
        Integer id = 1;
        Optional<Instructor> instructorById = instructorService.findInstructorById(id);

        System.out.println("Instructor found: " + instructorById.get().getFirstName());

        //System.out.println("Associated instructor details found: " + instructorById.get().getInstructorDetail());
    }

    private void createInstructor(InstructorService instructorService) {

//        Instructor instructor = Instructor.builder().firstName("Cee").lastName("dev").email("cee@gmail.com").build();
//
//        InstructorDetail instructorDetail = InstructorDetail.builder().youtubeChannel("YY").hobby("Football").build();
//
//        instructor.setInstructorDetail(instructorDetail);

        System.out.println("::::::::::Instructor creating::::::::::");

//        instructorService.saveInstructor(instructor);

        System.out.println("::::::::::Instructor created::::::::::");

    }


}
