package com.mauricegavin.viper_application.viper_single_view.ui.router;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.mauricegavin.viper_application.common.ui.router.BaseRouter;
import com.mauricegavin.viper_application.viper_recycler_view.ui.navigation.Y_VIPERIntentHelper;

import javax.inject.Inject;

/**
 * Created by maurice on 22/11/2016.
 */
public class VIPERRouter extends BaseRouter {

    @Inject
    public VIPERRouter(Activity activity) {
        super(activity);
    }

    /**
     * Builds an Intent for starting the CheckoutActivity.
     */
    public void navigateToY_VIPERActivity(String param1) {
        Bundle options = new Bundle();
        Intent launchingIntent = Y_VIPERIntentHelper.getLaunchingIntent(activity, param1);
        activity.startActivity(launchingIntent, options);
    }

    /**
     * Finish the VIPERActivity and set a result Intent to be captured by onActivityResult()
     */
    public void returnResult(boolean isSuccessful) {
        Intent resultIntent = VIPERIntentHelper.getResultIntent();
        activity.setResult(getResultCode(isSuccessful), resultIntent);
        activity.finish();
    }
}
