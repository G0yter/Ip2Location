package com.gmail.goyter012.geo.controller;

import com.gmail.goyter012.geo.model.Location;
import com.gmail.goyter012.geo.model.LocationDto;
import com.gmail.goyter012.geo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final LocationService locationService;


    @Autowired
    public MainController(LocationService locationService) {
        this.locationService = locationService;
    }

    //handling /
    @RequestMapping("/")
    public String go(){
        return "If you want to get the location from IP -- type to the address line /geoip/{ip}";
    }


    //task performance
    @RequestMapping("/geoip/{ip}")
    public ResponseEntity<LocationDto> getLocationByIp(@PathVariable String ip){
        return locationService.getLocation(ip);


    }


}
