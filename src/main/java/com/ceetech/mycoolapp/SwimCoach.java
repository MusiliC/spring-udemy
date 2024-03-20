package com.ceetech.mycoolapp;


public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    };

    @Override
    public String getDailyWorkout() {
        return "Always remember deep diving";
    }

}
