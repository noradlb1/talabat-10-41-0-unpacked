package com.huawei.wisesecurity.ucs.credential.crypto.signer;

public enum CredentialSignAlg {
    HMAC_SHA256(0);
    

    /* renamed from: id  reason: collision with root package name */
    public int f44856id;

    /* access modifiers changed from: public */
    CredentialSignAlg(int i11) {
        this.f44856id = i11;
    }

    public int getId() {
        return this.f44856id;
    }
}
