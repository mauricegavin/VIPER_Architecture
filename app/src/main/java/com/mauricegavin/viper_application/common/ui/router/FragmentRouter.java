package com.mauricegavin.viper_application.common.ui.router;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;

/**
 * Created by maurice on 04/08/2016.
 */
abstract public class FragmentRouter extends BaseRouter {

    protected int fragmentContainerId;
    protected FragmentManager fragmentManager;

    protected FragmentRouter(Activity activity,
                             @IdRes int fragmentContainerId,
                             FragmentManager fragmentManager) {
        super(activity);
        this.fragmentContainerId = fragmentContainerId;
        this.fragmentManager = fragmentManager;
    }

    /**
     * Call this function to show a Fragment in the Activity's container view
     * @param fragment
     * @param addToBackStack
     */
    protected void showFragment(Fragment fragment, boolean addToBackStack) {
        String fragmentName = fragment.getClass().getName();

        @SuppressLint("CommitTransaction")
        FragmentTransaction transaction = fragmentManager
                .beginTransaction()
                .replace(fragmentContainerId, fragment, fragmentName);

        if(addToBackStack) {
            transaction.addToBackStack(fragmentName);
        }

        transaction.commit();
        fragmentManager.executePendingTransactions();
    }

    protected void clearTopFragment() {
        activity.onBackPressed();
    }
}