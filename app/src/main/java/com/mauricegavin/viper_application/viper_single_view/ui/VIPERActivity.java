package com.mauricegavin.viper_application.viper_single_view.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.mauricegavin.viper_application.MyApplication;
import com.mauricegavin.viper_application.R;
import com.mauricegavin.viper_application.common.ui.activities.BaseActivity;
import com.mauricegavin.viper_application.databinding.ActivityViperBinding;
import com.mauricegavin.viper_application.viper_single_view.ui.presenters.VIPERPresenterInput;
import com.mauricegavin.viper_application.viper_single_view.ui.viewModels.VIPERActivityViewModel;

public final class VIPERActivity extends BaseActivity<VIPERActivityViewModel, VIPERPresenterInput> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getApplicationComponent()
                .VIPERPlugin().build(this)
                .inject(this);

        bindView(this, R.layout.activity_viper);
    }

    @Override
    protected void bindView(AppCompatActivity activity, @LayoutRes int layoutId) {
        ActivityViperBinding binding =
                DataBindingUtil.setContentView(this, layoutId);
        binding.setViewModel(viewModel);
        activity.setSupportActionBar(binding.VIPERToolbar);

        //todo attempt to do this in xml with app:setDisplayHomeAsUpEnabled (or if that's not supported use a null exception wrapped binding adapter)
        ActionBar supportActionBar = activity.getSupportActionBar();
        if (supportActionBar != null) {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onDestroy() {
        MyApplication.getInstance().getAppComponent().VIPERPlugin().release();
        super.onDestroy();
    }
}