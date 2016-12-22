package com.mauricegavin.viper_application.viper_single_view.ui.presenters;

import com.mauricegavin.viper_application.common.ui.presenter.BasePresenter;
import com.mauricegavin.viper_application.viper_single_view.domain.VIPERInteractorInput;
import com.mauricegavin.viper_application.viper_single_view.domain.VIPERInteractorOutput;
import com.mauricegavin.viper_application.viper_single_view.ui.models.VIPERDisplayModel;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;
import timber.log.Timber;

/**
 * Created by maurice on 24/08/2016.
 * Implementation of the VIPERPresenterInput and the VIPERInteractorOutput.
 * Responsible for encapsulating the presentation logic. It is reacts to input events from the
 * ViewModel's output events coming from the Interactor. It's own VIPERPresenterOutput
 * interface is implemented by the ViewModel.
 */
public final class VIPERPresenter extends BasePresenter<VIPERInteractorInput, VIPERPresenterOutput>
        implements VIPERPresenterInput, VIPERInteractorOutput {

    private PublishSubject<Boolean> publishSubject;

    @Inject
    public VIPERPresenter(VIPERInteractorInput interactor,
                                   VIPERPresenterOutput viewModel) {
        super(interactor, viewModel);

        registerClickEventListener(interactor);
        loadVIPERDisplayModel();
    }

    private void loadVIPERDisplayModel() {
        interactor.loadVIPERDisplayModel();
    }

    // VIPERInteractorOutput Implementation

    @Override
    public void loadedData(VIPERDisplayModel displayModel) {
        viewModel.loadedData(displayModel);
    }

    @Override
    public void interactorOutputEvent() {
        //navigator.navigateToY_VIPERActivity("");
    }
    
    // VIPERPresenterInput Implementation

    private void registerClickEventListener(VIPERInteractorInput interactor) {
        publishSubject = PublishSubject.create();

        subscriptions.add(
                publishSubject.throttleFirst(VIEW_CLICK_DEBOUNCE_TIMEOUT, TimeUnit.MILLISECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                b -> interactor.acceptedTerms(),
                                e -> Timber.e(e, "Error clicking the accept terms button.")
                        )
        );
    }

    @Override
    public void someInputAction() {
        publishSubject.onNext(true); // send an event to publishSubject
    }
}