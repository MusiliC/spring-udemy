package com.ceetech.mycoolapp.repository;

import com.ceetech.mycoolapp.entity.Course;
import com.ceetech.mycoolapp.entity.Instructor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface InstructorRepository extends JpaRepository<Instructor, Integer> {


    @Query("SELECT i FROM Instructor i join fetch i.courses join fetch i.instructorDetail  where i.id = :id")
    Instructor findInstructorByFetchJoin(@Param("id") Integer id);

}
