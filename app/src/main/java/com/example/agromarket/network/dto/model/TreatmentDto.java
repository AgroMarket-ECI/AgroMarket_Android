package com.example.agromarket.network.dto.model;

import com.example.agromarket.network.dto.product.ProductDto;

import java.util.List;

public class TreatmentDto {

    private String id;
    private String name;
    private String instructions;
    private List<ProductDto> products;

    public TreatmentDto(String id, String name, String instructions, List<ProductDto> products) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
        this.products = products;
    }

    public TreatmentDto(String id, String name, String instructions ) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
