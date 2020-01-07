package com.gmail.goyter012.geo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


//Entity of ip2location table
@Entity
@Table(name = "ip2location_db5")
@Data
public class Location {

    @EmbeddedId
    private Ipv4 ipv4FromTo;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "country_code", columnDefinition = "CHAR", length = 2)
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "canonicalip")
    private String canonicalIpv4Representation;

    @Column(name = "ipv4", columnDefinition = "INTEGER")
    private Long ipv4;
}
