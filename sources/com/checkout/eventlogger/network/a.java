package com.checkout.eventlogger.network;

import com.checkout.eventlogger.network.b.b;
import com.newrelic.agent.android.instrumentation.Instrumented;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Instrumented
public final class a implements com.checkout.eventlogger.network.b.a {

    /* renamed from: c  reason: collision with root package name */
    public static final MediaType f44255c = MediaType.Companion.get("application/cloudevents+json; charset=utf-8");
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final C0045a f44256d = new C0045a();

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f44257a = LazyKt__LazyJVMKt.lazy(b.f44259a);

    /* renamed from: b  reason: collision with root package name */
    public final String f44258b;

    /* renamed from: com.checkout.eventlogger.network.a$a  reason: collision with other inner class name */
    public static final class C0045a {
    }

    public static final class b extends Lambda implements Function0<OkHttpClient> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f44259a = new b();

        public b() {
            super(0);
        }

        public Object invoke() {
            MediaType mediaType = a.f44255c;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.retryOnConnectionFailure(true);
            Intrinsics.checkNotNullParameter(builder, "$this$addLocalInterceptors");
            return builder.build();
        }
    }

    public static final class c extends Lambda implements Function1<Response, com.checkout.eventlogger.network.b.b<Unit>> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f44260a = new c();

        public c() {
            super(1);
        }

        public Object invoke(Object obj) {
            Intrinsics.checkNotNullParameter((Response) obj, "it");
            return new b.c(Unit.INSTANCE);
        }
    }

    public a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.f44258b = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.checkout.eventlogger.network.b.b<kotlin.Unit> a(@org.jetbrains.annotations.NotNull java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "jsonPayload"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            okhttp3.RequestBody$Companion r0 = okhttp3.RequestBody.Companion
            okhttp3.MediaType r1 = f44255c
            okhttp3.RequestBody r4 = r0.create((java.lang.String) r4, (okhttp3.MediaType) r1)
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder
            r0.<init>()
            java.lang.String r1 = r3.f44258b
            okhttp3.Request$Builder r0 = r0.url((java.lang.String) r1)
            okhttp3.Request$Builder r4 = r0.post(r4)
            boolean r0 = r4 instanceof okhttp3.Request.Builder
            if (r0 != 0) goto L_0x0025
            okhttp3.Request r4 = r4.build()
            goto L_0x0029
        L_0x0025:
            okhttp3.Request r4 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.build(r4)
        L_0x0029:
            com.checkout.eventlogger.network.a$c r0 = com.checkout.eventlogger.network.a.c.f44260a
            kotlin.Lazy r1 = r3.f44257a     // Catch:{ all -> 0x0071 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0071 }
            okhttp3.OkHttpClient r1 = (okhttp3.OkHttpClient) r1     // Catch:{ all -> 0x0071 }
            boolean r2 = r1 instanceof okhttp3.OkHttpClient     // Catch:{ all -> 0x0071 }
            if (r2 != 0) goto L_0x003c
            okhttp3.Call r4 = r1.newCall(r4)     // Catch:{ all -> 0x0071 }
            goto L_0x0040
        L_0x003c:
            okhttp3.Call r4 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newCall(r1, r4)     // Catch:{ all -> 0x0071 }
        L_0x0040:
            okhttp3.Response r4 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r4)     // Catch:{ all -> 0x0071 }
            boolean r1 = r4.isSuccessful()     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0051
            java.lang.Object r0 = r0.invoke(r4)     // Catch:{ all -> 0x006a }
            com.checkout.eventlogger.network.b.b r0 = (com.checkout.eventlogger.network.b.b) r0     // Catch:{ all -> 0x006a }
            goto L_0x0065
        L_0x0051:
            com.checkout.eventlogger.network.b.b$b r0 = new com.checkout.eventlogger.network.b.b$b     // Catch:{ all -> 0x006a }
            okhttp3.ResponseBody r1 = r4.body()     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = r1.string()     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            java.lang.String r1 = "unknown failure"
        L_0x0062:
            r0.<init>(r1)     // Catch:{ all -> 0x006a }
        L_0x0065:
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r1)     // Catch:{ all -> 0x0071 }
            goto L_0x0077
        L_0x006a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x006c }
        L_0x006c:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ all -> 0x0071 }
            throw r1     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r4 = move-exception
            com.checkout.eventlogger.network.b.b$a r0 = new com.checkout.eventlogger.network.b.b$a
            r0.<init>(r4)
        L_0x0077:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.eventlogger.network.a.a(java.lang.String):com.checkout.eventlogger.network.b.b");
    }
}
