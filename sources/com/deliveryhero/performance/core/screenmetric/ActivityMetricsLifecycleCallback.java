package com.deliveryhero.performance.core.screenmetric;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.FrameMetricsAggregator;
import com.deliveryhero.performance.core.screenmetric.performance.PerformanceMetaData;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeTracer;
import com.deliveryhero.performance.core.screenmetric.performance.ScreenPerfMetricContainer;
import com.deliveryhero.performance.core.screenmetric.performance.ScreenPerformanceTrace;
import com.deliveryhero.performance.core.screenmetric.performance.TimeToInteractive;
import com.deliveryhero.performance.core.screenmetric.rendering.FrameMetricsAppender;
import com.deliveryhero.performance.core.screenmetric.rendering.FrameMetricsRecorder;
import com.deliveryhero.performance.core.screenmetric.rendering.ScreenFrameMetric;
import com.deliveryhero.performance.core.tapresponse.ActionTracker;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\rj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011`\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/ActivityMetricsLifecycleCallback;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "screenPerformanceTrace", "Lcom/deliveryhero/performance/core/screenmetric/performance/ScreenPerformanceTrace;", "excludeList", "", "", "isManualActivityPreCreated", "", "richContentLoadTimeTracer", "Lcom/deliveryhero/performance/core/screenmetric/performance/RichContentLoadTimeTracer;", "(Lcom/deliveryhero/performance/core/screenmetric/performance/ScreenPerformanceTrace;Ljava/util/Set;ZLcom/deliveryhero/performance/core/screenmetric/performance/RichContentLoadTimeTracer;)V", "activityFragmentMetricsLifecycleMap", "Ljava/util/HashMap;", "Lcom/deliveryhero/performance/core/screenmetric/FragmentMetricsLifecycleCallback;", "Lkotlin/collections/HashMap;", "activityFrameProvidersMap", "Lcom/deliveryhero/performance/core/screenmetric/rendering/FrameMetricsRecorder;", "appendFrameMetrics", "", "screenName", "clearTimeToInteractiveMetric", "activity", "Landroid/app/Activity;", "getScreenNameFromActivity", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityPreCreated", "onActivityPreCreatedManual", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "startTimeToInteractiveMetric", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActivityMetricsLifecycleCallback implements Application.ActivityLifecycleCallbacks {
    @NotNull
    private final HashMap<String, FragmentMetricsLifecycleCallback> activityFragmentMetricsLifecycleMap;
    @NotNull
    private final HashMap<String, FrameMetricsRecorder> activityFrameProvidersMap;
    @NotNull
    private final Set<String> excludeList;
    private final boolean isManualActivityPreCreated;
    @Nullable
    private final RichContentLoadTimeTracer richContentLoadTimeTracer;
    @NotNull
    private final ScreenPerformanceTrace screenPerformanceTrace;

    public ActivityMetricsLifecycleCallback(@NotNull ScreenPerformanceTrace screenPerformanceTrace2, @NotNull Set<String> set, boolean z11, @Nullable RichContentLoadTimeTracer richContentLoadTimeTracer2) {
        Intrinsics.checkNotNullParameter(screenPerformanceTrace2, "screenPerformanceTrace");
        Intrinsics.checkNotNullParameter(set, "excludeList");
        this.screenPerformanceTrace = screenPerformanceTrace2;
        this.excludeList = set;
        this.isManualActivityPreCreated = z11;
        this.richContentLoadTimeTracer = richContentLoadTimeTracer2;
        this.activityFrameProvidersMap = new HashMap<>();
        this.activityFragmentMetricsLifecycleMap = new HashMap<>();
    }

    private final void appendFrameMetrics(String str) {
        ScreenFrameMetric screenFrameMetric;
        FrameMetricsRecorder frameMetricsRecorder = this.activityFrameProvidersMap.get(str);
        if (frameMetricsRecorder == null) {
            screenFrameMetric = null;
        } else {
            screenFrameMetric = frameMetricsRecorder.stop();
        }
        if (screenFrameMetric != null) {
            FrameMetricsAppender.INSTANCE.appendFrameMetrics(str, screenFrameMetric);
        }
    }

    private final void clearTimeToInteractiveMetric(Activity activity) {
        if (activity instanceof PerformanceMeasurableScreen) {
            TimeToInteractive.INSTANCE.stopRecord((PerformanceMeasurableScreen) activity);
        }
    }

    private final String getScreenNameFromActivity(Activity activity) {
        return PerformanceExtensionKt.getScreenName(activity);
    }

    private final void startTimeToInteractiveMetric(Activity activity) {
        if (activity instanceof PerformanceMeasurableScreen) {
            TimeToInteractive.INSTANCE.start((PerformanceMeasurableScreen) activity);
        }
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String screenNameFromActivity = getScreenNameFromActivity(activity);
        this.screenPerformanceTrace.start(screenNameFromActivity);
        if (activity instanceof AppCompatActivity) {
            FrameMetricsRecorder frameMetricsRecorder = new FrameMetricsRecorder(activity, (FrameMetricsAggregator) null, 2, (DefaultConstructorMarker) null);
            this.activityFrameProvidersMap.put(screenNameFromActivity, frameMetricsRecorder);
            FragmentMetricsLifecycleCallback fragmentMetricsLifecycleCallback = new FragmentMetricsLifecycleCallback(this.excludeList, this.screenPerformanceTrace, frameMetricsRecorder, this.richContentLoadTimeTracer);
            this.activityFragmentMetricsLifecycleMap.put(screenNameFromActivity, fragmentMetricsLifecycleCallback);
            ((AppCompatActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(fragmentMetricsLifecycleCallback, true);
        }
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        FragmentMetricsLifecycleCallback remove;
        Intrinsics.checkNotNullParameter(activity, "activity");
        String screenNameFromActivity = getScreenNameFromActivity(activity);
        this.activityFrameProvidersMap.remove(screenNameFromActivity);
        if (this.activityFragmentMetricsLifecycleMap.containsKey(screenNameFromActivity) && (remove = this.activityFragmentMetricsLifecycleMap.remove(screenNameFromActivity)) != null) {
            ((AppCompatActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(remove);
        }
        clearTimeToInteractiveMetric(activity);
    }

    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ActionTracker.INSTANCE.setLastPausedActivity$core_release(PerformanceExtensionKt.getScreenName(activity));
    }

    public void onActivityPreCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!this.isManualActivityPreCreated) {
            ActionTracker.INSTANCE.reportScreenGetCreated$core_release(PerformanceExtensionKt.getScreenName(activity));
            startTimeToInteractiveMetric(activity);
        }
    }

    public final void onActivityPreCreatedManual(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.isManualActivityPreCreated) {
            ActionTracker.INSTANCE.reportScreenGetCreated$core_release(PerformanceExtensionKt.getScreenName(activity));
            startTimeToInteractiveMetric(activity);
        }
    }

    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "savedInstanceState");
    }

    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String screenNameFromActivity = getScreenNameFromActivity(activity);
        this.screenPerformanceTrace.start(screenNameFromActivity);
        FrameMetricsRecorder frameMetricsRecorder = this.activityFrameProvidersMap.get(screenNameFromActivity);
        if (frameMetricsRecorder != null) {
            frameMetricsRecorder.start();
        }
    }

    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String screenNameFromActivity = getScreenNameFromActivity(activity);
        appendFrameMetrics(screenNameFromActivity);
        RichContentLoadTimeTracer richContentLoadTimeTracer2 = this.richContentLoadTimeTracer;
        if (richContentLoadTimeTracer2 != null) {
            richContentLoadTimeTracer2.reportImageLoadingTimeTrace(screenNameFromActivity);
        }
        PerformanceMetaData popAllMetadataForScreenAndDeactivate$core_release = ScreenPerfMetricContainer.INSTANCE.popAllMetadataForScreenAndDeactivate$core_release(screenNameFromActivity);
        ScreenPerformanceTrace screenPerformanceTrace2 = this.screenPerformanceTrace;
        String name2 = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name2, "activity.javaClass.name");
        screenPerformanceTrace2.stop(screenNameFromActivity, name2, popAllMetadataForScreenAndDeactivate$core_release);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActivityMetricsLifecycleCallback(ScreenPerformanceTrace screenPerformanceTrace2, Set set, boolean z11, RichContentLoadTimeTracer richContentLoadTimeTracer2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(screenPerformanceTrace2, (i11 & 2) != 0 ? SetsKt__SetsKt.emptySet() : set, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? null : richContentLoadTimeTracer2);
    }
}
