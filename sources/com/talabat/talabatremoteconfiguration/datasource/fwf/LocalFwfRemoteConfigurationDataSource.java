package com.talabat.talabatremoteconfiguration.datasource.fwf;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J1\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u0002H\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0015H\u0002¢\u0006\u0002\u0010\u0016J1\u0010\u0017\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u0002H\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0015H\u0016¢\u0006\u0002\u0010\u0016J=\u0010\u0017\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJM\u0010\u0017\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00152\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u001b0\u001dH\u0016¢\u0006\u0002\u0010\u001eJ1\u0010\u001f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010 \u001a\u00020\r2\u0006\u0010\u0013\u001a\u0002H\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0015H\u0002¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020\u0005*\u00020#2\u0006\u0010$\u001a\u00020\u0005H\u0002J\f\u0010%\u001a\u00020\u0005*\u00020\rH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f0\fj\u0002`\u000eX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/datasource/fwf/LocalFwfRemoteConfigurationDataSource;", "Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "context", "Landroid/content/Context;", "sourceFile", "", "(Landroid/content/Context;Ljava/lang/String;)V", "gson", "Lcom/google/gson/Gson;", "parser", "Lcom/talabat/talabatremoteconfiguration/datasource/fwf/FwfRemoteConfigurationParser;", "talabatFeatureFlags", "Ljava/util/HashMap;", "", "Lcom/talabat/talabatremoteconfiguration/datasource/fwf/TalabatFeatureFlags;", "getEnabledFeatureFlagValue", "T", "fwfKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "classType", "Ljava/lang/Class;", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "getRemoteConfiguration", "forceRequest", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;ZLjava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;ZLjava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "getVariationValue", "variation", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "readAssetsFile", "Landroid/content/res/AssetManager;", "fileName", "toStringValue", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LocalFwfRemoteConfigurationDataSource implements IRemoteConfigurationDataSource {
    @NotNull
    private final Gson gson;
    @NotNull
    private final FwfRemoteConfigurationParser parser;
    @NotNull
    private final HashMap<String, HashMap<String, Object>> talabatFeatureFlags;

    public LocalFwfRemoteConfigurationDataSource(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "sourceFile");
        Gson gson2 = new Gson();
        this.gson = gson2;
        this.parser = new FwfRemoteConfigurationParser(gson2);
        AssetManager assets = context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        String readAssetsFile = readAssetsFile(assets, str);
        Type type = new TypeToken<HashMap<String, HashMap<String, Object>>>() {
        }.getType();
        Object fromJson = !(gson2 instanceof Gson) ? gson2.fromJson(readAssetsFile, type) : GsonInstrumentation.fromJson(gson2, readAssetsFile, type);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(json, obje…tFeatureFlags>() {}.type)");
        this.talabatFeatureFlags = (HashMap) fromJson;
    }

    /* access modifiers changed from: private */
    public final <T> T getEnabledFeatureFlagValue(FWFKey fWFKey, T t11, Class<T> cls) throws NoSuchElementException {
        Object obj;
        T variationValue;
        HashMap hashMap = this.talabatFeatureFlags.get(fWFKey.getValue());
        if (hashMap == null || (obj = hashMap.get("variation")) == null || (variationValue = getVariationValue(obj, t11, cls)) == null) {
            return t11;
        }
        return variationValue;
    }

    private final <T> T getVariationValue(Object obj, T t11, Class<T> cls) {
        return this.parser.getTheVariationValue(toStringValue(obj), t11, cls);
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatremoteconfiguration.datasource.fwf.LocalFwfRemoteConfigurationDataSource.readAssetsFile(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }

    private final String toStringValue(Object obj) {
        if ((obj instanceof LinkedTreeMap) || (obj instanceof LinkedHashMap) || (obj instanceof List)) {
            return GsonInstrumentation.toJson(new Gson(), obj).toString();
        }
        return obj.toString();
    }

    @Nullable
    public <T> Object getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, boolean z11, @NotNull Class<T> cls, @NotNull Continuation<? super T> continuation) {
        return getEnabledFeatureFlagValue(fWFKey, t11, cls);
    }

    public <T> void getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, boolean z11, @NotNull Class<T> cls, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Intrinsics.checkNotNullParameter(cls, "classType");
        Intrinsics.checkNotNullParameter(function1, "callback");
        function1.invoke(getEnabledFeatureFlagValue(fWFKey, t11, cls));
    }

    public <T> T getRemoteConfiguration(@NotNull FWFKey fWFKey, T t11, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(fWFKey, "fwfKey");
        Intrinsics.checkNotNullParameter(cls, "classType");
        return getEnabledFeatureFlagValue(fWFKey, t11, cls);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalFwfRemoteConfigurationDataSource(Context context, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? "talabat_remote_config.json" : str);
    }
}
