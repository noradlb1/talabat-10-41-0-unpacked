package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class ViewPropertyAnimatorPreHC extends ViewPropertyAnimator {
    private static final int ALPHA = 512;
    private static final int NONE = 0;
    private static final int ROTATION = 16;
    private static final int ROTATION_X = 32;
    private static final int ROTATION_Y = 64;
    private static final int SCALE_X = 4;
    private static final int SCALE_Y = 8;
    private static final int TRANSFORM_MASK = 511;
    private static final int TRANSLATION_X = 1;
    private static final int TRANSLATION_Y = 2;
    private static final int X = 128;
    private static final int Y = 256;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<NameValuesHolder> f52852a = new ArrayList<>();
    private Runnable mAnimationStarter = new Runnable() {
        public void run() {
            ViewPropertyAnimatorPreHC.this.startAnimation();
        }
    };
    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener();
    /* access modifiers changed from: private */
    public HashMap<Animator, PropertyBundle> mAnimatorMap = new HashMap<>();
    private long mDuration;
    private boolean mDurationSet = false;
    private Interpolator mInterpolator;
    private boolean mInterpolatorSet = false;
    /* access modifiers changed from: private */
    public Animator.AnimatorListener mListener = null;
    private final AnimatorProxy mProxy;
    private long mStartDelay = 0;
    private boolean mStartDelaySet = false;
    /* access modifiers changed from: private */
    public final WeakReference<View> mView;

    public class AnimatorEventListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private AnimatorEventListener() {
        }

        public void onAnimationCancel(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationCancel(animator);
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationEnd(animator);
            }
            ViewPropertyAnimatorPreHC.this.mAnimatorMap.remove(animator);
            if (ViewPropertyAnimatorPreHC.this.mAnimatorMap.isEmpty()) {
                Animator.AnimatorListener unused = ViewPropertyAnimatorPreHC.this.mListener = null;
            }
        }

        public void onAnimationRepeat(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationRepeat(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationStart(animator);
            }
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            PropertyBundle propertyBundle = (PropertyBundle) ViewPropertyAnimatorPreHC.this.mAnimatorMap.get(valueAnimator);
            if (!((propertyBundle.f52858a & 511) == 0 || (view = (View) ViewPropertyAnimatorPreHC.this.mView.get()) == null)) {
                view.invalidate();
            }
            ArrayList<NameValuesHolder> arrayList = propertyBundle.f52859b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    NameValuesHolder nameValuesHolder = arrayList.get(i11);
                    ViewPropertyAnimatorPreHC.this.setValue(nameValuesHolder.f52855a, nameValuesHolder.f52856b + (nameValuesHolder.f52857c * animatedFraction));
                }
            }
            View view2 = (View) ViewPropertyAnimatorPreHC.this.mView.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    public static class NameValuesHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f52855a;

        /* renamed from: b  reason: collision with root package name */
        public float f52856b;

        /* renamed from: c  reason: collision with root package name */
        public float f52857c;

        public NameValuesHolder(int i11, float f11, float f12) {
            this.f52855a = i11;
            this.f52856b = f11;
            this.f52857c = f12;
        }
    }

    public static class PropertyBundle {

        /* renamed from: a  reason: collision with root package name */
        public int f52858a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<NameValuesHolder> f52859b;

        public PropertyBundle(int i11, ArrayList<NameValuesHolder> arrayList) {
            this.f52858a = i11;
            this.f52859b = arrayList;
        }

        public boolean a(int i11) {
            ArrayList<NameValuesHolder> arrayList;
            if (!((this.f52858a & i11) == 0 || (arrayList = this.f52859b) == null)) {
                int size = arrayList.size();
                for (int i12 = 0; i12 < size; i12++) {
                    if (this.f52859b.get(i12).f52855a == i11) {
                        this.f52859b.remove(i12);
                        this.f52858a = (~i11) & this.f52858a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public ViewPropertyAnimatorPreHC(View view) {
        this.mView = new WeakReference<>(view);
        this.mProxy = AnimatorProxy.wrap(view);
    }

    private void animateProperty(int i11, float f11) {
        float value = getValue(i11);
        animatePropertyBy(i11, value, f11 - value);
    }

    private void animatePropertyBy(int i11, float f11) {
        animatePropertyBy(i11, getValue(i11), f11);
    }

    private float getValue(int i11) {
        if (i11 == 1) {
            return this.mProxy.getTranslationX();
        }
        if (i11 == 2) {
            return this.mProxy.getTranslationY();
        }
        if (i11 == 4) {
            return this.mProxy.getScaleX();
        }
        if (i11 == 8) {
            return this.mProxy.getScaleY();
        }
        if (i11 == 16) {
            return this.mProxy.getRotation();
        }
        if (i11 == 32) {
            return this.mProxy.getRotationX();
        }
        if (i11 == 64) {
            return this.mProxy.getRotationY();
        }
        if (i11 == 128) {
            return this.mProxy.getX();
        }
        if (i11 == 256) {
            return this.mProxy.getY();
        }
        if (i11 != 512) {
            return 0.0f;
        }
        return this.mProxy.getAlpha();
    }

    /* access modifiers changed from: private */
    public void setValue(int i11, float f11) {
        if (i11 == 1) {
            this.mProxy.setTranslationX(f11);
        } else if (i11 == 2) {
            this.mProxy.setTranslationY(f11);
        } else if (i11 == 4) {
            this.mProxy.setScaleX(f11);
        } else if (i11 == 8) {
            this.mProxy.setScaleY(f11);
        } else if (i11 == 16) {
            this.mProxy.setRotation(f11);
        } else if (i11 == 32) {
            this.mProxy.setRotationX(f11);
        } else if (i11 == 64) {
            this.mProxy.setRotationY(f11);
        } else if (i11 == 128) {
            this.mProxy.setX(f11);
        } else if (i11 == 256) {
            this.mProxy.setY(f11);
        } else if (i11 == 512) {
            this.mProxy.setAlpha(f11);
        }
    }

    /* access modifiers changed from: private */
    public void startAnimation() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ArrayList arrayList = (ArrayList) this.f52852a.clone();
        this.f52852a.clear();
        int size = arrayList.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 |= ((NameValuesHolder) arrayList.get(i12)).f52855a;
        }
        this.mAnimatorMap.put(ofFloat, new PropertyBundle(i11, arrayList));
        ofFloat.addUpdateListener(this.mAnimatorEventListener);
        ofFloat.addListener(this.mAnimatorEventListener);
        if (this.mStartDelaySet) {
            ofFloat.setStartDelay(this.mStartDelay);
        }
        if (this.mDurationSet) {
            ofFloat.setDuration(this.mDuration);
        }
        if (this.mInterpolatorSet) {
            ofFloat.setInterpolator(this.mInterpolator);
        }
        ofFloat.start();
    }

    public ViewPropertyAnimator alpha(float f11) {
        animateProperty(512, f11);
        return this;
    }

    public ViewPropertyAnimator alphaBy(float f11) {
        animatePropertyBy(512, f11);
        return this;
    }

    public void cancel() {
        if (this.mAnimatorMap.size() > 0) {
            for (Animator cancel : ((HashMap) this.mAnimatorMap.clone()).keySet()) {
                cancel.cancel();
            }
        }
        this.f52852a.clear();
        View view = this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
        }
    }

    public long getDuration() {
        if (this.mDurationSet) {
            return this.mDuration;
        }
        return new ValueAnimator().getDuration();
    }

    public long getStartDelay() {
        if (this.mStartDelaySet) {
            return this.mStartDelay;
        }
        return 0;
    }

    public ViewPropertyAnimator rotation(float f11) {
        animateProperty(16, f11);
        return this;
    }

    public ViewPropertyAnimator rotationBy(float f11) {
        animatePropertyBy(16, f11);
        return this;
    }

    public ViewPropertyAnimator rotationX(float f11) {
        animateProperty(32, f11);
        return this;
    }

    public ViewPropertyAnimator rotationXBy(float f11) {
        animatePropertyBy(32, f11);
        return this;
    }

    public ViewPropertyAnimator rotationY(float f11) {
        animateProperty(64, f11);
        return this;
    }

    public ViewPropertyAnimator rotationYBy(float f11) {
        animatePropertyBy(64, f11);
        return this;
    }

    public ViewPropertyAnimator scaleX(float f11) {
        animateProperty(4, f11);
        return this;
    }

    public ViewPropertyAnimator scaleXBy(float f11) {
        animatePropertyBy(4, f11);
        return this;
    }

    public ViewPropertyAnimator scaleY(float f11) {
        animateProperty(8, f11);
        return this;
    }

    public ViewPropertyAnimator scaleYBy(float f11) {
        animatePropertyBy(8, f11);
        return this;
    }

    public ViewPropertyAnimator setDuration(long j11) {
        if (j11 >= 0) {
            this.mDurationSet = true;
            this.mDuration = j11;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j11);
    }

    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        this.mInterpolatorSet = true;
        this.mInterpolator = interpolator;
        return this;
    }

    public ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener) {
        this.mListener = animatorListener;
        return this;
    }

    public ViewPropertyAnimator setStartDelay(long j11) {
        if (j11 >= 0) {
            this.mStartDelaySet = true;
            this.mStartDelay = j11;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j11);
    }

    public void start() {
        startAnimation();
    }

    public ViewPropertyAnimator translationX(float f11) {
        animateProperty(1, f11);
        return this;
    }

    public ViewPropertyAnimator translationXBy(float f11) {
        animatePropertyBy(1, f11);
        return this;
    }

    public ViewPropertyAnimator translationY(float f11) {
        animateProperty(2, f11);
        return this;
    }

    public ViewPropertyAnimator translationYBy(float f11) {
        animatePropertyBy(2, f11);
        return this;
    }

    public ViewPropertyAnimator x(float f11) {
        animateProperty(128, f11);
        return this;
    }

    public ViewPropertyAnimator xBy(float f11) {
        animatePropertyBy(128, f11);
        return this;
    }

    public ViewPropertyAnimator y(float f11) {
        animateProperty(256, f11);
        return this;
    }

    public ViewPropertyAnimator yBy(float f11) {
        animatePropertyBy(256, f11);
        return this;
    }

    private void animatePropertyBy(int i11, float f11, float f12) {
        Animator animator;
        if (this.mAnimatorMap.size() > 0) {
            Iterator<Animator> it = this.mAnimatorMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    animator = null;
                    break;
                }
                animator = it.next();
                PropertyBundle propertyBundle = this.mAnimatorMap.get(animator);
                if (propertyBundle.a(i11) && propertyBundle.f52858a == 0) {
                    break;
                }
            }
            if (animator != null) {
                animator.cancel();
            }
        }
        this.f52852a.add(new NameValuesHolder(i11, f11, f12));
        View view = this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
            view.post(this.mAnimationStarter);
        }
    }
}
