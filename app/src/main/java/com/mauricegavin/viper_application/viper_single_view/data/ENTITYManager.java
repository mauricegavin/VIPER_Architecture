package com.mauricegavin.viper_application.viper_single_view.data;

import com.mauricegavin.viper_application.viper_single_view.data.entities.ENTITY;

import rx.Observable;

/**
 * Created by maurice on 04/10/2016.
 */
public interface ENTITYManager {
    Observable<ENTITY> createENTITY(String paymentId);
}
