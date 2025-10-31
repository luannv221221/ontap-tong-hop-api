package com.ra.tongon.service;

import com.ra.tongon.model.dto.busroute.BusRouteRequestDTO;
import com.ra.tongon.model.dto.busroute.BusRouteResponseDTO;

import java.util.List;

public interface BusRouteService {
    List<BusRouteResponseDTO> getBusRoutes();
    BusRouteResponseDTO create(BusRouteRequestDTO busRouteRequestDTO);
}
