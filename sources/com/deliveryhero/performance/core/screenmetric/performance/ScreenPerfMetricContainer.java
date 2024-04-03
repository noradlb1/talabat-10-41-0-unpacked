package com.deliveryhero.performance.core.screenmetric.performance;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J%\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u001e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/ScreenPerfMetricContainer;", "", "()V", "TAG", "", "metricsForActiveScreen", "Ljava/util/HashMap;", "Lcom/deliveryhero/performance/core/screenmetric/performance/PerformanceMetaData;", "Lkotlin/collections/HashMap;", "addActiveScreen", "", "screenSimpleName", "addActiveScreen$core_release", "addAttributeToAllActiveScreen", "", "attrKey", "attrValue", "addAttributeToScreen", "addMetricToAllActiveScreens", "metricKey", "metricValue", "", "addMetricToScreen", "metricMetaData", "Lcom/deliveryhero/performance/core/screenmetric/performance/MetricMetaData;", "addMetricToScreen$core_release", "popAllMetadataForScreenAndDeactivate", "popAllMetadataForScreenAndDeactivate$core_release", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenPerfMetricContainer {
    @NotNull
    public static final ScreenPerfMetricContainer INSTANCE = new ScreenPerfMetricContainer();
    @NotNull
    private static final String TAG = "Performance-SPMC";
    @NotNull
    private static final HashMap<String, PerformanceMetaData> metricsForActiveScreen = new HashMap<>();

    private ScreenPerfMetricContainer() {
    }

    public final boolean addActiveScreen$core_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenSimpleName");
        Intrinsics.stringPlus("add active Screen: Screen Name:", str);
        HashMap<String, PerformanceMetaData> hashMap = metricsForActiveScreen;
        if (hashMap.containsKey(str)) {
            return false;
        }
        hashMap.put(str, new PerformanceMetaData((HashMap) null, (HashMap) null, 3, (DefaultConstructorMarker) null));
        return true;
    }

    public final void addAttributeToAllActiveScreen(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "attrKey");
        Intrinsics.checkNotNullParameter(str2, "attrValue");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("attribute added to all: attrKey: ");
        sb2.append(str);
        sb2.append(", attrValue: ");
        sb2.append(str2);
        for (Map.Entry<String, PerformanceMetaData> value : metricsForActiveScreen.entrySet()) {
            ((PerformanceMetaData) value.getValue()).getAttributes().put(str, str2);
        }
    }

    public final void addAttributeToScreen(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenSimpleName");
        Intrinsics.checkNotNullParameter(str2, "attrKey");
        Intrinsics.checkNotNullParameter(str3, "attrValue");
        String str4 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Attribute added: screenSimpleName: ");
        sb2.append(str);
        sb2.append(", attrKey: ");
        sb2.append(str2);
        sb2.append(", attrValue: ");
        sb2.append(str3);
        HashMap<String, PerformanceMetaData> hashMap = metricsForActiveScreen;
        if (!hashMap.containsKey(str)) {
            Log.e(str4, Intrinsics.stringPlus("Screen was not active: ", str));
            hashMap.put(str, new PerformanceMetaData((HashMap) null, (HashMap) null, 3, (DefaultConstructorMarker) null));
        }
        PerformanceMetaData performanceMetaData = hashMap.get(str);
        Intrinsics.checkNotNull(performanceMetaData);
        performanceMetaData.getAttributes().put(str2, str3);
    }

    public final void addMetricToAllActiveScreens(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "metricKey");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Metric to all screen: metricKey: ");
        sb2.append(str);
        sb2.append(", metricValue: ");
        sb2.append(j11);
        for (Map.Entry<String, PerformanceMetaData> value : metricsForActiveScreen.entrySet()) {
            ((PerformanceMetaData) value.getValue()).getMetrics().put(str, new MetricMetaData(j11, (Map) null, 2, (DefaultConstructorMarker) null));
        }
    }

    public final void addMetricToScreen(@NotNull String str, @NotNull String str2, long j11) {
        Intrinsics.checkNotNullParameter(str, "screenSimpleName");
        Intrinsics.checkNotNullParameter(str2, "metricKey");
        addMetricToScreen$core_release(str, str2, new MetricMetaData(j11, (Map) null, 2, (DefaultConstructorMarker) null));
    }

    public final void addMetricToScreen$core_release(@NotNull String str, @NotNull String str2, @NotNull MetricMetaData metricMetaData) {
        Intrinsics.checkNotNullParameter(str, "screenSimpleName");
        Intrinsics.checkNotNullParameter(str2, "metricKey");
        Intrinsics.checkNotNullParameter(metricMetaData, "metricMetaData");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Metric added: screenSimpleName: ");
        sb2.append(str);
        sb2.append(", metricKey: ");
        sb2.append(str2);
        sb2.append(", metricValue: ");
        sb2.append(metricMetaData);
        HashMap<String, PerformanceMetaData> hashMap = metricsForActiveScreen;
        if (!hashMap.containsKey(str)) {
            Log.e("Performance Metric", Intrinsics.stringPlus("Screen was not active: ", str));
            hashMap.put(str, new PerformanceMetaData((HashMap) null, (HashMap) null, 3, (DefaultConstructorMarker) null));
        }
        PerformanceMetaData performanceMetaData = hashMap.get(str);
        Intrinsics.checkNotNull(performanceMetaData);
        performanceMetaData.getMetrics().put(str2, metricMetaData);
    }

    @NotNull
    public final PerformanceMetaData popAllMetadataForScreenAndDeactivate$core_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenSimpleName");
        Intrinsics.stringPlus("deactivate Screen: Screen Name:", str);
        PerformanceMetaData remove = metricsForActiveScreen.remove(str);
        if (remove == null) {
            return new PerformanceMetaData((HashMap) null, (HashMap) null, 3, (DefaultConstructorMarker) null);
        }
        return remove;
    }
}
