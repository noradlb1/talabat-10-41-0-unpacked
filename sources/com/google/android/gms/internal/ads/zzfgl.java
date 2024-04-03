package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

final class zzfgl {
    private final long zza;
    private final zzfgk zzb = new zzfgk();
    private long zzc;
    private int zzd = 0;
    private int zze = 0;
    private int zzf = 0;

    public zzfgl() {
        long currentTimeMillis = zzt.zzA().currentTimeMillis();
        this.zza = currentTimeMillis;
        this.zzc = currentTimeMillis;
    }

    public final int zza() {
        return this.zzd;
    }

    public final long zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final zzfgk zzd() {
        zzfgk zza2 = this.zzb.clone();
        zzfgk zzfgk = this.zzb;
        zzfgk.zza = false;
        zzfgk.zzb = 0;
        return zza2;
    }

    public final String zze() {
        return "Created: " + this.zza + " Last accessed: " + this.zzc + " Accesses: " + this.zzd + "\nEntries retrieved: Valid: " + this.zze + " Stale: " + this.zzf;
    }

    public final void zzf() {
        this.zzc = zzt.zzA().currentTimeMillis();
        this.zzd++;
    }

    public final void zzg() {
        this.zzf++;
        this.zzb.zzb++;
    }

    public final void zzh() {
        this.zze++;
        this.zzb.zza = true;
    }
}
