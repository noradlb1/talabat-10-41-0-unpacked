package com.huawei.hms.dtm;

import android.net.Uri;
import android.text.TextUtils;

public class F {
    public static String a(Uri uri, String str) {
        if (!(uri == null || TextUtils.isEmpty(str) || uri.getHost() == null || uri.getAuthority() == null)) {
            try {
                return uri.getQueryParameter(str);
            } catch (Exception e11) {
                B.b("SafeUri", "getQueryParameter: " + e11.getMessage());
            }
        }
        return "";
    }
}
