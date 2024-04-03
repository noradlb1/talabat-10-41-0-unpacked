package com.huawei.agconnect.https;

import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public class OKHttpBuilder {
    private OkHttpClient.Builder builder = new OkHttpClient.Builder();

    public OKHttpBuilder addInterceptor(Interceptor interceptor) {
        if (interceptor != null) {
            this.builder.addInterceptor(interceptor);
            return this;
        }
        throw new IllegalArgumentException("interceptor == null");
    }

    public OKHttpBuilder authenticator(Authenticator authenticator) {
        this.builder.authenticator(authenticator);
        return this;
    }

    public OkHttpClient build() {
        return this.builder.build();
    }

    public OkHttpClient buildWithTimeOut(long j11, TimeUnit timeUnit) {
        return this.builder.connectTimeout(j11, timeUnit).readTimeout(j11, timeUnit).writeTimeout(j11, timeUnit).build();
    }

    public OKHttpBuilder connectTimeout(long j11) {
        this.builder.connectTimeout(j11, TimeUnit.MILLISECONDS);
        return this;
    }

    public OKHttpBuilder enableGzip() {
        this.builder.addInterceptor(new c());
        return this;
    }

    public OKHttpBuilder readTimeout(long j11) {
        this.builder.readTimeout(j11, TimeUnit.MILLISECONDS);
        return this;
    }

    public OKHttpBuilder setRetryTimes(int i11) {
        this.builder.addInterceptor(new g(i11));
        return this;
    }

    public OKHttpBuilder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        try {
            this.builder.sslSocketFactory(sSLSocketFactory, x509TrustManager);
        } catch (NoSuchMethodError unused) {
        }
        return this;
    }

    public OKHttpBuilder writeTimeout(long j11) {
        this.builder.writeTimeout(j11, TimeUnit.MILLISECONDS);
        return this;
    }
}
