package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacb  reason: invalid package */
final class zzacb extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {
    final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zza;
    final /* synthetic */ String zzb;

    public zzacb(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, String str) {
        this.zza = onVerificationStateChangedCallbacks;
        this.zzb = str;
    }

    public final void onCodeAutoRetrievalTimeOut(@NonNull String str) {
        zzacd.zza.remove(this.zzb);
        this.zza.onCodeAutoRetrievalTimeOut(str);
    }

    public final void onCodeSent(@NonNull String str, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        this.zza.onCodeSent(str, forceResendingToken);
    }

    public final void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
        zzacd.zza.remove(this.zzb);
        this.zza.onVerificationCompleted(phoneAuthCredential);
    }

    public final void onVerificationFailed(@NonNull FirebaseException firebaseException) {
        zzacd.zza.remove(this.zzb);
        this.zza.onVerificationFailed(firebaseException);
    }
}
