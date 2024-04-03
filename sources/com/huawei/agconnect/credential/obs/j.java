package com.huawei.agconnect.credential.obs;

import android.util.Log;

public class j {
    private static boolean a(int i11) {
        return Log.isLoggable("AGC_LOG", i11);
    }

    public void a(String str, String str2) {
        if (a(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[AGC_LOG]");
            sb2.append(str);
        }
    }

    public void a(String str, String str2, Throwable th2) {
        if (a(6)) {
            Log.e("[AGC_LOG]" + str, str2, th2);
        }
    }

    public void b(String str, String str2) {
        if (a(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[AGC_LOG]");
            sb2.append(str);
        }
    }

    public void c(String str, String str2) {
        if (a(4)) {
            Log.i("[AGC_LOG]" + str, str2);
        }
    }

    public void d(String str, String str2) {
        if (a(5)) {
            Log.w("[AGC_LOG]" + str, str2);
        }
    }
}
