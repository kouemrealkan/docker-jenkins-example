package com.alkan.docker_example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    @GetMapping("/home")
    public String home() {
        return "Hello From Docker Demo App :)";
    }

    @GetMapping("/test")
    public String test() {
        return "Test";
    }
}
