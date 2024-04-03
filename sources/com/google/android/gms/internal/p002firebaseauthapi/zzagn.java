package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagn  reason: invalid package */
public final class zzagn {
    static final zzagn zza = new zzagn(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    public zzagn() {
        this.zzd = new HashMap();
    }

    public static zzagn zza() {
        return zza;
    }

    public final zzagy zzb(zzaif zzaif, int i11) {
        return (zzagy) this.zzd.get(new zzagm(zzaif, i11));
    }

    public zzagn(boolean z11) {
        this.zzd = Collections.emptyMap();
    }
}
