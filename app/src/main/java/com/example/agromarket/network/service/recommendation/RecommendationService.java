package com.example.agromarket.network.service.recommendation;

import com.example.agromarket.network.dto.model.DiseaseDto;
import com.example.agromarket.network.dto.model.TreatmentDto;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

public interface RecommendationService {

    @GET("v1/recommendation/{imageUrl}")
    Observable<List<TreatmentDto>> recommendationsByImage(@Path("imageUrl") String imageUrl);

    @GET("v1/recommendation/info/{imageUrl}")
    Observable<DiseaseDto> infoDiseaseByImage(@Path("imageUrl") String imageUrl);
}
