package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.EncryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher;
import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.codec.Encoder;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.util.ByteUtil;
import com.huawei.wisesecurity.ucs.common.exception.UcsCryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.SkDkEntity;
import com.huawei.wisesecurity.ucs_credential.a;
import com.huawei.wisesecurity.ucs_credential.t;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.SecretKeySpec;

public class CredentialEncryptHandler implements EncryptHandler {
    public CredentialCipherText cipherText;
    public Credential credential;
    public CredentialClient credentialClient;

    public CredentialEncryptHandler(Credential credential2, CredentialCipherText credentialCipherText, CredentialClient credentialClient2) {
        this.credential = credential2;
        this.cipherText = credentialCipherText;
        this.credentialClient = credentialClient2;
    }

    private void doEncrypt() throws UcsCryptoException {
        t tVar = (t) new t().a().setApiName("appAuth.encrypt").setCallTime();
        try {
            this.cipherText.checkParam(true);
            this.cipherText.setCipherBytes(new AESCipher.Builder().withKey(new SecretKeySpec(SkDkEntity.from(this.credential.getDataKeyBytes()).decryptSkDk(a.a(this.credential.getKekString())), "AES")).withAlg(CipherAlg.AES_GCM).withIv(this.cipherText.getIv()).build().getEncryptHandler().from(this.cipherText.getPlainBytes()).to());
            tVar.setStatusCode(0);
            this.credentialClient.reportLogs(tVar);
        } catch (UcsParamException e11) {
            String str = "Fail to encrypt, errorMessage : " + e11.getMessage();
            tVar.setStatusCode(1001).setErrorMsg(str);
            throw new UcsCryptoException(UcsErrorCode.PARAM_ILLEGAL, str);
        } catch (CryptoException | UcsException e12) {
            String str2 = "Fail to encrypt, errorMessage : " + e12.getMessage();
            tVar.setStatusCode(1003).setErrorMsg(str2);
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, str2);
        } catch (Throwable th2) {
            this.credentialClient.reportLogs(tVar);
            throw th2;
        }
    }

    private CredentialEncryptHandler from(String str, Decoder decoder) throws UcsCryptoException {
        try {
            from(decoder.decode(str));
            return this;
        } catch (CodecException e11) {
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, "Fail to decode plain text : " + e11.getMessage());
        }
    }

    private String to(Encoder encoder) throws UcsCryptoException {
        try {
            doEncrypt();
            return encoder.encode(this.cipherText.getCipherBytes());
        } catch (CodecException e11) {
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, "Fail to encode cipher bytes: " + e11.getMessage());
        }
    }

    public CredentialEncryptHandler from(String str) throws UcsCryptoException {
        if (!TextUtils.isEmpty(str)) {
            return from(str.getBytes(StandardCharsets.UTF_8));
        }
        throw new UcsCryptoException(UcsErrorCode.PARAM_ILLEGAL, "plainText cannot empty..");
    }

    public CredentialEncryptHandler from(byte[] bArr) throws UcsCryptoException {
        if (bArr != null) {
            this.cipherText.setPlainBytes(ByteUtil.clone(bArr));
            return this;
        }
        throw new UcsCryptoException(UcsErrorCode.PARAM_ILLEGAL, "plainBytes cannot null..");
    }

    public CredentialEncryptHandler fromBase64(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64);
    }

    public CredentialEncryptHandler fromBase64Url(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64Url);
    }

    public CredentialEncryptHandler fromHex(String str) throws UcsCryptoException {
        return from(str, Decoder.HEX);
    }

    public byte[] to() throws UcsCryptoException {
        doEncrypt();
        return this.cipherText.getCipherBytes();
    }

    public String toBase64() throws UcsCryptoException {
        return to(Encoder.BASE64);
    }

    public String toBase64Url() throws UcsCryptoException {
        return to(Encoder.BASE64Url);
    }

    public String toHex() throws UcsCryptoException {
        return to(Encoder.HEX);
    }
}
