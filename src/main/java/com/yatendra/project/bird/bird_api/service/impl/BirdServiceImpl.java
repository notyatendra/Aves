package com.yatendra.project.bird.bird_api.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.yatendra.project.bird.bird_api.entity.Bird;
import com.yatendra.project.bird.bird_api.exception.BadRequestException;
import com.yatendra.project.bird.bird_api.repos.BirdRepository;
import com.yatendra.project.bird.bird_api.service.BirdService;

@Service
public class BirdServiceImpl implements BirdService {

    @Autowired
    private BirdRepository repo;

    @Override
    public void createBird(Bird bird) {

        if(bird.getName() == null) {
            throw new BadRequestException("please provide the name of the bird");
        }
        
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
        if(!repo.existsById(id)) throw new ResourceNotFoundException("Bird not found with id : " + id);
        return repo.findById(id).get();
    }

    @Override
    public void deleteBird(Long id) {
        if(!repo.existsById(id)) throw new ResourceNotFoundException("Bird with id " + id + " does not exists");
        repo.deleteById(id);
    }


}
