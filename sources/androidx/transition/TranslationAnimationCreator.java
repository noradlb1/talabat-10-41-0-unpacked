package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;

class TranslationAnimationCreator {

    public static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final int mStartX;
        private final int mStartY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        public TransitionPositionListener(View view, View view2, int i11, int i12, float f11, float f12) {
            this.mMovingView = view;
            this.mViewInHierarchy = view2;
            this.mStartX = i11 - Math.round(view.getTranslationX());
            this.mStartY = i12 - Math.round(view.getTranslationY());
            this.mTerminalX = f11;
            this.mTerminalY = f12;
            int i13 = R.id.transition_position;
            int[] iArr = (int[]) view2.getTag(i13);
            this.mTransitionPosition = iArr;
            if (iArr != null) {
                view2.setTag(i13, (Object) null);
            }
        }

        public void onAnimationCancel(Animator animator) {
            if (this.mTransitionPosition == null) {
                this.mTransitionPosition = new int[2];
            }
            this.mTransitionPosition[0] = Math.round(((float) this.mStartX) + this.mMovingView.getTranslationX());
            this.mTransitionPosition[1] = Math.round(((float) this.mStartY) + this.mMovingView.getTranslationY());
            this.mViewInHierarchy.setTag(R.id.transition_position, this.mTransitionPosition);
        }

        public void onAnimationPause(Animator animator) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onAnimationResume(Animator animator) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        public void onTransitionCancel(@NonNull Transition transition) {
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
            transition.removeListener(this);
        }

        public void onTransitionPause(@NonNull Transition transition) {
        }

        public void onTransitionResume(@NonNull Transition transition) {
        }

        public void onTransitionStart(@NonNull Transition transition) {
        }
    }

    private TranslationAnimationCreator() {
    }

    @Nullable
    public static Animator a(@NonNull View view, @NonNull TransitionValues transitionValues, int i11, int i12, float f11, float f12, float f13, float f14, @Nullable TimeInterpolator timeInterpolator, @NonNull Transition transition) {
        float f15;
        float f16;
        View view2 = view;
        TransitionValues transitionValues2 = transitionValues;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues2.view.getTag(R.id.transition_position);
        if (iArr != null) {
            f15 = ((float) (iArr[0] - i11)) + translationX;
            f16 = ((float) (iArr[1] - i12)) + translationY;
        } else {
            f15 = f11;
            f16 = f12;
        }
        int round = i11 + Math.round(f15 - translationX);
        int round2 = i12 + Math.round(f16 - translationY);
        view.setTranslationX(f15);
        view.setTranslationY(f16);
        if (f15 == f13 && f16 == f14) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f15, f13}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f16, f14})});
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues2.view, round, round2, translationX, translationY);
        transition.addListener(transitionPositionListener);
        ofPropertyValuesHolder.addListener(transitionPositionListener);
        AnimatorUtils.a(ofPropertyValuesHolder, transitionPositionListener);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
