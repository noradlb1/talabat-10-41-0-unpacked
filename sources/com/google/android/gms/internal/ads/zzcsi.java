package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzcsi implements zzeym {
    private final zzcui zza;
    private final zzcsi zzb = this;
    private final zzgqe<Context> zzc;
    private final zzgqe<String> zzd;
    private final zzgqe<zzfbc<zzcxz, zzcyf>> zze;
    private final zzgqe<zzezj> zzf;
    private final zzgqe<zzeyd> zzg;
    private final zzgqe<zzeyj> zzh;
    private final zzgqe<zzfbc<zzcyk, zzcyp>> zzi;
    private final zzgqe<zzezl> zzj;
    private final zzgqe<zzezr> zzk;

    public /* synthetic */ zzcsi(zzcui zzcui, Context context, String str, zzcsh zzcsh) {
        this.zza = zzcui;
        zzgpr zza2 = zzgps.zza(context);
        this.zzc = zza2;
        zzgpr zza3 = zzgps.zza(str);
        this.zzd = zza3;
        zzfbg zzfbg = new zzfbg(zza2, zzcui.zzau, zzcui.zzav);
        this.zze = zzfbg;
        zzgqe<zzezj> zzc2 = zzgpq.zzc(new zzezk(zzcui.zzau));
        this.zzf = zzc2;
        zzgqe<zzezj> zzgqe = zzc2;
        zzgqe<zzeyd> zzc3 = zzgpq.zzc(new zzeye(zza2, zzcui.zzp, zzcui.zzO, zzfbg, zzgqe, zzfeh.zza()));
        this.zzg = zzc3;
        this.zzh = zzgpq.zzc(new zzeyk(zzcui.zzO, zza2, zza3, zzc3, zzgqe, zzcui.zzi));
        zzfbf zzfbf = new zzfbf(zza2, zzcui.zzau, zzcui.zzav);
        this.zzi = zzfbf;
        zzgqe<zzezl> zzc4 = zzgpq.zzc(new zzezm(zza2, zzcui.zzp, zzcui.zzO, zzfbf, zzgqe, zzfeh.zza()));
        this.zzj = zzc4;
        this.zzk = zzgpq.zzc(new zzezs(zzcui.zzO, zza2, zza3, zzc4, zzgqe));
    }

    public final zzeyj zza() {
        return this.zzh.zzb();
    }

    public final zzezr zzb() {
        return this.zzk.zzb();
    }
}
