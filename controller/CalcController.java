package ru.neoflex.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/calc")
public class CalcController {

    @GetMapping("/plus/{a}/{b}")
    public ResponseEntity<String> plus(@PathVariable int a, @PathVariable int b) {
        int result = a + b;
        return ResponseEntity.ok(String.valueOf(result));
    }

    @GetMapping("/minus/{a}/{b}")
    public ResponseEntity<String> minus(@PathVariable int a, @PathVariable int b) {
        int result = a - b;
        return ResponseEntity.ok(String.valueOf(result));
    }

}

