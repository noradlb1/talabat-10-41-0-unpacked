package com.deliveryhero.performance.core.tapresponse;

import com.deliveryhero.performance.core.screenmetric.ScreenMetricTimeKt;
import com.deliveryhero.performance.core.screenmetric.performance.MetricMetaData;
import com.deliveryhero.performance.core.screenmetric.performance.ScreenPerfMetricContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"NTS_KEY", "", "SNTR_KEY", "SOURCE_SCREEN_KEY", "reportTapResponseMetric", "", "Lcom/deliveryhero/performance/core/tapresponse/TapResponseTime;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TapResponseTimeKt {
    @NotNull
    public static final String NTS_KEY = "nts_ms";
    @NotNull
    public static final String SNTR_KEY = "sntr_ms";
    @NotNull
    public static final String SOURCE_SCREEN_KEY = "SourceScreen";

    public static final void reportTapResponseMetric(@NotNull TapResponseTime tapResponseTime) {
        Intrinsics.checkNotNullParameter(tapResponseTime, "<this>");
        long currentTimeMillis = System.currentTimeMillis();
        ScreenPerfMetricContainer screenPerfMetricContainer = ScreenPerfMetricContainer.INSTANCE;
        screenPerfMetricContainer.addMetricToScreen$core_release(tapResponseTime.getScreenMetricTime().getDestinationScreenSimpleName(), SNTR_KEY, new MetricMetaData(tapResponseTime.getTotalMillis(), currentTimeMillis));
        screenPerfMetricContainer.addMetricToScreen$core_release(tapResponseTime.getScreenMetricTime().getDestinationScreenSimpleName(), NTS_KEY, new MetricMetaData(tapResponseTime.getNavigationToScreen(), currentTimeMillis));
        String sourceScreenChosenName = tapResponseTime.getSourceScreenChosenName();
        if (sourceScreenChosenName != null) {
            screenPerfMetricContainer.addAttributeToScreen(tapResponseTime.getScreenMetricTime().getDestinationScreenSimpleName(), SOURCE_SCREEN_KEY, sourceScreenChosenName);
        }
        ScreenMetricTimeKt.reportScreenMetric(tapResponseTime.getScreenMetricTime());
    }
}
