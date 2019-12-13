package com.gmail.goyter012.geo.controller;

import com.gmail.goyter012.geo.model.Location;
import com.gmail.goyter012.geo.service.LocationSrervice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private LocationSrervice locationService;

    @Autowired
    public void setLocationService(LocationSrervice locationService) {
        this.locationService = locationService;
    }

    @RequestMapping("/")
    public String go(){
        return "Hello There!";
    }

    @RequestMapping("/geoip/{ip}")
    public Location getLocByIp(@PathVariable String ip){
        long ipDig = locationService.convertFromCanonicalIpToIpDigit(ip);
        Location loc = locationService.findLocByIp(ipDig,ipDig);
        loc.setCanonicalIpv4Representation(ip);
        loc.setIpv4(ipDig);
        return loc;
    }



}
