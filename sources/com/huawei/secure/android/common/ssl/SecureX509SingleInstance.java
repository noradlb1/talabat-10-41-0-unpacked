package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.e;
import java.io.InputStream;
import java.security.SecureRandom;

public class SecureX509SingleInstance {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33893a = "SecureX509SingleInstance";

    /* renamed from: b  reason: collision with root package name */
    private static volatile SecureX509TrustManager f33894b;

    private SecureX509SingleInstance() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        com.huawei.secure.android.common.ssl.util.e.b(f33893a, "get files bks error");
        r3 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0019 */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.secure.android.common.ssl.SecureX509TrustManager getInstance(android.content.Context r5) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.KeyStoreException, java.io.IOException {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            if (r5 == 0) goto L_0x006d
            com.huawei.secure.android.common.ssl.util.ContextUtil.setContext(r5)
            com.huawei.secure.android.common.ssl.SecureX509TrustManager r2 = f33894b
            if (r2 != 0) goto L_0x004a
            java.lang.Class<com.huawei.secure.android.common.ssl.SecureX509SingleInstance> r2 = com.huawei.secure.android.common.ssl.SecureX509SingleInstance.class
            monitor-enter(r2)
            com.huawei.secure.android.common.ssl.SecureX509TrustManager r3 = f33894b     // Catch:{ all -> 0x0047 }
            if (r3 != 0) goto L_0x0045
            java.io.InputStream r3 = com.huawei.secure.android.common.ssl.util.BksUtil.getFilesBksIS(r5)     // Catch:{ RuntimeException -> 0x0019 }
            goto L_0x0021
        L_0x0019:
            java.lang.String r3 = f33893a     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "get files bks error"
            com.huawei.secure.android.common.ssl.util.e.b(r3, r4)     // Catch:{ all -> 0x0047 }
            r3 = 0
        L_0x0021:
            if (r3 != 0) goto L_0x0035
            java.lang.String r3 = f33893a     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "get assets bks"
            com.huawei.secure.android.common.ssl.util.e.c(r3, r4)     // Catch:{ all -> 0x0047 }
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = "hmsrootcas.bks"
            java.io.InputStream r3 = r5.open(r3)     // Catch:{ all -> 0x0047 }
            goto L_0x003c
        L_0x0035:
            java.lang.String r5 = f33893a     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "get files bks"
            com.huawei.secure.android.common.ssl.util.e.c(r5, r4)     // Catch:{ all -> 0x0047 }
        L_0x003c:
            com.huawei.secure.android.common.ssl.SecureX509TrustManager r5 = new com.huawei.secure.android.common.ssl.SecureX509TrustManager     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = ""
            r5.<init>((java.io.InputStream) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0047 }
            f33894b = r5     // Catch:{ all -> 0x0047 }
        L_0x0045:
            monitor-exit(r2)     // Catch:{ all -> 0x0047 }
            goto L_0x004a
        L_0x0047:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0047 }
            throw r5
        L_0x004a:
            java.lang.String r5 = f33893a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "SecureX509TrustManager getInstance: cost : "
            r2.append(r3)
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r0
            r2.append(r3)
            java.lang.String r0 = " ms"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.huawei.secure.android.common.ssl.util.e.a(r5, r0)
            com.huawei.secure.android.common.ssl.SecureX509TrustManager r5 = f33894b
            return r5
        L_0x006d:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "context is null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.SecureX509SingleInstance.getInstance(android.content.Context):com.huawei.secure.android.common.ssl.SecureX509TrustManager");
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        String str = f33893a;
        e.c(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (!(inputStream == null || f33894b == null)) {
            f33894b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.b(f33894b);
            SecureApacheSSLSocketFactory.b(f33894b);
        }
        e.c(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        String str = f33893a;
        e.c(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (!(inputStream == null || f33894b == null)) {
            f33894b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.c(f33894b, secureRandom);
            SecureApacheSSLSocketFactory.c(f33894b, secureRandom);
        }
        e.c(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
