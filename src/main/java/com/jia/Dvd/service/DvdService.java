package com.jia.Dvd.service;

import com.jia.Dvd.model.Dvd;
import com.jia.Dvd.repository.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class DvdService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    DvdRepository dvdRepository;

    public Iterable<Dvd> findAll(){
        return dvdRepository.findAll();
    }

    public Dvd findOne(String id){
        return dvdRepository.findOne(id);
    }

    public Dvd save(Dvd dvd){
        return dvdRepository.save(dvd);
    }

    public void delete(String id){
        dvdRepository.delete(id);
    }


    public void patchUpdate(String id, Dvd dvd){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("lendState", dvd.getLendState());
        update.set("lendCount", dvd.getLendCount());
        update.set("lendOutDate", dvd.getLendOutDate());
        mongoTemplate.updateFirst(query, update, Dvd.class);
    }

}
