package com.google.android.gms.internal.ads;

import java.io.IOException;

public abstract class zzaoq implements zzapl, zzapm {
    private final int zza;
    private zzapn zzb;
    private int zzc;
    private int zzd;
    private zzauy zze;
    private long zzf;
    private boolean zzg = true;
    private boolean zzh;

    public zzaoq(int i11) {
        this.zza = i11;
    }

    public final boolean zzA() {
        return this.zzg;
    }

    public final boolean zzB() {
        return this.zzh;
    }

    public final boolean zzC() {
        return this.zzg ? this.zzh : this.zze.zze();
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd(zzaph zzaph, zzarb zzarb, boolean z11) {
        zzaph zzaph2 = zzaph;
        zzarb zzarb2 = zzarb;
        int zzb2 = this.zze.zzb(zzaph2, zzarb2, z11);
        if (zzb2 == -4) {
            if (zzarb.zzf()) {
                this.zzg = true;
                if (this.zzh) {
                    return -4;
                }
                return -3;
            }
            zzarb2.zzc += this.zzf;
        } else if (zzb2 == -5) {
            zzapg zzapg = zzaph2.zza;
            long j11 = zzapg.zzw;
            if (j11 != Long.MAX_VALUE) {
                zzaph2.zza = new zzapg(zzapg.zza, zzapg.zze, zzapg.zzf, zzapg.zzc, zzapg.zzb, zzapg.zzg, zzapg.zzj, zzapg.zzk, zzapg.zzl, zzapg.zzm, zzapg.zzn, zzapg.zzp, zzapg.zzo, zzapg.zzq, zzapg.zzr, zzapg.zzs, zzapg.zzt, zzapg.zzu, zzapg.zzv, zzapg.zzx, zzapg.zzy, zzapg.zzz, j11 + this.zzf, zzapg.zzh, zzapg.zzi, zzapg.zzd);
                return -5;
            }
        }
        return zzb2;
    }

    public int zze() throws zzaos {
        throw null;
    }

    public final zzapm zzf() {
        return this;
    }

    public final zzapn zzg() {
        return this.zzb;
    }

    public final zzauy zzh() {
        return this.zze;
    }

    public zzawq zzi() {
        return null;
    }

    public final void zzj() {
        boolean z11 = true;
        if (this.zzd != 1) {
            z11 = false;
        }
        zzawm.zze(z11);
        this.zzd = 0;
        this.zze = null;
        this.zzh = false;
        zzn();
    }

    public final void zzk(zzapn zzapn, zzapg[] zzapgArr, zzauy zzauy, long j11, boolean z11, long j12) throws zzaos {
        boolean z12;
        if (this.zzd == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        zzawm.zze(z12);
        this.zzb = zzapn;
        this.zzd = 1;
        zzo(z11);
        zzt(zzapgArr, zzauy, j12);
        zzp(j11, z11);
    }

    public void zzl(int i11, Object obj) throws zzaos {
    }

    public final void zzm() throws IOException {
        this.zze.zzc();
    }

    public void zzn() {
        throw null;
    }

    public void zzo(boolean z11) throws zzaos {
    }

    public void zzp(long j11, boolean z11) throws zzaos {
        throw null;
    }

    public void zzq() throws zzaos {
    }

    public void zzr() throws zzaos {
    }

    public void zzs(zzapg[] zzapgArr, long j11) throws zzaos {
    }

    public final void zzt(zzapg[] zzapgArr, zzauy zzauy, long j11) throws zzaos {
        zzawm.zze(!this.zzh);
        this.zze = zzauy;
        this.zzg = false;
        this.zzf = j11;
        zzs(zzapgArr, j11);
    }

    public final void zzu(long j11) throws zzaos {
        this.zzh = false;
        this.zzg = false;
        zzp(j11, false);
    }

    public final void zzv() {
        this.zzh = true;
    }

    public final void zzw(int i11) {
        this.zzc = i11;
    }

    public final void zzx(long j11) {
        this.zze.zzd(j11 - this.zzf);
    }

    public final void zzy() throws zzaos {
        boolean z11 = true;
        if (this.zzd != 1) {
            z11 = false;
        }
        zzawm.zze(z11);
        this.zzd = 2;
        zzq();
    }

    public final void zzz() throws zzaos {
        boolean z11;
        if (this.zzd == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzawm.zze(z11);
        this.zzd = 1;
        zzr();
    }
}
