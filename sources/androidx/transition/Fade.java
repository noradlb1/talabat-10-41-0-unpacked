package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;

public class Fade extends Visibility {
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    public static class FadeAnimatorListener extends AnimatorListenerAdapter {
        private boolean mLayerTypeChanged = false;
        private final View mView;

        public FadeAnimatorListener(View view) {
            this.mView = view;
        }

        public void onAnimationEnd(Animator animator) {
            ViewUtils.h(this.mView, 1.0f);
            if (this.mLayerTypeChanged) {
                this.mView.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (ViewCompat.hasOverlappingRendering(this.mView) && this.mView.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, (Paint) null);
            }
        }
    }

    public Fade(int i11) {
        setMode(i11);
    }

    private Animator createAnimation(final View view, float f11, float f12) {
        if (f11 == f12) {
            return null;
        }
        ViewUtils.h(view, f11);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ViewUtils.f37822a, new float[]{f12});
        ofFloat.addListener(new FadeAnimatorListener(view));
        addListener(new TransitionListenerAdapter() {
            public void onTransitionEnd(@NonNull Transition transition) {
                ViewUtils.h(view, 1.0f);
                ViewUtils.a(view);
                transition.removeListener(this);
            }
        });
        return ofFloat;
    }

    private static float getStartAlpha(TransitionValues transitionValues, float f11) {
        Float f12;
        if (transitionValues == null || (f12 = (Float) transitionValues.values.get(PROPNAME_TRANSITION_ALPHA)) == null) {
            return f11;
        }
        return f12.floatValue();
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put(PROPNAME_TRANSITION_ALPHA, Float.valueOf(ViewUtils.c(transitionValues.view)));
    }

    @Nullable
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f11 = 0.0f;
        float startAlpha = getStartAlpha(transitionValues, 0.0f);
        if (startAlpha != 1.0f) {
            f11 = startAlpha;
        }
        return createAnimation(view, f11, 1.0f);
    }

    @Nullable
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.e(view);
        return createAnimation(view, getStartAlpha(transitionValues, 1.0f), 0.0f);
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f37785f);
        setMode(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, getMode()));
        obtainStyledAttributes.recycle();
    }
}
