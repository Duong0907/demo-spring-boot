package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.RegisterRequest;
import com.example.demo.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public Response register(RegisterRequest registerRequest) {
        return Response
                .builder().
                statusCode(HttpStatus.OK).
                message("Register successfully").
                data("null").
                build();
    }

    public Response login(LoginRequest loginRequest) {
        return Response
                .builder().
                statusCode(HttpStatus.OK).
                message("Login successfully").
                data("null").
                build();
    }
}
