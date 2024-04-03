package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;

public class CredentialSigner implements KfsSigner {
    public Credential credential;
    public CredentialClient credentialClient;
    public CredentialSignText signText;

    public static class Builder {
        @KfsNotNull
        public Credential credential;
        @KfsNotNull
        public CredentialClient credentialClient;
        @KfsNotNull
        public CredentialSignAlg signAlg = CredentialSignAlg.HMAC_SHA256;

        public CredentialSigner build() throws UcsException {
            try {
                KfsValidator.validate(this);
                return new CredentialSigner(this.signAlg, this.credential, this.credentialClient);
            } catch (KfsValidationException e11) {
                throw new UcsParamException("CredentialCipher check param error : " + e11.getMessage());
            }
        }

        public Builder withAlg(CredentialSignAlg credentialSignAlg) {
            this.signAlg = credentialSignAlg;
            return this;
        }

        public Builder withCredential(Credential credential2) {
            this.credential = credential2;
            return this;
        }

        public Builder withCredentialClient(CredentialClient credentialClient2) {
            this.credentialClient = credentialClient2;
            return this;
        }
    }

    public CredentialSigner(CredentialSignAlg credentialSignAlg, Credential credential2, CredentialClient credentialClient2) {
        this.credential = credential2;
        CredentialSignText credentialSignText = new CredentialSignText();
        this.signText = credentialSignText;
        credentialSignText.setAlgId(credentialSignAlg);
        this.credentialClient = credentialClient2;
    }

    public CredentialSignHandler getSignHandler() {
        return new CredentialSignHandler(this.credential, this.signText, this.credentialClient);
    }

    public CredentialVerifyHandler getVerifyHandler() {
        return new CredentialVerifyHandler(this.credential, this.signText, this.credentialClient);
    }
}
