package com.deliveryhero.performance.core.screenmetric;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.deliveryhero.performance.core.screenmetric.performance.PerformanceMetaData;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeTracer;
import com.deliveryhero.performance.core.screenmetric.performance.ScreenPerfMetricContainer;
import com.deliveryhero.performance.core.screenmetric.performance.ScreenPerformanceTrace;
import com.deliveryhero.performance.core.screenmetric.performance.TimeToInteractive;
import com.deliveryhero.performance.core.screenmetric.rendering.FrameMetricsAppender;
import com.deliveryhero.performance.core.screenmetric.rendering.FrameMetricsRecorder;
import com.deliveryhero.performance.core.screenmetric.rendering.ScreenFrameMetric;
import com.deliveryhero.performance.core.tapresponse.ActionTracker;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/FragmentMetricsLifecycleCallback;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "excludeList", "", "", "screenPerformanceTrace", "Lcom/deliveryhero/performance/core/screenmetric/performance/ScreenPerformanceTrace;", "frameMetricsRecorder", "Lcom/deliveryhero/performance/core/screenmetric/rendering/FrameMetricsRecorder;", "richContentLoadTimeTracer", "Lcom/deliveryhero/performance/core/screenmetric/performance/RichContentLoadTimeTracer;", "(Ljava/util/Set;Lcom/deliveryhero/performance/core/screenmetric/performance/ScreenPerformanceTrace;Lcom/deliveryhero/performance/core/screenmetric/rendering/FrameMetricsRecorder;Lcom/deliveryhero/performance/core/screenmetric/performance/RichContentLoadTimeTracer;)V", "clearTimeToInteractiveMetric", "", "fragment", "Landroidx/fragment/app/Fragment;", "getScreenNameFromFragment", "onFragmentAttached", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "context", "Landroid/content/Context;", "onFragmentCreated", "savedInstanceState", "Landroid/os/Bundle;", "onFragmentPaused", "onFragmentResumed", "onFragmentStarted", "onFragmentStopped", "startTimeToInteractiveMetric", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FragmentMetricsLifecycleCallback extends FragmentManager.FragmentLifecycleCallbacks {
    @NotNull
    private final Set<String> excludeList;
    @NotNull
    private final FrameMetricsRecorder frameMetricsRecorder;
    @Nullable
    private final RichContentLoadTimeTracer richContentLoadTimeTracer;
    @NotNull
    private final ScreenPerformanceTrace screenPerformanceTrace;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FragmentMetricsLifecycleCallback(Set set, ScreenPerformanceTrace screenPerformanceTrace2, FrameMetricsRecorder frameMetricsRecorder2, RichContentLoadTimeTracer richContentLoadTimeTracer2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? SetsKt__SetsKt.emptySet() : set, screenPerformanceTrace2, frameMetricsRecorder2, (i11 & 8) != 0 ? null : richContentLoadTimeTracer2);
    }

    private final void clearTimeToInteractiveMetric(Fragment fragment) {
        if (fragment instanceof PerformanceMeasurableScreen) {
            TimeToInteractive.INSTANCE.stopRecord((PerformanceMeasurableScreen) fragment);
        }
    }

    private final String getScreenNameFromFragment(Fragment fragment) {
        return PerformanceExtensionKt.getScreenName(fragment);
    }

    private final void startTimeToInteractiveMetric(Fragment fragment) {
        if (fragment instanceof PerformanceMeasurableScreen) {
            TimeToInteractive.INSTANCE.start((PerformanceMeasurableScreen) fragment);
        }
    }

    public void onFragmentAttached(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        Intrinsics.checkNotNullParameter(context, "context");
        ActionTracker.INSTANCE.reportScreenGetCreated$core_release(PerformanceExtensionKt.getScreenName(fragment));
        startTimeToInteractiveMetric(fragment);
        super.onFragmentAttached(fragmentManager, fragment, context);
    }

    public void onFragmentCreated(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        this.screenPerformanceTrace.start(getScreenNameFromFragment(fragment));
        super.onFragmentCreated(fragmentManager, fragment, bundle);
    }

    public void onFragmentPaused(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentPaused(fragmentManager, fragment);
        String screenNameFromFragment = getScreenNameFromFragment(fragment);
        ScreenFrameMetric stopFragment = this.frameMetricsRecorder.stopFragment(fragment);
        if (stopFragment != null) {
            FrameMetricsAppender.INSTANCE.appendFrameMetrics(screenNameFromFragment, stopFragment);
        }
        RichContentLoadTimeTracer richContentLoadTimeTracer2 = this.richContentLoadTimeTracer;
        if (richContentLoadTimeTracer2 != null) {
            richContentLoadTimeTracer2.reportImageLoadingTimeTrace(screenNameFromFragment);
        }
    }

    public void onFragmentResumed(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentResumed(fragmentManager, fragment);
        this.frameMetricsRecorder.startFragment(fragment);
    }

    public void onFragmentStarted(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentStarted(fragmentManager, fragment);
        String screenNameFromFragment = getScreenNameFromFragment(fragment);
        if (!this.excludeList.contains(screenNameFromFragment)) {
            this.screenPerformanceTrace.start(screenNameFromFragment);
        }
    }

    public void onFragmentStopped(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentStopped(fragmentManager, fragment);
        String screenNameFromFragment = getScreenNameFromFragment(fragment);
        if (!this.excludeList.contains(screenNameFromFragment)) {
            PerformanceMetaData popAllMetadataForScreenAndDeactivate$core_release = ScreenPerfMetricContainer.INSTANCE.popAllMetadataForScreenAndDeactivate$core_release(screenNameFromFragment);
            ScreenPerformanceTrace screenPerformanceTrace2 = this.screenPerformanceTrace;
            String name2 = fragment.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "f.javaClass.name");
            screenPerformanceTrace2.stop(screenNameFromFragment, name2, popAllMetadataForScreenAndDeactivate$core_release);
            clearTimeToInteractiveMetric(fragment);
        }
    }

    public FragmentMetricsLifecycleCallback(@NotNull Set<String> set, @NotNull ScreenPerformanceTrace screenPerformanceTrace2, @NotNull FrameMetricsRecorder frameMetricsRecorder2, @Nullable RichContentLoadTimeTracer richContentLoadTimeTracer2) {
        Intrinsics.checkNotNullParameter(set, "excludeList");
        Intrinsics.checkNotNullParameter(screenPerformanceTrace2, "screenPerformanceTrace");
        Intrinsics.checkNotNullParameter(frameMetricsRecorder2, "frameMetricsRecorder");
        this.excludeList = set;
        this.screenPerformanceTrace = screenPerformanceTrace2;
        this.frameMetricsRecorder = frameMetricsRecorder2;
        this.richContentLoadTimeTracer = richContentLoadTimeTracer2;
    }
}
