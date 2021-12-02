package com.example.agromarket.di;

import com.example.agromarket.analytics.AnalyticsAdapter;
import com.example.agromarket.analytics.GoogleAnalytics;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn( SingletonComponent.class )
public class DataModule {

    @Provides
    @Singleton
    public AnalyticsAdapter provideAnalyticsAdapter() {
        return new GoogleAnalytics();
    }

}
