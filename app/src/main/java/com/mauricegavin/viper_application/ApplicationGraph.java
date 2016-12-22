package com.mauricegavin.viper_application;

import com.mauricegavin.viper_application.common.di.ActivityModule;
import com.mauricegavin.viper_application.viper_single_view.di.VIPERComponent;
import com.mauricegavin.viper_application.viper_single_view.di.VIPERModule;
import com.mauricegavin.viper_application.viper_single_view.di.VIPERPlugin;

/**
 * Created by maurice on 19/12/2016.
 */
public interface ApplicationGraph {

    void inject(MyApplication target);

    VIPERPlugin VIPERPlugin();
    VIPERComponent plus(ActivityModule activityModule, VIPERModule module);
}
