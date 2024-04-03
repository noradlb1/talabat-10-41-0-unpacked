package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmb  reason: invalid package */
final class zzmb {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzmb(Class cls, Class cls2, zzma zzma) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzmb)) {
            return false;
        }
        zzmb zzmb = (zzmb) obj;
        if (!zzmb.zza.equals(this.zza) || !zzmb.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String simpleName2 = this.zzb.getSimpleName();
        return simpleName + " with serialization type: " + simpleName2;
    }
}
