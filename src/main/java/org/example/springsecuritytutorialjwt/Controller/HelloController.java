package org.example.springsecuritytutorialjwt.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/test")
    public String helloWorld() {
        return "hello";
    }
}
