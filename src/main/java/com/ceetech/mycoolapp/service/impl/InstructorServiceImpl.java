package com.ceetech.mycoolapp.service.impl;

import com.ceetech.mycoolapp.entity.Instructor;
import com.ceetech.mycoolapp.repository.InstructorRepository;
import com.ceetech.mycoolapp.service.InstructorService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service

public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return  instructorRepository.save(instructor);
    }

    @Override
    public Optional<Instructor> findInstructorById(Integer id) {
        return Optional.ofNullable(instructorRepository.findById(id).orElse(null));
    }
}
