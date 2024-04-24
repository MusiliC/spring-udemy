package com.ceetech.mycoolapp.service;

import com.ceetech.mycoolapp.entity.InstructorDetail;
import java.util.Optional;

public interface InstructorDetailsService {
    Optional<InstructorDetail> findById(Integer id);
}
