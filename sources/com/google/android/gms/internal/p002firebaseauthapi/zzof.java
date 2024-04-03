package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzof  reason: invalid package */
public final class zzof {
    private HashMap zza = new HashMap();

    public final zzoh zza() {
        if (this.zza != null) {
            zzoh zzoh = new zzoh(Collections.unmodifiableMap(this.zza), (zzog) null);
            this.zza = null;
            return zzoh;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
