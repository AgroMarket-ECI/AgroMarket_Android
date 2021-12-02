package com.example.agromarket.network.dto.recommendation;

public class RecommendationDto {

    private String url_plant_disease;

    public RecommendationDto(String url_plant_disease) {
        this.url_plant_disease = url_plant_disease;
    }

    public String getUrl_plant_disease() {
        return url_plant_disease;
    }

    public void setUrl_plant_disease(String url_plant_disease) {
        this.url_plant_disease = url_plant_disease;
    }
}
