package com.google.android.gms.internal.ads;

public final class zzegl {
    private int zza = 0;
    private long zzb = 0;
    private long zzc = 0;
    private long zzd = 0;
    private final Object zze = new Object();
    private final Object zzf = new Object();
    private final Object zzg = new Object();
    private final Object zzh = new Object();

    public final int zza() {
        int i11;
        synchronized (this.zze) {
            i11 = this.zza;
        }
        return i11;
    }

    public final synchronized long zzb() {
        long j11;
        synchronized (this.zzh) {
            j11 = this.zzd;
        }
        return j11;
    }

    public final synchronized long zzc() {
        long j11;
        synchronized (this.zzg) {
            j11 = this.zzc;
        }
        return j11;
    }

    public final long zzd() {
        long j11;
        synchronized (this.zzf) {
            j11 = this.zzb;
        }
        return j11;
    }

    public final synchronized void zze(long j11) {
        synchronized (this.zzh) {
            this.zzd = j11;
        }
    }

    public final synchronized void zzf(long j11) {
        synchronized (this.zzg) {
            this.zzc = j11;
        }
    }

    public final void zzg(int i11) {
        synchronized (this.zze) {
            this.zza = i11;
        }
    }

    public final void zzh(long j11) {
        synchronized (this.zzf) {
            this.zzb = j11;
        }
    }
}
