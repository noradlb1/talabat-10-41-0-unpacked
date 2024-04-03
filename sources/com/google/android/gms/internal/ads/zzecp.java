package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public final class zzecp implements zzgpr<ApplicationInfo> {
    private final zzgqe<Context> zza;

    public zzecp(zzgqe<Context> zzgqe) {
        this.zza = zzgqe;
    }

    /* renamed from: zza */
    public final ApplicationInfo zzb() {
        ApplicationInfo applicationInfo = this.zza.zzb().getApplicationInfo();
        zzgpz.zzb(applicationInfo);
        return applicationInfo;
    }
}
