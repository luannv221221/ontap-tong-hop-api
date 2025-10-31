package com.ra.tongon.controller;

import com.ra.tongon.model.dto.ResponseWrapper;
import com.ra.tongon.model.dto.bus.BusRequestDTO;
import com.ra.tongon.model.dto.bus.BusResponseDTO;
import com.ra.tongon.service.BusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/buses")
public class BusController {
    @Autowired
    private BusService busService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<BusResponseDTO> busResponseDTOS = busService.findAll();

        return new ResponseEntity<>(ResponseWrapper.builder()
                .success(true)
                .message("Get all bus success")
                .data(busResponseDTOS)
                .httpStatus(HttpStatus.OK.value())
                .build(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @ModelAttribute BusRequestDTO busRequestDTO) {
        BusResponseDTO busResponseDTO = busService.save(busRequestDTO);
        return new ResponseEntity<>(
                ResponseWrapper.builder()
                        .success(true)
                        .message("Create bus success")
                        .data(busResponseDTO)
                        .httpStatus(HttpStatus.CREATED.value())
                        .build(),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        busService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @Valid @ModelAttribute BusRequestDTO busRequestDTO
            ,@PathVariable int id){
        BusResponseDTO busResponseDTO = busService.update(busRequestDTO,id);
        return new ResponseEntity<>(
                ResponseWrapper.builder()
                        .success(true)
                        .message("update bus success")
                        .data(busResponseDTO)
                        .httpStatus(HttpStatus.OK.value())
                        .build(),
                HttpStatus.OK
        );
    }
}
