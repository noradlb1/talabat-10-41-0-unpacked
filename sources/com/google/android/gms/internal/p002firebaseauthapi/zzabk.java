package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabk  reason: invalid package */
final class zzabk implements zzabn {
    final /* synthetic */ Status zza;

    public zzabk(zzabm zzabm, Status status) {
        this.zza = status;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationFailed(zzaap.zza(this.zza));
    }
}
