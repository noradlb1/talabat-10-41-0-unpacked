package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Hkdf {
    private Hkdf() {
    }

    public static byte[] computeEciesHkdfSymmetricKey(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, byte[] bArr4, int i11) throws GeneralSecurityException {
        return computeHkdf(str, Bytes.concat(bArr, bArr2), bArr3, bArr4, i11);
    }

    public static byte[] computeHkdf(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, int i11) throws GeneralSecurityException {
        Mac instance = EngineFactory.MAC.getInstance(str);
        if (i11 <= instance.getMacLength() * 255) {
            if (bArr2 == null || bArr2.length == 0) {
                instance.init(new SecretKeySpec(new byte[instance.getMacLength()], str));
            } else {
                instance.init(new SecretKeySpec(bArr2, str));
            }
            byte[] bArr4 = new byte[i11];
            instance.init(new SecretKeySpec(instance.doFinal(bArr), str));
            byte[] bArr5 = new byte[0];
            int i12 = 1;
            int i13 = 0;
            while (true) {
                instance.update(bArr5);
                instance.update(bArr3);
                instance.update((byte) i12);
                bArr5 = instance.doFinal();
                if (bArr5.length + i13 < i11) {
                    System.arraycopy(bArr5, 0, bArr4, i13, bArr5.length);
                    i13 += bArr5.length;
                    i12++;
                } else {
                    System.arraycopy(bArr5, 0, bArr4, i13, i11 - i13);
                    return bArr4;
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }
}
