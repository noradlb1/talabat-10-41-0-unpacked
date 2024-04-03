package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzctu implements zzfdh {
    private final zzcui zza;
    private final zzctu zzb = this;
    private final zzgqe<Context> zzc;
    private final zzgqe<zzfbc<zzdvs, zzdvn>> zzd;
    private final zzgqe<zzfcq> zze;
    private final zzgqe<zzfea> zzf;
    private final zzgqe<zzfda> zzg;
    private final zzgqe<zzfdk> zzh;
    private final zzgqe<String> zzi;
    private final zzgqe<zzfde> zzj;

    public /* synthetic */ zzctu(zzcui zzcui, Context context, String str, zzctt zzctt) {
        this.zza = zzcui;
        zzgpr zza2 = zzgps.zza(context);
        this.zzc = zza2;
        zzfbh zzfbh = new zzfbh(zza2, zzcui.zzau, zzcui.zzav);
        this.zzd = zzfbh;
        zzgqe<zzfcq> zzc2 = zzgpq.zzc(new zzfcr(zzcui.zzau));
        this.zze = zzc2;
        zzgqe<zzfea> zzc3 = zzgpq.zzc(zzfec.zza());
        this.zzf = zzc3;
        zzgqe<zzfda> zzc4 = zzgpq.zzc(new zzfdb(zza2, zzcui.zzp, zzcui.zzO, zzfbh, zzc2, zzfeh.zza(), zzc3));
        this.zzg = zzc4;
        this.zzh = zzgpq.zzc(new zzfdl(zzc4, zzc2, zzc3));
        zzgpr zzc5 = zzgps.zzc(str);
        this.zzi = zzc5;
        this.zzj = zzgpq.zzc(new zzfdf(zzc5, zzc4, zza2, zzc2, zzc3));
    }

    public final zzfde zza() {
        return this.zzj.zzb();
    }

    public final zzfdk zzb() {
        return this.zzh.zzb();
    }
}
