package com.huawei.wisesecurity.kfs.crypto.key;

import android.util.Log;
import com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher;
import com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.exception.KfsKeyStoreException;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.util.RandomUtil;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;

public abstract class KeyStoreKeyManager implements KfsKeyManager {
    public static final String TAG = "KeyStoreKeyManager";
    public static KeyStore mKeyStore;
    public KeyGenerateParam param;

    private void clearKey(String str) throws KfsException {
        if (hasAlias(str)) {
            try {
                mKeyStore.deleteEntry(str);
                Log.i(TAG, "keyEntry: " + str + " removed");
            } catch (KeyStoreException e11) {
                throw new KfsException("delete key entry failed, " + e11.getMessage());
            }
        }
    }

    public static void initKeyStore() throws KfsException {
        if (mKeyStore == null) {
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                mKeyStore = instance;
                instance.load((KeyStore.LoadStoreParameter) null);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e11) {
                throw new KfsException("init keystore failed, " + e11.getMessage());
            }
        }
    }

    public void generate(KeyGenerateParam keyGenerateParam) throws KfsException {
        this.param = keyGenerateParam;
        KfsValidator.validate(keyGenerateParam);
        validateParam(keyGenerateParam);
        generateKey();
        try {
            validateKey();
        } catch (KfsException e11) {
            Log.i(TAG, "validate key failed, try to remove the key entry for alias:" + keyGenerateParam.getAlias());
            clearKey(keyGenerateParam.getAlias());
            throw e11;
        }
    }

    public abstract void generateKey() throws KfsException;

    public Key getKey(String str) throws KfsException {
        initKeyStore();
        try {
            return mKeyStore.getKey(str, (char[]) null);
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e11) {
            throw new KfsException("keystore get key failed, " + e11.getMessage());
        }
    }

    public PrivateKey getPrivateKey(String str) throws KfsException {
        initKeyStore();
        try {
            return (PrivateKey) mKeyStore.getKey(str, (char[]) null);
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e11) {
            throw new KfsException("keystore get private key failed, " + e11.getMessage());
        }
    }

    public PublicKey getPublicKey(String str) throws KfsException {
        initKeyStore();
        try {
            return mKeyStore.getCertificate(str).getPublicKey();
        } catch (KeyStoreException e11) {
            throw new KfsException("keystore get public key failed, " + e11.getMessage());
        }
    }

    public boolean hasAlias(String str) throws KfsException {
        initKeyStore();
        try {
            return mKeyStore.containsAlias(str);
        } catch (KeyStoreException e11) {
            throw new KfsException("keystore check alias failed, " + e11.getMessage());
        }
    }

    public void validateCrypto(KfsCipher kfsCipher) throws KfsException {
        byte[] generateRandomBytes = RandomUtil.generateRandomBytes(32);
        if (!Arrays.equals(generateRandomBytes, kfsCipher.getDecryptHandler().from(kfsCipher.getEncryptHandler().from(generateRandomBytes).to()).to())) {
            throw new KfsKeyStoreException("validate crypto key get bad result");
        }
    }

    public abstract void validateKey() throws KfsException;

    public abstract void validateParam(KeyGenerateParam keyGenerateParam) throws KfsValidationException;

    public void validateSign(KfsSigner kfsSigner) throws KfsException {
        byte[] generateRandomBytes = RandomUtil.generateRandomBytes(32);
        if (!kfsSigner.getVerifyHandler().fromData(generateRandomBytes).verify(kfsSigner.getSignHandler().from(generateRandomBytes).sign())) {
            throw new KfsKeyStoreException("validate sign key get bad result");
        }
    }
}
