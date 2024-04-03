package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import com.huawei.wisesecurity.kfs.util.ByteUtil;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;

public class CredentialSignText {
    public CredentialSignAlg algId;
    public byte[] dataBytes;
    public byte[] signature;

    public void checkParam(boolean z11) throws UcsException {
        byte[] bArr = this.dataBytes;
        if (bArr == null || bArr.length == 0) {
            throw new UcsParamException("dataBytes data can not be empty..");
        } else if (!z11) {
            byte[] bArr2 = this.signature;
            if (bArr2 == null || bArr2.length == 0) {
                throw new UcsParamException("signature data can not be empty..");
            }
        }
    }

    public int getAlgId() {
        return this.algId.getId();
    }

    public byte[] getDataBytes() {
        return ByteUtil.clone(this.dataBytes);
    }

    public byte[] getSignature() {
        return ByteUtil.clone(this.signature);
    }

    public void setAlgId(CredentialSignAlg credentialSignAlg) {
        this.algId = credentialSignAlg;
    }

    public void setDataBytes(byte[] bArr) {
        this.dataBytes = ByteUtil.clone(bArr);
    }

    public void setSignature(byte[] bArr) {
        this.signature = ByteUtil.clone(bArr);
    }
}
