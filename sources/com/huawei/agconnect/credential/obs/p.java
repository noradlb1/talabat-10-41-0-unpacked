package com.huawei.agconnect.credential.obs;

import android.content.Context;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.agconnect.https.OKHttpBuilder;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private OKHttpBuilder f47608a;

    public p(Context context, List<Interceptor> list, boolean z11) {
        this.f47608a = a(context);
        if (list != null && list.size() > 0) {
            for (Interceptor addInterceptor : list) {
                this.f47608a.addInterceptor(addInterceptor);
            }
        }
        if (z11) {
            this.f47608a.connectTimeout(5000).readTimeout(5000).writeTimeout(5000);
        }
    }

    private OKHttpBuilder a(Context context) {
        OKHttpBuilder oKHttpBuilder;
        try {
            this.f47608a = new OKHttpBuilder().sslSocketFactory(SecureSSLSocketFactory.getInstance(context), new SecureX509TrustManager(context));
        } catch (IOException e11) {
            Logger.e("ClientImpl", "IOException", e11);
            oKHttpBuilder = new OKHttpBuilder();
        } catch (NoSuchAlgorithmException e12) {
            Logger.e("ClientImpl", "NoSuchAlgorithmException", e12);
            oKHttpBuilder = new OKHttpBuilder();
        } catch (CertificateException e13) {
            Logger.e("ClientImpl", "CertificateException", e13);
            oKHttpBuilder = new OKHttpBuilder();
        } catch (KeyStoreException e14) {
            Logger.e("ClientImpl", "KeyStoreException", e14);
            oKHttpBuilder = new OKHttpBuilder();
        } catch (IllegalAccessException e15) {
            Logger.e("ClientImpl", "IllegalAccessException", e15);
            oKHttpBuilder = new OKHttpBuilder();
        } catch (KeyManagementException e16) {
            Logger.e("ClientImpl", "KeyManagementException", e16);
            oKHttpBuilder = new OKHttpBuilder();
        } catch (Throwable th2) {
            this.f47608a = new OKHttpBuilder();
            throw th2;
        }
        return this.f47608a;
        this.f47608a = oKHttpBuilder;
        return this.f47608a;
    }

    public p a(Authenticator authenticator) {
        if (authenticator != null) {
            this.f47608a.authenticator(authenticator);
        }
        return this;
    }

    public OkHttpClient a() {
        return this.f47608a.build();
    }

    public OkHttpClient a(long j11, TimeUnit timeUnit) {
        return this.f47608a.buildWithTimeOut(j11, timeUnit);
    }
}
