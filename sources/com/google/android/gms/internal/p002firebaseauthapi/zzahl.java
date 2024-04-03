package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahl  reason: invalid package */
public class zzahl {
    private static final zzagn zzb = zzagn.zza;
    protected volatile zzaif zza;
    private volatile zzafv zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzahl)) {
            return false;
        }
        zzahl zzahl = (zzahl) obj;
        zzaif zzaif = this.zza;
        zzaif zzaif2 = zzahl.zza;
        if (zzaif == null && zzaif2 == null) {
            return zzb().equals(zzahl.zzb());
        }
        if (zzaif != null && zzaif2 != null) {
            return zzaif.equals(zzaif2);
        }
        if (zzaif != null) {
            zzahl.zzc(zzaif.zzM());
            return zzaif.equals(zzahl.zza);
        }
        zzc(zzaif2.zzM());
        return this.zza.equals(zzaif2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzafs) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzs();
        }
        return 0;
    }

    public final zzafv zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzafv zzafv = this.zzc;
                return zzafv;
            }
            if (this.zza == null) {
                this.zzc = zzafv.zzb;
            } else {
                this.zzc = this.zza.zzo();
            }
            zzafv zzafv2 = this.zzc;
            return zzafv2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.p002firebaseauthapi.zzaif r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase-auth-api.zzaif r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.firebase-auth-api.zzaif r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzahi -> 0x0011 }
            com.google.android.gms.internal.firebase-auth-api.zzafv r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafv.zzb     // Catch:{ zzahi -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzahi -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.firebase-auth-api.zzafv r2 = com.google.android.gms.internal.p002firebaseauthapi.zzafv.zzb     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzahl.zzc(com.google.android.gms.internal.firebase-auth-api.zzaif):void");
    }
}
