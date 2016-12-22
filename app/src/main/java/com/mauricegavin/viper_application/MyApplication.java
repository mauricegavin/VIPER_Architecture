package com.mauricegavin.viper_application;

import android.support.annotation.NonNull;
import android.support.multidex.MultiDexApplication;

import com.mauricegavin.viper_application.common.di.ApplicationModule;

// Don't forget to add it to your manifest by doing
// <application android:name="your.package.ToothpicApplication" ...
public class MyApplication extends MultiDexApplication {

    private static MyApplication instance;

    private ApplicationComponent appComponent;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;

        appComponent = prepareApplicationComponent().build();
        appComponent.inject(this);
    }

    @NonNull
    protected DaggerApplicationComponent.Builder prepareApplicationComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this));
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }
}