package com.google.android.gms.internal.places;

public class zzbp {
    private static final zzap zzdv = zzap.zzao();
    private zzw zzju;
    private volatile zzck zzjv;
    private volatile zzw zzjw;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.places.zzck zzi(com.google.android.gms.internal.places.zzck r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.places.zzck r0 = r1.zzjv
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.places.zzck r0 = r1.zzjv     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzjv = r2     // Catch:{ zzbk -> 0x0012 }
            com.google.android.gms.internal.places.zzw r0 = com.google.android.gms.internal.places.zzw.zzeg     // Catch:{ zzbk -> 0x0012 }
            r1.zzjw = r0     // Catch:{ zzbk -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzjv = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.places.zzw r2 = com.google.android.gms.internal.places.zzw.zzeg     // Catch:{ all -> 0x001a }
            r1.zzjw = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.places.zzck r2 = r1.zzjv
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzbp.zzi(com.google.android.gms.internal.places.zzck):com.google.android.gms.internal.places.zzck");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbp)) {
            return false;
        }
        zzbp zzbp = (zzbp) obj;
        zzck zzck = this.zzjv;
        zzck zzck2 = zzbp.zzjv;
        if (zzck == null && zzck2 == null) {
            return zzv().equals(zzbp.zzv());
        }
        if (zzck != null && zzck2 != null) {
            return zzck.equals(zzck2);
        }
        if (zzck != null) {
            return zzck.equals(zzbp.zzi(zzck.zzbg()));
        }
        return zzi(zzck2.zzbg()).equals(zzck2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zzbh() {
        if (this.zzjw != null) {
            return this.zzjw.size();
        }
        if (this.zzjv != null) {
            return this.zzjv.zzbh();
        }
        return 0;
    }

    public final zzck zzj(zzck zzck) {
        zzck zzck2 = this.zzjv;
        this.zzju = null;
        this.zzjw = null;
        this.zzjv = zzck;
        return zzck2;
    }

    public final zzw zzv() {
        if (this.zzjw != null) {
            return this.zzjw;
        }
        synchronized (this) {
            if (this.zzjw != null) {
                zzw zzw = this.zzjw;
                return zzw;
            }
            if (this.zzjv == null) {
                this.zzjw = zzw.zzeg;
            } else {
                this.zzjw = this.zzjv.zzv();
            }
            zzw zzw2 = this.zzjw;
            return zzw2;
        }
    }
}
