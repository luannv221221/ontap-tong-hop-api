package com.ra.tongon.service;

import com.ra.tongon.model.dto.bus.BusRequestDTO;
import com.ra.tongon.model.dto.bus.BusResponseDTO;

import java.util.List;

public interface BusService {
    List<BusResponseDTO> findAll();
    BusResponseDTO save(BusRequestDTO busRequestDTO);
    void delete(int busId);
    BusResponseDTO update(BusRequestDTO busRequestDTO, int busId);
}
