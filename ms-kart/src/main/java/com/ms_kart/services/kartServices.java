package com.ms_kart.services;

import com.ms_kart.entities.kartEntity;
import com.ms_kart.repository.kartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class kartServices {
    @Autowired
    kartRepository kartRepository;

    public List<kartEntity> getAllKart() {
        return kartRepository.findAll();
    }
    public kartEntity getKartById(Long id) {
        return kartRepository.findById(id).get();
    }
    public kartEntity saveKart(kartEntity kart) {
        return kartRepository.save(kart);
    }
    //actualizar un kart
    public kartEntity updateKart(kartEntity kart) {
        return kartRepository.save(kart);
    }
    public void deleteKartById(Long id){
        kartRepository.deleteById(id);
    }
}
