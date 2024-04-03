package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuz  reason: invalid package */
public final class zzuz {
    private final ECPrivateKey zza;

    public zzuz(ECPrivateKey eCPrivateKey) {
        this.zza = eCPrivateKey;
    }

    public final byte[] zza(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i11, int i12) throws GeneralSecurityException {
        int i13 = 1;
        byte[] zzb = zzuu.zzb(bArr, zzvb.zzf(this.zza, zzvb.zzh(this.zza.getParams(), i12, bArr)));
        Mac mac = (Mac) zzvk.zzb.zza(str);
        if (i11 <= mac.getMacLength() * 255) {
            if (bArr2 == null || bArr2.length == 0) {
                mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
            } else {
                mac.init(new SecretKeySpec(bArr2, str));
            }
            byte[] doFinal = mac.doFinal(zzb);
            byte[] bArr4 = new byte[i11];
            mac.init(new SecretKeySpec(doFinal, str));
            byte[] bArr5 = new byte[0];
            int i14 = 0;
            while (true) {
                mac.update(bArr5);
                mac.update((byte[]) null);
                mac.update((byte) i13);
                bArr5 = mac.doFinal();
                int length = bArr5.length;
                int i15 = i14 + length;
                if (i15 < i11) {
                    System.arraycopy(bArr5, 0, bArr4, i14, length);
                    i13++;
                    i14 = i15;
                } else {
                    System.arraycopy(bArr5, 0, bArr4, i14, i11 - i14);
                    return bArr4;
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }
}
