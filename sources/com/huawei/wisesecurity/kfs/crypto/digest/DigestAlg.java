package com.huawei.wisesecurity.kfs.crypto.digest;

public enum DigestAlg {
    SHA256("sha-256");
    
    public final String alg;

    /* access modifiers changed from: public */
    DigestAlg(String str) {
        this.alg = str;
    }

    public String getTransformation() {
        return this.alg;
    }
}
