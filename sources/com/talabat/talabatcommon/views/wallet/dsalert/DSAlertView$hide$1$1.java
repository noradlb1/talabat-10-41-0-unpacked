package com.talabat.talabatcommon.views.wallet.dsalert;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "value", "Landroid/animation/ValueAnimator;", "onAnimationUpdate"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DSAlertView$hide$1$1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DSAlertView f11912a;

    public DSAlertView$hide$1$1(DSAlertView dSAlertView) {
        this.f11912a = dSAlertView;
    }

    public final void onAnimationUpdate(@NotNull ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "value");
        DSAlertView dSAlertView = this.f11912a;
        ViewGroup.LayoutParams layoutParams = dSAlertView.getLayoutParams();
        if (layoutParams != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                layoutParams.height = ((Integer) animatedValue).intValue();
                dSAlertView.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
