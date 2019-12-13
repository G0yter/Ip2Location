package com.gmail.goyter012.geo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ip2location")
@Data
public class Location {

    @JsonIgnore
    @EmbeddedId
    private Ipv4 ipv4FromTo;


    @Column(name = "canonicalip")
    private String canonicalIpv4Representation;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "country_code", columnDefinition = "bpchar(2)", length = 2)
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    private Long ipv4;

    @Column(name = "region_name")
    private String regionName;

    private Float latitude;
    private Float longitude;


}
