package com.jia.Dvd.service;

import com.jia.Dvd.model.Asset;
import com.jia.Dvd.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public Asset save(Asset asset) {
        return assetRepository.save(asset);
    }
}
