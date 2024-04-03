package com.huawei.hms.hatool;

import android.util.Log;

public class m0 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f49078a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f49079b = 4;

    private static String a() {
        return "FormalHASDK_2.2.0.314" + p.a();
    }

    public void a(int i11) {
        Log.i("FormalHASDK", System.lineSeparator() + "======================================= " + System.lineSeparator() + a() + "" + System.lineSeparator() + "=======================================");
        this.f49079b = i11;
        this.f49078a = true;
    }

    public void a(int i11, String str, String str2) {
        if (i11 == 3) {
            return;
        }
        if (i11 == 5) {
            Log.w(str, str2);
        } else if (i11 != 6) {
            Log.i(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public void b(int i11, String str, String str2) {
        a(i11, "FormalHASDK", str + "=> " + str2);
    }

    public boolean b(int i11) {
        return this.f49078a && i11 >= this.f49079b;
    }
}
