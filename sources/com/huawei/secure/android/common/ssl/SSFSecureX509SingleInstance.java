package com.huawei.secure.android.common.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

public class SSFSecureX509SingleInstance {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33853a = "SSFSecureX509SingleInstance";

    /* renamed from: b  reason: collision with root package name */
    private static volatile SecureX509TrustManager f33854b;

    private SSFSecureX509SingleInstance() {
    }

    @SuppressLint({"NewApi"})
    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        if (context != null) {
            ContextUtil.setContext(context);
            if (f33854b == null) {
                synchronized (SSFSecureX509SingleInstance.class) {
                    if (f33854b == null) {
                        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                        if (filesBksIS == null) {
                            e.c(f33853a, "get assets bks");
                            filesBksIS = context.getAssets().open("hmsrootcas.bks");
                        } else {
                            e.c(f33853a, "get files bks");
                        }
                        f33854b = new SecureX509TrustManager(filesBksIS, "", true);
                    }
                }
            }
            return f33854b;
        }
        throw new NullPointerException("context is null");
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        String str = f33853a;
        e.c(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (!(inputStream == null || f33854b == null)) {
            f33854b = new SecureX509TrustManager(inputStream, "", true);
            e.a(str, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            SSFCompatiableSystemCA.b(f33854b);
            SASFCompatiableSystemCA.b(f33854b);
        }
        e.a(str, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        String str = f33853a;
        e.c(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (!(inputStream == null || f33854b == null)) {
            f33854b = new SecureX509TrustManager(inputStream, "", true);
            e.a(str, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            SSFCompatiableSystemCA.c(f33854b, secureRandom);
            SASFCompatiableSystemCA.c(f33854b, secureRandom);
        }
        e.a(str, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
