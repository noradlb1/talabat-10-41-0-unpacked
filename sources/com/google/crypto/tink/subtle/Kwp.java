package com.google.crypto.tink.subtle;

import com.google.crypto.tink.KeyWrap;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Kwp implements KeyWrap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int MAX_WRAP_KEY_SIZE = 4096;
    static final int MIN_WRAP_KEY_SIZE = 16;
    static final byte[] PREFIX = {-90, 89, 89, -90};
    static final int ROUNDS = 6;
    private final SecretKey aesKey;

    public Kwp(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == 16 || bArr.length == 32) {
            this.aesKey = new SecretKeySpec(bArr, "AES");
            return;
        }
        throw new GeneralSecurityException("Unsupported key length");
    }

    private byte[] computeW(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr4.length <= 8 || bArr4.length > 2147483631 || bArr3.length != 8) {
            throw new GeneralSecurityException("computeW called with invalid parameters");
        }
        int wrappingSize = wrappingSize(bArr4.length);
        byte[] bArr5 = new byte[wrappingSize];
        System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
        System.arraycopy(bArr4, 0, bArr5, 8, bArr4.length);
        int i11 = 1;
        int i12 = (wrappingSize / 8) - 1;
        Cipher instance = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        instance.init(1, this.aesKey);
        byte[] bArr6 = new byte[16];
        System.arraycopy(bArr5, 0, bArr6, 0, 8);
        int i13 = 0;
        while (i13 < 6) {
            int i14 = 0;
            while (i14 < i12) {
                int i15 = i14 + 1;
                int i16 = i15 * 8;
                System.arraycopy(bArr5, i16, bArr6, 8, 8);
                instance.doFinal(bArr6, 0, 16, bArr6);
                int i17 = (i13 * i12) + i14 + i11;
                for (int i18 = 0; i18 < 4; i18++) {
                    int i19 = 7 - i18;
                    bArr6[i19] = (byte) (((byte) (i17 & 255)) ^ bArr6[i19]);
                    i17 >>>= 8;
                }
                System.arraycopy(bArr6, 8, bArr5, i16, 8);
                i14 = i15;
                i11 = 1;
            }
            i13++;
            i11 = 1;
        }
        System.arraycopy(bArr6, 0, bArr5, 0, 8);
        return bArr5;
    }

    private byte[] invertW(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length < 24 || bArr.length % 8 != 0) {
            throw new GeneralSecurityException("Incorrect data size");
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        int length = (copyOf.length / 8) - 1;
        Cipher instance = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        instance.init(2, this.aesKey);
        byte[] bArr2 = new byte[16];
        System.arraycopy(copyOf, 0, bArr2, 0, 8);
        for (int i11 = 5; i11 >= 0; i11--) {
            for (int i12 = length - 1; i12 >= 0; i12--) {
                int i13 = (i12 + 1) * 8;
                System.arraycopy(copyOf, i13, bArr2, 8, 8);
                int i14 = (i11 * length) + i12 + 1;
                for (int i15 = 0; i15 < 4; i15++) {
                    int i16 = 7 - i15;
                    bArr2[i16] = (byte) (bArr2[i16] ^ ((byte) (i14 & 255)));
                    i14 >>>= 8;
                }
                instance.doFinal(bArr2, 0, 16, bArr2);
                System.arraycopy(bArr2, 8, copyOf, i13, 8);
            }
        }
        System.arraycopy(bArr2, 0, copyOf, 0, 8);
        return copyOf;
    }

    private int wrappingSize(int i11) {
        return i11 + (7 - ((i11 + 7) % 8)) + 8;
    }

    public byte[] unwrap(byte[] bArr) throws GeneralSecurityException {
        int i11;
        if (bArr.length < wrappingSize(16)) {
            throw new GeneralSecurityException("Wrapped key size is too small");
        } else if (bArr.length > wrappingSize(4096)) {
            throw new GeneralSecurityException("Wrapped key size is too large");
        } else if (bArr.length % 8 == 0) {
            byte[] invertW = invertW(bArr);
            boolean z11 = true;
            boolean z12 = false;
            int i12 = 0;
            while (true) {
                if (i12 >= 4) {
                    break;
                }
                if (PREFIX[i12] != invertW[i12]) {
                    z11 = false;
                }
                i12++;
            }
            int i13 = 0;
            for (i11 = 4; i11 < 8; i11++) {
                i13 = (i13 << 8) + (invertW[i11] & 255);
            }
            if (wrappingSize(i13) == invertW.length) {
                for (int i14 = i13 + 8; i14 < invertW.length; i14++) {
                    if (invertW[i14] != 0) {
                        z11 = false;
                    }
                }
                z12 = z11;
            }
            if (z12) {
                return Arrays.copyOfRange(invertW, 8, i13 + 8);
            }
            throw new BadPaddingException("Invalid padding");
        } else {
            throw new GeneralSecurityException("Wrapped key size must be a multiple of 8 bytes");
        }
    }

    public byte[] wrap(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length < 16) {
            throw new GeneralSecurityException("Key size of key to wrap too small");
        } else if (bArr.length <= 4096) {
            byte[] bArr2 = new byte[8];
            byte[] bArr3 = PREFIX;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            for (int i11 = 0; i11 < 4; i11++) {
                bArr2[i11 + 4] = (byte) ((bArr.length >> ((3 - i11) * 8)) & 255);
            }
            return computeW(bArr2, bArr);
        } else {
            throw new GeneralSecurityException("Key size of key to wrap too large");
        }
    }
}
