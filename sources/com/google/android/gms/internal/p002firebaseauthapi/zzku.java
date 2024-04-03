package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzku  reason: invalid package */
public final class zzku {
    private static final zzku zza = new zzku();
    private static final zzkt zzb = new zzkt((zzks) null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzku zza() {
        return zza;
    }

    public final zzoj zzb() {
        zzoj zzoj = (zzoj) this.zzc.get();
        return zzoj == null ? zzb : zzoj;
    }
}
