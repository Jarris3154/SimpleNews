package com.jia.Dvd.controller;

import com.jia.Dvd.model.Dvd;
import com.jia.Dvd.model.LendState;
import com.jia.Dvd.repository.DvdRepository;
import com.jia.Dvd.service.DvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/api/rest/v1/dvds")
public class DvdController {

    @Autowired
    private DvdService dvdService;

    @PostMapping
    public Dvd add(@RequestBody Dvd dvd){
        return dvdService.save(dvd);
    }

    @GetMapping
    public Iterable<Dvd> findAll(){
        return dvdService.findAll();
    }

    @GetMapping("/{id}")
    public Dvd getById(@PathVariable String id){
        return dvdService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        dvdService.delete(id);
    }

    @PostMapping("/{id}/lendDvd")
    public void lendDvd(@PathVariable String id){
        Dvd dvd = new Dvd();
        dvd.setLendState(LendState.已借出);
        Dvd dvd1 = dvdService.findOne(id);
        int count = dvd1.getLendCount();
        dvd.setLendCount(count);
        dvd.setLendOutDate(new Date());
        dvdService.patchUpdate(id, dvd);
    }

    @PostMapping("/{id}/returnDvd")
    public void returnDvd(@PathVariable String id){
        Dvd dvd = new Dvd();
        dvd.setLendState(LendState.可借);
        Dvd dvd1 = dvdService.findOne(id);
        int count = dvd1.getLendCount()+1;
        dvd.setLendCount(count);
        dvdService.patchUpdate(id, dvd);
    }

}
