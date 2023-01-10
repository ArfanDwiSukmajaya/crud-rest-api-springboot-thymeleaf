package com.example.frontend.service;

import com.example.frontend.model.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RegionService {
    private RestTemplate restTemplate;

    public RegionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/region")
    String url;

//    Get all data
    public List<Region> getAll(){
        return restTemplate
                .exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Region>>() {
                        }).getBody();
    }

//    Get By Id
public Region getById(Long id) {
    return restTemplate
            .exchange(url.concat("/" + id), HttpMethod.GET, null,
                    new ParameterizedTypeReference<Region>() {
                    }).getBody();
}

    // Create
    public Region create(Region region){
        return restTemplate
        .exchange(url, HttpMethod.POST, new HttpEntity(region),
            new ParameterizedTypeReference<Region>() {
            }).getBody();
    }

//    update
    public Region update(Long id, Region region) {
        return restTemplate
                .exchange(url.concat("/" + id), HttpMethod.PUT, new HttpEntity(region),
                        new ParameterizedTypeReference<Region>() {
                        }).getBody();
    }

//    Delete Data
    public Region delete(Long id) {
        ResponseEntity<Region> respon = restTemplate
                .exchange(url.concat("/" + id), HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<Region>() {
                        });
        if (respon.getStatusCodeValue() == 200) {
            return respon.getBody();
        }
        return respon.getBody();
    }


}
