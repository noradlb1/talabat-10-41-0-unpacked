package com.talabat.fluid.homescreen.data.local.impl;

import android.content.Context;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.fluid.homescreen.data.local.FluidHomeComponentLocalDataSource;
import com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0002R\u001b\u0010\u0007\u001a\u00020\b8VX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\b8VX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/fluid/homescreen/data/local/impl/FluidHomeComponentLocalDataSourceImpl;", "Lcom/talabat/fluid/homescreen/data/local/FluidHomeComponentLocalDataSource;", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "arabicComponents", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse;", "getArabicComponents", "()Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse;", "arabicComponents$delegate", "Lkotlin/Lazy;", "englishComponents", "getEnglishComponents", "englishComponents$delegate", "readRawResourceAsJson", "resource", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeComponentLocalDataSourceImpl implements FluidHomeComponentLocalDataSource {
    @NotNull
    private final Lazy arabicComponents$delegate;
    @NotNull
    private final Context context;
    @NotNull
    private final Lazy englishComponents$delegate;
    @NotNull
    private final Gson gson;

    public FluidHomeComponentLocalDataSourceImpl(@NotNull Context context2, @NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.context = context2;
        this.gson = gson2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.englishComponents$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new FluidHomeComponentLocalDataSourceImpl$englishComponents$2(this));
        this.arabicComponents$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new FluidHomeComponentLocalDataSourceImpl$arabicComponents$2(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse readRawResourceAsJson(@androidx.annotation.RawRes int r4) {
        /*
            r3 = this;
            android.content.Context r0 = r3.context
            android.content.res.Resources r0 = r0.getResources()
            java.io.InputStream r4 = r0.openRawResource(r4)
            java.lang.String r0 = "context\n            .res…openRawResource(resource)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r4, r0)
            boolean r4 = r1 instanceof java.io.BufferedReader
            if (r4 == 0) goto L_0x001d
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1
            goto L_0x0025
        L_0x001d:
            java.io.BufferedReader r4 = new java.io.BufferedReader
            r0 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r1, r0)
            r1 = r4
        L_0x0025:
            java.lang.String r4 = kotlin.io.TextStreamsKt.readText(r1)     // Catch:{ all -> 0x0046 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            com.google.gson.Gson r0 = r3.gson
            boolean r1 = r0 instanceof com.google.gson.Gson
            java.lang.Class<com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse> r2 = com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse.class
            if (r1 != 0) goto L_0x003a
            java.lang.Object r4 = r0.fromJson((java.lang.String) r4, r2)
            goto L_0x003e
        L_0x003a:
            java.lang.Object r4 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r0, (java.lang.String) r4, r2)
        L_0x003e:
            com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse r4 = (com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse) r4
            java.lang.String r0 = "context\n            .res…piResponse::class.java) }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            return r4
        L_0x0046:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.local.impl.FluidHomeComponentLocalDataSourceImpl.readRawResourceAsJson(int):com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse");
    }

    @NotNull
    public ContentApiResponse getArabicComponents() {
        return (ContentApiResponse) this.arabicComponents$delegate.getValue();
    }

    @NotNull
    public ContentApiResponse getEnglishComponents() {
        return (ContentApiResponse) this.englishComponents$delegate.getValue();
    }
}
