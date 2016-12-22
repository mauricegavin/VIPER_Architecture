package com.mauricegavin.viper_application.viper_single_view.ui.viewModels;

import android.databinding.Bindable;

import com.mauricegavin.viper_application.common.ui.viewModels.ActivityViewModel;
import com.mauricegavin.viper_application.viper_single_view.ui.models.VIPERDisplayModel;
import com.mauricegavin.viper_application.viper_single_view.ui.presenters.VIPERPresenterInput;
import com.mauricegavin.viper_application.viper_single_view.ui.presenters.VIPERPresenterOutput;

import javax.inject.Inject;

/**
 * Created by maurice on 05/12/15.
 */
public class VIPERActivityViewModel
        extends ActivityViewModel<VIPERDisplayModel, VIPERPresenterInput>
        implements VIPERPresenterOutput {

    @Inject
    public VIPERActivityViewModel() {
        super();
    }

    // View Bindings
    @Bindable
    public String getToolbarTitle() {
        return displayModel.getToolbarTitle();
    }

    // VIPERPresenterOutput Implementation

    @Override
    public void loadedData(VIPERDisplayModel displayModel) {

    }
}