package okhttp3.internal.cache;

import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "cache", "Lokhttp3/Cache;", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "cacheWritingResponse", "Lokhttp3/Response;", "cacheRequest", "Lokhttp3/internal/cache/CacheRequest;", "response", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CacheInterceptor implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final Cache cache;

    @Instrumented
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "()V", "combine", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isContentSpecificHeader", "", "fieldName", "", "isEndToEnd", "stripBody", "Lokhttp3/Response;", "response", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            int i11 = 0;
            int i12 = 0;
            while (i12 < size) {
                int i13 = i12 + 1;
                String name2 = headers.name(i12);
                String value = headers.value(i12);
                if ((!StringsKt__StringsJVMKt.equals(HttpHeaders.WARNING, name2, true) || !StringsKt__StringsJVMKt.startsWith$default(value, "1", false, 2, (Object) null)) && (isContentSpecificHeader(name2) || !isEndToEnd(name2) || headers2.get(name2) == null)) {
                    builder.addLenient$okhttp(name2, value);
                }
                i12 = i13;
            }
            int size2 = headers2.size();
            while (i11 < size2) {
                int i14 = i11 + 1;
                String name3 = headers2.name(i11);
                if (!isContentSpecificHeader(name3) && isEndToEnd(name3)) {
                    builder.addLenient$okhttp(name3, headers2.value(i11));
                }
                i11 = i14;
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            if (StringsKt__StringsJVMKt.equals("Content-Length", str, true) || StringsKt__StringsJVMKt.equals("Content-Encoding", str, true) || StringsKt__StringsJVMKt.equals("Content-Type", str, true)) {
                return true;
            }
            return false;
        }

        private final boolean isEndToEnd(String str) {
            if (StringsKt__StringsJVMKt.equals("Connection", str, true) || StringsKt__StringsJVMKt.equals(HttpHeaders.KEEP_ALIVE, str, true) || StringsKt__StringsJVMKt.equals(HttpHeaders.PROXY_AUTHENTICATE, str, true) || StringsKt__StringsJVMKt.equals(HttpHeaders.PROXY_AUTHORIZATION, str, true) || StringsKt__StringsJVMKt.equals(HttpHeaders.TE, str, true) || StringsKt__StringsJVMKt.equals("Trailers", str, true) || StringsKt__StringsJVMKt.equals(HttpHeaders.TRANSFER_ENCODING, str, true) || StringsKt__StringsJVMKt.equals(HttpHeaders.UPGRADE, str, true)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final Response stripBody(Response response) {
            ResponseBody responseBody;
            Response.Builder builder;
            Response.Builder builder2;
            if (response == null) {
                responseBody = null;
            } else {
                responseBody = response.body();
            }
            if (responseBody == null) {
                return response;
            }
            if (!(response instanceof Response.Builder)) {
                builder = response.newBuilder();
            } else {
                builder = OkHttp3Instrumentation.newBuilder((Response.Builder) response);
            }
            if (!(builder instanceof Response.Builder)) {
                builder2 = builder.body((ResponseBody) null);
            } else {
                builder2 = OkHttp3Instrumentation.body(builder, (ResponseBody) null);
            }
            return builder2.build();
        }
    }

    public CacheInterceptor(@Nullable Cache cache2) {
        this.cache = cache2;
    }

    private final Response cacheWritingResponse(CacheRequest cacheRequest, Response response) throws IOException {
        Response.Builder builder;
        Response.Builder builder2;
        if (cacheRequest == null) {
            return response;
        }
        Sink body = cacheRequest.body();
        ResponseBody body2 = response.body();
        Intrinsics.checkNotNull(body2);
        CacheInterceptor$cacheWritingResponse$cacheWritingSource$1 cacheInterceptor$cacheWritingResponse$cacheWritingSource$1 = new CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(body2.source(), cacheRequest, Okio.buffer(body));
        String header$default = Response.header$default(response, "Content-Type", (String) null, 2, (Object) null);
        long contentLength = response.body().contentLength();
        if (!(response instanceof Response.Builder)) {
            builder = response.newBuilder();
        } else {
            builder = OkHttp3Instrumentation.newBuilder((Response.Builder) response);
        }
        RealResponseBody realResponseBody = new RealResponseBody(header$default, contentLength, Okio.buffer((Source) cacheInterceptor$cacheWritingResponse$cacheWritingSource$1));
        if (!(builder instanceof Response.Builder)) {
            builder2 = builder.body(realResponseBody);
        } else {
            builder2 = OkHttp3Instrumentation.body(builder, realResponseBody);
        }
        return builder2.build();
    }

    @Nullable
    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Response response;
        RealCall realCall;
        ResponseBody body;
        Response.Builder builder;
        Response.Builder builder2;
        Response.Builder builder3;
        Response.Builder builder4;
        ResponseBody body2;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Call call = chain.call();
        Cache cache2 = this.cache;
        EventListener eventListener = null;
        if (cache2 == null) {
            response = null;
        } else {
            response = cache2.get$okhttp(chain.request());
        }
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        Cache cache3 = this.cache;
        if (cache3 != null) {
            cache3.trackResponse$okhttp(compute);
        }
        if (call instanceof RealCall) {
            realCall = (RealCall) call;
        } else {
            realCall = null;
        }
        if (realCall != null) {
            eventListener = realCall.getEventListener$okhttp();
        }
        if (eventListener == null) {
            eventListener = EventListener.NONE;
        }
        if (!(response == null || cacheResponse != null || (body2 = response.body()) == null)) {
            Util.closeQuietly((Closeable) body2);
        }
        if (networkRequest == null && cacheResponse == null) {
            Response.Builder message = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)");
            ResponseBody responseBody = Util.EMPTY_RESPONSE;
            if (!(message instanceof Response.Builder)) {
                builder4 = message.body(responseBody);
            } else {
                builder4 = OkHttp3Instrumentation.body(message, responseBody);
            }
            Response build = builder4.sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener.satisfactionFailure(call, build);
            return build;
        } else if (networkRequest == null) {
            Intrinsics.checkNotNull(cacheResponse);
            if (!(cacheResponse instanceof Response.Builder)) {
                builder3 = cacheResponse.newBuilder();
            } else {
                builder3 = OkHttp3Instrumentation.newBuilder((Response.Builder) cacheResponse);
            }
            Response build2 = builder3.cacheResponse(Companion.stripBody(cacheResponse)).build();
            eventListener.cacheHit(call, build2);
            return build2;
        } else {
            if (cacheResponse != null) {
                eventListener.cacheConditionalHit(call, cacheResponse);
            } else if (this.cache != null) {
                eventListener.cacheMiss(call);
            }
            try {
                Response proceed = chain.proceed(networkRequest);
                if (!(proceed != null || response == null || body == null)) {
                }
                if (cacheResponse != null) {
                    boolean z11 = false;
                    if (proceed != null && proceed.code() == 304) {
                        z11 = true;
                    }
                    if (z11) {
                        if (!(cacheResponse instanceof Response.Builder)) {
                            builder2 = cacheResponse.newBuilder();
                        } else {
                            builder2 = OkHttp3Instrumentation.newBuilder((Response.Builder) cacheResponse);
                        }
                        Companion companion = Companion;
                        Response build3 = builder2.headers(companion.combine(cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(companion.stripBody(cacheResponse)).networkResponse(companion.stripBody(proceed)).build();
                        ResponseBody body3 = proceed.body();
                        Intrinsics.checkNotNull(body3);
                        body3.close();
                        Cache cache4 = this.cache;
                        Intrinsics.checkNotNull(cache4);
                        cache4.trackConditionalCacheHit$okhttp();
                        this.cache.update$okhttp(cacheResponse, build3);
                        eventListener.cacheHit(call, build3);
                        return build3;
                    }
                    ResponseBody body4 = cacheResponse.body();
                    if (body4 != null) {
                        Util.closeQuietly((Closeable) body4);
                    }
                }
                Intrinsics.checkNotNull(proceed);
                if (!(proceed instanceof Response.Builder)) {
                    builder = proceed.newBuilder();
                } else {
                    builder = OkHttp3Instrumentation.newBuilder((Response.Builder) proceed);
                }
                Companion companion2 = Companion;
                Response build4 = builder.cacheResponse(companion2.stripBody(cacheResponse)).networkResponse(companion2.stripBody(proceed)).build();
                if (this.cache != null) {
                    if (okhttp3.internal.http.HttpHeaders.promisesBody(build4) && CacheStrategy.Companion.isCacheable(build4, networkRequest)) {
                        Response cacheWritingResponse = cacheWritingResponse(this.cache.put$okhttp(build4), build4);
                        if (cacheResponse != null) {
                            eventListener.cacheMiss(call);
                        }
                        return cacheWritingResponse;
                    } else if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                        try {
                            this.cache.remove$okhttp(networkRequest);
                        } catch (IOException unused) {
                        }
                    }
                }
                return build4;
            } finally {
                if (!(response == null || (body = response.body()) == null)) {
                    Util.closeQuietly((Closeable) body);
                }
            }
        }
    }
}
