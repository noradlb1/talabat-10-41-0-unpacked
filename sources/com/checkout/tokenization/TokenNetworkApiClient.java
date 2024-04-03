package com.checkout.tokenization;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/checkout/tokenization/TokenNetworkApiClient;", "Lcom/checkout/tokenization/NetworkApiClient;", "url", "", "okHttpClient", "Lokhttp3/OkHttpClient;", "moshiClient", "Lcom/squareup/moshi/Moshi;", "(Ljava/lang/String;Lokhttp3/OkHttpClient;Lcom/squareup/moshi/Moshi;)V", "sendCardTokenRequest", "Lcom/checkout/network/response/NetworkApiResponse;", "Lcom/checkout/tokenization/response/TokenDetailsResponse;", "cardTokenRequest", "Lcom/checkout/tokenization/request/TokenRequest;", "(Lcom/checkout/tokenization/request/TokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendGooglePayTokenRequest", "googlePayTokenNetworkRequest", "Lcom/checkout/tokenization/request/GooglePayTokenNetworkRequest;", "(Lcom/checkout/tokenization/request/GooglePayTokenNetworkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TokenNetworkApiClient implements NetworkApiClient {
    @NotNull
    private final Moshi moshiClient;
    @NotNull
    private final OkHttpClient okHttpClient;
    @NotNull
    private final String url;

    public TokenNetworkApiClient(@NotNull String str, @NotNull OkHttpClient okHttpClient2, @NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(okHttpClient2, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshi, "moshiClient");
        this.url = str;
        this.okHttpClient = okHttpClient2;
        this.moshiClient = moshi;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sendCardTokenRequest(@org.jetbrains.annotations.NotNull com.checkout.tokenization.request.TokenRequest r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.checkout.network.response.NetworkApiResponse<com.checkout.tokenization.response.TokenDetailsResponse>> r8) {
        /*
            r6 = this;
            com.squareup.moshi.Moshi r8 = r6.moshiClient
            java.lang.Class<com.checkout.tokenization.request.TokenRequest> r0 = com.checkout.tokenization.request.TokenRequest.class
            com.squareup.moshi.JsonAdapter r8 = r8.adapter(r0)
            okhttp3.RequestBody$Companion r0 = okhttp3.RequestBody.Companion
            java.lang.String r7 = r8.toJson(r7)
            java.lang.String r8 = "jsonTokenRequestAdapter.toJson(cardTokenRequest)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            com.checkout.tokenization.utils.TokenizationConstants r8 = com.checkout.tokenization.utils.TokenizationConstants.INSTANCE
            okhttp3.MediaType r8 = r8.getJsonMediaType()
            okhttp3.RequestBody r7 = r0.create((java.lang.String) r7, (okhttp3.MediaType) r8)
            okhttp3.Request$Builder r8 = new okhttp3.Request$Builder
            r8.<init>()
            java.lang.String r0 = r6.url
            okhttp3.Request$Builder r8 = r8.url((java.lang.String) r0)
            okhttp3.Request$Builder r7 = r8.post(r7)
            boolean r8 = r7 instanceof okhttp3.Request.Builder
            if (r8 != 0) goto L_0x0035
            okhttp3.Request r7 = r7.build()
            goto L_0x0039
        L_0x0035:
            okhttp3.Request r7 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.build(r7)
        L_0x0039:
            okhttp3.OkHttpClient r8 = r6.okHttpClient
            com.squareup.moshi.Moshi r0 = r6.moshiClient
            java.lang.Class<com.checkout.tokenization.response.TokenDetailsResponse> r1 = com.checkout.tokenization.response.TokenDetailsResponse.class
            com.squareup.moshi.JsonAdapter r0 = r0.adapter(r1)
            java.lang.String r1 = "moshiClient.adapter(Toke…ailsResponse::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.squareup.moshi.Moshi r1 = r6.moshiClient
            java.lang.Class<com.checkout.network.response.ErrorResponse> r2 = com.checkout.network.response.ErrorResponse.class
            com.squareup.moshi.JsonAdapter r1 = r1.adapter(r2)
            java.lang.String r2 = "moshiClient.adapter(ErrorResponse::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r2 = r8 instanceof okhttp3.OkHttpClient     // Catch:{ all -> 0x00ab }
            if (r2 != 0) goto L_0x005e
            okhttp3.Call r7 = r8.newCall(r7)     // Catch:{ all -> 0x00ab }
            goto L_0x0062
        L_0x005e:
            okhttp3.Call r7 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newCall(r8, r7)     // Catch:{ all -> 0x00ab }
        L_0x0062:
            okhttp3.Response r7 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r7)     // Catch:{ all -> 0x00ab }
            boolean r8 = r7.isSuccessful()     // Catch:{ all -> 0x00a4 }
            r2 = 0
            if (r8 == 0) goto L_0x009c
            okhttp3.ResponseBody r8 = r7.body()     // Catch:{ all -> 0x00a4 }
            if (r8 == 0) goto L_0x008e
            okio.BufferedSource r8 = r8.source()     // Catch:{ all -> 0x00a4 }
            if (r8 == 0) goto L_0x008e
            java.lang.Object r8 = r0.fromJson((okio.BufferedSource) r8)     // Catch:{ all -> 0x00a4 }
            if (r8 == 0) goto L_0x008a
            com.checkout.network.response.NetworkApiResponse$Success r0 = new com.checkout.network.response.NetworkApiResponse$Success     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = "successResponse"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)     // Catch:{ all -> 0x00a4 }
            r0.<init>(r8)     // Catch:{ all -> 0x00a4 }
            goto L_0x008b
        L_0x008a:
            r0 = r2
        L_0x008b:
            if (r0 == 0) goto L_0x008e
            goto L_0x00a0
        L_0x008e:
            com.checkout.base.error.CheckoutError r8 = new com.checkout.base.error.CheckoutError     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = "NetworkError:2007"
            java.lang.String r2 = "Success response is null, can not be parsed"
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a4 }
            throw r8     // Catch:{ all -> 0x00a4 }
        L_0x009c:
            com.checkout.network.response.NetworkApiResponse$ServerError r0 = com.checkout.network.extension.OkHttpClientExtensionKt.provideErrorResult(r7, r1)     // Catch:{ all -> 0x00a4 }
        L_0x00a0:
            kotlin.io.CloseableKt.closeFinally(r7, r2)     // Catch:{ all -> 0x00ab }
            goto L_0x00b1
        L_0x00a4:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r8)     // Catch:{ all -> 0x00ab }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r7 = move-exception
            com.checkout.network.response.NetworkApiResponse$NetworkError r0 = new com.checkout.network.response.NetworkApiResponse$NetworkError
            r0.<init>(r7)
        L_0x00b1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.tokenization.TokenNetworkApiClient.sendCardTokenRequest(com.checkout.tokenization.request.TokenRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sendGooglePayTokenRequest(@org.jetbrains.annotations.NotNull com.checkout.tokenization.request.GooglePayTokenNetworkRequest r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.checkout.network.response.NetworkApiResponse<com.checkout.tokenization.response.TokenDetailsResponse>> r8) {
        /*
            r6 = this;
            com.squareup.moshi.Moshi r8 = r6.moshiClient
            java.lang.Class<com.checkout.tokenization.request.GooglePayTokenNetworkRequest> r0 = com.checkout.tokenization.request.GooglePayTokenNetworkRequest.class
            com.squareup.moshi.JsonAdapter r8 = r8.adapter(r0)
            okhttp3.RequestBody$Companion r0 = okhttp3.RequestBody.Companion
            java.lang.String r7 = r8.toJson(r7)
            java.lang.String r8 = "jsonGooglePayTokenReques…workRequest\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            com.checkout.tokenization.utils.TokenizationConstants r8 = com.checkout.tokenization.utils.TokenizationConstants.INSTANCE
            okhttp3.MediaType r8 = r8.getJsonMediaType()
            okhttp3.RequestBody r7 = r0.create((java.lang.String) r7, (okhttp3.MediaType) r8)
            okhttp3.Request$Builder r8 = new okhttp3.Request$Builder
            r8.<init>()
            java.lang.String r0 = r6.url
            okhttp3.Request$Builder r8 = r8.url((java.lang.String) r0)
            okhttp3.Request$Builder r7 = r8.post(r7)
            boolean r8 = r7 instanceof okhttp3.Request.Builder
            if (r8 != 0) goto L_0x0035
            okhttp3.Request r7 = r7.build()
            goto L_0x0039
        L_0x0035:
            okhttp3.Request r7 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.build(r7)
        L_0x0039:
            okhttp3.OkHttpClient r8 = r6.okHttpClient
            com.squareup.moshi.Moshi r0 = r6.moshiClient
            java.lang.Class<com.checkout.tokenization.response.TokenDetailsResponse> r1 = com.checkout.tokenization.response.TokenDetailsResponse.class
            com.squareup.moshi.JsonAdapter r0 = r0.adapter(r1)
            java.lang.String r1 = "moshiClient.adapter(Toke…ailsResponse::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.squareup.moshi.Moshi r1 = r6.moshiClient
            java.lang.Class<com.checkout.network.response.ErrorResponse> r2 = com.checkout.network.response.ErrorResponse.class
            com.squareup.moshi.JsonAdapter r1 = r1.adapter(r2)
            java.lang.String r2 = "moshiClient.adapter(ErrorResponse::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r2 = r8 instanceof okhttp3.OkHttpClient     // Catch:{ all -> 0x00ab }
            if (r2 != 0) goto L_0x005e
            okhttp3.Call r7 = r8.newCall(r7)     // Catch:{ all -> 0x00ab }
            goto L_0x0062
        L_0x005e:
            okhttp3.Call r7 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newCall(r8, r7)     // Catch:{ all -> 0x00ab }
        L_0x0062:
            okhttp3.Response r7 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r7)     // Catch:{ all -> 0x00ab }
            boolean r8 = r7.isSuccessful()     // Catch:{ all -> 0x00a4 }
            r2 = 0
            if (r8 == 0) goto L_0x009c
            okhttp3.ResponseBody r8 = r7.body()     // Catch:{ all -> 0x00a4 }
            if (r8 == 0) goto L_0x008e
            okio.BufferedSource r8 = r8.source()     // Catch:{ all -> 0x00a4 }
            if (r8 == 0) goto L_0x008e
            java.lang.Object r8 = r0.fromJson((okio.BufferedSource) r8)     // Catch:{ all -> 0x00a4 }
            if (r8 == 0) goto L_0x008a
            com.checkout.network.response.NetworkApiResponse$Success r0 = new com.checkout.network.response.NetworkApiResponse$Success     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = "successResponse"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)     // Catch:{ all -> 0x00a4 }
            r0.<init>(r8)     // Catch:{ all -> 0x00a4 }
            goto L_0x008b
        L_0x008a:
            r0 = r2
        L_0x008b:
            if (r0 == 0) goto L_0x008e
            goto L_0x00a0
        L_0x008e:
            com.checkout.base.error.CheckoutError r8 = new com.checkout.base.error.CheckoutError     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = "NetworkError:2007"
            java.lang.String r2 = "Success response is null, can not be parsed"
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a4 }
            throw r8     // Catch:{ all -> 0x00a4 }
        L_0x009c:
            com.checkout.network.response.NetworkApiResponse$ServerError r0 = com.checkout.network.extension.OkHttpClientExtensionKt.provideErrorResult(r7, r1)     // Catch:{ all -> 0x00a4 }
        L_0x00a0:
            kotlin.io.CloseableKt.closeFinally(r7, r2)     // Catch:{ all -> 0x00ab }
            goto L_0x00b1
        L_0x00a4:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r8)     // Catch:{ all -> 0x00ab }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r7 = move-exception
            com.checkout.network.response.NetworkApiResponse$NetworkError r0 = new com.checkout.network.response.NetworkApiResponse$NetworkError
            r0.<init>(r7)
        L_0x00b1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.tokenization.TokenNetworkApiClient.sendGooglePayTokenRequest(com.checkout.tokenization.request.GooglePayTokenNetworkRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
