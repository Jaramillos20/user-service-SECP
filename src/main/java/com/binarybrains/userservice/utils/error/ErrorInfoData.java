package com.binarybrains.userservice.utils.error;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfoData {
    private List<ErrorInfo> errorsInfo;
}