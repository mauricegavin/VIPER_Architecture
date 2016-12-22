package com.mauricegavin.viper_application.viper_single_view.domain;

import android.support.annotation.NonNull;

import com.mauricegavin.viper_application.common.domain.interactor.BaseInteractor;
import com.mauricegavin.viper_application.viper_single_view.data.VIPERDataManager;
import com.mauricegavin.viper_application.viper_single_view.ui.models.VIPERDisplayModel;
import com.mauricegavin.viper_application.viper_single_view.ui.router.VIPERRouter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by maurice on 22/11/2016.
 * <p>
 * Responsible for encapsulating the presentation logic. It reacts to input events through it's
 * VIPERInteractorInput interface which is called by the Presenter.
 * The Presenter implements the VIPERInteractorOutput interface to capture the
 * VIPERInteractor's responses.
 */
public final class VIPERInteractor
        extends BaseInteractor<VIPERDataManager, VIPERRouter, VIPERInteractorOutput>
        implements VIPERInteractorInput {

    @Inject
    public VIPERInteractor(VIPERDataManager dataManager, VIPERRouter navigator) {
        super(dataManager, navigator);
    }

    // VIPERInteractorInput Implementation

    @Override
    public void acceptedTerms() {
        presenter.interactorOutputEvent();
    }

    @Override
    public void loadVIPERDisplayModel() {
        subscriptions.add(dataManager.getVIPERItem("")
                .subscribeOn(Schedulers.io())
                .map(this::convertToDisplayModel)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getVIPERDataSubscriber()));
    }

    private VIPERDisplayModel convertToDisplayModel(VIPERItem item) {
        return null; //todo new VIPERDisplayModel(item);
    }

    @NonNull
    private Subscriber<VIPERDisplayModel> getVIPERDataSubscriber() {
        return new Subscriber<VIPERDisplayModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Timber.e(e, "Error fetching VIPERDisplayModel from " +
                        "VIPERDataManagerImpl.");
            }

            @Override
            public void onNext(VIPERDisplayModel displayModel) {
                handleDisplayModel(displayModel);
            }
        };
    }

    private void handleDisplayModel(VIPERDisplayModel displayModel) {
        presenter.loadedData(displayModel);
    }

}