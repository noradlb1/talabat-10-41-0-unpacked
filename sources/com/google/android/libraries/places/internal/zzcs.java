package com.google.android.libraries.places.internal;

import android.content.Context;

final class zzcs implements zzcv {
    private Context zza;
    private zzcy zzb;
    private zzdf zzc;

    private zzcs() {
    }

    public /* synthetic */ zzcs(zzcr zzcr) {
    }

    public final /* bridge */ /* synthetic */ zzcv zza(zzcy zzcy) {
        this.zzb = zzcy;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzcv zzb(zzdf zzdf) {
        this.zzc = zzdf;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzcv zzc(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzcw zzd() {
        zzaes.zzb(this.zza, Context.class);
        zzaes.zzb(this.zzb, zzcy.class);
        zzaes.zzb(this.zzc, zzdf.class);
        return new zzcu(this.zza, this.zzb, this.zzc, (zzct) null);
    }
}
