package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoh  reason: invalid package */
public final class zzoh {
    public static final zzoh zza = new zzof().zza();
    private final Map zzb;

    public /* synthetic */ zzoh(Map map, zzog zzog) {
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzoh)) {
            return false;
        }
        return this.zzb.equals(((zzoh) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map zza() {
        return this.zzb;
    }
}
