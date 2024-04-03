package com.instabug.library.ui.custom;

import android.animation.Animator;
import android.view.animation.Interpolator;
import com.instabug.library.ui.custom.MaterialMenuDrawable;

public interface MaterialMenu {
    void animateIconState(MaterialMenuDrawable.IconState iconState);

    MaterialMenuDrawable.IconState getIconState();

    void setAnimationListener(Animator.AnimatorListener animatorListener);

    void setColor(int i11);

    void setIconState(MaterialMenuDrawable.IconState iconState);

    void setInterpolator(Interpolator interpolator);

    void setRTLEnabled(boolean z11);

    void setTransformationDuration(int i11);

    MaterialMenuDrawable.IconState setTransformationOffset(MaterialMenuDrawable.AnimationState animationState, float f11);

    void setVisible(boolean z11);
}
