package com.huawei.secure.android.common.util;

import android.webkit.URLUtil;

public class UrlUtil {
    public static boolean isAboutUrl(String str) {
        return URLUtil.isAboutUrl(str);
    }

    public static boolean isAssetUrl(String str) {
        return URLUtil.isAssetUrl(str);
    }

    public static boolean isContentUrl(String str) {
        return URLUtil.isContentUrl(str);
    }

    public static boolean isDataUrl(String str) {
        return URLUtil.isDataUrl(str);
    }

    public static boolean isFileUrl(String str) {
        return URLUtil.isFileUrl(str);
    }

    public static boolean isHttpUrl(String str) {
        return URLUtil.isHttpUrl(str);
    }

    public static boolean isHttpsUrl(String str) {
        return URLUtil.isHttpsUrl(str);
    }

    public static boolean isJavaScriptUrl(String str) {
        return URLUtil.isJavaScriptUrl(str);
    }

    public static boolean isNetworkUrl(String str) {
        return URLUtil.isNetworkUrl(str);
    }

    public static boolean isResourceUrl(String str) {
        if (str == null || !str.startsWith("file:///android_res/")) {
            return false;
        }
        return true;
    }

    public static boolean isValidUrl(String str) {
        return URLUtil.isValidUrl(str);
    }
}
