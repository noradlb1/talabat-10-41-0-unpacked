package com.huawei.wisesecurity.kfs.crypto.cipher;

import com.huawei.wisesecurity.kfs.util.ByteUtil;

public class CipherText {
    public CipherAlg algId = CipherAlg.UNKNOWN;
    public byte[] cipherBytes;
    public byte[] plainBytes;

    public CipherAlg getAlgId() {
        return this.algId;
    }

    public byte[] getCipherBytes() {
        return ByteUtil.clone(this.cipherBytes);
    }

    public byte[] getPlainBytes() {
        return ByteUtil.clone(this.plainBytes);
    }

    public void setAlgId(CipherAlg cipherAlg) {
        this.algId = cipherAlg;
    }

    public void setCipherBytes(byte[] bArr) {
        this.cipherBytes = ByteUtil.clone(bArr);
    }

    public void setPlainBytes(byte[] bArr) {
        this.plainBytes = ByteUtil.clone(bArr);
    }
}
