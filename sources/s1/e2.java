package s1;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

public final /* synthetic */ class e2 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener f11614a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f11615b;

    public /* synthetic */ e2(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.f11614a = viewPropertyAnimatorUpdateListener;
        this.f11615b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f11614a.onAnimationUpdate(this.f11615b);
    }
}
