package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

final class zzggt extends ThreadLocal<Cipher> {
    public static final Cipher zza() {
        try {
            return zzghp.zza.zza("AES/CTR/NoPadding");
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
