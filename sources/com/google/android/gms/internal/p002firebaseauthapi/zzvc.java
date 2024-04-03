package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvc  reason: invalid package */
public final class zzvc implements zzbd {
    private final zzvu zza;
    private final zzcd zzb;
    private final int zzc;

    public zzvc(zzvu zzvu, zzcd zzcd, int i11) {
        this.zza = zzvu;
        this.zzb = zzcd;
        this.zzc = i11;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i11 = this.zzc;
        if (length >= i11) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, length - i11);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, length - this.zzc, length);
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(0).array(), 8);
            this.zzb.zza(copyOfRange2, zzuu.zzb(bArr2, copyOfRange, copyOf));
            return this.zza.zza(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
