package com.mauricegavin.viper_application.viper_single_view.di;

import com.mauricegavin.viper_application.common.di.ActivityModule;

import dagger.Subcomponent;

/**
 * Created by maurice on 22/11/2016.
 * <p>
 * VIPERComponent is part of the app's Directed acyclic graph. It is responsible for
 * injecting classes related to VIPER.
 */
@VIPERScope
@Subcomponent(modules = {ActivityModule.class, VIPERModule.class})
public interface VIPERComponent extends VIPERGraph {
}

