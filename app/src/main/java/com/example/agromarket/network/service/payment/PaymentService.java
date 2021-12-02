package com.example.agromarket.network.service.payment;

import com.example.agromarket.network.dto.order.OrderDto;
import com.example.agromarket.network.dto.payment.PaymentDto;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface PaymentService {

    @POST("v1/payment")
    Observable<PaymentDto> generatePayment(@Body PaymentDto paymentDto);
}
