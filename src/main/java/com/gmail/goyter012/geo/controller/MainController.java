package com.gmail.goyter012.geo.controller;

import com.gmail.goyter012.geo.model.Location;
import com.gmail.goyter012.geo.service.LocationSrervice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private LocationSrervice locationService;

    @Autowired
    public void setLocationService(LocationSrervice locationService) {
        this.locationService = locationService;
    }

    //handling /
    @RequestMapping("/")
    public String go(){
        return "If you want to get the location from IP -- type to the address line /geoip/{ip}";
    }


    //task performance
    @RequestMapping("/geoip/{ip}")
    public Location getLocByIp(@PathVariable String ip){
        Long ipDig;
        try {
            ipDig = locationService.convertFromCanonicalIpToIpDigit(ip);
        }catch (IllegalArgumentException e ){
            return null;
        }

        Location loc = locationService.findLocByIpDig(ipDig,ipDig);
        loc.setCanonicalIpv4Representation(ip);
        loc.setIpv4(ipDig);
        log.info("Ip was correctly written. Data received ");
        return loc;
        }


}
