package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ViewTransitionController {
    private String TAG = "ViewTransitionController";

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ViewTransition.Animate> f11042a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ViewTransition.Animate> f11043b = new ArrayList<>();
    /* access modifiers changed from: private */
    public final MotionLayout mMotionLayout;
    private HashSet<View> mRelatedViews;
    private ArrayList<ViewTransition> viewTransitions = new ArrayList<>();

    public ViewTransitionController(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private void listenForSharedVariable(ViewTransition viewTransition, boolean z11) {
        final int sharedValueID = viewTransition.getSharedValueID();
        final int sharedValue = viewTransition.getSharedValue();
        final ViewTransition viewTransition2 = viewTransition;
        final boolean z12 = z11;
        ConstraintLayout.getSharedValues().addListener(viewTransition.getSharedValueID(), new SharedValues.SharedValuesListener() {
            public void onNewValue(int i11, int i12, int i13) {
                int sharedValueCurrent = viewTransition2.getSharedValueCurrent();
                viewTransition2.setSharedValueCurrent(i12);
                if (sharedValueID == i11 && sharedValueCurrent != i12) {
                    if (z12) {
                        if (sharedValue == i12) {
                            int childCount = ViewTransitionController.this.mMotionLayout.getChildCount();
                            for (int i14 = 0; i14 < childCount; i14++) {
                                View childAt = ViewTransitionController.this.mMotionLayout.getChildAt(i14);
                                if (viewTransition2.h(childAt)) {
                                    int currentState = ViewTransitionController.this.mMotionLayout.getCurrentState();
                                    ConstraintSet constraintSet = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState);
                                    ViewTransition viewTransition = viewTransition2;
                                    ViewTransitionController viewTransitionController = ViewTransitionController.this;
                                    viewTransition.c(viewTransitionController, viewTransitionController.mMotionLayout, currentState, constraintSet, childAt);
                                }
                            }
                        }
                    } else if (sharedValue != i12) {
                        int childCount2 = ViewTransitionController.this.mMotionLayout.getChildCount();
                        for (int i15 = 0; i15 < childCount2; i15++) {
                            View childAt2 = ViewTransitionController.this.mMotionLayout.getChildAt(i15);
                            if (viewTransition2.h(childAt2)) {
                                int currentState2 = ViewTransitionController.this.mMotionLayout.getCurrentState();
                                ConstraintSet constraintSet2 = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState2);
                                ViewTransition viewTransition2 = viewTransition2;
                                ViewTransitionController viewTransitionController2 = ViewTransitionController.this;
                                viewTransition2.c(viewTransitionController2, viewTransitionController2.mMotionLayout, currentState2, constraintSet2, childAt2);
                            }
                        }
                    }
                }
            }
        });
    }

    private void viewTransition(ViewTransition viewTransition, View... viewArr) {
        int currentState = this.mMotionLayout.getCurrentState();
        if (viewTransition.f11023a == 2) {
            viewTransition.c(this, this.mMotionLayout, currentState, (ConstraintSet) null, viewArr);
        } else if (currentState == -1) {
            String str = this.TAG;
            Log.w(str, "No support for ViewTransition within transition yet. Currently: " + this.mMotionLayout.toString());
        } else {
            ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(currentState);
            if (constraintSet != null) {
                viewTransition.c(this, this.mMotionLayout, currentState, constraintSet, viewArr);
            }
        }
    }

    public void add(ViewTransition viewTransition) {
        this.viewTransitions.add(viewTransition);
        this.mRelatedViews = null;
        if (viewTransition.getStateTransition() == 4) {
            listenForSharedVariable(viewTransition, true);
        } else if (viewTransition.getStateTransition() == 5) {
            listenForSharedVariable(viewTransition, false);
        }
    }

    public void b(ViewTransition.Animate animate) {
        if (this.f11042a == null) {
            this.f11042a = new ArrayList<>();
        }
        this.f11042a.add(animate);
    }

    public void c() {
        ArrayList<ViewTransition.Animate> arrayList = this.f11042a;
        if (arrayList != null) {
            Iterator<ViewTransition.Animate> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f11042a.removeAll(this.f11043b);
            this.f11043b.clear();
            if (this.f11042a.isEmpty()) {
                this.f11042a = null;
            }
        }
    }

    public boolean d(int i11, MotionController motionController) {
        Iterator<ViewTransition> it = this.viewTransitions.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.e() == i11) {
                next.f11024b.addAllFrames(motionController);
                return true;
            }
        }
        return false;
    }

    public void e(int i11, boolean z11) {
        Iterator<ViewTransition> it = this.viewTransitions.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.e() == i11) {
                next.i(z11);
                return;
            }
        }
    }

    public void f() {
        this.mMotionLayout.invalidate();
    }

    public boolean g(int i11) {
        Iterator<ViewTransition> it = this.viewTransitions.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.e() == i11) {
                return next.g();
            }
        }
        return false;
    }

    public void h(ViewTransition.Animate animate) {
        this.f11043b.add(animate);
    }

    public void i(MotionEvent motionEvent) {
        ViewTransition viewTransition;
        int currentState = this.mMotionLayout.getCurrentState();
        if (currentState != -1) {
            if (this.mRelatedViews == null) {
                this.mRelatedViews = new HashSet<>();
                Iterator<ViewTransition> it = this.viewTransitions.iterator();
                while (it.hasNext()) {
                    ViewTransition next = it.next();
                    int childCount = this.mMotionLayout.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        View childAt = this.mMotionLayout.getChildAt(i11);
                        if (next.h(childAt)) {
                            childAt.getId();
                            this.mRelatedViews.add(childAt);
                        }
                    }
                }
            }
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            Rect rect = new Rect();
            int action = motionEvent.getAction();
            ArrayList<ViewTransition.Animate> arrayList = this.f11042a;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<ViewTransition.Animate> it2 = this.f11042a.iterator();
                while (it2.hasNext()) {
                    it2.next().reactTo(action, x11, y11);
                }
            }
            if (action == 0 || action == 1) {
                ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(currentState);
                Iterator<ViewTransition> it3 = this.viewTransitions.iterator();
                while (it3.hasNext()) {
                    ViewTransition next2 = it3.next();
                    if (next2.j(action)) {
                        Iterator<View> it4 = this.mRelatedViews.iterator();
                        while (it4.hasNext()) {
                            View next3 = it4.next();
                            if (next2.h(next3)) {
                                next3.getHitRect(rect);
                                if (rect.contains((int) x11, (int) y11)) {
                                    viewTransition = next2;
                                    next2.c(this, this.mMotionLayout, currentState, constraintSet, next3);
                                } else {
                                    viewTransition = next2;
                                }
                                next2 = viewTransition;
                            }
                        }
                    }
                }
            }
        }
    }

    public void j(int i11, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<ViewTransition> it = this.viewTransitions.iterator();
        ViewTransition viewTransition = null;
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.e() == i11) {
                for (View view : viewArr) {
                    if (next.d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    viewTransition(next, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                viewTransition = next;
            }
        }
        if (viewTransition == null) {
            Log.e(this.TAG, " Could not find ViewTransition");
        }
    }
}
