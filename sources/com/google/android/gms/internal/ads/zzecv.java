package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzecv implements zzgpr<String> {
    private final zzgqe<Context> zza;

    public zzecv(zzgqe<Context> zzgqe) {
        this.zza = zzgqe;
    }

    /* renamed from: zza */
    public final String zzb() {
        String packageName = ((zzffh) this.zza).zza().getPackageName();
        zzgpz.zzb(packageName);
        return packageName;
    }
}
