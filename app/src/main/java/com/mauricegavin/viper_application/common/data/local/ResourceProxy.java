package com.mauricegavin.viper_application.common.data.local;

import android.content.res.Resources;
import android.support.annotation.BoolRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringRes;

/**
 * Created by maurice on 20/12/2016.
 */
public class ResourceProxy {
    private final Resources resources;

    public ResourceProxy(Resources resources) {
        this.resources = resources;
    }

    public String getString(@StringRes int id) {
        return resources.getString(id);
    }

    public boolean getBoolean(@BoolRes int id) {
        return resources.getBoolean(id);
    }

    public int getInt(@IntegerRes int id) {
        return resources.getInteger(id);
    }
}
