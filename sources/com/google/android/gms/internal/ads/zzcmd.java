package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

public final class zzcmd {
    private final zzavz zza = new zzavz(true, 65536);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = 5000000;
    private int zzf;
    private boolean zzg;

    public final void zza() {
        zze(false);
    }

    public final void zzb() {
        zze(true);
    }

    public final void zzc() {
        zze(true);
    }

    public final void zzd(zzapl[] zzaplArr, zzavd zzavd, zzavp zzavp) {
        this.zzf = 0;
        for (int i11 = 0; i11 < 2; i11++) {
            if (zzavp.zza(i11) != null) {
                this.zzf += zzaxb.zzf(zzaplArr[i11].zzc());
            }
        }
        this.zza.zzf(this.zzf);
    }

    @VisibleForTesting
    public final void zze(boolean z11) {
        this.zzf = 0;
        this.zzg = false;
        if (z11) {
            this.zza.zze();
        }
    }

    public final synchronized void zzf(int i11) {
        this.zzd = ((long) i11) * 1000;
    }

    public final synchronized void zzg(int i11) {
        this.zze = ((long) i11) * 1000;
    }

    public final synchronized void zzh(int i11) {
        this.zzc = ((long) i11) * 1000;
    }

    public final synchronized void zzi(int i11) {
        this.zzb = ((long) i11) * 1000;
    }

    public final synchronized boolean zzj(long j11) {
        boolean z11;
        z11 = true;
        boolean z12 = j11 > this.zzc ? false : j11 < this.zzb ? true : true;
        int zza2 = this.zza.zza();
        int i11 = this.zzf;
        if (!z12) {
            if (!z12 || !this.zzg || zza2 >= i11) {
                z11 = false;
            }
        }
        this.zzg = z11;
        return z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzk(long r5, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r7 == 0) goto L_0x0006
            long r0 = r4.zze     // Catch:{ all -> 0x0019 }
            goto L_0x0008
        L_0x0006:
            long r0 = r4.zzd     // Catch:{ all -> 0x0019 }
        L_0x0008:
            r2 = 0
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0016
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 < 0) goto L_0x0013
            goto L_0x0016
        L_0x0013:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x0016:
            monitor-exit(r4)
            r5 = 1
            return r5
        L_0x0019:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmd.zzk(long, boolean):boolean");
    }

    public final zzavz zzl() {
        return this.zza;
    }
}
