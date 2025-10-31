package com.ra.tongon.repository;

import com.ra.tongon.model.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Integer> {
    boolean existsBusByBusId(int id);
    boolean existsBusByBusName(String busName);
    boolean existsBusByRegistrationNumber(String busNo);
    boolean existsByBusNameAndBusIdNot(String busName, int busId);
    boolean existsByRegistrationNumberAndBusIdNot(String busNo, int busId);
}
