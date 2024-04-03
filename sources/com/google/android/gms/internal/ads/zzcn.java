package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public class zzcn {
    public static final zzcn zza;
    @Deprecated
    public static final zzcn zzb;
    public static final zzj<zzcn> zzc = zzcj.zza;
    public final zzftc<Integer> zzA;
    public final int zzd = Integer.MAX_VALUE;
    public final int zze = Integer.MAX_VALUE;
    public final int zzf = Integer.MAX_VALUE;
    public final int zzg = Integer.MAX_VALUE;
    public final int zzh = 0;
    public final int zzi = 0;
    public final int zzj = 0;
    public final int zzk = 0;
    public final int zzl;
    public final int zzm;
    public final boolean zzn;
    public final zzfss<String> zzo;
    public final zzfss<String> zzp;
    public final int zzq;
    public final int zzr;
    public final int zzs;
    public final zzfss<String> zzt;
    public final zzfss<String> zzu;
    public final int zzv;
    public final boolean zzw;
    public final boolean zzx;
    public final boolean zzy;
    public final zzfsw<zzcf, zzcm> zzz;

    static {
        zzcn zzcn = new zzcn(new zzck());
        zza = zzcn;
        zzb = zzcn;
    }

    public zzcn(zzck zzck) {
        this.zzl = zzck.zza;
        this.zzm = zzck.zzb;
        this.zzn = zzck.zzc;
        this.zzo = zzck.zzd;
        this.zzp = zzck.zze;
        this.zzq = 0;
        this.zzr = Integer.MAX_VALUE;
        this.zzs = Integer.MAX_VALUE;
        this.zzt = zzck.zzf;
        this.zzu = zzck.zzg;
        this.zzv = zzck.zzh;
        this.zzw = false;
        this.zzx = false;
        this.zzy = false;
        this.zzz = zzck.zzi;
        this.zzA = zzck.zzj;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzcn zzcn = (zzcn) obj;
            if (this.zzn != zzcn.zzn || this.zzl != zzcn.zzl || this.zzm != zzcn.zzm || !this.zzo.equals(zzcn.zzo) || !this.zzp.equals(zzcn.zzp) || !this.zzt.equals(zzcn.zzt) || !this.zzu.equals(zzcn.zzu) || this.zzv != zzcn.zzv || !this.zzz.equals(zzcn.zzz) || !this.zzA.equals(zzcn.zzA)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.zzn ? 1 : 0) - true) * 31) + this.zzl) * 31) + this.zzm) * 31) + this.zzo.hashCode()) * 31) + this.zzp.hashCode()) * 961) + Integer.MAX_VALUE) * 31) + Integer.MAX_VALUE) * 31) + this.zzt.hashCode()) * 31) + this.zzu.hashCode()) * 31) + this.zzv) * 923521) + this.zzz.hashCode()) * 31) + this.zzA.hashCode();
    }
}
