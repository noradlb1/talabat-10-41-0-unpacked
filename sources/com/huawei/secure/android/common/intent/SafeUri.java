package com.huawei.secure.android.common.intent;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SafeUri {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33830a = "SafeUri";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33831b = "";

    private SafeUri() {
    }

    @SuppressLint({"NewApi"})
    public static boolean getBooleanQueryParameter(Uri uri, String str, boolean z11) {
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                return uri.getBooleanQueryParameter(str, z11);
            } catch (Exception e11) {
                String str2 = f33830a;
                Log.e(str2, "getBooleanQueryParameter: " + e11.getMessage());
            }
        }
        return z11;
    }

    public static String getQueryParameter(Uri uri, String str) {
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                return uri.getQueryParameter(str);
            } catch (Exception e11) {
                String str2 = f33830a;
                Log.e(str2, "getQueryParameter: " + e11.getMessage());
            }
        }
        return "";
    }

    @SuppressLint({"NewApi"})
    public static Set<String> getQueryParameterNames(Uri uri) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (uri == null) {
            return linkedHashSet;
        }
        try {
            return uri.getQueryParameterNames();
        } catch (Exception e11) {
            String str = f33830a;
            Log.e(str, "getQueryParameterNames: " + e11.getMessage());
            return linkedHashSet;
        }
    }

    public static List<String> getQueryParameters(Uri uri, String str) {
        ArrayList arrayList = new ArrayList();
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                return uri.getQueryParameters(str);
            } catch (Exception e11) {
                String str2 = f33830a;
                Log.e(str2, "getQueryParameters: " + e11.getMessage());
            }
        }
        return arrayList;
    }
}
