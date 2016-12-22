package com.mauricegavin.viper_application.viper_single_view.domain;

import com.mauricegavin.viper_application.common.domain.interactor.BaseInteractorInput;

/**
 * Created by maurice on 22/11/2016.
 * Interface declares the contract for data flow from the ViewModel to the Presenter
 */
public interface VIPERInteractorInput extends BaseInteractorInput<VIPERInteractorOutput> {
    void acceptedTerms();
    /**
     * Result can be captured by implementing VIPERInteractorOutput.loadedVIPERUrl()
     */
    void loadVIPERDisplayModel();
}