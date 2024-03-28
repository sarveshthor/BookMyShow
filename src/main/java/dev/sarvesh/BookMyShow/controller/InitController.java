package dev.sarvesh.BookMyShow.controller;

import dev.sarvesh.BookMyShow.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @Autowired
    private InitService initService;

    @PostMapping("/generateData")
    public ResponseEntity generateData(){
        return ResponseEntity.ok(
                initService.initializeData()
        );
    }
}
