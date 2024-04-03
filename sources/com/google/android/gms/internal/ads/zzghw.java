package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Signature;

public final class zzghw implements zzghx<Signature> {
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return Signature.getInstance(str);
        }
        return Signature.getInstance(str, provider);
    }
}
