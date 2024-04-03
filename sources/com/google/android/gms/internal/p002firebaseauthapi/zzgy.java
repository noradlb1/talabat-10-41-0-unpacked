package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgy  reason: invalid package */
final class zzgy extends ThreadLocal {
    public static final Cipher zza() {
        try {
            return (Cipher) zzvk.zza.zza("AES/GCM/NoPadding");
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
