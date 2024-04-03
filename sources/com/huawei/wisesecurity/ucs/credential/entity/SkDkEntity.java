package com.huawei.wisesecurity.ucs.credential.entity;

import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import javax.crypto.spec.SecretKeySpec;

public class SkDkEntity {
    public static final int GCM_IV_LEN = 12;
    public static final int GCM_TAG_LEN = 16;

    /* renamed from: iv  reason: collision with root package name */
    public byte[] f44859iv;
    public byte[] secKey;

    public static SkDkEntity from(byte[] bArr) throws UcsException {
        SkDkEntity skDkEntity = new SkDkEntity();
        if (bArr.length >= 28) {
            byte[] bArr2 = new byte[12];
            skDkEntity.f44859iv = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, 12);
            byte[] bArr3 = new byte[(bArr.length - 12)];
            skDkEntity.secKey = bArr3;
            System.arraycopy(bArr, 12, bArr3, 0, bArr.length - 12);
            return skDkEntity;
        }
        throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "SK DK format error");
    }

    public byte[] decryptSkDk(byte[] bArr) throws UcsException {
        try {
            return new AESCipher.Builder().withAlg(CipherAlg.AES_GCM).withIv(this.f44859iv).withKey(new SecretKeySpec(bArr, "AES")).build().getDecryptHandler().from(this.secKey).to();
        } catch (CryptoException e11) {
            throw new UcsException(UcsErrorCode.CRYPTO_ERROR, "decrypt sk dk error : " + e11.getMessage());
        }
    }

    public byte[] getIv() {
        return this.f44859iv;
    }

    public byte[] getSecKey() {
        return this.secKey;
    }
}
