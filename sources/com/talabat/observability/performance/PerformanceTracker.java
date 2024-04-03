package com.talabat.observability.performance;

import android.app.Application;
import androidx.annotation.VisibleForTesting;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.deliveryhero.performance.core.appstartup.AppStartUpDetector;
import com.talabat.performance_analytics.PerformanceAnalyticsPluginFacade;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0011\"\u00020\b¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u001c\b\u0002\u0010\u0015\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0007J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/observability/performance/PerformanceTracker;", "", "()V", "performanceTrackerInstance", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "addAppFlowTraceAttribute", "", "traceName", "", "attrValue", "addTraceCounter", "traceCounterName", "cancelTrace", "listenToAppStartUp", "context", "Landroid/app/Application;", "traces", "", "(Landroid/app/Application;[Ljava/lang/String;)V", "setPerformanceTrackerImpl", "performanceTrackingManager", "onError", "Lkotlin/Function2;", "", "startTrace", "stopTrace", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PerformanceTracker {
    @NotNull
    public static final PerformanceTracker INSTANCE = new PerformanceTracker();
    private static PerformanceTrackingManager performanceTrackerInstance;

    private PerformanceTracker() {
    }

    public static /* synthetic */ void setPerformanceTrackerImpl$default(PerformanceTracker performanceTracker, PerformanceTrackingManager performanceTrackingManager, Function2 function2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function2 = PerformanceTracker$setPerformanceTrackerImpl$1.INSTANCE;
        }
        performanceTracker.setPerformanceTrackerImpl(performanceTrackingManager, function2);
    }

    public final void addAppFlowTraceAttribute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "attrValue");
        PerformanceTrackingManager performanceTrackingManager = performanceTrackerInstance;
        if (performanceTrackingManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTrackerInstance");
            performanceTrackingManager = null;
        }
        performanceTrackingManager.addTraceAttribute(str, AppStartFlow.INSTANCE.getName(), str2);
    }

    public final void addTraceCounter(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "traceCounterName");
        PerformanceTrackingManager performanceTrackingManager = performanceTrackerInstance;
        if (performanceTrackingManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTrackerInstance");
            performanceTrackingManager = null;
        }
        performanceTrackingManager.addTraceCounter(str, str2);
    }

    public final void cancelTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        PerformanceTrackingManager performanceTrackingManager = performanceTrackerInstance;
        if (performanceTrackingManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTrackerInstance");
            performanceTrackingManager = null;
        }
        performanceTrackingManager.cancelTrace(str);
    }

    public final void listenToAppStartUp(@NotNull Application application, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(strArr, "traces");
        PerformanceTrackingManager performanceTrackingManager = performanceTrackerInstance;
        if (performanceTrackingManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTrackerInstance");
            performanceTrackingManager = null;
        }
        AppStartUpDetector.listenToAppStartUp(application, performanceTrackingManager, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @VisibleForTesting
    public final void setPerformanceTrackerImpl(@NotNull PerformanceTrackingManager performanceTrackingManager, @NotNull Function2<? super Throwable, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(performanceTrackingManager, "performanceTrackingManager");
        Intrinsics.checkNotNullParameter(function2, "onError");
        performanceTrackerInstance = performanceTrackingManager;
        try {
            PerformanceAnalyticsPluginFacade.setPerformanceTrackingManager(performanceTrackingManager);
        } catch (Exception e11) {
            function2.invoke(e11, "PerformanceAnalyticsPluginFacade.setPerformanceTrackingManager");
        }
    }

    public final void startTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        PerformanceTrackingManager performanceTrackingManager = performanceTrackerInstance;
        if (performanceTrackingManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTrackerInstance");
            performanceTrackingManager = null;
        }
        performanceTrackingManager.startTrace(str);
    }

    public final void stopTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        PerformanceTrackingManager performanceTrackingManager = performanceTrackerInstance;
        if (performanceTrackingManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTrackerInstance");
            performanceTrackingManager = null;
        }
        performanceTrackingManager.stopTrace(str);
    }
}
