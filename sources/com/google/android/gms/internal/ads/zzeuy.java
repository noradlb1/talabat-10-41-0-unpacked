package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzeuy implements zzevn<zzeuz> {
    private final zzchh zza;
    private final zzfxb zzb;
    private final Context zzc;

    public zzeuy(zzchh zzchh, zzfxb zzfxb, Context context) {
        this.zza = zzchh;
        this.zzb = zzfxb;
        this.zzc = context;
    }

    public final /* synthetic */ zzeuz zza() throws Exception {
        String str;
        String str2;
        String str3;
        String str4;
        Long l11;
        if (!this.zza.zzu(this.zzc)) {
            return new zzeuz((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zze = this.zza.zze(this.zzc);
        if (zze == null) {
            str = "";
        } else {
            str = zze;
        }
        String zzc2 = this.zza.zzc(this.zzc);
        if (zzc2 == null) {
            str2 = "";
        } else {
            str2 = zzc2;
        }
        String zza2 = this.zza.zza(this.zzc);
        if (zza2 == null) {
            str3 = "";
        } else {
            str3 = zza2;
        }
        String zzb2 = this.zza.zzb(this.zzc);
        if (zzb2 == null) {
            str4 = "";
        } else {
            str4 = zzb2;
        }
        if ("TIME_OUT".equals(str2)) {
            l11 = (Long) zzbgq.zzc().zzb(zzblj.zzaa);
        } else {
            l11 = null;
        }
        return new zzeuz(str, str2, str3, str4, l11);
    }

    public final zzfxa<zzeuz> zzb() {
        return this.zzb.zzb(new zzeux(this));
    }
}
