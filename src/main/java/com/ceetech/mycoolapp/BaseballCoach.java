package com.ceetech.mycoolapp;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Indians game - Base ball coach";
    }

}
