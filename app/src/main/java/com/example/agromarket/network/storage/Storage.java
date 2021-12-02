package com.example.agromarket.network.storage;

public interface Storage {
    void saveToken(String token);
    String getToken();
}
