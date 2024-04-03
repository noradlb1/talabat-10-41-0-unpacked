package com.deliveryhero.performance.core.screenmetric.performance;

import android.util.DisplayMetrics;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\u00020\f*\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/RichContentLoadTimeTracer;", "", "performanceTrackingManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "richContentLoadTimeRecorder", "Lcom/deliveryhero/performance/core/screenmetric/performance/RichContentLoadTimeRecorder;", "displayMetrics", "Landroid/util/DisplayMetrics;", "(Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;Lcom/deliveryhero/performance/core/screenmetric/performance/RichContentLoadTimeRecorder;Landroid/util/DisplayMetrics;)V", "reportImageLoadingTimeTrace", "", "screenName", "", "toRcltTraceName", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RichContentLoadTimeTracer {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String IMAGE_COUNT = "count";
    @NotNull
    @Deprecated
    public static final String MAX = "max";
    @NotNull
    @Deprecated
    public static final String P50 = "p50";
    @NotNull
    @Deprecated
    public static final String P75 = "p75";
    @NotNull
    @Deprecated
    public static final String P95 = "p95";
    @NotNull
    @Deprecated
    public static final String SCREEN_DENSITY_ATTR = "screen_density";
    /* access modifiers changed from: private */
    @NotNull
    public final DisplayMetrics displayMetrics;
    /* access modifiers changed from: private */
    @NotNull
    public final PerformanceTrackingManager performanceTrackingManager;
    /* access modifiers changed from: private */
    @NotNull
    public final RichContentLoadTimeRecorder richContentLoadTimeRecorder;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/RichContentLoadTimeTracer$Companion;", "", "()V", "IMAGE_COUNT", "", "MAX", "P50", "P75", "P95", "SCREEN_DENSITY_ATTR", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RichContentLoadTimeTracer(@NotNull PerformanceTrackingManager performanceTrackingManager2, @NotNull RichContentLoadTimeRecorder richContentLoadTimeRecorder2, @NotNull DisplayMetrics displayMetrics2) {
        Intrinsics.checkNotNullParameter(performanceTrackingManager2, "performanceTrackingManager");
        Intrinsics.checkNotNullParameter(richContentLoadTimeRecorder2, "richContentLoadTimeRecorder");
        Intrinsics.checkNotNullParameter(displayMetrics2, "displayMetrics");
        this.performanceTrackingManager = performanceTrackingManager2;
        this.richContentLoadTimeRecorder = richContentLoadTimeRecorder2;
        this.displayMetrics = displayMetrics2;
    }

    /* access modifiers changed from: private */
    public final String toRcltTraceName(String str) {
        return Intrinsics.stringPlus("rclt_", str);
    }

    public final void reportImageLoadingTimeTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new RichContentLoadTimeTracer$reportImageLoadingTimeTrace$1(this, str, (Continuation<? super RichContentLoadTimeTracer$reportImageLoadingTimeTrace$1>) null), 2, (Object) null);
    }
}
