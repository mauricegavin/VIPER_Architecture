package com.mauricegavin.viper_application.viper_recycler_view.ui.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by maurice on 20/12/2016.
 */
public class Y_VIPERIntentHelper {
    private static final String Y_VIPER_ACTIVITY_PARAM_USER_ID = "user_id_param_from_auto_generated_code";

    private Y_VIPERIntentHelper() {
    }

    // Activity Intents //

    /**
     * Builds an Intent for starting the Y_VIPERActivity.
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public static Intent getLaunchingIntent(Context context, String param1) {
        /*Intent intent = new Intent(context, Y_VIPERActivity.class);
        intent.putExtra(Y_VIPER_ACTIVITY_PARAM_USER_ID, param1);
        return intent;*/
        return null;
    }

    /**
     * Builds an Intent returned by the Y_VIPERActivity.
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public static Intent getResultIntent() {
        Intent intent = new Intent();
        return intent;
    }

    // Extra Accessors //

    @Nullable
    public String getParam1(@NonNull Bundle bundle) {
        return bundle.getString(Y_VIPER_ACTIVITY_PARAM_USER_ID);
    }
}
