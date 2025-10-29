package com.ra.tongon.model.dto.bus;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BusResponseDTO {
    private int busId;
    private String busName;
    private String registrationNumber;
    private int totalSeats;
    private String imageBus;
    private String status;
}
