package com.huawei.hms.dtm.core.safe;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.util.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SafeUri {
    private SafeUri() {
    }

    public static boolean getBooleanQueryParameter(Uri uri, String str, boolean z11) {
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                return uri.getBooleanQueryParameter(str, z11);
            } catch (Exception e11) {
                Logger.error("SafeUri", "getBooleanQueryParameter: " + e11.getMessage());
            }
        }
        return z11;
    }

    public static String getQueryParameter(Uri uri, String str) {
        if (!(uri == null || TextUtils.isEmpty(str) || uri.getHost() == null || uri.getAuthority() == null)) {
            try {
                return uri.getQueryParameter(str);
            } catch (Exception e11) {
                Logger.error("SafeUri", "getQueryParameter: " + e11.getMessage());
            }
        }
        return "";
    }

    public static Set<String> getQueryParameterNames(Uri uri) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (uri == null) {
            return linkedHashSet;
        }
        try {
            return uri.getQueryParameterNames();
        } catch (Exception e11) {
            Logger.error("SafeUri", "getQueryParameterNames: " + e11.getMessage());
            return linkedHashSet;
        }
    }

    public static List<String> getQueryParameters(Uri uri, String str) {
        ArrayList arrayList = new ArrayList();
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                return uri.getQueryParameters(str);
            } catch (Exception e11) {
                Logger.error("SafeUri", "getQueryParameters: " + e11.getMessage());
            }
        }
        return arrayList;
    }
}
