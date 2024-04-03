package com.deliveryhero.performance.core.tapresponse;

import android.view.Choreographer;
import android.view.View;
import android.view.Window;
import com.deliveryhero.performance.core.screenmetric.ScreenMetricParent;
import curtains.WindowsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ActionTracker$reportScreenStartMetrics$1 extends Lambda implements Function1<View, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ScreenMetricParent.Builder f30380g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionTracker$reportScreenStartMetrics$1(ScreenMetricParent.Builder builder) {
        super(1);
        this.f30380g = builder;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m8237invoke$lambda0(View view, ScreenMetricParent.Builder builder, long j11) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(builder, "$actionRecorded");
        CurrentFrameMetricsListener currentFrameMetricsListener = new CurrentFrameMetricsListener(j11, new ActionTracker$reportScreenStartMetrics$1$1$callback$1(builder));
        Window phoneWindow = WindowsKt.getPhoneWindow(view);
        if (phoneWindow != null) {
            phoneWindow.addOnFrameMetricsAvailableListener(currentFrameMetricsListener, ActionTracker.INSTANCE.getFrameMetricsHandler());
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Choreographer.getInstance().postFrameCallback(new a(view, this.f30380g));
    }
}
