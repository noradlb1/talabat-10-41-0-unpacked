package com.huawei.location.lite.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class StringUtil {
    private static final Pattern INT_PATTERN = Pattern.compile("\\d+");
    private static final String TAG = "LocationStringUtil";
    private static final Pattern VALID_PATTERN = Pattern.compile("^[.0-9a-zA-Z_-]{1,}$");

    public static String getDefaultValue(String str, String str2) {
        return isEmpty(str) ? str2 : str;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return INT_PATTERN.matcher(str).matches();
    }

    public static boolean isValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return VALID_PATTERN.matcher(str).matches();
    }

    public static boolean isValid(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.isEmpty(str2) ? isValid(str) : Pattern.compile(str2).matcher(str).matches();
    }

    public static String replaceValue(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        return str.replaceAll("(?i)" + str2, str3);
    }
}
