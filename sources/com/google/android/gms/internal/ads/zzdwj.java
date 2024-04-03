package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

public final class zzdwj {
    private final zzcpb zza;
    private final Context zzb;
    private final zzalt zzc;
    private final zzbmi zzd;
    private final zzcjf zze;
    private final zza zzf;
    private final zzbay zzg;
    /* access modifiers changed from: private */
    public final zzdhg zzh;

    public zzdwj(zzcpb zzcpb, Context context, zzalt zzalt, zzbmi zzbmi, zzcjf zzcjf, zza zza2, zzbay zzbay, zzdhg zzdhg) {
        this.zza = zzcpb;
        this.zzb = context;
        this.zzc = zzalt;
        this.zzd = zzbmi;
        this.zze = zzcjf;
        this.zzf = zza2;
        this.zzg = zzbay;
        this.zzh = zzdhg;
    }

    public final zzcop zza(zzbfi zzbfi, zzfdn zzfdn, zzfdq zzfdq) throws zzcpa {
        return zzcpb.zza(this.zzb, zzcqe.zzc(zzbfi), zzbfi.zza, false, false, this.zzc, this.zzd, this.zze, (zzbly) null, new zzdvy(this), this.zzf, this.zzg, zzfdn, zzfdq);
    }
}
