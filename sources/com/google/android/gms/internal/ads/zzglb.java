package com.google.android.gms.internal.ads;

public class zzglb {
    private static final zzgjx zzb = zzgjx.zza();
    protected volatile zzglv zza;
    private volatile zzgjf zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzglb)) {
            return false;
        }
        zzglb zzglb = (zzglb) obj;
        zzglv zzglv = this.zza;
        zzglv zzglv2 = zzglb.zza;
        if (zzglv == null && zzglv2 == null) {
            return zzb().equals(zzglb.zzb());
        }
        if (zzglv != null && zzglv2 != null) {
            return zzglv.equals(zzglv2);
        }
        if (zzglv != null) {
            zzglb.zzc(zzglv.zzbp());
            return zzglv.equals(zzglb.zza);
        }
        zzc(zzglv2.zzbp());
        return this.zza.equals(zzglv2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzgjb) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzas();
        }
        return 0;
    }

    public final zzgjf zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzgjf zzgjf = this.zzc;
                return zzgjf;
            }
            if (this.zza == null) {
                this.zzc = zzgjf.zzb;
            } else {
                this.zzc = this.zza.zzao();
            }
            zzgjf zzgjf2 = this.zzc;
            return zzgjf2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.ads.zzglv r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzglv r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzglv r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzgkx -> 0x0011 }
            com.google.android.gms.internal.ads.zzgjf r0 = com.google.android.gms.internal.ads.zzgjf.zzb     // Catch:{ zzgkx -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzgkx -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzgjf r2 = com.google.android.gms.internal.ads.zzgjf.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzglb.zzc(com.google.android.gms.internal.ads.zzglv):void");
    }
}
