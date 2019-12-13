package com.gmail.goyter012.geo.service;

import com.gmail.goyter012.geo.model.Location;

public interface LocationSrervice {

    Location findLocByIp(long ipFrom, long ipTo);
    Long convertFromCanonicalIpToIpDigit(String ip);

}
