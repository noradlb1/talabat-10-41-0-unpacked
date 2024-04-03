package com.huawei.wisesecurity.kfs.crypto.key;

import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.RequiresApi;
import com.google.android.gms.stats.CodePackage;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.util.RandomUtil;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIn;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.KeyGenerator;

public class AESKeyStoreKeyManager extends KeyStoreKeyManager {

    public static class AESKeyGenerateParam {
        @KfsIn(intArr = {128, 192, 256})
        public final int keyLen;
        @KfsIn(intArr = {3}, message = "bad purpose")
        public final int purpose;

        public AESKeyGenerateParam(KeyGenerateParam keyGenerateParam) {
            this.keyLen = keyGenerateParam.getKeyLen();
            this.purpose = keyGenerateParam.getPurpose().getValue();
        }

        public int getKeyLen() {
            return this.keyLen;
        }

        public int getPurpose() {
            return this.purpose;
        }
    }

    @RequiresApi(api = 23)
    public void generateKey() throws KfsException {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance.init(new KeyGenParameterSpec.Builder(this.param.getAlias(), 3).setKeySize(this.param.getKeyLen()).setRandomizedEncryptionRequired(false).setBlockModes(new String[]{CodePackage.GCM, "CBC"}).setEncryptionPaddings(new String[]{"NoPadding", "PKCS7Padding"}).build());
            if (instance.generateKey() == null) {
                throw new KfsException("generate aes key failed with bad key");
            }
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e11) {
            throw new KfsException("generate aes key failed, " + e11.getMessage());
        }
    }

    public void validateKey() throws KfsException {
        CipherAlg cipherAlg = CipherAlg.AES_GCM;
        validateCrypto(new AESCipher.Builder().withAlg(cipherAlg).withKeyStoreAlias(this.param.getAlias()).withIv(RandomUtil.generateRandomBytes(cipherAlg.getIvLen())).build());
    }

    public void validateParam(KeyGenerateParam keyGenerateParam) throws KfsValidationException {
        KfsValidator.validate(new AESKeyGenerateParam(keyGenerateParam));
    }
}
