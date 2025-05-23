package com.ms_kart.controllers;

import com.ms_kart.entities.kartEntity;
import com.ms_kart.services.kartServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/karts")
@CrossOrigin("*")
public class kartController {
    @Autowired
    kartServices kartService;

    @GetMapping("/")
    public ResponseEntity<List<kartEntity>> listKart() {
        List<kartEntity> karts = kartService.getAllKart();
        return ResponseEntity.ok(karts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<kartEntity> getKartById(@PathVariable("id") Long id) {
        kartEntity kartEntity = kartService.getKartById(id);
        return ResponseEntity.ok(kartEntity);
    }
    @PostMapping("/")
    public ResponseEntity<kartEntity> addKart(@RequestBody kartEntity kart) {
        kartEntity kartNew = kartService.saveKart(kart);
        return ResponseEntity.ok(kartNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<kartEntity> updateKart(@PathVariable("id") Long id,@RequestBody kartEntity kart) {
        if (!id.equals(kart.getId())) {
            return ResponseEntity.badRequest().build();
        }
        kartEntity kartUpdated = kartService.updateKart(kart);
        return ResponseEntity.ok(kartUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<kartEntity> deleteKart(@PathVariable("id") Long id) throws Exception {
        kartService.deleteKartById(id);
        return ResponseEntity.noContent().build();
    }
}
