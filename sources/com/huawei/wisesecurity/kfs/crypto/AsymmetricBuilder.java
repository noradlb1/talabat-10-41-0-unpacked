package com.huawei.wisesecurity.kfs.crypto;

import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;

public abstract class AsymmetricBuilder<T> {
    public static final String PROVIDER_ANDROID_KEYSTORE = "AndroidKeyStore";
    public AlgorithmParameterSpec parameterSpec;
    public PrivateKey privateKey;
    public PublicKey publicKey;

    public abstract T build() throws CryptoException;

    public AsymmetricBuilder<T> withKey(Key key) {
        if (key instanceof PrivateKey) {
            this.privateKey = (PrivateKey) key;
        } else if (key instanceof PublicKey) {
            this.publicKey = (PublicKey) key;
        }
        return this;
    }

    public AsymmetricBuilder<T> withKeyStoreAlias(String str) throws KfsException {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            Key key = instance.getKey(str, (char[]) null);
            if (key instanceof PrivateKey) {
                this.privateKey = (PrivateKey) key;
                this.publicKey = instance.getCertificate(str).getPublicKey();
                return this;
            }
            throw new KfsException("bad private key type");
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e11) {
            throw new KfsException("keystore get key with alias failed, " + e11.getMessage());
        }
    }

    public AsymmetricBuilder<T> withParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
        this.parameterSpec = algorithmParameterSpec;
        return this;
    }

    public AsymmetricBuilder<T> withPrivateKey(PrivateKey privateKey2) {
        this.privateKey = privateKey2;
        return this;
    }

    public AsymmetricBuilder<T> withPublicKey(PublicKey publicKey2) {
        this.publicKey = publicKey2;
        return this;
    }
}
