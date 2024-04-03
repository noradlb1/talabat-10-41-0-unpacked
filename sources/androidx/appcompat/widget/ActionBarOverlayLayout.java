package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    private static final int ACTION_BAR_ANIMATE_DELAY = 600;
    private static final String TAG = "ActionBarOverlayLayout";

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f755f = {R.attr.actionBarSize, 16842841};

    /* renamed from: b  reason: collision with root package name */
    public ActionBarContainer f756b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f757c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPropertyAnimator f758d;

    /* renamed from: e  reason: collision with root package name */
    public final AnimatorListenerAdapter f759e;
    private int mActionBarHeight;
    private ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    private final Rect mBaseContentInsets;
    @NonNull
    private WindowInsetsCompat mBaseInnerInsets;
    private final Rect mBaseInnerInsetsRect;
    private ContentFrameLayout mContent;
    private final Rect mContentInsets;
    private DecorToolbar mDecorToolbar;
    private OverScroller mFlingEstimator;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;
    @NonNull
    private WindowInsetsCompat mInnerInsets;
    private final Rect mInnerInsetsRect;
    private final Rect mLastBaseContentInsets;
    @NonNull
    private WindowInsetsCompat mLastBaseInnerInsets;
    private final Rect mLastBaseInnerInsetsRect;
    @NonNull
    private WindowInsetsCompat mLastInnerInsets;
    private final Rect mLastInnerInsetsRect;
    private int mLastSystemUiVisibility;
    private boolean mOverlayMode;
    private final NestedScrollingParentHelper mParentHelper;
    private final Runnable mRemoveActionBarHideOffset;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility;

    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean z11);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i11);

        void showForSystem();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addActionBarHideOffset() {
        b();
        this.mAddActionBarHideOffset.run();
    }

    private boolean applyInsets(@NonNull View view, @NonNull Rect rect, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15;
        int i11;
        int i12;
        int i13;
        int i14;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z11 || layoutParams.leftMargin == (i14 = rect.left)) {
            z15 = false;
        } else {
            layoutParams.leftMargin = i14;
            z15 = true;
        }
        if (z12 && layoutParams.topMargin != (i13 = rect.top)) {
            layoutParams.topMargin = i13;
            z15 = true;
        }
        if (z14 && layoutParams.rightMargin != (i12 = rect.right)) {
            layoutParams.rightMargin = i12;
            z15 = true;
        }
        if (!z13 || layoutParams.bottomMargin == (i11 = rect.bottom)) {
            return z15;
        }
        layoutParams.bottomMargin = i11;
        return true;
    }

    private DecorToolbar getDecorToolbar(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void init(Context context) {
        boolean z11;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f755f);
        boolean z12 = false;
        this.mActionBarHeight = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.mWindowContentOverlay = drawable;
        if (drawable == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        setWillNotDraw(z11);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z12 = true;
        }
        this.mIgnoreWindowContentOverlay = z12;
        this.mFlingEstimator = new OverScroller(context);
    }

    private void postAddActionBarHideOffset() {
        b();
        postDelayed(this.mAddActionBarHideOffset, 600);
    }

    private void postRemoveActionBarHideOffset() {
        b();
        postDelayed(this.mRemoveActionBarHideOffset, 600);
    }

    private void removeActionBarHideOffset() {
        b();
        this.mRemoveActionBarHideOffset.run();
    }

    private boolean shouldHideActionBarOnFling(float f11) {
        this.mFlingEstimator.fling(0, 0, 0, (int) f11, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.mFlingEstimator.getFinalY() > this.f756b.getHeight()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public void b() {
        removeCallbacks(this.mRemoveActionBarHideOffset);
        removeCallbacks(this.mAddActionBarHideOffset);
        ViewPropertyAnimator viewPropertyAnimator = this.f758d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public void c() {
        if (this.mContent == null) {
            this.mContent = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f756b = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.mDecorToolbar = getDecorToolbar(findViewById(R.id.action_bar));
        }
    }

    public boolean canShowOverflowMenu() {
        c();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopups() {
        c();
        this.mDecorToolbar.dismissPopupMenus();
    }

    public void draw(Canvas canvas) {
        int i11;
        super.draw(canvas);
        if (this.mWindowContentOverlay != null && !this.mIgnoreWindowContentOverlay) {
            if (this.f756b.getVisibility() == 0) {
                i11 = (int) (((float) this.f756b.getBottom()) + this.f756b.getTranslationY() + 0.5f);
            } else {
                i11 = 0;
            }
            this.mWindowContentOverlay.setBounds(0, i11, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + i11);
            this.mWindowContentOverlay.draw(canvas);
        }
    }

    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f756b;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        c();
        return this.mDecorToolbar.getTitle();
    }

    public boolean hasIcon() {
        c();
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        c();
        return this.mDecorToolbar.hasLogo();
    }

    public boolean hideOverflowMenu() {
        c();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public void initFeature(int i11) {
        c();
        if (i11 == 2) {
            this.mDecorToolbar.initProgress();
        } else if (i11 == 5) {
            this.mDecorToolbar.initIndeterminateProgress();
        } else if (i11 == 109) {
            setOverlayMode(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mHideOnContentScroll;
    }

    public boolean isInOverlayMode() {
        return this.mOverlayMode;
    }

    public boolean isOverflowMenuShowPending() {
        c();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        c();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    @RequiresApi(21)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        c();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, this);
        boolean applyInsets = applyInsets(this.f756b, new Rect(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom()), true, true, false, true);
        ViewCompat.computeSystemWindowInsets(this, windowInsetsCompat, this.mBaseContentInsets);
        Rect rect = this.mBaseContentInsets;
        WindowInsetsCompat inset = windowInsetsCompat.inset(rect.left, rect.top, rect.right, rect.bottom);
        this.mBaseInnerInsets = inset;
        boolean z11 = true;
        if (!this.mLastBaseInnerInsets.equals(inset)) {
            this.mLastBaseInnerInsets = this.mBaseInnerInsets;
            applyInsets = true;
        }
        if (!this.mLastBaseContentInsets.equals(this.mBaseContentInsets)) {
            this.mLastBaseContentInsets.set(this.mBaseContentInsets);
        } else {
            z11 = applyInsets;
        }
        if (z11) {
            requestLayout();
        }
        return windowInsetsCompat.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        init(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i16 = layoutParams.leftMargin + paddingLeft;
                int i17 = layoutParams.topMargin + paddingTop;
                childAt.layout(i16, i17, measuredWidth + i16, measuredHeight + i17);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        boolean z11;
        int i13;
        c();
        measureChildWithMargins(this.f756b, i11, 0, i12, 0);
        LayoutParams layoutParams = (LayoutParams) this.f756b.getLayoutParams();
        int max = Math.max(0, this.f756b.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.f756b.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f756b.getMeasuredState());
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i13 = this.mActionBarHeight;
            if (this.mHasNonEmbeddedTabs && this.f756b.getTabContainer() != null) {
                i13 += this.mActionBarHeight;
            }
        } else {
            i13 = this.f756b.getVisibility() != 8 ? this.f756b.getMeasuredHeight() : 0;
        }
        this.mContentInsets.set(this.mBaseContentInsets);
        WindowInsetsCompat windowInsetsCompat = this.mBaseInnerInsets;
        this.mInnerInsets = windowInsetsCompat;
        if (this.mOverlayMode || z11) {
            this.mInnerInsets = new WindowInsetsCompat.Builder(this.mInnerInsets).setSystemWindowInsets(Insets.of(windowInsetsCompat.getSystemWindowInsetLeft(), this.mInnerInsets.getSystemWindowInsetTop() + i13, this.mInnerInsets.getSystemWindowInsetRight(), this.mInnerInsets.getSystemWindowInsetBottom() + 0)).build();
        } else {
            Rect rect = this.mContentInsets;
            rect.top += i13;
            rect.bottom += 0;
            this.mInnerInsets = windowInsetsCompat.inset(0, i13, 0, 0);
        }
        applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
        if (!this.mLastInnerInsets.equals(this.mInnerInsets)) {
            WindowInsetsCompat windowInsetsCompat2 = this.mInnerInsets;
            this.mLastInnerInsets = windowInsetsCompat2;
            ViewCompat.dispatchApplyWindowInsets(this.mContent, windowInsetsCompat2);
        }
        measureChildWithMargins(this.mContent, i11, 0, i12, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.mContent.getLayoutParams();
        int max3 = Math.max(max, this.mContent.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.mContent.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.mContent.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i11, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i12, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        if (!this.mHideOnContentScroll || !z11) {
            return false;
        }
        if (shouldHideActionBarOnFling(f12)) {
            addActionBarHideOffset();
        } else {
            removeActionBarHideOffset();
        }
        this.f757c = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f11, float f12) {
        return false;
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        if (i13 == 0) {
            onNestedPreScroll(view, i11, i12, iArr);
        }
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        onNestedScroll(view, i11, i12, i13, i14, i15);
    }

    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            onNestedScrollAccepted(view, view2, i11);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        return i12 == 0 && onStartNestedScroll(view, view2, i11);
    }

    public void onStopNestedScroll(View view, int i11) {
        if (i11 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i11) {
        boolean z11;
        super.onWindowSystemUiVisibilityChanged(i11);
        c();
        int i12 = this.mLastSystemUiVisibility ^ i11;
        this.mLastSystemUiVisibility = i11;
        boolean z12 = false;
        if ((i11 & 4) == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((i11 & 256) != 0) {
            z12 = true;
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.enableContentAnimations(!z12);
            if (z11 || !z12) {
                this.mActionBarVisibilityCallback.showForSystem();
            } else {
                this.mActionBarVisibilityCallback.hideForSystem();
            }
        }
        if ((i12 & 256) != 0 && this.mActionBarVisibilityCallback != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        this.mWindowVisibility = i11;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onWindowVisibilityChanged(i11);
        }
    }

    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        c();
        this.mDecorToolbar.restoreHierarchyState(sparseArray);
    }

    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        c();
        this.mDecorToolbar.saveHierarchyState(sparseArray);
    }

    public void setActionBarHideOffset(int i11) {
        b();
        this.f756b.setTranslationY((float) (-Math.max(0, Math.min(i11, this.f756b.getHeight()))));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.mActionBarVisibilityCallback = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
            int i11 = this.mLastSystemUiVisibility;
            if (i11 != 0) {
                onWindowSystemUiVisibilityChanged(i11);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z11) {
        this.mHasNonEmbeddedTabs = z11;
    }

    public void setHideOnContentScrollEnabled(boolean z11) {
        if (z11 != this.mHideOnContentScroll) {
            this.mHideOnContentScroll = z11;
            if (!z11) {
                b();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i11) {
        c();
        this.mDecorToolbar.setIcon(i11);
    }

    public void setLogo(int i11) {
        c();
        this.mDecorToolbar.setLogo(i11);
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        c();
        this.mDecorToolbar.setMenu(menu, callback);
    }

    public void setMenuPrepared() {
        c();
        this.mDecorToolbar.setMenuPrepared();
    }

    public void setOverlayMode(boolean z11) {
        boolean z12;
        this.mOverlayMode = z11;
        if (!z11 || getContext().getApplicationInfo().targetSdkVersion >= 19) {
            z12 = false;
        } else {
            z12 = true;
        }
        this.mIgnoreWindowContentOverlay = z12;
    }

    public void setShowingForActionMode(boolean z11) {
    }

    public void setUiOptions(int i11) {
    }

    public void setWindowCallback(Window.Callback callback) {
        c();
        this.mDecorToolbar.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        c();
        return this.mDecorToolbar.showOverflowMenu();
    }

    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsetsRect = new Rect();
        this.mLastBaseInnerInsetsRect = new Rect();
        this.mInnerInsetsRect = new Rect();
        this.mLastInnerInsetsRect = new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.CONSUMED;
        this.mBaseInnerInsets = windowInsetsCompat;
        this.mLastBaseInnerInsets = windowInsetsCompat;
        this.mInnerInsets = windowInsetsCompat;
        this.mLastInnerInsets = windowInsetsCompat;
        this.f759e = new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f758d = null;
                actionBarOverlayLayout.f757c = false;
            }

            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f758d = null;
                actionBarOverlayLayout.f757c = false;
            }
        };
        this.mRemoveActionBarHideOffset = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.b();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f758d = actionBarOverlayLayout.f756b.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f759e);
            }
        };
        this.mAddActionBarHideOffset = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.b();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f758d = actionBarOverlayLayout.f756b.animate().translationY((float) (-ActionBarOverlayLayout.this.f756b.getHeight())).setListener(ActionBarOverlayLayout.this.f759e);
            }
        };
        init(context);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        if (i15 == 0) {
            onNestedScroll(view, i11, i12, i13, i14);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i11) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i11);
        this.mHideOnContentScrollReference = getActionBarHideOffset();
        b();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStarted();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i11) {
        if ((i11 & 2) == 0 || this.f756b.getVisibility() != 0) {
            return false;
        }
        return this.mHideOnContentScroll;
    }

    public void onStopNestedScroll(View view) {
        if (this.mHideOnContentScroll && !this.f757c) {
            if (this.mHideOnContentScrollReference <= this.f756b.getHeight()) {
                postRemoveActionBarHideOffset();
            } else {
                postAddActionBarHideOffset();
            }
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStopped();
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        int i15 = this.mHideOnContentScrollReference + i12;
        this.mHideOnContentScrollReference = i15;
        setActionBarHideOffset(i15);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.mDecorToolbar.setIcon(drawable);
    }
}
