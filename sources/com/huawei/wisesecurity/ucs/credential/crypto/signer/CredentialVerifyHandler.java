package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.VerifyHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.hmac.HmacSigner;
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
import java.nio.charset.StandardCharsets;

public class CredentialVerifyHandler implements VerifyHandler {
    public Credential credential;
    public CredentialClient credentialClient;
    public CredentialSignText signText;

    public CredentialVerifyHandler(Credential credential2, CredentialSignText credentialSignText, CredentialClient credentialClient2) {
        this.credential = credential2;
        this.signText = credentialSignText;
        this.credentialClient = credentialClient2;
    }

    private boolean checkSignature(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    private boolean doVerify() throws UcsCryptoException {
        t tVar = (t) new t().a().setApiName("appAuth.verify").setCallTime();
        try {
            this.signText.checkParam(false);
            boolean checkSignature = checkSignature(new HmacSigner.Builder().withKey(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(a.a(this.credential.getKekString()))).withAlg(SignAlg.HMAC_SHA256).build().getSignHandler().from(this.signText.getDataBytes()).sign(), this.signText.getSignature());
            tVar.setStatusCode(0);
            this.credentialClient.reportLogs(tVar);
            return checkSignature;
        } catch (UcsParamException e11) {
            String str = "Fail to verify, errorMessage : " + e11.getMessage();
            tVar.setStatusCode(1001).setErrorMsg(str);
            throw new UcsCryptoException(UcsErrorCode.PARAM_ILLEGAL, str);
        } catch (CryptoException | UcsException e12) {
            String str2 = "Fail to verify, errorMessage : " + e12.getMessage();
            tVar.setStatusCode(1003).setErrorMsg(str2);
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, str2);
        } catch (Throwable th2) {
            this.credentialClient.reportLogs(tVar);
            throw th2;
        }
    }

    private CredentialVerifyHandler fromData(String str, Decoder decoder) throws UcsCryptoException {
        try {
            fromData(decoder.decode(str));
            return this;
        } catch (CodecException e11) {
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, "Fail to decode sign data: " + e11.getMessage());
        }
    }

    private boolean verify(String str, Decoder decoder) throws UcsCryptoException {
        try {
            return verify(decoder.decode(str));
        } catch (CodecException e11) {
            throw new UcsCryptoException(UcsErrorCode.CRYPTO_ERROR, "Fail to decode signature : " + e11.getMessage());
        }
    }

    public CredentialVerifyHandler fromBase64Data(String str) throws UcsCryptoException {
        return fromData(str, Decoder.BASE64);
    }

    public CredentialVerifyHandler fromBase64UrlData(String str) throws UcsCryptoException {
        return fromData(str, Decoder.BASE64Url);
    }

    public CredentialVerifyHandler fromData(String str) throws UcsCryptoException {
        if (!TextUtils.isEmpty(str)) {
            return fromData(str.getBytes(StandardCharsets.UTF_8));
        }
        throw new UcsCryptoException(UcsErrorCode.PARAM_ILLEGAL, "dataString cannot empty..");
    }

    public CredentialVerifyHandler fromData(byte[] bArr) {
        this.signText.setDataBytes(bArr);
        return this;
    }

    public CredentialVerifyHandler fromHexData(String str) throws UcsCryptoException {
        return fromData(str, Decoder.HEX);
    }

    public boolean verify(String str) throws UcsCryptoException {
        if (!TextUtils.isEmpty(str)) {
            return verify(str.getBytes(StandardCharsets.UTF_8));
        }
        throw new UcsCryptoException(UcsErrorCode.PARAM_ILLEGAL, "signature cannot empty..");
    }

    public boolean verify(byte[] bArr) throws UcsCryptoException {
        this.signText.setSignature(bArr);
        return doVerify();
    }

    public boolean verifyBase64(String str) throws UcsCryptoException {
        return verify(str, Decoder.BASE64);
    }

    public boolean verifyBase64Url(String str) throws UcsCryptoException {
        return verify(str, Decoder.BASE64Url);
    }

    public boolean verifyHex(String str) throws UcsCryptoException {
        return verify(str, Decoder.HEX);
    }
}
