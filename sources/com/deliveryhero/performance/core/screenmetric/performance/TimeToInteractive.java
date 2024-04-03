package com.deliveryhero.performance.core.screenmetric.performance;

import android.app.Activity;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.deliveryhero.performance.core.analytics.Metric;
import com.deliveryhero.performance.core.screenmetric.PerformanceExtensionKt;
import com.deliveryhero.performance.core.screenmetric.PerformanceMeasurableScreen;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0019\u0010\"\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0017\u0010%\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010&R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/TimeToInteractive;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "TTI_METRIC_NAME", "metrics", "Ljava/util/HashMap;", "Lcom/deliveryhero/performance/core/analytics/Metric;", "Lkotlin/collections/HashMap;", "appendMetric", "", "screenName", "metricDuration", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "isMetricRunning", "", "metric", "isOnUiThread", "shouldStopActivityMetric", "fragment", "Landroidx/fragment/app/Fragment;", "start", "screen", "Lcom/deliveryhero/performance/core/screenmetric/PerformanceMeasurableScreen;", "startActivity", "activity", "Landroid/app/Activity;", "startFragment", "stop", "stopActivityMetric", "stopFragmentMetric", "stopMetric", "(Lcom/deliveryhero/performance/core/analytics/Metric;)Ljava/lang/Long;", "stopRecord", "stopScreenMetric", "(Ljava/lang/String;)Ljava/lang/Long;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TimeToInteractive {
    @NotNull
    public static final TimeToInteractive INSTANCE = new TimeToInteractive();
    private static final String TAG = TimeToInteractive.class.getSimpleName();
    @NotNull
    public static final String TTI_METRIC_NAME = "tti_ms";
    @NotNull
    private static final HashMap<String, Metric> metrics = new HashMap<>();

    private TimeToInteractive() {
    }

    private final void appendMetric(String str, Long l11) {
        if (l11 != null) {
            ScreenPerfMetricContainer.INSTANCE.addMetricToScreen$core_release(str, TTI_METRIC_NAME, new MetricMetaData(l11.longValue(), System.currentTimeMillis()));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot append TTI metric to ");
        sb2.append(str);
        sb2.append(", metric.duration doesn't exist!");
    }

    private final boolean isMetricRunning(Metric metric) {
        if (metric == null) {
            return false;
        }
        return metric.isRunning();
    }

    private final boolean isOnUiThread() {
        return Looper.getMainLooper().isCurrentThread();
    }

    private final boolean shouldStopActivityMetric(Fragment fragment) {
        Set<String> keySet = metrics.keySet();
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        return keySet.contains(PerformanceExtensionKt.getScreenName((Activity) requireActivity));
    }

    private final void startActivity(Activity activity) {
        start(PerformanceExtensionKt.getScreenName(activity));
    }

    private final void startFragment(Fragment fragment) {
        start(PerformanceExtensionKt.getScreenName(fragment));
    }

    private final void stopActivityMetric(Activity activity) {
        String screenName = PerformanceExtensionKt.getScreenName(activity);
        appendMetric(screenName, stopScreenMetric(screenName));
    }

    private final void stopFragmentMetric(Fragment fragment) {
        String str;
        if (shouldStopActivityMetric(fragment)) {
            FragmentActivity requireActivity = fragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
            str = PerformanceExtensionKt.getScreenName((Activity) requireActivity);
        } else {
            str = PerformanceExtensionKt.getScreenName(fragment);
        }
        appendMetric(PerformanceExtensionKt.getScreenName(fragment), stopScreenMetric(str));
    }

    private final Long stopMetric(Metric metric) {
        if (metric == null) {
            return null;
        }
        metric.stop();
        return metric.duration();
    }

    private final Long stopScreenMetric(String str) {
        Metric remove = metrics.remove(str);
        if (isMetricRunning(remove)) {
            return stopMetric(remove);
        }
        String str2 = TAG;
        Log.e(str2, "TTI metric hasn't been started for " + str + ", cannot stop metric!");
        return null;
    }

    public final void start(@NotNull PerformanceMeasurableScreen performanceMeasurableScreen) {
        Intrinsics.checkNotNullParameter(performanceMeasurableScreen, "screen");
        if (!isOnUiThread()) {
            throw new IllegalStateException("TTI metric start must be called from UI thread!".toString());
        } else if (performanceMeasurableScreen instanceof Activity) {
            startActivity((Activity) performanceMeasurableScreen);
        } else if (performanceMeasurableScreen instanceof Fragment) {
            startFragment((Fragment) performanceMeasurableScreen);
        } else {
            throw new IllegalStateException("Only Activities and Fragments should implement PerformanceMeasurableScreen");
        }
    }

    public final void stop(@NotNull PerformanceMeasurableScreen performanceMeasurableScreen) {
        Intrinsics.checkNotNullParameter(performanceMeasurableScreen, "screen");
        if (!isOnUiThread()) {
            throw new IllegalStateException("TTI metric stop must be called from UI thread!".toString());
        } else if (performanceMeasurableScreen instanceof Activity) {
            stopActivityMetric((Activity) performanceMeasurableScreen);
        } else if (performanceMeasurableScreen instanceof Fragment) {
            stopFragmentMetric((Fragment) performanceMeasurableScreen);
        } else {
            throw new IllegalStateException("Only Activities and Fragments should implement PerformanceMeasurableScreen");
        }
    }

    public final void stopRecord(@NotNull PerformanceMeasurableScreen performanceMeasurableScreen) {
        String str;
        Intrinsics.checkNotNullParameter(performanceMeasurableScreen, "screen");
        if (performanceMeasurableScreen instanceof Activity) {
            str = PerformanceExtensionKt.getScreenName((Activity) performanceMeasurableScreen);
        } else if (performanceMeasurableScreen instanceof Fragment) {
            str = PerformanceExtensionKt.getScreenName((Fragment) performanceMeasurableScreen);
        } else {
            throw new IllegalStateException("Only Activities and Fragments should implement PerformanceMeasurableScreen");
        }
        stopScreenMetric(str);
    }

    private final void start(String str) {
        HashMap<String, Metric> hashMap = metrics;
        if (isMetricRunning(hashMap.get(str))) {
            String str2 = TAG;
            Log.e(str2, "Cannot start TTI metric for " + str + ",metric is already running for this screen!");
            return;
        }
        Metric metric = new Metric();
        metric.start();
        hashMap.put(str, metric);
    }
}
