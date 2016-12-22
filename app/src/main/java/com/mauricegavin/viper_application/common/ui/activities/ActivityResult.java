package com.mauricegavin.viper_application.common.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

/**
 * Source: https://github.com/kickstarter/android-oss/blob/888a3746835835016fc1a1bb32d8e2a90b8bffce/app/src/main/java/com/kickstarter/ui/data/ActivityResult.java
 * Released under http://www.apache.org/licenses/LICENSE-2.0
 */
@AutoValue
public abstract class ActivityResult implements Parcelable {
    public abstract int requestCode();
    public abstract int resultCode();
    public abstract @Nullable Intent intent();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder requestCode(int requestCode);
        public abstract Builder resultCode(int resultCode);
        public abstract Builder intent(Intent intent);
        public abstract ActivityResult build();
    }

    @NonNull
    public static ActivityResult create(final int requestCode, final int resultCode, final @Nullable Intent intent) {
        return ActivityResult.builder()
                .requestCode(requestCode)
                .resultCode(resultCode)
                .intent(intent)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_ActivityResult.Builder();
    }

    public abstract Builder toBuilder();

    public boolean isCanceled() {
        return resultCode() == Activity.RESULT_CANCELED;
    }

    public boolean isOk() {
        return resultCode() == Activity.RESULT_OK;
    }

    public boolean isRequestCode(final int v) {
        return requestCode() == v;
    }
}
