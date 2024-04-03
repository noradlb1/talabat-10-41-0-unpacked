package coil.fetch;

import android.webkit.MimeTypeMap;
import androidx.annotation.VisibleForTesting;
import coil.bitmap.BitmapPool;
import coil.decode.Options;
import coil.fetch.Fetcher;
import coil.size.Size;
import coil.util.Extensions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.pool.TypePool;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000 \u0019*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0019B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J1\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\b\u0016J\u0011\u0010\u0017\u001a\u00020\u0013*\u00028\u0000H&¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcoil/fetch/HttpFetcher;", "T", "", "Lcoil/fetch/Fetcher;", "callFactory", "Lokhttp3/Call$Factory;", "(Lokhttp3/Call$Factory;)V", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Ljava/lang/Object;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "", "Lokhttp3/HttpUrl;", "body", "Lokhttp3/ResponseBody;", "getMimeType$coil_base_release", "toHttpUrl", "(Ljava/lang/Object;)Lokhttp3/HttpUrl;", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class HttpFetcher<T> implements Fetcher<T> {
    private static final CacheControl CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().noStore().build();
    private static final CacheControl CACHE_CONTROL_NO_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().onlyIfCached().build();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String MIME_TYPE_TEXT_PLAIN = "text/plain";
    @NotNull
    private final Call.Factory callFactory;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcoil/fetch/HttpFetcher$Companion;", "", "()V", "CACHE_CONTROL_FORCE_NETWORK_NO_CACHE", "Lokhttp3/CacheControl;", "kotlin.jvm.PlatformType", "CACHE_CONTROL_NO_NETWORK_NO_CACHE", "MIME_TYPE_TEXT_PLAIN", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HttpFetcher(@NotNull Call.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "callFactory");
        this.callFactory = factory;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object a(coil.fetch.HttpFetcher r3, coil.bitmap.BitmapPool r4, java.lang.Object r5, coil.size.Size r6, coil.decode.Options r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r4 = r8 instanceof coil.fetch.HttpFetcher$fetch$1
            if (r4 == 0) goto L_0x0013
            r4 = r8
            coil.fetch.HttpFetcher$fetch$1 r4 = (coil.fetch.HttpFetcher$fetch$1) r4
            int r6 = r4.f39717m
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r6 & r0
            if (r1 == 0) goto L_0x0013
            int r6 = r6 - r0
            r4.f39717m = r6
            goto L_0x0018
        L_0x0013:
            coil.fetch.HttpFetcher$fetch$1 r4 = new coil.fetch.HttpFetcher$fetch$1
            r4.<init>(r3, r8)
        L_0x0018:
            java.lang.Object r6 = r4.f39715k
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r4.f39717m
            r1 = 1
            if (r0 == 0) goto L_0x0040
            if (r0 != r1) goto L_0x0038
            java.lang.Object r3 = r4.f39714j
            okhttp3.Call r3 = (okhttp3.Call) r3
            java.lang.Object r3 = r4.f39713i
            okhttp3.HttpUrl r3 = (okhttp3.HttpUrl) r3
            java.lang.Object r4 = r4.f39712h
            coil.fetch.HttpFetcher r4 = (coil.fetch.HttpFetcher) r4
            kotlin.ResultKt.throwOnFailure(r6)
            r5 = r3
            r3 = r4
            goto L_0x0120
        L_0x0038:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r6)
            okhttp3.HttpUrl r5 = r3.toHttpUrl(r5)
            okhttp3.Request$Builder r6 = new okhttp3.Request$Builder
            r6.<init>()
            okhttp3.Request$Builder r6 = r6.url((okhttp3.HttpUrl) r5)
            okhttp3.Headers r0 = r7.getHeaders()
            okhttp3.Request$Builder r6 = r6.headers(r0)
            coil.request.CachePolicy r0 = r7.getNetworkCachePolicy()
            boolean r0 = r0.getReadEnabled()
            coil.request.CachePolicy r2 = r7.getDiskCachePolicy()
            boolean r2 = r2.getReadEnabled()
            if (r0 != 0) goto L_0x0072
            if (r2 == 0) goto L_0x0072
            okhttp3.CacheControl r7 = okhttp3.CacheControl.FORCE_CACHE
            r6.cacheControl(r7)
            goto L_0x0095
        L_0x0072:
            if (r0 == 0) goto L_0x008c
            if (r2 != 0) goto L_0x008c
            coil.request.CachePolicy r7 = r7.getDiskCachePolicy()
            boolean r7 = r7.getWriteEnabled()
            if (r7 == 0) goto L_0x0086
            okhttp3.CacheControl r7 = okhttp3.CacheControl.FORCE_NETWORK
            r6.cacheControl(r7)
            goto L_0x0095
        L_0x0086:
            okhttp3.CacheControl r7 = CACHE_CONTROL_FORCE_NETWORK_NO_CACHE
            r6.cacheControl(r7)
            goto L_0x0095
        L_0x008c:
            if (r0 != 0) goto L_0x0095
            if (r2 != 0) goto L_0x0095
            okhttp3.CacheControl r7 = CACHE_CONTROL_NO_NETWORK_NO_CACHE
            r6.cacheControl(r7)
        L_0x0095:
            kotlin.coroutines.CoroutineContext r7 = r4.getContext()
            kotlinx.coroutines.CoroutineDispatcher$Key r2 = kotlinx.coroutines.CoroutineDispatcher.Key
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r2)
            boolean r7 = r7 instanceof kotlinx.coroutines.MainCoroutineDispatcher
            if (r7 == 0) goto L_0x00ce
            if (r0 != 0) goto L_0x00c8
            okhttp3.Call$Factory r4 = r3.callFactory
            boolean r7 = r6 instanceof okhttp3.Request.Builder
            if (r7 != 0) goto L_0x00b0
            okhttp3.Request r6 = r6.build()
            goto L_0x00b4
        L_0x00b0:
            okhttp3.Request r6 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.build(r6)
        L_0x00b4:
            boolean r7 = r4 instanceof okhttp3.OkHttpClient
            if (r7 != 0) goto L_0x00bd
            okhttp3.Call r4 = r4.newCall(r6)
            goto L_0x00c3
        L_0x00bd:
            okhttp3.OkHttpClient r4 = (okhttp3.OkHttpClient) r4
            okhttp3.Call r4 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newCall(r4, r6)
        L_0x00c3:
            okhttp3.Response r4 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r4)
            goto L_0x0123
        L_0x00c8:
            android.os.NetworkOnMainThreadException r3 = new android.os.NetworkOnMainThreadException
            r3.<init>()
            throw r3
        L_0x00ce:
            okhttp3.Call$Factory r7 = r3.callFactory
            boolean r0 = r6 instanceof okhttp3.Request.Builder
            if (r0 != 0) goto L_0x00d9
            okhttp3.Request r6 = r6.build()
            goto L_0x00dd
        L_0x00d9:
            okhttp3.Request r6 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.build(r6)
        L_0x00dd:
            boolean r0 = r7 instanceof okhttp3.OkHttpClient
            if (r0 != 0) goto L_0x00e6
            okhttp3.Call r6 = r7.newCall(r6)
            goto L_0x00ec
        L_0x00e6:
            okhttp3.OkHttpClient r7 = (okhttp3.OkHttpClient) r7
            okhttp3.Call r6 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newCall(r7, r6)
        L_0x00ec:
            java.lang.String r7 = "callFactory.newCall(request.build())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r4.f39712h = r3
            r4.f39713i = r5
            r4.f39714j = r6
            r4.f39717m = r1
            kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r4)
            r7.<init>(r0, r1)
            r7.initCancellability()
            coil.util.ContinuationCallback r0 = new coil.util.ContinuationCallback
            r0.<init>(r6, r7)
            com.google.firebase.perf.network.FirebasePerfOkHttpClient.enqueue(r6, r0)
            r7.invokeOnCancellation(r0)
            java.lang.Object r6 = r7.getResult()
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r6 != r7) goto L_0x011d
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r4)
        L_0x011d:
            if (r6 != r8) goto L_0x0120
            return r8
        L_0x0120:
            r4 = r6
            okhttp3.Response r4 = (okhttp3.Response) r4
        L_0x0123:
            boolean r6 = r4.isSuccessful()
            if (r6 != 0) goto L_0x013e
            okhttp3.ResponseBody r3 = r4.body()
            if (r3 != 0) goto L_0x0130
            goto L_0x0133
        L_0x0130:
            r3.close()
        L_0x0133:
            coil.network.HttpException r3 = new coil.network.HttpException
            java.lang.String r5 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r3.<init>(r4)
            throw r3
        L_0x013e:
            okhttp3.ResponseBody r6 = r4.body()
            if (r6 == 0) goto L_0x0162
            coil.fetch.SourceResult r7 = new coil.fetch.SourceResult
            okio.BufferedSource r8 = r6.source()
            java.lang.String r0 = "body.source()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            java.lang.String r3 = r3.getMimeType$coil_base_release(r5, r6)
            okhttp3.Response r4 = r4.cacheResponse()
            if (r4 == 0) goto L_0x015c
            coil.decode.DataSource r4 = coil.decode.DataSource.DISK
            goto L_0x015e
        L_0x015c:
            coil.decode.DataSource r4 = coil.decode.DataSource.NETWORK
        L_0x015e:
            r7.<init>(r8, r3, r4)
            return r7
        L_0x0162:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Null response body!"
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpFetcher.a(coil.fetch.HttpFetcher, coil.bitmap.BitmapPool, java.lang.Object, coil.size.Size, coil.decode.Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public Object fetch(@NotNull BitmapPool bitmapPool, @NotNull T t11, @NotNull Size size, @NotNull Options options, @NotNull Continuation<? super FetchResult> continuation) {
        return a(this, bitmapPool, t11, size, options, continuation);
    }

    @VisibleForTesting
    @Nullable
    public final String getMimeType$coil_base_release(@NotNull HttpUrl httpUrl, @NotNull ResponseBody responseBody) {
        String str;
        Intrinsics.checkNotNullParameter(httpUrl, "data");
        Intrinsics.checkNotNullParameter(responseBody, "body");
        MediaType contentType = responseBody.contentType();
        if (contentType == null) {
            str = null;
        } else {
            str = contentType.toString();
        }
        if (str == null || StringsKt__StringsJVMKt.startsWith$default(str, "text/plain", false, 2, (Object) null)) {
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            Intrinsics.checkNotNullExpressionValue(singleton, "getSingleton()");
            String mimeTypeFromUrl = Extensions.getMimeTypeFromUrl(singleton, httpUrl.toString());
            if (mimeTypeFromUrl != null) {
                return mimeTypeFromUrl;
            }
        }
        if (str == null) {
            return null;
        }
        return StringsKt__StringsKt.substringBefore$default(str, (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, (String) null, 2, (Object) null);
    }

    public boolean handles(@NotNull T t11) {
        return Fetcher.DefaultImpls.handles(this, t11);
    }

    @NotNull
    public abstract HttpUrl toHttpUrl(@NotNull T t11);
}
