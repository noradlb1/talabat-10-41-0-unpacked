package com.checkout.network.extension;

import com.checkout.network.utils.OkHttpConstants;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import j4.a;
import j4.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\b\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\n*\u00020\nH\u0000\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\f"}, d2 = {"buildConnectionSpecs", "", "Lokhttp3/ConnectionSpec;", "createNetworkApiRequestInterceptor", "Lokhttp3/Interceptor;", "publicKey", "", "httpLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "addLocalInterceptors", "Lokhttp3/OkHttpClient$Builder;", "addRequestInterceptors", "checkout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class OkHttpProviderExtensionKt {
    @NotNull
    public static final OkHttpClient.Builder addLocalInterceptors(@NotNull OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder;
    }

    @NotNull
    public static final OkHttpClient.Builder addRequestInterceptors(@NotNull OkHttpClient.Builder builder, @NotNull String str) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "publicKey");
        return builder.addInterceptor(createNetworkApiRequestInterceptor(str));
    }

    @NotNull
    public static final List<ConnectionSpec> buildConnectionSpecs() {
        return CollectionsKt__CollectionsKt.listOf(ConnectionSpec.RESTRICTED_TLS, ConnectionSpec.CLEARTEXT);
    }

    private static final Interceptor createNetworkApiRequestInterceptor(String str) {
        return new a(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: createNetworkApiRequestInterceptor$lambda-1  reason: not valid java name */
    public static final Response m9336createNetworkApiRequestInterceptor$lambda1(String str, Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(str, "$publicKey");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder newBuilder = chain.request().newBuilder();
        newBuilder.addHeader("Authorization", str);
        newBuilder.addHeader("User-Agent", OkHttpConstants.HEADER_USER_AGENT_VALUE);
        return chain.proceed(OkHttp3Instrumentation.build(newBuilder));
    }

    private static final HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new b());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    /* access modifiers changed from: private */
    /* renamed from: httpLoggingInterceptor$lambda-2  reason: not valid java name */
    public static final void m9337httpLoggingInterceptor$lambda2(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
