package com.gmail.goyter012.geo.service;

import com.gmail.goyter012.geo.model.Location;
import com.gmail.goyter012.geo.model.LocationDto;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface LocationService{

    Location findLocationByIpDigit(long ipFrom, long ipTo);
    Long convertFromIpToIpDigit(String ip);
    Location getLocation(String ip);
    LocationDto getLocationDto(Location location);
    String makeCanonicalIp(String ip);
}
