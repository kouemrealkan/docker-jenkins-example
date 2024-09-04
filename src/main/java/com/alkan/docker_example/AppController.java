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

    @GetMapping("/test2")
    public String test2() {
        return "Test2";
    }

    @GetMapping("/test3")
    public String test3() {
        return "Test3";
    }

    @GetMapping("/test4")
    public String test4() {
        return "Test4";
    }
}
