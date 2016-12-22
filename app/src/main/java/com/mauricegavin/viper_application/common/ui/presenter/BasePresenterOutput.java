package com.mauricegavin.viper_application.common.ui.presenter;

/**
 * Created by maurice on 24/08/2016.
 */
public interface BasePresenterOutput<DisplayModelT> {
    void loadedData(DisplayModelT displayModel);
}
