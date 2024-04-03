package com.huawei.agconnect.common.api;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.security.SecureRandom;

public class RandomWrapper {
    public static byte[] generateSecureRandom(int i11) {
        EncryptUtil.setBouncycastleFlag(true);
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(i11);
        if (generateSecureRandom.length != 0) {
            return generateSecureRandom;
        }
        byte[] bArr = new byte[i11];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
