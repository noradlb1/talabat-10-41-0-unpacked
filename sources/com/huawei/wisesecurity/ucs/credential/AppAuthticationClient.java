package com.huawei.wisesecurity.ucs.credential;

import android.content.Context;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.hmac.HmacSigner;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;
import com.huawei.wisesecurity.ucs.common.exception.UcsCryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs.credential.crypto.signer.CredentialSignAlg;
import com.huawei.wisesecurity.ucs.credential.entity.SkDkEntity;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs_credential.v;
import java.util.List;

public class AppAuthticationClient {
    public CredentialSignAlg alg;
    public Context context;
    public Credential credential;
    public String extra;

    public static class Builder {
        @KfsNotNull
        public CredentialSignAlg alg = CredentialSignAlg.HMAC_SHA256;
        @KfsNotNull
        public Context context;
        @KfsNotNull
        public Credential credential;
        public String extra;

        public Builder alg(CredentialSignAlg credentialSignAlg) {
            this.alg = credentialSignAlg;
            return this;
        }

        public AppAuthticationClient build() throws UcsException {
            try {
                KfsValidator.validate(this);
                return new AppAuthticationClient(this.context, this.credential, this.extra, this.alg);
            } catch (KfsValidationException e11) {
                throw new UcsParamException("AppAuthticationClient check param error : " + e11.getMessage());
            }
        }

        public Builder context(Context context2) {
            this.context = context2;
            return this;
        }

        public Builder credential(Credential credential2) {
            this.credential = credential2;
            return this;
        }

        public Builder extra(String str) {
            this.extra = str;
            return this;
        }
    }

    public AppAuthticationClient(Context context2, Credential credential2, String str, CredentialSignAlg credentialSignAlg) {
        this.context = context2;
        this.credential = credential2;
        this.extra = str;
        this.alg = credentialSignAlg;
    }

    public String getAppAuthtication() throws UcsException {
        String str;
        String str2;
        try {
            v vVar = new v();
            vVar.f44890a = new v.a("HS256").toString();
            if (this.credential.getAkskVersion() < 1) {
                List<String> pkgNameCertFP = UcsLib.getPkgNameCertFP(this.context);
                str = pkgNameCertFP.get(0);
                str2 = pkgNameCertFP.get(1);
            } else {
                str = "";
                str2 = str;
            }
            vVar.f44891b = new v.b(str, str2, this.extra).toString();
            vVar.f44892c = StringUtil.base64EncodeToString(new HmacSigner.Builder().withKey(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(com.huawei.wisesecurity.ucs_credential.a.a(this.credential.getKekString()))).withAlg(SignAlg.HMAC_SHA256).build().getSignHandler().from(vVar.b()).sign(), 10);
            return vVar.a();
        } catch (UnsupportedOperationException unused) {
            throw new UcsException(2001, "new String UnsupportedOperationException..");
        } catch (UcsCryptoException e11) {
            throw new UcsException(1022, e11.getMessage());
        } catch (Exception e12) {
            throw new UcsException(2001, "app info auth Exception : " + e12.getMessage());
        }
    }
}
