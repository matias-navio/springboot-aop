package com.matias.springboot.app.aop.springbootaop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.springboot.app.aop.springbootaop.services.GreetingService;

@RestController
@RequestMapping("/app")
public class GreetingController {

    @Autowired
    private GreetingService gService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting(){
    
        String greeting = gService.sayHello("Matias Navio", "Hola que tal");
        return ResponseEntity.ok(Collections.singletonMap("greeting", greeting));
    }

    @GetMapping("/error")
    public ResponseEntity<?> greetingError(){
    
        String greeting = gService.sayHelloError("Matias Navio", "Hola que tal");
        return ResponseEntity.ok(Collections.singletonMap("greeting", greeting));
    }
 
}
