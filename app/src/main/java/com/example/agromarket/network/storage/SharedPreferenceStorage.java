package com.example.agromarket.network.storage;

import android.content.SharedPreferences;

public class SharedPreferenceStorage implements Storage{

    private final String TOKEN_KEY = "Token_key";
    private final SharedPreferences sharedPreferences;

    public SharedPreferenceStorage(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void saveToken(String token) {
        sharedPreferences.edit().putString(TOKEN_KEY, token).apply();
    }

    @Override
    public String getToken() {
        return sharedPreferences.getString(TOKEN_KEY,"");
    }
}
