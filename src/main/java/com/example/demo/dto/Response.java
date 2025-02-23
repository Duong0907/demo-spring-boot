package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class Response {
    private HttpStatus statusCode;
    private String message;
    private Object data;
}
