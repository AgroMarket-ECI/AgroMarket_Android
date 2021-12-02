package com.example.agromarket.network.service.order;

import com.example.agromarket.network.dto.order.OrderDto;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface OrderService {

    @POST("v1/order")
    Observable<OrderDto> generateOrder(@Body OrderDto orderDto);
}
