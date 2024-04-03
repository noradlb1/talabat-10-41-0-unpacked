package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwr  reason: invalid package */
public final class zzwr {
    private final PhoneAuthCredential zza;
    @Nullable
    private final String zzb;

    public zzwr(PhoneAuthCredential phoneAuthCredential, @Nullable String str) {
        this.zza = phoneAuthCredential;
        this.zzb = str;
    }

    public final PhoneAuthCredential zza() {
        return this.zza;
    }
}
