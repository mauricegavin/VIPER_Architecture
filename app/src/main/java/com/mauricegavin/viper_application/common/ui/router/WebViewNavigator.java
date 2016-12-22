package com.mauricegavin.viper_application.common.ui.router;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by maurice on 24/08/2016.
 */
public class WebViewNavigator {

    private final WebView webView;

    public WebViewNavigator(WebView webView) {
        this.webView = webView;
        webView.setOnKeyListener(getWebViewBackListener());
    }

    /**
     * Method which provides a listener that overrides the back button to first navigate backwards
     * through the page stack before falling back on it's normal behaviour.
     */
    private View.OnKeyListener getWebViewBackListener() {
        return new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                return false;
            }
        };
    }
}
