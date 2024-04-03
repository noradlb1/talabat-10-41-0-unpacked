package com.deliveryhero.performance.core.screenmetric.performance;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/ScreenPerfTimeMetricTracker;", "", "()V", "metricStartedTime", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getMetricStartedTime", "()Ljava/util/HashMap;", "start", "", "metricName", "stop", "screenSimpleName", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenPerfTimeMetricTracker {
    @NotNull
    private final HashMap<String, Long> metricStartedTime = new HashMap<>();

    @NotNull
    public final HashMap<String, Long> getMetricStartedTime() {
        return this.metricStartedTime;
    }

    public final void start(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "metricName");
        this.metricStartedTime.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public final void stop(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "metricName");
        Intrinsics.checkNotNullParameter(str2, "screenSimpleName");
        long currentTimeMillis = System.currentTimeMillis();
        Long remove = this.metricStartedTime.remove(str);
        if (remove == null) {
            remove = 0L;
        }
        ScreenPerfMetricContainer.INSTANCE.addMetricToScreen(str2, str, currentTimeMillis - remove.longValue());
    }
}
