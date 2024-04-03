package com.google.firebase.auth;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.firebase.auth.internal.zzg;

@VisibleForTesting
class zzac implements zzg {
    final /* synthetic */ FirebaseAuth zza;

    public zzac(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzadr zzadr, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(zzadr);
        Preconditions.checkNotNull(firebaseUser);
        firebaseUser.zzh(zzadr);
        this.zza.zzQ(firebaseUser, zzadr, true);
    }
}
