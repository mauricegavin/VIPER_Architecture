package com.mauricegavin.viper_application.common.ui.viewModels;

import android.support.annotation.NonNull;

import com.mauricegavin.viper_application.common.ui.activities.ActivityResult;
import com.mauricegavin.viper_application.common.ui.displayModel.ActivityDisplayModel;
import com.mauricegavin.viper_application.common.ui.presenter.BasePresenterInput;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by maurice on 15/12/2016.
 */
abstract public class ActivityViewModel<ActivityDisplayModelT extends ActivityDisplayModel,
        PresenterInputT extends BasePresenterInput>
        extends BaseViewModel<ActivityDisplayModelT, PresenterInputT> {

    private final PublishSubject<ActivityResult> activityResult = PublishSubject.create();

    public ActivityViewModel() {
        super();
    }

    /**
     * Takes activity result data from the activity.
     */
    public void activityResult(final @NonNull ActivityResult activityResult) {
        this.activityResult.onNext(activityResult);
    }

    // Accessors

    @NonNull protected Observable<ActivityResult> activityResult() {
        return activityResult;
    }
}

