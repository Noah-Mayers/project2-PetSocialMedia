package dev.groupone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.groupone.beans.Image;

@Repository
public interface ImageRepo extends CrudRepository<Image, Integer> {

}
