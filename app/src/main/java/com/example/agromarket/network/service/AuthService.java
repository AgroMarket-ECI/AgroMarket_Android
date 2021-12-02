package com.example.agromarket.network.service;

import com.example.agromarket.network.dto.LoginDto;
import com.example.agromarket.network.dto.TokenDto;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface AuthService {
    @POST("auth")
    Observable<TokenDto> auth(@Body LoginDto loginDto);

}
