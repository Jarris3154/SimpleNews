package com.jia.Dvd.controller;

import com.jia.Dvd.model.Asset;
import com.jia.Dvd.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rest/v1/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping
    public Asset add(@RequestBody Asset asset){
        return assetService.save(asset);
    }

    @GetMapping
    public List<Asset> get(){
        return assetService.findAll();
    }
}
