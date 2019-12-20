package com.gmail.goyter012.geo.service;

import com.gmail.goyter012.geo.model.Location;
import com.gmail.goyter012.geo.model.LocationDto;
import com.gmail.goyter012.geo.repo.LocationRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService{

    private final LocationRepo locationRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public LocationServiceImpl(LocationRepo locationRepo, ModelMapper modelMapper) {
        this.locationRepo = locationRepo;
        this.modelMapper = modelMapper;
    }

    // get Location from Ip
    @Override
    public Location getLocation(String ip) {
        Long ipDig = convertFromCanonicalIpToIpDigit(ip);

        if(ipDig == 0) {
            log.error("Invalid Ip entered!");
            return new Location();
        }
        Location loc = findLocationByIpDigit(ipDig,ipDig);

        loc.setCanonicalIpv4Representation(makeCanonicalIp(ip));
        loc.setIpv4(ipDig);

        log.info("Data received!");
        return loc;
    }

    //conversion canonicalIP to decimal form
    @Override
    public Long convertFromCanonicalIpToIpDigit(String ip){

        if(!isIpValid(ip)) return (long)0;

        long res = 0;
        String[] s = ip.split("\\.");

        for(int i = 0; i < s.length; i++){
            res+= Integer.parseInt(s[i]) * Math.pow(2,24 - (i * 8));
        }

        return res;
    }

    //getting location from IP address in decimal form
    @Override
    public Location findLocationByIpDigit(long ipFrom, long ipTo) {
        return locationRepo.findLocationByIpv4FromToIpFromLessThanEqualAndIpv4FromToIpToGreaterThanEqual(ipFrom, ipTo);
    }


    //ip validation method
    private boolean isIpValid(String ip){
        if(ip == null) return false;    // null check
        if(!ip.contains(".")) return false; // dot check

        String[] s = ip.split("\\.");
        if(s.length > 4) return false;

        for (String value : s) {  // ip validation
            try {
                int digit = Integer.parseInt(value.trim());
                if (digit < 0 || digit > 255) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                return false;
            }
        }

        return true;

    }

    @Override
    public String makeCanonicalIp(String ip){
        if(countCharsInString(ip,'.') == 3){    // in canonical ip it has to be 3 dots

            if(ip.charAt(ip.length()-1)!='.'){     // last index must be digit
                return ip;
            }else {
                return ip + "0";
            }

        }

        StringBuilder sb = new StringBuilder(ip);

        while (countCharsInString(sb.toString(), '.') != 3 || sb.charAt(sb.length() - 1) == '.') {
            if (!(sb.charAt(sb.length() - 1) == '.')) {
                sb.append(".0");
            }else{
            sb.append("0");
            }
        }
        return sb.toString();

    }

    private long countCharsInString(String string, char c){
        return string.chars().filter(n -> n == c).count();
    }


    @Override
    public LocationDto getLocationDto(Location location) {
        return modelMapper.map(location,LocationDto.class);

    }
}
