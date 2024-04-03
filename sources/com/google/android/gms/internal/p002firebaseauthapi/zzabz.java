package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabz  reason: invalid package */
public final class zzabz {
    public static zzaez zza(PhoneAuthCredential phoneAuthCredential) {
        if (!TextUtils.isEmpty(phoneAuthCredential.zzh())) {
            return zzaez.zzc(phoneAuthCredential.zzf(), phoneAuthCredential.zzh(), phoneAuthCredential.zzi());
        }
        return zzaez.zzb(phoneAuthCredential.zzg(), phoneAuthCredential.getSmsCode(), phoneAuthCredential.zzi());
    }
}
