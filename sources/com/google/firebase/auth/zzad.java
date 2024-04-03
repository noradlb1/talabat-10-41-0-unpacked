package com.google.firebase.auth;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.firebase.auth.internal.zzbx;

@VisibleForTesting
final class zzad implements zzbx {
    final /* synthetic */ FirebaseAuth zza;

    public zzad(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzadr zzadr, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(zzadr);
        Preconditions.checkNotNull(firebaseUser);
        firebaseUser.zzh(zzadr);
        FirebaseAuth.zzT(this.zza, firebaseUser, zzadr, true, true);
    }

    public final void zzb(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005 || status.getStatusCode() == 17091) {
            this.zza.signOut();
        }
    }
}
