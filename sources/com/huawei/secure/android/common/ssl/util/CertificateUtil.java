package com.huawei.secure.android.common.ssl.util;

public final class CertificateUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33955a = "CertificateUtil";

    private CertificateUtil() {
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.security.cert.X509Certificate] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.X509Certificate getHwCbgRootCA(android.content.Context r6) {
        /*
            r0 = 0
            java.lang.String r1 = "bks"
            java.security.KeyStore r1 = java.security.KeyStore.getInstance(r1)     // Catch:{ KeyStoreException -> 0x003c, CertificateException -> 0x003a, IOException -> 0x0038, NoSuchAlgorithmException -> 0x0036, RuntimeException -> 0x0033, all -> 0x0031 }
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ KeyStoreException -> 0x003c, CertificateException -> 0x003a, IOException -> 0x0038, NoSuchAlgorithmException -> 0x0036, RuntimeException -> 0x0033, all -> 0x0031 }
            java.lang.String r2 = "hmsrootcas.bks"
            java.io.InputStream r6 = r6.open(r2)     // Catch:{ KeyStoreException -> 0x003c, CertificateException -> 0x003a, IOException -> 0x0038, NoSuchAlgorithmException -> 0x0036, RuntimeException -> 0x0033, all -> 0x0031 }
            r6.reset()     // Catch:{ KeyStoreException -> 0x002f, CertificateException -> 0x002d, IOException -> 0x002b, NoSuchAlgorithmException -> 0x0029, RuntimeException -> 0x0027 }
            java.lang.String r2 = ""
            char[] r2 = r2.toCharArray()     // Catch:{ KeyStoreException -> 0x002f, CertificateException -> 0x002d, IOException -> 0x002b, NoSuchAlgorithmException -> 0x0029, RuntimeException -> 0x0027 }
            r1.load(r6, r2)     // Catch:{ KeyStoreException -> 0x002f, CertificateException -> 0x002d, IOException -> 0x002b, NoSuchAlgorithmException -> 0x0029, RuntimeException -> 0x0027 }
            java.lang.String r2 = "052root"
            java.security.cert.Certificate r1 = r1.getCertificate(r2)     // Catch:{ KeyStoreException -> 0x002f, CertificateException -> 0x002d, IOException -> 0x002b, NoSuchAlgorithmException -> 0x0029, RuntimeException -> 0x0027 }
            java.security.cert.X509Certificate r1 = (java.security.cert.X509Certificate) r1     // Catch:{ KeyStoreException -> 0x002f, CertificateException -> 0x002d, IOException -> 0x002b, NoSuchAlgorithmException -> 0x0029, RuntimeException -> 0x0027 }
            r0 = r1
            goto L_0x0058
        L_0x0027:
            r1 = move-exception
            goto L_0x003e
        L_0x0029:
            r1 = move-exception
            goto L_0x003e
        L_0x002b:
            r1 = move-exception
            goto L_0x003e
        L_0x002d:
            r1 = move-exception
            goto L_0x003e
        L_0x002f:
            r1 = move-exception
            goto L_0x003e
        L_0x0031:
            r6 = move-exception
            goto L_0x0060
        L_0x0033:
            r1 = move-exception
        L_0x0034:
            r6 = r0
            goto L_0x003e
        L_0x0036:
            r1 = move-exception
            goto L_0x0034
        L_0x0038:
            r1 = move-exception
            goto L_0x0034
        L_0x003a:
            r1 = move-exception
            goto L_0x0034
        L_0x003c:
            r1 = move-exception
            goto L_0x0034
        L_0x003e:
            java.lang.String r2 = "CertificateUtil"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005c }
            r3.<init>()     // Catch:{ all -> 0x005c }
            java.lang.String r4 = "loadBksCA: exception : "
            r3.append(r4)     // Catch:{ all -> 0x005c }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x005c }
            r3.append(r1)     // Catch:{ all -> 0x005c }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x005c }
            com.huawei.secure.android.common.ssl.util.e.b(r2, r1)     // Catch:{ all -> 0x005c }
        L_0x0058:
            com.huawei.secure.android.common.ssl.util.d.a((java.io.InputStream) r6)
            return r0
        L_0x005c:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
        L_0x0060:
            com.huawei.secure.android.common.ssl.util.d.a((java.io.InputStream) r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.util.CertificateUtil.getHwCbgRootCA(android.content.Context):java.security.cert.X509Certificate");
    }
}
