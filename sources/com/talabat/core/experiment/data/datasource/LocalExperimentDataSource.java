package com.talabat.core.experiment.data.datasource;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.annotation.VisibleForTesting;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.experiment.data.datasource.IExperimentDataSource;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0014\u0010\u0016\u001a\u00020\u0005*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0002R6\u0010\u0007\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b0\b0\bj\u0002`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/experiment/data/datasource/LocalExperimentDataSource;", "Lcom/talabat/core/experiment/data/datasource/IExperimentDataSource;", "context", "Landroid/content/Context;", "file", "", "(Landroid/content/Context;Ljava/lang/String;)V", "talabatExperiments", "Ljava/util/HashMap;", "", "Lcom/talabat/core/experiment/data/datasource/TalabatExperiments;", "getBooleanVariant", "experimentKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "getDoubleVariant", "", "getIntVariant", "", "getRandomEnabledValue", "experimentType", "getStringVariant", "readAssetsFile", "Landroid/content/res/AssetManager;", "fileName", "com_talabat_core_experiment_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@VisibleForTesting
public class LocalExperimentDataSource implements IExperimentDataSource {
    @NotNull
    private final HashMap<String, HashMap<String, HashMap<String, Boolean>>> talabatExperiments;

    public LocalExperimentDataSource(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "file");
        AssetManager assets = context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        Object fromJson = GsonInstrumentation.fromJson(new Gson(), readAssetsFile(assets, str), new TypeToken<HashMap<String, HashMap<String, HashMap<String, Boolean>>>>() {
        }.getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(json, ob…atExperiments>() {}.type)");
        this.talabatExperiments = (HashMap) fromJson;
    }

    private final String getRandomEnabledValue(FWFKey fWFKey, String str) {
        HashMap hashMap;
        HashMap hashMap2 = this.talabatExperiments.get(str);
        if (!(hashMap2 == null || (hashMap = (HashMap) hashMap2.get(fWFKey.getValue())) == null)) {
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
                return (String) CollectionsKt___CollectionsKt.first(arrayList);
            }
        }
        return null;
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.experiment.data.datasource.LocalExperimentDataSource.readAssetsFile(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }

    @Nullable
    public Object getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation) {
        return IExperimentDataSource.DefaultImpls.getBooleanVariant((IExperimentDataSource) this, fWFKey, z11, z12, continuation);
    }

    @Nullable
    public Object getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull Continuation<? super Double> continuation) {
        return IExperimentDataSource.DefaultImpls.getDoubleVariant((IExperimentDataSource) this, fWFKey, d11, z11, continuation);
    }

    @Nullable
    public Object getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Continuation<? super Integer> continuation) {
        return IExperimentDataSource.DefaultImpls.getIntVariant((IExperimentDataSource) this, fWFKey, i11, z11, continuation);
    }

    @Nullable
    public Object getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Continuation<? super String> continuation) {
        return IExperimentDataSource.DefaultImpls.getStringVariant((IExperimentDataSource) this, fWFKey, str, z11, continuation);
    }

    public void setAttribute(@NotNull String str, @NotNull String str2) {
        IExperimentDataSource.DefaultImpls.setAttribute(this, str, str2);
    }

    public void getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1) {
        IExperimentDataSource.DefaultImpls.getBooleanVariant((IExperimentDataSource) this, fWFKey, z11, z12, function1);
    }

    public void getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull Function1<? super Double, Unit> function1) {
        IExperimentDataSource.DefaultImpls.getDoubleVariant((IExperimentDataSource) this, fWFKey, d11, z11, function1);
    }

    public void getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Function1<? super Integer, Unit> function1) {
        IExperimentDataSource.DefaultImpls.getIntVariant((IExperimentDataSource) this, fWFKey, i11, z11, function1);
    }

    public void getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Function1<? super String, Unit> function1) {
        IExperimentDataSource.DefaultImpls.getStringVariant((IExperimentDataSource) this, fWFKey, str, z11, function1);
    }

    public boolean getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        String randomEnabledValue = getRandomEnabledValue(fWFKey, "boolean_experiments");
        if (randomEnabledValue != null) {
            return Boolean.parseBoolean(randomEnabledValue);
        }
        return false;
    }

    public double getDoubleVariant(@NotNull FWFKey fWFKey, double d11) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        String randomEnabledValue = getRandomEnabledValue(fWFKey, "double_experiments");
        if (randomEnabledValue != null) {
            return Double.parseDouble(randomEnabledValue);
        }
        return 0.0d;
    }

    public int getIntVariant(@NotNull FWFKey fWFKey, int i11) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        String randomEnabledValue = getRandomEnabledValue(fWFKey, "int_experiments");
        if (randomEnabledValue != null) {
            return Integer.parseInt(randomEnabledValue);
        }
        return 1;
    }

    @NotNull
    public String getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(str, "defaultValue");
        String randomEnabledValue = getRandomEnabledValue(fWFKey, "string_experiments");
        return randomEnabledValue == null ? "" : randomEnabledValue;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalExperimentDataSource(Context context, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? "talabat_experiments.json" : str);
    }
}
