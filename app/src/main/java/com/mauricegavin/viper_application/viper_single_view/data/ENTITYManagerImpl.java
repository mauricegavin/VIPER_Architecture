package com.mauricegavin.viper_application.viper_single_view.data;

import android.support.annotation.NonNull;

import com.mauricegavin.viper_application.viper_single_view.data.entities.ENTITY;
import com.mauricegavin.viper_application.viper_single_view.data.api.ENTITYService;
import com.mauricegavin.viper_application.viper_single_view.data.local.ENTITYPersistenceService;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by maurice on 03/10/2016.
 *
 * Data Manager for ENTITYs resources
 */
public class ENTITYManagerImpl implements ENTITYManager {

    private final ENTITYService ENTITYService;
    private final ENTITYPersistenceService ENTITYPersistenceService;

    public ENTITYManagerImpl(ENTITYService ENTITYService, ENTITYPersistenceService ENTITYPersistenceService) {
        this.ENTITYService = ENTITYService;
        this.ENTITYPersistenceService = ENTITYPersistenceService;
    }

    @Override
    public Observable<ENTITY> createENTITY(String paymentId) {
        Observable<ENTITY> network = ENTITYService.createENTITY(paymentId);
        return network.flatMap(writeENTITYToDisk());
    }

    /**
     * Writes a ENTITY to disk
     * @return
     */
    @NonNull
    private Func1<ENTITY, Observable<ENTITY>> writeENTITYToDisk() {
        return ENTITYPersistenceService::saveENTITY;
    }
}
