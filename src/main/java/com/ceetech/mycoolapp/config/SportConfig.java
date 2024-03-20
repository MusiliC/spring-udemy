package com.ceetech.mycoolapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceetech.mycoolapp.Coach;
import com.ceetech.mycoolapp.SwimCoach;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
