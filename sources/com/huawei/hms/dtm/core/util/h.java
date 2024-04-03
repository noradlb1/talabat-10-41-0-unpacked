package com.huawei.hms.dtm.core.util;

import com.deliveryhero.perseus.data.remote.api.client.PerseusRetrofitBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class h {
    public static String a(Thread thread, Throwable th2) {
        if (thread == null || th2 == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        a(sb2);
        a(sb2, thread);
        a(sb2, th2);
        return sb2.length() >= 10000 ? sb2.substring(0, 10000) : sb2.toString();
    }

    private static void a(StringBuilder sb2) {
        String format = new SimpleDateFormat(PerseusRetrofitBuilder.DATE_FORMAT_DATE_TIME, Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
        sb2.append("CrashTime=");
        sb2.append(format);
        sb2.append(10);
    }

    private static void a(StringBuilder sb2, Thread thread) {
        sb2.append("CrashThread=");
        sb2.append("name: ");
        sb2.append(thread.getName());
        sb2.append(", tid: ");
        sb2.append(thread.getId());
        sb2.append(10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        r3 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.StringBuilder r2, java.lang.Throwable r3) {
        /*
            java.io.StringWriter r0 = new java.io.StringWriter
            r0.<init>()
            java.io.PrintWriter r1 = new java.io.PrintWriter
            r1.<init>(r0)
        L_0x000a:
            r3.printStackTrace(r1)     // Catch:{ all -> 0x0029 }
            java.lang.Throwable r3 = r3.getCause()     // Catch:{ all -> 0x0029 }
            if (r3 == 0) goto L_0x0014
            goto L_0x000a
        L_0x0014:
            r1.close()
            java.lang.String r3 = "StackTrace="
            r2.append(r3)
            java.lang.String r3 = r0.toString()
            r2.append(r3)
            r3 = 10
            r2.append(r3)
            return
        L_0x0029:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x002b }
        L_0x002b:
            r3 = move-exception
            r1.close()     // Catch:{ all -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x0034:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.util.h.a(java.lang.StringBuilder, java.lang.Throwable):void");
    }
}
