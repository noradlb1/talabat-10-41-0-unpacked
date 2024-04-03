package com.adtechsdk.dh_adtech_sdk_flutter.viewability.data;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/OmJsSdkDataSource;", "", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "omidJsSdk", "", "semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "getOmidJsSdk", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadOmidJsSdk", "loadOmidSdkFromFile", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OmJsSdkDataSource {
    @NotNull
    private final CoroutineDispatcher ioDispatcher;
    /* access modifiers changed from: private */
    @Nullable
    public String omidJsSdk;
    /* access modifiers changed from: private */
    @NotNull
    public final Semaphore semaphore = SemaphoreKt.Semaphore$default(1, 0, 2, (Object) null);

    public OmJsSdkDataSource(@NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.ioDispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    public final Object loadOmidJsSdk(Context context, Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new OmJsSdkDataSource$loadOmidJsSdk$2(this, context, (Continuation<? super OmJsSdkDataSource$loadOmidJsSdk$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String loadOmidSdkFromFile(android.content.Context r4) {
        /*
            r3 = this;
            android.content.res.Resources r4 = r4.getResources()
            int r0 = com.adtechsdk.dh_adtech_sdk_flutter.R.raw.omsdk_v1
            java.io.InputStream r4 = r4.openRawResource(r0)
            java.lang.String r0 = "inputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch:{ all -> 0x003a }
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x003a }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x003a }
            r1.<init>(r4, r0)     // Catch:{ all -> 0x003a }
            boolean r0 = r1 instanceof java.io.BufferedReader     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x001d
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1     // Catch:{ all -> 0x003a }
            goto L_0x0025
        L_0x001d:
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x003a }
            r2 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r1, r2)     // Catch:{ all -> 0x003a }
            r1 = r0
        L_0x0025:
            java.lang.String r0 = kotlin.io.TextStreamsKt.readText(r1)     // Catch:{ all -> 0x0033 }
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ all -> 0x003a }
            kotlin.io.CloseableKt.closeFinally(r4, r2)
            r3.omidJsSdk = r0
            return r0
        L_0x0033:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ all -> 0x003a }
            throw r2     // Catch:{ all -> 0x003a }
        L_0x003a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adtechsdk.dh_adtech_sdk_flutter.viewability.data.OmJsSdkDataSource.loadOmidSdkFromFile(android.content.Context):java.lang.String");
    }

    @Nullable
    public final Object getOmidJsSdk(@NotNull Context context, @NotNull Continuation<? super String> continuation) {
        String str = this.omidJsSdk;
        return str == null ? loadOmidJsSdk(context, continuation) : str;
    }
}
