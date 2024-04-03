package com.deliveryhero.performance.core.screenmetric;

import com.deliveryhero.performance.core.screenmetric.performance.MetricMetaData;
import com.deliveryhero.performance.core.screenmetric.performance.ScreenPerfMetricContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"TTFL_KEY", "", "reportScreenMetric", "", "Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricTime;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ScreenMetricTimeKt {
    @NotNull
    public static final String TTFL_KEY = "ttfl_ms";

    public static final void reportScreenMetric(@NotNull ScreenMetricTime screenMetricTime) {
        Intrinsics.checkNotNullParameter(screenMetricTime, "<this>");
        ScreenPerfMetricContainer.INSTANCE.addMetricToScreen$core_release(screenMetricTime.getDestinationScreenSimpleName(), TTFL_KEY, new MetricMetaData(screenMetricTime.getTimeToFirstLayout(), System.currentTimeMillis()));
    }
}
