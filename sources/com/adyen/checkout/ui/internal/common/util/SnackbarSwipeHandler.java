package com.adyen.checkout.ui.internal.common.util;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import com.google.android.material.snackbar.Snackbar;

public final class SnackbarSwipeHandler extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    private static final int DURATION_FACTOR_HORIZONTAL = 100;
    private static final int SWIPE_MIN_DISTANCE_HORIZONTAL = 120;
    private static final int SWIPE_MIN_DISTANCE_VERTICAL = 50;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private SimpleAnimatorListener mAnimatorListener = new SimpleAnimatorListener() {
        public void onAnimationEnd(@NonNull Animator animator) {
            SnackbarSwipeHandler.this.mSnackbar.dismiss();
        }
    };
    private GestureDetectorCompat mGestureDetector;
    /* access modifiers changed from: private */
    public Snackbar mSnackbar;

    private SnackbarSwipeHandler(@NonNull Context context, @NonNull Snackbar snackbar) {
        this.mGestureDetector = new GestureDetectorCompat(context, this);
        this.mSnackbar = snackbar;
    }

    public static void attach(@NonNull Context context, @NonNull Snackbar snackbar) {
        snackbar.getView().setOnTouchListener(new SnackbarSwipeHandler(context, snackbar));
    }

    private void onSwipeDismissX(float f11, int i11) {
        View view = this.mSnackbar.getView();
        int width = view.getWidth();
        view.animate().translationX((float) (i11 * width)).setDuration(Math.abs(((long) (f11 / ((float) width))) * 100)).setListener(this.mAnimatorListener).start();
    }

    public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f11, float f12) {
        if (motionEvent.getX() - motionEvent2.getX() > 120.0f && Math.abs(f11) > 200.0f) {
            onSwipeDismissX(f11, -1);
            return true;
        } else if (motionEvent2.getX() - motionEvent.getX() > 120.0f && Math.abs(f11) > 200.0f) {
            onSwipeDismissX(f11, 1);
            return true;
        } else if (motionEvent2.getY() - motionEvent.getY() <= 50.0f || Math.abs(f12) <= 200.0f) {
            return false;
        } else {
            this.mSnackbar.dismiss();
            return true;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }
}
