package com.example.agromarket.network.service.auth;

import com.example.agromarket.network.dto.auth.LoginDto;
import com.example.agromarket.network.dto.auth.TokenDto;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface AuthService {
    @POST("v1/auth")
    Observable<TokenDto> auth(@Body LoginDto loginDto);

}
