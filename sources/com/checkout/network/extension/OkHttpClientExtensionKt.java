package com.checkout.network.extension;

import com.checkout.base.error.CheckoutError;
import com.checkout.network.error.NetworkError;
import com.checkout.network.response.ErrorResponse;
import com.checkout.network.response.NetworkApiResponse;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.squareup.moshi.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

@Instrumented
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u001a1\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005H\b\u001aC\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b¨\u0006\u0011"}, d2 = {"provideErrorResult", "Lcom/checkout/network/response/NetworkApiResponse$ServerError;", "result", "Lokhttp3/Response;", "errorAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/checkout/network/response/ErrorResponse;", "provideSuccessResult", "Lcom/checkout/network/response/NetworkApiResponse;", "S", "", "adapter", "executeHttpRequest", "Lokhttp3/OkHttpClient;", "request", "Lokhttp3/Request;", "successAdapter", "checkout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class OkHttpClientExtensionKt {
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r6, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0076, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <S> com.checkout.network.response.NetworkApiResponse<S> executeHttpRequest(okhttp3.OkHttpClient r6, okhttp3.Request r7, com.squareup.moshi.JsonAdapter<S> r8, com.squareup.moshi.JsonAdapter<com.checkout.network.response.ErrorResponse> r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "successAdapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "errorAdapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r6 instanceof okhttp3.OkHttpClient     // Catch:{ all -> 0x0077 }
            if (r0 != 0) goto L_0x001d
            okhttp3.Call r6 = r6.newCall(r7)     // Catch:{ all -> 0x0077 }
            goto L_0x0021
        L_0x001d:
            okhttp3.Call r6 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newCall(r6, r7)     // Catch:{ all -> 0x0077 }
        L_0x0021:
            okhttp3.Response r6 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r6)     // Catch:{ all -> 0x0077 }
            r7 = 1
            boolean r0 = r6.isSuccessful()     // Catch:{ all -> 0x006a }
            r1 = 0
            if (r0 == 0) goto L_0x005c
            okhttp3.ResponseBody r9 = r6.body()     // Catch:{ all -> 0x006a }
            if (r9 == 0) goto L_0x004e
            okio.BufferedSource r9 = r9.source()     // Catch:{ all -> 0x006a }
            if (r9 == 0) goto L_0x004e
            java.lang.Object r8 = r8.fromJson((okio.BufferedSource) r9)     // Catch:{ all -> 0x006a }
            if (r8 == 0) goto L_0x004a
            com.checkout.network.response.NetworkApiResponse$Success r9 = new com.checkout.network.response.NetworkApiResponse$Success     // Catch:{ all -> 0x006a }
            java.lang.String r0 = "successResponse"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)     // Catch:{ all -> 0x006a }
            r9.<init>(r8)     // Catch:{ all -> 0x006a }
            goto L_0x004b
        L_0x004a:
            r9 = r1
        L_0x004b:
            if (r9 == 0) goto L_0x004e
            goto L_0x0060
        L_0x004e:
            com.checkout.base.error.CheckoutError r8 = new com.checkout.base.error.CheckoutError     // Catch:{ all -> 0x006a }
            java.lang.String r1 = "NetworkError:2007"
            java.lang.String r2 = "Success response is null, can not be parsed"
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x006a }
            throw r8     // Catch:{ all -> 0x006a }
        L_0x005c:
            com.checkout.network.response.NetworkApiResponse$ServerError r9 = provideErrorResult(r6, r9)     // Catch:{ all -> 0x006a }
        L_0x0060:
            kotlin.jvm.internal.InlineMarker.finallyStart(r7)     // Catch:{ all -> 0x0077 }
            kotlin.io.CloseableKt.closeFinally(r6, r1)     // Catch:{ all -> 0x0077 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r7)     // Catch:{ all -> 0x0077 }
            goto L_0x007d
        L_0x006a:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x006c }
        L_0x006c:
            r9 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r7)     // Catch:{ all -> 0x0077 }
            kotlin.io.CloseableKt.closeFinally(r6, r8)     // Catch:{ all -> 0x0077 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r7)     // Catch:{ all -> 0x0077 }
            throw r9     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r6 = move-exception
            com.checkout.network.response.NetworkApiResponse$NetworkError r9 = new com.checkout.network.response.NetworkApiResponse$NetworkError
            r9.<init>(r6)
        L_0x007d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.network.extension.OkHttpClientExtensionKt.executeHttpRequest(okhttp3.OkHttpClient, okhttp3.Request, com.squareup.moshi.JsonAdapter, com.squareup.moshi.JsonAdapter):com.checkout.network.response.NetworkApiResponse");
    }

    /* access modifiers changed from: private */
    public static final NetworkApiResponse.ServerError provideErrorResult(Response response, JsonAdapter<ErrorResponse> jsonAdapter) {
        ErrorResponse errorResponse;
        BufferedSource source;
        ResponseBody body = response.body();
        if (body == null || (source = body.source()) == null) {
            errorResponse = null;
        } else {
            errorResponse = jsonAdapter.fromJson(source);
        }
        return new NetworkApiResponse.ServerError(errorResponse, response.code());
    }

    private static final /* synthetic */ <S> NetworkApiResponse<S> provideSuccessResult(Response response, JsonAdapter<S> jsonAdapter) throws CheckoutError {
        BufferedSource source;
        NetworkApiResponse.Success success;
        ResponseBody body = response.body();
        if (!(body == null || (source = body.source()) == null)) {
            S fromJson = jsonAdapter.fromJson(source);
            if (fromJson != null) {
                Intrinsics.checkNotNullExpressionValue(fromJson, "successResponse");
                success = new NetworkApiResponse.Success(fromJson);
            } else {
                success = null;
            }
            if (success != null) {
                return success;
            }
        }
        throw new CheckoutError(NetworkError.RESPONSE_PARSING_ERROR, "Success response is null, can not be parsed", (Throwable) null, 4, (DefaultConstructorMarker) null);
    }
}
