package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

@RequiresApi(21)
class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS = {16843848};

    public static void setBoundsViewOutlineProvider(@NonNull View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    public static void setDefaultAppBarLayoutStateListAnimator(@NonNull View view, float f11) {
        int integer = view.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j11 = (long) integer;
        stateListAnimator.addState(new int[]{16842910, R.attr.state_liftable, -R.attr.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(j11));
        stateListAnimator.addState(new int[]{16842910}, ObjectAnimator.ofFloat(view, "elevation", new float[]{f11}).setDuration(j11));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(0));
        view.setStateListAnimator(stateListAnimator);
    }

    public static void setStateListAnimatorFromAttrs(@NonNull View view, AttributeSet attributeSet, int i11, int i12) {
        Context context = view.getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, STATE_LIST_ANIM_ATTRS, i11, i12, new int[0]);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, obtainStyledAttributes.getResourceId(0, 0)));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
