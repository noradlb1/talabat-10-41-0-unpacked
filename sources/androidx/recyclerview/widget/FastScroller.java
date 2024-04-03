package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

@VisibleForTesting
class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int ANIMATION_STATE_FADING_IN = 1;
    private static final int ANIMATION_STATE_FADING_OUT = 3;
    private static final int ANIMATION_STATE_IN = 2;
    private static final int ANIMATION_STATE_OUT = 0;
    private static final int DRAG_NONE = 0;
    private static final int DRAG_X = 1;
    private static final int DRAG_Y = 2;
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
    private static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
    private static final int HIDE_DURATION_MS = 500;
    private static final int[] PRESSED_STATE_SET = {16842919};
    private static final int SCROLLBAR_FULL_OPAQUE = 255;
    private static final int SHOW_DURATION_MS = 500;
    private static final int STATE_DRAGGING = 2;
    private static final int STATE_HIDDEN = 0;
    private static final int STATE_VISIBLE = 1;
    int mAnimationState;
    private int mDragState = 0;
    private final Runnable mHideRunnable;
    @VisibleForTesting
    float mHorizontalDragX;
    private final int[] mHorizontalRange = new int[2];
    @VisibleForTesting
    int mHorizontalThumbCenterX;
    private final StateListDrawable mHorizontalThumbDrawable;
    private final int mHorizontalThumbHeight;
    @VisibleForTesting
    int mHorizontalThumbWidth;
    private final Drawable mHorizontalTrackDrawable;
    private final int mHorizontalTrackHeight;
    private final int mMargin;
    private boolean mNeedHorizontalScrollbar = false;
    private boolean mNeedVerticalScrollbar = false;
    private final RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;
    private int mRecyclerViewHeight = 0;
    private int mRecyclerViewWidth = 0;
    private final int mScrollbarMinimumRange;
    final ValueAnimator mShowHideAnimator;
    private int mState = 0;
    @VisibleForTesting
    float mVerticalDragY;
    private final int[] mVerticalRange = new int[2];
    @VisibleForTesting
    int mVerticalThumbCenterY;
    final StateListDrawable mVerticalThumbDrawable;
    @VisibleForTesting
    int mVerticalThumbHeight;
    private final int mVerticalThumbWidth;
    final Drawable mVerticalTrackDrawable;
    private final int mVerticalTrackWidth;

    public class AnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled = false;

        public AnimatorListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.mCanceled) {
                this.mCanceled = false;
            } else if (((Float) FastScroller.this.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.mAnimationState = 0;
                fastScroller.setState(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.mAnimationState = 2;
                fastScroller2.requestRedraw();
            }
        }
    }

    public class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        public AnimatorUpdater() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.mVerticalThumbDrawable.setAlpha(floatValue);
            FastScroller.this.mVerticalTrackDrawable.setAlpha(floatValue);
            FastScroller.this.requestRedraw();
        }
    }

    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i11, int i12, int i13) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mShowHideAnimator = ofFloat;
        this.mAnimationState = 0;
        this.mHideRunnable = new Runnable() {
            public void run() {
                FastScroller.this.hide(500);
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                FastScroller.this.updateScrollPosition(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
            }
        };
        this.mVerticalThumbDrawable = stateListDrawable;
        this.mVerticalTrackDrawable = drawable;
        this.mHorizontalThumbDrawable = stateListDrawable2;
        this.mHorizontalTrackDrawable = drawable2;
        this.mVerticalThumbWidth = Math.max(i11, stateListDrawable.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(i11, drawable.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(i11, stateListDrawable2.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(i11, drawable2.getIntrinsicWidth());
        this.mScrollbarMinimumRange = i12;
        this.mMargin = i13;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new AnimatorListener());
        ofFloat.addUpdateListener(new AnimatorUpdater());
        attachToRecyclerView(recyclerView);
    }

    private void cancelHide() {
        this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this);
        this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
        cancelHide();
    }

    private void drawHorizontalScrollbar(Canvas canvas) {
        int i11 = this.mRecyclerViewHeight;
        int i12 = this.mHorizontalThumbHeight;
        int i13 = i11 - i12;
        int i14 = this.mHorizontalThumbCenterX;
        int i15 = this.mHorizontalThumbWidth;
        int i16 = i14 - (i15 / 2);
        this.mHorizontalThumbDrawable.setBounds(0, 0, i15, i12);
        this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
        canvas.translate(0.0f, (float) i13);
        this.mHorizontalTrackDrawable.draw(canvas);
        canvas.translate((float) i16, 0.0f);
        this.mHorizontalThumbDrawable.draw(canvas);
        canvas.translate((float) (-i16), (float) (-i13));
    }

    private void drawVerticalScrollbar(Canvas canvas) {
        int i11 = this.mRecyclerViewWidth;
        int i12 = this.mVerticalThumbWidth;
        int i13 = i11 - i12;
        int i14 = this.mVerticalThumbCenterY;
        int i15 = this.mVerticalThumbHeight;
        int i16 = i14 - (i15 / 2);
        this.mVerticalThumbDrawable.setBounds(0, 0, i12, i15);
        this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
        if (isLayoutRTL()) {
            this.mVerticalTrackDrawable.draw(canvas);
            canvas.translate((float) this.mVerticalThumbWidth, (float) i16);
            canvas.scale(-1.0f, 1.0f);
            this.mVerticalThumbDrawable.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate((float) (-this.mVerticalThumbWidth), (float) (-i16));
            return;
        }
        canvas.translate((float) i13, 0.0f);
        this.mVerticalTrackDrawable.draw(canvas);
        canvas.translate(0.0f, (float) i16);
        this.mVerticalThumbDrawable.draw(canvas);
        canvas.translate((float) (-i13), (float) (-i16));
    }

    private int[] getHorizontalRange() {
        int[] iArr = this.mHorizontalRange;
        int i11 = this.mMargin;
        iArr[0] = i11;
        iArr[1] = this.mRecyclerViewWidth - i11;
        return iArr;
    }

    private int[] getVerticalRange() {
        int[] iArr = this.mVerticalRange;
        int i11 = this.mMargin;
        iArr[0] = i11;
        iArr[1] = this.mRecyclerViewHeight - i11;
        return iArr;
    }

    private void horizontalScrollTo(float f11) {
        int[] horizontalRange = getHorizontalRange();
        float max = Math.max((float) horizontalRange[0], Math.min((float) horizontalRange[1], f11));
        if (Math.abs(((float) this.mHorizontalThumbCenterX) - max) >= 2.0f) {
            int scrollTo = scrollTo(this.mHorizontalDragX, max, horizontalRange, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
            if (scrollTo != 0) {
                this.mRecyclerView.scrollBy(scrollTo, 0);
            }
            this.mHorizontalDragX = max;
        }
    }

    private boolean isLayoutRTL() {
        return ViewCompat.getLayoutDirection(this.mRecyclerView) == 1;
    }

    private void resetHideDelay(int i11) {
        cancelHide();
        this.mRecyclerView.postDelayed(this.mHideRunnable, (long) i11);
    }

    private int scrollTo(float f11, float f12, int[] iArr, int i11, int i12, int i13) {
        int i14 = iArr[1] - iArr[0];
        if (i14 == 0) {
            return 0;
        }
        int i15 = i11 - i13;
        int i16 = (int) (((f12 - f11) / ((float) i14)) * ((float) i15));
        int i17 = i12 + i16;
        if (i17 >= i15 || i17 < 0) {
            return 0;
        }
        return i16;
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
    }

    private void verticalScrollTo(float f11) {
        int[] verticalRange = getVerticalRange();
        float max = Math.max((float) verticalRange[0], Math.min((float) verticalRange[1], f11));
        if (Math.abs(((float) this.mVerticalThumbCenterY) - max) >= 2.0f) {
            int scrollTo = scrollTo(this.mVerticalDragY, max, verticalRange, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
            if (scrollTo != 0) {
                this.mRecyclerView.scrollBy(0, scrollTo);
            }
            this.mVerticalDragY = max;
        }
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                setupCallbacks();
            }
        }
    }

    @VisibleForTesting
    public Drawable getHorizontalThumbDrawable() {
        return this.mHorizontalThumbDrawable;
    }

    @VisibleForTesting
    public Drawable getHorizontalTrackDrawable() {
        return this.mHorizontalTrackDrawable;
    }

    @VisibleForTesting
    public Drawable getVerticalThumbDrawable() {
        return this.mVerticalThumbDrawable;
    }

    @VisibleForTesting
    public Drawable getVerticalTrackDrawable() {
        return this.mVerticalTrackDrawable;
    }

    @VisibleForTesting
    public void hide(int i11) {
        int i12 = this.mAnimationState;
        if (i12 == 1) {
            this.mShowHideAnimator.cancel();
        } else if (i12 != 2) {
            return;
        }
        this.mAnimationState = 3;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.mShowHideAnimator.setDuration((long) i11);
        this.mShowHideAnimator.start();
    }

    public boolean isDragging() {
        return this.mState == 2;
    }

    @VisibleForTesting
    public boolean isPointInsideHorizontalThumb(float f11, float f12) {
        if (f12 >= ((float) (this.mRecyclerViewHeight - this.mHorizontalThumbHeight))) {
            int i11 = this.mHorizontalThumbCenterX;
            int i12 = this.mHorizontalThumbWidth;
            return f11 >= ((float) (i11 - (i12 / 2))) && f11 <= ((float) (i11 + (i12 / 2)));
        }
    }

    @VisibleForTesting
    public boolean isPointInsideVerticalThumb(float f11, float f12) {
        if (!isLayoutRTL() ? f11 >= ((float) (this.mRecyclerViewWidth - this.mVerticalThumbWidth)) : f11 <= ((float) this.mVerticalThumbWidth)) {
            int i11 = this.mVerticalThumbCenterY;
            int i12 = this.mVerticalThumbHeight;
            return f12 >= ((float) (i11 - (i12 / 2))) && f12 <= ((float) (i11 + (i12 / 2)));
        }
    }

    @VisibleForTesting
    public boolean isVisible() {
        return this.mState == 1;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mRecyclerViewWidth != this.mRecyclerView.getWidth() || this.mRecyclerViewHeight != this.mRecyclerView.getHeight()) {
            this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
            this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
            setState(0);
        } else if (this.mAnimationState != 0) {
            if (this.mNeedVerticalScrollbar) {
                drawVerticalScrollbar(canvas);
            }
            if (this.mNeedHorizontalScrollbar) {
                drawHorizontalScrollbar(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i11 = this.mState;
        if (i11 == 1) {
            boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
            boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!isPointInsideVerticalThumb && !isPointInsideHorizontalThumb) {
                return false;
            }
            if (isPointInsideHorizontalThumb) {
                this.mDragState = 1;
                this.mHorizontalDragX = (float) ((int) motionEvent.getX());
            } else if (isPointInsideVerticalThumb) {
                this.mDragState = 2;
                this.mVerticalDragY = (float) ((int) motionEvent.getY());
            }
            setState(2);
        } else if (i11 != 2) {
            return false;
        }
        return true;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z11) {
    }

    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.mState != 0) {
            if (motionEvent.getAction() == 0) {
                boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
                boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
                if (isPointInsideVerticalThumb || isPointInsideHorizontalThumb) {
                    if (isPointInsideHorizontalThumb) {
                        this.mDragState = 1;
                        this.mHorizontalDragX = (float) ((int) motionEvent.getX());
                    } else if (isPointInsideVerticalThumb) {
                        this.mDragState = 2;
                        this.mVerticalDragY = (float) ((int) motionEvent.getY());
                    }
                    setState(2);
                }
            } else if (motionEvent.getAction() == 1 && this.mState == 2) {
                this.mVerticalDragY = 0.0f;
                this.mHorizontalDragX = 0.0f;
                setState(1);
                this.mDragState = 0;
            } else if (motionEvent.getAction() == 2 && this.mState == 2) {
                show();
                if (this.mDragState == 1) {
                    horizontalScrollTo(motionEvent.getX());
                }
                if (this.mDragState == 2) {
                    verticalScrollTo(motionEvent.getY());
                }
            }
        }
    }

    public void requestRedraw() {
        this.mRecyclerView.invalidate();
    }

    public void setState(int i11) {
        if (i11 == 2 && this.mState != 2) {
            this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
            cancelHide();
        }
        if (i11 == 0) {
            requestRedraw();
        } else {
            show();
        }
        if (this.mState == 2 && i11 != 2) {
            this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
            resetHideDelay(HIDE_DELAY_AFTER_DRAGGING_MS);
        } else if (i11 == 1) {
            resetHideDelay(1500);
        }
        this.mState = i11;
    }

    public void show() {
        int i11 = this.mAnimationState;
        if (i11 != 0) {
            if (i11 == 3) {
                this.mShowHideAnimator.cancel();
            } else {
                return;
            }
        }
        this.mAnimationState = 1;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.mShowHideAnimator.setDuration(500);
        this.mShowHideAnimator.setStartDelay(0);
        this.mShowHideAnimator.start();
    }

    public void updateScrollPosition(int i11, int i12) {
        boolean z11;
        boolean z12;
        int computeVerticalScrollRange = this.mRecyclerView.computeVerticalScrollRange();
        int i13 = this.mRecyclerViewHeight;
        if (computeVerticalScrollRange - i13 <= 0 || i13 < this.mScrollbarMinimumRange) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.mNeedVerticalScrollbar = z11;
        int computeHorizontalScrollRange = this.mRecyclerView.computeHorizontalScrollRange();
        int i14 = this.mRecyclerViewWidth;
        if (computeHorizontalScrollRange - i14 <= 0 || i14 < this.mScrollbarMinimumRange) {
            z12 = false;
        } else {
            z12 = true;
        }
        this.mNeedHorizontalScrollbar = z12;
        boolean z13 = this.mNeedVerticalScrollbar;
        if (z13 || z12) {
            if (z13) {
                float f11 = (float) i13;
                this.mVerticalThumbCenterY = (int) ((f11 * (((float) i12) + (f11 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.mVerticalThumbHeight = Math.min(i13, (i13 * i13) / computeVerticalScrollRange);
            }
            if (this.mNeedHorizontalScrollbar) {
                float f12 = (float) i14;
                this.mHorizontalThumbCenterX = (int) ((f12 * (((float) i11) + (f12 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.mHorizontalThumbWidth = Math.min(i14, (i14 * i14) / computeHorizontalScrollRange);
            }
            int i15 = this.mState;
            if (i15 == 0 || i15 == 1) {
                setState(1);
            }
        } else if (this.mState != 0) {
            setState(0);
        }
    }
}
