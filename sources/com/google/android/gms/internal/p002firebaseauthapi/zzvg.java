package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvg  reason: invalid package */
final class zzvg implements zzvj {
    private final zzvs zza;

    public /* synthetic */ zzvg(zzvs zzvs, zzvf zzvf) {
        this.zza = zzvs;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zza.zza(str, (Provider) null);
    }
}
