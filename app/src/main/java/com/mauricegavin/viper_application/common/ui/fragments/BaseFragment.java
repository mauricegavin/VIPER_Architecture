package com.mauricegavin.viper_application.common.ui.fragments;

import android.app.Fragment;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mauricegavin.viper_application.ApplicationComponent;
import com.mauricegavin.viper_application.MyApplication;
import com.mauricegavin.viper_application.common.ui.presenter.BasePresenterInput;
import com.mauricegavin.viper_application.common.ui.viewModels.FragmentViewModel;

import javax.inject.Inject;

/**
 * Created by maurice on 14/12/2016.
 */
public abstract class BaseFragment<ViewModelT extends FragmentViewModel,
        PresenterT extends BasePresenterInput>
        extends Fragment {
    protected final String TAG = this.getClass().getName();

    @Inject
    public ViewModelT viewModel;
    @Inject
    protected PresenterT presenter;

    /**
     * Bind layout to the ViewModel.
     * @param inflater contains references to the view's objects
     * @param container
     * @param layoutId the resource id of the layout to be bound
     */
    protected abstract View bindView(LayoutInflater inflater,
                                     ViewGroup container,
                                     @LayoutRes int layoutId);

    protected ApplicationComponent getApplicationComponent() {
        return MyApplication.getInstance().getAppComponent();
    }
}