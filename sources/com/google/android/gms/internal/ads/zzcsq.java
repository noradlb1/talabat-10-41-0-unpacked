package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzcsq implements zzezz {
    private final zzcui zza;
    private Context zzb;
    private String zzc;
    private zzbfi zzd;

    public /* synthetic */ zzcsq(zzcui zzcui, zzcsp zzcsp) {
        this.zza = zzcui;
    }

    public final /* synthetic */ zzezz zza(zzbfi zzbfi) {
        zzbfi.getClass();
        this.zzd = zzbfi;
        return this;
    }

    public final /* synthetic */ zzezz zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzezz zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzfaa zzd() {
        zzgpz.zzc(this.zzb, Context.class);
        zzgpz.zzc(this.zzc, String.class);
        zzgpz.zzc(this.zzd, zzbfi.class);
        return new zzcss(this.zza, this.zzb, this.zzc, this.zzd, (zzcsr) null);
    }
}
