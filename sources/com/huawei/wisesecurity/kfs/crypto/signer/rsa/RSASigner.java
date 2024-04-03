package com.huawei.wisesecurity.kfs.crypto.signer.rsa;

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

public class RSASigner implements KfsSigner {
    public final AlgorithmParameterSpec parameterSpec;
    public final PrivateKey privateKey;
    public final PublicKey publicKey;
    public final SignAlg signAlg;

    public static class Builder extends AsymmetricSignerBuilder<RSASigner> {
        public Builder() {
            withAlg(SignAlg.getPreferredAlg("RSA"));
        }

        public RSASigner build() throws CryptoException {
            return new RSASigner(this.signAlg, this.privateKey, this.publicKey, this.parameterSpec);
        }
    }

    public RSASigner(SignAlg signAlg2, PrivateKey privateKey2, PublicKey publicKey2, AlgorithmParameterSpec algorithmParameterSpec) {
        this.signAlg = signAlg2;
        this.privateKey = privateKey2;
        this.publicKey = publicKey2;
        this.parameterSpec = algorithmParameterSpec;
    }

    public SignHandler getSignHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        PrivateKey privateKey2 = this.privateKey;
        if (privateKey2 != null) {
            return new DefaultSignHandler(privateKey2, signText, this.parameterSpec);
        }
        throw new CryptoException("privateKey is invalid.");
    }

    public VerifyHandler getVerifyHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        PublicKey publicKey2 = this.publicKey;
        if (publicKey2 != null) {
            return new DefaultVerifyHandler(publicKey2, signText, this.parameterSpec);
        }
        throw new CryptoException("publicKey is invalid.");
    }
}
