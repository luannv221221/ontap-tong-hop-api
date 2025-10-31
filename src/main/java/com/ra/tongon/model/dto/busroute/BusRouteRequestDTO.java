package com.ra.tongon.model.dto.busroute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusRouteRequestDTO {

    private String startPoint;
    private String endPoint;
    private String tripInformation;
    private String driverName;
    private Boolean status;
    private Integer busId;
}
