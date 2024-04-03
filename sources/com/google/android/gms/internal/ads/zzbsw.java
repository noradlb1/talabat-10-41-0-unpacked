package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;

public final /* synthetic */ class zzbsw implements OnH5AdsEventListener {
    public final /* synthetic */ WebView zza;

    public /* synthetic */ zzbsw(WebView webView) {
        this.zza = webView;
    }

    public final void onH5AdsEvent(String str) {
        WebView webView = this.zza;
        int i11 = zzbsx.zza;
        webView.evaluateJavascript(str, (ValueCallback) null);
    }
}
