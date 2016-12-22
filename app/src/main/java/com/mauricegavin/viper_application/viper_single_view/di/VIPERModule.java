package com.mauricegavin.viper_application.viper_single_view.di;

import com.mauricegavin.viper_application.common.data.local.ResourceProxy;
import com.mauricegavin.viper_application.viper_single_view.data.VIPERDataManager;
import com.mauricegavin.viper_application.viper_single_view.domain.VIPERInteractor;
import com.mauricegavin.viper_application.viper_single_view.ui.presenters.VIPERPresenter;
import com.mauricegavin.viper_application.viper_single_view.ui.presenters.VIPERPresenterInput;
import com.mauricegavin.viper_application.viper_single_view.ui.viewModels.VIPERActivityViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by maurice on 24/08/2016.
 * Used to provide dependencies for VIPER class injection.
 */
@Module
public class VIPERModule {

    public VIPERModule() {
    }

    /**
     * Required to inject Interactor with an implementation of DataManager.
     * @param resourceProxy
     * @return
     */
    @VIPERScope
    @Provides
    VIPERDataManager provideVIPERDataManagerInput(ResourceProxy resourceProxy) {
        return null; //todo new VIPERDataManagerImpl(resourceProxy, ENTITYManagerImpl); //todo - needs to import ENTITYModule somewhere!?
    }

    @VIPERScope
    @Provides
    VIPERPresenter provideVIPERPresenter(
            VIPERInteractor interactor,
            VIPERActivityViewModel viewModel) {

        VIPERPresenter presenter
                = new VIPERPresenter(interactor, viewModel);

        interactor.setInteractorOutput(presenter);
        viewModel.setPresenter(presenter);

        return presenter;
    }

    @VIPERScope
    @Provides
    VIPERPresenterInput provideVIPERPresenterInput(VIPERPresenter presenter) {
        return presenter;
    }
}