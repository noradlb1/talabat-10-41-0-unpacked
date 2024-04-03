package com.deliveryhero.performance.core.screentracker;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.facebook.internal.NativeProtocol;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u001c\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/performance/core/screentracker/ScreenPerformanceTracker;", "", "()V", "TAG", "", "logger", "Lcom/deliveryhero/performance/core/screentracker/ScreenPerformanceLogger;", "performanceTracker", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "cancel", "", "params", "Lcom/deliveryhero/performance/core/screentracker/ScreenPerformanceParams;", "trace", "init", "start", "screenName", "screenType", "stop", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenPerformanceTracker {
    @NotNull
    public static final ScreenPerformanceTracker INSTANCE = new ScreenPerformanceTracker();
    @NotNull
    private static final String TAG = "ScreenPerformanceTracker";
    @Nullable
    private static ScreenPerformanceLogger logger;
    private static PerformanceTrackingManager performanceTracker;

    private ScreenPerformanceTracker() {
    }

    @JvmStatic
    public static final void cancel(@NotNull ScreenPerformanceParams screenPerformanceParams) {
        Intrinsics.checkNotNullParameter(screenPerformanceParams, NativeProtocol.WEB_DIALOG_PARAMS);
        cancel(screenPerformanceParams.getTrace());
    }

    @JvmStatic
    public static final void init(@NotNull PerformanceTrackingManager performanceTrackingManager, @Nullable ScreenPerformanceLogger screenPerformanceLogger) {
        Intrinsics.checkNotNullParameter(performanceTrackingManager, "performanceTracker");
        performanceTracker = performanceTrackingManager;
        logger = screenPerformanceLogger;
    }

    public static /* synthetic */ void init$default(PerformanceTrackingManager performanceTrackingManager, ScreenPerformanceLogger screenPerformanceLogger, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            screenPerformanceLogger = null;
        }
        init(performanceTrackingManager, screenPerformanceLogger);
    }

    @JvmStatic
    public static final void start(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "trace");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "screenType");
        String traceName = ExtensionsKt.toTraceName(str);
        PerformanceTrackingManager performanceTrackingManager = performanceTracker;
        PerformanceTrackingManager performanceTrackingManager2 = null;
        if (performanceTrackingManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
            performanceTrackingManager = null;
        }
        performanceTrackingManager.startTrace(traceName);
        String format = String.format(ScreenTraceAttribute.attValue, Arrays.copyOf(new Object[]{str3, str2}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        PerformanceTrackingManager performanceTrackingManager3 = performanceTracker;
        if (performanceTrackingManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
        } else {
            performanceTrackingManager2 = performanceTrackingManager3;
        }
        performanceTrackingManager2.addTraceAttribute(traceName, ScreenTraceAttribute.INSTANCE.getName(), format);
        ScreenPerformanceLogger screenPerformanceLogger = logger;
        if (screenPerformanceLogger != null) {
            screenPerformanceLogger.log(TAG + " start trace_name=" + traceName);
        }
    }

    @JvmStatic
    public static final void stop(@NotNull ScreenPerformanceParams screenPerformanceParams) {
        Intrinsics.checkNotNullParameter(screenPerformanceParams, NativeProtocol.WEB_DIALOG_PARAMS);
        stop(screenPerformanceParams.getTrace());
    }

    @JvmStatic
    public static final void cancel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "trace");
        String traceName = ExtensionsKt.toTraceName(str);
        PerformanceTrackingManager performanceTrackingManager = performanceTracker;
        if (performanceTrackingManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
            performanceTrackingManager = null;
        }
        performanceTrackingManager.cancelTrace(traceName);
        ScreenPerformanceLogger screenPerformanceLogger = logger;
        if (screenPerformanceLogger != null) {
            screenPerformanceLogger.log(TAG + "  cancel trace_name=" + traceName);
        }
    }

    @JvmStatic
    public static final void stop(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "trace");
        String traceName = ExtensionsKt.toTraceName(str);
        PerformanceTrackingManager performanceTrackingManager = performanceTracker;
        if (performanceTrackingManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
            performanceTrackingManager = null;
        }
        performanceTrackingManager.stopTrace(traceName);
        ScreenPerformanceLogger screenPerformanceLogger = logger;
        if (screenPerformanceLogger != null) {
            screenPerformanceLogger.log(TAG + "  end trace_name=" + traceName);
        }
    }

    @JvmStatic
    public static final void start(@NotNull ScreenPerformanceParams screenPerformanceParams) {
        Intrinsics.checkNotNullParameter(screenPerformanceParams, NativeProtocol.WEB_DIALOG_PARAMS);
        start(screenPerformanceParams.getTrace(), screenPerformanceParams.getScreenName(), screenPerformanceParams.getScreenType());
    }
}
