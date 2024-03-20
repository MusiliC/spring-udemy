package com.ceetech.mycoolapp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //makes this the primary coach 
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Doing workout - cricket coach";
    }
    
}
