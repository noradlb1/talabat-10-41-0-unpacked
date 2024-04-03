package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzto implements zzdh {
    private final Context zza;
    private final zzdh zzb;

    public zzto(Context context) {
        zzdn zzdn = new zzdn();
        this.zza = context.getApplicationContext();
        this.zzb = zzdn;
    }

    public final /* bridge */ /* synthetic */ zzdi zza() {
        return new zztp(this.zza, ((zzdn) this.zzb).zza());
    }
}
