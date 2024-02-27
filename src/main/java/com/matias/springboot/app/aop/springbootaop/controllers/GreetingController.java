package com.matias.springboot.app.aop.springbootaop.controllers;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class GreetingController {

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting(){
    
        return ResponseEntity.ok(Collections.singletonMap("greeting", null));
    }
 
}
