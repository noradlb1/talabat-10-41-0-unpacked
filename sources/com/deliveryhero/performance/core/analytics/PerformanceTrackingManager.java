package com.deliveryhero.performance.core.analytics;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0017J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J8\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0003H&¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "Lcom/deliveryhero/performance/core/analytics/Tracker;", "addHostScreen", "", "traceName", "", "host", "addTracker", "performanceTracker", "Lcom/deliveryhero/performance/core/analytics/PerformanceTracker;", "putTraceMetric", "metricName", "metricValue", "", "metadata", "", "", "registerTraceListener", "traceListener", "Lcom/deliveryhero/performance/core/analytics/TraceListener;", "startMetric", "stopMetric", "unregisterTraceListener", "Params", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PerformanceTrackingManager extends Tracker {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void putTraceMetric$default(PerformanceTrackingManager performanceTrackingManager, String str, String str2, long j11, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 8) != 0) {
                    map = null;
                }
                performanceTrackingManager.putTraceMetric(str, str2, j11, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: putTraceMetric");
        }
    }

    void addHostScreen(@NotNull String str, @NotNull String str2);

    void addTracker(@NotNull PerformanceTracker performanceTracker);

    void putTraceMetric(@NotNull String str, @NotNull String str2, long j11, @Nullable Map<String, ? extends Object> map);

    void registerTraceListener(@NotNull TraceListener traceListener);

    void startMetric(@NotNull String str, @NotNull String str2);

    void stopMetric(@NotNull String str, @NotNull String str2);

    void unregisterTraceListener();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager$Params;", "", "enableTraceMessaging", "", "(Z)V", "getEnableTraceMessaging", "()Z", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        private final boolean enableTraceMessaging;

        public Params() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public Params(boolean z11) {
            this.enableTraceMessaging = z11;
        }

        public final boolean getEnableTraceMessaging() {
            return this.enableTraceMessaging;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Params(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? false : z11);
        }
    }
}
