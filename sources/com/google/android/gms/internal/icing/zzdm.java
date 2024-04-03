package com.google.android.gms.internal.icing;

public class zzdm {
    private static final zzcp zzb = zzcp.zza();
    protected volatile zzee zza;
    private volatile zzcf zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdm)) {
            return false;
        }
        zzdm zzdm = (zzdm) obj;
        zzee zzee = this.zza;
        zzee zzee2 = zzdm.zza;
        if (zzee == null && zzee2 == null) {
            return zzb().equals(zzdm.zzb());
        }
        if (zzee != null && zzee2 != null) {
            return zzee.equals(zzee2);
        }
        if (zzee != null) {
            zzdm.zzc(zzee.zzm());
            return zzee.equals(zzdm.zza);
        }
        zzc(zzee2.zzm());
        return this.zza.equals(zzee2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzcd) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzo();
        }
        return 0;
    }

    public final zzcf zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzcf zzcf = this.zzc;
                return zzcf;
            }
            if (this.zza == null) {
                this.zzc = zzcf.zzb;
            } else {
                this.zzc = this.zza.zzg();
            }
            zzcf zzcf2 = this.zzc;
            return zzcf2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.icing.zzee r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.icing.zzee r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.icing.zzee r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzdj -> 0x0011 }
            com.google.android.gms.internal.icing.zzcf r0 = com.google.android.gms.internal.icing.zzcf.zzb     // Catch:{ zzdj -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzdj -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.icing.zzcf r2 = com.google.android.gms.internal.icing.zzcf.zzb     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.zzdm.zzc(com.google.android.gms.internal.icing.zzee):void");
    }
}
