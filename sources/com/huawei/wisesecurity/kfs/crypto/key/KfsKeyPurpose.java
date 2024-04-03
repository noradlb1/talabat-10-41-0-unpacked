package com.huawei.wisesecurity.kfs.crypto.key;

public enum KfsKeyPurpose {
    PURPOSE_CRYPTO(3),
    PURPOSE_SIGN(12),
    PURPOSE_ALL(47);
    
    public final int value;

    /* access modifiers changed from: public */
    KfsKeyPurpose(int i11) {
        this.value = i11;
    }

    public static boolean containsPurpose(KfsKeyPurpose kfsKeyPurpose, KfsKeyPurpose kfsKeyPurpose2) {
        int i11 = kfsKeyPurpose.value;
        int i12 = kfsKeyPurpose2.value;
        return (i11 & i12) == i12;
    }

    public int getValue() {
        return this.value;
    }
}
