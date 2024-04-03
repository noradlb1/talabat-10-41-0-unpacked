package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Explode extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    private int[] mTempLoc = new int[2];

    public Explode() {
        setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float f11, float f12) {
        return (float) Math.sqrt((double) ((f11 * f11) + (f12 * f12)));
    }

    private static float calculateMaxDistance(View view, int i11, int i12) {
        return calculateDistance((float) Math.max(i11, view.getWidth() - i11), (float) Math.max(i12, view.getHeight() - i12));
    }

    private void calculateOut(View view, Rect rect, int[] iArr) {
        int i11;
        int i12;
        View view2 = view;
        view2.getLocationOnScreen(this.mTempLoc);
        int[] iArr2 = this.mTempLoc;
        int i13 = iArr2[0];
        int i14 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            i12 = (view.getWidth() / 2) + i13 + Math.round(view.getTranslationX());
            i11 = (view.getHeight() / 2) + i14 + Math.round(view.getTranslationY());
        } else {
            int centerX = epicenter.centerX();
            i11 = epicenter.centerY();
            i12 = centerX;
        }
        float centerX2 = (float) (rect.centerX() - i12);
        float centerY = (float) (rect.centerY() - i11);
        if (centerX2 == 0.0f && centerY == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float calculateDistance = calculateDistance(centerX2, centerY);
        float calculateMaxDistance = calculateMaxDistance(view2, i12 - i13, i11 - i14);
        iArr[0] = Math.round((centerX2 / calculateDistance) * calculateMaxDistance);
        iArr[1] = Math.round(calculateMaxDistance * (centerY / calculateDistance));
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        view.getLocationOnScreen(this.mTempLoc);
        int[] iArr = this.mTempLoc;
        int i11 = iArr[0];
        int i12 = iArr[1];
        transitionValues.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(i11, i12, view.getWidth() + i11, view.getHeight() + i12));
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    @Nullable
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get(PROPNAME_SCREEN_BOUNDS);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        calculateOut(viewGroup, rect, this.mTempLoc);
        int[] iArr = this.mTempLoc;
        return TranslationAnimationCreator.a(view, transitionValues2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, sDecelerate, this);
    }

    @Nullable
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f11;
        float f12;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.values.get(PROPNAME_SCREEN_BOUNDS);
        int i11 = rect.left;
        int i12 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(R.id.transition_position);
        if (iArr != null) {
            int i13 = iArr[0];
            f12 = ((float) (i13 - rect.left)) + translationX;
            int i14 = iArr[1];
            f11 = ((float) (i14 - rect.top)) + translationY;
            rect.offsetTo(i13, i14);
        } else {
            f12 = translationX;
            f11 = translationY;
        }
        calculateOut(viewGroup, rect, this.mTempLoc);
        int[] iArr2 = this.mTempLoc;
        return TranslationAnimationCreator.a(view, transitionValues, i11, i12, translationX, translationY, f12 + ((float) iArr2[0]), f11 + ((float) iArr2[1]), sAccelerate, this);
    }

    public Explode(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        setPropagation(new CircularPropagation());
    }
}
