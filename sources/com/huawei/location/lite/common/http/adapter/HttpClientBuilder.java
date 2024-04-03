package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.report.ReportBuilder;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class HttpClientBuilder {
    private static final int TIME_OUT = 30000;

    /* renamed from: a  reason: collision with root package name */
    public List<InterceptorAdapter> f50129a = new ArrayList(4);

    /* renamed from: b  reason: collision with root package name */
    public List<InterceptorAdapter> f50130b = new ArrayList(4);

    /* renamed from: c  reason: collision with root package name */
    public int f50131c = 30000;

    /* renamed from: d  reason: collision with root package name */
    public int f50132d = 30000;

    /* renamed from: e  reason: collision with root package name */
    public int f50133e;

    /* renamed from: f  reason: collision with root package name */
    public int f50134f = 30000;

    /* renamed from: g  reason: collision with root package name */
    public SSLSocketFactory f50135g;

    /* renamed from: h  reason: collision with root package name */
    public X509TrustManager f50136h;

    /* renamed from: i  reason: collision with root package name */
    public HostnameVerifier f50137i;

    /* renamed from: j  reason: collision with root package name */
    public Proxy f50138j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f50139k = true;

    /* renamed from: l  reason: collision with root package name */
    public boolean f50140l = true;

    /* renamed from: m  reason: collision with root package name */
    public boolean f50141m = true;

    /* renamed from: n  reason: collision with root package name */
    public boolean f50142n = true;

    /* renamed from: o  reason: collision with root package name */
    public ReportBuilder f50143o;

    public HttpClientBuilder addInterceptor(InterceptorAdapter interceptorAdapter) {
        this.f50129a.add(interceptorAdapter);
        return this;
    }

    public HttpClientBuilder addNetworkInterceptor(InterceptorAdapter interceptorAdapter) {
        this.f50130b.add(interceptorAdapter);
        return this;
    }

    public HttpClientBuilder connectTimeout(int i11) {
        this.f50131c = i11;
        return this;
    }

    public HttpClientBuilder hostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f50137i = hostnameVerifier;
        return this;
    }

    public HttpClientBuilder pingInterval(int i11) {
        this.f50133e = i11;
        return this;
    }

    public HttpClientBuilder proxy(Proxy proxy) {
        this.f50138j = proxy;
        return this;
    }

    public HttpClientBuilder readTimeout(int i11) {
        this.f50132d = i11;
        return this;
    }

    public HttpClientBuilder setNeedCheckAGC(boolean z11) {
        this.f50140l = z11;
        return this;
    }

    public HttpClientBuilder setNeedCheckTssAuth(boolean z11) {
        this.f50142n = z11;
        return this;
    }

    public HttpClientBuilder setNeedCheckUcsAuth(boolean z11) {
        this.f50141m = z11;
        return this;
    }

    public HttpClientBuilder setNeedInterceptor(boolean z11) {
        this.f50139k = z11;
        return this;
    }

    public void setReportBuilder(ReportBuilder reportBuilder) {
        this.f50143o = reportBuilder;
    }

    public HttpClientBuilder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        this.f50135g = sSLSocketFactory;
        this.f50136h = x509TrustManager;
        return this;
    }

    public HttpClientBuilder writeTimeout(int i11) {
        this.f50134f = i11;
        return this;
    }
}
