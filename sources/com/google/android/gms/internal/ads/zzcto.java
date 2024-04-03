package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzcto implements zzfbs {
    private final zzcui zza;
    private Context zzb;
    private String zzc;
    private zzbfi zzd;

    public /* synthetic */ zzcto(zzcui zzcui, zzctn zzctn) {
        this.zza = zzcui;
    }

    public final /* synthetic */ zzfbs zza(zzbfi zzbfi) {
        zzbfi.getClass();
        this.zzd = zzbfi;
        return this;
    }

    public final /* synthetic */ zzfbs zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzfbs zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzfbt zzd() {
        zzgpz.zzc(this.zzb, Context.class);
        zzgpz.zzc(this.zzc, String.class);
        zzgpz.zzc(this.zzd, zzbfi.class);
        return new zzctq(this.zza, this.zzb, this.zzc, this.zzd, (zzctp) null);
    }
}
