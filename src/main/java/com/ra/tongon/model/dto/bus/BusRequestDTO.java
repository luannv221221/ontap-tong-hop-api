package com.ra.tongon.model.dto.bus;

import com.ra.tongon.model.entity.Bus;
import com.ra.tongon.validate.FileNotBank;
import com.ra.tongon.validate.Unique;
import com.ra.tongon.validate.Uniques;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
//@Uniques({
//        @Unique(field = "busName",entityClass =  Bus.class,idField = "busId",message = "busName da ton tai"),
//        @Unique(field = "registrationNumber",entityClass = Bus.class,idField = "busId")
//})

public class BusRequestDTO {
//    private Integer busId;
    @NotBlank(message = "ten xe khong rong")
    private String busName;
    @NotBlank(message = "dang ky xe khong rong")
    private String registrationNumber;
    @NotNull(message = "tong ghe khong rong")
    private int totalSeats;
    private boolean  status;
    @FileNotBank(message = "Anh khong duoc de rong")
    private MultipartFile imageBus;
}
