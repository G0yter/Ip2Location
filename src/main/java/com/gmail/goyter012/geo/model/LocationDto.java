package com.gmail.goyter012.geo.model;


import lombok.Data;

@Data
public class LocationDto {

    private String cityName;

    private String countryCode;

    private String countryName;

    private String regionName;

    private Double latitude;

    private Double longitude;

    private String canonicalIpv4Representation;

    private Long ipv4;
}
