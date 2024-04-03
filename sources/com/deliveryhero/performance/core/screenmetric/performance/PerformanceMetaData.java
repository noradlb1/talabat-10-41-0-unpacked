package com.deliveryhero.performance.core.screenmetric.performance;

import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0006¢\u0006\u0002\u0010\bJ%\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J%\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0006HÆ\u0003JU\u0010\u000e\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00062$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/PerformanceMetaData;", "", "metrics", "Ljava/util/HashMap;", "", "Lcom/deliveryhero/performance/core/screenmetric/performance/MetricMetaData;", "Lkotlin/collections/HashMap;", "attributes", "(Ljava/util/HashMap;Ljava/util/HashMap;)V", "getAttributes", "()Ljava/util/HashMap;", "getMetrics", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PerformanceMetaData {
    @NotNull
    private final HashMap<String, String> attributes;
    @NotNull
    private final HashMap<String, MetricMetaData> metrics;

    public PerformanceMetaData() {
        this((HashMap) null, (HashMap) null, 3, (DefaultConstructorMarker) null);
    }

    public PerformanceMetaData(@NotNull HashMap<String, MetricMetaData> hashMap, @NotNull HashMap<String, String> hashMap2) {
        Intrinsics.checkNotNullParameter(hashMap, "metrics");
        Intrinsics.checkNotNullParameter(hashMap2, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.metrics = hashMap;
        this.attributes = hashMap2;
    }

    public static /* synthetic */ PerformanceMetaData copy$default(PerformanceMetaData performanceMetaData, HashMap<String, MetricMetaData> hashMap, HashMap<String, String> hashMap2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            hashMap = performanceMetaData.metrics;
        }
        if ((i11 & 2) != 0) {
            hashMap2 = performanceMetaData.attributes;
        }
        return performanceMetaData.copy(hashMap, hashMap2);
    }

    @NotNull
    public final HashMap<String, MetricMetaData> component1() {
        return this.metrics;
    }

    @NotNull
    public final HashMap<String, String> component2() {
        return this.attributes;
    }

    @NotNull
    public final PerformanceMetaData copy(@NotNull HashMap<String, MetricMetaData> hashMap, @NotNull HashMap<String, String> hashMap2) {
        Intrinsics.checkNotNullParameter(hashMap, "metrics");
        Intrinsics.checkNotNullParameter(hashMap2, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        return new PerformanceMetaData(hashMap, hashMap2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PerformanceMetaData)) {
            return false;
        }
        PerformanceMetaData performanceMetaData = (PerformanceMetaData) obj;
        return Intrinsics.areEqual((Object) this.metrics, (Object) performanceMetaData.metrics) && Intrinsics.areEqual((Object) this.attributes, (Object) performanceMetaData.attributes);
    }

    @NotNull
    public final HashMap<String, String> getAttributes() {
        return this.attributes;
    }

    @NotNull
    public final HashMap<String, MetricMetaData> getMetrics() {
        return this.metrics;
    }

    public int hashCode() {
        return (this.metrics.hashCode() * 31) + this.attributes.hashCode();
    }

    @NotNull
    public String toString() {
        return "PerformanceMetaData(metrics=" + this.metrics + ", attributes=" + this.attributes + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PerformanceMetaData(HashMap hashMap, HashMap hashMap2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new HashMap() : hashMap, (i11 & 2) != 0 ? new HashMap() : hashMap2);
    }
}
