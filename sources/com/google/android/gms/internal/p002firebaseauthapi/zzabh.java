package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabh  reason: invalid package */
final class zzabh implements zzabn {
    final /* synthetic */ String zza;

    public zzabh(zzabm zzabm, String str) {
        this.zza = str;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeSent(this.zza, PhoneAuthProvider.ForceResendingToken.zza());
    }
}
