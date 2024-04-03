package com.huawei.location.vdr.util;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class yn {
    private static final Map<String, String> Vw;

    /* renamed from: yn  reason: collision with root package name */
    private static final Map<String, String> f50299yn;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("kirin990", "Kirin990");
        hashMap.put("kirin980", "Kirin980");
        hashMap.put("lahaina", "Snapdragon888");
        hashMap.put("kona", "Snapdragon865");
        hashMap.put("lito", "Snapdragon765");
        hashMap.put("mt6873", "Dimensity800");
        hashMap.put("mt6853", "Dimensity720");
        hashMap.put("mt6885", "Dimensity1000p");
        hashMap.put("erd9815_r", "Exynos1080");
        f50299yn = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("kirin990", "Kirin990");
        hashMap2.put("kirin980", "Kirin980");
        hashMap2.put("lahaina", "snapdragon888");
        hashMap2.put("kona", "snapdragon865");
        hashMap2.put("lito", "snapdragon765");
        hashMap2.put("mt6873", "tj800");
        hashMap2.put("mt6853", "tj720");
        hashMap2.put("mt6885", "tj1000");
        hashMap2.put("erd9815_r", "exynos1080");
        Vw = Collections.unmodifiableMap(hashMap2);
    }

    public static String Vw(String str) {
        String str2 = Vw.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    public static String yn(String str) {
        String str2 = f50299yn.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
