package com.ra.tongon.service.impl;

import com.ra.tongon.model.dto.bus.BusResponseDTO;
import com.ra.tongon.model.dto.busroute.BusRouteRequestDTO;
import com.ra.tongon.model.dto.busroute.BusRouteResponseDTO;
import com.ra.tongon.model.entity.Bus;
import com.ra.tongon.model.entity.BusRoute;
import com.ra.tongon.repository.BusRepository;
import com.ra.tongon.repository.BusRouteRepository;
import com.ra.tongon.service.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteServiceImpl implements BusRouteService {
    @Autowired
    private BusRouteRepository busRouteRepository;
    @Autowired
    private BusRepository busRepository;
    @Override
    public List<BusRouteResponseDTO> getBusRoutes() {
        return List.of();
    }

    @Override
    public BusRouteResponseDTO create(BusRouteRequestDTO busRouteRequestDTO) {
        Bus bus = busRepository.findById(busRouteRequestDTO.getBusId()).orElseThrow();
        BusRoute busRoute = BusRoute.builder()
                .driverName(busRouteRequestDTO.getDriverName())
                .endPoint(busRouteRequestDTO.getEndPoint())
                .bus(bus)
                .build();
        BusRoute busNew = busRouteRepository.save(busRoute);
        return BusRouteResponseDTO.builder()
                .busId(busNew.getBusRouteId())
                .driverName(busRouteRequestDTO.getDriverName())
                .endPoint(busRouteRequestDTO.getEndPoint())
                .status(busRouteRequestDTO.getStatus())
                .build();
    }
}
