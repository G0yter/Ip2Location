package com.gmail.goyter012.geo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class Ipv4 implements Serializable {

    @Column(name = "ip_from")
    private long ipFrom;
    @Column(name = "ip_to")
    private long ipTo;


}
