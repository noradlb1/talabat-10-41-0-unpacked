package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.R;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements Openable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.drawerlayout.widget.DrawerLayout";
    private static final boolean ALLOW_EDGE_LOCK = false;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION = true;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final int[] THEME_ATTRS = {16843828};
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f35849b = {16842931};

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f35850c = true;
    private static boolean sEdgeSizeUsingSystemGestureInsets;
    private final AccessibilityViewCommand mActionDismiss;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    @Nullable
    private DrawerListener mListener;
    private List<DrawerListener> mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        public AccessibilityDelegate() {
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (DrawerLayout.m(childAt)) {
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence drawerTitle;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View i11 = DrawerLayout.this.i();
            if (i11 == null || (drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.j(i11))) == null) {
                return true;
            }
            text.add(drawerTitle);
            return true;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.f35850c) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, obtain);
                accessibilityNodeInfoCompat.setSource(view);
                ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                }
                copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
                obtain.recycle();
                addChildrenForAccessibility(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
            accessibilityNodeInfoCompat.setFocusable(false);
            accessibilityNodeInfoCompat.setFocused(false);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f35850c || DrawerLayout.m(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.m(view)) {
                accessibilityNodeInfoCompat.setParent((View) null);
            }
        }
    }

    public interface DrawerListener {
        void onDrawerClosed(@NonNull View view);

        void onDrawerOpened(@NonNull View view);

        void onDrawerSlide(@NonNull View view, float f11);

        void onDrawerStateChanged(int i11);
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
        public void onDrawerClosed(View view) {
        }

        public void onDrawerOpened(View view) {
        }

        public void onDrawerSlide(View view, float f11) {
        }

        public void onDrawerStateChanged(int i11) {
        }
    }

    public class ViewDragCallback extends ViewDragHelper.Callback {
        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable = new Runnable() {
            public void run() {
                ViewDragCallback.this.a();
            }
        };

        public ViewDragCallback(int i11) {
            this.mAbsGravity = i11;
        }

        private void closeOtherDrawer() {
            int i11 = 3;
            if (this.mAbsGravity == 3) {
                i11 = 5;
            }
            View g11 = DrawerLayout.this.g(i11);
            if (g11 != null) {
                DrawerLayout.this.closeDrawer(g11);
            }
        }

        public void a() {
            boolean z11;
            View view;
            int i11;
            int edgeSize = this.mDragger.getEdgeSize();
            int i12 = 0;
            if (this.mAbsGravity == 3) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                view = DrawerLayout.this.g(3);
                if (view != null) {
                    i12 = -view.getWidth();
                }
                i11 = i12 + edgeSize;
            } else {
                view = DrawerLayout.this.g(5);
                i11 = DrawerLayout.this.getWidth() - edgeSize;
            }
            if (view == null) {
                return;
            }
            if (((z11 && view.getLeft() < i11) || (!z11 && view.getLeft() > i11)) && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                this.mDragger.smoothSlideViewTo(view, i11, view.getTop());
                ((LayoutParams) view.getLayoutParams()).f35855b = true;
                DrawerLayout.this.invalidate();
                closeOtherDrawer();
                DrawerLayout.this.a();
            }
        }

        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            if (DrawerLayout.this.b(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i11, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i11, width));
        }

        public int clampViewPositionVertical(View view, int i11, int i12) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.o(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public void onEdgeDragStarted(int i11, int i12) {
            View view;
            if ((i11 & 1) == 1) {
                view = DrawerLayout.this.g(3);
            } else {
                view = DrawerLayout.this.g(5);
            }
            if (view != null && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                this.mDragger.captureChildView(view, i12);
            }
        }

        public boolean onEdgeLock(int i11) {
            return false;
        }

        public void onEdgeTouched(int i11, int i12) {
            DrawerLayout.this.postDelayed(this.mPeekRunnable, 160);
        }

        public void onViewCaptured(View view, int i11) {
            ((LayoutParams) view.getLayoutParams()).f35855b = false;
            closeOtherDrawer();
        }

        public void onViewDragStateChanged(int i11) {
            DrawerLayout.this.r(i11, this.mDragger.getCapturedView());
        }

        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            float f11;
            int i15;
            int width = view.getWidth();
            if (DrawerLayout.this.b(view, 3)) {
                f11 = (float) (i11 + width);
            } else {
                f11 = (float) (DrawerLayout.this.getWidth() - i11);
            }
            float f12 = f11 / ((float) width);
            DrawerLayout.this.q(view, f12);
            if (f12 == 0.0f) {
                i15 = 4;
            } else {
                i15 = 0;
            }
            view.setVisibility(i15);
            DrawerLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f11, float f12) {
            int i11;
            float k11 = DrawerLayout.this.k(view);
            int width = view.getWidth();
            if (DrawerLayout.this.b(view, 3)) {
                int i12 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
                if (i12 > 0 || (i12 == 0 && k11 > 0.5f)) {
                    i11 = 0;
                } else {
                    i11 = -width;
                }
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f11 < 0.0f || (f11 == 0.0f && k11 > 0.5f)) {
                    width2 -= width;
                }
                i11 = width2;
            }
            this.mDragger.settleCapturedViewAt(i11, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public void removeCallbacks() {
            DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
        }

        public void setDragger(ViewDragHelper viewDragHelper) {
            this.mDragger = viewDragHelper;
        }

        public boolean tryCaptureView(View view, int i11) {
            if (!DrawerLayout.this.o(view) || !DrawerLayout.this.b(view, this.mAbsGravity) || DrawerLayout.this.getDrawerLockMode(view) != 0) {
                return false;
            }
            return true;
        }
    }

    static {
        boolean z11 = true;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 29) {
            z11 = false;
        }
        sEdgeSizeUsingSystemGestureInsets = z11;
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent transformedMotionEvent = getTransformedMotionEvent(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(transformedMotionEvent);
            transformedMotionEvent.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.mChildInvertedMatrix == null) {
                this.mChildInvertedMatrix = new Matrix();
            }
            matrix.invert(this.mChildInvertedMatrix);
            obtain.transform(this.mChildInvertedMatrix);
        }
        return obtain;
    }

    private static boolean hasOpaqueBackground(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    private boolean hasPeekingDrawer() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (((LayoutParams) getChildAt(i11).getLayoutParams()).f35855b) {
                return true;
            }
        }
        return false;
    }

    private boolean hasVisibleDrawer() {
        return i() != null;
    }

    private boolean isInBoundsOfChild(float f11, float f12, View view) {
        if (this.mChildHitRect == null) {
            this.mChildHitRect = new Rect();
        }
        view.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) f11, (int) f12);
    }

    public static String l(int i11) {
        if ((i11 & 3) == 3) {
            return "LEFT";
        }
        if ((i11 & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i11);
    }

    public static boolean m(View view) {
        if (ViewCompat.getImportantForAccessibility(view) == 4 || ViewCompat.getImportantForAccessibility(view) == 2) {
            return false;
        }
        return true;
    }

    private void mirror(Drawable drawable, int i11) {
        if (drawable != null && DrawableCompat.isAutoMirrored(drawable)) {
            DrawableCompat.setLayoutDirection(drawable, i11);
        }
    }

    private Drawable resolveLeftShadow() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.mShadowStart;
            if (drawable != null) {
                mirror(drawable, layoutDirection);
                return this.mShadowStart;
            }
        } else {
            Drawable drawable2 = this.mShadowEnd;
            if (drawable2 != null) {
                mirror(drawable2, layoutDirection);
                return this.mShadowEnd;
            }
        }
        return this.mShadowLeft;
    }

    private Drawable resolveRightShadow() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.mShadowEnd;
            if (drawable != null) {
                mirror(drawable, layoutDirection);
                return this.mShadowEnd;
            }
        } else {
            Drawable drawable2 = this.mShadowStart;
            if (drawable2 != null) {
                mirror(drawable2, layoutDirection);
                return this.mShadowStart;
            }
        }
        return this.mShadowRight;
    }

    private void resolveShadowDrawables() {
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
            this.mShadowLeftResolved = resolveLeftShadow();
            this.mShadowRightResolved = resolveRightShadow();
        }
    }

    private void updateChildAccessibilityAction(View view) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS;
        ViewCompat.removeAccessibilityAction(view, accessibilityActionCompat.getId());
        if (isDrawerOpen(view) && getDrawerLockMode(view) != 2) {
            ViewCompat.replaceAccessibilityAction(view, accessibilityActionCompat, (CharSequence) null, this.mActionDismiss);
        }
    }

    private void updateChildrenImportantForAccessibility(View view, boolean z11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((z11 || o(childAt)) && (!z11 || childAt != view)) {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            }
        }
    }

    public void a() {
        if (!this.mChildrenCanceledTouch) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                getChildAt(i11).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.mChildrenCanceledTouch = true;
        }
    }

    public void addDrawerListener(@NonNull DrawerListener drawerListener) {
        if (drawerListener != null) {
            if (this.mListeners == null) {
                this.mListeners = new ArrayList();
            }
            this.mListeners.add(drawerListener);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i11, int i12) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z11 = false;
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (!o(childAt)) {
                    this.mNonDrawerViews.add(childAt);
                } else if (isDrawerOpen(childAt)) {
                    childAt.addFocusables(arrayList, i11, i12);
                    z11 = true;
                }
            }
            if (!z11) {
                int size = this.mNonDrawerViews.size();
                for (int i14 = 0; i14 < size; i14++) {
                    View view = this.mNonDrawerViews.get(i14);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i11, i12);
                    }
                }
            }
            this.mNonDrawerViews.clear();
        }
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i11, layoutParams);
        if (h() != null || o(view)) {
            ViewCompat.setImportantForAccessibility(view, 4);
        } else {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
        if (!f35850c) {
            ViewCompat.setAccessibilityDelegate(view, this.mChildAccessibilityDelegate);
        }
    }

    public boolean b(View view, int i11) {
        return (j(view) & i11) == i11;
    }

    public void c(boolean z11) {
        boolean z12;
        int childCount = getChildCount();
        boolean z13 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (o(childAt) && (!z11 || layoutParams.f35855b)) {
                int width = childAt.getWidth();
                if (b(childAt, 3)) {
                    z12 = this.mLeftDragger.smoothSlideViewTo(childAt, -width, childAt.getTop());
                } else {
                    z12 = this.mRightDragger.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                }
                z13 |= z12;
                layoutParams.f35855b = false;
            }
        }
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (z13) {
            invalidate();
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void close() {
        closeDrawer((int) GravityCompat.START);
    }

    public void closeDrawer(@NonNull View view) {
        closeDrawer(view, true);
    }

    public void closeDrawers() {
        c(false);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f11 = 0.0f;
        for (int i11 = 0; i11 < childCount; i11++) {
            f11 = Math.max(f11, ((LayoutParams) getChildAt(i11).getLayoutParams()).f35854a);
        }
        this.mScrimOpacity = f11;
        boolean continueSettling = this.mLeftDragger.continueSettling(true);
        boolean continueSettling2 = this.mRightDragger.continueSettling(true);
        if (continueSettling || continueSettling2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void d(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f35856c & 1) == 1) {
            layoutParams.f35856c = 0;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerClosed(view);
                }
            }
            updateChildrenImportantForAccessibility(view, false);
            updateChildAccessibilityAction(view);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.mScrimOpacity <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            View childAt = getChildAt(i11);
            if (isInBoundsOfChild(x11, y11, childAt) && !n(childAt) && dispatchTransformedGenericPointerEvent(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    public boolean drawChild(Canvas canvas, View view, long j11) {
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean n11 = n(view2);
        int width = getWidth();
        int save = canvas.save();
        int i11 = 0;
        if (n11) {
            int childCount = getChildCount();
            int i12 = 0;
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (childAt != view2 && childAt.getVisibility() == 0 && hasOpaqueBackground(childAt) && o(childAt) && childAt.getHeight() >= height) {
                    if (b(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i12) {
                            i12 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i12, 0, width, getHeight());
            i11 = i12;
        }
        boolean drawChild = super.drawChild(canvas, view, j11);
        canvas.restoreToCount(save);
        float f11 = this.mScrimOpacity;
        if (f11 > 0.0f && n11) {
            int i14 = this.mScrimColor;
            this.mScrimPaint.setColor((i14 & 16777215) | (((int) (((float) ((-16777216 & i14) >>> 24)) * f11)) << 24));
            canvas.drawRect((float) i11, 0.0f, (float) width, (float) getHeight(), this.mScrimPaint);
        } else if (this.mShadowLeftResolved != null && b(view2, 3)) {
            int intrinsicWidth = this.mShadowLeftResolved.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.mLeftDragger.getEdgeSize()), 1.0f));
            this.mShadowLeftResolved.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.mShadowLeftResolved.setAlpha((int) (max * 255.0f));
            this.mShadowLeftResolved.draw(canvas);
        } else if (this.mShadowRightResolved != null && b(view2, 5)) {
            int intrinsicWidth2 = this.mShadowRightResolved.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.mRightDragger.getEdgeSize()), 1.0f));
            this.mShadowRightResolved.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.mShadowRightResolved.setAlpha((int) (max2 * 255.0f));
            this.mShadowRightResolved.draw(canvas);
        }
        return drawChild;
    }

    public void e(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f35856c & 1) == 0) {
            layoutParams.f35856c = 1;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerOpened(view);
                }
            }
            updateChildrenImportantForAccessibility(view, true);
            updateChildAccessibilityAction(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    public void f(View view, float f11) {
        List<DrawerListener> list = this.mListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onDrawerSlide(view, f11);
            }
        }
    }

    public View g(int i11) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this)) & 7;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if ((j(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return this.mDrawerElevation;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i11) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (i11 == 3) {
            int i12 = this.mLockModeLeft;
            if (i12 != 3) {
                return i12;
            }
            int i13 = layoutDirection == 0 ? this.mLockModeStart : this.mLockModeEnd;
            if (i13 != 3) {
                return i13;
            }
            return 0;
        } else if (i11 == 5) {
            int i14 = this.mLockModeRight;
            if (i14 != 3) {
                return i14;
            }
            int i15 = layoutDirection == 0 ? this.mLockModeEnd : this.mLockModeStart;
            if (i15 != 3) {
                return i15;
            }
            return 0;
        } else if (i11 == 8388611) {
            int i16 = this.mLockModeStart;
            if (i16 != 3) {
                return i16;
            }
            int i17 = layoutDirection == 0 ? this.mLockModeLeft : this.mLockModeRight;
            if (i17 != 3) {
                return i17;
            }
            return 0;
        } else if (i11 != 8388613) {
            return 0;
        } else {
            int i18 = this.mLockModeEnd;
            if (i18 != 3) {
                return i18;
            }
            int i19 = layoutDirection == 0 ? this.mLockModeRight : this.mLockModeLeft;
            if (i19 != 3) {
                return i19;
            }
            return 0;
        }
    }

    @Nullable
    public CharSequence getDrawerTitle(int i11) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.mTitleLeft;
        }
        if (absoluteGravity == 5) {
            return this.mTitleRight;
        }
        return null;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    public View h() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((((LayoutParams) childAt.getLayoutParams()).f35856c & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public View i() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (o(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public boolean isDrawerOpen(@NonNull View view) {
        if (o(view)) {
            return (((LayoutParams) view.getLayoutParams()).f35856c & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerVisible(@NonNull View view) {
        if (o(view)) {
            return ((LayoutParams) view.getLayoutParams()).f35854a > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isOpen() {
        return isDrawerOpen((int) GravityCompat.START);
    }

    public int j(View view) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    public float k(View view) {
        return ((LayoutParams) view.getLayoutParams()).f35854a;
    }

    public boolean n(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    public boolean o(View view) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view));
        if ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) {
            return false;
        }
        return true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    public void onDraw(Canvas canvas) {
        int i11;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            Object obj = this.mLastInsets;
            if (obj != null) {
                i11 = ((WindowInsets) obj).getSystemWindowInsetTop();
            } else {
                i11 = 0;
            }
            if (i11 > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), i11);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r6.mLeftDragger
            boolean r1 = r1.shouldInterceptTouchEvent(r7)
            androidx.customview.widget.ViewDragHelper r2 = r6.mRightDragger
            boolean r2 = r2.shouldInterceptTouchEvent(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0038
            if (r0 == r2) goto L_0x0031
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L_0x001e
            if (r0 == r4) goto L_0x0031
            goto L_0x0036
        L_0x001e:
            androidx.customview.widget.ViewDragHelper r7 = r6.mLeftDragger
            boolean r7 = r7.checkTouchSlop(r4)
            if (r7 == 0) goto L_0x0036
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.mLeftCallback
            r7.removeCallbacks()
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.mRightCallback
            r7.removeCallbacks()
            goto L_0x0036
        L_0x0031:
            r6.c(r2)
            r6.mChildrenCanceledTouch = r3
        L_0x0036:
            r7 = r3
            goto L_0x0060
        L_0x0038:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.mInitialMotionX = r0
            r6.mInitialMotionY = r7
            float r4 = r6.mScrimOpacity
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005d
            androidx.customview.widget.ViewDragHelper r4 = r6.mLeftDragger
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.findTopChildUnder(r0, r7)
            if (r7 == 0) goto L_0x005d
            boolean r7 = r6.n(r7)
            if (r7 == 0) goto L_0x005d
            r7 = r2
            goto L_0x005e
        L_0x005d:
            r7 = r3
        L_0x005e:
            r6.mChildrenCanceledTouch = r3
        L_0x0060:
            if (r1 != 0) goto L_0x0070
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.hasPeekingDrawer()
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.mChildrenCanceledTouch
            if (r7 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = r3
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4 || !hasVisibleDrawer()) {
            return super.onKeyDown(i11, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return super.onKeyUp(i11, keyEvent);
        }
        View i12 = i();
        if (i12 != null && getDrawerLockMode(i12) == 0) {
            closeDrawers();
        }
        if (i12 != null) {
            return true;
        }
        return false;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        WindowInsets rootWindowInsets;
        float f11;
        int i15;
        boolean z12;
        int i16;
        boolean z13 = true;
        this.mInLayout = true;
        int i17 = i13 - i11;
        int childCount = getChildCount();
        int i18 = 0;
        while (i18 < childCount) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (n(childAt)) {
                    int i19 = layoutParams.leftMargin;
                    childAt.layout(i19, layoutParams.topMargin, childAt.getMeasuredWidth() + i19, layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b(childAt, 3)) {
                        float f12 = (float) measuredWidth;
                        i15 = (-measuredWidth) + ((int) (layoutParams.f35854a * f12));
                        f11 = ((float) (measuredWidth + i15)) / f12;
                    } else {
                        float f13 = (float) measuredWidth;
                        int i21 = i17 - ((int) (layoutParams.f35854a * f13));
                        f11 = ((float) (i17 - i21)) / f13;
                        i15 = i21;
                    }
                    if (f11 != layoutParams.f35854a) {
                        z12 = z13;
                    } else {
                        z12 = false;
                    }
                    int i22 = layoutParams.gravity & 112;
                    if (i22 == 16) {
                        int i23 = i14 - i12;
                        int i24 = (i23 - measuredHeight) / 2;
                        int i25 = layoutParams.topMargin;
                        if (i24 < i25) {
                            i24 = i25;
                        } else {
                            int i26 = i24 + measuredHeight;
                            int i27 = layoutParams.bottomMargin;
                            if (i26 > i23 - i27) {
                                i24 = (i23 - i27) - measuredHeight;
                            }
                        }
                        childAt.layout(i15, i24, measuredWidth + i15, measuredHeight + i24);
                    } else if (i22 != 80) {
                        int i28 = layoutParams.topMargin;
                        childAt.layout(i15, i28, measuredWidth + i15, measuredHeight + i28);
                    } else {
                        int i29 = i14 - i12;
                        childAt.layout(i15, (i29 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i15, i29 - layoutParams.bottomMargin);
                    }
                    if (z12) {
                        q(childAt, f11);
                    }
                    if (layoutParams.f35854a > 0.0f) {
                        i16 = 0;
                    } else {
                        i16 = 4;
                    }
                    if (childAt.getVisibility() != i16) {
                        childAt.setVisibility(i16);
                    }
                }
            }
            i18++;
            z13 = true;
        }
        if (sEdgeSizeUsingSystemGestureInsets && (rootWindowInsets = getRootWindowInsets()) != null) {
            Insets systemGestureInsets = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets).getSystemGestureInsets();
            ViewDragHelper viewDragHelper = this.mLeftDragger;
            viewDragHelper.setEdgeSize(Math.max(viewDragHelper.getDefaultEdgeSize(), systemGestureInsets.left));
            ViewDragHelper viewDragHelper2 = this.mRightDragger;
            viewDragHelper2.setEdgeSize(Math.max(viewDragHelper2.getDefaultEdgeSize(), systemGestureInsets.right));
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i11, int i12) {
        boolean z11;
        boolean z12;
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        if (this.mLastInsets == null || !ViewCompat.getFitsSystemWindows(this)) {
            z11 = false;
        } else {
            z11 = true;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int childCount = getChildCount();
        boolean z13 = false;
        boolean z14 = false;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z11) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.gravity, layoutDirection);
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        WindowInsets windowInsets = (WindowInsets) this.mLastInsets;
                        if (absoluteGravity == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsets);
                    } else {
                        WindowInsets windowInsets2 = (WindowInsets) this.mLastInsets;
                        if (absoluteGravity == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), 0, windowInsets2.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(0, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets2.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (n(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (o(childAt)) {
                    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
                        float elevation = ViewCompat.getElevation(childAt);
                        float f11 = this.mDrawerElevation;
                        if (elevation != f11) {
                            ViewCompat.setElevation(childAt, f11);
                        }
                    }
                    int j11 = j(childAt) & 7;
                    if (j11 == 3) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if ((!z12 || !z13) && (z12 || !z14)) {
                        if (z12) {
                            z13 = true;
                        } else {
                            z14 = true;
                        }
                        childAt.measure(ViewGroup.getChildMeasureSpec(i11, this.mMinDrawerMargin + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), ViewGroup.getChildMeasureSpec(i12, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + l(j11) + " but this " + TAG + " already has a drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i13 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            int i14 = i11;
            int i15 = i12;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        View g11;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i11 = savedState.f35857b;
        if (!(i11 == 0 || (g11 = g(i11)) == null)) {
            openDrawer(g11);
        }
        int i12 = savedState.f35858c;
        if (i12 != 3) {
            setDrawerLockMode(i12, 3);
        }
        int i13 = savedState.f35859d;
        if (i13 != 3) {
            setDrawerLockMode(i13, 5);
        }
        int i14 = savedState.f35860e;
        if (i14 != 3) {
            setDrawerLockMode(i14, (int) GravityCompat.START);
        }
        int i15 = savedState.f35861f;
        if (i15 != 3) {
            setDrawerLockMode(i15, (int) GravityCompat.END);
        }
    }

    public void onRtlPropertiesChanged(int i11) {
        resolveShadowDrawables();
    }

    public Parcelable onSaveInstanceState() {
        boolean z11;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i11).getLayoutParams();
            int i12 = layoutParams.f35856c;
            boolean z12 = true;
            if (i12 == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (i12 != 2) {
                z12 = false;
            }
            if (z11 || z12) {
                savedState.f35857b = layoutParams.gravity;
            } else {
                i11++;
            }
        }
        savedState.f35858c = this.mLockModeLeft;
        savedState.f35859d = this.mLockModeRight;
        savedState.f35860e = this.mLockModeStart;
        savedState.f35861f = this.mLockModeEnd;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        if (getDrawerLockMode(r7) != 2) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.mLeftDragger
            r0.processTouchEvent(r7)
            androidx.customview.widget.ViewDragHelper r0 = r6.mRightDragger
            r0.processTouchEvent(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x005f
            if (r0 == r2) goto L_0x0020
            r7 = 3
            if (r0 == r7) goto L_0x001a
            goto L_0x006d
        L_0x001a:
            r6.c(r2)
            r6.mChildrenCanceledTouch = r1
            goto L_0x006d
        L_0x0020:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.widget.ViewDragHelper r3 = r6.mLeftDragger
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.findTopChildUnder(r4, r5)
            if (r3 == 0) goto L_0x005a
            boolean r3 = r6.n(r3)
            if (r3 == 0) goto L_0x005a
            float r3 = r6.mInitialMotionX
            float r0 = r0 - r3
            float r3 = r6.mInitialMotionY
            float r7 = r7 - r3
            androidx.customview.widget.ViewDragHelper r3 = r6.mLeftDragger
            int r3 = r3.getTouchSlop()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x005a
            android.view.View r7 = r6.h()
            if (r7 == 0) goto L_0x005a
            int r7 = r6.getDrawerLockMode((android.view.View) r7)
            r0 = 2
            if (r7 != r0) goto L_0x005b
        L_0x005a:
            r1 = r2
        L_0x005b:
            r6.c(r1)
            goto L_0x006d
        L_0x005f:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.mInitialMotionX = r0
            r6.mInitialMotionY = r7
            r6.mChildrenCanceledTouch = r1
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void open() {
        openDrawer((int) GravityCompat.START);
    }

    public void openDrawer(@NonNull View view) {
        openDrawer(view, true);
    }

    public void p(View view, float f11) {
        float k11 = k(view);
        float width = (float) view.getWidth();
        int i11 = ((int) (width * f11)) - ((int) (k11 * width));
        if (!b(view, 3)) {
            i11 = -i11;
        }
        view.offsetLeftAndRight(i11);
        q(view, f11);
    }

    public void q(View view, float f11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f11 != layoutParams.f35854a) {
            layoutParams.f35854a = f11;
            f(view, f11);
        }
    }

    public void r(int i11, View view) {
        int i12;
        int viewDragState = this.mLeftDragger.getViewDragState();
        int viewDragState2 = this.mRightDragger.getViewDragState();
        if (viewDragState == 1 || viewDragState2 == 1) {
            i12 = 1;
        } else {
            i12 = 2;
            if (!(viewDragState == 2 || viewDragState2 == 2)) {
                i12 = 0;
            }
        }
        if (view != null && i11 == 0) {
            float f11 = ((LayoutParams) view.getLayoutParams()).f35854a;
            if (f11 == 0.0f) {
                d(view);
            } else if (f11 == 1.0f) {
                e(view);
            }
        }
        if (i12 != this.mDrawerState) {
            this.mDrawerState = i12;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerStateChanged(i12);
                }
            }
        }
    }

    public void removeDrawerListener(@NonNull DrawerListener drawerListener) {
        List<DrawerListener> list;
        if (drawerListener != null && (list = this.mListeners) != null) {
            list.remove(drawerListener);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z11) {
        super.requestDisallowInterceptTouchEvent(z11);
        if (z11) {
            c(true);
        }
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setChildInsets(Object obj, boolean z11) {
        boolean z12;
        this.mLastInsets = obj;
        this.mDrawStatusBarBackground = z11;
        if (z11 || getBackground() != null) {
            z12 = false;
        } else {
            z12 = true;
        }
        setWillNotDraw(z12);
        requestLayout();
    }

    public void setDrawerElevation(float f11) {
        this.mDrawerElevation = f11;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (o(childAt)) {
                ViewCompat.setElevation(childAt, this.mDrawerElevation);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.mListener;
        if (drawerListener2 != null) {
            removeDrawerListener(drawerListener2);
        }
        if (drawerListener != null) {
            addDrawerListener(drawerListener);
        }
        this.mListener = drawerListener;
    }

    public void setDrawerLockMode(int i11) {
        setDrawerLockMode(i11, 3);
        setDrawerLockMode(i11, 5);
    }

    public void setDrawerShadow(Drawable drawable, int i11) {
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
            if ((i11 & GravityCompat.START) == 8388611) {
                this.mShadowStart = drawable;
            } else if ((i11 & GravityCompat.END) == 8388613) {
                this.mShadowEnd = drawable;
            } else if ((i11 & 3) == 3) {
                this.mShadowLeft = drawable;
            } else if ((i11 & 5) == 5) {
                this.mShadowRight = drawable;
            } else {
                return;
            }
            resolveShadowDrawables();
            invalidate();
        }
    }

    public void setDrawerTitle(int i11, @Nullable CharSequence charSequence) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.mTitleLeft = charSequence;
        } else if (absoluteGravity == 5) {
            this.mTitleRight = charSequence;
        }
    }

    public void setScrimColor(@ColorInt int i11) {
        this.mScrimColor = i11;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.mStatusBarBackground = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i11) {
        this.mStatusBarBackground = new ColorDrawable(i11);
        invalidate();
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.drawerLayoutStyle);
    }

    public void closeDrawer(@NonNull View view, boolean z11) {
        if (o(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.f35854a = 0.0f;
                layoutParams.f35856c = 0;
            } else if (z11) {
                layoutParams.f35856c |= 4;
                if (b(view, 3)) {
                    this.mLeftDragger.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
                } else {
                    this.mRightDragger.smoothSlideViewTo(view, getWidth(), view.getTop());
                }
            } else {
                p(view, 0.0f);
                r(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void openDrawer(@NonNull View view, boolean z11) {
        if (o(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.f35854a = 1.0f;
                layoutParams.f35856c = 1;
                updateChildrenImportantForAccessibility(view, true);
                updateChildAccessibilityAction(view);
            } else if (z11) {
                layoutParams.f35856c |= 2;
                if (b(view, 3)) {
                    this.mLeftDragger.smoothSlideViewTo(view, 0, view.getTop());
                } else {
                    this.mRightDragger.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                p(view, 1.0f);
                r(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* JADX INFO: finally extract failed */
    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        this.mActionDismiss = new AccessibilityViewCommand() {
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                if (!DrawerLayout.this.isDrawerOpen(view) || DrawerLayout.this.getDrawerLockMode(view) == 2) {
                    return false;
                }
                DrawerLayout.this.closeDrawer(view);
                return true;
            }
        };
        setDescendantFocusability(262144);
        float f11 = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * f11) + 0.5f);
        float f12 = f11 * 400.0f;
        ViewDragCallback viewDragCallback = new ViewDragCallback(3);
        this.mLeftCallback = viewDragCallback;
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(5);
        this.mRightCallback = viewDragCallback2;
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, viewDragCallback);
        this.mLeftDragger = create;
        create.setEdgeTrackingEnabled(1);
        create.setMinVelocity(f12);
        viewDragCallback.setDragger(create);
        ViewDragHelper create2 = ViewDragHelper.create(this, 1.0f, viewDragCallback2);
        this.mRightDragger = create2;
        create2.setEdgeTrackingEnabled(2);
        create2.setMinVelocity(f12);
        viewDragCallback2.setDragger(create2);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    boolean z11;
                    DrawerLayout drawerLayout = (DrawerLayout) view;
                    if (windowInsets.getSystemWindowInsetTop() > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    drawerLayout.setChildInsets(windowInsets, z11);
                    return windowInsets.consumeSystemWindowInsets();
                }
            });
            setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(THEME_ATTRS);
            try {
                this.mStatusBarBackground = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.DrawerLayout, i11, 0);
        try {
            int i12 = R.styleable.DrawerLayout_elevation;
            if (obtainStyledAttributes2.hasValue(i12)) {
                this.mDrawerElevation = obtainStyledAttributes2.getDimension(i12, 0.0f);
            } else {
                this.mDrawerElevation = getResources().getDimension(R.dimen.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.mNonDrawerViews = new ArrayList<>();
        } catch (Throwable th2) {
            obtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    public void setDrawerLockMode(int i11, int i12) {
        View g11;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i12, ViewCompat.getLayoutDirection(this));
        if (i12 == 3) {
            this.mLockModeLeft = i11;
        } else if (i12 == 5) {
            this.mLockModeRight = i11;
        } else if (i12 == 8388611) {
            this.mLockModeStart = i11;
        } else if (i12 == 8388613) {
            this.mLockModeEnd = i11;
        }
        if (i11 != 0) {
            (absoluteGravity == 3 ? this.mLeftDragger : this.mRightDragger).cancel();
        }
        if (i11 == 1) {
            View g12 = g(absoluteGravity);
            if (g12 != null) {
                closeDrawer(g12);
            }
        } else if (i11 == 2 && (g11 = g(absoluteGravity)) != null) {
            openDrawer(g11);
        }
    }

    public void setStatusBarBackground(int i11) {
        this.mStatusBarBackground = i11 != 0 ? ContextCompat.getDrawable(getContext(), i11) : null;
        invalidate();
    }

    public boolean isDrawerVisible(int i11) {
        View g11 = g(i11);
        if (g11 != null) {
            return isDrawerVisible(g11);
        }
        return false;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int FLAG_IS_CLOSING = 4;
        private static final int FLAG_IS_OPENED = 1;
        private static final int FLAG_IS_OPENING = 2;

        /* renamed from: a  reason: collision with root package name */
        public float f35854a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f35855b;

        /* renamed from: c  reason: collision with root package name */
        public int f35856c;
        public int gravity;

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f35849b);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
            this.gravity = 0;
        }

        public LayoutParams(int i11, int i12, int i13) {
            this(i11, i12);
            this.gravity = i13;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = 0;
        }
    }

    public boolean isDrawerOpen(int i11) {
        View g11 = g(i11);
        if (g11 != null) {
            return isDrawerOpen(g11);
        }
        return false;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public int f35857b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f35858c;

        /* renamed from: d  reason: collision with root package name */
        public int f35859d;

        /* renamed from: e  reason: collision with root package name */
        public int f35860e;

        /* renamed from: f  reason: collision with root package name */
        public int f35861f;

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f35857b = parcel.readInt();
            this.f35858c = parcel.readInt();
            this.f35859d = parcel.readInt();
            this.f35860e = parcel.readInt();
            this.f35861f = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f35857b);
            parcel.writeInt(this.f35858c);
            parcel.writeInt(this.f35859d);
            parcel.writeInt(this.f35860e);
            parcel.writeInt(this.f35861f);
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setDrawerShadow(@DrawableRes int i11, int i12) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), i11), i12);
    }

    public int getDrawerLockMode(@NonNull View view) {
        if (o(view)) {
            return getDrawerLockMode(((LayoutParams) view.getLayoutParams()).gravity);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void setDrawerLockMode(int i11, @NonNull View view) {
        if (o(view)) {
            setDrawerLockMode(i11, ((LayoutParams) view.getLayoutParams()).gravity);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public void closeDrawer(int i11) {
        closeDrawer(i11, true);
    }

    public void closeDrawer(int i11, boolean z11) {
        View g11 = g(i11);
        if (g11 != null) {
            closeDrawer(g11, z11);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + l(i11));
    }

    public void openDrawer(int i11) {
        openDrawer(i11, true);
    }

    public void openDrawer(int i11, boolean z11) {
        View g11 = g(i11);
        if (g11 != null) {
            openDrawer(g11, z11);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + l(i11));
    }
}
