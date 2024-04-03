package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.ActionCodeSettings;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwm  reason: invalid package */
public final class zzwm {
    private final String zza;
    @Nullable
    private final ActionCodeSettings zzb;

    public zzwm(String str, @Nullable ActionCodeSettings actionCodeSettings) {
        this.zza = str;
        this.zzb = actionCodeSettings;
    }

    @Nullable
    public final ActionCodeSettings zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
