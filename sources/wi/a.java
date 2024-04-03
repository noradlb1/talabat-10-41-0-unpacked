package wi;

import android.animation.ValueAnimator;
import com.talabat.darkstores.feature.cart.views.CartProgressView;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartProgressView f57959a;

    public /* synthetic */ a(CartProgressView cartProgressView) {
        this.f57959a = cartProgressView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        CartProgressView.m9852animateProgress$lambda10$lambda9(this.f57959a, valueAnimator);
    }
}
