package c4;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.braze.ui.inappmessage.listeners.SwipeDismissTouchListener;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissTouchListener f39661a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f39662b;

    public /* synthetic */ c(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.f39661a = swipeDismissTouchListener;
        this.f39662b = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f39661a.lambda$performDismiss$0(this.f39662b, valueAnimator);
    }
}
