package com.itsmerishab08.salonuserservice.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseResponse {
    private String successMessage;
    private String errorMessage;
    private HttpStatus statusCode;
}
