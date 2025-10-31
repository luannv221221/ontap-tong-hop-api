package com.ra.tongon.model.dto.busroute;

import com.ra.tongon.model.entity.Bus;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BusRouteResponseDTO {
    private int busRouteId;
    private String startPoint;
    private String endPoint;
    private String tripInformation;
    private String driverName;
    private Boolean status;
    private int busId;
}
