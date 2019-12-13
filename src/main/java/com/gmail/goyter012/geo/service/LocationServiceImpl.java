package com.gmail.goyter012.geo.service;

import com.gmail.goyter012.geo.model.Location;
import com.gmail.goyter012.geo.repo.LocationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationSrervice{

    private LocationRepo locationRepo;

    @Autowired
    public void setLocationRepo(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }


    //getting location from IP address in decimal form
    @Override
    public Location findLocByIpDig(long ipFrom, long ipTo) {
        return locationRepo.findLocationByIpv4FromToIpFromLessThanEqualAndIpv4FromToIpToGreaterThanEqual(ipFrom, ipTo);
    }



    //conversion canonicalIP to decimal form
    @Override
    public Long convertFromCanonicalIpToIpDigit(String ip) {
        String[] s = ip.split("\\.");
        return (long)(Integer.valueOf(s[0])*Math.pow(2,24) + Integer.valueOf(s[1])*Math.pow(2,16) + Integer.valueOf(s[2])*Math.pow(2,8) + Integer.valueOf(s[3]));

    }
}
