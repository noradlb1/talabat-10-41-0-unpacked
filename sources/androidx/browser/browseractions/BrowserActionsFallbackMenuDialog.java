package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@Deprecated
class BrowserActionsFallbackMenuDialog extends Dialog {
    private static final long ENTER_ANIMATION_DURATION_MS = 250;
    private static final long EXIT_ANIMATION_DURATION_MS = 150;
    private final View mContentView;

    public BrowserActionsFallbackMenuDialog(Context context, View view) {
        super(context);
        this.mContentView = view;
    }

    private void startAnimation(final boolean z11) {
        float f11;
        long j11;
        float f12 = 0.0f;
        if (z11) {
            f11 = 0.0f;
        } else {
            f11 = 1.0f;
        }
        if (z11) {
            f12 = 1.0f;
        }
        if (z11) {
            j11 = 250;
        } else {
            j11 = 150;
        }
        this.mContentView.setScaleX(f11);
        this.mContentView.setScaleY(f11);
        this.mContentView.animate().scaleX(f12).scaleY(f12).setDuration(j11).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!z11) {
                    BrowserActionsFallbackMenuDialog.super.dismiss();
                }
            }
        }).start();
    }

    public void dismiss() {
        startAnimation(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return true;
    }

    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        startAnimation(true);
        super.show();
    }
}
