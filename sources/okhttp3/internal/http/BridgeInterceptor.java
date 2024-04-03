package okhttp3.internal.http;

import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okio.GzipSource;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/http/BridgeInterceptor;", "Lokhttp3/Interceptor;", "cookieJar", "Lokhttp3/CookieJar;", "(Lokhttp3/CookieJar;)V", "cookieHeader", "", "cookies", "", "Lokhttp3/Cookie;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BridgeInterceptor implements Interceptor {
    @NotNull
    private final CookieJar cookieJar;

    public BridgeInterceptor(@NotNull CookieJar cookieJar2) {
        Intrinsics.checkNotNullParameter(cookieJar2, "cookieJar");
        this.cookieJar = cookieJar2;
    }

    private final String cookieHeader(List<Cookie> list) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        for (Object next : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Cookie cookie = (Cookie) next;
            if (i11 > 0) {
                sb2.append("; ");
            }
            sb2.append(cookie.name());
            sb2.append(SignatureVisitor.INSTANCEOF);
            sb2.append(cookie.value());
            i11 = i12;
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Request request;
        Response.Builder builder;
        ResponseBody body;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request2 = chain.request();
        Request.Builder newBuilder = request2.newBuilder();
        RequestBody body2 = request2.body();
        if (body2 != null) {
            MediaType contentType = body2.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", String.valueOf(contentLength));
                newBuilder.removeHeader(HttpHeaders.TRANSFER_ENCODING);
            } else {
                newBuilder.header(HttpHeaders.TRANSFER_ENCODING, "chunked");
                newBuilder.removeHeader("Content-Length");
            }
        }
        boolean z11 = false;
        if (request2.header("Host") == null) {
            newBuilder.header("Host", Util.toHostHeader$default(request2.url(), false, 1, (Object) null));
        }
        if (request2.header("Connection") == null) {
            newBuilder.header("Connection", HttpHeaders.KEEP_ALIVE);
        }
        if (request2.header(HttpHeaders.ACCEPT_ENCODING) == null && request2.header(HttpHeaders.RANGE) == null) {
            newBuilder.header(HttpHeaders.ACCEPT_ENCODING, Constants.Network.ContentType.GZIP);
            z11 = true;
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request2.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(HttpHeaders.COOKIE, cookieHeader(loadForRequest));
        }
        if (request2.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Util.userAgent);
        }
        if (!(newBuilder instanceof Request.Builder)) {
            request = newBuilder.build();
        } else {
            request = OkHttp3Instrumentation.build(newBuilder);
        }
        Response proceed = chain.proceed(request);
        HttpHeaders.receiveHeaders(this.cookieJar, request2.url(), proceed.headers());
        if (!(proceed instanceof Response.Builder)) {
            builder = proceed.newBuilder();
        } else {
            builder = OkHttp3Instrumentation.newBuilder((Response.Builder) proceed);
        }
        Response.Builder request3 = builder.request(request2);
        if (z11 && StringsKt__StringsJVMKt.equals(Constants.Network.ContentType.GZIP, Response.header$default(proceed, "Content-Encoding", (String) null, 2, (Object) null), true) && HttpHeaders.promisesBody(proceed) && (body = proceed.body()) != null) {
            GzipSource gzipSource = new GzipSource(body.source());
            request3.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            OkHttp3Instrumentation.body(request3, new RealResponseBody(Response.header$default(proceed, "Content-Type", (String) null, 2, (Object) null), -1, Okio.buffer((Source) gzipSource)));
        }
        return request3.build();
    }
}
