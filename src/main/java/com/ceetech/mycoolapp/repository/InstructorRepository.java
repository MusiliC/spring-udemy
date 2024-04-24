package com.ceetech.mycoolapp.repository;

import com.ceetech.mycoolapp.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
