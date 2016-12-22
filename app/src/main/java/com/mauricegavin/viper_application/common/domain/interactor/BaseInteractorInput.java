package com.mauricegavin.viper_application.common.domain.interactor;

/**
 * Created by maurice on 24/08/2016.
 */
public interface BaseInteractorInput<PresenterT> {
    void setInteractorOutput(PresenterT presenter);
    void destroy();
}
