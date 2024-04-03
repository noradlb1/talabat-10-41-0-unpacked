package com.huawei.agconnect.https;

import com.huawei.agconnect.https.Adapter;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.RequestBody;

public abstract class Method<HttpsRequest> {
    HttpsRequest httpsRequest;

    public static class Get<HttpsRequest> extends Method {
        public Get(HttpsRequest httpsrequest) {
            this.httpsRequest = httpsrequest;
        }

        public Request.Builder create() {
            return f.a(this.httpsRequest).a();
        }
    }

    public static class Post<HttpsRequest> extends Method {
        Adapter.Factory factory;

        public Post(HttpsRequest httpsrequest, Adapter.Factory factory2) {
            init(httpsrequest, factory2);
        }

        private void init(HttpsRequest httpsrequest, Adapter.Factory factory2) {
            this.httpsRequest = httpsrequest;
            this.factory = factory2;
        }

        public Request.Builder create() {
            Request.Builder a11 = f.a(this.httpsRequest).a();
            try {
                if (this.factory.requestBodyAdapter() != null) {
                    return createBody(a11, (RequestBody) this.factory.requestBodyAdapter().adapter(this.httpsRequest));
                }
                throw new IllegalArgumentException("RequestBodyAdapter should not be null.");
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }

        public Request.Builder createBody(Request.Builder builder, RequestBody requestBody) {
            builder.post(requestBody);
            return builder;
        }
    }

    public static class Put<HttpsRequest> extends Post {
        public Put(HttpsRequest httpsrequest, Adapter.Factory factory) {
            super(httpsrequest, factory);
        }

        public Request.Builder createBody(Request.Builder builder, RequestBody requestBody) {
            builder.put(requestBody);
            return builder;
        }
    }

    public static final class a<HttpsRequest> extends Method {

        /* renamed from: a  reason: collision with root package name */
        Adapter.Factory f47623a;

        public a(HttpsRequest httpsrequest) {
            this.httpsRequest = httpsrequest;
        }

        public a(HttpsRequest httpsrequest, Adapter.Factory factory) {
            this.httpsRequest = httpsrequest;
            this.f47623a = factory;
        }

        public Request.Builder create() {
            Request.Builder a11 = f.a(this.httpsRequest).a();
            Adapter.Factory factory = this.f47623a;
            if (factory == null || factory.requestBodyAdapter() == null) {
                a11.delete();
            } else {
                try {
                    a11.delete((RequestBody) this.f47623a.requestBodyAdapter().adapter(this.httpsRequest));
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
            return a11;
        }
    }

    public abstract Request.Builder create();
}
