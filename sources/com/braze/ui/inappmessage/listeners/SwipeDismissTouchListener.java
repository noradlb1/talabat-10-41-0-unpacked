package com.braze.ui.inappmessage.listeners;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import c4.c;

public class SwipeDismissTouchListener implements View.OnTouchListener {
    private final long mAnimationTime;
    /* access modifiers changed from: private */
    public final DismissCallbacks mCallbacks;
    private float mDownX;
    private float mDownY;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int mSlop;
    private boolean mSwiping;
    private int mSwipingSlop;
    /* access modifiers changed from: private */
    public final Object mToken;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;
    /* access modifiers changed from: private */
    public final View mView;
    private int mViewWidth = 1;

    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.mSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mAnimationTime = (long) view.getContext().getResources().getInteger(17694720);
        this.mView = view;
        this.mToken = obj;
        this.mCallbacks = dismissCallbacks;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$performDismiss$0(ViewGroup.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.mView.setLayoutParams(layoutParams);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z11;
        int i11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i12;
        motionEvent.offsetLocation(this.mTranslationX, 0.0f);
        if (this.mViewWidth < 2) {
            this.mViewWidth = this.mView.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            boolean z15 = true;
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                        float rawX = motionEvent.getRawX() - this.mDownX;
                        float rawY = motionEvent.getRawY() - this.mDownY;
                        if (Math.abs(rawX) > ((float) this.mSlop) && Math.abs(rawY) < Math.abs(rawX) / 2.0f) {
                            this.mSwiping = true;
                            if (rawX > 0.0f) {
                                i12 = this.mSlop;
                            } else {
                                i12 = -this.mSlop;
                            }
                            this.mSwipingSlop = i12;
                            this.mView.getParent().requestDisallowInterceptTouchEvent(true);
                            MotionEvent obtain = MotionEvent.obtain(motionEvent);
                            obtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                            this.mView.onTouchEvent(obtain);
                            obtain.recycle();
                        }
                        if (this.mSwiping) {
                            this.mTranslationX = rawX;
                            this.mView.setTranslationX(rawX - ((float) this.mSwipingSlop));
                            return true;
                        }
                    }
                } else if (actionMasked == 3 && this.mVelocityTracker != null) {
                    this.mView.animate().translationX(0.0f).alpha(1.0f).setDuration(this.mAnimationTime).setListener((Animator.AnimatorListener) null);
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    this.mTranslationX = 0.0f;
                    this.mDownX = 0.0f;
                    this.mDownY = 0.0f;
                    this.mSwiping = false;
                }
            } else if (this.mVelocityTracker != null) {
                float rawX2 = motionEvent.getRawX() - this.mDownX;
                this.mVelocityTracker.addMovement(motionEvent);
                this.mVelocityTracker.computeCurrentVelocity(1000);
                float xVelocity = this.mVelocityTracker.getXVelocity();
                float abs = Math.abs(xVelocity);
                float abs2 = Math.abs(this.mVelocityTracker.getYVelocity());
                if (Math.abs(rawX2) <= ((float) (this.mViewWidth / 2)) || !this.mSwiping) {
                    if (((float) this.mMinFlingVelocity) > abs || abs > ((float) this.mMaxFlingVelocity) || abs2 >= abs || !this.mSwiping) {
                        z11 = false;
                        z15 = false;
                    } else {
                        if (xVelocity < 0.0f) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (rawX2 < 0.0f) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (z12 == z13) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (this.mVelocityTracker.getXVelocity() <= 0.0f) {
                            z15 = false;
                        }
                        boolean z16 = z15;
                        z15 = z14;
                        z11 = z16;
                    }
                } else if (rawX2 > 0.0f) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z15) {
                    ViewPropertyAnimator animate = this.mView.animate();
                    if (z11) {
                        i11 = this.mViewWidth;
                    } else {
                        i11 = -this.mViewWidth;
                    }
                    animate.translationX((float) i11).alpha(0.0f).setDuration(this.mAnimationTime).setListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            SwipeDismissTouchListener.this.performDismiss();
                        }
                    });
                } else if (this.mSwiping) {
                    this.mView.animate().translationX(0.0f).alpha(1.0f).setDuration(this.mAnimationTime).setListener((Animator.AnimatorListener) null);
                }
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                this.mTranslationX = 0.0f;
                this.mDownX = 0.0f;
                this.mDownY = 0.0f;
                this.mSwiping = false;
            }
            return false;
        }
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        if (this.mCallbacks.canDismiss(this.mToken)) {
            VelocityTracker obtain2 = VelocityTracker.obtain();
            this.mVelocityTracker = obtain2;
            obtain2.addMovement(motionEvent);
        }
        return false;
    }

    @TargetApi(12)
    public void performDismiss() {
        final ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        final int height = this.mView.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{height, 1}).setDuration(this.mAnimationTime);
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SwipeDismissTouchListener.this.mCallbacks.onDismiss(SwipeDismissTouchListener.this.mView, SwipeDismissTouchListener.this.mToken);
                SwipeDismissTouchListener.this.mView.setAlpha(1.0f);
                SwipeDismissTouchListener.this.mView.setTranslationX(0.0f);
                layoutParams.height = height;
                SwipeDismissTouchListener.this.mView.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new c(this, layoutParams));
        duration.start();
    }
}
