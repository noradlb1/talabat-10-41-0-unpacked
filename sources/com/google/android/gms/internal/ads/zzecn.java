package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.TimeUnit;

public final class zzecn implements zzgpr<zzfxa<String>> {
    private final zzgqe<zzfie> zza;
    private final zzgqe<Context> zzb;

    public zzecn(zzgqe<zzfie> zzgqe, zzgqe<Context> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        CookieManager zzl = zzt.zzq().zzl(this.zzb.zzb());
        zzfhy zzfhy = zzfhy.WEBVIEW_COOKIE;
        return zzfho.zza(new zzeck(zzl), zzfhy, this.zza.zzb()).zzi(1, TimeUnit.SECONDS).zzc(Exception.class, new zzfhq(zzecj.zza)).zza();
    }
}
