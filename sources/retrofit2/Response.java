package retrofit2;

import com.deliveryhero.customerchat.analytics.service.AnalyticsClientKt;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.OkHttpCall;

@Instrumented
public final class Response<T> {
    @Nullable
    private final T body;
    @Nullable
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    private Response(okhttp3.Response response, @Nullable T t11, @Nullable ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t11;
        this.errorBody = responseBody;
    }

    public static <T> Response<T> error(int i11, ResponseBody responseBody) {
        Objects.requireNonNull(responseBody, "body == null");
        if (i11 >= 400) {
            Response.Builder protocol = OkHttp3Instrumentation.body(new Response.Builder(), new OkHttpCall.NoContentResponseBody(responseBody.contentType(), responseBody.contentLength())).code(i11).message("Response.error()").protocol(Protocol.HTTP_1_1);
            Request.Builder url = new Request.Builder().url(AnalyticsClientKt.DUMMY_URL);
            return error(responseBody, protocol.request(!(url instanceof Request.Builder) ? url.build() : OkHttp3Instrumentation.build(url)).build());
        }
        throw new IllegalArgumentException("code < 400: " + i11);
    }

    public static <T> Response<T> success(@Nullable T t11) {
        Response.Builder protocol = new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1);
        Request.Builder url = new Request.Builder().url(AnalyticsClientKt.DUMMY_URL);
        return success(t11, protocol.request(!(url instanceof Request.Builder) ? url.build() : OkHttp3Instrumentation.build(url)).build());
    }

    @Nullable
    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.code();
    }

    @Nullable
    public ResponseBody errorBody() {
        return this.errorBody;
    }

    public Headers headers() {
        return this.rawResponse.headers();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String message() {
        return this.rawResponse.message();
    }

    public okhttp3.Response raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(int i11, @Nullable T t11) {
        if (i11 < 200 || i11 >= 300) {
            throw new IllegalArgumentException("code < 200 or >= 300: " + i11);
        }
        Response.Builder protocol = new Response.Builder().code(i11).message("Response.success()").protocol(Protocol.HTTP_1_1);
        Request.Builder url = new Request.Builder().url(AnalyticsClientKt.DUMMY_URL);
        return success(t11, protocol.request(!(url instanceof Request.Builder) ? url.build() : OkHttp3Instrumentation.build(url)).build());
    }

    public static <T> Response<T> error(ResponseBody responseBody, okhttp3.Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new Response<>(response, (Object) null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(@Nullable T t11, Headers headers) {
        Objects.requireNonNull(headers, "headers == null");
        Response.Builder headers2 = new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers);
        Request.Builder url = new Request.Builder().url(AnalyticsClientKt.DUMMY_URL);
        return success(t11, headers2.request(!(url instanceof Request.Builder) ? url.build() : OkHttp3Instrumentation.build(url)).build());
    }

    public static <T> Response<T> success(@Nullable T t11, okhttp3.Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new Response<>(response, t11, (ResponseBody) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
