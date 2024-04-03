package com.talabat.performance_analytics;

import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/talabat/performance_analytics/TraceMetricParams;", "", "traceName", "", "metricName", "metricValue", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getMetricName", "()Ljava/lang/String;", "getMetricValue", "()J", "getTraceName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toList", "", "toString", "Companion", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TraceMetricParams {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String metricName;
    private final long metricValue;
    @NotNull
    private final String traceName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/performance_analytics/TraceMetricParams$Companion;", "", "()V", "fromList", "Lcom/talabat/performance_analytics/TraceMetricParams;", "list", "", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TraceMetricParams fromList(@NotNull List<? extends Object> list) {
            long j11;
            Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
            Object obj = list.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            Object obj2 = list.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj2;
            Object obj3 = list.get(2);
            if (obj3 instanceof Integer) {
                j11 = (long) ((Number) obj3).intValue();
            } else {
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Long");
                j11 = ((Long) obj3).longValue();
            }
            return new TraceMetricParams(str, str2, j11);
        }
    }

    public TraceMetricParams(@NotNull String str, @NotNull String str2, long j11) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "metricName");
        this.traceName = str;
        this.metricName = str2;
        this.metricValue = j11;
    }

    public static /* synthetic */ TraceMetricParams copy$default(TraceMetricParams traceMetricParams, String str, String str2, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = traceMetricParams.traceName;
        }
        if ((i11 & 2) != 0) {
            str2 = traceMetricParams.metricName;
        }
        if ((i11 & 4) != 0) {
            j11 = traceMetricParams.metricValue;
        }
        return traceMetricParams.copy(str, str2, j11);
    }

    @NotNull
    public final String component1() {
        return this.traceName;
    }

    @NotNull
    public final String component2() {
        return this.metricName;
    }

    public final long component3() {
        return this.metricValue;
    }

    @NotNull
    public final TraceMetricParams copy(@NotNull String str, @NotNull String str2, long j11) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "metricName");
        return new TraceMetricParams(str, str2, j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TraceMetricParams)) {
            return false;
        }
        TraceMetricParams traceMetricParams = (TraceMetricParams) obj;
        return Intrinsics.areEqual((Object) this.traceName, (Object) traceMetricParams.traceName) && Intrinsics.areEqual((Object) this.metricName, (Object) traceMetricParams.metricName) && this.metricValue == traceMetricParams.metricValue;
    }

    @NotNull
    public final String getMetricName() {
        return this.metricName;
    }

    public final long getMetricValue() {
        return this.metricValue;
    }

    @NotNull
    public final String getTraceName() {
        return this.traceName;
    }

    public int hashCode() {
        return (((this.traceName.hashCode() * 31) + this.metricName.hashCode()) * 31) + a.a(this.metricValue);
    }

    @NotNull
    public final List<Object> toList() {
        return CollectionsKt__CollectionsKt.listOf(this.traceName, this.metricName, Long.valueOf(this.metricValue));
    }

    @NotNull
    public String toString() {
        return "TraceMetricParams(traceName=" + this.traceName + ", metricName=" + this.metricName + ", metricValue=" + this.metricValue + ')';
    }
}
