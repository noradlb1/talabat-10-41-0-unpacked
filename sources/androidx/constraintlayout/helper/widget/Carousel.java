package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import java.util.Iterator;
import y0.a;

public class Carousel extends MotionHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "Carousel";
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    private int backwardTransition = -1;
    /* access modifiers changed from: private */
    public float dampening = 0.9f;
    private int emptyViewBehavior = 4;
    private int firstViewReference = -1;
    private int forwardTransition = -1;
    private boolean infiniteCarousel = false;

    /* renamed from: k  reason: collision with root package name */
    public int f10838k = -1;

    /* renamed from: l  reason: collision with root package name */
    public Runnable f10839l = new Runnable() {
        public void run() {
            Carousel.this.mMotionLayout.setProgress(0.0f);
            Carousel.this.updateItems();
            Carousel.this.mAdapter.onNewItem(Carousel.this.mIndex);
            float velocity = Carousel.this.mMotionLayout.getVelocity();
            if (Carousel.this.touchUpMode == 2 && velocity > Carousel.this.velocityThreshold && Carousel.this.mIndex < Carousel.this.mAdapter.count() - 1) {
                final float m11 = velocity * Carousel.this.dampening;
                if (Carousel.this.mIndex == 0 && Carousel.this.mPreviousIndex > Carousel.this.mIndex) {
                    return;
                }
                if (Carousel.this.mIndex != Carousel.this.mAdapter.count() - 1 || Carousel.this.mPreviousIndex >= Carousel.this.mIndex) {
                    Carousel.this.mMotionLayout.post(new Runnable() {
                        public void run() {
                            Carousel.this.mMotionLayout.touchAnimateTo(5, 1.0f, m11);
                        }
                    });
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public Adapter mAdapter = null;
    private int mAnimateTargetDelay = 200;
    /* access modifiers changed from: private */
    public int mIndex = 0;
    private final ArrayList<View> mList = new ArrayList<>();
    /* access modifiers changed from: private */
    public MotionLayout mMotionLayout;
    /* access modifiers changed from: private */
    public int mPreviousIndex = 0;
    private int mTargetIndex = -1;
    private int nextState = -1;
    private int previousState = -1;
    private int startIndex = 0;
    /* access modifiers changed from: private */
    public int touchUpMode = 1;
    /* access modifiers changed from: private */
    public float velocityThreshold = 2.0f;

    public interface Adapter {
        int count();

        void onNewItem(int i11);

        void populate(View view, int i11);
    }

    public Carousel(Context context) {
        super(context);
    }

    private void enableAllTransitions(boolean z11) {
        Iterator<MotionScene.Transition> it = this.mMotionLayout.getDefinedTransitions().iterator();
        while (it.hasNext()) {
            it.next().setEnabled(z11);
        }
    }

    private boolean enableTransition(int i11, boolean z11) {
        MotionLayout motionLayout;
        MotionScene.Transition transition;
        if (i11 == -1 || (motionLayout = this.mMotionLayout) == null || (transition = motionLayout.getTransition(i11)) == null || z11 == transition.isEnabled()) {
            return false;
        }
        transition.setEnabled(z11);
        return true;
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.Carousel_carousel_firstView) {
                    this.firstViewReference = obtainStyledAttributes.getResourceId(index, this.firstViewReference);
                } else if (index == R.styleable.Carousel_carousel_backwardTransition) {
                    this.backwardTransition = obtainStyledAttributes.getResourceId(index, this.backwardTransition);
                } else if (index == R.styleable.Carousel_carousel_forwardTransition) {
                    this.forwardTransition = obtainStyledAttributes.getResourceId(index, this.forwardTransition);
                } else if (index == R.styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.emptyViewBehavior = obtainStyledAttributes.getInt(index, this.emptyViewBehavior);
                } else if (index == R.styleable.Carousel_carousel_previousState) {
                    this.previousState = obtainStyledAttributes.getResourceId(index, this.previousState);
                } else if (index == R.styleable.Carousel_carousel_nextState) {
                    this.nextState = obtainStyledAttributes.getResourceId(index, this.nextState);
                } else if (index == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.dampening = obtainStyledAttributes.getFloat(index, this.dampening);
                } else if (index == R.styleable.Carousel_carousel_touchUpMode) {
                    this.touchUpMode = obtainStyledAttributes.getInt(index, this.touchUpMode);
                } else if (index == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.velocityThreshold = obtainStyledAttributes.getFloat(index, this.velocityThreshold);
                } else if (index == R.styleable.Carousel_carousel_infinite) {
                    this.infiniteCarousel = obtainStyledAttributes.getBoolean(index, this.infiniteCarousel);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateItems$0() {
        this.mMotionLayout.setTransitionDuration(this.mAnimateTargetDelay);
        if (this.mTargetIndex < this.mIndex) {
            this.mMotionLayout.transitionToState(this.previousState, this.mAnimateTargetDelay);
        } else {
            this.mMotionLayout.transitionToState(this.nextState, this.mAnimateTargetDelay);
        }
    }

    /* access modifiers changed from: private */
    public void updateItems() {
        Adapter adapter = this.mAdapter;
        if (adapter != null && this.mMotionLayout != null && adapter.count() != 0) {
            int size = this.mList.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = this.mList.get(i11);
                int i12 = (this.mIndex + i11) - this.startIndex;
                if (this.infiniteCarousel) {
                    if (i12 < 0) {
                        int i13 = this.emptyViewBehavior;
                        if (i13 != 4) {
                            updateViewVisibility(view, i13);
                        } else {
                            updateViewVisibility(view, 0);
                        }
                        if (i12 % this.mAdapter.count() == 0) {
                            this.mAdapter.populate(view, 0);
                        } else {
                            Adapter adapter2 = this.mAdapter;
                            adapter2.populate(view, adapter2.count() + (i12 % this.mAdapter.count()));
                        }
                    } else if (i12 >= this.mAdapter.count()) {
                        if (i12 == this.mAdapter.count()) {
                            i12 = 0;
                        } else if (i12 > this.mAdapter.count()) {
                            i12 %= this.mAdapter.count();
                        }
                        int i14 = this.emptyViewBehavior;
                        if (i14 != 4) {
                            updateViewVisibility(view, i14);
                        } else {
                            updateViewVisibility(view, 0);
                        }
                        this.mAdapter.populate(view, i12);
                    } else {
                        updateViewVisibility(view, 0);
                        this.mAdapter.populate(view, i12);
                    }
                } else if (i12 < 0) {
                    updateViewVisibility(view, this.emptyViewBehavior);
                } else if (i12 >= this.mAdapter.count()) {
                    updateViewVisibility(view, this.emptyViewBehavior);
                } else {
                    updateViewVisibility(view, 0);
                    this.mAdapter.populate(view, i12);
                }
            }
            int i15 = this.mTargetIndex;
            if (i15 != -1 && i15 != this.mIndex) {
                this.mMotionLayout.post(new a(this));
            } else if (i15 == this.mIndex) {
                this.mTargetIndex = -1;
            }
            if (this.backwardTransition == -1 || this.forwardTransition == -1) {
                Log.w(TAG, "No backward or forward transitions defined for Carousel!");
            } else if (!this.infiniteCarousel) {
                int count = this.mAdapter.count();
                if (this.mIndex == 0) {
                    enableTransition(this.backwardTransition, false);
                } else {
                    enableTransition(this.backwardTransition, true);
                    this.mMotionLayout.setTransition(this.backwardTransition);
                }
                if (this.mIndex == count - 1) {
                    enableTransition(this.forwardTransition, false);
                    return;
                }
                enableTransition(this.forwardTransition, true);
                this.mMotionLayout.setTransition(this.forwardTransition);
            }
        }
    }

    private boolean updateViewVisibility(View view, int i11) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout == null) {
            return false;
        }
        int[] constraintSetIds = motionLayout.getConstraintSetIds();
        boolean z11 = false;
        for (int updateViewVisibility : constraintSetIds) {
            z11 |= updateViewVisibility(updateViewVisibility, view, i11);
        }
        return z11;
    }

    public int getCount() {
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            return adapter.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.mIndex;
    }

    public void jumpToIndex(int i11) {
        this.mIndex = Math.max(0, Math.min(getCount() - 1, i11));
        refresh();
    }

    @RequiresApi(api = 17)
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i11 = 0; i11 < this.f11095c; i11++) {
                int i12 = this.f11094b[i11];
                View viewById = motionLayout.getViewById(i12);
                if (this.firstViewReference == i12) {
                    this.startIndex = i11;
                }
                this.mList.add(viewById);
            }
            this.mMotionLayout = motionLayout;
            if (this.touchUpMode == 2) {
                MotionScene.Transition transition = motionLayout.getTransition(this.forwardTransition);
                if (transition != null) {
                    transition.setOnTouchUp(5);
                }
                MotionScene.Transition transition2 = this.mMotionLayout.getTransition(this.backwardTransition);
                if (transition2 != null) {
                    transition2.setOnTouchUp(5);
                }
            }
            updateItems();
        }
    }

    public void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11) {
        this.f10838k = i11;
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i11) {
        int i12 = this.mIndex;
        this.mPreviousIndex = i12;
        if (i11 == this.nextState) {
            this.mIndex = i12 + 1;
        } else if (i11 == this.previousState) {
            this.mIndex = i12 - 1;
        }
        if (this.infiniteCarousel) {
            if (this.mIndex >= this.mAdapter.count()) {
                this.mIndex = 0;
            }
            if (this.mIndex < 0) {
                this.mIndex = this.mAdapter.count() - 1;
            }
        } else {
            if (this.mIndex >= this.mAdapter.count()) {
                this.mIndex = this.mAdapter.count() - 1;
            }
            if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        }
        if (this.mPreviousIndex != this.mIndex) {
            this.mMotionLayout.post(this.f10839l);
        }
    }

    public void refresh() {
        int size = this.mList.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.mList.get(i11);
            if (this.mAdapter.count() == 0) {
                updateViewVisibility(view, this.emptyViewBehavior);
            } else {
                updateViewVisibility(view, 0);
            }
        }
        this.mMotionLayout.rebuildScene();
        updateItems();
    }

    public void setAdapter(Adapter adapter) {
        this.mAdapter = adapter;
    }

    public void transitionToIndex(int i11, int i12) {
        this.mTargetIndex = Math.max(0, Math.min(getCount() - 1, i11));
        int max = Math.max(0, i12);
        this.mAnimateTargetDelay = max;
        this.mMotionLayout.setTransitionDuration(max);
        if (i11 < this.mIndex) {
            this.mMotionLayout.transitionToState(this.previousState, this.mAnimateTargetDelay);
        } else {
            this.mMotionLayout.transitionToState(this.nextState, this.mAnimateTargetDelay);
        }
    }

    private boolean updateViewVisibility(int i11, View view, int i12) {
        ConstraintSet.Constraint constraint;
        ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(i11);
        if (constraintSet == null || (constraint = constraintSet.getConstraint(view.getId())) == null) {
            return false;
        }
        constraint.propertySet.mVisibilityMode = 1;
        view.setVisibility(i12);
        return true;
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
