package com.huawei.hms.analytics.core.transport.net;

import com.huawei.hms.analytics.core.log.HiLog;
import java.io.Closeable;
import java.io.IOException;

public final class a {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HiLog.w("StreamToolsKit", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }
}
