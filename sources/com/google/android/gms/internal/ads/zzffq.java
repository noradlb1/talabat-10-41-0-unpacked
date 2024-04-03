package com.google.android.gms.internal.ads;

import org.apache.commons.lang3.StringUtils;

final class zzffq {
    private final zzffp zza = new zzffp();
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;

    public final zzffp zza() {
        zzffp zza2 = this.zza.clone();
        zzffp zzffp = this.zza;
        zzffp.zza = false;
        zzffp.zzb = false;
        return zza2;
    }

    public final String zzb() {
        return "\n\tPool does not exist: " + this.zzd + "\n\tNew pools created: " + this.zzb + "\n\tPools removed: " + this.zzc + "\n\tEntries added: " + this.zzf + "\n\tNo entries retrieved: " + this.zze + StringUtils.LF;
    }

    public final void zzc() {
        this.zzf++;
    }

    public final void zzd() {
        this.zzb++;
        this.zza.zza = true;
    }

    public final void zze() {
        this.zze++;
    }

    public final void zzf() {
        this.zzd++;
    }

    public final void zzg() {
        this.zzc++;
        this.zza.zzb = true;
    }
}
