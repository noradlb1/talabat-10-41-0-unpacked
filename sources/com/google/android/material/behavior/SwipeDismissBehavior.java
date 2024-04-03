package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float alphaEndSwipeDistance = 0.5f;
    float alphaStartSwipeDistance = 0.0f;
    private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        private static final int INVALID_POINTER_ID = -1;
        private int activePointerId = -1;
        private int originalCapturedViewLeft;

        private boolean shouldDismiss(@NonNull View view, float f11) {
            boolean z11;
            int i11 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
            if (i11 != 0) {
                if (ViewCompat.getLayoutDirection(view) == 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int i12 = SwipeDismissBehavior.this.swipeDirection;
                if (i12 == 2) {
                    return true;
                }
                if (i12 == 0) {
                    if (z11) {
                        if (f11 >= 0.0f) {
                            return false;
                        }
                    } else if (i11 <= 0) {
                        return false;
                    }
                    return true;
                } else if (i12 != 1) {
                    return false;
                } else {
                    if (z11) {
                        if (i11 <= 0) {
                            return false;
                        }
                    } else if (f11 >= 0.0f) {
                        return false;
                    }
                    return true;
                }
            } else {
                if (Math.abs(view.getLeft() - this.originalCapturedViewLeft) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.dragDismissThreshold)) {
                    return true;
                }
                return false;
            }
        }

        public int clampViewPositionHorizontal(@NonNull View view, int i11, int i12) {
            boolean z11;
            int i13;
            int i14;
            int width;
            if (ViewCompat.getLayoutDirection(view) == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            int i15 = SwipeDismissBehavior.this.swipeDirection;
            if (i15 != 0) {
                if (i15 != 1) {
                    i13 = this.originalCapturedViewLeft - view.getWidth();
                    i14 = view.getWidth() + this.originalCapturedViewLeft;
                } else if (z11) {
                    i13 = this.originalCapturedViewLeft;
                    width = view.getWidth();
                } else {
                    i13 = this.originalCapturedViewLeft - view.getWidth();
                    i14 = this.originalCapturedViewLeft;
                }
                return SwipeDismissBehavior.clamp(i13, i11, i14);
            } else if (z11) {
                i13 = this.originalCapturedViewLeft - view.getWidth();
                i14 = this.originalCapturedViewLeft;
                return SwipeDismissBehavior.clamp(i13, i11, i14);
            } else {
                i13 = this.originalCapturedViewLeft;
                width = view.getWidth();
            }
            i14 = width + i13;
            return SwipeDismissBehavior.clamp(i13, i11, i14);
        }

        public int clampViewPositionVertical(@NonNull View view, int i11, int i12) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return view.getWidth();
        }

        public void onViewCaptured(@NonNull View view, int i11) {
            this.activePointerId = i11;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void onViewDragStateChanged(int i11) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i11);
            }
        }

        public void onViewPositionChanged(@NonNull View view, int i11, int i12, int i13, int i14) {
            float width = ((float) this.originalCapturedViewLeft) + (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaStartSwipeDistance);
            float width2 = ((float) this.originalCapturedViewLeft) + (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaEndSwipeDistance);
            float f11 = (float) i11;
            if (f11 <= width) {
                view.setAlpha(1.0f);
            } else if (f11 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.clamp(0.0f, 1.0f - SwipeDismissBehavior.fraction(width, width2, f11), 1.0f));
            }
        }

        public void onViewReleased(@NonNull View view, float f11, float f12) {
            boolean z11;
            int i11;
            OnDismissListener onDismissListener;
            this.activePointerId = -1;
            int width = view.getWidth();
            if (shouldDismiss(view, f11)) {
                int left = view.getLeft();
                int i12 = this.originalCapturedViewLeft;
                if (left < i12) {
                    i11 = i12 - width;
                } else {
                    i11 = i12 + width;
                }
                z11 = true;
            } else {
                i11 = this.originalCapturedViewLeft;
                z11 = false;
            }
            if (SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(i11, view.getTop())) {
                ViewCompat.postOnAnimation(view, new SettleRunnable(view, z11));
            } else if (z11 && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                onDismissListener.onDismiss(view);
            }
        }

        public boolean tryCaptureView(View view, int i11) {
            int i12 = this.activePointerId;
            if ((i12 == -1 || i12 == i11) && SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                return true;
            }
            return false;
        }
    };
    float dragDismissThreshold = 0.5f;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private float sensitivity = 0.0f;
    private boolean sensitivitySet;
    int swipeDirection = 2;
    ViewDragHelper viewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i11);
    }

    public class SettleRunnable implements Runnable {
        private final boolean dismiss;
        private final View view;

        public SettleRunnable(View view2, boolean z11) {
            this.view = view2;
            this.dismiss = z11;
        }

        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.viewDragHelper;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.view, this);
            } else if (this.dismiss && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                onDismissListener.onDismiss(this.view);
            }
        }
    }

    public static float clamp(float f11, float f12, float f13) {
        return Math.min(Math.max(f11, f12), f13);
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        ViewDragHelper viewDragHelper2;
        if (this.viewDragHelper == null) {
            if (this.sensitivitySet) {
                viewDragHelper2 = ViewDragHelper.create(viewGroup, this.sensitivity, this.dragCallback);
            } else {
                viewDragHelper2 = ViewDragHelper.create(viewGroup, this.dragCallback);
            }
            this.viewDragHelper = viewDragHelper2;
        }
    }

    public static float fraction(float f11, float f12, float f13) {
        return (f13 - f11) / (f12 - f11);
    }

    private void updateAccessibilityActions(View view) {
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (canSwipeDismissView(view)) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, (CharSequence) null, new AccessibilityViewCommand() {
                public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                    boolean z11;
                    boolean z12 = false;
                    if (!SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                        return false;
                    }
                    if (ViewCompat.getLayoutDirection(view) == 1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int i11 = SwipeDismissBehavior.this.swipeDirection;
                    if ((i11 == 0 && z11) || (i11 == 1 && !z11)) {
                        z12 = true;
                    }
                    int width = view.getWidth();
                    if (z12) {
                        width = -width;
                    }
                    ViewCompat.offsetLeftAndRight(view, width);
                    view.setAlpha(0.0f);
                    OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(view);
                    }
                    return true;
                }
            });
        }
    }

    public boolean canSwipeDismissView(@NonNull View view) {
        return true;
    }

    public int getDragState() {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 != null) {
            return viewDragHelper2.getViewDragState();
        }
        return 0;
    }

    @VisibleForTesting
    @Nullable
    public OnDismissListener getListener() {
        return this.listener;
    }

    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
        boolean z11 = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z11 = coordinatorLayout.isPointInChildBounds(v11, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = z11;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!z11) {
            return false;
        }
        ensureViewDragHelper(coordinatorLayout);
        return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v11, i11);
        if (ViewCompat.getImportantForAccessibility(v11) == 0) {
            ViewCompat.setImportantForAccessibility(v11, 1);
            updateAccessibilityActions(v11);
        }
        return onLayoutChild;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v11, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 == null) {
            return false;
        }
        viewDragHelper2.processTouchEvent(motionEvent);
        return true;
    }

    public void setDragDismissDistance(float f11) {
        this.dragDismissThreshold = clamp(0.0f, f11, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f11) {
        this.alphaEndSwipeDistance = clamp(0.0f, f11, 1.0f);
    }

    public void setListener(@Nullable OnDismissListener onDismissListener) {
        this.listener = onDismissListener;
    }

    public void setSensitivity(float f11) {
        this.sensitivity = f11;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float f11) {
        this.alphaStartSwipeDistance = clamp(0.0f, f11, 1.0f);
    }

    public void setSwipeDirection(int i11) {
        this.swipeDirection = i11;
    }

    public static int clamp(int i11, int i12, int i13) {
        return Math.min(Math.max(i11, i12), i13);
    }
}
