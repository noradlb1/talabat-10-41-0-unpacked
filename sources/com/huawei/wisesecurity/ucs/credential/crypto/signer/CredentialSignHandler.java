package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.codec.Encoder;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.SignHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.hmac.HmacSigner;
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

public class CredentialSignHandler implements SignHandler {
    public Credential credential;
    public CredentialClient credentialClient;
    public CredentialSignText signText;

    public CredentialSignHandler(Credential credential2, CredentialSignText credentialSignText, CredentialClient credentialClient2) {
        this.credential = credential2;
        this.signText = credentialSignText;
        this.credentialClient = credentialClient2;
    }

    private void doSign() throws UcsCryptoException {
        t tVar = (t) new t().a().setApiName("appAuth.sign").setCallTime();
        try {
            this.signText.checkParam(true);
            this.signText.setSignature(new HmacSigner.Builder().withKey(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(a.a(this.credential.getKekString()))).withAlg(SignAlg.HMAC_SHA256).build().getSignHandler().from(this.signText.getDataBytes()).sign());
            tVar.setStatusCode(0);
            this.credentialClient.reportLogs(tVar);
        } catch (UcsParamException e11) {
            String str = "Fail to sign, errorMessage : " + e11.getMessage();
            tVar.setStatusCode(1001).setErrorMsg(str);
            throw new UcsCryptoException(UcsErrorCode.PARAM_ILLEGAL, str);
        } catch (CryptoException | UcsException e12) {
            String str2 = "Fail to sign, errorMessage : " + e12.getMessage();
            tVar.setStatusCode(1003).setErrorMsg(str2);
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, str2);
        } catch (Throwable th2) {
            this.credentialClient.reportLogs(tVar);
            throw th2;
        }
    }

    private CredentialSignHandler from(String str, Decoder decoder) throws UcsCryptoException {
        try {
            from(decoder.decode(str));
            return this;
        } catch (CodecException e11) {
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, "Fail to decode plain text : " + e11.getMessage());
        }
    }

    private String sign(Encoder encoder) throws UcsCryptoException {
        try {
            doSign();
            return encoder.encode(this.signText.getSignature());
        } catch (CodecException e11) {
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, "Fail to encode signature bytes: " + e11.getMessage());
        }
    }

    public CredentialSignHandler from(String str) throws UcsCryptoException {
        if (!TextUtils.isEmpty(str)) {
            return from(str.getBytes(StandardCharsets.UTF_8));
        }
        throw new UcsCryptoException(UcsErrorCode.PARAM_ILLEGAL, "dataString cannot empty..");
    }

    public CredentialSignHandler from(byte[] bArr) {
        this.signText.setDataBytes(ByteUtil.clone(bArr));
        return this;
    }

    public CredentialSignHandler fromBase64(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64);
    }

    public CredentialSignHandler fromBase64Url(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64Url);
    }

    public CredentialSignHandler fromHex(String str) throws UcsCryptoException {
        return from(str, Decoder.HEX);
    }

    public byte[] sign() throws UcsCryptoException {
        doSign();
        return this.signText.getSignature();
    }

    public String signBase64() throws UcsCryptoException {
        return sign(Encoder.BASE64);
    }

    public String signBase64Url() throws UcsCryptoException {
        return sign(Encoder.BASE64Url);
    }

    public String signHex() throws UcsCryptoException {
        return sign(Encoder.HEX);
    }
}
