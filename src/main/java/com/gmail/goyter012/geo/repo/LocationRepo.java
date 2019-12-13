package com.gmail.goyter012.geo.repo;

import com.gmail.goyter012.geo.model.Ipv4;
import com.gmail.goyter012.geo.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends CrudRepository<Location, Ipv4> {

    Location findLocationByIpv4FromToIpFromLessThanEqualAndIpv4FromToIpToGreaterThanEqual(long ipFrom, long ipTo);
}
