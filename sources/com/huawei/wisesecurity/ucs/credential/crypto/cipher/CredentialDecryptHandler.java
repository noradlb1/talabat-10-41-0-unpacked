package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.DecryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher;
import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.codec.Encoder;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsCryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.SkDkEntity;
import com.huawei.wisesecurity.ucs_credential.a;
import com.huawei.wisesecurity.ucs_credential.t;
import javax.crypto.spec.SecretKeySpec;

public class CredentialDecryptHandler implements DecryptHandler {
    public CredentialCipherText cipherText;
    public Credential credential;
    public CredentialClient credentialClient;

    public CredentialDecryptHandler(Credential credential2, CredentialCipherText credentialCipherText, CredentialClient credentialClient2) {
        this.credential = credential2;
        this.cipherText = credentialCipherText;
        this.credentialClient = credentialClient2;
    }

    private void doDecrypt() throws UcsCryptoException {
        t tVar = (t) new t().a().setApiName("appAuth.decrypt").setCallTime();
        try {
            this.cipherText.checkParam(false);
            this.cipherText.setPlainBytes(new AESCipher.Builder().withKey(new SecretKeySpec(SkDkEntity.from(this.credential.getDataKeyBytes()).decryptSkDk(a.a(this.credential.getKekString())), "AES")).withAlg(CipherAlg.AES_GCM).withIv(this.cipherText.getIv()).build().getDecryptHandler().from(this.cipherText.getCipherBytes()).to());
            tVar.setStatusCode(0);
            this.credentialClient.reportLogs(tVar);
        } catch (UcsParamException e11) {
            String str = "Fail to decrypt, errorMessage : " + e11.getMessage();
            tVar.setStatusCode(1001).setErrorMsg(str);
            throw new UcsCryptoException(UcsErrorCode.PARAM_ILLEGAL, str);
        } catch (CryptoException | UcsException e12) {
            String str2 = "Fail to decrypt, errorMessage : " + e12.getMessage();
            tVar.setStatusCode(1003).setErrorMsg(str2);
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, str2);
        } catch (Throwable th2) {
            this.credentialClient.reportLogs(tVar);
            throw th2;
        }
    }

    private CredentialDecryptHandler from(String str, Decoder decoder) throws UcsCryptoException {
        try {
            from(decoder.decode(str));
            return this;
        } catch (CodecException e11) {
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, "Fail to decode cipher text: " + e11.getMessage());
        }
    }

    private String to(Encoder encoder) throws UcsCryptoException {
        try {
            return encoder.encode(to());
        } catch (CodecException e11) {
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, "Fail to encode plain text: " + e11.getMessage());
        }
    }

    public CredentialDecryptHandler from(byte[] bArr) throws UcsCryptoException {
        if (bArr != null) {
            this.cipherText.setCipherBytes(bArr);
            return this;
        }
        throw new UcsCryptoException(UcsErrorCode.PARAM_ILLEGAL, "cipherBytes cannot null..");
    }

    public CredentialDecryptHandler fromBase64(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64);
    }

    public CredentialDecryptHandler fromBase64Url(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64Url);
    }

    public CredentialDecryptHandler fromHex(String str) throws UcsCryptoException {
        return from(str, Decoder.HEX);
    }

    public byte[] to() throws UcsCryptoException {
        doDecrypt();
        return this.cipherText.getPlainBytes();
    }

    public String toBase64() throws UcsCryptoException {
        return to(Encoder.BASE64);
    }

    public String toHex() throws UcsCryptoException {
        return to(Encoder.HEX);
    }

    public String toRawString() throws UcsCryptoException {
        return to(Encoder.RAW);
    }
}
