package com.mauricegavin.viper_application.viper_single_view.ui.models;

import com.google.auto.value.AutoValue;
import com.mauricegavin.viper_application.common.ui.displayModel.ActivityDisplayModel;

/**
 * Created by maurice on 22/11/2016.
 * The model used to populate the View. It's values are never accessed directly by the View, rather
 * VIPERFragmentViewModel provides accessor methods this model.
 */
@AutoValue
public abstract class VIPERDisplayModel extends ActivityDisplayModel {

    public abstract String getToolbarTitle();
    public abstract String getParam1();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder toolbarTitle(String s);
        public abstract Builder param1(String s);
        public abstract VIPERDisplayModel build();
    }

    public static Builder builder() {
        return new AutoValue_VIPERDisplayModel.Builder();
    }

    public abstract Builder toBuilder();
}