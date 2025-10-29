package com.ra.tongon.repository;

import com.ra.tongon.model.entity.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRouteRepository extends JpaRepository<BusRoute,Integer> {
    boolean existsBusRoutesByBus_BusId(int id);
}
