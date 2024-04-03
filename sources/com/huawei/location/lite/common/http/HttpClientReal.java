package com.huawei.location.lite.common.http;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.location.lite.common.http.adapter.HttpClientAdapter;
import com.huawei.location.lite.common.http.adapter.HttpClientBuilder;
import com.huawei.location.lite.common.http.adapter.IHttpSDKRequestTask;
import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.interceptor.AGCInterceptor;
import com.huawei.location.lite.common.http.interceptor.CommonInterceptor;
import com.huawei.location.lite.common.http.interceptor.UcsAuthInterceptor;
import com.huawei.location.lite.common.log.LogConsole;
import java.net.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

@SuppressLint({"CheckResult"})
public class HttpClientReal extends HttpClientAdapter {
    private static final ConnectionPool CONNECTION_POOL = new ConnectionPool(HttpClientAdapter.f50112q, 30000, TimeUnit.MILLISECONDS);
    private OkHttpClient httpClient;

    public HttpClientReal(HttpClientBuilder httpClientBuilder, Context context) {
        super(httpClientBuilder, context);
    }

    public void a() {
        this.f50113a.add(new CommonInterceptor());
        if (this.f50125m) {
            this.f50113a.add(new UcsAuthInterceptor());
        }
        if (this.f50124l) {
            this.f50113a.add(new AGCInterceptor());
        }
    }

    public void b() {
        X509TrustManager x509TrustManager;
        LogConsole.d("HttpClientReal", "OkHttpClient init...");
        OkHttpClient.Builder protocols = new OkHttpClient.Builder().connectionPool(CONNECTION_POOL).retryOnConnectionFailure(false).protocols(Collections.unmodifiableList(Arrays.asList(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1})));
        int i11 = this.f50117e;
        if (i11 > 0) {
            protocols.pingInterval((long) i11, TimeUnit.MILLISECONDS);
        }
        int i12 = this.f50116d;
        if (i12 > 0) {
            protocols.readTimeout((long) i12, TimeUnit.MILLISECONDS);
        }
        int i13 = this.f50118f;
        if (i13 > 0) {
            protocols.writeTimeout((long) i13, TimeUnit.MILLISECONDS);
        }
        int i14 = this.f50115c;
        if (i14 > 0) {
            protocols.connectTimeout((long) i14, TimeUnit.MILLISECONDS);
        }
        Proxy proxy = this.f50122j;
        if (proxy != null) {
            protocols.proxy(proxy);
        }
        HostnameVerifier hostnameVerifier = this.f50121i;
        if (hostnameVerifier != null) {
            protocols.hostnameVerifier(hostnameVerifier);
        }
        SSLSocketFactory sSLSocketFactory = this.f50119g;
        if (!(sSLSocketFactory == null || (x509TrustManager = this.f50120h) == null)) {
            protocols.sslSocketFactory(sSLSocketFactory, x509TrustManager);
        }
        this.httpClient = protocols.build();
    }

    public void evictAllConnections() {
        if (this.httpClient != null) {
            CONNECTION_POOL.evictAll();
            this.httpClient = null;
        }
    }

    public List<InterceptorAdapter> getInterceptors() {
        return this.f50113a;
    }

    public IHttpSDKRequestTask newRequestTask() {
        return new OkRequestTask(this.httpClient);
    }
}
