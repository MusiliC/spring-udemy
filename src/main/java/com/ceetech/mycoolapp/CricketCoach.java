package com.ceetech.mycoolapp;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Doing workout";
    }
    
}
