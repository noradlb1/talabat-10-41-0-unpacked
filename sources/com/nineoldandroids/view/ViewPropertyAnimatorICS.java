package com.nineoldandroids.view;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.lang.ref.WeakReference;

class ViewPropertyAnimatorICS extends ViewPropertyAnimator {
    private static final long RETURN_WHEN_NULL = -1;
    private final WeakReference<ViewPropertyAnimator> mNative;

    public ViewPropertyAnimatorICS(View view) {
        this.mNative = new WeakReference<>(view.animate());
    }

    public ViewPropertyAnimator alpha(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f11);
        }
        return this;
    }

    public ViewPropertyAnimator alphaBy(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f11);
        }
        return this;
    }

    public void cancel() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public long getDuration() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1;
    }

    public long getStartDelay() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1;
    }

    public ViewPropertyAnimator rotation(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f11);
        }
        return this;
    }

    public ViewPropertyAnimator rotationBy(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f11);
        }
        return this;
    }

    public ViewPropertyAnimator rotationX(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f11);
        }
        return this;
    }

    public ViewPropertyAnimator rotationXBy(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f11);
        }
        return this;
    }

    public ViewPropertyAnimator rotationY(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f11);
        }
        return this;
    }

    public ViewPropertyAnimator rotationYBy(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f11);
        }
        return this;
    }

    public ViewPropertyAnimator scaleX(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f11);
        }
        return this;
    }

    public ViewPropertyAnimator scaleXBy(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f11);
        }
        return this;
    }

    public ViewPropertyAnimator scaleY(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f11);
        }
        return this;
    }

    public ViewPropertyAnimator scaleYBy(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f11);
        }
        return this;
    }

    public ViewPropertyAnimator setDuration(long j11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j11);
        }
        return this;
    }

    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimator setListener(final Animator.AnimatorListener animatorListener) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            if (animatorListener == null) {
                viewPropertyAnimator.setListener((Animator.AnimatorListener) null);
            } else {
                viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(android.animation.Animator animator) {
                        animatorListener.onAnimationCancel((com.nineoldandroids.animation.Animator) null);
                    }

                    public void onAnimationEnd(android.animation.Animator animator) {
                        animatorListener.onAnimationEnd((com.nineoldandroids.animation.Animator) null);
                    }

                    public void onAnimationRepeat(android.animation.Animator animator) {
                        animatorListener.onAnimationRepeat((com.nineoldandroids.animation.Animator) null);
                    }

                    public void onAnimationStart(android.animation.Animator animator) {
                        animatorListener.onAnimationStart((com.nineoldandroids.animation.Animator) null);
                    }
                });
            }
        }
        return this;
    }

    public ViewPropertyAnimator setStartDelay(long j11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j11);
        }
        return this;
    }

    public void start() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    public ViewPropertyAnimator translationX(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f11);
        }
        return this;
    }

    public ViewPropertyAnimator translationXBy(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f11);
        }
        return this;
    }

    public ViewPropertyAnimator translationY(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f11);
        }
        return this;
    }

    public ViewPropertyAnimator translationYBy(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f11);
        }
        return this;
    }

    public ViewPropertyAnimator x(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f11);
        }
        return this;
    }

    public ViewPropertyAnimator xBy(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f11);
        }
        return this;
    }

    public ViewPropertyAnimator y(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f11);
        }
        return this;
    }

    public ViewPropertyAnimator yBy(float f11) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f11);
        }
        return this;
    }
}
