package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.h5.H5AdsRequestHandler;

@RequiresApi(api = 21)
public final class zzbsx extends zzbsk {
    public static final /* synthetic */ int zza = 0;
    @Nullable
    private WebViewClient zzb;
    private final H5AdsRequestHandler zzc;
    private final WebView zzd;

    public zzbsx(Context context, WebView webView) {
        context.getClass();
        webView.getClass();
        zzfqg.zze(webView.getSettings().getJavaScriptEnabled(), "JavaScript must be enabled on the WebView.");
        this.zzd = webView;
        this.zzc = new H5AdsRequestHandler(context, new zzbsw(webView));
    }

    private final boolean zzc(WebView webView) {
        if (this.zzd.equals(webView)) {
            return true;
        }
        zzciz.zzg("H5AdsWebViewClient must be attached to the same WebVew which was passed in the constructor.");
        return false;
    }

    @Nullable
    public final WebViewClient getDelegate() {
        return this.zzb;
    }

    public final void onLoadResource(WebView webView, String str) {
        if (zzc(webView) && !this.zzc.handleH5AdsRequest(str)) {
            super.onLoadResource(webView, str);
        }
    }

    @RequiresApi(api = 24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (!zzc(this.zzd)) {
            return false;
        }
        if (this.zzc.handleH5AdsRequest(webResourceRequest.getUrl().toString())) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public final void zza() {
        this.zzc.clearAdObjects();
    }

    public final void zzb(@Nullable WebViewClient webViewClient) {
        boolean z11;
        if (webViewClient != this) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfqg.zze(z11, "Delegate cannot be itself.");
        this.zzb = webViewClient;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!zzc(webView)) {
            return false;
        }
        if (this.zzc.handleH5AdsRequest(str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
