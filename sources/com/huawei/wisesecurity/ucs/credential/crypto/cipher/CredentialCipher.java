package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.util.ByteUtil;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;

public class CredentialCipher implements KfsCipher {
    public CredentialCipherText cipherText;
    public Credential credential;
    public CredentialClient credentialClient;

    public static class Builder {
        @KfsNotNull
        public CredentialCipherAlg cipherAlg = CredentialCipherAlg.AES_GCM;
        @KfsNotNull
        public Credential credential;
        @KfsNotNull
        public CredentialClient credentialClient;
        @KfsNotNull

        /* renamed from: iv  reason: collision with root package name */
        public byte[] f44853iv;

        public CredentialCipher build() throws UcsException {
            try {
                KfsValidator.validate(this);
                return new CredentialCipher(this.cipherAlg, this.credential, this.f44853iv, this.credentialClient);
            } catch (KfsValidationException e11) {
                throw new UcsParamException("CredentialCipher check param error : " + e11.getMessage());
            }
        }

        public Builder withAlg(CredentialCipherAlg credentialCipherAlg) {
            this.cipherAlg = credentialCipherAlg;
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

        public Builder withIv(byte[] bArr) {
            this.f44853iv = ByteUtil.clone(bArr);
            return this;
        }
    }

    public CredentialCipher(CredentialCipherAlg credentialCipherAlg, Credential credential2, byte[] bArr, CredentialClient credentialClient2) {
        this.credential = credential2;
        CredentialCipherText credentialCipherText = new CredentialCipherText();
        credentialCipherText.setAlgId(credentialCipherAlg);
        credentialCipherText.setIv(bArr);
        this.cipherText = credentialCipherText;
        this.credentialClient = credentialClient2;
    }

    public CredentialDecryptHandler getDecryptHandler() {
        return new CredentialDecryptHandler(this.credential, this.cipherText, this.credentialClient);
    }

    public CredentialEncryptHandler getEncryptHandler() {
        return new CredentialEncryptHandler(this.credential, this.cipherText, this.credentialClient);
    }
}
