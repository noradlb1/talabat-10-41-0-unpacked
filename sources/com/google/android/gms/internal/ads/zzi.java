package com.google.android.gms.internal.ads;

public abstract class zzi implements zzbw {
    protected final zzcc zza = new zzcc();

    public final boolean zza() {
        zzcd zzm = zzm();
        if (!zzm.zzo()) {
            int zzg = zzg();
            zzi();
            zzo();
            if (zzm.zzj(zzg, 0, false) != -1) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzb() {
        zzcd zzm = zzm();
        if (!zzm.zzo()) {
            int zzg = zzg();
            zzi();
            zzo();
            if (zzm.zzk(zzg, 0, false) != -1) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzc() {
        zzcd zzm = zzm();
        if (zzm.zzo() || !zzm.zze(zzg(), this.zza, 0).zzb()) {
            return false;
        }
        return true;
    }

    public final boolean zzd() {
        zzcd zzm = zzm();
        if (zzm.zzo() || !zzm.zze(zzg(), this.zza, 0).zzh) {
            return false;
        }
        return true;
    }
}
