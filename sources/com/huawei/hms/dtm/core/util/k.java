package com.huawei.hms.dtm.core.util;

import java.io.Closeable;
import java.io.IOException;

public final class k {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Logger.warn("closeable#IOException");
            }
        }
    }

    public static void a(String str, Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Logger.warn(str + "->closeable#IOException");
            }
        }
    }
}
