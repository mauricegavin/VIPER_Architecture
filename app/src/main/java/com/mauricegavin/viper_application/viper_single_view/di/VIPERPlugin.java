package com.mauricegavin.viper_application.viper_single_view.di;

import com.android.annotations.NonNull;
import com.mauricegavin.viper_application.ApplicationComponent;
import com.mauricegavin.viper_application.common.di.ActivityModule;
import com.mauricegavin.viper_application.viper_single_view.ui.VIPERActivity;

import javax.inject.Inject;

/**
 * Created by maurice on 19/12/2016.
 */
public class VIPERPlugin {

    private final ApplicationComponent appComponent;
    private VIPERComponent VIPERComponent;

    @Inject
    public VIPERPlugin(ApplicationComponent appComponent) {
        this.appComponent = appComponent;
    }

    @NonNull
    public VIPERComponent build(VIPERActivity activity) {
        VIPERComponent = appComponent.plus(new ActivityModule(activity), new VIPERModule());
        return VIPERComponent;
    }

    public void release() {
        VIPERComponent = null;
    }

    @NonNull
    public VIPERComponent get() {
        return VIPERComponent;
    }
}
