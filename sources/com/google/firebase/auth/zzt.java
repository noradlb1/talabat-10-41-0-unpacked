package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

final class zzt implements Runnable {
    final /* synthetic */ FirebaseAuth.IdTokenListener zza;
    final /* synthetic */ FirebaseAuth zzb;

    public zzt(FirebaseAuth firebaseAuth, FirebaseAuth.IdTokenListener idTokenListener) {
        this.zzb = firebaseAuth;
        this.zza = idTokenListener;
    }

    public final void run() {
        this.zza.onIdTokenChanged(this.zzb);
    }
}
