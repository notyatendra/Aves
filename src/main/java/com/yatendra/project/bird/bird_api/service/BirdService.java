package com.yatendra.project.bird.bird_api.service;

import java.util.List;

import com.yatendra.project.bird.bird_api.entity.Bird;

public interface BirdService {

    public void createBird(Bird bird);
    public List<Bird> readBirds();
    public Bird readBird(Long id);
    public void deleteBird(Long id);

}
