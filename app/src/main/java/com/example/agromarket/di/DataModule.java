package com.example.agromarket.di;

import android.content.Context;

import androidx.room.Room;

import com.example.agromarket.analytics.AnalyticsAdapter;
import com.example.agromarket.analytics.GoogleAnalytics;
import com.example.agromarket.room.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn( SingletonComponent.class )
public class DataModule {

    @Provides
    @Singleton
    public AnalyticsAdapter provideAnalyticsAdapter() {
        return new GoogleAnalytics();
    }

    @Provides
    @Singleton
    public AppDatabase appDatabase(@ApplicationContext Context context)
    {
        AppDatabase db = Room.databaseBuilder(context,
                AppDatabase.class, "database-name").build();
        return db;
    }

    /*@Provides
    @Singleton
    public UserDao provideUserDao(AppDatabase appDatabase){
        return appDatabase.userDao();
    }*/
}
