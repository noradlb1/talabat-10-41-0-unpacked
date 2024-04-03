package com.huawei.location.lite.common.http.adapter;

import android.content.Context;
import com.huawei.location.lite.common.report.ReportBuilder;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public abstract class HttpClientAdapter implements IHttpClient {

    /* renamed from: q  reason: collision with root package name */
    public static final int f50112q = Runtime.getRuntime().availableProcessors();

    /* renamed from: a  reason: collision with root package name */
    public List<InterceptorAdapter> f50113a;

    /* renamed from: b  reason: collision with root package name */
    public List<InterceptorAdapter> f50114b;

    /* renamed from: c  reason: collision with root package name */
    public int f50115c;

    /* renamed from: d  reason: collision with root package name */
    public int f50116d;

    /* renamed from: e  reason: collision with root package name */
    public int f50117e;

    /* renamed from: f  reason: collision with root package name */
    public int f50118f;

    /* renamed from: g  reason: collision with root package name */
    public SSLSocketFactory f50119g;

    /* renamed from: h  reason: collision with root package name */
    public X509TrustManager f50120h;

    /* renamed from: i  reason: collision with root package name */
    public HostnameVerifier f50121i;

    /* renamed from: j  reason: collision with root package name */
    public Proxy f50122j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f50123k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f50124l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f50125m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f50126n;

    /* renamed from: o  reason: collision with root package name */
    public ReportBuilder f50127o;

    /* renamed from: p  reason: collision with root package name */
    public Context f50128p;

    public HttpClientAdapter(HttpClientBuilder httpClientBuilder, Context context) {
        this.f50128p = context;
        this.f50115c = httpClientBuilder.f50131c;
        this.f50116d = httpClientBuilder.f50132d;
        this.f50117e = httpClientBuilder.f50133e;
        this.f50118f = httpClientBuilder.f50134f;
        this.f50119g = httpClientBuilder.f50135g;
        this.f50120h = httpClientBuilder.f50136h;
        this.f50121i = httpClientBuilder.f50137i;
        this.f50122j = httpClientBuilder.f50138j;
        this.f50123k = httpClientBuilder.f50139k;
        this.f50124l = httpClientBuilder.f50140l;
        this.f50125m = httpClientBuilder.f50141m;
        this.f50126n = httpClientBuilder.f50142n;
        this.f50127o = httpClientBuilder.f50143o;
        List<InterceptorAdapter> list = httpClientBuilder.f50129a;
        this.f50113a = list;
        if (list == null) {
            this.f50113a = new ArrayList(8);
        }
        this.f50114b = httpClientBuilder.f50130b;
    }

    public abstract void a();

    public abstract void b();

    public ReportBuilder getReportBuilder() {
        return this.f50127o;
    }

    public void init() {
        if (this.f50123k) {
            a();
        }
        b();
    }
}
