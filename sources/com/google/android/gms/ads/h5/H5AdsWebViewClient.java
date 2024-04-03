package com.google.android.gms.ads.h5;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.internal.ads.zzbsk;
import com.google.android.gms.internal.ads.zzbsx;

@RequiresApi(api = 21)
public final class H5AdsWebViewClient extends zzbsk {
    private final zzbsx zza;

    public H5AdsWebViewClient(@RecentlyNonNull Context context, @RecentlyNonNull WebView webView) {
        this.zza = new zzbsx(context, webView);
    }

    public void clearAdObjects() {
        this.zza.zza();
    }

    @RecentlyNonNull
    public WebViewClient getDelegate() {
        return this.zza;
    }

    @RecentlyNullable
    public WebViewClient getDelegateWebViewClient() {
        return this.zza.getDelegate();
    }

    public void setDelegateWebViewClient(@Nullable WebViewClient webViewClient) {
        this.zza.zzb(webViewClient);
    }
}
