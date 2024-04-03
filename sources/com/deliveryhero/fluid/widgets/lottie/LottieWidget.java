package com.deliveryhero.fluid.widgets.lottie;

import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import com.deliveryhero.fluid.widgets.collections.VisibilityObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/fluid/widgets/lottie/LottieWidget;", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/deliveryhero/fluid/widgets/collections/VisibilityObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onViewAppearedOnScreen", "", "reason", "Lcom/deliveryhero/fluid/widgets/collections/VisibilityObserver$Reason;", "onViewDisappearedFromScreen", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LottieWidget extends LottieAnimationView implements VisibilityObserver {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieWidget(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void onViewAppearedOnScreen(@NotNull VisibilityObserver.Reason reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        playAnimation();
    }

    public void onViewDisappearedFromScreen(@NotNull VisibilityObserver.Reason reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        pauseAnimation();
    }
}
