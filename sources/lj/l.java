package lj;

import android.animation.ValueAnimator;
import android.view.View;
import com.talabat.darkstores.feature.product.views.QuantityPopAnimator;

public final /* synthetic */ class l implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f57020a;

    public /* synthetic */ l(View view) {
        this.f57020a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        QuantityPopAnimator.m10057animate$lambda2$lambda1(this.f57020a, valueAnimator);
    }
}
