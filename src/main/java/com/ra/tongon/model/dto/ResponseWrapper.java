package com.ra.tongon.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseWrapper <T>{
    private boolean success;
    private String message;
    private T data;
    private int httpStatus;

}
