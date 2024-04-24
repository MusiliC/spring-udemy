package com.ceetech.mycoolapp.service;

import com.ceetech.mycoolapp.entity.Instructor;
import java.util.Optional;

public interface InstructorService {

    Instructor saveInstructor(Instructor instructor);

    Optional<Instructor> findInstructorById(Integer id);
}
