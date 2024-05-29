package com.yatendra.project.bird.bird_api.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yatendra.project.bird.bird_api.entity.Bird;
import com.yatendra.project.bird.bird_api.repos.BirdRepository;
import com.yatendra.project.bird.bird_api.service.BirdService;

@Service
public class BirdServiceImpl implements BirdService {

    @Autowired
    private BirdRepository repo;

    @Override
    public void createBird(Bird bird) {
        
        String formatDate = ZonedDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        bird.setAdded(formatDate);
        if(bird.getVisible() == null) bird.setVisible(false);

        repo.save(bird);
    }

    @Override
    public List<Bird> readBirds() {
        return repo.findAll();
    }

    @Override
    public Bird readBird(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteBird(Long id) {
        repo.deleteById(id);
    }


}
