package com.google.android.gms.internal.ads;

import android.webkit.CookieManager;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzeck implements Callable {
    public final /* synthetic */ CookieManager zza;

    public /* synthetic */ zzeck(CookieManager cookieManager) {
        this.zza = cookieManager;
    }

    public final Object call() {
        CookieManager cookieManager = this.zza;
        if (cookieManager == null) {
            return "";
        }
        return cookieManager.getCookie((String) zzbgq.zzc().zzb(zzblj.zzaC));
    }
}
