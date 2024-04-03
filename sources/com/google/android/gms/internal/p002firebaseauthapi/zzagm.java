package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagm  reason: invalid package */
final class zzagm {
    private final Object zza;
    private final int zzb;

    public zzagm(Object obj, int i11) {
        this.zza = obj;
        this.zzb = i11;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzagm)) {
            return false;
        }
        zzagm zzagm = (zzagm) obj;
        if (this.zza == zzagm.zza && this.zzb == zzagm.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
