package com.huawei.wisesecurity.kfs.crypto.key;

import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotBlank;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;

public class KeyGenerateParam {
    @KfsNotNull
    @KfsNotBlank
    public String alias;
    public int keyLen;
    @KfsNotNull
    public KfsKeyPurpose purpose;

    public static class Builder {
        public String alias;
        public int keyLen;
        public KfsKeyPurpose purpose;

        public Builder alias(String str) {
            this.alias = str;
            return this;
        }

        public KeyGenerateParam build() {
            return new KeyGenerateParam(this.alias, this.keyLen, this.purpose);
        }

        public Builder keyLen(int i11) {
            this.keyLen = i11;
            return this;
        }

        public Builder purpose(KfsKeyPurpose kfsKeyPurpose) {
            this.purpose = kfsKeyPurpose;
            return this;
        }
    }

    public KeyGenerateParam(String str, int i11, KfsKeyPurpose kfsKeyPurpose) {
        this.alias = str;
        this.keyLen = i11;
        this.purpose = kfsKeyPurpose;
    }

    public String getAlias() {
        return this.alias;
    }

    public int getKeyLen() {
        return this.keyLen;
    }

    public KfsKeyPurpose getPurpose() {
        return this.purpose;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setKeyLen(int i11) {
        this.keyLen = i11;
    }

    public void setPurpose(KfsKeyPurpose kfsKeyPurpose) {
        this.purpose = kfsKeyPurpose;
    }
}
