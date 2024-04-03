package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.crypto.AsymmetricBuilder;
import com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner;

public abstract class AsymmetricSignerBuilder<T extends KfsSigner> extends AsymmetricBuilder<T> {
    public SignAlg signAlg;

    public AsymmetricSignerBuilder<T> withAlg(SignAlg signAlg2) {
        this.signAlg = signAlg2;
        return this;
    }
}
