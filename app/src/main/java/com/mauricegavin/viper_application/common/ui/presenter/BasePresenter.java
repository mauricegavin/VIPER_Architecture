package com.mauricegavin.viper_application.common.ui.presenter;

import com.mauricegavin.viper_application.common.domain.interactor.BaseInteractorInput;
import com.mauricegavin.viper_application.common.domain.interactor.BaseInteractorOutput;

import rx.subscriptions.CompositeSubscription;

/**
 * Where T is the Interactor's type.
 * Created by maurice on 24/08/2016.
 */
public abstract class BasePresenter<
        InteractorT extends BaseInteractorInput<? extends BaseInteractorOutput>,
        ViewModelT extends BasePresenterOutput>
        implements BasePresenterInput {
    protected final String TAG = getClass().getName();
    protected final int VIEW_CLICK_DEBOUNCE_TIMEOUT = 1600; // [milliseconds]

    protected CompositeSubscription subscriptions = new CompositeSubscription();

    protected final InteractorT interactor;
    protected final ViewModelT viewModel;

    protected BasePresenter(InteractorT interactor, ViewModelT viewModel) {
        this.interactor = interactor;
        this.viewModel = viewModel;
    }

    @Override
    public void destroy() {
        if (subscriptions != null) {
            subscriptions.clear();
            subscriptions = null;
        }
        interactor.destroy();
    }
}
