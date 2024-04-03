package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.OkHttpClient;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

public class ee implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ne f48477a;

    public ee(ne neVar) {
        this.f48477a = neVar;
    }

    public void run() {
        if (this.f48477a.f48533d == null) {
            try {
                SecureX509TrustManager secureX509TrustManager = new SecureX509TrustManager(J.b());
                SSLSocketFactory a11 = Ic.a();
                ne neVar = this.f48477a;
                OkHttpClient.Builder hostnameVerifier = new OkHttpClient.Builder().sslSocketFactory(a11, secureX509TrustManager).hostnameVerifier(new StrictHostnameVerifier());
                TimeUnit timeUnit = TimeUnit.SECONDS;
                OkHttpClient unused = neVar.f48533d = hostnameVerifier.connectTimeout(45, timeUnit).writeTimeout(10, timeUnit).readTimeout(10, timeUnit).build();
            } catch (IOException | GeneralSecurityException e11) {
                Logger.error("DTM-AutoTrace", "initialize#" + e11.getMessage());
            }
        }
    }
}
