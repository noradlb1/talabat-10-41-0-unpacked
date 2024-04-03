package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;

public final class zzeft implements zzdlk {
    @GuardedBy("this")
    private boolean zza = false;
    @GuardedBy("this")
    private boolean zzb = false;
    private final String zzc;
    private final zzfio zzd;
    private final zzg zze;

    public zzeft(String str, zzfio zzfio) {
        this.zzc = str;
        this.zzd = zzfio;
        this.zze = zzt.zzo().zzh();
    }

    private final zzfin zzf(String str) {
        String str2;
        if (this.zze.zzL()) {
            str2 = "";
        } else {
            str2 = this.zzc;
        }
        zzfin zzb2 = zzfin.zzb(str);
        zzb2.zza("tms", Long.toString(zzt.zzA().elapsedRealtime(), 10));
        zzb2.zza("tid", str2);
        return zzb2;
    }

    public final void zza(String str, String str2) {
        zzfio zzfio = this.zzd;
        zzfin zzf = zzf("adapter_init_finished");
        zzf.zza("ancn", str);
        zzf.zza("rqe", str2);
        zzfio.zzb(zzf);
    }

    public final void zzb(String str) {
        zzfio zzfio = this.zzd;
        zzfin zzf = zzf("adapter_init_started");
        zzf.zza("ancn", str);
        zzfio.zzb(zzf);
    }

    public final void zzc(String str) {
        zzfio zzfio = this.zzd;
        zzfin zzf = zzf("adapter_init_finished");
        zzf.zza("ancn", str);
        zzfio.zzb(zzf);
    }

    public final synchronized void zzd() {
        if (!this.zzb) {
            this.zzd.zzb(zzf("init_finished"));
            this.zzb = true;
        }
    }

    public final synchronized void zze() {
        if (!this.zza) {
            this.zzd.zzb(zzf("init_started"));
            this.zza = true;
        }
    }
}
