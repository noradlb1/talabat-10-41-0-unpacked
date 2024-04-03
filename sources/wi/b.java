package wi;

import android.animation.ValueAnimator;
import com.talabat.darkstores.feature.cart.views.CartProgressView;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartProgressView f57960a;

    public /* synthetic */ b(CartProgressView cartProgressView) {
        this.f57960a = cartProgressView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        CartProgressView.m9853createAnimator$lambda5$lambda3(this.f57960a, valueAnimator);
    }
}
