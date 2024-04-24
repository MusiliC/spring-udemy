package com.ceetech.mycoolapp.service.impl;

import com.ceetech.mycoolapp.entity.InstructorDetail;
import com.ceetech.mycoolapp.repository.InstructorDetailRepository;
import com.ceetech.mycoolapp.service.InstructorDetailsService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailsService {

    private final InstructorDetailRepository instructorDetailRepository;

    public InstructorDetailServiceImpl(InstructorDetailRepository instructorDetailRepository) {
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @Override
    public Optional<InstructorDetail> findById(Integer id) {

        return Optional.ofNullable(instructorDetailRepository.findById(id).orElse(null));
    }
}
