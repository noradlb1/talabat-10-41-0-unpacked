package com.huawei.location.lite.common.security;

import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;

class yn implements Vw {
    public String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            LogConsole.e("AesSecurityCipher", "decrypt alias or content is null");
            return "";
        }
        try {
            return AesGcmKS.decrypt(str2, str);
        } catch (Exception unused) {
            LogConsole.e("AesSecurityCipher", "AesGcmKS decrypt failed", true);
            return "";
        }
    }

    public String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            LogConsole.e("AesSecurityCipher", "encrypt alias or content is null");
            return "";
        }
        try {
            return AesGcmKS.encrypt(str2, str);
        } catch (Exception unused) {
            LogConsole.e("AesSecurityCipher", "AesGcmKS encrypt failed", true);
            return "";
        }
    }
}
