package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.secure.android.common.ssl.util.e;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Instrumented
public class WebViewSSLCheckThread extends Thread {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String f33904i = "WebViewSSLCheckThread";

    /* renamed from: a  reason: collision with root package name */
    private SSLSocketFactory f33905a;

    /* renamed from: b  reason: collision with root package name */
    private HostnameVerifier f33906b;

    /* renamed from: c  reason: collision with root package name */
    private org.apache.http.conn.ssl.SSLSocketFactory f33907c;

    /* renamed from: d  reason: collision with root package name */
    private X509HostnameVerifier f33908d;

    /* renamed from: e  reason: collision with root package name */
    private SslErrorHandler f33909e;

    /* renamed from: f  reason: collision with root package name */
    private String f33910f;

    /* renamed from: g  reason: collision with root package name */
    private Callback f33911g;

    /* renamed from: h  reason: collision with root package name */
    private Context f33912h;

    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    public static class a implements okhttp3.Callback {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Callback f33913b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f33914c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f33915d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f33916e;

        public a(Callback callback, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.f33913b = callback;
            this.f33914c = context;
            this.f33915d = str;
            this.f33916e = sslErrorHandler;
        }

        public void onFailure(Call call, IOException iOException) {
            String a11 = WebViewSSLCheckThread.f33904i;
            e.b(a11, "onFailure , IO Exception : " + iOException.getMessage());
            Callback callback = this.f33913b;
            if (callback != null) {
                callback.onCancel(this.f33914c, this.f33915d);
            } else {
                this.f33916e.cancel();
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            e.b(WebViewSSLCheckThread.f33904i, "onResponse . proceed");
            Callback callback = this.f33913b;
            if (callback != null) {
                callback.onProceed(this.f33914c, this.f33915d);
            } else {
                this.f33916e.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    private void b() {
        String str = f33904i;
        e.c(str, "callbackCancel: ");
        Callback callback = this.f33911g;
        if (callback != null) {
            callback.onCancel(this.f33912h, this.f33910f);
        } else if (this.f33909e != null) {
            e.c(str, "callbackCancel 2: ");
            this.f33909e.cancel();
        }
    }

    private void c() {
        e.c(f33904i, "callbackProceed: ");
        Callback callback = this.f33911g;
        if (callback != null) {
            callback.onProceed(this.f33912h, this.f33910f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.f33909e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, (Callback) null);
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.f33908d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.f33907c;
    }

    public Callback getCallback() {
        return this.f33911g;
    }

    public Context getContext() {
        return this.f33912h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f33906b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.f33909e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f33905a;
    }

    public String getUrl() {
        return this.f33910f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            super.run()
            org.apache.http.conn.ssl.SSLSocketFactory r0 = r8.f33907c
            r1 = 0
            if (r0 == 0) goto L_0x00d3
            org.apache.http.conn.ssl.X509HostnameVerifier r0 = r8.f33908d
            if (r0 == 0) goto L_0x00d3
            android.webkit.SslErrorHandler r0 = r8.f33909e
            if (r0 == 0) goto L_0x00c8
            java.lang.String r0 = r8.f33910f
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001a
            goto L_0x00c8
        L_0x001a:
            org.apache.http.conn.ssl.SSLSocketFactory r0 = r8.f33907c     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.conn.ssl.X509HostnameVerifier r2 = r8.f33908d     // Catch:{ Exception -> 0x00a2 }
            r0.setHostnameVerifier(r2)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.conn.ssl.SSLSocketFactory r0 = r8.f33907c     // Catch:{ Exception -> 0x00a2 }
            boolean r2 = r0 instanceof com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory     // Catch:{ Exception -> 0x00a2 }
            if (r2 == 0) goto L_0x002e
            com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory r0 = (com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory) r0     // Catch:{ Exception -> 0x00a2 }
            android.content.Context r2 = r8.f33912h     // Catch:{ Exception -> 0x00a2 }
            r0.setContext(r2)     // Catch:{ Exception -> 0x00a2 }
        L_0x002e:
            org.apache.http.params.BasicHttpParams r0 = new org.apache.http.params.BasicHttpParams     // Catch:{ Exception -> 0x00a2 }
            r0.<init>()     // Catch:{ Exception -> 0x00a2 }
            r2 = 30000(0x7530, float:4.2039E-41)
            org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r0, r2)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.params.HttpConnectionParams.setSoTimeout(r0, r2)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.conn.scheme.SchemeRegistry r2 = new org.apache.http.conn.scheme.SchemeRegistry     // Catch:{ Exception -> 0x00a2 }
            r2.<init>()     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.conn.scheme.Scheme r3 = new org.apache.http.conn.scheme.Scheme     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r4 = "https"
            org.apache.http.conn.ssl.SSLSocketFactory r5 = r8.f33907c     // Catch:{ Exception -> 0x00a2 }
            r6 = 443(0x1bb, float:6.21E-43)
            r3.<init>(r4, r5, r6)     // Catch:{ Exception -> 0x00a2 }
            r2.register(r3)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.conn.scheme.Scheme r3 = new org.apache.http.conn.scheme.Scheme     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r4 = "http"
            org.apache.http.conn.scheme.PlainSocketFactory r5 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory()     // Catch:{ Exception -> 0x00a2 }
            r6 = 80
            r3.<init>(r4, r5, r6)     // Catch:{ Exception -> 0x00a2 }
            r2.register(r3)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager r3 = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager     // Catch:{ Exception -> 0x00a2 }
            r3.<init>(r0, r2)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.impl.client.DefaultHttpClient r2 = new org.apache.http.impl.client.DefaultHttpClient     // Catch:{ Exception -> 0x00a2 }
            r2.<init>(r3, r0)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.client.methods.HttpGet r0 = new org.apache.http.client.methods.HttpGet     // Catch:{ Exception -> 0x00a2 }
            r0.<init>()     // Catch:{ Exception -> 0x00a2 }
            java.net.URI r3 = new java.net.URI     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r4 = r8.f33910f     // Catch:{ Exception -> 0x00a2 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00a2 }
            r0.setURI(r3)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.HttpResponse r0 = com.google.firebase.perf.network.FirebasePerfHttpClient.execute(r2, r0)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r2 = f33904i     // Catch:{ Exception -> 0x00a2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2 }
            r3.<init>()     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r4 = "status code is : "
            r3.append(r4)     // Catch:{ Exception -> 0x00a2 }
            org.apache.http.StatusLine r0 = r0.getStatusLine()     // Catch:{ Exception -> 0x00a2 }
            int r0 = r0.getStatusCode()     // Catch:{ Exception -> 0x00a2 }
            r3.append(r0)     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x00a2 }
            com.huawei.secure.android.common.ssl.util.e.c(r2, r0)     // Catch:{ Exception -> 0x00a2 }
            com.huawei.secure.android.common.ssl.util.d.a((java.io.Reader) r1)
            r8.c()
            return
        L_0x00a0:
            r0 = move-exception
            goto L_0x00c4
        L_0x00a2:
            r0 = move-exception
            java.lang.String r2 = f33904i     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r3.<init>()     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = "run: exception : "
            r3.append(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00a0 }
            r3.append(r0)     // Catch:{ all -> 0x00a0 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00a0 }
            com.huawei.secure.android.common.ssl.util.e.b(r2, r0)     // Catch:{ all -> 0x00a0 }
            r8.b()     // Catch:{ all -> 0x00a0 }
            com.huawei.secure.android.common.ssl.util.d.a((java.io.Reader) r1)
            return
        L_0x00c4:
            com.huawei.secure.android.common.ssl.util.d.a((java.io.Reader) r1)
            throw r0
        L_0x00c8:
            java.lang.String r0 = f33904i
            java.lang.String r1 = "sslErrorHandler or url is null"
            com.huawei.secure.android.common.ssl.util.e.b(r0, r1)
            r8.b()
            return
        L_0x00d3:
            javax.net.ssl.SSLSocketFactory r0 = r8.f33905a
            if (r0 == 0) goto L_0x0152
            javax.net.ssl.HostnameVerifier r0 = r8.f33906b
            if (r0 == 0) goto L_0x0152
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r2 = r8.f33910f     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.net.URLConnection r0 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r0)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            boolean r2 = r0 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            if (r2 == 0) goto L_0x0116
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            javax.net.ssl.SSLSocketFactory r1 = r8.f33905a     // Catch:{ Exception -> 0x0114 }
            r0.setSSLSocketFactory(r1)     // Catch:{ Exception -> 0x0114 }
            javax.net.ssl.HostnameVerifier r1 = r8.f33906b     // Catch:{ Exception -> 0x0114 }
            r0.setHostnameVerifier(r1)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x0114 }
            r1 = 10000(0x2710, float:1.4013E-41)
            r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x0114 }
            r1 = 20000(0x4e20, float:2.8026E-41)
            r0.setReadTimeout(r1)     // Catch:{ Exception -> 0x0114 }
            r0.connect()     // Catch:{ Exception -> 0x0114 }
            r1 = r0
            goto L_0x0116
        L_0x0114:
            r1 = move-exception
            goto L_0x0128
        L_0x0116:
            if (r1 == 0) goto L_0x011b
            r1.disconnect()
        L_0x011b:
            r8.c()
            return
        L_0x011f:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x014c
        L_0x0124:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x0128:
            java.lang.String r2 = f33904i     // Catch:{ all -> 0x014b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x014b }
            r3.<init>()     // Catch:{ all -> 0x014b }
            java.lang.String r4 = "exception : "
            r3.append(r4)     // Catch:{ all -> 0x014b }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x014b }
            r3.append(r1)     // Catch:{ all -> 0x014b }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x014b }
            com.huawei.secure.android.common.ssl.util.e.b(r2, r1)     // Catch:{ all -> 0x014b }
            r8.b()     // Catch:{ all -> 0x014b }
            if (r0 == 0) goto L_0x014a
            r0.disconnect()
        L_0x014a:
            return
        L_0x014b:
            r1 = move-exception
        L_0x014c:
            if (r0 == 0) goto L_0x0151
            r0.disconnect()
        L_0x0151:
            throw r1
        L_0x0152:
            r8.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.run():void");
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.f33908d = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.f33907c = sSLSocketFactory;
    }

    public void setCallback(Callback callback) {
        this.f33911g = callback;
    }

    public void setContext(Context context) {
        this.f33912h = context;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f33906b = hostnameVerifier;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.f33909e = sslErrorHandler;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f33905a = sSLSocketFactory;
    }

    public void setUrl(String str) {
        this.f33910f = str;
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactoryNew(new c(context)));
        setHostnameVerifier(new StrictHostnameVerifier());
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory((KeyStore) null, new c(context)));
        } catch (UnrecoverableKeyException e11) {
            String str2 = f33904i;
            e.b(str2, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e11.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context, Callback callback) {
        if (sslErrorHandler == null || TextUtils.isEmpty(str) || context == null) {
            e.b(f33904i, "checkServerCertificateWithOK: handler or url or context is null");
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new SecureSSLSocketFactoryNew(new c(context));
            secureSSLSocketFactoryNew.setContext(context);
            builder.sslSocketFactory(secureSSLSocketFactoryNew, new c(context));
            builder.hostnameVerifier(new StrictHostnameVerifier());
            Request.Builder url = new Request.Builder().url(str);
            Request build = !(url instanceof Request.Builder) ? url.build() : OkHttp3Instrumentation.build(url);
            OkHttpClient build2 = builder.build();
            (!(build2 instanceof OkHttpClient) ? build2.newCall(build) : OkHttp3Instrumentation.newCall(build2, build)).enqueue(new a(callback, context, str, sslErrorHandler));
        } catch (Exception e11) {
            String str2 = f33904i;
            e.b(str2, "checkServerCertificateWithOK: exception : " + e11.getMessage());
            sslErrorHandler.cancel();
        }
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, Callback callback, Context context) {
        this.f33909e = sslErrorHandler;
        this.f33910f = str;
        this.f33907c = sSLSocketFactory;
        this.f33908d = x509HostnameVerifier;
        this.f33911g = callback;
        this.f33912h = context;
    }
}
