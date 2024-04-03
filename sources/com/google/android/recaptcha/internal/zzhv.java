package com.google.android.recaptcha.internal;

public class zzhv {
    private static final zzgq zzb = zzgq.zza;
    protected volatile zzip zza;
    private volatile zzfi zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhv)) {
            return false;
        }
        zzhv zzhv = (zzhv) obj;
        zzip zzip = this.zza;
        zzip zzip2 = zzhv.zza;
        if (zzip == null && zzip2 == null) {
            return zzb().equals(zzhv.zzb());
        }
        if (zzip != null && zzip2 != null) {
            return zzip.equals(zzip2);
        }
        if (zzip != null) {
            zzhv.zzd(zzip.zzX());
            return zzip.equals(zzhv.zza);
        }
        zzd(zzip2.zzX());
        return this.zza.equals(zzip2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzff) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzn();
        }
        return 0;
    }

    public final zzfi zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzfi zzfi = this.zzc;
                return zzfi;
            }
            if (this.zza == null) {
                this.zzc = zzfi.zzb;
            } else {
                this.zzc = this.zza.zzb();
            }
            zzfi zzfi2 = this.zzc;
            return zzfi2;
        }
    }

    public final zzip zzc(zzip zzip) {
        zzip zzip2 = this.zza;
        this.zzc = null;
        this.zza = zzip;
        return zzip2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.recaptcha.internal.zzip r2) {
        /*
            r1 = this;
            com.google.android.recaptcha.internal.zzip r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.recaptcha.internal.zzip r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzhp -> 0x0011 }
            com.google.android.recaptcha.internal.zzfi r0 = com.google.android.recaptcha.internal.zzfi.zzb     // Catch:{ zzhp -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzhp -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.recaptcha.internal.zzfi r2 = com.google.android.recaptcha.internal.zzfi.zzb     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzhv.zzd(com.google.android.recaptcha.internal.zzip):void");
    }
}
