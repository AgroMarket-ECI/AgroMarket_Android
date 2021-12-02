package com.example.agromarket.network.dto.product;

public class ProductDto {

    private String name;
    private double price;
    private String description;
    private String idProvider;
    private boolean favorite;
    private String image;

    public ProductDto(String name, double price, String description, String idProvider, boolean favorite, String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.idProvider = idProvider;
        this.favorite = favorite;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
