package com.huawei.wisesecurity.ucs.common.log;

import android.util.Log;

public class LogUcsDefault implements ILogUcs {
    public void d(String str, String str2) {
    }

    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    public void w(String str, String str2) {
        Log.w(str, str2);
    }
}
