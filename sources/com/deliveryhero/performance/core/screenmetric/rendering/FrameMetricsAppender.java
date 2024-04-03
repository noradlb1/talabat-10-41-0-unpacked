package com.deliveryhero.performance.core.screenmetric.rendering;

import com.deliveryhero.performance.core.screenmetric.performance.ScreenPerfMetricContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/rendering/FrameMetricsAppender;", "", "()V", "DEVICE_REFRESH_RATE", "", "DYNAMIC_SLOW_FRAMES_NAME", "DYNAMIC_SLOW_FRAMES_RATE_NAME", "FROZEN_FRAMES_NAME", "FROZEN_FRAMES_RATE_NAME", "SLOW_FRAMES_NAME", "SLOW_FRAMES_RATE_NAME", "TOTAL_FRAMES_NAME", "appendFrameMetrics", "", "screenName", "screenFrameMetrics", "Lcom/deliveryhero/performance/core/screenmetric/rendering/ScreenFrameMetric;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FrameMetricsAppender {
    @NotNull
    private static final String DEVICE_REFRESH_RATE = "device_refresh_rate";
    @NotNull
    private static final String DYNAMIC_SLOW_FRAMES_NAME = "dynamic_slow_frames";
    @NotNull
    private static final String DYNAMIC_SLOW_FRAMES_RATE_NAME = "dynamic_slow_frames_rate";
    @NotNull
    private static final String FROZEN_FRAMES_NAME = "frozen_frames";
    @NotNull
    private static final String FROZEN_FRAMES_RATE_NAME = "frozen_frames_rate";
    @NotNull
    public static final FrameMetricsAppender INSTANCE = new FrameMetricsAppender();
    @NotNull
    private static final String SLOW_FRAMES_NAME = "slow_frames";
    @NotNull
    private static final String SLOW_FRAMES_RATE_NAME = "slow_frames_rates";
    @NotNull
    private static final String TOTAL_FRAMES_NAME = "total_frames";

    private FrameMetricsAppender() {
    }

    public final void appendFrameMetrics(@NotNull String str, @NotNull ScreenFrameMetric screenFrameMetric) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(screenFrameMetric, "screenFrameMetrics");
        if (screenFrameMetric.getTotalFrames() > 0) {
            ScreenPerfMetricContainer screenPerfMetricContainer = ScreenPerfMetricContainer.INSTANCE;
            screenPerfMetricContainer.addMetricToScreen(str, TOTAL_FRAMES_NAME, screenFrameMetric.getTotalFrames());
            screenPerfMetricContainer.addMetricToScreen(str, FROZEN_FRAMES_NAME, screenFrameMetric.getFrozenFrames());
            screenPerfMetricContainer.addMetricToScreen(str, FROZEN_FRAMES_RATE_NAME, screenFrameMetric.getFrozenFramesRate());
            screenPerfMetricContainer.addMetricToScreen(str, SLOW_FRAMES_NAME, screenFrameMetric.getDefaultSlowFrames());
            screenPerfMetricContainer.addMetricToScreen(str, SLOW_FRAMES_RATE_NAME, screenFrameMetric.getDefaultSlowFramesRate());
            screenPerfMetricContainer.addMetricToScreen(str, DYNAMIC_SLOW_FRAMES_NAME, screenFrameMetric.getDynamicSlowFrames());
            screenPerfMetricContainer.addMetricToScreen(str, DYNAMIC_SLOW_FRAMES_RATE_NAME, screenFrameMetric.getDynamicSlowFramesRate());
            screenPerfMetricContainer.addMetricToScreen(str, DEVICE_REFRESH_RATE, screenFrameMetric.getDeviceRefreshRate());
        }
    }
}
