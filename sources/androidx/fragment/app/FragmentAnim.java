package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;

class FragmentAnim {
    private FragmentAnim() {
    }

    @AnimRes
    private static int getNextAnim(Fragment fragment, boolean z11, boolean z12) {
        if (z12) {
            if (z11) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        } else if (z11) {
            return fragment.getEnterAnim();
        } else {
            return fragment.getExitAnim();
        }
    }

    public static AnimationOrAnimator loadAnimation(@NonNull Context context, @NonNull Fragment fragment, boolean z11, boolean z12) {
        int nextTransition = fragment.getNextTransition();
        int nextAnim = getNextAnim(fragment, z11, z12);
        boolean z13 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i11 = R.id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i11) != null) {
                fragment.mContainer.setTag(i11, (Object) null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z11, nextAnim);
        if (onCreateAnimation != null) {
            return new AnimationOrAnimator(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z11, nextAnim);
        if (onCreateAnimator != null) {
            return new AnimationOrAnimator(onCreateAnimator);
        }
        if (nextAnim == 0 && nextTransition != 0) {
            nextAnim = transitToAnimResourceId(context, nextTransition, z11);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                    if (loadAnimation != null) {
                        return new AnimationOrAnimator(loadAnimation);
                    }
                    z13 = true;
                } catch (Resources.NotFoundException e11) {
                    throw e11;
                } catch (RuntimeException unused) {
                }
            }
            if (!z13) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                    if (loadAnimator != null) {
                        return new AnimationOrAnimator(loadAnimator);
                    }
                } catch (RuntimeException e12) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                        if (loadAnimation2 != null) {
                            return new AnimationOrAnimator(loadAnimation2);
                        }
                    } else {
                        throw e12;
                    }
                }
            }
        }
        return null;
    }

    @AnimRes
    private static int toActivityTransitResId(@NonNull Context context, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{i11});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    @AnimRes
    private static int transitToAnimResourceId(@NonNull Context context, int i11, boolean z11) {
        if (i11 != 4097) {
            if (i11 != 8194) {
                if (i11 != 8197) {
                    if (i11 != 4099) {
                        if (i11 != 4100) {
                            return -1;
                        }
                        if (z11) {
                            return toActivityTransitResId(context, 16842936);
                        }
                        return toActivityTransitResId(context, 16842937);
                    } else if (z11) {
                        return R.animator.fragment_fade_enter;
                    } else {
                        return R.animator.fragment_fade_exit;
                    }
                } else if (z11) {
                    return toActivityTransitResId(context, 16842938);
                } else {
                    return toActivityTransitResId(context, 16842939);
                }
            } else if (z11) {
                return R.animator.fragment_close_enter;
            } else {
                return R.animator.fragment_close_exit;
            }
        } else if (z11) {
            return R.animator.fragment_open_enter;
        } else {
            return R.animator.fragment_open_exit;
        }
    }

    public static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        public AnimationOrAnimator(Animation animation2) {
            this.animation = animation2;
            this.animator = null;
            if (animation2 == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public AnimationOrAnimator(Animator animator2) {
            this.animation = null;
            this.animator = animator2;
            if (animator2 == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    public static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating = true;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        public EndViewTransitionAnimation(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
            super(false);
            this.mParent = viewGroup;
            this.mChild = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j11, @NonNull Transformation transformation) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j11, transformation)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        public void run() {
            if (this.mEnded || !this.mAnimating) {
                this.mParent.endViewTransition(this.mChild);
                this.mTransitionEnded = true;
                return;
            }
            this.mAnimating = false;
            this.mParent.post(this);
        }

        public boolean getTransformation(long j11, @NonNull Transformation transformation, float f11) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j11, transformation, f11)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }
    }
}
