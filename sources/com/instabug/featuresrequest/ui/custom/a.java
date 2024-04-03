package com.instabug.featuresrequest.ui.custom;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

final class a extends SwipeDismissBehavior {

    /* renamed from: a  reason: collision with root package name */
    private r f46698a;

    public a(r rVar) {
        this.f46698a = rVar;
    }

    /* renamed from: a */
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
        if (coordinatorLayout.isPointInChildBounds(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                t.c().a(this.f46698a);
            } else if (actionMasked == 1 || actionMasked == 3) {
                t.c().g(this.f46698a);
            }
        }
        return super.onInterceptTouchEvent(coordinatorLayout, snackbarLayout, motionEvent);
    }

    public boolean canSwipeDismissView(View view) {
        return view instanceof SnackbarLayout;
    }
}
