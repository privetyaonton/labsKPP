package com.example.laba1.controller;
import com.example.laba1.fibonacci.Fibonacci;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/hello")
    Fibonacci output (@RequestParam(value = "num", defaultValue = "0")int num) {
        if (num == 0)
            return new Fibonacci(0);
        if (num == 1 || num == 2)
            return new Fibonacci(1);
        int mas[];
        mas = new int [100];
        mas[0] = 0;
        mas[1] = 1;
        for (int i = 2; i <= num; i++) {
            mas[i] = mas[i - 1] + mas[i - 2];
        }
        return new Fibonacci(mas[num]);
    }
}
