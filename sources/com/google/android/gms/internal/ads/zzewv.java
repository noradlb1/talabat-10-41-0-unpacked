package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzewv implements zzevn<zzeww> {
    final zzfxb zza;
    final Context zzb;
    final zzban zzc;

    public zzewv(zzban zzban, zzfxb zzfxb, Context context, byte[] bArr) {
        this.zzc = zzban;
        this.zza = zzfxb;
        this.zzb = context;
    }

    public final zzfxa<zzeww> zzb() {
        return this.zza.zzb(new zzewu(this));
    }
}
