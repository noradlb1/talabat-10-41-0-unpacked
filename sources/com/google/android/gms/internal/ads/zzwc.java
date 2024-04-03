package com.google.android.gms.internal.ads;

public final class zzwc {
    /* access modifiers changed from: private */
    public final long zza;
    /* access modifiers changed from: private */
    public final long zzb;
    private final long zzc;
    private long zzd = 0;
    private long zze;
    /* access modifiers changed from: private */
    public long zzf;
    /* access modifiers changed from: private */
    public long zzg;
    /* access modifiers changed from: private */
    public long zzh;

    public zzwc(long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
        this.zza = j11;
        long j18 = j12;
        this.zzb = j18;
        long j19 = j14;
        this.zze = j19;
        long j21 = j15;
        this.zzf = j21;
        long j22 = j16;
        this.zzg = j22;
        long j23 = j17;
        this.zzc = j23;
        this.zzh = zzf(j18, 0, j19, j21, j22, j23);
    }

    public static long zzf(long j11, long j12, long j13, long j14, long j15, long j16) {
        if (j14 + 1 >= j15 || 1 + j12 >= j13) {
            return j14;
        }
        long j17 = (long) (((float) (j11 - j12)) * (((float) (j15 - j14)) / ((float) (j13 - j12))));
        return zzfn.zzo(((j14 + j17) - j16) - (j17 / 20), j14, -1 + j15);
    }

    public static /* bridge */ /* synthetic */ void zzg(zzwc zzwc, long j11, long j12) {
        zzwc.zze = j11;
        zzwc.zzg = j12;
        zzwc.zzi();
    }

    public static /* bridge */ /* synthetic */ void zzh(zzwc zzwc, long j11, long j12) {
        zzwc.zzd = j11;
        zzwc.zzf = j12;
        zzwc.zzi();
    }

    private final void zzi() {
        this.zzh = zzf(this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzc);
    }
}
