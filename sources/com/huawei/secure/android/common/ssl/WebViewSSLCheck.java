package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.WebViewSSLCheckThread;
import com.huawei.secure.android.common.ssl.util.b;
import com.huawei.secure.android.common.ssl.util.e;
import com.huawei.secure.android.common.ssl.util.h;
import java.security.cert.X509Certificate;

public class WebViewSSLCheck {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33903a = "WebViewSSLCheck";

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        checkServerCertificateNew(sslErrorHandler, sslError, (String) null, context, (WebViewSSLCheckThread.Callback) null);
    }

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, WebViewSSLCheckThread.Callback callback) {
        String str2 = f33903a;
        e.c(str2, " error type : " + sslError.getPrimaryError() + " , cn is : " + sslError.getCertificate().getIssuedTo().getCName());
        X509Certificate a11 = b.a(sslError.getCertificate());
        X509Certificate a12 = new h(context).a();
        e.a(str2, "checkServerCertificateNew: error certificate is : " + a11);
        if (b.a(a12, a11)) {
            e.c(str2, "checkServerCertificateNew: proceed");
            if (callback != null) {
                callback.onProceed(context, str);
            } else {
                sslErrorHandler.proceed();
            }
        } else {
            e.b(str2, "checkServerCertificateNew: cancel");
            if (callback != null) {
                callback.onCancel(context, str);
            } else {
                sslErrorHandler.cancel();
            }
        }
    }

    public static boolean checkServerCertificateNew(X509Certificate x509Certificate, SslError sslError) {
        return b.a(x509Certificate, b.a(sslError.getCertificate()));
    }

    public static boolean checkServerCertificateNew(String str, SslError sslError) {
        return checkServerCertificateNew(b.a(str), sslError);
    }
}
