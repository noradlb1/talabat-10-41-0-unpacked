package com.instabug.library.util;

import java.io.Closeable;

public abstract class g {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th2) {
                InstabugSDKLogger.e("IBG-Core", "Failed to close " + closeable.getClass().getSimpleName(), th2);
            }
        }
    }
}
