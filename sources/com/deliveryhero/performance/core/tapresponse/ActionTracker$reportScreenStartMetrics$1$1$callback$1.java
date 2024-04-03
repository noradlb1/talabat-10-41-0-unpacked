package com.deliveryhero.performance.core.tapresponse;

import android.view.FrameMetrics;
import com.deliveryhero.performance.core.screenmetric.ScreenMetricParent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "frameMetrics", "Landroid/view/FrameMetrics;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ActionTracker$reportScreenStartMetrics$1$1$callback$1 extends Lambda implements Function1<FrameMetrics, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ScreenMetricParent.Builder f30381g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionTracker$reportScreenStartMetrics$1$1$callback$1(ScreenMetricParent.Builder builder) {
        super(1);
        this.f30381g = builder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FrameMetrics) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FrameMetrics frameMetrics) {
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        ActionTracker.INSTANCE.reportMetrics(frameMetrics, this.f30381g);
    }
}
