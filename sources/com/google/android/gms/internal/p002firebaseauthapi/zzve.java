package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzve  reason: invalid package */
final class zzve implements zzvj {
    private final zzvs zza;

    public /* synthetic */ zzve(zzvs zzvs, zzvd zzvd) {
        this.zza = zzvs;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        for (Provider zza2 : zzvk.zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception unused) {
            }
        }
        return this.zza.zza(str, (Provider) null);
    }
}
