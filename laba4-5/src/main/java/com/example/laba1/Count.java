package com.example.laba1;


import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class Count {
    private static final Logger LOGGER = LoggerFactory.getLogger(Count.class);
    static private int temp = 0;
    synchronized public void incrementTemp ()
    {
        temp++;
        LOGGER.info ("increment counter");
    }
    @GetMapping ("/countprint")
    synchronized public int getTemp ()
    {
        LOGGER.info("New count: " + temp);
        return temp;
    }
}
