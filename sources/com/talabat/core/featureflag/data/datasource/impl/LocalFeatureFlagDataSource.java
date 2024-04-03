package com.talabat.core.featureflag.data.datasource.impl;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.featureflag.data.datasource.IFeatureFlagDataSource;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016J)\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J4\u0010\u0010\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0015H\u0016J\u0014\u0010\u0016\u001a\u00020\t*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0002R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\bj\u0002`\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/core/featureflag/data/datasource/impl/LocalFeatureFlagDataSource;", "Lcom/talabat/core/featureflag/data/datasource/IFeatureFlagDataSource;", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "talabatFeatureFlags", "Ljava/util/HashMap;", "", "", "Lcom/talabat/core/featureflag/data/datasource/impl/TalabatFeatureFlags;", "getEnabledFeatureFlagValue", "fwfKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "getFeatureFlag", "forceRequest", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "readAssetsFile", "Landroid/content/res/AssetManager;", "fileName", "Companion", "com_talabat_core_feature-flag_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocalFeatureFlagDataSource implements IFeatureFlagDataSource {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String LOCAL_FEATURES_FILE = "talabat_feature_flags.json";
    @NotNull
    private final HashMap<String, HashMap<String, Boolean>> talabatFeatureFlags;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/featureflag/data/datasource/impl/LocalFeatureFlagDataSource$Companion;", "", "()V", "LOCAL_FEATURES_FILE", "", "com_talabat_core_feature-flag_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public LocalFeatureFlagDataSource(@NotNull @ApplicationContext Context context, @NotNull Gson gson) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gson, "gson");
        AssetManager assets = context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        String readAssetsFile = readAssetsFile(assets, LOCAL_FEATURES_FILE);
        Type type = new TypeToken<HashMap<String, HashMap<String, Boolean>>>() {
        }.getType();
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(readAssetsFile, type);
        } else {
            obj = GsonInstrumentation.fromJson(gson, readAssetsFile, type);
        }
        Intrinsics.checkNotNullExpressionValue(obj, "gson.fromJson(\n         …lags>() {}.type\n        )");
        this.talabatFeatureFlags = (HashMap) obj;
    }

    private final boolean getEnabledFeatureFlagValue(FWFKey fWFKey, boolean z11) throws NoSuchElementException {
        HashMap hashMap = this.talabatFeatureFlags.get(fWFKey.getValue());
        if (hashMap != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (((Boolean) entry.getValue()).booleanValue()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            List list = MapsKt___MapsKt.toList(linkedHashMap);
            if (list != null) {
                Iterable<Pair> iterable = list;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (Pair component1 : iterable) {
                    arrayList.add((String) component1.component1());
                }
                String str = (String) CollectionsKt___CollectionsKt.first(arrayList);
                if (str != null) {
                    z11 = Boolean.parseBoolean(str);
                }
            }
        }
        String value = fWFKey.getValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getFeatureFlag() called with: flagName = ");
        sb2.append(value);
        sb2.append(", value = ");
        sb2.append(z11);
        return z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String readAssetsFile(android.content.res.AssetManager r2, java.lang.String r3) {
        /*
            r1 = this;
            java.io.InputStream r2 = r2.open(r3)
            java.lang.String r3 = "open(fileName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r2, r3)
            boolean r2 = r0 instanceof java.io.BufferedReader
            if (r2 == 0) goto L_0x0017
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x001f
        L_0x0017:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r3 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r0, r3)
            r0 = r2
        L_0x001f:
            java.lang.String r2 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0028 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            return r2
        L_0x0028:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x002a }
        L_0x002a:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.featureflag.data.datasource.impl.LocalFeatureFlagDataSource.readAssetsFile(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }

    @Nullable
    public Object getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation) throws NoSuchElementException {
        return Boxing.boxBoolean(getEnabledFeatureFlagValue(fWFKey, z11));
    }

    public void getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1) throws NoSuchElementException {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Intrinsics.checkNotNullParameter(function1, "callback");
        function1.invoke(Boolean.valueOf(getEnabledFeatureFlagValue(fWFKey, z11)));
    }

    public boolean getFeatureFlag(@NotNull FWFKey fWFKey, boolean z11) throws NoSuchElementException {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        return getEnabledFeatureFlagValue(fWFKey, z11);
    }
}
