package com.mauricegavin.viper_application.common.domain.interactor;

import com.mauricegavin.viper_application.common.ui.router.BaseRouter;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by maurice on 26/08/2016.
 */
public abstract class BaseInteractor<DataManagerT,
        RouterT extends BaseRouter,
        PresenterT extends BaseInteractorOutput>
        implements BaseInteractorInput<PresenterT> {

    protected final String TAG = getClass().getName();

    protected final DataManagerT dataManager;
    protected final RouterT navigator;
    protected PresenterT presenter;

    protected CompositeSubscription subscriptions = new CompositeSubscription();

    protected BaseInteractor(DataManagerT dataManager, RouterT navigator) {
        this.dataManager = dataManager;
        this.navigator = navigator;
    }

    @Override
    public void setInteractorOutput(PresenterT presenter) {
        this.presenter = presenter;
    }

    @Override
    public void destroy() {
        if (subscriptions != null) {
            subscriptions.clear();
            subscriptions = null;
        }
        presenter = null;
    }

    protected void handleThrowable(Throwable e) {
        handleThrowable(e, null);
    }

    protected void handleThrowable(Throwable e, String additionalLogMessage) {
        //ExceptionHandler.logError(e, additionalLogMessage);
        //UserNotificationModel userNotificationModel = ExceptionHandler.prepareUserNotification(e);
        //todo this will be turned back on for error handling presenter.showNotification(userNotificationModel);
    }
}
