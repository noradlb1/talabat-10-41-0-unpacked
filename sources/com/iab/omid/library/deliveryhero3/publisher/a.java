package com.iab.omid.library.deliveryhero3.publisher;

import android.annotation.SuppressLint;
import android.webkit.WebView;

public class a extends AdSessionStatePublisher {
    @SuppressLint({"SetJavaScriptEnabled"})
    public a(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        b(webView);
    }
}
