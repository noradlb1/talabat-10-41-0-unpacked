package com.huawei.wisesecurity.kfs.crypto.cipher.rsa;

import com.adjust.sdk.Constants;
import com.huawei.wisesecurity.kfs.crypto.AsymmetricBuilder;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherText;
import com.huawei.wisesecurity.kfs.crypto.cipher.DecryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.DefaultDecryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.DefaultEncryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.EncryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public class RSACipher implements KfsCipher {
    public final CipherAlg cipherAlg;
    public final AlgorithmParameterSpec parameterSpec;
    public final PrivateKey privateKey;
    public final PublicKey publicKey;

    public static class Builder extends AsymmetricBuilder<RSACipher> {
        public CipherAlg cipherAlg = CipherAlg.getPreferredAlg("RSA");
        public final AlgorithmParameterSpec parameterSpec = new OAEPParameterSpec(Constants.SHA256, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);

        public RSACipher build() throws CryptoException {
            return new RSACipher(this.cipherAlg, this.privateKey, this.publicKey, this.parameterSpec);
        }

        public Builder withAlg(CipherAlg cipherAlg2) {
            this.cipherAlg = cipherAlg2;
            return this;
        }
    }

    public RSACipher(CipherAlg cipherAlg2, PrivateKey privateKey2, PublicKey publicKey2, AlgorithmParameterSpec algorithmParameterSpec) {
        this.cipherAlg = cipherAlg2;
        this.privateKey = privateKey2;
        this.publicKey = publicKey2;
        this.parameterSpec = algorithmParameterSpec;
    }

    public DecryptHandler getDecryptHandler() throws CryptoException {
        CipherText cipherText = new CipherText();
        cipherText.setAlgId(this.cipherAlg);
        PrivateKey privateKey2 = this.privateKey;
        if (privateKey2 != null) {
            return new DefaultDecryptHandler(privateKey2, cipherText, this.parameterSpec);
        }
        throw new CryptoException("privateKey is invalid.");
    }

    public EncryptHandler getEncryptHandler() throws CryptoException {
        CipherText cipherText = new CipherText();
        cipherText.setAlgId(this.cipherAlg);
        PublicKey publicKey2 = this.publicKey;
        if (publicKey2 != null) {
            return new DefaultEncryptHandler(publicKey2, cipherText, this.parameterSpec);
        }
        throw new CryptoException("publicKey is invalid.");
    }
}
