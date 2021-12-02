package com.example.agromarket.network.dto.order;

import com.example.agromarket.network.dto.product.ItemDto;

import java.util.List;

public class OrderDto {

    String id;

    String idClient;

    String totalValue;

    List<ItemDto> items;

    public OrderDto(String id, String idClient, String totalValue, List<ItemDto> items) {
        this.id = id;
        this.idClient = idClient;
        this.totalValue = totalValue;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
