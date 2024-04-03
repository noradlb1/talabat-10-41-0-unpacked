package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import net.bytebuddy.jar.asm.Opcodes;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContainer extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public Drawable f748b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f749c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f750d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f751e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f752f;
    private View mActionBarView;
    private View mContextView;
    private int mHeight;
    private boolean mIsTransitioning;
    private View mTabContainer;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void invalidateOutline(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getMeasuredHeightWithMargins(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean isCollapsed(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f748b;
        if (drawable != null && drawable.isStateful()) {
            this.f748b.setState(getDrawableState());
        }
        Drawable drawable2 = this.f749c;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f749c.setState(getDrawableState());
        }
        Drawable drawable3 = this.f750d;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f750d.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.mTabContainer;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f748b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f749c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f750d;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = findViewById(R.id.action_bar);
        this.mContextView = findViewById(R.id.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mIsTransitioning || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            super.onLayout(r5, r6, r7, r8, r9)
            android.view.View r5 = r4.mTabContainer
            r7 = 8
            r9 = 1
            r0 = 0
            if (r5 == 0) goto L_0x0013
            int r1 = r5.getVisibility()
            if (r1 == r7) goto L_0x0013
            r1 = r9
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r5 == 0) goto L_0x0033
            int r2 = r5.getVisibility()
            if (r2 == r7) goto L_0x0033
            int r7 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r5.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r5.getMeasuredHeight()
            int r3 = r7 - r3
            int r2 = r2.bottomMargin
            int r3 = r3 - r2
            int r7 = r7 - r2
            r5.layout(r6, r3, r8, r7)
        L_0x0033:
            boolean r6 = r4.f751e
            if (r6 == 0) goto L_0x004b
            android.graphics.drawable.Drawable r5 = r4.f750d
            if (r5 == 0) goto L_0x0048
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r5.setBounds(r0, r0, r6, r7)
            goto L_0x00be
        L_0x0048:
            r9 = r0
            goto L_0x00be
        L_0x004b:
            android.graphics.drawable.Drawable r6 = r4.f748b
            if (r6 == 0) goto L_0x00a3
            android.view.View r6 = r4.mActionBarView
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x0075
            android.graphics.drawable.Drawable r6 = r4.f748b
            android.view.View r7 = r4.mActionBarView
            int r7 = r7.getLeft()
            android.view.View r8 = r4.mActionBarView
            int r8 = r8.getTop()
            android.view.View r0 = r4.mActionBarView
            int r0 = r0.getRight()
            android.view.View r2 = r4.mActionBarView
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto L_0x00a2
        L_0x0075:
            android.view.View r6 = r4.mContextView
            if (r6 == 0) goto L_0x009d
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x009d
            android.graphics.drawable.Drawable r6 = r4.f748b
            android.view.View r7 = r4.mContextView
            int r7 = r7.getLeft()
            android.view.View r8 = r4.mContextView
            int r8 = r8.getTop()
            android.view.View r0 = r4.mContextView
            int r0 = r0.getRight()
            android.view.View r2 = r4.mContextView
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto L_0x00a2
        L_0x009d:
            android.graphics.drawable.Drawable r6 = r4.f748b
            r6.setBounds(r0, r0, r0, r0)
        L_0x00a2:
            r0 = r9
        L_0x00a3:
            r4.f752f = r1
            if (r1 == 0) goto L_0x0048
            android.graphics.drawable.Drawable r6 = r4.f749c
            if (r6 == 0) goto L_0x0048
            int r7 = r5.getLeft()
            int r8 = r5.getTop()
            int r0 = r5.getRight()
            int r5 = r5.getBottom()
            r6.setBounds(r7, r8, r0, r5)
        L_0x00be:
            if (r9 == 0) goto L_0x00c3
            r4.invalidate()
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        if (this.mActionBarView == null && View.MeasureSpec.getMode(i12) == Integer.MIN_VALUE && (i15 = this.mHeight) >= 0) {
            i12 = View.MeasureSpec.makeMeasureSpec(Math.min(i15, View.MeasureSpec.getSize(i12)), Integer.MIN_VALUE);
        }
        super.onMeasure(i11, i12);
        if (this.mActionBarView != null) {
            int mode = View.MeasureSpec.getMode(i12);
            View view = this.mTabContainer;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!isCollapsed(this.mActionBarView)) {
                    i13 = getMeasuredHeightWithMargins(this.mActionBarView);
                } else if (!isCollapsed(this.mContextView)) {
                    i13 = getMeasuredHeightWithMargins(this.mContextView);
                } else {
                    i13 = 0;
                }
                if (mode == Integer.MIN_VALUE) {
                    i14 = View.MeasureSpec.getSize(i12);
                } else {
                    i14 = Integer.MAX_VALUE;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i13 + getMeasuredHeightWithMargins(this.mTabContainer), i14));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f748b;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f748b);
        }
        this.f748b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.mActionBarView;
            if (view != null) {
                this.f748b.setBounds(view.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
            }
        }
        boolean z11 = true;
        if (!this.f751e ? !(this.f748b == null && this.f749c == null) : this.f750d != null) {
            z11 = false;
        }
        setWillNotDraw(z11);
        invalidate();
        Api21Impl.invalidateOutline(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f750d;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f750d);
        }
        this.f750d = drawable;
        boolean z11 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f751e && (drawable2 = this.f750d) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f751e ? this.f748b == null && this.f749c == null : this.f750d == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        invalidate();
        Api21Impl.invalidateOutline(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f749c;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f749c);
        }
        this.f749c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f752f && (drawable2 = this.f749c) != null) {
                drawable2.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
            }
        }
        boolean z11 = true;
        if (!this.f751e ? !(this.f748b == null && this.f749c == null) : this.f750d != null) {
            z11 = false;
        }
        setWillNotDraw(z11);
        invalidate();
        Api21Impl.invalidateOutline(this);
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.mTabContainer;
        if (view != null) {
            removeView(view);
        }
        this.mTabContainer = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z11) {
        int i11;
        this.mIsTransitioning = z11;
        if (z11) {
            i11 = Opcodes.ASM6;
        } else {
            i11 = 262144;
        }
        setDescendantFocusability(i11);
    }

    public void setVisibility(int i11) {
        boolean z11;
        super.setVisibility(i11);
        if (i11 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Drawable drawable = this.f748b;
        if (drawable != null) {
            drawable.setVisible(z11, false);
        }
        Drawable drawable2 = this.f749c;
        if (drawable2 != null) {
            drawable2.setVisible(z11, false);
        }
        Drawable drawable3 = this.f750d;
        if (drawable3 != null) {
            drawable3.setVisible(z11, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i11) {
        if (i11 != 0) {
            return super.startActionModeForChild(view, callback, i11);
        }
        return null;
    }

    public boolean verifyDrawable(Drawable drawable) {
        if ((drawable != this.f748b || this.f751e) && ((drawable != this.f749c || !this.f752f) && ((drawable != this.f750d || !this.f751e) && !super.verifyDrawable(drawable)))) {
            return false;
        }
        return true;
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.setBackground(this, new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f748b = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f749c = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean z11 = true;
        if (getId() == R.id.split_action_bar) {
            this.f751e = true;
            this.f750d = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f751e ? !(this.f748b == null && this.f749c == null) : this.f750d != null) {
            z11 = false;
        }
        setWillNotDraw(z11);
    }
}
