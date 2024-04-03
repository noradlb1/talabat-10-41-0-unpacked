package com.huawei.wisesecurity.kfs.crypto.signer.hmac;

import com.huawei.wisesecurity.kfs.crypto.signer.DefaultSignHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.DefaultVerifyHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.SignHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.SignText;
import com.huawei.wisesecurity.kfs.crypto.signer.VerifyHandler;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class HmacSigner implements KfsSigner {
    public final Key key;
    public final SignAlg signAlg;

    public static class Builder {
        public static final String PROVIDER_ANDROID_KEYSTORE = "AndroidKeyStore";
        public Key key;
        public SignAlg signAlg = SignAlg.getPreferredAlg("HMAC");

        public HmacSigner build() throws CryptoException {
            Key key2 = this.key;
            if (key2 != null) {
                return new HmacSigner(this.signAlg, key2);
            }
            throw new CryptoException("key cannot be null");
        }

        public Builder withAlg(SignAlg signAlg2) {
            this.signAlg = signAlg2;
            return this;
        }

        public Builder withKey(Key key2) {
            this.key = key2;
            return this;
        }

        public Builder withKey(byte[] bArr) {
            this.key = new SecretKeySpec(bArr, this.signAlg.getTransformation());
            return this;
        }

        public Builder withKeyStoreAlias(String str) throws KfsException {
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                instance.load((KeyStore.LoadStoreParameter) null);
                this.key = instance.getKey(str, (char[]) null);
                return this;
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e11) {
                throw new KfsException("keystore get key with alias failed, " + e11.getMessage());
            }
        }
    }

    public HmacSigner(SignAlg signAlg2, Key key2) {
        this.signAlg = signAlg2;
        this.key = key2;
    }

    public SignHandler getSignHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        return new DefaultSignHandler(this.key, signText, (AlgorithmParameterSpec) null);
    }

    public VerifyHandler getVerifyHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        return new DefaultVerifyHandler(this.key, signText, (AlgorithmParameterSpec) null);
    }
}
