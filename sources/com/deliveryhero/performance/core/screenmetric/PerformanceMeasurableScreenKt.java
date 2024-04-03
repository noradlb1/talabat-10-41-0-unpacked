package com.deliveryhero.performance.core.screenmetric;

import com.deliveryhero.performance.core.screenmetric.performance.TimeToInteractive;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"screenReadyForInteraction", "", "Lcom/deliveryhero/performance/core/screenmetric/PerformanceMeasurableScreen;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PerformanceMeasurableScreenKt {
    public static final void screenReadyForInteraction(@NotNull PerformanceMeasurableScreen performanceMeasurableScreen) {
        Intrinsics.checkNotNullParameter(performanceMeasurableScreen, "<this>");
        TimeToInteractive.INSTANCE.stop(performanceMeasurableScreen);
    }
}
