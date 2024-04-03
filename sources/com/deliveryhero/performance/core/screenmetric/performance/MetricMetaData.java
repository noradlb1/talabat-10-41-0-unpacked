package com.deliveryhero.performance.core.screenmetric.performance;

import com.deliveryhero.performance.core.logger.TraceLogKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B%\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\tHÖ\u0001R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/MetricMetaData;", "", "duration", "", "stopTime", "(JJ)V", "value", "metaData", "", "", "(JLjava/util/Map;)V", "getMetaData", "()Ljava/util/Map;", "getValue", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MetricMetaData {
    @Nullable
    private final Map<String, Long> metaData;
    private final long value;

    public MetricMetaData(long j11, @Nullable Map<String, Long> map) {
        this.value = j11;
        this.metaData = map;
    }

    public static /* synthetic */ MetricMetaData copy$default(MetricMetaData metricMetaData, long j11, Map<String, Long> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = metricMetaData.value;
        }
        if ((i11 & 2) != 0) {
            map = metricMetaData.metaData;
        }
        return metricMetaData.copy(j11, map);
    }

    public final long component1() {
        return this.value;
    }

    @Nullable
    public final Map<String, Long> component2() {
        return this.metaData;
    }

    @NotNull
    public final MetricMetaData copy(long j11, @Nullable Map<String, Long> map) {
        return new MetricMetaData(j11, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetricMetaData)) {
            return false;
        }
        MetricMetaData metricMetaData = (MetricMetaData) obj;
        return this.value == metricMetaData.value && Intrinsics.areEqual((Object) this.metaData, (Object) metricMetaData.metaData);
    }

    @Nullable
    public final Map<String, Long> getMetaData() {
        return this.metaData;
    }

    public final long getValue() {
        return this.value;
    }

    public int hashCode() {
        int a11 = a.a(this.value) * 31;
        Map<String, Long> map = this.metaData;
        return a11 + (map == null ? 0 : map.hashCode());
    }

    @NotNull
    public String toString() {
        return "MetricMetaData(value=" + this.value + ", metaData=" + this.metaData + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MetricMetaData(long j11, Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, (Map<String, Long>) (i11 & 2) != 0 ? null : map);
    }

    public MetricMetaData(long j11, long j12) {
        this(j11, (Map<String, Long>) MapsKt__MapsKt.mapOf(TuplesKt.to(TraceLogKt.STOP_PROPERTY_NAME, Long.valueOf(j12)), TuplesKt.to("start", Long.valueOf(j12 - j11))));
    }
}
