package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.KeyAgreement;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvm  reason: invalid package */
public final class zzvm implements zzvs {
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return KeyAgreement.getInstance(str);
        }
        return KeyAgreement.getInstance(str, provider);
    }
}
