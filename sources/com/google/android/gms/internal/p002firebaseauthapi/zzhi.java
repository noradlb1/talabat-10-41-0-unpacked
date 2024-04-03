package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhi  reason: invalid package */
public final class zzhi implements zzbd {
    private static final ThreadLocal zza = new zzhh();
    private static final boolean zzb;
    private final SecretKey zzc;

    static {
        boolean z11;
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            z11 = true;
        } catch (ClassNotFoundException unused) {
            z11 = false;
        }
        zzb = z11;
    }

    public zzhi(byte[] bArr) throws GeneralSecurityException {
        zzwc.zzb(bArr.length);
        this.zzc = new SecretKeySpec(bArr, "AES");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        AlgorithmParameterSpec algorithmParameterSpec;
        int length = bArr.length;
        if (length >= 28) {
            if (zzb) {
                algorithmParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
            } else if (zzwb.zza()) {
                algorithmParameterSpec = new IvParameterSpec(bArr, 0, 12);
            } else {
                throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
            }
            ThreadLocal threadLocal = zza;
            ((Cipher) threadLocal.get()).init(2, this.zzc, algorithmParameterSpec);
            return ((Cipher) threadLocal.get()).doFinal(bArr, 12, length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
