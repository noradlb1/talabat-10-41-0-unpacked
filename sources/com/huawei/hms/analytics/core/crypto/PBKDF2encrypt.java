package com.huawei.hms.analytics.core.crypto;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;

public class PBKDF2encrypt {
    public static byte[] pbkdf2(char[] cArr, byte[] bArr, int i11, int i12) {
        return PBKDF2.pbkdf2(cArr, bArr, i11, i12);
    }
}
