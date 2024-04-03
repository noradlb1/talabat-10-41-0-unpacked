package com.huawei.hms.analytics.core.log;

import android.util.Log;
import org.apache.commons.lang3.StringUtils;

public final class a implements LogAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f47910a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f47911b = 4;

    /* renamed from: c  reason: collision with root package name */
    private String f47912c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f47913d = false;

    private static void a(int i11, String str, String str2) {
        int length = str2.length();
        int i12 = 3000;
        int i13 = 0;
        for (int i14 = 0; i14 < (length / 3000) + 1; i14++) {
            if (length > i12) {
                if (i11 != 3) {
                    String substring = str2.substring(i13, i12);
                    if (i11 == 5) {
                        Log.w(str, substring);
                    } else if (i11 != 6) {
                        Log.i(str, substring);
                    } else {
                        Log.e(str, substring);
                    }
                } else {
                    str2.substring(i13, i12);
                }
                int i15 = i12;
                i12 += 3000;
                i13 = i15;
            } else if (i11 == 3) {
                str2.substring(i13, length);
            } else if (i11 == 5) {
                Log.w(str, str2.substring(i13, length));
            } else if (i11 != 6) {
                Log.i(str, str2.substring(i13, length));
            } else {
                Log.e(str, str2.substring(i13, length));
            }
        }
    }

    public final void init(int i11, String str) {
        if (this.f47913d) {
            this.f47911b = i11;
            this.f47912c = str;
            return;
        }
        this.f47913d = true;
        this.f47911b = i11;
        this.f47910a = true;
        this.f47912c = str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.getProperty("line.separator", StringUtils.LF) + "=======================================" + System.getProperty("line.separator", StringUtils.LF) + " ");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f47912c);
        sb3.append("_6.9.0.302");
        sb2.append(sb3.toString());
        sb2.append(System.getProperty("line.separator", StringUtils.LF) + "=======================================");
        Log.i(str, sb2.toString());
    }

    public final boolean isLoggable(int i11) {
        return this.f47910a && i11 >= this.f47911b;
    }

    public final void println(int i11, String str, String str2) {
        a(i11, this.f47912c, str + "=> " + str2);
    }

    public final void println(int i11, String str, String str2, String str3) {
        a(i11, this.f47912c, str + "=> " + str2 + "|" + str3);
    }
}
