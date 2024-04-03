package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzcnr implements zzhs {
    private final zztk zza = new zztk(true, 65536);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = 5000000;
    private int zzf;
    private boolean zzg;

    public final long zza() {
        return 0;
    }

    public final void zzb() {
        zzj(false);
    }

    public final void zzc() {
        zzj(true);
    }

    public final void zzd() {
        zzj(true);
    }

    public final boolean zze() {
        return false;
    }

    public final boolean zzf(long j11, long j12, float f11) {
        boolean z11 = true;
        boolean z12 = j12 > this.zzc ? false : j12 < this.zzb ? true : true;
        int zza2 = this.zza.zza();
        int i11 = this.zzf;
        if (!z12 && (!z12 || !this.zzg || zza2 >= i11)) {
            z11 = false;
        }
        this.zzg = z11;
        return z11;
    }

    public final boolean zzg(long j11, float f11, boolean z11, long j12) {
        long j13 = z11 ? this.zze : this.zzd;
        return j13 <= 0 || j11 >= j13;
    }

    public final zztk zzh() {
        return this.zza;
    }

    public final void zzi(zzil[] zzilArr, zzch zzch, zzsb[] zzsbArr) {
        int i11;
        this.zzf = 0;
        for (int i12 = 0; i12 < 2; i12++) {
            if (zzsbArr[i12] != null) {
                int i13 = this.zzf;
                if (zzilArr[i12].zzb() != 1) {
                    i11 = DefaultLoadControl.DEFAULT_VIDEO_BUFFER_SIZE;
                } else {
                    i11 = 13107200;
                }
                this.zzf = i13 + i11;
            }
        }
        this.zza.zzf(this.zzf);
    }

    @VisibleForTesting
    public final void zzj(boolean z11) {
        this.zzf = 0;
        this.zzg = false;
        if (z11) {
            this.zza.zze();
        }
    }

    public final synchronized void zzk(int i11) {
        this.zzd = ((long) i11) * 1000;
    }

    public final synchronized void zzl(int i11) {
        this.zze = ((long) i11) * 1000;
    }

    public final synchronized void zzm(int i11) {
        this.zzc = ((long) i11) * 1000;
    }

    public final synchronized void zzn(int i11) {
        this.zzb = ((long) i11) * 1000;
    }
}
