package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzun  reason: invalid package */
final class zzun extends ThreadLocal {
    public static final Cipher zza() {
        try {
            return (Cipher) zzvk.zza.zza("AES/CTR/NoPadding");
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
