package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;

@TargetApi(11)
public final class zzcpr extends zzcps {
    public zzcpr(zzcop zzcop, zzbay zzbay, boolean z11) {
        super(zzcop, zzbay, z11);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzM(webView, str, (Map<String, String>) null);
    }
}
