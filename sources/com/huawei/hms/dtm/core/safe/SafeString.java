package com.huawei.hms.dtm.core.safe;

import com.huawei.hms.dtm.core.util.Logger;

public class SafeString {
    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (!(str == null || charSequence == null || charSequence2 == null)) {
            try {
                return str.replace(charSequence, charSequence2);
            } catch (Exception e11) {
                Logger.error("SafeString", "replace: " + e11.getMessage());
            }
        }
        return str;
    }

    public static String substring(String str, int i11) {
        if (str != null && str.length() >= i11 && i11 >= 0) {
            try {
                return str.substring(i11);
            } catch (Exception e11) {
                Logger.error("SafeString", "substring exception: " + e11.getMessage());
            }
        }
        return "";
    }

    public static String substring(String str, int i11, int i12) {
        if (str != null && i11 >= 0 && i12 <= str.length() && i12 >= i11) {
            try {
                return str.substring(i11, i12);
            } catch (Exception e11) {
                Logger.error("SafeString", "substring: " + e11.getMessage());
            }
        }
        return "";
    }
}
