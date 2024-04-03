package com.deliveryhero.performance.core.analytics;

import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tH&J8\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tH\u0016¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/performance/core/analytics/PerformanceTracker;", "Lcom/deliveryhero/performance/core/analytics/Tracker;", "addHostScreen", "", "traceName", "", "host", "putAllTraceAttributes", "attrs", "", "putTraceMetric", "metricName", "metricValue", "", "metadata", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PerformanceTracker extends Tracker {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void addHostScreen(@NotNull PerformanceTracker performanceTracker, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(performanceTracker, "this");
            Intrinsics.checkNotNullParameter(str, "traceName");
            Intrinsics.checkNotNullParameter(str2, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        }

        public static void putTraceMetric(@NotNull PerformanceTracker performanceTracker, @NotNull String str, @NotNull String str2, long j11, @Nullable Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(performanceTracker, "this");
            Intrinsics.checkNotNullParameter(str, "traceName");
            Intrinsics.checkNotNullParameter(str2, "metricName");
            performanceTracker.putTraceMetric(str, str2, j11);
        }

        public static /* synthetic */ void putTraceMetric$default(PerformanceTracker performanceTracker, String str, String str2, long j11, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 8) != 0) {
                    map = null;
                }
                performanceTracker.putTraceMetric(str, str2, j11, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: putTraceMetric");
        }
    }

    void addHostScreen(@NotNull String str, @NotNull String str2);

    void putAllTraceAttributes(@NotNull String str, @NotNull Map<String, String> map);

    void putTraceMetric(@NotNull String str, @NotNull String str2, long j11, @Nullable Map<String, ? extends Object> map);
}
