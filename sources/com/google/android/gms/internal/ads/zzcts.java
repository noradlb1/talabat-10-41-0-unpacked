package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzcts implements zzfdg {
    private final zzcui zza;
    private Context zzb;
    private String zzc;

    public /* synthetic */ zzcts(zzcui zzcui, zzctr zzctr) {
        this.zza = zzcui;
    }

    public final /* synthetic */ zzfdg zza(String str) {
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzfdg zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzfdh zzc() {
        zzgpz.zzc(this.zzb, Context.class);
        return new zzctu(this.zza, this.zzb, this.zzc, (zzctt) null);
    }
}
