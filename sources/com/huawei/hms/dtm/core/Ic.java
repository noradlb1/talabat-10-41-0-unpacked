package com.huawei.hms.dtm.core;

public class Ic {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static javax.net.ssl.SSLSocketFactory a() {
        /*
            java.lang.String r0 = "SafeSSLSocketFactory"
            android.content.Context r1 = com.huawei.hms.dtm.core.J.b()     // Catch:{ IOException -> 0x001a, NoSuchAlgorithmException -> 0x0017, CertificateException -> 0x0014, KeyManagementException -> 0x0011, IllegalArgumentException -> 0x000e, KeyStoreException -> 0x000b }
            com.huawei.secure.android.common.ssl.SSFCompatiableSystemCA r1 = com.huawei.secure.android.common.ssl.SSFCompatiableSystemCA.getInstance(r1)     // Catch:{ IOException -> 0x001a, NoSuchAlgorithmException -> 0x0017, CertificateException -> 0x0014, KeyManagementException -> 0x0011, IllegalArgumentException -> 0x000e, KeyStoreException -> 0x000b }
            goto L_0x0020
        L_0x000b:
            java.lang.String r1 = "getSafeSSLSocketFactory, KeyStoreException."
            goto L_0x001c
        L_0x000e:
            java.lang.String r1 = "getSafeSSLSocketFactory, IllegalArgumentException."
            goto L_0x001c
        L_0x0011:
            java.lang.String r1 = "getSafeSSLSocketFactory, KeyManagementException."
            goto L_0x001c
        L_0x0014:
            java.lang.String r1 = "getSafeSSLSocketFactory, CertificateException."
            goto L_0x001c
        L_0x0017:
            java.lang.String r1 = "getSafeSSLSocketFactory, NoSuchAlgorithmException."
            goto L_0x001c
        L_0x001a:
            java.lang.String r1 = "getSafeSSLSocketFactory, IOException."
        L_0x001c:
            com.huawei.hms.dtm.core.util.Logger.warn(r0, r1)
            r1 = 0
        L_0x0020:
            if (r1 != 0) goto L_0x002b
            java.lang.String r1 = "use https default factory."
            com.huawei.hms.dtm.core.util.Logger.info(r0, r1)
            javax.net.ssl.SSLSocketFactory r1 = javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory()
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.Ic.a():javax.net.ssl.SSLSocketFactory");
    }
}
