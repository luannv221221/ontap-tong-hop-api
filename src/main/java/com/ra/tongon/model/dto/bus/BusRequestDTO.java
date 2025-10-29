package com.ra.tongon.model.dto.bus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BusRequestDTO {
    @NotBlank(message = "ten xe khong rong")
    private String busName;
    @NotBlank(message = "dang ky xe khong rong")
    private String registrationNumber;
    @NotNull(message = "tong ghe khong rong")
    private int totalSeats;
    private boolean  status;
    private MultipartFile imageBus;
}
