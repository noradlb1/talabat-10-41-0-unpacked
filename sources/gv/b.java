package gv;

import android.animation.ValueAnimator;
import android.view.View;
import com.talabat.talabatcommon.utils.AnimationHelper;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f62123a;

    public /* synthetic */ b(View view) {
        this.f62123a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AnimationHelper.DefaultImpls.m10941adjustViewHeight$lambda0(this.f62123a, valueAnimator);
    }
}
