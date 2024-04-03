package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlz  reason: invalid package */
final class zzlz {
    private final Class zza;
    private final zzwf zzb;

    public /* synthetic */ zzlz(Class cls, zzwf zzwf, zzly zzly) {
        this.zza = cls;
        this.zzb = zzwf;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzlz)) {
            return false;
        }
        zzlz zzlz = (zzlz) obj;
        if (!zzlz.zza.equals(this.zza) || !zzlz.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(this.zzb);
        return simpleName + ", object identifier: " + valueOf;
    }
}
