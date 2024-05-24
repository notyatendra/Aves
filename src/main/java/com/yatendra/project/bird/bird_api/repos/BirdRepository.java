package com.yatendra.project.bird.bird_api.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.stereotype.Repository;

import com.yatendra.project.bird.bird_api.entity.Bird;

@RepositoryRestResource
public interface BirdRepository extends JpaRepository<Bird, Long>{

}
