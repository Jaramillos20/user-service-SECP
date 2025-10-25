package com.binarybrains.userservice.utils.error;

import javax.lang.model.type.ErrorType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorInfo {
    private String code;
    private String message;
    private String ruta;
    private ErrorType type;

}
