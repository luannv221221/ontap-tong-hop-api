package com.ra.tongon.service.impl;

import com.ra.tongon.exception.HttpConflict;
import com.ra.tongon.exception.HttpNotFound;
import com.ra.tongon.model.dto.bus.BusRequestDTO;
import com.ra.tongon.model.dto.bus.BusResponseDTO;
import com.ra.tongon.model.entity.Bus;
import com.ra.tongon.repository.BusRepository;
import com.ra.tongon.repository.BusRouteRepository;
import com.ra.tongon.service.BusService;
import com.ra.tongon.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private BusRouteRepository busRouteRepository;
    @Autowired
    private UploadService uploadService;
    @Override
    public List<BusResponseDTO> findAll() {
        List<Bus>  buses = busRepository.findAll();
        List<BusResponseDTO> busResponseDTOS;
        busResponseDTOS = buses.stream().map(bus ->
                        BusResponseDTO.builder()
                                .busId(bus.getBusId())
                                .busName(bus.getBusName())
                                .imageBus(bus.getImageBus())
                                .registrationNumber(bus.getRegistrationNumber())
                                .totalSeats(bus.getTotalSeats())
                                .status(bus.getStatus()?"Hoạt động":"Không hoạt động")
                                .build()
                ).toList();
        return busResponseDTOS;
    }

    @Override
    public BusResponseDTO save(BusRequestDTO busRequestDTO) {
        // kiem tra ten bus da co hay chua
        if (busRepository.existsBusByBusName(busRequestDTO.getBusName())) {
            throw new HttpConflict(busRequestDTO.getBusName() + "already exists");
        }

        if (busRepository.existsBusByRegistrationNumber(busRequestDTO.getRegistrationNumber())) {
            throw new HttpConflict(busRequestDTO.getRegistrationNumber() + "already exists");
        }

        String busImage = uploadService.uploadFile(busRequestDTO.getImageBus());

        Bus bus = Bus.builder()
                .busName(busRequestDTO.getBusName())
                .imageBus(busImage)
                .registrationNumber(busRequestDTO.getRegistrationNumber())
                .totalSeats(busRequestDTO.getTotalSeats())
                .status(true)
                .build();
        Bus busNew = busRepository.save(bus);

        return BusResponseDTO.builder()
                .busId(busNew.getBusId())
                .busName(busNew.getBusName())
                .imageBus(busNew.getImageBus())
                .totalSeats(busNew.getTotalSeats())
                .registrationNumber(busNew.getRegistrationNumber())
                .status(busNew.getStatus()?"Hoat Dong":"Khong Hoat Dong")
                .build();
    }

    @Override
    public void delete(int busId) {
        // kiem tra xem id co ton tai tren Bus hay khong
        Bus bus = busRepository.findById(busId).orElseThrow(()-> new HttpNotFound("Bus not found"));

        if (busRouteRepository.existsBusRoutesByBus_BusId(busId)) {
            throw new HttpConflict("cannot delete bus with id " + busId + " because it has routes bus");
        }
        bus.setStatus(false);
        busRepository.save(bus);
    }
}
