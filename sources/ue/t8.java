package ue;

import android.animation.ValueAnimator;
import com.talabat.HomeScreenMap;

public final /* synthetic */ class t8 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f57756a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f57757b;

    public /* synthetic */ t8(HomeScreenMap homeScreenMap, ValueAnimator valueAnimator) {
        this.f57756a = homeScreenMap;
        this.f57757b = valueAnimator;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        HomeScreenMap.m9461animtLocationBtnWhileDrag$lambda24(this.f57756a, this.f57757b, valueAnimator);
    }
}
