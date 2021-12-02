package com.example.agromarket.network.service.user;

import com.example.agromarket.network.dto.user.UserDto;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

public interface UserService {

    @POST("v1/user")
    Observable<UserDto> create(@Body UserDto userDto);

    @GET("v1/user")
    Observable<List<UserDto>> getAll();

    @GET("v1/user/{id}")
    Observable<UserDto> findById(@Path("id") String id);

    @PUT("v1/user/{id}")
    Observable<UserDto> updateById(@Body UserDto userDto, @Path("id") String id);

    @DELETE("v1/user/{id}")
    public Boolean deleteById(@Path("id") String id);
}
