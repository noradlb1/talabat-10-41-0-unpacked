package com.talabat.performance_analytics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u001a\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"logTag", "", "getLogTag", "()Ljava/lang/String;", "setLogTag", "(Ljava/lang/String;)V", "performance_analytics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PerformanceAnalyticsPluginKt {
    @NotNull
    private static String logTag = "PerformanceAnalytics ⏳: ";

    @NotNull
    public static final String getLogTag() {
        return logTag;
    }

    public static final void setLogTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        logTag = str;
    }
}
