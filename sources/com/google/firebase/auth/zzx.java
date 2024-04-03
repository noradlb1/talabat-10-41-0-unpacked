package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.firebase.auth.internal.zzbx;

final class zzx implements zzbx {
    final /* synthetic */ FirebaseAuth zza;

    public zzx(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzadr zzadr, FirebaseUser firebaseUser) {
        FirebaseAuth.zzT(this.zza, firebaseUser, zzadr, true, true);
    }

    public final void zzb(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zza.signOut();
        }
    }
}
