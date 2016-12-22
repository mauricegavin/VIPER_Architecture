package com.mauricegavin.viper_application.viper_single_view.domain;

import com.mauricegavin.viper_application.common.domain.interactor.BaseInteractorOutput;
import com.mauricegavin.viper_application.viper_single_view.ui.models.VIPERDisplayModel;

/**
 * Created by maurice on 22/11/2016.
 * Interface declares the contract for data flow from the Interactor to the Presenter
 */
public interface VIPERInteractorOutput extends BaseInteractorOutput {
    void loadedData(VIPERDisplayModel displayModel);
    void interactorOutputEvent();
}
