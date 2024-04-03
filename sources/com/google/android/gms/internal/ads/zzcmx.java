package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.zzt;

public final class zzcmx extends zzb {
    final zzclh zza;
    final zzcnf zzb;
    private final String zzc;
    private final String[] zzd;

    public zzcmx(zzclh zzclh, zzcnf zzcnf, String str, String[] strArr) {
        this.zza = zzclh;
        this.zzb = zzcnf;
        this.zzc = str;
        this.zzd = strArr;
        zzt.zzy().zzb(this);
    }

    public final void zza() {
        try {
            this.zzb.zzr(this.zzc, this.zzd);
        } finally {
            com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcmw(this));
        }
    }

    public final zzfxa<?> zzb() {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzbu)).booleanValue() || !(this.zzb instanceof zzcno)) {
            return super.zzb();
        }
        return zzcjm.zze.zzb(new zzcmv(this));
    }

    public final /* synthetic */ Boolean zzd() throws Exception {
        return Boolean.valueOf(this.zzb.zzs(this.zzc, this.zzd, this));
    }

    public final String zze() {
        return this.zzc;
    }
}
