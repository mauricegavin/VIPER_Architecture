package com.mauricegavin.viper_application;

import com.mauricegavin.viper_application.common.di.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by maurice on 19/12/2016.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent extends ApplicationGraph {
}
