package com.talabat.helpers;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import androidx.core.util.Supplier;
import androidx.webkit.ProxyConfig;
import com.facebook.internal.security.CertificateUtil;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.visa.checkout.Profile;
import j$.util.DesugarTimeZone;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.security.AccessControlException;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;
import okio.Timeout;
import zr.m;
import zr.n;

public final class ObsoleteUrlFactory implements URLStreamHandlerFactory, Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f60806b = new LinkedHashSet(Arrays.asList(new String[]{FirebasePerformance.HttpMethod.OPTIONS, "GET", FirebasePerformance.HttpMethod.HEAD, "POST", "PUT", "DELETE", FirebasePerformance.HttpMethod.TRACE, "PATCH"}));

    /* renamed from: c  reason: collision with root package name */
    public static final TimeZone f60807c = DesugarTimeZone.getTimeZone("GMT");

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<DateFormat> f60808d = ThreadLocalFactory.a(new m());

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<String> f60809e = new n();
    private OkHttpClient client;

    @Instrumented
    public static final class BufferedRequestBody extends OutputStreamRequestBody {

        /* renamed from: g  reason: collision with root package name */
        public final Buffer f60812g;

        /* renamed from: h  reason: collision with root package name */
        public long f60813h = -1;

        public BufferedRequestBody(long j11) {
            Buffer buffer = new Buffer();
            this.f60812g = buffer;
            a(buffer, j11);
        }

        public long contentLength() {
            return this.f60813h;
        }

        public Request prepareToSendRequest(Request request) throws IOException {
            if (request.header("Content-Length") != null) {
                return request;
            }
            this.f60828e.close();
            this.f60813h = this.f60812g.size();
            Request.Builder header = request.newBuilder().removeHeader(HttpHeaders.TRANSFER_ENCODING).header("Content-Length", Long.toString(this.f60812g.size()));
            if (!(header instanceof Request.Builder)) {
                return header.build();
            }
            return OkHttp3Instrumentation.build(header);
        }

        public void writeTo(BufferedSink bufferedSink) {
            this.f60812g.copyTo(bufferedSink.buffer(), 0, this.f60812g.size());
        }
    }

    public static abstract class DelegatingHttpsURLConnection extends HttpsURLConnection {
        private final HttpURLConnection delegate;

        public DelegatingHttpsURLConnection(HttpURLConnection httpURLConnection) {
            super(httpURLConnection.getURL());
            this.delegate = httpURLConnection;
        }

        public abstract Handshake a();

        public void addRequestProperty(String str, String str2) {
            this.delegate.addRequestProperty(str, str2);
        }

        public void connect() throws IOException {
            this.connected = true;
            this.delegate.connect();
        }

        public void disconnect() {
            this.delegate.disconnect();
        }

        public boolean getAllowUserInteraction() {
            return this.delegate.getAllowUserInteraction();
        }

        public String getCipherSuite() {
            Handshake a11 = a();
            if (a11 != null) {
                return a11.cipherSuite().javaName();
            }
            return null;
        }

        public int getConnectTimeout() {
            return this.delegate.getConnectTimeout();
        }

        public Object getContent() throws IOException {
            return this.delegate.getContent();
        }

        public String getContentEncoding() {
            return this.delegate.getContentEncoding();
        }

        public int getContentLength() {
            return this.delegate.getContentLength();
        }

        public long getContentLengthLong() {
            return this.delegate.getContentLengthLong();
        }

        public String getContentType() {
            return this.delegate.getContentType();
        }

        public long getDate() {
            return this.delegate.getDate();
        }

        public boolean getDefaultUseCaches() {
            return this.delegate.getDefaultUseCaches();
        }

        public boolean getDoInput() {
            return this.delegate.getDoInput();
        }

        public boolean getDoOutput() {
            return this.delegate.getDoOutput();
        }

        public InputStream getErrorStream() {
            return this.delegate.getErrorStream();
        }

        public long getExpiration() {
            return this.delegate.getExpiration();
        }

        public String getHeaderField(int i11) {
            return this.delegate.getHeaderField(i11);
        }

        public long getHeaderFieldDate(String str, long j11) {
            return this.delegate.getHeaderFieldDate(str, j11);
        }

        public int getHeaderFieldInt(String str, int i11) {
            return this.delegate.getHeaderFieldInt(str, i11);
        }

        public String getHeaderFieldKey(int i11) {
            return this.delegate.getHeaderFieldKey(i11);
        }

        public long getHeaderFieldLong(String str, long j11) {
            return this.delegate.getHeaderFieldLong(str, j11);
        }

        public Map<String, List<String>> getHeaderFields() {
            return this.delegate.getHeaderFields();
        }

        public abstract HostnameVerifier getHostnameVerifier();

        public long getIfModifiedSince() {
            return this.delegate.getIfModifiedSince();
        }

        public InputStream getInputStream() throws IOException {
            return this.delegate.getInputStream();
        }

        public boolean getInstanceFollowRedirects() {
            return this.delegate.getInstanceFollowRedirects();
        }

        public long getLastModified() {
            return this.delegate.getLastModified();
        }

        public Certificate[] getLocalCertificates() {
            Handshake a11 = a();
            if (a11 == null) {
                return null;
            }
            List<Certificate> localCertificates = a11.localCertificates();
            if (!localCertificates.isEmpty()) {
                return (Certificate[]) localCertificates.toArray(new Certificate[localCertificates.size()]);
            }
            return null;
        }

        public Principal getLocalPrincipal() {
            Handshake a11 = a();
            if (a11 != null) {
                return a11.localPrincipal();
            }
            return null;
        }

        public OutputStream getOutputStream() throws IOException {
            return this.delegate.getOutputStream();
        }

        public Principal getPeerPrincipal() {
            Handshake a11 = a();
            if (a11 != null) {
                return a11.peerPrincipal();
            }
            return null;
        }

        public Permission getPermission() throws IOException {
            return this.delegate.getPermission();
        }

        public int getReadTimeout() {
            return this.delegate.getReadTimeout();
        }

        public String getRequestMethod() {
            return this.delegate.getRequestMethod();
        }

        public Map<String, List<String>> getRequestProperties() {
            return this.delegate.getRequestProperties();
        }

        public String getRequestProperty(String str) {
            return this.delegate.getRequestProperty(str);
        }

        public int getResponseCode() throws IOException {
            return this.delegate.getResponseCode();
        }

        public String getResponseMessage() throws IOException {
            return this.delegate.getResponseMessage();
        }

        public abstract SSLSocketFactory getSSLSocketFactory();

        public Certificate[] getServerCertificates() {
            Handshake a11 = a();
            if (a11 == null) {
                return null;
            }
            List<Certificate> peerCertificates = a11.peerCertificates();
            if (!peerCertificates.isEmpty()) {
                return (Certificate[]) peerCertificates.toArray(new Certificate[peerCertificates.size()]);
            }
            return null;
        }

        public URL getURL() {
            return this.delegate.getURL();
        }

        public boolean getUseCaches() {
            return this.delegate.getUseCaches();
        }

        public void setAllowUserInteraction(boolean z11) {
            this.delegate.setAllowUserInteraction(z11);
        }

        public void setChunkedStreamingMode(int i11) {
            this.delegate.setChunkedStreamingMode(i11);
        }

        public void setConnectTimeout(int i11) {
            this.delegate.setConnectTimeout(i11);
        }

        public void setDefaultUseCaches(boolean z11) {
            this.delegate.setDefaultUseCaches(z11);
        }

        public void setDoInput(boolean z11) {
            this.delegate.setDoInput(z11);
        }

        public void setDoOutput(boolean z11) {
            this.delegate.setDoOutput(z11);
        }

        public void setFixedLengthStreamingMode(long j11) {
            this.delegate.setFixedLengthStreamingMode(j11);
        }

        public abstract void setHostnameVerifier(HostnameVerifier hostnameVerifier);

        public void setIfModifiedSince(long j11) {
            this.delegate.setIfModifiedSince(j11);
        }

        public void setInstanceFollowRedirects(boolean z11) {
            this.delegate.setInstanceFollowRedirects(z11);
        }

        public void setReadTimeout(int i11) {
            this.delegate.setReadTimeout(i11);
        }

        public void setRequestMethod(String str) throws ProtocolException {
            this.delegate.setRequestMethod(str);
        }

        public void setRequestProperty(String str, String str2) {
            this.delegate.setRequestProperty(str, str2);
        }

        public abstract void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory);

        public void setUseCaches(boolean z11) {
            this.delegate.setUseCaches(z11);
        }

        public String toString() {
            return this.delegate.toString();
        }

        public boolean usingProxy() {
            return this.delegate.usingProxy();
        }

        public Object getContent(Class[] clsArr) throws IOException {
            return this.delegate.getContent(clsArr);
        }

        public String getHeaderField(String str) {
            return this.delegate.getHeaderField(str);
        }

        public void setFixedLengthStreamingMode(int i11) {
            this.delegate.setFixedLengthStreamingMode(i11);
        }
    }

    @Instrumented
    public static final class OkHttpURLConnection extends HttpURLConnection implements Callback {

        /* renamed from: b  reason: collision with root package name */
        public OkHttpClient f60814b;

        /* renamed from: c  reason: collision with root package name */
        public final NetworkInterceptor f60815c = new NetworkInterceptor();
        private Throwable callFailure;

        /* renamed from: d  reason: collision with root package name */
        public Headers.Builder f60816d = new Headers.Builder();

        /* renamed from: e  reason: collision with root package name */
        public Headers f60817e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f60818f;

        /* renamed from: g  reason: collision with root package name */
        public Call f60819g;

        /* renamed from: h  reason: collision with root package name */
        public long f60820h = -1;

        /* renamed from: i  reason: collision with root package name */
        public Response f60821i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f60822j = true;

        /* renamed from: k  reason: collision with root package name */
        public Proxy f60823k;

        /* renamed from: l  reason: collision with root package name */
        public Handshake f60824l;
        /* access modifiers changed from: private */
        public final Object lock = new Object();
        private Response response;

        public final class NetworkInterceptor implements Interceptor {
            private boolean proceed;

            public NetworkInterceptor() {
            }

            /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|24) */
            /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
                java.lang.Thread.currentThread().interrupt();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0083, code lost:
                throw new java.io.InterruptedIOException();
             */
            /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0077 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public okhttp3.Response intercept(okhttp3.Interceptor.Chain r5) throws java.io.IOException {
                /*
                    r4 = this;
                    okhttp3.Request r0 = r5.request()
                    com.talabat.helpers.ObsoleteUrlFactory$OkHttpURLConnection r1 = com.talabat.helpers.ObsoleteUrlFactory.OkHttpURLConnection.this
                    java.lang.Object r1 = r1.lock
                    monitor-enter(r1)
                    com.talabat.helpers.ObsoleteUrlFactory$OkHttpURLConnection r2 = com.talabat.helpers.ObsoleteUrlFactory.OkHttpURLConnection.this     // Catch:{ all -> 0x0084 }
                    r3 = 0
                    r2.f60822j = r3     // Catch:{ all -> 0x0084 }
                    okhttp3.Connection r3 = r5.connection()     // Catch:{ all -> 0x0084 }
                    okhttp3.Route r3 = r3.route()     // Catch:{ all -> 0x0084 }
                    java.net.Proxy r3 = r3.proxy()     // Catch:{ all -> 0x0084 }
                    r2.f60823k = r3     // Catch:{ all -> 0x0084 }
                    com.talabat.helpers.ObsoleteUrlFactory$OkHttpURLConnection r2 = com.talabat.helpers.ObsoleteUrlFactory.OkHttpURLConnection.this     // Catch:{ all -> 0x0084 }
                    okhttp3.Connection r3 = r5.connection()     // Catch:{ all -> 0x0084 }
                    okhttp3.Handshake r3 = r3.handshake()     // Catch:{ all -> 0x0084 }
                    r2.f60824l = r3     // Catch:{ all -> 0x0084 }
                    com.talabat.helpers.ObsoleteUrlFactory$OkHttpURLConnection r2 = com.talabat.helpers.ObsoleteUrlFactory.OkHttpURLConnection.this     // Catch:{ all -> 0x0084 }
                    java.lang.Object r2 = r2.lock     // Catch:{ all -> 0x0084 }
                    r2.notifyAll()     // Catch:{ all -> 0x0084 }
                L_0x0033:
                    boolean r2 = r4.proceed     // Catch:{ InterruptedException -> 0x0077 }
                    if (r2 != 0) goto L_0x0041
                    com.talabat.helpers.ObsoleteUrlFactory$OkHttpURLConnection r2 = com.talabat.helpers.ObsoleteUrlFactory.OkHttpURLConnection.this     // Catch:{ InterruptedException -> 0x0077 }
                    java.lang.Object r2 = r2.lock     // Catch:{ InterruptedException -> 0x0077 }
                    r2.wait()     // Catch:{ InterruptedException -> 0x0077 }
                    goto L_0x0033
                L_0x0041:
                    monitor-exit(r1)     // Catch:{ all -> 0x0084 }
                    okhttp3.RequestBody r1 = r0.body()
                    boolean r1 = r1 instanceof com.talabat.helpers.ObsoleteUrlFactory.OutputStreamRequestBody
                    if (r1 == 0) goto L_0x0054
                    okhttp3.RequestBody r1 = r0.body()
                    com.talabat.helpers.ObsoleteUrlFactory$OutputStreamRequestBody r1 = (com.talabat.helpers.ObsoleteUrlFactory.OutputStreamRequestBody) r1
                    okhttp3.Request r0 = r1.prepareToSendRequest(r0)
                L_0x0054:
                    okhttp3.Response r5 = r5.proceed(r0)
                    com.talabat.helpers.ObsoleteUrlFactory$OkHttpURLConnection r0 = com.talabat.helpers.ObsoleteUrlFactory.OkHttpURLConnection.this
                    java.lang.Object r0 = r0.lock
                    monitor-enter(r0)
                    com.talabat.helpers.ObsoleteUrlFactory$OkHttpURLConnection r1 = com.talabat.helpers.ObsoleteUrlFactory.OkHttpURLConnection.this     // Catch:{ all -> 0x0074 }
                    r1.f60821i = r5     // Catch:{ all -> 0x0074 }
                    okhttp3.Request r2 = r5.request()     // Catch:{ all -> 0x0074 }
                    okhttp3.HttpUrl r2 = r2.url()     // Catch:{ all -> 0x0074 }
                    java.net.URL r2 = r2.url()     // Catch:{ all -> 0x0074 }
                    java.net.URL unused = r1.url = r2     // Catch:{ all -> 0x0074 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0074 }
                    return r5
                L_0x0074:
                    r5 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0074 }
                    throw r5
                L_0x0077:
                    java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0084 }
                    r5.interrupt()     // Catch:{ all -> 0x0084 }
                    java.io.InterruptedIOException r5 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0084 }
                    r5.<init>()     // Catch:{ all -> 0x0084 }
                    throw r5     // Catch:{ all -> 0x0084 }
                L_0x0084:
                    r5 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0084 }
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpers.ObsoleteUrlFactory.OkHttpURLConnection.NetworkInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
            }

            public void proceed() {
                synchronized (OkHttpURLConnection.this.lock) {
                    this.proceed = true;
                    OkHttpURLConnection.this.lock.notifyAll();
                }
            }
        }

        public OkHttpURLConnection(URL url, OkHttpClient okHttpClient) {
            super(url);
            this.f60814b = okHttpClient;
        }

        private Call buildCall() throws IOException {
            OutputStreamRequestBody outputStreamRequestBody;
            Request request;
            Call call;
            Call call2 = this.f60819g;
            if (call2 != null) {
                return call2;
            }
            boolean z11 = true;
            this.connected = true;
            if (this.doOutput) {
                if (this.method.equals("GET")) {
                    this.method = "POST";
                } else if (!ObsoleteUrlFactory.i(this.method)) {
                    throw new ProtocolException(this.method + " does not support writing");
                }
            }
            if (this.f60816d.get("User-Agent") == null) {
                this.f60816d.add("User-Agent", ObsoleteUrlFactory.d());
            }
            if (ObsoleteUrlFactory.i(this.method)) {
                if (this.f60816d.get("Content-Type") == null) {
                    this.f60816d.add("Content-Type", "application/x-www-form-urlencoded");
                }
                long j11 = -1;
                if (this.f60820h == -1 && this.chunkLength <= 0) {
                    z11 = false;
                }
                String str = this.f60816d.get("Content-Length");
                long j12 = this.f60820h;
                if (j12 != -1) {
                    j11 = j12;
                } else if (str != null) {
                    j11 = Long.parseLong(str);
                }
                if (z11) {
                    outputStreamRequestBody = new StreamedRequestBody(j11);
                } else {
                    outputStreamRequestBody = new BufferedRequestBody(j11);
                }
                outputStreamRequestBody.f60826c.timeout((long) this.f60814b.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
            } else {
                outputStreamRequestBody = null;
            }
            try {
                Request.Builder method = new Request.Builder().url(HttpUrl.get(getURL().toString())).headers(this.f60816d.build()).method(this.method, outputStreamRequestBody);
                if (!(method instanceof Request.Builder)) {
                    request = method.build();
                } else {
                    request = OkHttp3Instrumentation.build(method);
                }
                OkHttpClient.Builder newBuilder = this.f60814b.newBuilder();
                newBuilder.interceptors().add(UnexpectedException.f60833b);
                newBuilder.networkInterceptors().add(this.f60815c);
                newBuilder.dispatcher(new Dispatcher(this.f60814b.dispatcher().executorService()));
                if (!getUseCaches()) {
                    newBuilder.cache((Cache) null);
                }
                OkHttpClient build = newBuilder.build();
                if (!(build instanceof OkHttpClient)) {
                    call = build.newCall(request);
                } else {
                    call = OkHttp3Instrumentation.newCall(build, request);
                }
                this.f60819g = call;
                return call;
            } catch (IllegalArgumentException e11) {
                MalformedURLException malformedURLException = new MalformedURLException();
                malformedURLException.initCause(e11);
                throw malformedURLException;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001b, code lost:
            r3 = buildCall();
            r2.f60815c.proceed();
            r0 = (com.talabat.helpers.ObsoleteUrlFactory.OutputStreamRequestBody) r3.request().body();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
            if (r0 == null) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
            r0.f60828e.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            if (r2.f60818f == false) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            r0 = r2.lock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x003e, code lost:
            if (r2.response != null) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0042, code lost:
            if (r2.callFailure != null) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0044, code lost:
            r2.lock.wait();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x004c, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x004e, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x005a, code lost:
            throw new java.io.InterruptedIOException();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x005c, code lost:
            throw r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x005d, code lost:
            r2.f60818f = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            onResponse(r3, com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0068, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0069, code lost:
            onFailure(r3, r0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private okhttp3.Response getResponse(boolean r3) throws java.io.IOException {
            /*
                r2 = this;
                java.lang.Object r0 = r2.lock
                monitor-enter(r0)
                okhttp3.Response r1 = r2.response     // Catch:{ all -> 0x0088 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0088 }
                return r1
            L_0x0009:
                java.lang.Throwable r1 = r2.callFailure     // Catch:{ all -> 0x0088 }
                if (r1 == 0) goto L_0x001a
                if (r3 == 0) goto L_0x0015
                okhttp3.Response r3 = r2.f60821i     // Catch:{ all -> 0x0088 }
                if (r3 == 0) goto L_0x0015
                monitor-exit(r0)     // Catch:{ all -> 0x0088 }
                return r3
            L_0x0015:
                java.io.IOException r3 = com.talabat.helpers.ObsoleteUrlFactory.j(r1)     // Catch:{ all -> 0x0088 }
                throw r3     // Catch:{ all -> 0x0088 }
            L_0x001a:
                monitor-exit(r0)     // Catch:{ all -> 0x0088 }
                okhttp3.Call r3 = r2.buildCall()
                com.talabat.helpers.ObsoleteUrlFactory$OkHttpURLConnection$NetworkInterceptor r0 = r2.f60815c
                r0.proceed()
                okhttp3.Request r0 = r3.request()
                okhttp3.RequestBody r0 = r0.body()
                com.talabat.helpers.ObsoleteUrlFactory$OutputStreamRequestBody r0 = (com.talabat.helpers.ObsoleteUrlFactory.OutputStreamRequestBody) r0
                if (r0 == 0) goto L_0x0035
                java.io.OutputStream r0 = r0.f60828e
                r0.close()
            L_0x0035:
                boolean r0 = r2.f60818f
                if (r0 == 0) goto L_0x005d
                java.lang.Object r0 = r2.lock
                monitor-enter(r0)
            L_0x003c:
                okhttp3.Response r3 = r2.response     // Catch:{ InterruptedException -> 0x004e }
                if (r3 != 0) goto L_0x004a
                java.lang.Throwable r3 = r2.callFailure     // Catch:{ InterruptedException -> 0x004e }
                if (r3 != 0) goto L_0x004a
                java.lang.Object r3 = r2.lock     // Catch:{ InterruptedException -> 0x004e }
                r3.wait()     // Catch:{ InterruptedException -> 0x004e }
                goto L_0x003c
            L_0x004a:
                monitor-exit(r0)     // Catch:{ all -> 0x004c }
                goto L_0x006c
            L_0x004c:
                r3 = move-exception
                goto L_0x005b
            L_0x004e:
                java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x004c }
                r3.interrupt()     // Catch:{ all -> 0x004c }
                java.io.InterruptedIOException r3 = new java.io.InterruptedIOException     // Catch:{ all -> 0x004c }
                r3.<init>()     // Catch:{ all -> 0x004c }
                throw r3     // Catch:{ all -> 0x004c }
            L_0x005b:
                monitor-exit(r0)     // Catch:{ all -> 0x004c }
                throw r3
            L_0x005d:
                r0 = 1
                r2.f60818f = r0
                okhttp3.Response r0 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r3)     // Catch:{ IOException -> 0x0068 }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0068 }
                goto L_0x006c
            L_0x0068:
                r0 = move-exception
                r2.onFailure(r3, r0)
            L_0x006c:
                java.lang.Object r3 = r2.lock
                monitor-enter(r3)
                java.lang.Throwable r0 = r2.callFailure     // Catch:{ all -> 0x0085 }
                if (r0 != 0) goto L_0x0080
                okhttp3.Response r0 = r2.response     // Catch:{ all -> 0x0085 }
                if (r0 == 0) goto L_0x0079
                monitor-exit(r3)     // Catch:{ all -> 0x0085 }
                return r0
            L_0x0079:
                monitor-exit(r3)     // Catch:{ all -> 0x0085 }
                java.lang.AssertionError r3 = new java.lang.AssertionError
                r3.<init>()
                throw r3
            L_0x0080:
                java.io.IOException r0 = com.talabat.helpers.ObsoleteUrlFactory.j(r0)     // Catch:{ all -> 0x0085 }
                throw r0     // Catch:{ all -> 0x0085 }
            L_0x0085:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0085 }
                throw r0
            L_0x0088:
                r3 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0088 }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpers.ObsoleteUrlFactory.OkHttpURLConnection.getResponse(boolean):okhttp3.Response");
        }

        public void addRequestProperty(String str, String str2) {
            if (this.connected) {
                throw new IllegalStateException("Cannot add request property after connection is made");
            } else if (str == null) {
                throw new NullPointerException("field == null");
            } else if (str2 != null) {
                this.f60816d.add(str, str2);
            }
        }

        public Headers c() throws IOException {
            if (this.f60817e == null) {
                Response response2 = getResponse(true);
                this.f60817e = response2.headers().newBuilder().add("ObsoleteUrlFactory-Selected-Protocol", response2.protocol().toString()).add("ObsoleteUrlFactory-Response-Source", ObsoleteUrlFactory.k(response2)).build();
            }
            return this.f60817e;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|24) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
            throw new java.io.InterruptedIOException();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0031 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void connect() throws java.io.IOException {
            /*
                r2 = this;
                boolean r0 = r2.f60818f
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                okhttp3.Call r0 = r2.buildCall()
                r1 = 1
                r2.f60818f = r1
                com.google.firebase.perf.network.FirebasePerfOkHttpClient.enqueue(r0, r2)
                java.lang.Object r0 = r2.lock
                monitor-enter(r0)
            L_0x0012:
                boolean r1 = r2.f60822j     // Catch:{ InterruptedException -> 0x0031 }
                if (r1 == 0) goto L_0x0024
                okhttp3.Response r1 = r2.response     // Catch:{ InterruptedException -> 0x0031 }
                if (r1 != 0) goto L_0x0024
                java.lang.Throwable r1 = r2.callFailure     // Catch:{ InterruptedException -> 0x0031 }
                if (r1 != 0) goto L_0x0024
                java.lang.Object r1 = r2.lock     // Catch:{ InterruptedException -> 0x0031 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0031 }
                goto L_0x0012
            L_0x0024:
                java.lang.Throwable r1 = r2.callFailure     // Catch:{ InterruptedException -> 0x0031 }
                if (r1 != 0) goto L_0x002a
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                return
            L_0x002a:
                java.io.IOException r1 = com.talabat.helpers.ObsoleteUrlFactory.j(r1)     // Catch:{ InterruptedException -> 0x0031 }
                throw r1     // Catch:{ InterruptedException -> 0x0031 }
            L_0x002f:
                r1 = move-exception
                goto L_0x003e
            L_0x0031:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002f }
                r1.interrupt()     // Catch:{ all -> 0x002f }
                java.io.InterruptedIOException r1 = new java.io.InterruptedIOException     // Catch:{ all -> 0x002f }
                r1.<init>()     // Catch:{ all -> 0x002f }
                throw r1     // Catch:{ all -> 0x002f }
            L_0x003e:
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpers.ObsoleteUrlFactory.OkHttpURLConnection.connect():void");
        }

        public void disconnect() {
            if (this.f60819g != null) {
                this.f60815c.proceed();
                this.f60819g.cancel();
            }
        }

        public int getConnectTimeout() {
            return this.f60814b.connectTimeoutMillis();
        }

        public InputStream getErrorStream() {
            try {
                Response response2 = getResponse(true);
                if (ObsoleteUrlFactory.g(response2) && response2.code() >= 400) {
                    return response2.body().byteStream();
                }
            } catch (IOException unused) {
            }
            return null;
        }

        public String getHeaderField(int i11) {
            try {
                Headers c11 = c();
                if (i11 >= 0) {
                    if (i11 < c11.size()) {
                        return c11.value(i11);
                    }
                }
            } catch (IOException unused) {
            }
            return null;
        }

        public String getHeaderFieldKey(int i11) {
            try {
                Headers c11 = c();
                if (i11 >= 0) {
                    if (i11 < c11.size()) {
                        return c11.name(i11);
                    }
                }
            } catch (IOException unused) {
            }
            return null;
        }

        public Map<String, List<String>> getHeaderFields() {
            try {
                return ObsoleteUrlFactory.n(c(), ObsoleteUrlFactory.l(getResponse(true)));
            } catch (IOException unused) {
                return Collections.emptyMap();
            }
        }

        public InputStream getInputStream() throws IOException {
            if (this.doInput) {
                Response response2 = getResponse(false);
                if (response2.code() < 400) {
                    return response2.body().byteStream();
                }
                throw new FileNotFoundException(this.url.toString());
            }
            throw new ProtocolException("This protocol does not support input");
        }

        public boolean getInstanceFollowRedirects() {
            return this.f60814b.followRedirects();
        }

        public OutputStream getOutputStream() throws IOException {
            OutputStreamRequestBody outputStreamRequestBody = (OutputStreamRequestBody) buildCall().request().body();
            if (outputStreamRequestBody != null) {
                if (outputStreamRequestBody instanceof StreamedRequestBody) {
                    connect();
                    this.f60815c.proceed();
                }
                if (!outputStreamRequestBody.f60829f) {
                    return outputStreamRequestBody.f60828e;
                }
                throw new ProtocolException("cannot write request body after response has been read");
            }
            throw new ProtocolException("method does not support a request body: " + this.method);
        }

        public Permission getPermission() {
            int i11;
            URL url = getURL();
            String host = url.getHost();
            if (url.getPort() != -1) {
                i11 = url.getPort();
            } else {
                i11 = HttpUrl.defaultPort(url.getProtocol());
            }
            if (usingProxy()) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) this.f60814b.proxy().address();
                host = inetSocketAddress.getHostName();
                i11 = inetSocketAddress.getPort();
            }
            return new SocketPermission(host + CertificateUtil.DELIMITER + i11, "connect, resolve");
        }

        public int getReadTimeout() {
            return this.f60814b.readTimeoutMillis();
        }

        public Map<String, List<String>> getRequestProperties() {
            if (!this.connected) {
                return ObsoleteUrlFactory.n(this.f60816d.build(), (String) null);
            }
            throw new IllegalStateException("Cannot access request header fields after connection is set");
        }

        public String getRequestProperty(String str) {
            if (str == null) {
                return null;
            }
            return this.f60816d.get(str);
        }

        public int getResponseCode() throws IOException {
            return getResponse(true).code();
        }

        public String getResponseMessage() throws IOException {
            return getResponse(true).message();
        }

        public void onFailure(Call call, IOException iOException) {
            synchronized (this.lock) {
                boolean z11 = iOException instanceof UnexpectedException;
                Throwable th2 = iOException;
                if (z11) {
                    th2 = iOException.getCause();
                }
                this.callFailure = th2;
                this.lock.notifyAll();
            }
        }

        public void onResponse(Call call, Response response2) {
            synchronized (this.lock) {
                this.response = response2;
                this.f60824l = response2.handshake();
                this.url = response2.request().url().url();
                this.lock.notifyAll();
            }
        }

        public void setConnectTimeout(int i11) {
            this.f60814b = this.f60814b.newBuilder().connectTimeout((long) i11, TimeUnit.MILLISECONDS).build();
        }

        public void setFixedLengthStreamingMode(int i11) {
            setFixedLengthStreamingMode((long) i11);
        }

        public void setIfModifiedSince(long j11) {
            super.setIfModifiedSince(j11);
            if (this.ifModifiedSince != 0) {
                this.f60816d.set(HttpHeaders.IF_MODIFIED_SINCE, ObsoleteUrlFactory.e(new Date(this.ifModifiedSince)));
            } else {
                this.f60816d.removeAll(HttpHeaders.IF_MODIFIED_SINCE);
            }
        }

        public void setInstanceFollowRedirects(boolean z11) {
            this.f60814b = this.f60814b.newBuilder().followRedirects(z11).build();
        }

        public void setReadTimeout(int i11) {
            this.f60814b = this.f60814b.newBuilder().readTimeout((long) i11, TimeUnit.MILLISECONDS).build();
        }

        public void setRequestMethod(String str) throws ProtocolException {
            Set<String> set = ObsoleteUrlFactory.f60806b;
            if (set.contains(str)) {
                this.method = str;
                return;
            }
            throw new ProtocolException("Expected one of " + set + " but was " + str);
        }

        public void setRequestProperty(String str, String str2) {
            if (this.connected) {
                throw new IllegalStateException("Cannot set request property after connection is made");
            } else if (str == null) {
                throw new NullPointerException("field == null");
            } else if (str2 != null) {
                this.f60816d.set(str, str2);
            }
        }

        public boolean usingProxy() {
            if (this.f60823k != null) {
                return true;
            }
            Proxy proxy = this.f60814b.proxy();
            if (proxy == null || proxy.type() == Proxy.Type.DIRECT) {
                return false;
            }
            return true;
        }

        public void setFixedLengthStreamingMode(long j11) {
            if (this.connected) {
                throw new IllegalStateException("Already connected");
            } else if (this.chunkLength > 0) {
                throw new IllegalStateException("Already in chunked mode");
            } else if (j11 >= 0) {
                this.f60820h = j11;
                this.fixedContentLength = (int) Math.min(j11, 2147483647L);
            } else {
                throw new IllegalArgumentException("contentLength < 0");
            }
        }

        public String getHeaderField(String str) {
            if (str != null) {
                return c().get(str);
            }
            try {
                return ObsoleteUrlFactory.l(getResponse(true));
            } catch (IOException unused) {
                return null;
            }
        }
    }

    public static final class OkHttpsURLConnection extends DelegatingHttpsURLConnection {
        private final OkHttpURLConnection delegate;

        public OkHttpsURLConnection(URL url, OkHttpClient okHttpClient) {
            this(new OkHttpURLConnection(url, okHttpClient));
        }

        public Handshake a() {
            OkHttpURLConnection okHttpURLConnection = this.delegate;
            if (okHttpURLConnection.f60819g != null) {
                return okHttpURLConnection.f60824l;
            }
            throw new IllegalStateException("Connection has not yet been established");
        }

        public HostnameVerifier getHostnameVerifier() {
            return this.delegate.f60814b.hostnameVerifier();
        }

        public SSLSocketFactory getSSLSocketFactory() {
            return this.delegate.f60814b.sslSocketFactory();
        }

        public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            OkHttpURLConnection okHttpURLConnection = this.delegate;
            okHttpURLConnection.f60814b = okHttpURLConnection.f60814b.newBuilder().hostnameVerifier(hostnameVerifier).build();
        }

        public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                OkHttpURLConnection okHttpURLConnection = this.delegate;
                okHttpURLConnection.f60814b = okHttpURLConnection.f60814b.newBuilder().sslSocketFactory(sSLSocketFactory).build();
                return;
            }
            throw new IllegalArgumentException("sslSocketFactory == null");
        }

        public OkHttpsURLConnection(OkHttpURLConnection okHttpURLConnection) {
            super(okHttpURLConnection);
            this.delegate = okHttpURLConnection;
        }
    }

    public static abstract class OutputStreamRequestBody extends RequestBody {

        /* renamed from: c  reason: collision with root package name */
        public Timeout f60826c;

        /* renamed from: d  reason: collision with root package name */
        public long f60827d;

        /* renamed from: e  reason: collision with root package name */
        public OutputStream f60828e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f60829f;

        public void a(final BufferedSink bufferedSink, final long j11) {
            this.f60826c = bufferedSink.timeout();
            this.f60827d = j11;
            this.f60828e = new OutputStream() {
                private long bytesReceived;

                public void close() throws IOException {
                    OutputStreamRequestBody.this.f60829f = true;
                    long j11 = j11;
                    if (j11 == -1 || this.bytesReceived >= j11) {
                        bufferedSink.close();
                        return;
                    }
                    throw new ProtocolException("expected " + j11 + " bytes but received " + this.bytesReceived);
                }

                public void flush() throws IOException {
                    if (!OutputStreamRequestBody.this.f60829f) {
                        bufferedSink.flush();
                    }
                }

                public void write(int i11) throws IOException {
                    write(new byte[]{(byte) i11}, 0, 1);
                }

                public void write(byte[] bArr, int i11, int i12) throws IOException {
                    if (!OutputStreamRequestBody.this.f60829f) {
                        long j11 = j11;
                        if (j11 == -1 || this.bytesReceived + ((long) i12) <= j11) {
                            this.bytesReceived += (long) i12;
                            try {
                                bufferedSink.write(bArr, i11, i12);
                            } catch (InterruptedIOException e11) {
                                throw new SocketTimeoutException(e11.getMessage());
                            }
                        } else {
                            throw new ProtocolException("expected " + j11 + " bytes but received " + this.bytesReceived + i12);
                        }
                    } else {
                        throw new IOException("closed");
                    }
                }
            };
        }

        public long contentLength() {
            return this.f60827d;
        }

        @Nullable
        public final MediaType contentType() {
            return null;
        }

        public Request prepareToSendRequest(Request request) throws IOException {
            return request;
        }
    }

    public static final class StreamedRequestBody extends OutputStreamRequestBody {
        private final Pipe pipe;

        public StreamedRequestBody(long j11) {
            Pipe pipe2 = new Pipe(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            this.pipe = pipe2;
            a(Okio.buffer(pipe2.sink()), j11);
        }

        public boolean isOneShot() {
            return true;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Buffer buffer = new Buffer();
            while (this.pipe.source().read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                bufferedSink.write(buffer, buffer.size());
            }
        }
    }

    public static final class ThreadLocalFactory {
        private ThreadLocalFactory() {
        }

        public static <T> ThreadLocal<T> a(Supplier<T> supplier) {
            ThreadLocal<T> threadLocal = new ThreadLocal<>();
            threadLocal.set(supplier.get());
            return threadLocal;
        }
    }

    public static final class UnexpectedException extends IOException {

        /* renamed from: b  reason: collision with root package name */
        public static final Interceptor f60833b = new a();

        public UnexpectedException(Throwable th2) {
            super(th2);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Response lambda$static$0(Interceptor.Chain chain) throws IOException {
            try {
                return chain.proceed(chain.request());
            } catch (Error | RuntimeException e11) {
                throw new UnexpectedException(e11);
            }
        }
    }

    public ObsoleteUrlFactory(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public static long c(Headers headers) {
        String str = headers.get("Content-Length");
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static String d() {
        String f11 = f("http.agent", (String) null);
        if (f11 != null) {
            return m(f11);
        }
        return "ObsoleteUrlFactory";
    }

    public static String e(Date date) {
        return f60808d.get().format(date);
    }

    public static String f(String str, @Nullable String str2) {
        try {
            String property = System.getProperty(str);
            return property != null ? property : str2;
        } catch (AccessControlException unused) {
            return str2;
        }
    }

    public static boolean g(Response response) {
        if (response.request().method().equals(FirebasePerformance.HttpMethod.HEAD)) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && c(response.headers()) == -1 && !"chunked".equalsIgnoreCase(response.header(HttpHeaders.TRANSFER_ENCODING))) {
            return false;
        }
        return true;
    }

    public static boolean i(String str) {
        if (str.equals("GET") || str.equals(FirebasePerformance.HttpMethod.HEAD)) {
            return false;
        }
        return true;
    }

    public static IOException j(Throwable th2) throws IOException {
        if (th2 instanceof IOException) {
            throw ((IOException) th2);
        } else if (th2 instanceof Error) {
            throw ((Error) th2);
        } else if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        } else {
            throw new AssertionError();
        }
    }

    public static String k(Response response) {
        if (response.networkResponse() == null) {
            if (response.cacheResponse() == null) {
                return Profile.DataLevel.NONE;
            }
            return "CACHE " + response.code();
        } else if (response.cacheResponse() == null) {
            return "NETWORK " + response.code();
        } else {
            return "CONDITIONAL_CACHE " + response.networkResponse().code();
        }
    }

    public static String l(Response response) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        if (response.protocol() == Protocol.HTTP_1_0) {
            str = "HTTP/1.0";
        } else {
            str = "HTTP/1.1";
        }
        sb2.append(str);
        sb2.append(' ');
        sb2.append(response.code());
        sb2.append(' ');
        sb2.append(response.message());
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ DateFormat lambda$static$0() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(f60807c);
        return simpleDateFormat;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$1(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        if (str2 == null) {
            return 1;
        }
        return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
    }

    public static String m(String str) {
        int i11;
        int length = str.length();
        int i12 = 0;
        while (i12 < length) {
            int codePointAt = str.codePointAt(i12);
            if (codePointAt <= 31 || codePointAt >= 127) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i12);
                buffer.writeUtf8CodePoint(63);
                while (true) {
                    i12 += Character.charCount(codePointAt);
                    if (i12 < length) {
                        codePointAt = str.codePointAt(i12);
                        if (codePointAt <= 31 || codePointAt >= 127) {
                            i11 = 63;
                        } else {
                            i11 = codePointAt;
                        }
                        buffer.writeUtf8CodePoint(i11);
                    } else {
                        String readUtf8 = buffer.readUtf8();
                        buffer.close();
                        return readUtf8;
                    }
                }
            } else {
                i12 += Character.charCount(codePointAt);
            }
        }
        return str;
    }

    public static Map<String, List<String>> n(Headers headers, @Nullable String str) {
        TreeMap treeMap = new TreeMap(f60809e);
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            String name2 = headers.name(i11);
            String value = headers.value(i11);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(name2);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(value);
            treeMap.put(name2, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put((Object) null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public OkHttpClient client() {
        return this.client;
    }

    public URLStreamHandler createURLStreamHandler(final String str) {
        if (str.equals(ProxyConfig.MATCH_HTTP) || str.equals("https")) {
            return new URLStreamHandler() {
                public int getDefaultPort() {
                    if (str.equals(ProxyConfig.MATCH_HTTP)) {
                        return 80;
                    }
                    if (str.equals("https")) {
                        return 443;
                    }
                    throw new AssertionError();
                }

                public URLConnection openConnection(URL url) {
                    return ObsoleteUrlFactory.this.open(url);
                }

                public URLConnection openConnection(URL url, Proxy proxy) {
                    return ObsoleteUrlFactory.this.h(url, proxy);
                }
            };
        }
        return null;
    }

    public HttpURLConnection h(URL url, @Nullable Proxy proxy) {
        String protocol = url.getProtocol();
        OkHttpClient build = this.client.newBuilder().proxy(proxy).build();
        if (protocol.equals(ProxyConfig.MATCH_HTTP)) {
            return new OkHttpURLConnection(url, build);
        }
        if (protocol.equals("https")) {
            return new OkHttpsURLConnection(url, build);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }

    public HttpURLConnection open(URL url) {
        return h(url, this.client.proxy());
    }

    public ObsoleteUrlFactory setClient(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
        return this;
    }

    public ObsoleteUrlFactory clone() {
        return new ObsoleteUrlFactory(this.client);
    }
}
