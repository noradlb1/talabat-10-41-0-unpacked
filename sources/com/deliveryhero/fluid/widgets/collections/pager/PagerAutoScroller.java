package com.deliveryhero.fluid.widgets.collections.pager;

import c5.c;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/pager/PagerAutoScroller;", "", "pagerWidget", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerBaseWidget;", "delayInMillis", "", "(Lcom/deliveryhero/fluid/widgets/collections/pager/PagerBaseWidget;J)V", "onPageChangeCallbackToHandleManualScroll", "com/deliveryhero/fluid/widgets/collections/pager/PagerAutoScroller$onPageChangeCallbackToHandleManualScroll$1", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerAutoScroller$onPageChangeCallbackToHandleManualScroll$1;", "scrollToNextItemRunnable", "Ljava/lang/Runnable;", "timer", "Ljava/util/Timer;", "createTimerTaskToScroll", "com/deliveryhero/fluid/widgets/collections/pager/PagerAutoScroller$createTimerTaskToScroll$1", "()Lcom/deliveryhero/fluid/widgets/collections/pager/PagerAutoScroller$createTimerTaskToScroll$1;", "disable", "", "enable", "startScrolling", "stopScrolling", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PagerAutoScroller {
    private final long delayInMillis;
    @NotNull
    private final PagerAutoScroller$onPageChangeCallbackToHandleManualScroll$1 onPageChangeCallbackToHandleManualScroll = new PagerAutoScroller$onPageChangeCallbackToHandleManualScroll$1(this);
    /* access modifiers changed from: private */
    @NotNull
    public final PagerBaseWidget pagerWidget;
    /* access modifiers changed from: private */
    @NotNull
    public final Runnable scrollToNextItemRunnable = new c(this);
    @Nullable
    private Timer timer;

    public PagerAutoScroller(@NotNull PagerBaseWidget pagerBaseWidget, long j11) {
        Intrinsics.checkNotNullParameter(pagerBaseWidget, "pagerWidget");
        this.pagerWidget = pagerBaseWidget;
        this.delayInMillis = j11;
    }

    private final PagerAutoScroller$createTimerTaskToScroll$1 createTimerTaskToScroll() {
        return new PagerAutoScroller$createTimerTaskToScroll$1(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: scrollToNextItemRunnable$lambda-0  reason: not valid java name */
    public static final void m8212scrollToNextItemRunnable$lambda0(PagerAutoScroller pagerAutoScroller) {
        Intrinsics.checkNotNullParameter(pagerAutoScroller, "this$0");
        pagerAutoScroller.pagerWidget.getInternalPager().setCurrentItem((pagerAutoScroller.pagerWidget.getInternalPager().getCurrentItem() + 1) % pagerAutoScroller.pagerWidget.getAdapter().getItemCount(), true);
    }

    public final void disable() {
        stopScrolling();
        this.pagerWidget.getInternalPager().unregisterOnPageChangeCallback(this.onPageChangeCallbackToHandleManualScroll);
    }

    public final void enable() {
        this.pagerWidget.getInternalPager().registerOnPageChangeCallback(this.onPageChangeCallbackToHandleManualScroll);
    }

    public final void startScrolling() {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
        }
        Timer timer3 = new Timer();
        PagerAutoScroller$createTimerTaskToScroll$1 createTimerTaskToScroll = createTimerTaskToScroll();
        long j11 = this.delayInMillis;
        timer3.schedule(createTimerTaskToScroll, j11, j11);
        this.timer = timer3;
    }

    public final void stopScrolling() {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
        }
    }
}
