package com.example.laba1;
import com.example.laba1.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logic {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    int result;
    Hash map = new Hash();
    public int getFibonacciNumber (int value)
    {
        int mas[] = new int[100];
        mas[0] = 0;
        mas[1] = 1;
        if (value > 1)
            for (int i = 2; i < 100; i++){
                mas[i] = mas[i - 1] + mas[i - 2];
                if (value == i)
                    break;
            }
        result = mas[value];
        map.addToMap(value, result);
        LOGGER.info("Response: index in sequence: " + result);
        return result;
    }
}
