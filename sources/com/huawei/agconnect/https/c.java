package com.huawei.agconnect.https;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import okio.Sink;

@Instrumented
class c implements Interceptor {

    public static class a extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        private final RequestBody f47645a;

        public a(RequestBody requestBody) {
            this.f47645a = requestBody;
        }

        public long contentLength() {
            return -1;
        }

        public MediaType contentType() {
            return MediaType.parse("application/x-gzip");
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            BufferedSink buffer = Okio.buffer((Sink) new GzipSink(bufferedSink));
            this.f47645a.writeTo(buffer);
            buffer.close();
        }
    }

    public static class b extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        RequestBody f47646a;

        /* renamed from: b  reason: collision with root package name */
        Buffer f47647b = null;

        public b(RequestBody requestBody) throws IOException {
            this.f47646a = requestBody;
            Buffer buffer = new Buffer();
            this.f47647b = buffer;
            requestBody.writeTo(buffer);
        }

        public long contentLength() {
            return this.f47647b.size();
        }

        public MediaType contentType() {
            return this.f47646a.contentType();
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.f47647b.snapshot());
        }
    }

    private RequestBody a(RequestBody requestBody) throws IOException {
        return new b(requestBody);
    }

    private RequestBody b(RequestBody requestBody) {
        return new a(requestBody);
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (request.body() == null || request.header("Content-Encoding") != null) {
            return chain.proceed(request);
        }
        Request.Builder method = request.newBuilder().header("Content-Encoding", Constants.Network.ContentType.GZIP).method(request.method(), a(b(request.body())));
        return chain.proceed(!(method instanceof Request.Builder) ? method.build() : OkHttp3Instrumentation.build(method));
    }
}
