package com.huawei.location.lite.common.security;

import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;

public class dC implements Vw {

    /* renamed from: yn  reason: collision with root package name */
    private FB f50154yn = new FB();

    public String decrypt(String str, String str2) {
        String str3;
        if (this.f50154yn == null) {
            str3 = "rootKey is null";
        } else if (str.isEmpty()) {
            return "";
        } else {
            try {
                return AesCbc.decrypt(str, this.f50154yn.a());
            } catch (Exception unused) {
                str3 = "AesCbc decrypt failed";
            }
        }
        LogConsole.e("ACECipher", str3);
        return "";
    }

    public String encrypt(String str, String str2) {
        String str3;
        if (this.f50154yn == null) {
            str3 = "rootKey is null";
        } else if (str.isEmpty()) {
            return "";
        } else {
            try {
                return AesCbc.encrypt(str, this.f50154yn.a());
            } catch (Exception unused) {
                str3 = "AesCbc encrypt failed";
            }
        }
        LogConsole.e("ACECipher", str3);
        return "";
    }
}
