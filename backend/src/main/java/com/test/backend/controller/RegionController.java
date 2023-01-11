package com.test.backend.controller;

import com.test.backend.models.Region;
import com.test.backend.models.dto.request.RegionRequest;
import com.test.backend.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

//    Get all data
    @GetMapping
    public ResponseEntity<List<Region>> getAll(){
        return new ResponseEntity<>(regionService.getAll(), HttpStatus.OK);
    }

//    Get ById
    @GetMapping("/{id}")
    public ResponseEntity<Region> getById(@PathVariable Long id){
        return new ResponseEntity<>(regionService.getById(id), HttpStatus.OK);
    }

//    Create Data
    @PostMapping
//    public ResponseEntity<Region> create(@RequestBody RegionRequest regionRequest){
//        System.out.println("Tanggal " + regionRequest.getRegion_date());
//        return new ResponseEntity<>(regionService.create(regionRequest), HttpStatus.CREATED);
//    }
    public ResponseEntity<Region> create(@RequestBody Region region){
        return new ResponseEntity<>(regionService.create(region), HttpStatus.CREATED);
    }

// Update data
    @PutMapping("/{id}")
    public ResponseEntity<Region> update(@PathVariable Long id, @RequestBody Region region){
        return new ResponseEntity<>(regionService.update(id, region), HttpStatus.CREATED);
    }

//    Delete Data
    @DeleteMapping("/{id}")
    public ResponseEntity<Region> delete(@PathVariable Long id){
        return new ResponseEntity<>(regionService.delete(id), HttpStatus.OK);
    }

}

