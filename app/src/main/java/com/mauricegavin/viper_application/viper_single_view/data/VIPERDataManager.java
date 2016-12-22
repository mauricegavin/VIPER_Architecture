package com.mauricegavin.viper_application.viper_single_view.data;

import com.mauricegavin.viper_application.viper_single_view.domain.VIPERItem;

import rx.Observable;

/**
 * Created by maurice on 28/09/2016.
 * <p>
 * Responsible for providing data for the VIPER feature. The VIPERDataManager
 * Interface defines the methods that can be used by the VIPERInteractor.
 */
public interface VIPERDataManager {
    Observable<VIPERItem> getVIPERItem(String paymentId);
}