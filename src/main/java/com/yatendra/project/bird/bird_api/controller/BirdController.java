package com.yatendra.project.bird.bird_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yatendra.project.bird.bird_api.entity.Bird;
import com.yatendra.project.bird.bird_api.service.BirdService;

@RestController
public class BirdController {

    @Autowired
    private BirdService service;

    // @RequestMapping("/index")
    // public String homePage() {
    //     return "index";
    // }

    @PostMapping("/birds")
    public void addBird(@RequestBody Bird bird) {
        service.createBird(bird);
    }

    @GetMapping("/birds")
    public List<Bird> getBrids() {
        return service.readBirds();
    }

    @GetMapping("/birds/{id}")
    public Bird getBird(@PathVariable("id") Long id) {
        return service.readBird(id);
    }

    @RequestMapping(value = "/birds/{id}", method = RequestMethod.DELETE)
    public void deleteBird(@PathVariable("id") Long id) {
        service.deleteBird(id);
    }

}
