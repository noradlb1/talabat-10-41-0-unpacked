package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvi  reason: invalid package */
final class zzvi implements zzvj {
    private final zzvs zza;

    public /* synthetic */ zzvi(zzvs zzvs, zzvh zzvh) {
        this.zza = zzvs;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza2 : zzvk.zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception e11) {
                if (exc == null) {
                    exc = e11;
                }
            }
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
