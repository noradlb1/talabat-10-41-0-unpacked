package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvn  reason: invalid package */
public final class zzvn implements zzvs {
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return KeyFactory.getInstance(str);
        }
        return KeyFactory.getInstance(str, provider);
    }
}
