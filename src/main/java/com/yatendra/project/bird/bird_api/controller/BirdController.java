package com.yatendra.project.bird.bird_api.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import com.yatendra.project.bird.bird_api.entity.Bird;
import com.yatendra.project.bird.bird_api.repos.BirdRepository;

@RestController
public class BirdController {

    @Autowired
    BirdRepository repo;

    // @RequestMapping("/index")
    // public String homePage() {
    //     return "index";
    // }

    @PostMapping("/birds")
    public void addBird(@RequestBody Bird bird) {

        String formatDate = ZonedDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        bird.setAdded(formatDate);

        if(bird.getVisible() == null) bird.setVisible(false);
        repo.save(bird);

    }

    @GetMapping("/birds")
    public List<Bird> getBrids() {
        return repo.findAll();
    }

}
