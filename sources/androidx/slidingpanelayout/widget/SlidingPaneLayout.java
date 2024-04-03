package androidx.slidingpanelayout.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import androidx.window.layout.FoldingFeature;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import t2.e;

public class SlidingPaneLayout extends ViewGroup implements Openable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.slidingpanelayout.widget.SlidingPaneLayout";
    public static final int LOCK_MODE_LOCKED = 3;
    public static final int LOCK_MODE_LOCKED_CLOSED = 2;
    public static final int LOCK_MODE_LOCKED_OPEN = 1;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private static boolean sEdgeSizeUsingSystemGestureInsets = (Build.VERSION.SDK_INT >= 29);

    /* renamed from: b  reason: collision with root package name */
    public View f37597b;

    /* renamed from: c  reason: collision with root package name */
    public float f37598c;

    /* renamed from: d  reason: collision with root package name */
    public int f37599d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37600e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewDragHelper f37601f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37602g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<DisableLayerRunnable> f37603h;

    /* renamed from: i  reason: collision with root package name */
    public FoldingFeature f37604i;
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    private boolean mFirstLayout;
    private FoldingFeatureObserver mFoldingFeatureObserver;
    private Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mLockMode;
    private FoldingFeatureObserver.OnFoldingFeatureChangeListener mOnFoldingFeatureChangeListener;
    @Nullable
    private PanelSlideListener mPanelSlideListener;
    private final List<PanelSlideListener> mPanelSlideListeners;
    private int mParallaxBy;
    private float mParallaxOffset;
    private Field mRecreateDisplayList;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        public AccessibilityDelegate() {
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
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean filter(View view) {
            return SlidingPaneLayout.this.e(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.ACCESSIBILITY_CLASS_NAME);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.ACCESSIBILITY_CLASS_NAME);
            accessibilityNodeInfoCompat.setSource(view);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i11);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!filter(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public class DisableLayerRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final View f37607b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SlidingPaneLayout f37608c;

        public void run() {
            if (this.f37607b.getParent() == this.f37608c) {
                this.f37607b.setLayerType(0, (Paint) null);
                this.f37608c.d(this.f37607b);
            }
            this.f37608c.f37603h.remove(this);
        }
    }

    public class DragHelperCallback extends ViewDragHelper.Callback {
        public DragHelperCallback() {
        }

        private boolean isDraggable() {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.f37600e || slidingPaneLayout.getLockMode() == 3) {
                return false;
            }
            if (SlidingPaneLayout.this.isOpen() && SlidingPaneLayout.this.getLockMode() == 1) {
                return false;
            }
            if (SlidingPaneLayout.this.isOpen() || SlidingPaneLayout.this.getLockMode() != 2) {
                return true;
            }
            return false;
        }

        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f37597b.getLayoutParams();
            if (SlidingPaneLayout.this.f()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.f37597b.getWidth());
                return Math.max(Math.min(i11, width), width - SlidingPaneLayout.this.f37599d);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i11, paddingLeft), SlidingPaneLayout.this.f37599d + paddingLeft);
        }

        public int clampViewPositionVertical(View view, int i11, int i12) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.f37599d;
        }

        public void onEdgeDragStarted(int i11, int i12) {
            if (isDraggable()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f37601f.captureChildView(slidingPaneLayout.f37597b, i12);
            }
        }

        public void onEdgeTouched(int i11, int i12) {
            if (isDraggable()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f37601f.captureChildView(slidingPaneLayout.f37597b, i12);
            }
        }

        public void onViewCaptured(View view, int i11) {
            SlidingPaneLayout.this.h();
        }

        public void onViewDragStateChanged(int i11) {
            if (SlidingPaneLayout.this.f37601f.getViewDragState() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f37598c == 1.0f) {
                    slidingPaneLayout.j(slidingPaneLayout.f37597b);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.a(slidingPaneLayout2.f37597b);
                    SlidingPaneLayout.this.f37602g = false;
                    return;
                }
                slidingPaneLayout.b(slidingPaneLayout.f37597b);
                SlidingPaneLayout.this.f37602g = true;
            }
        }

        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            SlidingPaneLayout.this.g(i11);
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f11, float f12) {
            int i11;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.f()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f11 < 0.0f || (f11 == 0.0f && SlidingPaneLayout.this.f37598c > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f37599d;
                }
                i11 = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f37597b.getWidth();
            } else {
                i11 = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i12 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
                if (i12 > 0 || (i12 == 0 && SlidingPaneLayout.this.f37598c > 0.5f)) {
                    i11 += SlidingPaneLayout.this.f37599d;
                }
            }
            SlidingPaneLayout.this.f37601f.settleCapturedViewAt(i11, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i11) {
            if (!isDraggable()) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f37610a;
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View view);

        void onPanelOpened(@NonNull View view);

        void onPanelSlide(@NonNull View view, float f11);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public boolean f37613b;

        /* renamed from: c  reason: collision with root package name */
        public int f37614c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f37613b ? 1 : 0);
            parcel.writeInt(this.f37614c);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f37613b = parcel.readInt() != 0;
            this.f37614c = parcel.readInt();
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void onPanelClosed(@NonNull View view) {
        }

        public void onPanelOpened(@NonNull View view) {
        }

        public void onPanelSlide(@NonNull View view, float f11) {
        }
    }

    public static class TouchBlocker extends FrameLayout {
        public TouchBlocker(View view) {
            super(view.getContext());
            addView(view);
        }

        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean closePane(int i11) {
        if (!this.mCanSlide) {
            this.f37602g = false;
        }
        if (!this.mFirstLayout && !i(1.0f, i11)) {
            return false;
        }
        this.f37602g = false;
        return true;
    }

    @Nullable
    private static Activity getActivityOrNull(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private static Rect getFoldBoundsInView(@NonNull FoldingFeature foldingFeature, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i11 = iArr[0];
        Rect rect = new Rect(i11, iArr[1], view.getWidth() + i11, iArr[1] + view.getWidth());
        Rect rect2 = new Rect(foldingFeature.getBounds());
        boolean intersect = rect2.intersect(rect);
        if ((rect2.width() == 0 && rect2.height() == 0) || !intersect) {
            return null;
        }
        rect2.offset(-iArr[0], -iArr[1]);
        return rect2;
    }

    private static int getMinimumWidth(View view) {
        if (view instanceof TouchBlocker) {
            return ViewCompat.getMinimumWidth(((TouchBlocker) view).getChildAt(0));
        }
        return ViewCompat.getMinimumWidth(view);
    }

    private Insets getSystemGestureInsets() {
        WindowInsetsCompat rootWindowInsets;
        if (!sEdgeSizeUsingSystemGestureInsets || (rootWindowInsets = ViewCompat.getRootWindowInsets(this)) == null) {
            return null;
        }
        return rootWindowInsets.getSystemGestureInsets();
    }

    private static int measureChildHeight(@NonNull View view, int i11, int i12) {
        boolean z11;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.width != 0 || layoutParams.weight <= 0.0f) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return ViewGroup.getChildMeasureSpec(i11, i12, layoutParams.height);
        }
        return View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824);
    }

    private boolean openPane(int i11) {
        if (!this.mCanSlide) {
            this.f37602g = true;
        }
        if (!this.mFirstLayout && !i(0.0f, i11)) {
            return false;
        }
        this.f37602g = true;
        return true;
    }

    private void parallaxOtherViews(float f11) {
        boolean f12 = f();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt != this.f37597b) {
                int i12 = this.mParallaxBy;
                this.mParallaxOffset = f11;
                int i13 = ((int) ((1.0f - this.mParallaxOffset) * ((float) i12))) - ((int) ((1.0f - f11) * ((float) i12)));
                if (f12) {
                    i13 = -i13;
                }
                childAt.offsetLeftAndRight(i13);
            }
        }
    }

    private void setFoldingFeatureObserver(FoldingFeatureObserver foldingFeatureObserver) {
        this.mFoldingFeatureObserver = foldingFeatureObserver;
        foldingFeatureObserver.setOnFoldingFeatureChangeListener(this.mOnFoldingFeatureChangeListener);
    }

    private ArrayList<Rect> splitViewPositions() {
        Rect foldBoundsInView;
        FoldingFeature foldingFeature = this.f37604i;
        if (foldingFeature == null || !foldingFeature.isSeparating() || this.f37604i.getBounds().left == 0 || this.f37604i.getBounds().top != 0 || (foldBoundsInView = getFoldBoundsInView(this.f37604i, this)) == null) {
            return null;
        }
        Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), Math.max(getPaddingLeft(), foldBoundsInView.left), getHeight() - getPaddingBottom());
        int width = getWidth() - getPaddingRight();
        return new ArrayList<>(Arrays.asList(new Rect[]{rect, new Rect(Math.min(width, foldBoundsInView.right), getPaddingTop(), width, getHeight() - getPaddingBottom())}));
    }

    private static boolean viewIsOpaque(View view) {
        return view.isOpaque();
    }

    public void a(@NonNull View view) {
        for (PanelSlideListener onPanelClosed : this.mPanelSlideListeners) {
            onPanelClosed.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    public void addPanelSlideListener(@NonNull PanelSlideListener panelSlideListener) {
        this.mPanelSlideListeners.add(panelSlideListener);
    }

    public void addView(@NonNull View view, int i11, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 1) {
            super.addView(new TouchBlocker(view), i11, layoutParams);
        } else {
            super.addView(view, i11, layoutParams);
        }
    }

    public void b(@NonNull View view) {
        for (PanelSlideListener onPanelOpened : this.mPanelSlideListeners) {
            onPanelOpened.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    public void c(@NonNull View view) {
        for (PanelSlideListener onPanelSlide : this.mPanelSlideListeners) {
            onPanelSlide.onPanelSlide(view, this.f37598c);
        }
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void close() {
        closePane();
    }

    public void computeScroll() {
        if (!this.f37601f.continueSettling(true)) {
            return;
        }
        if (!this.mCanSlide) {
            this.f37601f.abort();
        } else {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void d(View view) {
        ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).f37612c);
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        View view;
        int i11;
        int i12;
        super.draw(canvas);
        if (f()) {
            drawable = this.mShadowDrawableRight;
        } else {
            drawable = this.mShadowDrawableLeft;
        }
        if (getChildCount() > 1) {
            view = getChildAt(1);
        } else {
            view = null;
        }
        if (view != null && drawable != null) {
            int top = view.getTop();
            int bottom = view.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (f()) {
                i12 = view.getRight();
                i11 = intrinsicWidth + i12;
            } else {
                int left = view.getLeft();
                int i13 = left - intrinsicWidth;
                i11 = left;
                i12 = i13;
            }
            drawable.setBounds(i12, top, i11, bottom);
            drawable.draw(canvas);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j11) {
        if (f() ^ isOpen()) {
            this.f37601f.setEdgeTrackingEnabled(1);
            Insets systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                ViewDragHelper viewDragHelper = this.f37601f;
                viewDragHelper.setEdgeSize(Math.max(viewDragHelper.getDefaultEdgeSize(), systemGestureInsets.left));
            }
        } else {
            this.f37601f.setEdgeTrackingEnabled(2);
            Insets systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                ViewDragHelper viewDragHelper2 = this.f37601f;
                viewDragHelper2.setEdgeSize(Math.max(viewDragHelper2.getDefaultEdgeSize(), systemGestureInsets2.right));
            }
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.mCanSlide && !layoutParams.f37610a && this.f37597b != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (f()) {
                Rect rect = this.mTmpRect;
                rect.left = Math.max(rect.left, this.f37597b.getRight());
            } else {
                Rect rect2 = this.mTmpRect;
                rect2.right = Math.min(rect2.right, this.f37597b.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean drawChild = super.drawChild(canvas, view, j11);
        canvas.restoreToCount(save);
        return drawChild;
    }

    public boolean e(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.mCanSlide || !layoutParams.f37611b || this.f37598c <= 0.0f) {
            return false;
        }
        return true;
    }

    public boolean f() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public void g(int i11) {
        int i12;
        int i13;
        if (this.f37597b == null) {
            this.f37598c = 0.0f;
            return;
        }
        boolean f11 = f();
        LayoutParams layoutParams = (LayoutParams) this.f37597b.getLayoutParams();
        int width = this.f37597b.getWidth();
        if (f11) {
            i11 = (getWidth() - i11) - width;
        }
        if (f11) {
            i12 = getPaddingRight();
        } else {
            i12 = getPaddingLeft();
        }
        if (f11) {
            i13 = layoutParams.rightMargin;
        } else {
            i13 = layoutParams.leftMargin;
        }
        float f12 = ((float) (i11 - (i12 + i13))) / ((float) this.f37599d);
        this.f37598c = f12;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(f12);
        }
        c(this.f37597b);
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @ColorInt
    @Deprecated
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public final int getLockMode() {
        return this.mLockMode;
    }

    @Px
    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @ColorInt
    @Deprecated
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public void h() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public boolean i(float f11, int i11) {
        int i12;
        if (!this.mCanSlide) {
            return false;
        }
        boolean f12 = f();
        LayoutParams layoutParams = (LayoutParams) this.f37597b.getLayoutParams();
        if (f12) {
            i12 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f11 * ((float) this.f37599d))) + ((float) this.f37597b.getWidth())));
        } else {
            i12 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f11 * ((float) this.f37599d)));
        }
        ViewDragHelper viewDragHelper = this.f37601f;
        View view = this.f37597b;
        if (!viewDragHelper.smoothSlideViewTo(view, i12, view.getTop())) {
            return false;
        }
        h();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.f37598c == 0.0f;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    public void j(View view) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        View childAt;
        boolean z11;
        int i17;
        int i18;
        int i19;
        View view2 = view;
        boolean f11 = f();
        if (f11) {
            i11 = getWidth() - getPaddingRight();
        } else {
            i11 = getPaddingLeft();
        }
        if (f11) {
            i12 = getPaddingLeft();
        } else {
            i12 = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view)) {
            i16 = 0;
            i15 = 0;
            i14 = 0;
            i13 = 0;
        } else {
            i16 = view.getLeft();
            i15 = view.getRight();
            i14 = view.getTop();
            i13 = view.getBottom();
        }
        int childCount = getChildCount();
        int i21 = 0;
        while (true) {
            if (i21 < childCount && (childAt = getChildAt(i21)) != view2) {
                if (childAt.getVisibility() == 8) {
                    z11 = f11;
                } else {
                    if (f11) {
                        i17 = i12;
                    } else {
                        i17 = i11;
                    }
                    int max = Math.max(i17, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    z11 = f11;
                    if (f11) {
                        i18 = i11;
                    } else {
                        i18 = i12;
                    }
                    int min = Math.min(i18, childAt.getRight());
                    int min2 = Math.min(height, childAt.getBottom());
                    if (max < i16 || max2 < i14 || min > i15 || min2 > i13) {
                        i19 = 0;
                    } else {
                        i19 = 4;
                    }
                    childAt.setVisibility(i19);
                }
                i21++;
                view2 = view;
                f11 = z11;
            } else {
                return;
            }
        }
    }

    public void onAttachedToWindow() {
        Activity activityOrNull;
        super.onAttachedToWindow();
        this.mFirstLayout = true;
        if (this.mFoldingFeatureObserver != null && (activityOrNull = getActivityOrNull(getContext())) != null) {
            this.mFoldingFeatureObserver.registerLayoutStateChangeCallback(activityOrNull);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        FoldingFeatureObserver foldingFeatureObserver = this.mFoldingFeatureObserver;
        if (foldingFeatureObserver != null) {
            foldingFeatureObserver.unregisterLayoutStateChangeCallback();
        }
        int size = this.f37603h.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f37603h.get(i11).run();
        }
        this.f37603h.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f37602g = this.f37601f.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.mCanSlide || (this.f37600e && actionMasked != 0)) {
            this.f37601f.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.f37601f.cancel();
            return false;
        } else {
            if (actionMasked == 0) {
                this.f37600e = false;
                float x11 = motionEvent.getX();
                float y11 = motionEvent.getY();
                this.mInitialMotionX = x11;
                this.mInitialMotionY = y11;
                if (this.f37601f.isViewUnder(this.f37597b, (int) x11, (int) y11) && e(this.f37597b)) {
                    z11 = true;
                    if (this.f37601f.shouldInterceptTouchEvent(motionEvent) && !z11) {
                        return false;
                    }
                }
            } else if (actionMasked == 2) {
                float x12 = motionEvent.getX();
                float y12 = motionEvent.getY();
                float abs = Math.abs(x12 - this.mInitialMotionX);
                float abs2 = Math.abs(y12 - this.mInitialMotionY);
                if (abs > ((float) this.f37601f.getTouchSlop()) && abs2 > abs) {
                    this.f37601f.cancel();
                    this.f37600e = true;
                    return false;
                }
            }
            z11 = false;
            return this.f37601f.shouldInterceptTouchEvent(motionEvent) ? true : true;
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z12;
        float f11;
        boolean f12 = f();
        int i25 = i13 - i11;
        if (f12) {
            i15 = getPaddingRight();
        } else {
            i15 = getPaddingLeft();
        }
        if (f12) {
            i16 = getPaddingLeft();
        } else {
            i16 = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            if (!this.mCanSlide || !this.f37602g) {
                f11 = 1.0f;
            } else {
                f11 = 0.0f;
            }
            this.f37598c = f11;
        }
        int i26 = i15;
        int i27 = 0;
        while (i27 < childCount) {
            View childAt = getChildAt(i27);
            if (childAt.getVisibility() == 8) {
                i17 = i26;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f37610a) {
                    int i28 = i25 - i16;
                    int min = (Math.min(i15, i28) - i26) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f37599d = min;
                    if (f12) {
                        i24 = layoutParams.rightMargin;
                    } else {
                        i24 = layoutParams.leftMargin;
                    }
                    if (i26 + i24 + min + (measuredWidth / 2) > i28) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    layoutParams.f37611b = z12;
                    int i29 = (int) (((float) min) * this.f37598c);
                    this.f37598c = ((float) i29) / ((float) min);
                    i17 = i26 + i24 + i29;
                    i18 = 0;
                } else if (!this.mCanSlide || (i23 = this.mParallaxBy) == 0) {
                    i17 = i15;
                    i18 = 0;
                } else {
                    i18 = (int) ((1.0f - this.f37598c) * ((float) i23));
                    i17 = i15;
                }
                if (f12) {
                    i19 = (i25 - i17) + i18;
                    i21 = i19 - measuredWidth;
                } else {
                    i21 = i17 - i18;
                    i19 = i21 + measuredWidth;
                }
                childAt.layout(i21, paddingTop, i19, childAt.getMeasuredHeight() + paddingTop);
                FoldingFeature foldingFeature = this.f37604i;
                if (foldingFeature == null || foldingFeature.getOrientation() != FoldingFeature.Orientation.VERTICAL || !this.f37604i.isSeparating()) {
                    i22 = 0;
                } else {
                    i22 = this.f37604i.getBounds().width();
                }
                i15 += childAt.getWidth() + Math.abs(i22);
            }
            i27++;
            i26 = i17;
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide && this.mParallaxBy != 0) {
                parallaxOtherViews(this.f37598c);
            }
            j(this.f37597b);
        }
        this.mFirstLayout = false;
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        boolean z11;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z12;
        int i21;
        int i22 = i12;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        boolean z13 = false;
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                i14 = 0;
            } else {
                i14 = (size2 - getPaddingTop()) - getPaddingBottom();
            }
            i13 = i14;
        } else {
            i13 = (size2 - getPaddingTop()) - getPaddingBottom();
            i14 = 0;
        }
        int max = Math.max((size - getPaddingLeft()) - getPaddingRight(), 0);
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e(TAG, "onMeasure: More than two child views are not supported.");
        }
        this.f37597b = null;
        int i23 = 0;
        boolean z14 = false;
        int i24 = max;
        float f11 = 0.0f;
        while (true) {
            i15 = 8;
            if (i23 >= childCount) {
                break;
            }
            View childAt = getChildAt(i23);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int i25 = size;
            if (childAt.getVisibility() == 8) {
                layoutParams.f37611b = z13;
            } else {
                float f12 = layoutParams.weight;
                if (f12 > 0.0f) {
                    f11 += f12;
                    if (layoutParams.width == 0) {
                    }
                }
                int max2 = Math.max(max - (layoutParams.leftMargin + layoutParams.rightMargin), z13 ? 1 : 0);
                int i26 = layoutParams.width;
                if (i26 == -2) {
                    if (mode == 0) {
                        i21 = mode;
                    } else {
                        i21 = Integer.MIN_VALUE;
                    }
                    i19 = View.MeasureSpec.makeMeasureSpec(max2, i21);
                } else if (i26 == -1) {
                    i19 = View.MeasureSpec.makeMeasureSpec(max2, mode);
                } else {
                    i19 = View.MeasureSpec.makeMeasureSpec(i26, 1073741824);
                }
                childAt.measure(i19, ViewGroup.getChildMeasureSpec(i22, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i14) {
                    if (mode2 == Integer.MIN_VALUE) {
                        i14 = Math.min(measuredHeight, i13);
                    } else if (mode2 == 0) {
                        i14 = measuredHeight;
                    }
                }
                i24 -= measuredWidth;
                if (i23 != 0) {
                    if (i24 < 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    layoutParams.f37610a = z12;
                    z14 |= z12;
                    if (z12) {
                        this.f37597b = childAt;
                    }
                }
            }
            i23++;
            size = i25;
            z13 = false;
        }
        int i27 = size;
        int i28 = i24;
        if (z14 || f11 > 0.0f) {
            int i29 = 0;
            while (i29 < childCount) {
                View childAt2 = getChildAt(i29);
                if (childAt2.getVisibility() != i15) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (layoutParams2.width != 0 || layoutParams2.weight <= 0.0f) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (z11) {
                        i16 = 0;
                    } else {
                        i16 = childAt2.getMeasuredWidth();
                    }
                    if (z14) {
                        i17 = max - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                        i18 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                    } else if (layoutParams2.weight > 0.0f) {
                        i17 = i16 + ((int) ((layoutParams2.weight * ((float) Math.max(0, i28))) / f11));
                        i18 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                    } else {
                        i17 = i16;
                        i18 = 0;
                    }
                    int measureChildHeight = measureChildHeight(childAt2, i22, getPaddingTop() + getPaddingBottom());
                    if (i16 != i17) {
                        childAt2.measure(i18, measureChildHeight);
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        if (measuredHeight2 > i14) {
                            if (mode2 == Integer.MIN_VALUE) {
                                measuredHeight2 = Math.min(measuredHeight2, i13);
                            } else if (mode2 != 0) {
                            }
                            i14 = measuredHeight2;
                        }
                    }
                }
                i29++;
                i15 = 8;
            }
        }
        ArrayList<Rect> splitViewPositions = splitViewPositions();
        if (splitViewPositions != null && !z14) {
            for (int i31 = 0; i31 < childCount; i31++) {
                View childAt3 = getChildAt(i31);
                if (childAt3.getVisibility() != 8) {
                    Rect rect = splitViewPositions.get(i31);
                    LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                    int i32 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt3.getMeasuredHeight(), 1073741824);
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), Integer.MIN_VALUE), makeMeasureSpec);
                    if ((childAt3.getMeasuredWidthAndState() & 16777216) == 1 || (getMinimumWidth(childAt3) != 0 && rect.width() < getMinimumWidth(childAt3))) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(max - i32, 1073741824), makeMeasureSpec);
                        if (i31 != 0) {
                            layoutParams3.f37610a = true;
                            this.f37597b = childAt3;
                            z14 = true;
                        }
                    } else {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), makeMeasureSpec);
                    }
                }
            }
        }
        setMeasuredDimension(i27, i14 + getPaddingTop() + getPaddingBottom());
        this.mCanSlide = z14;
        if (this.f37601f.getViewDragState() != 0 && !z14) {
            this.f37601f.abort();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f37613b) {
            openPane();
        } else {
            closePane();
        }
        this.f37602g = savedState.f37613b;
        setLockMode(savedState.f37614c);
    }

    public Parcelable onSaveInstanceState() {
        boolean z11;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (isSlideable()) {
            z11 = isOpen();
        } else {
            z11 = this.f37602g;
        }
        savedState.f37613b = z11;
        savedState.f37614c = this.mLockMode;
        return savedState;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 != i13) {
            this.mFirstLayout = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.f37601f.processTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.mInitialMotionX = x11;
            this.mInitialMotionY = y11;
        } else if (actionMasked == 1 && e(this.f37597b)) {
            float x12 = motionEvent.getX();
            float y12 = motionEvent.getY();
            float f11 = x12 - this.mInitialMotionX;
            float f12 = y12 - this.mInitialMotionY;
            int touchSlop = this.f37601f.getTouchSlop();
            if ((f11 * f11) + (f12 * f12) < ((float) (touchSlop * touchSlop)) && this.f37601f.isViewUnder(this.f37597b, (int) x12, (int) y12)) {
                closePane(0);
            }
        }
        return true;
    }

    public void open() {
        openPane();
    }

    public void removePanelSlideListener(@NonNull PanelSlideListener panelSlideListener) {
        this.mPanelSlideListeners.remove(panelSlideListener);
    }

    public void removeView(@NonNull View view) {
        if (view.getParent() instanceof TouchBlocker) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    public void requestChildFocus(View view, View view2) {
        boolean z11;
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            if (view == this.f37597b) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f37602g = z11;
        }
    }

    @Deprecated
    public void setCoveredFadeColor(@ColorInt int i11) {
        this.mCoveredFadeColor = i11;
    }

    public final void setLockMode(int i11) {
        this.mLockMode = i11;
    }

    @Deprecated
    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        PanelSlideListener panelSlideListener2 = this.mPanelSlideListener;
        if (panelSlideListener2 != null) {
            removePanelSlideListener(panelSlideListener2);
        }
        if (panelSlideListener != null) {
            addPanelSlideListener(panelSlideListener);
        }
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(@Px int i11) {
        this.mParallaxBy = i11;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i11) {
        setShadowDrawableLeft(getResources().getDrawable(i11));
    }

    public void setShadowResourceLeft(int i11) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i11));
    }

    public void setShadowResourceRight(int i11) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i11));
    }

    @Deprecated
    public void setSliderFadeColor(@ColorInt int i11) {
        this.mSliderFadeColor = i11;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {16843137};

        /* renamed from: a  reason: collision with root package name */
        public boolean f37610a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37611b;

        /* renamed from: c  reason: collision with root package name */
        public Paint f37612c;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = layoutParams.weight;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mSliderFadeColor = 0;
        this.f37598c = 1.0f;
        this.mPanelSlideListeners = new CopyOnWriteArrayList();
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.f37603h = new ArrayList<>();
        this.mOnFoldingFeatureChangeListener = new FoldingFeatureObserver.OnFoldingFeatureChangeListener() {
            public void onFoldingFeatureChange(@NonNull FoldingFeature foldingFeature) {
                SlidingPaneLayout.this.f37604i = foldingFeature;
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.setDuration(300);
                changeBounds.setInterpolator(PathInterpolatorCompat.create(0.2f, 0.0f, 0.0f, 1.0f));
                TransitionManager.beginDelayedTransition(SlidingPaneLayout.this, changeBounds);
                SlidingPaneLayout.this.requestLayout();
            }
        };
        float f11 = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new DragHelperCallback());
        this.f37601f = create;
        create.setMinVelocity(f11 * 400.0f);
        setFoldingFeatureObserver(new FoldingFeatureObserver(e.a(context), ContextCompat.getMainExecutor(context)));
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public boolean closePane() {
        return closePane(0);
    }

    public boolean openPane() {
        return openPane(0);
    }
}
