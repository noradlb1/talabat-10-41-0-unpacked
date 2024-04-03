package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;
    @Px
    private int slideDistance = -1;
    private int slideEdge;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i11) {
        this.slideEdge = i11;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i11, @Px int i12) {
        float f11;
        float f12;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i11 == 3) {
            return createTranslationXAnimator(view2, ((float) i12) + translationX, translationX, translationX);
        }
        if (i11 == 5) {
            return createTranslationXAnimator(view2, translationX - ((float) i12), translationX, translationX);
        }
        if (i11 == 48) {
            return createTranslationYAnimator(view2, translationY - ((float) i12), translationY, translationY);
        }
        if (i11 == 80) {
            return createTranslationYAnimator(view2, ((float) i12) + translationY, translationY, translationY);
        }
        if (i11 == 8388611) {
            if (isRtl(view)) {
                f11 = ((float) i12) + translationX;
            } else {
                f11 = translationX - ((float) i12);
            }
            return createTranslationXAnimator(view2, f11, translationX, translationX);
        } else if (i11 == 8388613) {
            if (isRtl(view)) {
                f12 = translationX - ((float) i12);
            } else {
                f12 = ((float) i12) + translationX;
            }
            return createTranslationXAnimator(view2, f12, translationX, translationX);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i11);
        }
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i11, @Px int i12) {
        float f11;
        float f12;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i11 == 3) {
            return createTranslationXAnimator(view2, translationX, translationX - ((float) i12), translationX);
        }
        if (i11 == 5) {
            return createTranslationXAnimator(view2, translationX, ((float) i12) + translationX, translationX);
        }
        if (i11 == 48) {
            return createTranslationYAnimator(view2, translationY, ((float) i12) + translationY, translationY);
        }
        if (i11 == 80) {
            return createTranslationYAnimator(view2, translationY, translationY - ((float) i12), translationY);
        }
        if (i11 == 8388611) {
            if (isRtl(view)) {
                f11 = translationX - ((float) i12);
            } else {
                f11 = ((float) i12) + translationX;
            }
            return createTranslationXAnimator(view2, translationX, f11, translationX);
        } else if (i11 == 8388613) {
            if (isRtl(view)) {
                f12 = ((float) i12) + translationX;
            } else {
                f12 = translationX - ((float) i12);
            }
            return createTranslationXAnimator(view2, translationX, f12, translationX);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i11);
        }
    }

    private static Animator createTranslationXAnimator(final View view, float f11, float f12, final float f13) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f11, f12})});
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(f13);
            }
        });
        return ofPropertyValuesHolder;
    }

    private static Animator createTranslationYAnimator(final View view, float f11, float f12, final float f13) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f11, f12})});
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f13);
            }
        });
        return ofPropertyValuesHolder;
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i11 = this.slideDistance;
        if (i11 != -1) {
            return i11;
        }
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i11) {
        if (i11 >= 0) {
            this.slideDistance = i11;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int i11) {
        this.slideEdge = i11;
    }
}
