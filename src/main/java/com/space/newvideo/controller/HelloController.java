package com.space.newvideo.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(String name, @RequestParam(defaultValue = "12") int age) {
        return "hello " + name + "is" + age;
    }

    @RequestMapping("/hello/{name}/{age}")
    public String sayHello2(@PathVariable String name, @PathVariable int age) {
        return "hi "+name+"is "+age;
    }
}
