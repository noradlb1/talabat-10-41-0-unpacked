package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public Runnable f852b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayoutCompat f853c;

    /* renamed from: d  reason: collision with root package name */
    public int f854d;

    /* renamed from: e  reason: collision with root package name */
    public int f855e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPropertyAnimator f856f;

    /* renamed from: g  reason: collision with root package name */
    public final VisibilityAnimListener f857g = new VisibilityAnimListener();
    private boolean mAllowCollapse;
    private int mContentHeight;
    private int mSelectedTabIndex;
    private TabClickListener mTabClickListener;
    private Spinner mTabSpinner;

    public class TabAdapter extends BaseAdapter {
        public TabAdapter() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.f853c.getChildCount();
        }

        public Object getItem(int i11) {
            return ((TabView) ScrollingTabContainerView.this.f853c.getChildAt(i11)).getTab();
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.a((ActionBar.Tab) getItem(i11), true);
            }
            ((TabView) view).bindTab((ActionBar.Tab) getItem(i11));
            return view;
        }
    }

    public class TabClickListener implements View.OnClickListener {
        public TabClickListener() {
        }

        public void onClick(View view) {
            boolean z11;
            ((TabView) view).getTab().select();
            int childCount = ScrollingTabContainerView.this.f853c.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = ScrollingTabContainerView.this.f853c.getChildAt(i11);
                if (childAt == view) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                childAt.setSelected(z11);
            }
        }
    }

    public class TabView extends LinearLayout {
        private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
        private final int[] BG_ATTRS;
        private View mCustomView;
        private ImageView mIconView;
        private ActionBar.Tab mTab;
        private TextView mTextView;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public TabView(android.content.Context r6, androidx.appcompat.app.ActionBar.Tab r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.ScrollingTabContainerView.this = r5
                int r5 = androidx.appcompat.R.attr.actionBarTabStyle
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.BG_ATTRS = r1
                r4.mTab = r7
                androidx.appcompat.widget.TintTypedArray r5 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r6, r0, r1, r5, r3)
                boolean r6 = r5.hasValue(r3)
                if (r6 == 0) goto L_0x0026
                android.graphics.drawable.Drawable r6 = r5.getDrawable(r3)
                r4.setBackgroundDrawable(r6)
            L_0x0026:
                r5.recycle()
                if (r8 == 0) goto L_0x0031
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L_0x0031:
                r4.update()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ScrollingTabContainerView.TabView.<init>(androidx.appcompat.widget.ScrollingTabContainerView, android.content.Context, androidx.appcompat.app.ActionBar$Tab, boolean):void");
        }

        public void bindTab(ActionBar.Tab tab) {
            this.mTab = tab;
            update();
        }

        public ActionBar.Tab getTab() {
            return this.mTab;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        public void onMeasure(int i11, int i12) {
            int i13;
            super.onMeasure(i11, i12);
            if (ScrollingTabContainerView.this.f854d > 0 && getMeasuredWidth() > (i13 = ScrollingTabContainerView.this.f854d)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), i12);
            }
        }

        public void setSelected(boolean z11) {
            boolean z12;
            if (isSelected() != z11) {
                z12 = true;
            } else {
                z12 = false;
            }
            super.setSelected(z11);
            if (z12 && z11) {
                sendAccessibilityEvent(4);
            }
        }

        public void update() {
            ActionBar.Tab tab = this.mTab;
            View customView = tab.getCustomView();
            CharSequence charSequence = null;
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.mCustomView = customView;
                TextView textView = this.mTextView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.mIconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.mIconView.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.mCustomView;
            if (view != null) {
                removeView(view);
                this.mCustomView = null;
            }
            Drawable icon = tab.getIcon();
            CharSequence text = tab.getText();
            if (icon != null) {
                if (this.mIconView == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.mIconView = appCompatImageView;
                }
                this.mIconView.setImageDrawable(icon);
                this.mIconView.setVisibility(0);
            } else {
                ImageView imageView2 = this.mIconView;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.mIconView.setImageDrawable((Drawable) null);
                }
            }
            boolean z11 = !TextUtils.isEmpty(text);
            if (z11) {
                if (this.mTextView == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.mTextView = appCompatTextView;
                }
                this.mTextView.setText(text);
                this.mTextView.setVisibility(0);
            } else {
                TextView textView2 = this.mTextView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.mTextView.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.mIconView;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.getContentDescription());
            }
            if (!z11) {
                charSequence = tab.getContentDescription();
            }
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    public class VisibilityAnimListener extends AnimatorListenerAdapter {
        private boolean mCanceled = false;
        private int mFinalVisibility;

        public VisibilityAnimListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.mCanceled) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.f856f = null;
                scrollingTabContainerView.setVisibility(this.mFinalVisibility);
            }
        }

        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator viewPropertyAnimator, int i11) {
            this.mFinalVisibility = i11;
            ScrollingTabContainerView.this.f856f = viewPropertyAnimator;
            return this;
        }
    }

    public ScrollingTabContainerView(@NonNull Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f855e = actionBarPolicy.getStackedTabMaxWidth();
        LinearLayoutCompat createTabLayout = createTabLayout();
        this.f853c = createTabLayout;
        addView(createTabLayout, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner createSpinner() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat createTabLayout() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean isCollapsed() {
        Spinner spinner = this.mTabSpinner;
        return spinner != null && spinner.getParent() == this;
    }

    private void performCollapse() {
        if (!isCollapsed()) {
            if (this.mTabSpinner == null) {
                this.mTabSpinner = createSpinner();
            }
            removeView(this.f853c);
            addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
            if (this.mTabSpinner.getAdapter() == null) {
                this.mTabSpinner.setAdapter(new TabAdapter());
            }
            Runnable runnable = this.f852b;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f852b = null;
            }
            this.mTabSpinner.setSelection(this.mSelectedTabIndex);
        }
    }

    private boolean performExpand() {
        if (!isCollapsed()) {
            return false;
        }
        removeView(this.mTabSpinner);
        addView(this.f853c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }

    public TabView a(ActionBar.Tab tab, boolean z11) {
        TabView tabView = new TabView(getContext(), tab, z11);
        if (z11) {
            tabView.setBackgroundDrawable((Drawable) null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
        } else {
            tabView.setFocusable(true);
            if (this.mTabClickListener == null) {
                this.mTabClickListener = new TabClickListener();
            }
            tabView.setOnClickListener(this.mTabClickListener);
        }
        return tabView;
    }

    public void addTab(ActionBar.Tab tab, boolean z11) {
        TabView a11 = a(tab, false);
        this.f853c.addView(a11, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z11) {
            a11.setSelected(true);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void animateToTab(int i11) {
        final View childAt = this.f853c.getChildAt(i11);
        Runnable runnable = this.f852b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f852b = null;
            }
        };
        this.f852b = r02;
        post(r02);
    }

    public void animateToVisibility(int i11) {
        ViewPropertyAnimator viewPropertyAnimator = this.f856f;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i11 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimator alpha = animate().alpha(1.0f);
            alpha.setDuration(200);
            alpha.setInterpolator(sAlphaInterpolator);
            alpha.setListener(this.f857g.withFinalVisibility(alpha, i11));
            alpha.start();
            return;
        }
        ViewPropertyAnimator alpha2 = animate().alpha(0.0f);
        alpha2.setDuration(200);
        alpha2.setInterpolator(sAlphaInterpolator);
        alpha2.setListener(this.f857g.withFinalVisibility(alpha2, i11));
        alpha2.start();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f852b;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f855e = actionBarPolicy.getStackedTabMaxWidth();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f852b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
        ((TabView) view).getTab().select();
    }

    public void onMeasure(int i11, int i12) {
        boolean z11;
        int mode = View.MeasureSpec.getMode(i11);
        boolean z12 = true;
        if (mode == 1073741824) {
            z11 = true;
        } else {
            z11 = false;
        }
        setFillViewport(z11);
        int childCount = this.f853c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f854d = -1;
        } else {
            if (childCount > 2) {
                this.f854d = (int) (((float) View.MeasureSpec.getSize(i11)) * 0.4f);
            } else {
                this.f854d = View.MeasureSpec.getSize(i11) / 2;
            }
            this.f854d = Math.min(this.f854d, this.f855e);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
        if (z11 || !this.mAllowCollapse) {
            z12 = false;
        }
        if (z12) {
            this.f853c.measure(0, makeMeasureSpec);
            if (this.f853c.getMeasuredWidth() > View.MeasureSpec.getSize(i11)) {
                performCollapse();
            } else {
                performExpand();
            }
        } else {
            performExpand();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i11, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z11 && measuredWidth != measuredWidth2) {
            setTabSelected(this.mSelectedTabIndex);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.f853c.removeAllViews();
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void removeTabAt(int i11) {
        this.f853c.removeViewAt(i11);
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z11) {
        this.mAllowCollapse = z11;
    }

    public void setContentHeight(int i11) {
        this.mContentHeight = i11;
        requestLayout();
    }

    public void setTabSelected(int i11) {
        boolean z11;
        this.mSelectedTabIndex = i11;
        int childCount = this.f853c.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = this.f853c.getChildAt(i12);
            if (i12 == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            childAt.setSelected(z11);
            if (z11) {
                animateToTab(i11);
            }
        }
        Spinner spinner = this.mTabSpinner;
        if (spinner != null && i11 >= 0) {
            spinner.setSelection(i11);
        }
    }

    public void updateTab(int i11) {
        ((TabView) this.f853c.getChildAt(i11)).update();
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void addTab(ActionBar.Tab tab, int i11, boolean z11) {
        TabView a11 = a(tab, false);
        this.f853c.addView(a11, i11, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z11) {
            a11.setSelected(true);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }
}
