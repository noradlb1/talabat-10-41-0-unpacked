package com.deliveryhero.performance.core.tapresponse;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.deliveryhero.performance.core.screenmetric.ScreenMetricParent;
import curtains.DispatchState;
import curtains.KeyEventInterceptor;
import curtains.TouchEventInterceptor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t5.c;
import t5.d;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0015H\u0016J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00110\u0015H\u0016R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/TapTracker;", "Lcurtains/TouchEventInterceptor;", "Lcurtains/KeyEventInterceptor;", "()V", "<set-?>", "Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricParent$Builder;", "currentTap", "getCurrentTap", "()Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricParent$Builder;", "handler", "Landroid/os/Handler;", "isTapInProgress", "", "()Z", "setTapInProgress", "(Z)V", "intercept", "Lcurtains/DispatchState;", "keyEvent", "Landroid/view/KeyEvent;", "dispatch", "Lkotlin/Function1;", "motionEvent", "Landroid/view/MotionEvent;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TapTracker implements TouchEventInterceptor, KeyEventInterceptor {
    @NotNull
    public static final TapTracker INSTANCE = new TapTracker();
    @Nullable
    private static ScreenMetricParent.Builder currentTap;
    @NotNull
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static boolean isTapInProgress;

    private TapTracker() {
    }

    /* access modifiers changed from: private */
    /* renamed from: intercept$lambda-0  reason: not valid java name */
    public static final void m8240intercept$lambda0(ScreenMetricParent.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$currentTap");
        currentTap = ScreenMetricParent.Builder.copy$default(builder, (Long) null, (Long) null, Long.valueOf(SystemClock.uptimeMillis()), (Long) null, (String) null, (String) null, 59, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: intercept$lambda-1  reason: not valid java name */
    public static final void m8241intercept$lambda1() {
        ScreenMetricParent.Builder builder;
        ScreenMetricParent.Builder builder2 = currentTap;
        if (builder2 == null) {
            builder = null;
        } else {
            builder = ScreenMetricParent.Builder.copy$default(builder2, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, SourceTracker.INSTANCE.getSourceScreen(), 31, (Object) null);
        }
        currentTap = builder;
        SourceTracker.INSTANCE.setSourceScreen((String) null);
        isTapInProgress = false;
    }

    @Nullable
    public final ScreenMetricParent.Builder getCurrentTap() {
        return currentTap;
    }

    @NotNull
    public DispatchState intercept(@NotNull MotionEvent motionEvent, @NotNull Function1<? super MotionEvent, ? extends DispatchState> function1) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        Intrinsics.checkNotNullParameter(function1, "dispatch");
        boolean z11 = motionEvent.getAction() == 1;
        if (z11) {
            ScreenMetricParent.Builder builder = new ScreenMetricParent.Builder(Long.valueOf(motionEvent.getEventTime()), Long.valueOf(SystemClock.uptimeMillis()), (Long) null, (Long) null, (String) null, (String) null, 60, (DefaultConstructorMarker) null);
            SourceTracker.INSTANCE.setSourceScreen((String) null);
            isTapInProgress = true;
            handler.post(new c(builder));
        }
        DispatchState dispatchState = (DispatchState) function1.invoke(motionEvent);
        if (z11) {
            handler.post(new d());
        }
        return dispatchState;
    }

    public final boolean isTapInProgress() {
        return isTapInProgress;
    }

    public final void setTapInProgress(boolean z11) {
        isTapInProgress = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
        if (r13.isCanceled() == false) goto L_0x0020;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public curtains.DispatchState intercept(@org.jetbrains.annotations.NotNull android.view.KeyEvent r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.view.KeyEvent, ? extends curtains.DispatchState> r14) {
        /*
            r12 = this;
            java.lang.String r0 = "keyEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "dispatch"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            int r0 = r13.getKeyCode()
            r1 = 4
            if (r0 != r1) goto L_0x001f
            int r0 = r13.getAction()
            r1 = 1
            if (r0 != r1) goto L_0x001f
            boolean r0 = r13.isCanceled()
            if (r0 != 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            if (r1 == 0) goto L_0x0044
            long r0 = android.os.SystemClock.uptimeMillis()
            com.deliveryhero.performance.core.screenmetric.ScreenMetricParent$Builder r11 = new com.deliveryhero.performance.core.screenmetric.ScreenMetricParent$Builder
            long r2 = r13.getEventTime()
            java.lang.Long r3 = java.lang.Long.valueOf(r2)
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            java.lang.Long r5 = java.lang.Long.valueOf(r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 56
            r10 = 0
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            currentTap = r11
        L_0x0044:
            java.lang.Object r13 = r14.invoke(r13)
            curtains.DispatchState r13 = (curtains.DispatchState) r13
            r14 = 0
            currentTap = r14
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.performance.core.tapresponse.TapTracker.intercept(android.view.KeyEvent, kotlin.jvm.functions.Function1):curtains.DispatchState");
    }
}
