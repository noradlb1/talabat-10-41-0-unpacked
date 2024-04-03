package com.google.android.gms.internal.ads;

public final class zzmi {
    private final zzlh[] zza;
    private final zzmx zzb;
    private final zzmz zzc;

    public zzmi(zzlh... zzlhArr) {
        zzmx zzmx = new zzmx();
        zzmz zzmz = new zzmz();
        zzlh[] zzlhArr2 = new zzlh[2];
        this.zza = zzlhArr2;
        System.arraycopy(zzlhArr, 0, zzlhArr2, 0, 0);
        this.zzb = zzmx;
        this.zzc = zzmz;
        zzlhArr2[0] = zzmx;
        zzlhArr2[1] = zzmz;
    }

    public final long zza(long j11) {
        return this.zzc.zzi(j11);
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzbn zzc(zzbn zzbn) {
        this.zzc.zzk(zzbn.zzc);
        this.zzc.zzj(zzbn.zzd);
        return zzbn;
    }

    public final boolean zzd(boolean z11) {
        this.zzb.zzp(z11);
        return z11;
    }

    public final zzlh[] zze() {
        return this.zza;
    }
}
