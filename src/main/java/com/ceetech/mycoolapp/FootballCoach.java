package com.ceetech.mycoolapp;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Pep Guardiola Man city coach";
    }

}
