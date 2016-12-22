package com.mauricegavin.viper_application.common.ui.viewModels;

import com.mauricegavin.viper_application.common.ui.displayModel.DisplayModel;
import com.mauricegavin.viper_application.common.ui.presenter.BasePresenterInput;

/**
 * Created by maurice on 16/12/2016.
 */
abstract public class FragmentViewModel<DisplayModelT extends DisplayModel, PresenterT extends BasePresenterInput>
        extends BaseViewModel<DisplayModelT, PresenterT>
        implements ViewModelInput<PresenterT> {

    public FragmentViewModel() {
        super();
    }

    //todo public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

}
