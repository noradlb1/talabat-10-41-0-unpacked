package com.talabat.performance_analytics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"toScreenTraceName", "", "performance_analytics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PerformanceAnalyticsScreenTrackerImplKt {
    @NotNull
    public static final String toScreenTraceName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str + "StartToInteractive";
    }
}
