package com.huawei.wisesecurity.kfs.crypto.key;

import android.annotation.SuppressLint;
import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.RequiresApi;
import com.adjust.sdk.Constants;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher;
import com.huawei.wisesecurity.kfs.crypto.cipher.rsa.RSACipher;
import com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.rsa.RSASigner;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIn;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class RSAKeyStoreKeyManager extends KeyStoreKeyManager {

    public static class RSAGenerateKeyParam {
        @KfsIn(intArr = {2048, 3072, 4096})
        public final int keyLen;

        public RSAGenerateKeyParam(KeyGenerateParam keyGenerateParam) {
            this.keyLen = keyGenerateParam.getKeyLen();
        }

        public int getKeyLen() {
            return this.keyLen;
        }
    }

    @RequiresApi(api = 23)
    @SuppressLint({"WrongConstant"})
    public void generateKey() throws KfsException {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            instance.initialize(new KeyGenParameterSpec.Builder(this.param.getAlias(), this.param.getPurpose().getValue()).setSignaturePaddings(new String[]{"PKCS1", "PSS"}).setEncryptionPaddings(new String[]{"PKCS1Padding", "OAEPPadding"}).setDigests(new String[]{Constants.SHA256, "SHA-384", "SHA-512"}).setKeySize(this.param.getKeyLen()).build());
            if (instance.generateKeyPair() == null) {
                throw new KfsException("generate rsa key pair failed with bad key");
            }
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e11) {
            throw new KfsException("generate rsa key pair failed, " + e11.getMessage());
        }
    }

    public void validateKey() throws KfsException {
        if (KfsKeyPurpose.containsPurpose(this.param.getPurpose(), KfsKeyPurpose.PURPOSE_CRYPTO)) {
            validateCrypto((KfsCipher) new RSACipher.Builder().withAlg(CipherAlg.RSA_OAEP).withKeyStoreAlias(this.param.getAlias()).build());
        }
        if (KfsKeyPurpose.containsPurpose(this.param.getPurpose(), KfsKeyPurpose.PURPOSE_SIGN)) {
            validateSign((KfsSigner) new RSASigner.Builder().withAlg(SignAlg.RSA_SHA256).withKeyStoreAlias(this.param.getAlias()).build());
        }
    }

    public void validateParam(KeyGenerateParam keyGenerateParam) throws KfsValidationException {
        KfsValidator.validate(new RSAGenerateKeyParam(keyGenerateParam));
    }
}
