package com.jia.Dvd.repository;

import com.jia.Dvd.model.Dvd;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="dvds")
public interface DvdRepository extends MongoRepository<Dvd, String>{
}
