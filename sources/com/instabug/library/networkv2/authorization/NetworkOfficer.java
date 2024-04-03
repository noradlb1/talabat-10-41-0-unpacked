package com.instabug.library.networkv2.authorization;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.security.CertificateUtil;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.UUID;

public abstract class NetworkOfficer {
    static {
        try {
            b();
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    @VisibleForTesting
    public static synchronized String a() {
        String uuid;
        synchronized (NetworkOfficer.class) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }

    private static synchronized void b() throws UnsatisfiedLinkError {
        synchronized (NetworkOfficer.class) {
            System.loadLibrary("ibg-native");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String c(@androidx.annotation.NonNull com.instabug.library.networkv2.request.Request r4) {
        /*
            java.lang.Class<com.instabug.library.networkv2.authorization.NetworkOfficer> r0 = com.instabug.library.networkv2.authorization.NetworkOfficer.class
            monitor-enter(r0)
            r1 = 0
            java.lang.String r2 = r4.getRequestBody()     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0039 }
            if (r2 == 0) goto L_0x0033
            java.lang.String r2 = r4.getRequestBody()     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0039 }
            boolean r2 = r2.isEmpty()     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0039 }
            if (r2 == 0) goto L_0x0015
            goto L_0x0033
        L_0x0015:
            java.lang.String r4 = r4.getRequestBody()     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0039 }
            byte[] r4 = com.instabug.library.networkv2.authorization.a.b(r4)     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0039 }
            r2 = 2
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r2)     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0039 }
            java.lang.String r4 = com.instabug.library.networkv2.authorization.a.c(r4)     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0039 }
            if (r4 == 0) goto L_0x0031
            boolean r2 = r4.isEmpty()     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0039 }
            if (r2 == 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            monitor-exit(r0)
            return r4
        L_0x0031:
            monitor-exit(r0)
            return r1
        L_0x0033:
            java.lang.String r4 = ""
            monitor-exit(r0)
            return r4
        L_0x0037:
            r4 = move-exception
            goto L_0x004c
        L_0x0039:
            r4 = move-exception
            java.lang.String r2 = "IBG-Core"
            java.lang.String r3 = "OOM: Failed to get signature base string"
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r4)     // Catch:{ all -> 0x0037 }
            goto L_0x004a
        L_0x0042:
            r4 = move-exception
            java.lang.String r2 = "IBG-Core"
            java.lang.String r3 = "Failed to get signature base string"
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r4)     // Catch:{ all -> 0x0037 }
        L_0x004a:
            monitor-exit(r0)
            return r1
        L_0x004c:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.networkv2.authorization.NetworkOfficer.c(com.instabug.library.networkv2.request.Request):java.lang.String");
    }

    @VisibleForTesting
    @Nullable
    public static synchronized String d(Request request) {
        synchronized (NetworkOfficer.class) {
            if (request.isMultiPartRequest()) {
                return "";
            }
            String c11 = c(request);
            return c11;
        }
    }

    public static native String getAppSecret();

    public static native String getClientId();

    public static synchronized String a(Request request) throws Exception {
        String str;
        String sb2;
        synchronized (NetworkOfficer.class) {
            String a11 = a();
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb3 = new StringBuilder("amx ");
            sb3.append(a11);
            sb3.append(CertificateUtil.DELIMITER);
            String str2 = null;
            try {
                str = getClientId();
                try {
                    str2 = a(getAppSecret(), b(request, str, a11, currentTimeMillis));
                } catch (UnsatisfiedLinkError unused) {
                }
            } catch (UnsatisfiedLinkError unused2) {
                str = null;
            }
            if (str2 != null) {
                sb3.append(str2);
            }
            sb3.append(CertificateUtil.DELIMITER);
            if (str != null) {
                sb3.append(str);
            }
            sb3.append(CertificateUtil.DELIMITER);
            sb3.append(currentTimeMillis);
            sb2 = sb3.toString();
        }
        return sb2;
    }

    @VisibleForTesting
    @NonNull
    public static synchronized String b(Request request, String str, String str2, long j11) {
        synchronized (NetworkOfficer.class) {
            StringBuilder sb2 = new StringBuilder();
            if (request.getRequestMethod() != null) {
                sb2.append(request.getRequestMethod());
            }
            sb2.append(a.a(request.getRequestUrl()));
            sb2.append(str);
            sb2.append(str2);
            if ((request.getRequestMethod().equals("POST") || request.getRequestMethod().equals("PUT")) && request.getRequestBody() != null) {
                String d11 = d(request);
                if (d11 == null) {
                    InstabugSDKLogger.e("IBG-Core", "failed to hash Request body");
                    return "";
                } else if (!d11.isEmpty()) {
                    sb2.append(d11);
                }
            }
            sb2.append(j11);
            String sb3 = sb2.toString();
            return sb3;
        }
    }

    private static synchronized String a(String str, String str2) throws Exception {
        String a11;
        synchronized (NetworkOfficer.class) {
            a11 = a.a(str, str2);
        }
        return a11;
    }
}
