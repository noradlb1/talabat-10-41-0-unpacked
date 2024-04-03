package com.deliveryhero.performance.core.analytics;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\u0007"}, d2 = {"trace", "", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "traceName", "", "action", "Lkotlin/Function0;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PerformanceTrackingManagerKt {
    public static final void trace(@NotNull PerformanceTrackingManager performanceTrackingManager, @NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(performanceTrackingManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        performanceTrackingManager.startTrace(str);
        function0.invoke();
        performanceTrackingManager.stopTrace(str);
    }
}
