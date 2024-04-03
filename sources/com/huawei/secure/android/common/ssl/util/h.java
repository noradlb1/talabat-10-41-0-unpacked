package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.security.cert.X509Certificate;

public class h {

    /* renamed from: b  reason: collision with root package name */
    private static final String f33969b = "X509CertificateUtil";

    /* renamed from: c  reason: collision with root package name */
    public static final String f33970c = "hmsrootcas.bks";

    /* renamed from: d  reason: collision with root package name */
    public static final String f33971d = "";

    /* renamed from: e  reason: collision with root package name */
    public static final String f33972e = "bks";

    /* renamed from: f  reason: collision with root package name */
    public static final String f33973f = "052root";

    /* renamed from: g  reason: collision with root package name */
    private static final String f33974g = "hmsincas.bks";

    /* renamed from: h  reason: collision with root package name */
    private static final String f33975h = "huawei cbg application integration ca";

    /* renamed from: a  reason: collision with root package name */
    private Context f33976a;

    public h(Context context) {
        this.f33976a = context;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.security.cert.X509Certificate] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.cert.X509Certificate a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = "bks"
            java.security.KeyStore r1 = java.security.KeyStore.getInstance(r1)     // Catch:{ KeyStoreException -> 0x0036, CertificateException -> 0x0034, IOException -> 0x0032, NoSuchAlgorithmException -> 0x002f, all -> 0x002d }
            android.content.Context r2 = r4.f33976a     // Catch:{ KeyStoreException -> 0x0036, CertificateException -> 0x0034, IOException -> 0x0032, NoSuchAlgorithmException -> 0x002f, all -> 0x002d }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ KeyStoreException -> 0x0036, CertificateException -> 0x0034, IOException -> 0x0032, NoSuchAlgorithmException -> 0x002f, all -> 0x002d }
            java.io.InputStream r5 = r2.open(r5)     // Catch:{ KeyStoreException -> 0x0036, CertificateException -> 0x0034, IOException -> 0x0032, NoSuchAlgorithmException -> 0x002f, all -> 0x002d }
            r5.reset()     // Catch:{ KeyStoreException -> 0x002b, CertificateException -> 0x0029, IOException -> 0x0027, NoSuchAlgorithmException -> 0x0025 }
            java.lang.String r2 = ""
            char[] r2 = r2.toCharArray()     // Catch:{ KeyStoreException -> 0x002b, CertificateException -> 0x0029, IOException -> 0x0027, NoSuchAlgorithmException -> 0x0025 }
            r1.load(r5, r2)     // Catch:{ KeyStoreException -> 0x002b, CertificateException -> 0x0029, IOException -> 0x0027, NoSuchAlgorithmException -> 0x0025 }
            java.security.cert.Certificate r6 = r1.getCertificate(r6)     // Catch:{ KeyStoreException -> 0x002b, CertificateException -> 0x0029, IOException -> 0x0027, NoSuchAlgorithmException -> 0x0025 }
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6     // Catch:{ KeyStoreException -> 0x002b, CertificateException -> 0x0029, IOException -> 0x0027, NoSuchAlgorithmException -> 0x0025 }
            r0 = r6
            goto L_0x0052
        L_0x0025:
            r6 = move-exception
            goto L_0x0038
        L_0x0027:
            r6 = move-exception
            goto L_0x0038
        L_0x0029:
            r6 = move-exception
            goto L_0x0038
        L_0x002b:
            r6 = move-exception
            goto L_0x0038
        L_0x002d:
            r6 = move-exception
            goto L_0x0058
        L_0x002f:
            r6 = move-exception
        L_0x0030:
            r5 = r0
            goto L_0x0038
        L_0x0032:
            r6 = move-exception
            goto L_0x0030
        L_0x0034:
            r6 = move-exception
            goto L_0x0030
        L_0x0036:
            r6 = move-exception
            goto L_0x0030
        L_0x0038:
            java.lang.String r1 = "X509CertificateUtil"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
            r2.<init>()     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = "loadBksCA: exception : "
            r2.append(r3)     // Catch:{ all -> 0x0056 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0056 }
            r2.append(r6)     // Catch:{ all -> 0x0056 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0056 }
            com.huawei.secure.android.common.ssl.util.e.b(r1, r6)     // Catch:{ all -> 0x0056 }
        L_0x0052:
            com.huawei.secure.android.common.ssl.util.d.a((java.io.InputStream) r5)
            return r0
        L_0x0056:
            r6 = move-exception
            r0 = r5
        L_0x0058:
            com.huawei.secure.android.common.ssl.util.d.a((java.io.InputStream) r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.util.h.a(java.lang.String, java.lang.String):java.security.cert.X509Certificate");
    }

    public X509Certificate b() {
        return a("hmsrootcas.bks", f33973f);
    }

    public X509Certificate a() {
        return a(f33974g, f33975h);
    }
}
