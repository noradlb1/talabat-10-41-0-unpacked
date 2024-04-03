package com.deliveryhero.performance.core.tapresponse;

import android.os.Handler;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.RequiresApi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t5.a;

@RequiresApi(26)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/CurrentFrameMetricsListener;", "Landroid/view/Window$OnFrameMetricsAvailableListener;", "frameTimeNanos", "", "callback", "Lkotlin/Function1;", "Landroid/view/FrameMetrics;", "", "(JLkotlin/jvm/functions/Function1;)V", "mainThreadHandler", "Landroid/os/Handler;", "getMainThreadHandler", "()Landroid/os/Handler;", "mainThreadHandler$delegate", "Lkotlin/Lazy;", "removed", "", "getRemoved", "()Z", "setRemoved", "(Z)V", "onFrameMetricsAvailable", "window", "Landroid/view/Window;", "frameMetrics", "dropCountSinceLastInvocation", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CurrentFrameMetricsListener implements Window.OnFrameMetricsAvailableListener {
    @NotNull
    private final Function1<FrameMetrics, Unit> callback;
    private final long frameTimeNanos;
    @NotNull
    private final Lazy mainThreadHandler$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, CurrentFrameMetricsListener$mainThreadHandler$2.INSTANCE);
    private volatile boolean removed;

    public CurrentFrameMetricsListener(long j11, @NotNull Function1<? super FrameMetrics, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.frameTimeNanos = j11;
        this.callback = function1;
    }

    private final Handler getMainThreadHandler() {
        return (Handler) this.mainThreadHandler$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onFrameMetricsAvailable$lambda-0  reason: not valid java name */
    public static final void m8238onFrameMetricsAvailable$lambda0(Window window, CurrentFrameMetricsListener currentFrameMetricsListener) {
        Intrinsics.checkNotNullParameter(window, "$window");
        Intrinsics.checkNotNullParameter(currentFrameMetricsListener, "this$0");
        window.removeOnFrameMetricsAvailableListener(currentFrameMetricsListener);
    }

    public final boolean getRemoved() {
        return this.removed;
    }

    public void onFrameMetricsAvailable(@NotNull Window window, @NotNull FrameMetrics frameMetrics, int i11) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        if (!this.removed) {
            this.removed = true;
            getMainThreadHandler().post(new a(window, this));
        }
        if (frameMetrics.getMetric(11) == this.frameTimeNanos) {
            this.callback.invoke(frameMetrics);
        }
    }

    public final void setRemoved(boolean z11) {
        this.removed = z11;
    }
}
