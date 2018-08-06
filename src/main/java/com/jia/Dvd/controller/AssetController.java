package com.jia.Dvd.controller;

import com.jia.Dvd.model.Asset;
import com.jia.Dvd.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest/v1/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping
    public Asset add(@RequestBody Asset asset){
        return assetService.save(asset);
    }
}
