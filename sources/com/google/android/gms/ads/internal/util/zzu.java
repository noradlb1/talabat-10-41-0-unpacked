package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.WebSettings;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzu implements Callable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ WebSettings zzb;

    public /* synthetic */ zzu(Context context, WebSettings webSettings) {
        this.zza = context;
        this.zzb = webSettings;
    }

    public final Object call() {
        Context context = this.zza;
        WebSettings webSettings = this.zzb;
        if (context.getCacheDir() != null) {
            webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
            webSettings.setAppCacheMaxSize(0);
            webSettings.setAppCacheEnabled(true);
        }
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzaz)).booleanValue()) {
            webSettings.setTextZoom(100);
        }
        webSettings.setAllowContentAccess(false);
        return Boolean.TRUE;
    }
}
