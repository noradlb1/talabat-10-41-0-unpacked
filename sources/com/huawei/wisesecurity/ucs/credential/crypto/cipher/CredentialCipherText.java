package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import com.huawei.wisesecurity.kfs.util.ByteUtil;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;

public class CredentialCipherText {
    public CredentialCipherAlg algId;
    public byte[] cipherBytes;

    /* renamed from: iv  reason: collision with root package name */
    public byte[] f44855iv;
    public byte[] plainBytes;

    public void checkParam(boolean z11) throws UcsParamException {
        byte[] bArr = this.f44855iv;
        if (bArr == null || (this.algId == CredentialCipherAlg.AES_GCM && bArr.length != 12)) {
            throw new UcsParamException("illegal iv param..");
        } else if (z11) {
            byte[] bArr2 = this.plainBytes;
            if (bArr2 == null || bArr2.length == 0) {
                throw new UcsParamException("plainBytes data can not be empty..");
            }
        } else {
            byte[] bArr3 = this.cipherBytes;
            if (bArr3 == null || bArr3.length == 0) {
                throw new UcsParamException("cipherBytes data can not be empty..");
            }
        }
    }

    public int getAlgId() {
        return this.algId.getId();
    }

    public byte[] getCipherBytes() {
        return ByteUtil.clone(this.cipherBytes);
    }

    public byte[] getIv() {
        return ByteUtil.clone(this.f44855iv);
    }

    public byte[] getPlainBytes() {
        return ByteUtil.clone(this.plainBytes);
    }

    public void setAlgId(CredentialCipherAlg credentialCipherAlg) {
        this.algId = credentialCipherAlg;
    }

    public void setCipherBytes(byte[] bArr) {
        this.cipherBytes = ByteUtil.clone(bArr);
    }

    public void setIv(byte[] bArr) {
        this.f44855iv = ByteUtil.clone(bArr);
    }

    public void setPlainBytes(byte[] bArr) {
        this.plainBytes = ByteUtil.clone(bArr);
    }
}
