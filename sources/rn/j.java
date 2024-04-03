package rn;

import android.animation.ValueAnimator;
import android.view.View;
import com.talabat.feature.pickup.presentation.PickupTooltipViewAnimations;

public final /* synthetic */ class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f62873a;

    public /* synthetic */ j(View view) {
        this.f62873a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        PickupTooltipViewAnimations.m10253animateSlideTo$lambda0(this.f62873a, valueAnimator);
    }
}
