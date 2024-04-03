package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzcss implements zzfaa {
    private final Context zza;
    private final zzbfi zzb;
    private final String zzc;
    private final zzcui zzd;
    private final zzcss zze = this;
    private final zzgqe<Context> zzf;
    private final zzgqe<zzbfi> zzg;
    private final zzgqe<zzeox> zzh;
    private final zzgqe<zzepb> zzi;
    private final zzgqe<zzezx> zzj;

    public /* synthetic */ zzcss(zzcui zzcui, Context context, String str, zzbfi zzbfi, zzcsr zzcsr) {
        this.zzd = zzcui;
        this.zza = context;
        this.zzb = zzbfi;
        this.zzc = str;
        zzgpr zza2 = zzgps.zza(context);
        this.zzf = zza2;
        zzgpr zza3 = zzgps.zza(zzbfi);
        this.zzg = zza3;
        zzgqe<zzeox> zzc2 = zzgpq.zzc(new zzeoy(zzcui.zzo));
        this.zzh = zzc2;
        zzgqe<zzepb> zzc3 = zzgpq.zzc(zzepd.zza());
        this.zzi = zzc3;
        this.zzj = zzgpq.zzc(new zzezy(zza2, zzcui.zzp, zza3, zzcui.zzO, zzc2, zzc3, zzfeh.zza()));
    }

    public final zzeoe zza() {
        return new zzeoe(this.zza, this.zzb, this.zzc, this.zzj.zzb(), this.zzh.zzb());
    }
}
