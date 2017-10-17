package com.jia.Dvd.controller;

import com.jia.Dvd.model.Dvd;
import com.jia.Dvd.repository.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rest/v1/dvds")
public class DvdController {

    @Autowired
    DvdRepository dvdRepository;

    @PostMapping
    public Dvd add(@RequestBody Dvd dvd){
        return dvdRepository.save(dvd);
    }

    @GetMapping
    public List<Dvd> findAll(){
        return dvdRepository.findAll();
    }

    @GetMapping("/{id}")
    public Dvd getById(@PathVariable String id){
        return dvdRepository.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        dvdRepository.delete(id);
    }
}
