package com.google.android.gms.internal.ads;

import android.util.Log;

final class zzapa {
    public final zzaum zza;
    public final Object zzb;
    public final int zzc;
    public final zzauy[] zzd = new zzauy[2];
    public final boolean[] zze = new boolean[2];
    public final long zzf;
    public int zzg;
    public long zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;
    public zzapa zzl;
    public zzavs zzm;
    private final zzapl[] zzn;
    private final zzapm[] zzo;
    private final zzavr zzp;
    private final zzauo zzq;
    private zzavs zzr;
    private final zzcmd zzs;

    public zzapa(zzapl[] zzaplArr, zzapm[] zzapmArr, long j11, zzavr zzavr, zzcmd zzcmd, zzauo zzauo, Object obj, int i11, int i12, boolean z11, long j12, byte[] bArr) {
        this.zzn = zzaplArr;
        this.zzo = zzapmArr;
        this.zzf = j11;
        this.zzp = zzavr;
        this.zzs = zzcmd;
        this.zzq = zzauo;
        obj.getClass();
        this.zzb = obj;
        this.zzc = i11;
        this.zzg = i12;
        this.zzi = z11;
        this.zzh = j12;
        this.zza = zzauo.zzf(i12, zzcmd.zzl());
    }

    public final long zza(long j11, boolean z11) {
        return zzb(j11, false, new boolean[2]);
    }

    public final long zzb(long j11, boolean z11, boolean[] zArr) {
        boolean z12;
        boolean z13;
        zzavp zzavp = this.zzm.zzb;
        int i11 = 0;
        while (true) {
            boolean z14 = true;
            if (i11 >= 2) {
                break;
            }
            boolean[] zArr2 = this.zze;
            if (z11 || !this.zzm.zza(this.zzr, i11)) {
                z14 = false;
            }
            zArr2[i11] = z14;
            i11++;
        }
        long zzB = this.zza.zzB(zzavp.zzb(), this.zze, this.zzd, zArr, j11);
        this.zzr = this.zzm;
        this.zzk = false;
        int i12 = 0;
        while (true) {
            zzauy[] zzauyArr = this.zzd;
            if (i12 < 2) {
                if (zzauyArr[i12] != null) {
                    if (zzavp.zza(i12) != null) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    zzawm.zze(z13);
                    this.zzk = true;
                } else {
                    if (zzavp.zza(i12) == null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zzawm.zze(z12);
                }
                i12++;
            } else {
                this.zzs.zzd(this.zzn, this.zzm.zza, zzavp);
                return zzB;
            }
        }
    }

    public final void zzc() {
        try {
            this.zzq.zzc(this.zza);
        } catch (RuntimeException e11) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e11);
        }
    }

    public final boolean zzd() {
        if (!this.zzj) {
            return false;
        }
        if (this.zzk) {
            return this.zza.zzg() == Long.MIN_VALUE;
        }
        return true;
    }

    public final boolean zze() throws zzaos {
        zzavs zzc2 = this.zzp.zzc(this.zzo, this.zza.zzn());
        zzavs zzavs = this.zzr;
        if (zzavs != null) {
            int i11 = 0;
            while (i11 < 2) {
                if (zzc2.zza(zzavs, i11)) {
                    i11++;
                }
            }
            return false;
        }
        this.zzm = zzc2;
        return true;
    }
}
