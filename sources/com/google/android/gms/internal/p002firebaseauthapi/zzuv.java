package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuv  reason: invalid package */
public final class zzuv implements zzbd {
    private final zzhc zza;

    public zzuv(byte[] bArr) throws GeneralSecurityException {
        this.zza = new zzhc(bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length >= 28) {
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            return this.zza.zzb(ByteBuffer.wrap(bArr, 12, length - 12), copyOf, bArr2);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
