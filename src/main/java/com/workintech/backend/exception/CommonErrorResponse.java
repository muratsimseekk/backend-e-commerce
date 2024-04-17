package com.workintech.backend.exception;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonErrorResponse {

    private Integer status;
    private String message;
    private LocalDateTime timeStamp;

}
