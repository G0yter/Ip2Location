package com.gmail.goyter012.geo.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class LocationServiceImplTest {

    private final LocationService locationService;

    @Autowired
    public LocationServiceImplTest(LocationService locationService) {
        this.locationService = locationService;
    }

    @Test
    void convertFromIpToIpDigit() {
        Assert.assertEquals(134744072, (long)locationService.convertFromIpToIpDigit("8.8.8.8"));
        Assert.assertEquals(184816128, (long)locationService.convertFromIpToIpDigit("11.4.18"));
        Assert.assertEquals(0, (long)locationService.convertFromIpToIpDigit("8.8.8.f8"));
        Assert.assertEquals(0, (long)locationService.convertFromIpToIpDigit("256.8.8.8"));


    }

    @Test
    void makeCanonicalIp() {
        Assert.assertEquals("8.8.8.8",locationService.makeCanonicalIp("8.8.8.8"));
        Assert.assertEquals("8.8.8.0",locationService.makeCanonicalIp("8.8.8."));
        Assert.assertEquals("122.13.45.0",locationService.makeCanonicalIp("122.13.45"));
        Assert.assertEquals("122.13.0.0",locationService.makeCanonicalIp("122.13"));

    }

}