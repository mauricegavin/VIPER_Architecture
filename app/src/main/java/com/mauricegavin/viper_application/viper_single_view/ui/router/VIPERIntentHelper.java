package com.mauricegavin.viper_application.viper_single_view.ui.router;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mauricegavin.viper_application.viper_single_view.ui.VIPERActivity;

/**
 * Created by maurice on 22/11/2016.
 */
final public class VIPERIntentHelper {

    private static final String VIPER_ACTIVITY_PARAM_USER_ID = "user_id_param_from_auto_generated_code";

    private VIPERIntentHelper() {
    }

    // Activity Intents //

    /**
     * Builds an Intent for starting the VIPERActivity.
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public static Intent getLaunchingIntent(Context context, String param1) {
        Intent intent = new Intent(context, VIPERActivity.class);
        intent.putExtra(VIPER_ACTIVITY_PARAM_USER_ID, param1);
        return intent;
    }

    /**
     * Builds an Intent returned by the VIPERActivity.
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public static Intent getResultIntent() {
        Intent intent = new Intent();
        return intent;
    }

    // Extra Accessors //

    @Nullable
    public String getParam1(@NonNull Bundle bundle) {
        return bundle.getString(VIPER_ACTIVITY_PARAM_USER_ID);
    }
}