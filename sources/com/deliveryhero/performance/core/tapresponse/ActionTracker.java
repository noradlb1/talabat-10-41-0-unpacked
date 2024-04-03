package com.deliveryhero.performance.core.tapresponse;

import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.FrameMetrics;
import androidx.annotation.RequiresApi;
import com.deliveryhero.performance.core.screenmetric.ScreenMetricParent;
import com.deliveryhero.performance.core.screenmetric.ScreenMetricTime;
import com.deliveryhero.performance.core.screenmetric.ScreenMetricTimeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0003J\u0015\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\nH\u0000¢\u0006\u0002\b\u001aJ\u001d\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/ActionTracker;", "", "()V", "frameMetricsHandler", "Landroid/os/Handler;", "getFrameMetricsHandler", "()Landroid/os/Handler;", "frameMetricsHandler$delegate", "Lkotlin/Lazy;", "lastPausedActivity", "", "getLastPausedActivity$core_release", "()Ljava/lang/String;", "setLastPausedActivity$core_release", "(Ljava/lang/String;)V", "screenCreationTimes", "", "", "reportMetrics", "", "frameMetrics", "Landroid/view/FrameMetrics;", "actionRecorded", "Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricParent$Builder;", "reportScreenGetCreated", "screenName", "reportScreenGetCreated$core_release", "reportScreenStartMetrics", "screenSimpleName", "viewUpdateRunner", "Lcom/deliveryhero/performance/core/tapresponse/OnViewUpdateRunner;", "reportScreenStartMetrics$core_release", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActionTracker {
    @NotNull
    public static final ActionTracker INSTANCE = new ActionTracker();
    @NotNull
    private static final Lazy frameMetricsHandler$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, ActionTracker$frameMetricsHandler$2.INSTANCE);
    @Nullable
    private static String lastPausedActivity;
    @NotNull
    private static final Map<String, Long> screenCreationTimes = new LinkedHashMap();

    private ActionTracker() {
    }

    /* access modifiers changed from: private */
    public final Handler getFrameMetricsHandler() {
        return (Handler) frameMetricsHandler$delegate.getValue();
    }

    /* access modifiers changed from: private */
    @RequiresApi(26)
    public final void reportMetrics(FrameMetrics frameMetrics, ScreenMetricParent.Builder builder) {
        Object obj;
        FrameMetrics frameMetrics2 = frameMetrics;
        ScreenMetricParent.Builder builder2 = builder;
        if (builder2 != null) {
            ScreenMetricParent build = builder2.build(frameMetrics2);
            if (builder.getSourceScreenChosenName() != null || !(build instanceof TapResponseTime)) {
                obj = builder2.build(frameMetrics2);
            } else {
                obj = TapResponseTime.copy$default((TapResponseTime) build, (ScreenMetricTime) null, lastPausedActivity, 0, 0, 0, 0, 0, 125, (Object) null);
            }
            if (obj instanceof TapResponseTime) {
                TapResponseTimeKt.reportTapResponseMetric((TapResponseTime) obj);
            } else if (obj instanceof ScreenMetricTime) {
                ScreenMetricTimeKt.reportScreenMetric((ScreenMetricTime) obj);
            }
        }
    }

    @Nullable
    public final String getLastPausedActivity$core_release() {
        return lastPausedActivity;
    }

    public final void reportScreenGetCreated$core_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        screenCreationTimes.put(str, Long.valueOf(SystemClock.uptimeMillis()));
    }

    public final void reportScreenStartMetrics$core_release(@NotNull String str, @NotNull OnViewUpdateRunner onViewUpdateRunner) {
        long j11;
        ScreenMetricParent.Builder builder;
        Intrinsics.checkNotNullParameter(str, "screenSimpleName");
        Intrinsics.checkNotNullParameter(onViewUpdateRunner, "viewUpdateRunner");
        if (Build.VERSION.SDK_INT >= 26) {
            Long remove = screenCreationTimes.remove(str);
            if (remove == null) {
                j11 = SystemClock.uptimeMillis();
            } else {
                j11 = remove.longValue();
            }
            ScreenMetricParent.Builder currentTap = TapTracker.INSTANCE.getCurrentTap();
            if (currentTap == null) {
                builder = null;
            } else {
                builder = ScreenMetricParent.Builder.copy$default(currentTap, (Long) null, (Long) null, (Long) null, Long.valueOf(j11), str, (String) null, 39, (Object) null);
            }
            if (builder == null) {
                builder = new ScreenMetricParent.Builder((Long) null, (Long) null, (Long) null, Long.valueOf(j11), str, (String) null, 39, (DefaultConstructorMarker) null);
            }
            onViewUpdateRunner.runOnViewsUpdated(new ActionTracker$reportScreenStartMetrics$1(builder));
        }
    }

    public final void setLastPausedActivity$core_release(@Nullable String str) {
        lastPausedActivity = str;
    }
}
