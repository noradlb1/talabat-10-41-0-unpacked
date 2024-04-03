package okhttp3.internal.http;

import com.deliveryhero.customerchat.eventTracking.constants.ContactDetailsKeys;
import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "buildRedirectRequest", "Lokhttp3/Request;", "userResponse", "Lokhttp3/Response;", "method", "", "followUpRequest", "exchange", "Lokhttp3/internal/connection/Exchange;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "isRecoverable", "", "e", "Ljava/io/IOException;", "requestSendStarted", "recover", "call", "Lokhttp3/internal/connection/RealCall;", "userRequest", "requestIsOneShot", "retryAfter", "", "defaultDelay", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RetryAndFollowUpInterceptor implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_FOLLOW_UPS = 20;
    @NotNull
    private final OkHttpClient client;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "()V", "MAX_FOLLOW_UPS", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RetryAndFollowUpInterceptor(@NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, ContactDetailsKeys.SENT_FROM_VALUE);
        this.client = okHttpClient;
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String header$default;
        HttpUrl resolve;
        boolean z11;
        RequestBody requestBody = null;
        if (!this.client.followRedirects() || (header$default = Response.header$default(response, "Location", (String) null, 2, (Object) null)) == null || (resolve = response.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (!Intrinsics.areEqual((Object) resolve.scheme(), (Object) response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(str)) {
            int code = response.code();
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            if (httpMethod.redirectsWithBody(str) || code == 308 || code == 307) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!httpMethod.redirectsToGet(str) || code == 308 || code == 307) {
                if (z11) {
                    requestBody = response.request().body();
                }
                newBuilder.method(str, requestBody);
            } else {
                newBuilder.method("GET", (RequestBody) null);
            }
            if (!z11) {
                newBuilder.removeHeader(HttpHeaders.TRANSFER_ENCODING);
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(response.request().url(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        Request.Builder url = newBuilder.url(resolve);
        if (!(url instanceof Request.Builder)) {
            return url.build();
        }
        return OkHttp3Instrumentation.build(url);
    }

    private final Request followUpRequest(Response response, Exchange exchange) throws IOException {
        Route route;
        RealConnection connection$okhttp;
        if (exchange == null || (connection$okhttp = exchange.getConnection$okhttp()) == null) {
            route = null;
        } else {
            route = connection$okhttp.route();
        }
        int code = response.code();
        String method = response.request().method();
        if (!(code == 307 || code == 308)) {
            if (code == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (code == 421) {
                RequestBody body = response.request().body();
                if ((body != null && body.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                return response.request();
            } else if (code == 503) {
                Response priorResponse = response.priorResponse();
                if ((priorResponse == null || priorResponse.code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            } else if (code == 407) {
                Intrinsics.checkNotNull(route);
                if (route.proxy().type() == Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            } else if (code != 408) {
                switch (code) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            } else if (!this.client.retryOnConnectionFailure()) {
                return null;
            } else {
                RequestBody body2 = response.request().body();
                if (body2 != null && body2.isOneShot()) {
                    return null;
                }
                Response priorResponse2 = response.priorResponse();
                if ((priorResponse2 == null || priorResponse2.code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
        }
        return buildRedirectRequest(response, method);
    }

    private final boolean isRecoverable(IOException iOException, boolean z11) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z11) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request, boolean z11) {
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z11 || !requestIsOneShot(iOException, request)) && isRecoverable(iOException, z11) && realCall.retryAfterFailure()) {
            return true;
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody body = request.body();
        if ((body == null || !body.isOneShot()) && !(iOException instanceof FileNotFoundException)) {
            return false;
        }
        return true;
    }

    private final int retryAfter(Response response, int i11) {
        String header$default = Response.header$default(response, HttpHeaders.RETRY_AFTER, (String) null, 2, (Object) null);
        if (header$default == null) {
            return i11;
        }
        if (!new Regex("\\d+").matches(header$default)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(header$default);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(header)");
        return valueOf.intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        if ((r0 instanceof okhttp3.Response.Builder) != false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r0 = r0.newBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r0 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newBuilder((okhttp3.Response.Builder) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if ((r7 instanceof okhttp3.Response.Builder) != false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r6 = r7.newBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        r6 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newBuilder((okhttp3.Response.Builder) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
        if ((r6 instanceof okhttp3.Response.Builder) != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        r6 = r6.body((okhttp3.ResponseBody) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        r6 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.body(r6, (okhttp3.ResponseBody) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        r0 = r0.priorResponse(r6.build()).build();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        r7 = r0;
        r0 = r1.getInterceptorScopedExchange$okhttp();
        r6 = followUpRequest(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (r6 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        if (r0 == null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0070, code lost:
        if (r0.isDuplex$okhttp() == false) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0072, code lost:
        r1.timeoutEarlyExit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0075, code lost:
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0078, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r0 = r6.body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007d, code lost:
        if (r0 == null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0083, code lost:
        if (r0.isOneShot() == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0085, code lost:
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0088, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r0 = r7.body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008d, code lost:
        if (r0 != null) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0090, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0093, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0097, code lost:
        if (r8 > 20) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ae, code lost:
        throw new java.net.ProtocolException(kotlin.jvm.internal.Intrinsics.stringPlus("Too many follow-up requests: ", java.lang.Integer.valueOf(r8)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        if (r7 == null) goto L_0x005f;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain r11) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            okhttp3.internal.http.RealInterceptorChain r11 = (okhttp3.internal.http.RealInterceptorChain) r11
            okhttp3.Request r0 = r11.getRequest$okhttp()
            okhttp3.internal.connection.RealCall r1 = r11.getCall$okhttp()
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r3 = 0
            r4 = 0
            r5 = 1
            r8 = r3
            r7 = r4
        L_0x0018:
            r6 = r5
        L_0x0019:
            r1.enterNetworkInterceptorExchange(r0, r6)
            boolean r6 = r1.isCanceled()     // Catch:{ all -> 0x00f5 }
            if (r6 != 0) goto L_0x00ed
            okhttp3.Response r0 = r11.proceed(r0)     // Catch:{ RouteException -> 0x00c9, IOException -> 0x00af }
            if (r7 == 0) goto L_0x005f
            boolean r6 = r0 instanceof okhttp3.Response.Builder     // Catch:{ all -> 0x00f5 }
            if (r6 != 0) goto L_0x0031
            okhttp3.Response$Builder r0 = r0.newBuilder()     // Catch:{ all -> 0x00f5 }
            goto L_0x0037
        L_0x0031:
            okhttp3.Response$Builder r0 = (okhttp3.Response.Builder) r0     // Catch:{ all -> 0x00f5 }
            okhttp3.Response$Builder r0 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newBuilder(r0)     // Catch:{ all -> 0x00f5 }
        L_0x0037:
            boolean r6 = r7 instanceof okhttp3.Response.Builder     // Catch:{ all -> 0x00f5 }
            if (r6 != 0) goto L_0x0040
            okhttp3.Response$Builder r6 = r7.newBuilder()     // Catch:{ all -> 0x00f5 }
            goto L_0x0046
        L_0x0040:
            okhttp3.Response$Builder r7 = (okhttp3.Response.Builder) r7     // Catch:{ all -> 0x00f5 }
            okhttp3.Response$Builder r6 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newBuilder(r7)     // Catch:{ all -> 0x00f5 }
        L_0x0046:
            boolean r7 = r6 instanceof okhttp3.Response.Builder     // Catch:{ all -> 0x00f5 }
            if (r7 != 0) goto L_0x004f
            okhttp3.Response$Builder r6 = r6.body(r4)     // Catch:{ all -> 0x00f5 }
            goto L_0x0053
        L_0x004f:
            okhttp3.Response$Builder r6 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.body(r6, r4)     // Catch:{ all -> 0x00f5 }
        L_0x0053:
            okhttp3.Response r6 = r6.build()     // Catch:{ all -> 0x00f5 }
            okhttp3.Response$Builder r0 = r0.priorResponse(r6)     // Catch:{ all -> 0x00f5 }
            okhttp3.Response r0 = r0.build()     // Catch:{ all -> 0x00f5 }
        L_0x005f:
            r7 = r0
            okhttp3.internal.connection.Exchange r0 = r1.getInterceptorScopedExchange$okhttp()     // Catch:{ all -> 0x00f5 }
            okhttp3.Request r6 = r10.followUpRequest(r7, r0)     // Catch:{ all -> 0x00f5 }
            if (r6 != 0) goto L_0x0079
            if (r0 == 0) goto L_0x0075
            boolean r11 = r0.isDuplex$okhttp()     // Catch:{ all -> 0x00f5 }
            if (r11 == 0) goto L_0x0075
            r1.timeoutEarlyExit()     // Catch:{ all -> 0x00f5 }
        L_0x0075:
            r1.exitNetworkInterceptorExchange$okhttp(r3)
            return r7
        L_0x0079:
            okhttp3.RequestBody r0 = r6.body()     // Catch:{ all -> 0x00f5 }
            if (r0 == 0) goto L_0x0089
            boolean r0 = r0.isOneShot()     // Catch:{ all -> 0x00f5 }
            if (r0 == 0) goto L_0x0089
            r1.exitNetworkInterceptorExchange$okhttp(r3)
            return r7
        L_0x0089:
            okhttp3.ResponseBody r0 = r7.body()     // Catch:{ all -> 0x00f5 }
            if (r0 != 0) goto L_0x0090
            goto L_0x0093
        L_0x0090:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)     // Catch:{ all -> 0x00f5 }
        L_0x0093:
            int r8 = r8 + 1
            r0 = 20
            if (r8 > r0) goto L_0x009f
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            r0 = r6
            goto L_0x0018
        L_0x009f:
            java.net.ProtocolException r11 = new java.net.ProtocolException     // Catch:{ all -> 0x00f5 }
            java.lang.String r0 = "Too many follow-up requests: "
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x00f5 }
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r2)     // Catch:{ all -> 0x00f5 }
            r11.<init>(r0)     // Catch:{ all -> 0x00f5 }
            throw r11     // Catch:{ all -> 0x00f5 }
        L_0x00af:
            r6 = move-exception
            boolean r9 = r6 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x00f5 }
            if (r9 != 0) goto L_0x00b6
            r9 = r5
            goto L_0x00b7
        L_0x00b6:
            r9 = r3
        L_0x00b7:
            boolean r9 = r10.recover(r6, r1, r0, r9)     // Catch:{ all -> 0x00f5 }
            if (r9 == 0) goto L_0x00c4
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x00f5 }
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r2, r6)     // Catch:{ all -> 0x00f5 }
            goto L_0x00de
        L_0x00c4:
            java.lang.Throwable r11 = okhttp3.internal.Util.withSuppressed(r6, r2)     // Catch:{ all -> 0x00f5 }
            throw r11     // Catch:{ all -> 0x00f5 }
        L_0x00c9:
            r6 = move-exception
            java.io.IOException r9 = r6.getLastConnectException()     // Catch:{ all -> 0x00f5 }
            boolean r9 = r10.recover(r9, r1, r0, r3)     // Catch:{ all -> 0x00f5 }
            if (r9 == 0) goto L_0x00e4
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x00f5 }
            java.io.IOException r6 = r6.getFirstConnectException()     // Catch:{ all -> 0x00f5 }
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r2, r6)     // Catch:{ all -> 0x00f5 }
        L_0x00de:
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            r6 = r3
            goto L_0x0019
        L_0x00e4:
            java.io.IOException r11 = r6.getFirstConnectException()     // Catch:{ all -> 0x00f5 }
            java.lang.Throwable r11 = okhttp3.internal.Util.withSuppressed(r11, r2)     // Catch:{ all -> 0x00f5 }
            throw r11     // Catch:{ all -> 0x00f5 }
        L_0x00ed:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x00f5 }
            java.lang.String r0 = "Canceled"
            r11.<init>(r0)     // Catch:{ all -> 0x00f5 }
            throw r11     // Catch:{ all -> 0x00f5 }
        L_0x00f5:
            r11 = move-exception
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
