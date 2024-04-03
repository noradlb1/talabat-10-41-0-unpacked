package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.AesDecrypt;
import java.io.UnsupportedEncodingException;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private final AesDecrypt f47514a;

    public k(Context context, String str) {
        this.f47514a = (TextUtils.isEmpty(a(context, str)) || Build.VERSION.SDK_INT < 26) ? new g(context, str) : new h(context, str);
    }

    private String a(Context context, String str) {
        String a11 = l.a(context, str, "agc_plugin_", "crypto");
        if (a11 == null) {
            return null;
        }
        try {
            return new String(Hex.decodeHexString(a11), "utf-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e11) {
            Log.e("ReaderStrategy", "UnsupportedEncodingException" + e11.getMessage());
            return null;
        }
    }

    public String a(String str, String str2) {
        return this.f47514a.decrypt(str, str2);
    }
}
