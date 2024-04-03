package com.instabug.crash.utils;

import com.instabug.crash.di.d;
import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;

public class CrashReportingUtility {
    public static boolean isCrashReportingEnabled() {
        boolean b11 = d.b().b();
        InstabugSDKLogger.v("IBG-CR", "isCrashReportingEnabled ? " + b11);
        if (!Instabug.isEnabled() || !b11) {
            return false;
        }
        return true;
    }
}
