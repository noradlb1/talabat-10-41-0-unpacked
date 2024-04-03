package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlp  reason: invalid package */
final class zzlp {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzlp(Class cls, Class cls2, zzlo zzlo) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzlp)) {
            return false;
        }
        zzlp zzlp = (zzlp) obj;
        if (!zzlp.zza.equals(this.zza) || !zzlp.zzb.equals(this.zzb)) {
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
        return simpleName + " with primitive type: " + simpleName2;
    }
}
