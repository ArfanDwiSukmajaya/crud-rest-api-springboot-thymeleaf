package com.test.backend.service;

import com.test.backend.models.Region;
import com.test.backend.models.dto.request.RegionRequest;
import com.test.backend.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class RegionService {
    final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

//    Get all daa
    public List<Region> getAll(){
        return regionRepository.findAll();
    }

//    Get ById
    public Region getById(Long id){
        return regionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Region not found"));
    }

//    Create data

//    public Region create(Region region) {
//        if (region.getId() != null) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region already exist");
//        }
//        if (regionRepository.findByName(region.getName()).isPresent()) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region name already exist");
//        }
//        return regionRepository.save(region);
//    }

    public Region create(RegionRequest regionRequest){
        Region region = new Region();
        region.setId(regionRequest.getId());
        region.setName(regionRequest.getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(regionRequest.getRegion_date(), formatter);
        region.setRegion_date(localDate);
        return regionRepository.save(region);

    }

//    update data
    public Region update(Long id, Region region){
        getById(id);
        region.setId(id);
        return regionRepository.save(region);
    }

//    Delete data
    public Region delete(Long id){
        Region region = getById(id);
        regionRepository.delete(region);
        return region;
    }
}
