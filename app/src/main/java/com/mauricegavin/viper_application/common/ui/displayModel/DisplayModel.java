package com.mauricegavin.viper_application.common.ui.displayModel;

import android.os.Parcelable;

/**
 * Created by maurice on 09/08/2016.
 * <p>
 * Base class for POJOs used to populate the UI.
 * A class which extends DisplayModel should never be bound to directly to the view, it is either
 * abstracted through the ViewModel.
 */
public abstract class DisplayModel implements Parcelable {
}
