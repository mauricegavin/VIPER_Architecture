package com.mauricegavin.viper_application.common.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mauricegavin.viper_application.ApplicationComponent;
import com.mauricegavin.viper_application.MyApplication;
import com.mauricegavin.viper_application.common.ui.presenter.BasePresenterInput;
import com.mauricegavin.viper_application.common.ui.viewModels.ActivityViewModel;

import javax.inject.Inject;

/**
 * Created by maurice on 16/12/2016.
 */
public abstract class BaseActivity<ViewModelT extends ActivityViewModel,
        PresenterInputT extends BasePresenterInput>
        extends AppCompatActivity {
    protected final String TAG = this.getClass().getName();

    @Inject
    public ViewModelT viewModel;
    @Inject
    public PresenterInputT presenter;

    @CallSuper
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        viewModel.activityResult(ActivityResult.create(requestCode, resultCode, intent));
    }

    /**
     * Bind layout to the ViewModel
     * @param layoutId the resource id of the layout to be bound
     */
    protected abstract void bindView(AppCompatActivity activity, @LayoutRes int layoutId);

    @CallSuper
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                back();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        back();
    }

    private void back() {
        setResultCancelled();
        super.onBackPressed();
    }

    private void setResultCancelled() {
        setResult(Activity.RESULT_CANCELED, new Intent());
    }

    protected ApplicationComponent getApplicationComponent() {
        return MyApplication.getInstance().getAppComponent();
    }
}