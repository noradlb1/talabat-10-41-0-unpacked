package com.huawei.wisesecurity.kfs.crypto.key;

import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.RequiresApi;
import com.adjust.sdk.Constants;
import com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.ec.ECSigner;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIn;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;

public class ECKeyStoreKeyManager extends KeyStoreKeyManager {
    public static final AlgorithmParameterSpec EC_PRIME256_PARAMETER_SPEC = new ECGenParameterSpec("secp256r1");

    public static class ECGenerateKeyParam {
        @KfsIn(intArr = {256})
        public final int keyLen;
        @KfsIn(intArr = {12}, message = "bad purpose")
        public final int purpose;

        public ECGenerateKeyParam(KeyGenerateParam keyGenerateParam) {
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
            KeyPairGenerator instance = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
            instance.initialize(new KeyGenParameterSpec.Builder(this.param.getAlias(), 15).setDigests(new String[]{Constants.SHA256, "SHA-384", "SHA-512"}).setAlgorithmParameterSpec(EC_PRIME256_PARAMETER_SPEC).setKeySize(this.param.getKeyLen()).build());
            if (instance.generateKeyPair() == null) {
                throw new KfsException("generate ec key pair failed with bad key");
            }
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e11) {
            throw new KfsException("generate ec key pair failed, " + e11.getMessage());
        }
    }

    public void validateKey() throws KfsException {
        validateSign((KfsSigner) new ECSigner.Builder().withAlg(SignAlg.ECDSA).withKeyStoreAlias(this.param.getAlias()).build());
    }

    public void validateParam(KeyGenerateParam keyGenerateParam) throws KfsValidationException {
        KfsValidator.validate(new ECGenerateKeyParam(keyGenerateParam));
    }
}
