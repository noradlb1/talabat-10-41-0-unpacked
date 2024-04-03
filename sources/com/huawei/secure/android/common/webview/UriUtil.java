package com.huawei.secure.android.common.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.net.MalformedURLException;
import java.net.URL;
import net.bytebuddy.description.type.TypeDescription;

public class UriUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34035a = "UriUtil";

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.i(f34035a, "whiteListUrl is null");
            return null;
        } else if (!URLUtil.isNetworkUrl(str)) {
            return str;
        } else {
            return getHostByURI(str);
        }
    }

    @TargetApi(9)
    public static String getHostByURI(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.i(f34035a, "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str)) {
                return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
            }
            LogsUtil.e(f34035a, "url don't starts with http or https");
            return "";
        } catch (MalformedURLException e11) {
            LogsUtil.e(f34035a, "getHostByURI error  MalformedURLException : " + e11.getMessage());
            return "";
        }
    }

    public static boolean isUrlHostAndPathInWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.e(f34035a, "whitelist is null");
            return false;
        }
        for (String isUrlHostAndPathMatchWhitelist : strArr) {
            if (isUrlHostAndPathMatchWhitelist(str, isUrlHostAndPathMatchWhitelist)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostAndPathMatchWhitelist(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.contains("..") || str.contains("@")) {
                Log.e(f34035a, "url contains unsafe char");
            } else {
                if (!str2.equals(str)) {
                    if (!str.startsWith(str2 + TypeDescription.Generic.OfWildcardType.SYMBOL)) {
                        if (!str.startsWith(str2 + "#")) {
                            if (!str2.endsWith("/")) {
                                return false;
                            }
                            if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                                return false;
                            }
                            return str.startsWith(str2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostInWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.e(f34035a, "whitelist is null");
            return false;
        }
        for (String isUrlHostMatchWhitelist : strArr) {
            if (isUrlHostMatchWhitelist(str, isUrlHostMatchWhitelist)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostMatchWhitelist(String str, String str2) {
        String hostByURI = getHostByURI(str);
        if (TextUtils.isEmpty(hostByURI) || TextUtils.isEmpty(str2)) {
            LogsUtil.e(f34035a, "url or whitelist is null");
            return false;
        }
        String a11 = a(str2);
        if (TextUtils.isEmpty(a11)) {
            Log.e(f34035a, "whitelist host is null");
            return false;
        } else if (a11.equals(hostByURI)) {
            return true;
        } else {
            if (hostByURI.endsWith(a11)) {
                try {
                    String substring = hostByURI.substring(0, hostByURI.length() - a11.length());
                    if (!substring.endsWith(RealDiscoveryConfigurationRepository.VERSION_DELIMETER)) {
                        return false;
                    }
                    return substring.matches("^[A-Za-z0-9.-]+$");
                } catch (IndexOutOfBoundsException e11) {
                    LogsUtil.e(f34035a, "IndexOutOfBoundsException" + e11.getMessage());
                } catch (Exception e12) {
                    LogsUtil.e(f34035a, "Exception : " + e12.getMessage());
                    return false;
                }
            }
            return false;
        }
    }

    public static boolean isUrlHostSameWhitelist(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return TextUtils.equals(getHostByURI(str), a(str2));
        }
        Log.e(f34035a, "isUrlHostSameWhitelist: url or host is null");
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.e(f34035a, "whitelist is null");
            return false;
        }
        for (String isUrlHostSameWhitelist : strArr) {
            if (isUrlHostSameWhitelist(str, isUrlHostSameWhitelist)) {
                return true;
            }
        }
        return false;
    }
}
