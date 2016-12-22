package com.mauricegavin.viper_application.common.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.mauricegavin.viper_application.common.data.local.ResourceProxy;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    Application application;

    public ApplicationModule(Application application) {
        application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    ResourceProxy provideResourceProxy() {
        return new ResourceProxy(application.getResources());
    }
}