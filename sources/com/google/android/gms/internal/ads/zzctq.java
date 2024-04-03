package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzctq implements zzfbt {
    private final zzcui zza;
    private final zzctq zzb = this;
    private final zzgqe<Context> zzc;
    private final zzgqe<zzbfi> zzd;
    private final zzgqe<String> zze;
    private final zzgqe<zzeox> zzf;
    private final zzgqe<zzfcq> zzg;
    private final zzgqe<zzfbq> zzh;
    private final zzgqe<zzepf> zzi;

    public /* synthetic */ zzctq(zzcui zzcui, Context context, String str, zzbfi zzbfi, zzctp zzctp) {
        this.zza = zzcui;
        zzgpr zza2 = zzgps.zza(context);
        this.zzc = zza2;
        zzgpr zza3 = zzgps.zza(zzbfi);
        this.zzd = zza3;
        zzgpr zza4 = zzgps.zza(str);
        this.zze = zza4;
        zzgqe<zzeox> zzc2 = zzgpq.zzc(new zzeoy(zzcui.zzo));
        this.zzf = zzc2;
        zzgqe<zzfcq> zzc3 = zzgpq.zzc(new zzfcr(zzcui.zzau));
        this.zzg = zzc3;
        zzgpr zzgpr = zza2;
        zzgqe<zzfbq> zzc4 = zzgpq.zzc(new zzfbr(zzgpr, zzcui.zzp, zzcui.zzO, zzc2, zzc3, zzfeh.zza()));
        this.zzh = zzc4;
        this.zzi = zzgpq.zzc(new zzepg(zzgpr, zza3, zza4, zzc4, zzc2, zzc3));
    }

    public final zzepf zza() {
        return this.zzi.zzb();
    }
}
