package com.mauricegavin.viper_application.common.ui.displayModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

/**
 * Created by maurice on 09/08/2016.
 * <p>
 * A base class which can be extended by DisplayModels that are used in adapters.
 * It provides the same level of abstraction from the DisplayModel that is usually provided by
 * the ViewModel. (i.e. the DisplayModelHolder provides accessors and listeners for the underlying
 * DisplayModel instead of the View directly accessing the DisplayModel itself).
 */
public abstract class DisplayModelHolder<T extends DisplayModel> extends BaseObservable {

    protected final T displayModel;
    protected final Callback callback;

    public DisplayModelHolder(T displayModel, Callback callback) {
        this.displayModel = displayModel;
        this.callback = callback;
    }

    @Bindable
    public abstract View.OnClickListener getClickListener();

    protected interface Callback<T> {
        void onItemClicked(T displayModel);
    }
}
