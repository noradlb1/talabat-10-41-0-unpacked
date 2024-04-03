package com.google.android.gms.internal.ads;

final class zzafp implements zzxp {
    private final zzafm zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzafp(zzafm zzafm, int i11, long j11, long j12) {
        this.zza = zzafm;
        this.zzb = i11;
        this.zzc = j11;
        long j13 = (j12 - j11) / ((long) zzafm.zzd);
        this.zzd = j13;
        this.zze = zza(j13);
    }

    private final long zza(long j11) {
        return zzfn.zzt(j11 * ((long) this.zzb), 1000000, (long) this.zza.zzc);
    }

    public final long zze() {
        return this.zze;
    }

    public final zzxn zzg(long j11) {
        long zzo = zzfn.zzo((((long) this.zza.zzc) * j11) / (((long) this.zzb) * 1000000), 0, this.zzd - 1);
        long j12 = this.zzc;
        int i11 = this.zza.zzd;
        long zza2 = zza(zzo);
        zzxq zzxq = new zzxq(zza2, j12 + (((long) i11) * zzo));
        if (zza2 >= j11 || zzo == this.zzd - 1) {
            return new zzxn(zzxq, zzxq);
        }
        long j13 = zzo + 1;
        return new zzxn(zzxq, new zzxq(zza(j13), this.zzc + (j13 * ((long) this.zza.zzd))));
    }

    public final boolean zzh() {
        return true;
    }
}
