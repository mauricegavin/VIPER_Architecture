package com.mauricegavin.viper_application.common.ui.viewModels;

/**
 * Created by maurice on 16/12/2016.
 */
public interface ViewModelInput<PresenterT> {
    void setPresenter(PresenterT presenter);
    void destroy();
}
