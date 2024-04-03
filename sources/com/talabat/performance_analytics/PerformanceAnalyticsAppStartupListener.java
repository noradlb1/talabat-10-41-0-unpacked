package com.talabat.performance_analytics;

import android.app.Application;
import android.content.Context;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.deliveryhero.performance.core.appstartup.AppStartUpDetector;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsAppStartupListener;", "Lcom/talabat/performance_analytics/PerformanceAnalyticsAppStartupListenerApi;", "context", "Landroid/content/Context;", "performanceTrackingManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "(Landroid/content/Context;Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;)V", "listenToAppStartUp", "", "traces", "", "", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerformanceAnalyticsAppStartupListener implements PerformanceAnalyticsAppStartupListenerApi {
    @NotNull
    private Context context;
    @NotNull
    private PerformanceTrackingManager performanceTrackingManager;

    public PerformanceAnalyticsAppStartupListener(@NotNull Context context2, @NotNull PerformanceTrackingManager performanceTrackingManager2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(performanceTrackingManager2, "performanceTrackingManager");
        this.context = context2;
        this.performanceTrackingManager = performanceTrackingManager2;
    }

    public void listenToAppStartUp(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "traces");
        PerformanceAnalyticsPluginKt.getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("listenToAppStartUp: ");
        sb2.append(list);
        Context context2 = this.context;
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Application");
        PerformanceTrackingManager performanceTrackingManager2 = this.performanceTrackingManager;
        Object[] array = list.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        AppStartUpDetector.listenToAppStartUp((Application) context2, performanceTrackingManager2, (String[]) Arrays.copyOf(strArr, strArr.length));
    }
}
