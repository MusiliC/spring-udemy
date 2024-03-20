package com.ceetech.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceetech.mycoolapp.Coach;
import com.ceetech.mycoolapp.Player;

@RestController
public class FunRestController {

    @Value("${dev.name}")
    private String devName;

    private Coach myCoach;
    private Player player;

    @Autowired
    public FunRestController(@Qualifier("swimCoach") Coach myCoach) {
        this.myCoach = myCoach;
    }


    // setter injection
    @Autowired
    public void setPlayer(Player player) {
        this.player = player;
    }



    @GetMapping("/")
    public String sayHello() {
        return "Hello world, its me again " + devName;
    }

    @GetMapping("/java")
    public String softwareDev() {
        //setter injection
        //return player.positionOfPlay();
        //constructor injection
         return myCoach.getDailyWorkout();
    }
}
