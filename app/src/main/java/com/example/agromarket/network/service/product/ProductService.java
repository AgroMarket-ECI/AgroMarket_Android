package com.example.agromarket.network.service.product;

import com.example.agromarket.network.dto.payment.PaymentDto;
import com.example.agromarket.network.dto.product.ProductDto;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

public interface ProductService {

    @POST("v1/product")
    Observable<ProductDto> create(@Body ProductDto productDto);

    @GET("v1/product/{id}")
    Observable<ProductDto> findProductById(@Path("id") String id);

    @GET("v1/product")
    Observable<List<ProductDto>> getAllProducts();

    @GET("v1/product/name/{name}")
    Observable<List<ProductDto>> findProductsByname(@Path("name") String name);

    @PUT("v1/product/{id}")
    Observable<ProductDto> updateProductById(@Body ProductDto productDto, @Path("id") String id);

    @DELETE("v1/product/{id}")
    Observable<Boolean> deleteProductById(@Path("id") String id);
}
