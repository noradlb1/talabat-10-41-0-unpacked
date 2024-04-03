package com.huawei.wisesecurity.kfs.crypto.key;

import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.RequiresApi;
import com.adjust.sdk.Constants;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.hmac.HmacSigner;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.exception.KfsKeyStoreException;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIn;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.KeyGenerator;

public class HmacKeyStoreKeyManager extends KeyStoreKeyManager {

    public static class HmacGenerateKeyParam {
        @KfsIn(intArr = {128, 192, 256})
        public final int keyLen;
        @KfsIn(intArr = {12}, message = "bad purpose")
        public final int purpose;

        public HmacGenerateKeyParam(KeyGenerateParam keyGenerateParam) {
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
            KeyGenerator instance = KeyGenerator.getInstance("HmacSHA256", "AndroidKeyStore");
            instance.init(new KeyGenParameterSpec.Builder(this.param.getAlias(), 12).setDigests(new String[]{Constants.SHA256}).setKeySize(this.param.getKeyLen()).build());
            if (instance.generateKey() == null) {
                throw new KfsException("generate hmac failed with bad key");
            }
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e11) {
            throw new KfsKeyStoreException("generate hmac key failed, " + e11.getMessage());
        }
    }

    public void validateKey() throws KfsException {
        validateSign(new HmacSigner.Builder().withAlg(SignAlg.HMAC_SHA256).withKeyStoreAlias(this.param.getAlias()).build());
    }

    public void validateParam(KeyGenerateParam keyGenerateParam) throws KfsValidationException {
        KfsValidator.validate(new HmacGenerateKeyParam(keyGenerateParam));
    }
}
