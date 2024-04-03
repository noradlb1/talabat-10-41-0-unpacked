package com.google.android.gms.internal.consent_sdk;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class zzbf extends WebViewClient {
    private final /* synthetic */ zzbe zza;

    private zzbf(zzbe zzbe) {
        this.zza = zzbe;
    }

    public final void onLoadResource(WebView webView, String str) {
        if (zzbe.zza(str)) {
            this.zza.zzb.zza(str);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        if (!this.zza.zzc) {
            zzbj unused = this.zza.zzb;
            boolean unused2 = this.zza.zzc = true;
        }
    }

    public final void onReceivedError(WebView webView, int i11, String str, String str2) {
        this.zza.zzb.zza(i11, str, str2);
    }

    @TargetApi(24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (!zzbe.zza(uri)) {
            return false;
        }
        this.zza.zzb.zza(uri);
        return true;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!zzbe.zza(str)) {
            return false;
        }
        this.zza.zzb.zza(str);
        return true;
    }
}
