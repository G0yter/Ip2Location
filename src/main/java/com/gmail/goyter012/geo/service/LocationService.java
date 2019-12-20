package com.gmail.goyter012.geo.service;

import com.gmail.goyter012.geo.model.Location;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface LocationService{

    Location findLocationByIpDigit(long ipFrom, long ipTo);
    Long convertFromCanonicalIpToIpDigit(String ip);
    Location getLocation(String ip);
}