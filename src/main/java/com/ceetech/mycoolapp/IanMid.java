package com.ceetech.mycoolapp;

import org.springframework.stereotype.Component;

@Component
public class IanMid implements Player {

    @Override
    public String positionOfPlay() {
      return "Midfield maestro number 6";
    }
    
}
