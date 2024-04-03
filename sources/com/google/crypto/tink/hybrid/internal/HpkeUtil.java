package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.proto.HpkeAead;
import com.google.crypto.tink.proto.HpkeKdf;
import com.google.crypto.tink.proto.HpkeKem;
import com.google.crypto.tink.proto.HpkeParams;
import com.google.crypto.tink.subtle.Bytes;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

public final class HpkeUtil {
    public static final byte[] AES_128_GCM_AEAD_ID = intToByteArray(2, 1);
    public static final byte[] AES_256_GCM_AEAD_ID = intToByteArray(2, 2);
    public static final byte[] BASE_MODE = intToByteArray(1, 0);
    public static final byte[] CHACHA20_POLY1305_AEAD_ID = intToByteArray(2, 3);
    public static final byte[] EMPTY_SALT = new byte[0];
    public static final byte[] HKDF_SHA256_KDF_ID = intToByteArray(2, 1);
    public static final byte[] HKDF_SHA384_KDF_ID = intToByteArray(2, 2);
    public static final byte[] HKDF_SHA512_KDF_ID = intToByteArray(2, 3);
    private static final byte[] HPKE = "HPKE".getBytes(StandardCharsets.UTF_8);
    private static final byte[] HPKE_V1 = "HPKE-v1".getBytes(StandardCharsets.UTF_8);
    private static final byte[] KEM = "KEM".getBytes(StandardCharsets.UTF_8);
    public static final byte[] P256_HKDF_SHA256_KEM_ID = intToByteArray(2, 16);
    public static final byte[] P384_HKDF_SHA384_KEM_ID = intToByteArray(2, 17);
    public static final byte[] P521_HKDF_SHA512_KEM_ID = intToByteArray(2, 18);
    public static final byte[] X25519_HKDF_SHA256_KEM_ID = intToByteArray(2, 32);

    private HpkeUtil() {
    }

    public static byte[] hpkeSuiteId(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return Bytes.concat(HPKE, bArr, bArr2, bArr3);
    }

    public static byte[] intToByteArray(int i11, int i12) {
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) ((i12 >> (((i11 - i13) - 1) * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] kemSuiteId(byte[] bArr) throws GeneralSecurityException {
        return Bytes.concat(KEM, bArr);
    }

    public static byte[] labelIkm(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return Bytes.concat(HPKE_V1, bArr2, str.getBytes(StandardCharsets.UTF_8), bArr);
    }

    public static byte[] labelInfo(String str, byte[] bArr, byte[] bArr2, int i11) throws GeneralSecurityException {
        return Bytes.concat(intToByteArray(2, i11), HPKE_V1, bArr2, str.getBytes(StandardCharsets.UTF_8), bArr);
    }

    public static void validateParams(HpkeParams hpkeParams) throws GeneralSecurityException {
        if (hpkeParams.getKem() == HpkeKem.KEM_UNKNOWN || hpkeParams.getKem() == HpkeKem.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KEM param: " + hpkeParams.getKem().name());
        } else if (hpkeParams.getKdf() == HpkeKdf.KDF_UNKNOWN || hpkeParams.getKdf() == HpkeKdf.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KDF param: " + hpkeParams.getKdf().name());
        } else if (hpkeParams.getAead() == HpkeAead.AEAD_UNKNOWN || hpkeParams.getAead() == HpkeAead.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid AEAD param: " + hpkeParams.getAead().name());
        }
    }
}
