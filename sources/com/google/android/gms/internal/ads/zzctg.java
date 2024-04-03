package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzctg implements zzeai {
    /* access modifiers changed from: private */
    public final Context zza;
    private final zzbso zzb;
    private final zzcui zzc;
    private final zzctg zzd = this;
    private final zzgqe<zzeai> zze;
    private final zzgqe<zzbso> zzf;
    private final zzgqe<zzead> zzg;
    private final zzgqe<zzeaf> zzh;

    public /* synthetic */ zzctg(zzcui zzcui, Context context, zzbso zzbso, zzctf zzctf) {
        this.zzc = zzcui;
        this.zza = context;
        this.zzb = zzbso;
        zzgpr zza2 = zzgps.zza(this);
        this.zze = zza2;
        zzgpr zza3 = zzgps.zza(zzbso);
        this.zzf = zza3;
        zzeae zzeae = new zzeae(zza3);
        this.zzg = zzeae;
        this.zzh = zzgpq.zzc(new zzeag(zza2, zzeae));
    }

    public final zzdzz zzb() {
        return new zzcta(this.zzc, this.zzd, (zzcsz) null);
    }

    public final zzeaf zzd() {
        return this.zzh.zzb();
    }
}
