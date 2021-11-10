package com.nashtech.rookies.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class ResponseDto {
    private LocalDateTime time = LocalDateTime.now();
    private String errorCode;
    private Object data;
    private String successCode;

    public ResponseDto(String errorCode, Object data, String successCode) {
        this.errorCode = errorCode;
        this.data = data;
        this.successCode = successCode;
    }
}
