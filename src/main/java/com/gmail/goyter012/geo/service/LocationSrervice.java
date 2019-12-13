package com.gmail.goyter012.geo.service;

import com.gmail.goyter012.geo.model.Location;

import java.util.Optional;

public interface LocationSrervice {

    Location findLocByIpDig(long ipFrom, long ipTo);
    Long convertFromCanonicalIpToIpDigit(String ip);

}
