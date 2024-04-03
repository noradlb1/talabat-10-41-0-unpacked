package okhttp3.internal.cache;

import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy;", "", "networkRequest", "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(Lokhttp3/Request;Lokhttp3/Response;)V", "getCacheResponse", "()Lokhttp3/Response;", "getNetworkRequest", "()Lokhttp3/Request;", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CacheStrategy {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final Response cacheResponse;
    @Nullable
    private final Request networkRequest;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "()V", "isCacheable", "", "response", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isCacheable(@NotNull Response response, @NotNull Request request) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(request, "request");
            int code = response.code();
            if (!(code == 200 || code == 410 || code == 414 || code == 501 || code == 203 || code == 204)) {
                if (code != 307) {
                    if (!(code == 308 || code == 404 || code == 405)) {
                        switch (code) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (Response.header$default(response, HttpHeaders.EXPIRES, (String) null, 2, (Object) null) == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                    return false;
                }
            }
            if (response.cacheControl().noStore() || request.cacheControl().noStore()) {
                return false;
            }
            return true;
        }
    }

    @Instrumented
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "nowMillis", "", "request", "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(JLokhttp3/Request;Lokhttp3/Response;)V", "ageSeconds", "", "etag", "", "expires", "Ljava/util/Date;", "lastModified", "lastModifiedString", "receivedResponseMillis", "getRequest$okhttp", "()Lokhttp3/Request;", "sentRequestMillis", "servedDate", "servedDateString", "cacheResponseAge", "compute", "Lokhttp3/internal/cache/CacheStrategy;", "computeCandidate", "computeFreshnessLifetime", "hasConditions", "", "isFreshnessLifetimeHeuristic", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Factory {
        private int ageSeconds = -1;
        @Nullable
        private final Response cacheResponse;
        @Nullable
        private String etag;
        @Nullable
        private Date expires;
        @Nullable
        private Date lastModified;
        @Nullable
        private String lastModifiedString;
        private final long nowMillis;
        private long receivedResponseMillis;
        @NotNull
        private final Request request;
        private long sentRequestMillis;
        @Nullable
        private Date servedDate;
        @Nullable
        private String servedDateString;

        public Factory(long j11, @NotNull Request request2, @Nullable Response response) {
            Intrinsics.checkNotNullParameter(request2, "request");
            this.nowMillis = j11;
            this.request = request2;
            this.cacheResponse = response;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                int i11 = 0;
                while (i11 < size) {
                    int i12 = i11 + 1;
                    String name2 = headers.name(i11);
                    String value = headers.value(i11);
                    if (StringsKt__StringsJVMKt.equals(name2, HttpHeaders.DATE, true)) {
                        this.servedDate = DatesKt.toHttpDateOrNull(value);
                        this.servedDateString = value;
                    } else if (StringsKt__StringsJVMKt.equals(name2, HttpHeaders.EXPIRES, true)) {
                        this.expires = DatesKt.toHttpDateOrNull(value);
                    } else if (StringsKt__StringsJVMKt.equals(name2, HttpHeaders.LAST_MODIFIED, true)) {
                        this.lastModified = DatesKt.toHttpDateOrNull(value);
                        this.lastModifiedString = value;
                    } else if (StringsKt__StringsJVMKt.equals(name2, HttpHeaders.ETAG, true)) {
                        this.etag = value;
                    } else if (StringsKt__StringsJVMKt.equals(name2, HttpHeaders.AGE, true)) {
                        this.ageSeconds = Util.toNonNegativeInt(value, -1);
                    }
                    i11 = i12;
                }
            }
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long j11 = 0;
            if (date != null) {
                j11 = Math.max(0, this.receivedResponseMillis - date.getTime());
            }
            int i11 = this.ageSeconds;
            if (i11 != -1) {
                j11 = Math.max(j11, TimeUnit.SECONDS.toMillis((long) i11));
            }
            long j12 = this.receivedResponseMillis;
            return j11 + (j12 - this.sentRequestMillis) + (this.nowMillis - j12);
        }

        private final CacheStrategy computeCandidate() {
            long j11;
            String str;
            Request request2;
            Response.Builder builder;
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, (Response) null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, (Response) null);
            }
            if (!CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, (Response) null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, (Response) null);
            }
            CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            long cacheResponseAge = cacheResponseAge();
            long computeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl.maxAgeSeconds() != -1) {
                computeFreshnessLifetime = Math.min(computeFreshnessLifetime, TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds()));
            }
            long j12 = 0;
            if (cacheControl.minFreshSeconds() != -1) {
                j11 = TimeUnit.SECONDS.toMillis((long) cacheControl.minFreshSeconds());
            } else {
                j11 = 0;
            }
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                j12 = TimeUnit.SECONDS.toMillis((long) cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j13 = j11 + cacheResponseAge;
                if (j13 < j12 + computeFreshnessLifetime) {
                    Response response = this.cacheResponse;
                    if (!(response instanceof Response.Builder)) {
                        builder = response.newBuilder();
                    } else {
                        builder = OkHttp3Instrumentation.newBuilder((Response.Builder) response);
                    }
                    if (j13 >= computeFreshnessLifetime) {
                        builder.addHeader(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (cacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                        builder.addHeader(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy((Request) null, builder.build());
                }
            }
            String str2 = this.etag;
            if (str2 != null) {
                str = HttpHeaders.IF_NONE_MATCH;
            } else {
                if (this.lastModified != null) {
                    str2 = this.lastModifiedString;
                } else if (this.servedDate == null) {
                    return new CacheStrategy(this.request, (Response) null);
                } else {
                    str2 = this.servedDateString;
                }
                str = HttpHeaders.IF_MODIFIED_SINCE;
            }
            Headers.Builder newBuilder = this.request.headers().newBuilder();
            Intrinsics.checkNotNull(str2);
            newBuilder.addLenient$okhttp(str, str2);
            Request.Builder headers = this.request.newBuilder().headers(newBuilder.build());
            if (!(headers instanceof Request.Builder)) {
                request2 = headers.build();
            } else {
                request2 = OkHttp3Instrumentation.build(headers);
            }
            return new CacheStrategy(request2, this.cacheResponse);
        }

        private final long computeFreshnessLifetime() {
            long j11;
            long j12;
            Response response = this.cacheResponse;
            Intrinsics.checkNotNull(response);
            CacheControl cacheControl = response.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds());
            }
            Date date = this.expires;
            Long l11 = null;
            if (date != null) {
                Date date2 = this.servedDate;
                if (date2 != null) {
                    l11 = Long.valueOf(date2.getTime());
                }
                if (l11 == null) {
                    j12 = this.receivedResponseMillis;
                } else {
                    j12 = l11.longValue();
                }
                long time = date.getTime() - j12;
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                return 0;
            } else {
                Date date3 = this.servedDate;
                if (date3 != null) {
                    l11 = Long.valueOf(date3.getTime());
                }
                if (l11 == null) {
                    j11 = this.sentRequestMillis;
                } else {
                    j11 = l11.longValue();
                }
                Date date4 = this.lastModified;
                Intrinsics.checkNotNull(date4);
                long time2 = j11 - date4.getTime();
                if (time2 > 0) {
                    return time2 / ((long) 10);
                }
                return 0;
            }
        }

        private final boolean hasConditions(Request request2) {
            if (request2.header(HttpHeaders.IF_MODIFIED_SINCE) == null && request2.header(HttpHeaders.IF_NONE_MATCH) == null) {
                return false;
            }
            return true;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            Response response = this.cacheResponse;
            Intrinsics.checkNotNull(response);
            return response.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        @NotNull
        public final CacheStrategy compute() {
            CacheStrategy computeCandidate = computeCandidate();
            if (computeCandidate.getNetworkRequest() == null || !this.request.cacheControl().onlyIfCached()) {
                return computeCandidate;
            }
            return new CacheStrategy((Request) null, (Response) null);
        }

        @NotNull
        public final Request getRequest$okhttp() {
            return this.request;
        }
    }

    public CacheStrategy(@Nullable Request request, @Nullable Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    @Nullable
    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    @Nullable
    public final Request getNetworkRequest() {
        return this.networkRequest;
    }
}
