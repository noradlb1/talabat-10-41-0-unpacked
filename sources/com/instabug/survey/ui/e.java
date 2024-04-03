package com.instabug.survey.ui;

import android.animation.ValueAnimator;
import android.view.ViewGroup;

class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f52503a;

    public e(g gVar) {
        this.f52503a = gVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.f52503a.f52510k.getLayoutParams();
        layoutParams.height = intValue;
        this.f52503a.f52510k.setLayoutParams(layoutParams);
    }
}
