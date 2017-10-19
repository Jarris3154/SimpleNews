package com.jia.Dvd.repository;

import com.jia.Dvd.model.Dvd;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DvdRepository extends MongoRepository<Dvd, String> {

}
