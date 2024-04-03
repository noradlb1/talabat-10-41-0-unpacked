package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabl  reason: invalid package */
final class zzabl implements Runnable {
    final /* synthetic */ zzabn zza;
    final /* synthetic */ zzabm zzb;

    public zzabl(zzabm zzabm, zzabn zzabn) {
        this.zzb = zzabm;
        this.zza = zzabn;
    }

    public final void run() {
        synchronized (this.zzb.zza.zzl) {
            if (!this.zzb.zza.zzl.isEmpty()) {
                this.zza.zza((PhoneAuthProvider.OnVerificationStateChangedCallbacks) this.zzb.zza.zzl.get(0), new Object[0]);
            }
        }
    }
}
