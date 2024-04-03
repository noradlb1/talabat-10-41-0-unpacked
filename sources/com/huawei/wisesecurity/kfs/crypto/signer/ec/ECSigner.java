package com.huawei.wisesecurity.kfs.crypto.signer.ec;

import com.huawei.wisesecurity.kfs.crypto.signer.AsymmetricSignerBuilder;
import com.huawei.wisesecurity.kfs.crypto.signer.DefaultSignHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.DefaultVerifyHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.SignHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.SignText;
import com.huawei.wisesecurity.kfs.crypto.signer.VerifyHandler;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;

public class ECSigner implements KfsSigner {
    public final PrivateKey privateKey;
    public final PublicKey publicKey;
    public final SignAlg signAlg;

    public static class Builder extends AsymmetricSignerBuilder<ECSigner> {
        public Builder() {
            withAlg(SignAlg.getPreferredAlg("EC"));
        }

        public ECSigner build() throws CryptoException {
            return new ECSigner(this.signAlg, this.privateKey, this.publicKey);
        }
    }

    public ECSigner(SignAlg signAlg2, PrivateKey privateKey2, PublicKey publicKey2) {
        this.signAlg = signAlg2;
        this.privateKey = privateKey2;
        this.publicKey = publicKey2;
    }

    public SignHandler getSignHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        PrivateKey privateKey2 = this.privateKey;
        if (privateKey2 != null) {
            return new DefaultSignHandler(privateKey2, signText, (AlgorithmParameterSpec) null);
        }
        throw new CryptoException("privateKey is invalid.");
    }

    public VerifyHandler getVerifyHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        PublicKey publicKey2 = this.publicKey;
        if (publicKey2 != null) {
            return new DefaultVerifyHandler(publicKey2, signText, (AlgorithmParameterSpec) null);
        }
        throw new CryptoException("publicKey is invalid.");
    }
}
