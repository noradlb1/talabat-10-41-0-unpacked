package com.huawei.location.lite.common.security;

import com.huawei.location.lite.common.log.LogConsole;

public class LocationSecurityManager implements Vw {
    private static final String TAG = "LocationSecurityManager";
    private final int securityType;

    public LocationSecurityManager(int i11) {
        this.securityType = i11;
    }

    private Vw getSecurity() {
        int i11 = this.securityType;
        if (i11 == 1) {
            return new LW();
        }
        if (i11 == 2) {
            return new OpensslSm4Security();
        }
        if (i11 == 3) {
            return new yn();
        }
        if (i11 != 4) {
            return null;
        }
        return new dC();
    }

    public String decrypt(String str, String str2) {
        Vw security = getSecurity();
        if (security != null) {
            return security.decrypt(str, str2);
        }
        LogConsole.e(TAG, "locationCipher is null");
        return str;
    }

    public String encrypt(String str, String str2) {
        Vw security = getSecurity();
        if (security != null) {
            return security.encrypt(str, str2);
        }
        LogConsole.e(TAG, "locationCipher is null");
        return str;
    }
}
