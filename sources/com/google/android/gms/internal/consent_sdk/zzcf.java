package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.ThreadFactory;

final /* synthetic */ class zzcf implements ThreadFactory {
    private final zzcg zza;
    private final String zzb;

    public zzcf(zzcg zzcg, String str) {
        this.zza = zzcg;
        this.zzb = str;
    }

    public final Thread newThread(Runnable runnable) {
        return this.zza.zza(this.zzb, runnable);
    }
}
