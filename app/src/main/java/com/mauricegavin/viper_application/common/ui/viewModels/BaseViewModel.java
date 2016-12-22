package com.mauricegavin.viper_application.common.ui.viewModels;

import android.databinding.BaseObservable;

import com.mauricegavin.viper_application.common.ui.displayModel.DisplayModel;
import com.mauricegavin.viper_application.common.ui.presenter.BasePresenterInput;
import com.mauricegavin.viper_application.common.ui.presenter.BasePresenterOutput;

/**
 * Created by maurice on 16/12/2016.
 */
public abstract class BaseViewModel<DisplayModelT extends DisplayModel,
        PresenterInputT extends BasePresenterInput>
        extends BaseObservable
        implements ViewModelInput<PresenterInputT>, BasePresenterOutput<DisplayModelT> {

    protected final String TAG = this.getClass().getName();

    protected DisplayModelT displayModel;
    protected PresenterInputT presenter;

    public BaseViewModel() {
    }

    /**
     * Presenter is linked through setter method. This cannot be done with the constructor as
     * the Presenter depends on the ViewModel to exist before it can be created. This would result
     * in a cyclic relationship in the DAG if Presenter were to be set in the constructor.
     * @param presenter
     */
    @Override
    public void setPresenter(PresenterInputT presenter) {
        this.presenter = presenter;
        // todo presenter.loadDisplayModel(); - need to load the display model at some stage!!
    }

    @Override
    public void destroy() {
        if(presenter != null) {
            presenter.destroy();
            presenter = null;
        }
        if(displayModel != null) {
            displayModel = null;
        }
        //todo dunno yet if this is the correct place for this - ToothpicApplication.getInstance().releaseTermsAcceptanceComponent();
    }
}
