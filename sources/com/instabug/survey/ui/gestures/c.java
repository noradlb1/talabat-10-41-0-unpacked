package com.instabug.survey.ui.gestures;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f52514a;

    public c(View view) {
        this.f52514a = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.f52514a.getLayoutParams();
        layoutParams.height = intValue;
        this.f52514a.setLayoutParams(layoutParams);
    }
}
