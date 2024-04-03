package com.google.android.libraries.places.internal;

public class zzacf {
    private static final zzabh zzb = zzabh.zza();
    protected volatile zzacz zza;
    private volatile zzaax zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzacf)) {
            return false;
        }
        zzacf zzacf = (zzacf) obj;
        zzacz zzacz = this.zza;
        zzacz zzacz2 = zzacf.zza;
        if (zzacz == null && zzacz2 == null) {
            return zzb().equals(zzacf.zzb());
        }
        if (zzacz != null && zzacz2 != null) {
            return zzacz.equals(zzacz2);
        }
        if (zzacz != null) {
            zzacf.zzc(zzacz.zzw());
            return zzacz.equals(zzacf.zza);
        }
        zzc(zzacz2.zzw());
        return this.zza.equals(zzacz2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzaau) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzv();
        }
        return 0;
    }

    public final zzaax zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzaax zzaax = this.zzc;
                return zzaax;
            }
            if (this.zza == null) {
                this.zzc = zzaax.zzb;
            } else {
                this.zzc = this.zza.zzs();
            }
            zzaax zzaax2 = this.zzc;
            return zzaax2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.libraries.places.internal.zzacz r2) {
        /*
            r1 = this;
            com.google.android.libraries.places.internal.zzacz r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.libraries.places.internal.zzacz r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzacc -> 0x0011 }
            com.google.android.libraries.places.internal.zzaax r0 = com.google.android.libraries.places.internal.zzaax.zzb     // Catch:{ zzacc -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzacc -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.libraries.places.internal.zzaax r2 = com.google.android.libraries.places.internal.zzaax.zzb     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzacf.zzc(com.google.android.libraries.places.internal.zzacz):void");
    }
}
