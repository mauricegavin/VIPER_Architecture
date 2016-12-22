package com.mauricegavin.viper_application.common.ui.router;

import android.app.Activity;

/**
 * Created by maurice on 04/08/2016.
 */
abstract public class BaseRouter {

    protected Activity activity;

    public BaseRouter(Activity activity) {
        this.activity = activity;
    }

    protected int getResultCode(boolean isSuccessful) {
        return (isSuccessful) ? Activity.RESULT_OK : Activity.RESULT_CANCELED;
    }

    // todo potentially put something here that uses NotificationManager to post notifications?
    /*protected void postNotification(int notificationId, NotificationCompat.Builder builder) {
        NotificationManager notificationManager =
                (NotificationManager) activity.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(
                notificationId,
                builder.build());
    }*/
}