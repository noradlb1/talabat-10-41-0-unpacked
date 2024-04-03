package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    @Dimension(unit = 0)
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT = 48;
    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_TabLayout;
    @Dimension(unit = 0)
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final String LOG_TAG = "TabLayout";
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    @Dimension(unit = 0)
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<Tab> tabPool = new Pools.SynchronizedPool(16);
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;
    @Nullable
    private BaseOnTabSelectedListener currentVpSelectedListener;
    boolean inlineLabel;
    int mode;
    private TabLayoutOnPageChangeListener pageChangeListener;
    @Nullable
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    @Nullable
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;
    @Nullable
    private Tab selectedTab;
    private boolean setupViewPagerImplicitly;
    @NonNull
    final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    int tabIndicatorAnimationMode;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabIndicatorHeight;
    /* access modifiers changed from: private */
    public TabIndicatorInterpolator tabIndicatorInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;
    @NonNull
    Drawable tabSelectedIndicator;
    /* access modifiers changed from: private */
    public int tabSelectedIndicatorColor;
    int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;
    @Nullable
    ViewPager viewPager;

    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;

        public AdapterChangeListener() {
        }

        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.viewPager == viewPager) {
                tabLayout.setPagerAdapter(pagerAdapter2, this.autoRefresh);
            }
        }

        public void setAutoRefresh(boolean z11) {
            this.autoRefresh = z11;
        }
    }

    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T t11);

        void onTabSelected(T t11);

        void onTabUnselected(T t11);
    }

    public @interface LabelVisibility {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    public class PagerAdapterObserver extends DataSetObserver {
        public PagerAdapterObserver() {
        }

        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    public class SlidingTabIndicator extends LinearLayout {
        ValueAnimator indicatorAnimator;
        private int layoutDirection = -1;
        int selectedPosition = -1;
        float selectionOffset;

        public SlidingTabIndicator(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        /* access modifiers changed from: private */
        public void jumpIndicatorToSelectedPosition() {
            View childAt = getChildAt(this.selectedPosition);
            TabIndicatorInterpolator access$1300 = TabLayout.this.tabIndicatorInterpolator;
            TabLayout tabLayout = TabLayout.this;
            access$1300.setIndicatorBoundsForTab(tabLayout, childAt, tabLayout.tabSelectedIndicator);
        }

        /* access modifiers changed from: private */
        public void tweenIndicatorPosition(View view, View view2, float f11) {
            boolean z11;
            if (view == null || view.getWidth() <= 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                TabIndicatorInterpolator access$1300 = TabLayout.this.tabIndicatorInterpolator;
                TabLayout tabLayout = TabLayout.this;
                access$1300.setIndicatorBoundsForOffset(tabLayout, view, view2, f11, tabLayout.tabSelectedIndicator);
            } else {
                Drawable drawable = TabLayout.this.tabSelectedIndicator;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.tabSelectedIndicator.getBounds().bottom);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        private void updateOrRecreateIndicatorAnimation(boolean z11, final int i11, int i12) {
            final View childAt = getChildAt(this.selectedPosition);
            final View childAt2 = getChildAt(i11);
            if (childAt2 == null) {
                jumpIndicatorToSelectedPosition();
                return;
            }
            AnonymousClass1 r22 = new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    SlidingTabIndicator.this.tweenIndicatorPosition(childAt, childAt2, valueAnimator.getAnimatedFraction());
                }
            };
            if (z11) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.indicatorAnimator = valueAnimator;
                valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                valueAnimator.setDuration((long) i12);
                valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
                valueAnimator.addUpdateListener(r22);
                valueAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        SlidingTabIndicator.this.selectedPosition = i11;
                    }

                    public void onAnimationStart(Animator animator) {
                        SlidingTabIndicator.this.selectedPosition = i11;
                    }
                });
                valueAnimator.start();
                return;
            }
            this.indicatorAnimator.removeAllUpdateListeners();
            this.indicatorAnimator.addUpdateListener(r22);
        }

        public void animateIndicatorToPosition(int i11, int i12) {
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.indicatorAnimator.cancel();
            }
            updateOrRecreateIndicatorAnimation(true, i11, i12);
        }

        public boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                if (getChildAt(i11).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        public void draw(@NonNull Canvas canvas) {
            int i11;
            int height = TabLayout.this.tabSelectedIndicator.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.tabSelectedIndicator.getIntrinsicHeight();
            }
            int i12 = TabLayout.this.tabIndicatorGravity;
            if (i12 == 0) {
                i11 = getHeight() - height;
                height = getHeight();
            } else if (i12 != 1) {
                i11 = 0;
                if (i12 != 2) {
                    if (i12 != 3) {
                        height = 0;
                    } else {
                        height = getHeight();
                    }
                }
            } else {
                i11 = (getHeight() - height) / 2;
                height = (getHeight() + height) / 2;
            }
            if (TabLayout.this.tabSelectedIndicator.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.tabSelectedIndicator.getBounds();
                TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, i11, bounds.right, height);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawable = tabLayout.tabSelectedIndicator;
                if (tabLayout.tabSelectedIndicatorColor != 0) {
                    drawable = DrawableCompat.wrap(drawable);
                    DrawableCompat.setTint(drawable, TabLayout.this.tabSelectedIndicatorColor);
                } else {
                    DrawableCompat.setTintList(drawable, (ColorStateList) null);
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        public float getIndicatorPosition() {
            return ((float) this.selectedPosition) + this.selectionOffset;
        }

        public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
            super.onLayout(z11, i11, i12, i13, i14);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                jumpIndicatorToSelectedPosition();
            } else {
                updateOrRecreateIndicatorAnimation(false, this.selectedPosition, -1);
            }
        }

        public void onMeasure(int i11, int i12) {
            super.onMeasure(i11, i12);
            if (View.MeasureSpec.getMode(i11) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z11 = true;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    int childCount = getChildCount();
                    int i13 = 0;
                    for (int i14 = 0; i14 < childCount; i14++) {
                        View childAt = getChildAt(i14);
                        if (childAt.getVisibility() == 0) {
                            i13 = Math.max(i13, childAt.getMeasuredWidth());
                        }
                    }
                    if (i13 > 0) {
                        if (i13 * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                            boolean z12 = false;
                            for (int i15 = 0; i15 < childCount; i15++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i15).getLayoutParams();
                                if (layoutParams.width != i13 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i13;
                                    layoutParams.weight = 0.0f;
                                    z12 = true;
                                }
                            }
                            z11 = z12;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.tabGravity = 0;
                            tabLayout2.updateTabViews(false);
                        }
                        if (z11) {
                            super.onMeasure(i11, i12);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i11) {
            super.onRtlPropertiesChanged(i11);
        }

        public void setIndicatorPositionFromTabPosition(int i11, float f11) {
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.indicatorAnimator.cancel();
            }
            this.selectedPosition = i11;
            this.selectionOffset = f11;
            tweenIndicatorPosition(getChildAt(i11), getChildAt(this.selectedPosition + 1), this.selectionOffset);
        }

        public void setSelectedIndicatorHeight(int i11) {
            Rect bounds = TabLayout.this.tabSelectedIndicator.getBounds();
            TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, 0, bounds.right, i11);
            requestLayout();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorAnimationMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;
        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.tabLayoutRef = new WeakReference<>(tabLayout);
        }

        public void onPageScrollStateChanged(int i11) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i11;
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            boolean z11;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                int i13 = this.scrollState;
                boolean z12 = false;
                if (i13 != 2 || this.previousScrollState == 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!(i13 == 2 && this.previousScrollState == 0)) {
                    z12 = true;
                }
                tabLayout.setScrollPosition(i11, f11, z11, z12);
            }
        }

        public void onPageSelected(int i11) {
            boolean z11;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i11 && i11 < tabLayout.getTabCount()) {
                int i12 = this.scrollState;
                if (i12 == 0 || (i12 == 2 && this.previousScrollState == 0)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i11), z11);
            }
        }

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public final class TabView extends LinearLayout {
        @Nullable
        private View badgeAnchorView;
        /* access modifiers changed from: private */
        @Nullable
        public BadgeDrawable badgeDrawable;
        @Nullable
        private Drawable baseBackgroundDrawable;
        @Nullable
        private ImageView customIconView;
        @Nullable
        private TextView customTextView;
        @Nullable
        private View customView;
        private int defaultMaxLines = 2;
        private ImageView iconView;
        private Tab tab;
        private TextView textView;

        public TabView(@NonNull Context context) {
            super(context);
            updateBackgroundDrawable(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(TabLayout.this.inlineLabel ^ true ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private void addOnLayoutChangeListener(@Nullable final View view) {
            if (view != null) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                        if (view.getVisibility() == 0) {
                            TabView.this.tryUpdateBadgeDrawableBounds(view);
                        }
                    }
                });
            }
        }

        private float approximateLineWidth(@NonNull Layout layout, int i11, float f11) {
            return layout.getLineWidth(i11) * (f11 / layout.getPaint().getTextSize());
        }

        private void clipViewToPaddingForBadge(boolean z11) {
            setClipChildren(z11);
            setClipToPadding(z11);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z11);
                viewGroup.setClipToPadding(z11);
            }
        }

        @NonNull
        private FrameLayout createPreApi18BadgeAnchorRoot() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* access modifiers changed from: private */
        public void drawBackground(@NonNull Canvas canvas) {
            Drawable drawable = this.baseBackgroundDrawable;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.baseBackgroundDrawable.draw(canvas);
            }
        }

        /* access modifiers changed from: private */
        @Nullable
        public BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        @Nullable
        private FrameLayout getCustomParentForBadge(@NonNull View view) {
            if ((view == this.iconView || view == this.textView) && BadgeUtils.USE_COMPAT_PARENT) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* access modifiers changed from: private */
        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable == null) {
                this.badgeDrawable = BadgeDrawable.create(getContext());
            }
            tryUpdateBadgeAnchor();
            BadgeDrawable badgeDrawable2 = this.badgeDrawable;
            if (badgeDrawable2 != null) {
                return badgeDrawable2;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        /* access modifiers changed from: private */
        public boolean hasBadgeDrawable() {
            return this.badgeDrawable != null;
        }

        private void inflateAndAddDefaultIconView() {
            ViewGroup viewGroup;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                viewGroup = createPreApi18BadgeAnchorRoot();
                addView(viewGroup, 0);
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, viewGroup, false);
            this.iconView = imageView;
            viewGroup.addView(imageView, 0);
        }

        private void inflateAndAddDefaultTextView() {
            ViewGroup viewGroup;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                viewGroup = createPreApi18BadgeAnchorRoot();
                addView(viewGroup);
            } else {
                viewGroup = this;
            }
            TextView textView2 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, viewGroup, false);
            this.textView = textView2;
            viewGroup.addView(textView2);
        }

        /* access modifiers changed from: private */
        public void removeBadge() {
            if (this.badgeAnchorView != null) {
                tryRemoveBadgeFromAnchor();
            }
            this.badgeDrawable = null;
        }

        private void tryAttachBadgeToAnchor(@Nullable View view) {
            if (hasBadgeDrawable() && view != null) {
                clipViewToPaddingForBadge(false);
                BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
                this.badgeAnchorView = view;
            }
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable()) {
                clipViewToPaddingForBadge(true);
                View view = this.badgeAnchorView;
                if (view != null) {
                    BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
                    this.badgeAnchorView = null;
                }
            }
        }

        private void tryUpdateBadgeAnchor() {
            Tab tab2;
            Tab tab3;
            if (hasBadgeDrawable()) {
                if (this.customView != null) {
                    tryRemoveBadgeFromAnchor();
                } else if (this.iconView != null && (tab3 = this.tab) != null && tab3.getIcon() != null) {
                    View view = this.badgeAnchorView;
                    ImageView imageView = this.iconView;
                    if (view != imageView) {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.iconView);
                        return;
                    }
                    tryUpdateBadgeDrawableBounds(imageView);
                } else if (this.textView == null || (tab2 = this.tab) == null || tab2.getTabLabelVisibility() != 1) {
                    tryRemoveBadgeFromAnchor();
                } else {
                    View view2 = this.badgeAnchorView;
                    TextView textView2 = this.textView;
                    if (view2 != textView2) {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.textView);
                        return;
                    }
                    tryUpdateBadgeDrawableBounds(textView2);
                }
            }
        }

        /* access modifiers changed from: private */
        public void tryUpdateBadgeDrawableBounds(@NonNull View view) {
            if (hasBadgeDrawable() && view == this.badgeAnchorView) {
                BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void updateBackgroundDrawable(android.content.Context r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.tabBackgroundResId
                r1 = 0
                if (r0 == 0) goto L_0x001f
                android.graphics.drawable.Drawable r6 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r6, r0)
                r5.baseBackgroundDrawable = r6
                if (r6 == 0) goto L_0x0021
                boolean r6 = r6.isStateful()
                if (r6 == 0) goto L_0x0021
                android.graphics.drawable.Drawable r6 = r5.baseBackgroundDrawable
                int[] r0 = r5.getDrawableState()
                r6.setState(r0)
                goto L_0x0021
            L_0x001f:
                r5.baseBackgroundDrawable = r1
            L_0x0021:
                android.graphics.drawable.GradientDrawable r6 = new android.graphics.drawable.GradientDrawable
                r6.<init>()
                r0 = 0
                r6.setColor(r0)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r0 = r0.tabRippleColorStateList
                if (r0 == 0) goto L_0x0058
                android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
                r0.<init>()
                r2 = 925353388(0x3727c5ac, float:1.0E-5)
                r0.setCornerRadius(r2)
                r2 = -1
                r0.setColor(r2)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.tabRippleColorStateList
                android.content.res.ColorStateList r2 = com.google.android.material.ripple.RippleUtils.convertToRippleDrawableColor(r2)
                android.graphics.drawable.RippleDrawable r3 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.unboundedRipple
                if (r4 == 0) goto L_0x0050
                r6 = r1
            L_0x0050:
                if (r4 == 0) goto L_0x0053
                goto L_0x0054
            L_0x0053:
                r1 = r0
            L_0x0054:
                r3.<init>(r2, r6, r1)
                r6 = r3
            L_0x0058:
                androidx.core.view.ViewCompat.setBackground(r5, r6)
                com.google.android.material.tabs.TabLayout r6 = com.google.android.material.tabs.TabLayout.this
                r6.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.updateBackgroundDrawable(android.content.Context):void");
        }

        private void updateTextAndIcon(@Nullable TextView textView2, @Nullable ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            int i11;
            Tab tab2 = this.tab;
            CharSequence charSequence2 = null;
            if (tab2 == null || tab2.getIcon() == null) {
                drawable = null;
            } else {
                drawable = DrawableCompat.wrap(this.tab.getIcon()).mutate();
            }
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, TabLayout.this.tabIconTint);
                PorterDuff.Mode mode = TabLayout.this.tabIconTintMode;
                if (mode != null) {
                    DrawableCompat.setTintMode(drawable, mode);
                }
            }
            Tab tab3 = this.tab;
            if (tab3 != null) {
                charSequence = tab3.getText();
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
            }
            boolean z11 = !TextUtils.isEmpty(charSequence);
            if (textView2 != null) {
                if (z11) {
                    textView2.setText(charSequence);
                    if (this.tab.labelVisibilityMode == 1) {
                        textView2.setVisibility(0);
                    } else {
                        textView2.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                    textView2.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (!z11 || imageView.getVisibility() != 0) {
                    i11 = 0;
                } else {
                    i11 = (int) ViewUtils.dpToPx(getContext(), 8);
                }
                if (TabLayout.this.inlineLabel) {
                    if (i11 != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, i11);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i11 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i11;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            Tab tab4 = this.tab;
            if (tab4 != null) {
                charSequence2 = tab4.contentDesc;
            }
            if (Build.VERSION.SDK_INT > 23) {
                if (!z11) {
                    charSequence = charSequence2;
                }
                TooltipCompat.setTooltipText(this, charSequence);
            }
        }

        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.baseBackgroundDrawable;
            boolean z11 = false;
            if (drawable != null && drawable.isStateful()) {
                z11 = false | this.baseBackgroundDrawable.setState(drawableState);
            }
            if (z11) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public int getContentHeight() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int i11 = 0;
            int i12 = 0;
            boolean z11 = false;
            for (int i13 = 0; i13 < 3; i13++) {
                View view = viewArr[i13];
                if (view != null && view.getVisibility() == 0) {
                    if (z11) {
                        i12 = Math.min(i12, view.getTop());
                    } else {
                        i12 = view.getTop();
                    }
                    if (z11) {
                        i11 = Math.max(i11, view.getBottom());
                    } else {
                        i11 = view.getBottom();
                    }
                    z11 = true;
                }
            }
            return i11 - i12;
        }

        public int getContentWidth() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int i11 = 0;
            int i12 = 0;
            boolean z11 = false;
            for (int i13 = 0; i13 < 3; i13++) {
                View view = viewArr[i13];
                if (view != null && view.getVisibility() == 0) {
                    if (z11) {
                        i12 = Math.min(i12, view.getLeft());
                    } else {
                        i12 = view.getLeft();
                    }
                    if (z11) {
                        i11 = Math.max(i11, view.getRight());
                    } else {
                        i11 = view.getRight();
                    }
                    z11 = true;
                }
            }
            return i11 - i12;
        }

        @Nullable
        public Tab getTab() {
            return this.tab;
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable2 = this.badgeDrawable;
            if (badgeDrawable2 != null && badgeDrawable2.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(contentDescription + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.badgeDrawable.getContentDescription());
            }
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
        }

        public void onMeasure(int i11, int i12) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i11);
            int mode = View.MeasureSpec.getMode(i11);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i11 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i11, i12);
            if (this.textView != null) {
                float f11 = TabLayout.this.tabTextSize;
                int i13 = this.defaultMaxLines;
                ImageView imageView = this.iconView;
                boolean z11 = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView2 = this.textView;
                    if (textView2 != null && textView2.getLineCount() > 1) {
                        f11 = TabLayout.this.tabTextMultiLineSize;
                    }
                } else {
                    i13 = 1;
                }
                float textSize = this.textView.getTextSize();
                int lineCount = this.textView.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.textView);
                int i14 = (f11 > textSize ? 1 : (f11 == textSize ? 0 : -1));
                if (i14 != 0 || (maxLines >= 0 && i13 != maxLines)) {
                    if (TabLayout.this.mode == 1 && i14 > 0 && lineCount == 1 && ((layout = this.textView.getLayout()) == null || approximateLineWidth(layout, 0, f11) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                        z11 = false;
                    }
                    if (z11) {
                        this.textView.setTextSize(0, f11);
                        this.textView.setMaxLines(i13);
                        super.onMeasure(i11, i12);
                    }
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.tab == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.tab.select();
            return true;
        }

        public void reset() {
            setTab((Tab) null);
            setSelected(false);
        }

        public void setSelected(boolean z11) {
            if (isSelected() != z11) {
            }
            super.setSelected(z11);
            TextView textView2 = this.textView;
            if (textView2 != null) {
                textView2.setSelected(z11);
            }
            ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setSelected(z11);
            }
            View view = this.customView;
            if (view != null) {
                view.setSelected(z11);
            }
        }

        public void setTab(@Nullable Tab tab2) {
            if (tab2 != this.tab) {
                this.tab = tab2;
                update();
            }
        }

        public final void update() {
            View view;
            boolean z11;
            Tab tab2 = this.tab;
            if (tab2 != null) {
                view = tab2.getCustomView();
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.customView = view;
                TextView textView2 = this.textView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iconView.setImageDrawable((Drawable) null);
                }
                TextView textView3 = (TextView) view.findViewById(16908308);
                this.customTextView = textView3;
                if (textView3 != null) {
                    this.defaultMaxLines = TextViewCompat.getMaxLines(textView3);
                }
                this.customIconView = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.customView;
                if (view2 != null) {
                    removeView(view2);
                    this.customView = null;
                }
                this.customTextView = null;
                this.customIconView = null;
            }
            if (this.customView == null) {
                if (this.iconView == null) {
                    inflateAndAddDefaultIconView();
                }
                if (this.textView == null) {
                    inflateAndAddDefaultTextView();
                    this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
                }
                TextViewCompat.setTextAppearance(this.textView, TabLayout.this.tabTextAppearance);
                ColorStateList colorStateList = TabLayout.this.tabTextColors;
                if (colorStateList != null) {
                    this.textView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.textView, this.iconView);
                tryUpdateBadgeAnchor();
                addOnLayoutChangeListener(this.iconView);
                addOnLayoutChangeListener(this.textView);
            } else {
                TextView textView4 = this.customTextView;
                if (!(textView4 == null && this.customIconView == null)) {
                    updateTextAndIcon(textView4, this.customIconView);
                }
            }
            if (tab2 != null && !TextUtils.isEmpty(tab2.contentDesc)) {
                setContentDescription(tab2.contentDesc);
            }
            if (tab2 == null || !tab2.isSelected()) {
                z11 = false;
            } else {
                z11 = true;
            }
            setSelected(z11);
        }

        public final void updateOrientation() {
            setOrientation(TabLayout.this.inlineLabel ^ true ? 1 : 0);
            TextView textView2 = this.customTextView;
            if (textView2 == null && this.customIconView == null) {
                updateTextAndIcon(this.textView, this.iconView);
            } else {
                updateTextAndIcon(textView2, this.customIconView);
            }
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager2) {
            this.viewPager = viewPager2;
        }

        public void onTabReselected(Tab tab) {
        }

        public void onTabSelected(@NonNull Tab tab) {
            this.viewPager.setCurrentItem(tab.getPosition());
        }

        public void onTabUnselected(Tab tab) {
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addTabFromItemView(@NonNull TabItem tabItem) {
        Tab newTab = newTab();
        CharSequence charSequence = tabItem.text;
        if (charSequence != null) {
            newTab.setText(charSequence);
        }
        Drawable drawable = tabItem.icon;
        if (drawable != null) {
            newTab.setIcon(drawable);
        }
        int i11 = tabItem.customLayout;
        if (i11 != 0) {
            newTab.setCustomView(i11);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.setContentDescription(tabItem.getContentDescription());
        }
        addTab(newTab);
    }

    private void addTabView(@NonNull Tab tab) {
        TabView tabView = tab.view;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.slidingTabIndicator.addView(tabView, tab.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View view) {
        if (view instanceof TabItem) {
            addTabFromItemView((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void animateToTab(int i11) {
        if (i11 != -1) {
            if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.slidingTabIndicator.childrenNeedLayout()) {
                setScrollPosition(i11, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int calculateScrollXForTab = calculateScrollXForTab(i11, 0.0f);
            if (scrollX != calculateScrollXForTab) {
                ensureScrollAnimator();
                this.scrollAnimator.setIntValues(new int[]{scrollX, calculateScrollXForTab});
                this.scrollAnimator.start();
            }
            this.slidingTabIndicator.animateIndicatorToPosition(i11, this.tabIndicatorAnimationDuration);
        }
    }

    private void applyGravityForModeScrollable(int i11) {
        if (i11 == 0) {
            Log.w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i11 == 1) {
            this.slidingTabIndicator.setGravity(1);
            return;
        } else if (i11 != 2) {
            return;
        }
        this.slidingTabIndicator.setGravity(GravityCompat.START);
    }

    private void applyModeAndGravity() {
        int i11;
        int i12 = this.mode;
        if (i12 == 0 || i12 == 2) {
            i11 = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
        } else {
            i11 = 0;
        }
        ViewCompat.setPaddingRelative(this.slidingTabIndicator, i11, 0, 0, 0);
        int i13 = this.mode;
        if (i13 == 0) {
            applyGravityForModeScrollable(this.tabGravity);
        } else if (i13 == 1 || i13 == 2) {
            if (this.tabGravity == 2) {
                Log.w(LOG_TAG, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.slidingTabIndicator.setGravity(1);
        }
        updateTabViews(true);
    }

    private int calculateScrollXForTab(int i11, float f11) {
        View childAt;
        View view;
        int i12 = this.mode;
        int i13 = 0;
        if ((i12 != 0 && i12 != 2) || (childAt = this.slidingTabIndicator.getChildAt(i11)) == null) {
            return 0;
        }
        int i14 = i11 + 1;
        if (i14 < this.slidingTabIndicator.getChildCount()) {
            view = this.slidingTabIndicator.getChildAt(i14);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            i13 = view.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i15 = (int) (((float) (width + i13)) * 0.5f * f11);
        if (ViewCompat.getLayoutDirection(this) == 0) {
            return left + i15;
        }
        return left - i15;
    }

    private void configureTab(@NonNull Tab tab, int i11) {
        tab.setPosition(i11);
        this.tabs.add(i11, tab);
        int size = this.tabs.size();
        while (true) {
            i11++;
            if (i11 < size) {
                this.tabs.get(i11).setPosition(i11);
            } else {
                return;
            }
        }
    }

    @NonNull
    private static ColorStateList createColorStateList(int i11, int i12) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i12, i11});
    }

    @NonNull
    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    @NonNull
    private TabView createTabView(@NonNull Tab tab) {
        TabView tabView;
        Pools.Pool<TabView> pool = this.tabViewPool;
        if (pool != null) {
            tabView = pool.acquire();
        } else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.contentDesc)) {
            tabView.setContentDescription(tab.text);
        } else {
            tabView.setContentDescription(tab.contentDesc);
        }
        return tabView;
    }

    private void dispatchTabReselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabReselected(tab);
        }
    }

    private void dispatchTabSelected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabSelected(tab);
        }
    }

    private void dispatchTabUnselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabUnselected(tab);
        }
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.scrollAnimator.setDuration((long) this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.tabs.size();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 < size) {
                Tab tab = this.tabs.get(i11);
                if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText())) {
                    z11 = true;
                    break;
                }
                i11++;
            } else {
                break;
            }
        }
        if (!z11 || this.inlineLabel) {
            return 48;
        }
        return 72;
    }

    private int getTabMinWidth() {
        int i11 = this.requestedTabMinWidth;
        if (i11 != -1) {
            return i11;
        }
        int i12 = this.mode;
        if (i12 == 0 || i12 == 2) {
            return this.scrollableTabMinWidth;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void removeTabViewAt(int i11) {
        TabView tabView = (TabView) this.slidingTabIndicator.getChildAt(i11);
        this.slidingTabIndicator.removeViewAt(i11);
        if (tabView != null) {
            tabView.reset();
            this.tabViewPool.release(tabView);
        }
        requestLayout();
    }

    private void setSelectedTabView(int i11) {
        boolean z11;
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i11 < childCount) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = this.slidingTabIndicator.getChildAt(i12);
                boolean z12 = true;
                if (i12 == i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                childAt.setSelected(z11);
                if (i12 != i11) {
                    z12 = false;
                }
                childAt.setActivated(z12);
            }
        }
    }

    private void updateAllTabs() {
        int size = this.tabs.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.tabs.get(i11).updateView();
        }
    }

    private void updateTabViewLayoutParams(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        addOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void addTab(@NonNull Tab tab) {
        addTab(tab, this.tabs.isEmpty());
    }

    public void addView(View view) {
        addViewInternal(view);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public Tab createTabFromPool() {
        Tab acquire = tabPool.acquire();
        if (acquire == null) {
            return new Tab();
        }
        return acquire;
    }

    public int getSelectedTabPosition() {
        Tab tab = this.selectedTab;
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    @Nullable
    public Tab getTabAt(int i11) {
        if (i11 < 0 || i11 >= getTabCount()) {
            return null;
        }
        return this.tabs.get(i11);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    @NonNull
    public Tab newTab() {
        Tab createTabFromPool = createTabFromPool();
        createTabFromPool.parent = this;
        createTabFromPool.view = createTabView(createTabFromPool);
        if (createTabFromPool.f44536id != -1) {
            createTabFromPool.view.setId(createTabFromPool.f44536id);
        }
        return createTabFromPool;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager((ViewPager) null);
            this.setupViewPagerImplicitly = false;
        }
    }

    public void onDraw(@NonNull Canvas canvas) {
        for (int i11 = 0; i11 < this.slidingTabIndicator.getChildCount(); i11++) {
            View childAt = this.slidingTabIndicator.getChildAt(i11);
            if (childAt instanceof TabView) {
                ((TabView) childAt).drawBackground(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r0 != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.ViewUtils.dpToPx(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L_0x002e
            if (r1 == 0) goto L_0x001f
            goto L_0x0041
        L_0x001f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L_0x0041
        L_0x002e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L_0x0041
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L_0x0041
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L_0x0041:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L_0x005f
            int r1 = r6.requestedTabMaxWidth
            if (r1 <= 0) goto L_0x0050
            goto L_0x005d
        L_0x0050:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.ViewUtils.dpToPx(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L_0x005d:
            r6.tabMaxWidth = r1
        L_0x005f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto L_0x00ad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.mode
            if (r0 == 0) goto L_0x0082
            if (r0 == r5) goto L_0x0076
            r1 = 2
            if (r0 == r1) goto L_0x0082
            goto L_0x008d
        L_0x0076:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L_0x008d
        L_0x0080:
            r4 = r5
            goto L_0x008d
        L_0x0082:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L_0x008d
            goto L_0x0080
        L_0x008d:
            if (r4 == 0) goto L_0x00ad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 != null) {
            int count = pagerAdapter2.getCount();
            for (int i11 = 0; i11 < count; i11++) {
                addTab(newTab().setText(this.pagerAdapter.getPageTitle(i11)), false);
            }
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 != null && count > 0 && (currentItem = viewPager2.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                selectTab(getTabAt(currentItem));
            }
        }
    }

    public boolean releaseFromTabPool(Tab tab) {
        return tabPool.release(tab);
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<Tab> it = this.tabs.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.reset();
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        removeOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void removeTab(@NonNull Tab tab) {
        if (tab.parent == this) {
            removeTabAt(tab.getPosition());
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int i11) {
        int i12;
        Tab tab;
        Tab tab2 = this.selectedTab;
        if (tab2 != null) {
            i12 = tab2.getPosition();
        } else {
            i12 = 0;
        }
        removeTabViewAt(i11);
        Tab remove = this.tabs.remove(i11);
        if (remove != null) {
            remove.reset();
            releaseFromTabPool(remove);
        }
        int size = this.tabs.size();
        for (int i13 = i11; i13 < size; i13++) {
            this.tabs.get(i13).setPosition(i13);
        }
        if (i12 == i11) {
            if (this.tabs.isEmpty()) {
                tab = null;
            } else {
                tab = this.tabs.get(Math.max(0, i11 - 1));
            }
            selectTab(tab);
        }
    }

    public void selectTab(@Nullable Tab tab) {
        selectTab(tab, true);
    }

    @RequiresApi(21)
    public void setElevation(float f11) {
        super.setElevation(f11);
        MaterialShapeUtils.setElevation(this, f11);
    }

    public void setInlineLabel(boolean z11) {
        if (this.inlineLabel != z11) {
            this.inlineLabel = z11;
            for (int i11 = 0; i11 < this.slidingTabIndicator.getChildCount(); i11++) {
                View childAt = this.slidingTabIndicator.getChildAt(i11);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateOrientation();
                }
            }
            applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(@BoolRes int i11) {
        setInlineLabel(getResources().getBoolean(i11));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void setPagerAdapter(@Nullable PagerAdapter pagerAdapter2, boolean z11) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter3 = this.pagerAdapter;
        if (!(pagerAdapter3 == null || (dataSetObserver = this.pagerAdapterObserver) == null)) {
            pagerAdapter3.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = pagerAdapter2;
        if (z11 && pagerAdapter2 != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new PagerAdapterObserver();
            }
            pagerAdapter2.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int i11, float f11, boolean z11) {
        setScrollPosition(i11, f11, z11, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.tabSelectedIndicator != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.tabSelectedIndicator = drawable;
            int i11 = this.tabIndicatorHeight;
            if (i11 == -1) {
                i11 = drawable.getIntrinsicHeight();
            }
            this.slidingTabIndicator.setSelectedIndicatorHeight(i11);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i11) {
        this.tabSelectedIndicatorColor = i11;
        updateTabViews(false);
    }

    public void setSelectedTabIndicatorGravity(int i11) {
        if (this.tabIndicatorGravity != i11) {
            this.tabIndicatorGravity = i11;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i11) {
        this.tabIndicatorHeight = i11;
        this.slidingTabIndicator.setSelectedIndicatorHeight(i11);
    }

    public void setTabGravity(int i11) {
        if (this.tabGravity != i11) {
            this.tabGravity = i11;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIconTintResource(@ColorRes int i11) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i11));
    }

    public void setTabIndicatorAnimationMode(int i11) {
        this.tabIndicatorAnimationMode = i11;
        if (i11 == 0) {
            this.tabIndicatorInterpolator = new TabIndicatorInterpolator();
        } else if (i11 == 1) {
            this.tabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
        } else {
            throw new IllegalArgumentException(i11 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z11) {
        this.tabIndicatorFullWidth = z11;
        this.slidingTabIndicator.jumpIndicatorToSelectedPosition();
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMode(int i11) {
        if (i11 != this.mode) {
            this.mode = i11;
            applyModeAndGravity();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i11 = 0; i11 < this.slidingTabIndicator.getChildCount(); i11++) {
                View childAt = this.slidingTabIndicator.getChildAt(i11);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i11) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i11));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter2) {
        setPagerAdapter(pagerAdapter2, false);
    }

    public void setUnboundedRipple(boolean z11) {
        if (this.unboundedRipple != z11) {
            this.unboundedRipple = z11;
            for (int i11 = 0; i11 < this.slidingTabIndicator.getChildCount(); i11++) {
                View childAt = this.slidingTabIndicator.getChildAt(i11);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i11) {
        setUnboundedRipple(getResources().getBoolean(i11));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager2) {
        setupWithViewPager(viewPager2, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public void updateTabViews(boolean z11) {
        for (int i11 = 0; i11 < this.slidingTabIndicator.getChildCount(); i11++) {
            View childAt = this.slidingTabIndicator.getChildAt(i11);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z11) {
                childAt.requestLayout();
            }
        }
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence contentDesc;
        @Nullable
        private View customView;
        @Nullable
        private Drawable icon;
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public int f44536id = -1;
        /* access modifiers changed from: private */
        @LabelVisibility
        public int labelVisibilityMode = 1;
        @Nullable
        public TabLayout parent;
        private int position = -1;
        @Nullable
        private Object tag;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence text;
        @NonNull
        public TabView view;

        @Nullable
        public BadgeDrawable getBadge() {
            return this.view.getBadge();
        }

        @Nullable
        public CharSequence getContentDescription() {
            TabView tabView = this.view;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @Nullable
        public View getCustomView() {
            return this.customView;
        }

        @Nullable
        public Drawable getIcon() {
            return this.icon;
        }

        public int getId() {
            return this.f44536id;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            return this.view.getOrCreateBadge();
        }

        public int getPosition() {
            return this.position;
        }

        @LabelVisibility
        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        @Nullable
        public Object getTag() {
            return this.tag;
        }

        @Nullable
        public CharSequence getText() {
            return this.text;
        }

        public boolean isSelected() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                if (selectedTabPosition == -1 || selectedTabPosition != this.position) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void removeBadge() {
            this.view.removeBadge();
        }

        public void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.f44536id = -1;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        public void select() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                tabLayout.selectTab(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setContentDescription(@StringRes int i11) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setContentDescription(tabLayout.getResources().getText(i11));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setCustomView(@Nullable View view2) {
            this.customView = view2;
            updateView();
            return this;
        }

        @NonNull
        public Tab setIcon(@Nullable Drawable drawable) {
            this.icon = drawable;
            TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        public Tab setId(int i11) {
            this.f44536id = i11;
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.setId(i11);
            }
            return this;
        }

        public void setPosition(int i11) {
            this.position = i11;
        }

        @NonNull
        public Tab setTabLabelVisibility(@LabelVisibility int i11) {
            this.labelVisibilityMode = i11;
            TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        public Tab setTag(@Nullable Object obj) {
            this.tag = obj;
            return this;
        }

        @NonNull
        public Tab setText(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.contentDesc) && !TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.text = charSequence;
            updateView();
            return this;
        }

        public void updateView() {
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.update();
            }
        }

        @NonNull
        public Tab setCustomView(@LayoutRes int i11) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(i11, this.view, false));
        }

        @NonNull
        public Tab setContentDescription(@Nullable CharSequence charSequence) {
            this.contentDesc = charSequence;
            updateView();
            return this;
        }

        @NonNull
        public Tab setText(@StringRes int i11) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setText(tabLayout.getResources().getText(i11));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setIcon(@DrawableRes int i11) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setIcon(AppCompatResources.getDrawable(tabLayout.getContext(), i11));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (!this.selectedListeners.contains(baseOnTabSelectedListener)) {
            this.selectedListeners.add(baseOnTabSelectedListener);
        }
    }

    public void addTab(@NonNull Tab tab, int i11) {
        addTab(tab, i11, this.tabs.isEmpty());
    }

    public void addView(View view, int i11) {
        addViewInternal(view);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.selectedListeners.remove(baseOnTabSelectedListener);
    }

    public void selectTab(@Nullable Tab tab, boolean z11) {
        Tab tab2 = this.selectedTab;
        if (tab2 != tab) {
            int position = tab != null ? tab.getPosition() : -1;
            if (z11) {
                if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                    setScrollPosition(position, 0.0f, true);
                } else {
                    animateToTab(position);
                }
                if (position != -1) {
                    setSelectedTabView(position);
                }
            }
            this.selectedTab = tab;
            if (tab2 != null) {
                dispatchTabUnselected(tab2);
            }
            if (tab != null) {
                dispatchTabSelected(tab);
            }
        } else if (tab2 != null) {
            dispatchTabReselected(tab);
            animateToTab(tab.getPosition());
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
        if (baseOnTabSelectedListener2 != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener2);
        }
        this.selectedListener = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            addOnTabSelectedListener(baseOnTabSelectedListener);
        }
    }

    public void setScrollPosition(int i11, float f11, boolean z11, boolean z12) {
        int i12;
        int round = Math.round(((float) i11) + f11);
        if (round >= 0 && round < this.slidingTabIndicator.getChildCount()) {
            if (z12) {
                this.slidingTabIndicator.setIndicatorPositionFromTabPosition(i11, f11);
            }
            ValueAnimator valueAnimator = this.scrollAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.scrollAnimator.cancel();
            }
            if (i11 < 0) {
                i12 = 0;
            } else {
                i12 = calculateScrollXForTab(i11, f11);
            }
            scrollTo(i12, 0);
            if (z11) {
                setSelectedTabView(round);
            }
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager2, boolean z11) {
        setupWithViewPager(viewPager2, z11, false);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r12, @androidx.annotation.Nullable android.util.AttributeSet r13, int r14) {
        /*
            r11 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r12 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r12, r13, r14, r4)
            r11.<init>(r12, r13, r14)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r11.tabs = r12
            android.graphics.drawable.GradientDrawable r12 = new android.graphics.drawable.GradientDrawable
            r12.<init>()
            r11.tabSelectedIndicator = r12
            r12 = 0
            r11.tabSelectedIndicatorColor = r12
            r0 = 2147483647(0x7fffffff, float:NaN)
            r11.tabMaxWidth = r0
            r6 = -1
            r11.tabIndicatorHeight = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r11.selectedListeners = r0
            androidx.core.util.Pools$SimplePool r0 = new androidx.core.util.Pools$SimplePool
            r1 = 12
            r0.<init>(r1)
            r11.tabViewPool = r0
            android.content.Context r7 = r11.getContext()
            r11.setHorizontalScrollBarEnabled(r12)
            com.google.android.material.tabs.TabLayout$SlidingTabIndicator r8 = new com.google.android.material.tabs.TabLayout$SlidingTabIndicator
            r8.<init>(r7)
            r11.slidingTabIndicator = r8
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = -2
            r0.<init>(r1, r6)
            super.addView(r8, r12, r0)
            int[] r2 = com.google.android.material.R.styleable.TabLayout
            r9 = 1
            int[] r5 = new int[r9]
            int r10 = com.google.android.material.R.styleable.TabLayout_tabTextAppearance
            r5[r12] = r10
            r0 = r7
            r1 = r13
            r3 = r14
            android.content.res.TypedArray r13 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            android.graphics.drawable.Drawable r14 = r11.getBackground()
            boolean r14 = r14 instanceof android.graphics.drawable.ColorDrawable
            if (r14 == 0) goto L_0x0084
            android.graphics.drawable.Drawable r14 = r11.getBackground()
            android.graphics.drawable.ColorDrawable r14 = (android.graphics.drawable.ColorDrawable) r14
            com.google.android.material.shape.MaterialShapeDrawable r0 = new com.google.android.material.shape.MaterialShapeDrawable
            r0.<init>()
            int r14 = r14.getColor()
            android.content.res.ColorStateList r14 = android.content.res.ColorStateList.valueOf(r14)
            r0.setFillColor(r14)
            r0.initializeElevationOverlay(r7)
            float r14 = androidx.core.view.ViewCompat.getElevation(r11)
            r0.setElevation(r14)
            androidx.core.view.ViewCompat.setBackground(r11, r0)
        L_0x0084:
            int r14 = com.google.android.material.R.styleable.TabLayout_tabIndicator
            android.graphics.drawable.Drawable r14 = com.google.android.material.resources.MaterialResources.getDrawable(r7, r13, r14)
            r11.setSelectedTabIndicator((android.graphics.drawable.Drawable) r14)
            int r14 = com.google.android.material.R.styleable.TabLayout_tabIndicatorColor
            int r14 = r13.getColor(r14, r12)
            r11.setSelectedTabIndicatorColor(r14)
            int r14 = com.google.android.material.R.styleable.TabLayout_tabIndicatorHeight
            int r14 = r13.getDimensionPixelSize(r14, r6)
            r8.setSelectedIndicatorHeight(r14)
            int r14 = com.google.android.material.R.styleable.TabLayout_tabIndicatorGravity
            int r14 = r13.getInt(r14, r12)
            r11.setSelectedTabIndicatorGravity(r14)
            int r14 = com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationMode
            int r14 = r13.getInt(r14, r12)
            r11.setTabIndicatorAnimationMode(r14)
            int r14 = com.google.android.material.R.styleable.TabLayout_tabIndicatorFullWidth
            boolean r14 = r13.getBoolean(r14, r9)
            r11.setTabIndicatorFullWidth(r14)
            int r14 = com.google.android.material.R.styleable.TabLayout_tabPadding
            int r14 = r13.getDimensionPixelSize(r14, r12)
            r11.tabPaddingBottom = r14
            r11.tabPaddingEnd = r14
            r11.tabPaddingTop = r14
            r11.tabPaddingStart = r14
            int r0 = com.google.android.material.R.styleable.TabLayout_tabPaddingStart
            int r14 = r13.getDimensionPixelSize(r0, r14)
            r11.tabPaddingStart = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabPaddingTop
            int r0 = r11.tabPaddingTop
            int r14 = r13.getDimensionPixelSize(r14, r0)
            r11.tabPaddingTop = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabPaddingEnd
            int r0 = r11.tabPaddingEnd
            int r14 = r13.getDimensionPixelSize(r14, r0)
            r11.tabPaddingEnd = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabPaddingBottom
            int r0 = r11.tabPaddingBottom
            int r14 = r13.getDimensionPixelSize(r14, r0)
            r11.tabPaddingBottom = r14
            int r14 = com.google.android.material.R.style.TextAppearance_Design_Tab
            int r14 = r13.getResourceId(r10, r14)
            r11.tabTextAppearance = r14
            int[] r0 = androidx.appcompat.R.styleable.TextAppearance
            android.content.res.TypedArray r14 = r7.obtainStyledAttributes(r14, r0)
            int r0 = androidx.appcompat.R.styleable.TextAppearance_android_textSize     // Catch:{ all -> 0x01b9 }
            int r0 = r14.getDimensionPixelSize(r0, r12)     // Catch:{ all -> 0x01b9 }
            float r0 = (float) r0     // Catch:{ all -> 0x01b9 }
            r11.tabTextSize = r0     // Catch:{ all -> 0x01b9 }
            int r0 = androidx.appcompat.R.styleable.TextAppearance_android_textColor     // Catch:{ all -> 0x01b9 }
            android.content.res.ColorStateList r0 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r7, (android.content.res.TypedArray) r14, (int) r0)     // Catch:{ all -> 0x01b9 }
            r11.tabTextColors = r0     // Catch:{ all -> 0x01b9 }
            r14.recycle()
            int r14 = com.google.android.material.R.styleable.TabLayout_tabTextColor
            boolean r0 = r13.hasValue(r14)
            if (r0 == 0) goto L_0x011e
            android.content.res.ColorStateList r14 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r7, (android.content.res.TypedArray) r13, (int) r14)
            r11.tabTextColors = r14
        L_0x011e:
            int r14 = com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor
            boolean r0 = r13.hasValue(r14)
            if (r0 == 0) goto L_0x0136
            int r14 = r13.getColor(r14, r12)
            android.content.res.ColorStateList r0 = r11.tabTextColors
            int r0 = r0.getDefaultColor()
            android.content.res.ColorStateList r14 = createColorStateList(r0, r14)
            r11.tabTextColors = r14
        L_0x0136:
            int r14 = com.google.android.material.R.styleable.TabLayout_tabIconTint
            android.content.res.ColorStateList r14 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r7, (android.content.res.TypedArray) r13, (int) r14)
            r11.tabIconTint = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabIconTintMode
            int r14 = r13.getInt(r14, r6)
            r0 = 0
            android.graphics.PorterDuff$Mode r14 = com.google.android.material.internal.ViewUtils.parseTintMode(r14, r0)
            r11.tabIconTintMode = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabRippleColor
            android.content.res.ColorStateList r14 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r7, (android.content.res.TypedArray) r13, (int) r14)
            r11.tabRippleColorStateList = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationDuration
            r0 = 300(0x12c, float:4.2E-43)
            int r14 = r13.getInt(r14, r0)
            r11.tabIndicatorAnimationDuration = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabMinWidth
            int r14 = r13.getDimensionPixelSize(r14, r6)
            r11.requestedTabMinWidth = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabMaxWidth
            int r14 = r13.getDimensionPixelSize(r14, r6)
            r11.requestedTabMaxWidth = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabBackground
            int r14 = r13.getResourceId(r14, r12)
            r11.tabBackgroundResId = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabContentStart
            int r14 = r13.getDimensionPixelSize(r14, r12)
            r11.contentInsetStart = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabMode
            int r14 = r13.getInt(r14, r9)
            r11.mode = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabGravity
            int r14 = r13.getInt(r14, r12)
            r11.tabGravity = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabInlineLabel
            boolean r14 = r13.getBoolean(r14, r12)
            r11.inlineLabel = r14
            int r14 = com.google.android.material.R.styleable.TabLayout_tabUnboundedRipple
            boolean r12 = r13.getBoolean(r14, r12)
            r11.unboundedRipple = r12
            r13.recycle()
            android.content.res.Resources r12 = r11.getResources()
            int r13 = com.google.android.material.R.dimen.design_tab_text_size_2line
            int r13 = r12.getDimensionPixelSize(r13)
            float r13 = (float) r13
            r11.tabTextMultiLineSize = r13
            int r13 = com.google.android.material.R.dimen.design_tab_scrollable_min_width
            int r12 = r12.getDimensionPixelSize(r13)
            r11.scrollableTabMinWidth = r12
            r11.applyModeAndGravity()
            return
        L_0x01b9:
            r12 = move-exception
            r14.recycle()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager2, boolean z11, boolean z12) {
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager3.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener2 = this.adapterChangeListener;
            if (adapterChangeListener2 != null) {
                this.viewPager.removeOnAdapterChangeListener(adapterChangeListener2);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.currentVpSelectedListener;
        if (baseOnTabSelectedListener != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener);
            this.currentVpSelectedListener = null;
        }
        if (viewPager2 != null) {
            this.viewPager = viewPager2;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.pageChangeListener.reset();
            viewPager2.addOnPageChangeListener(this.pageChangeListener);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager2);
            this.currentVpSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener((BaseOnTabSelectedListener) viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager2.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z11);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new AdapterChangeListener();
            }
            this.adapterChangeListener.setAutoRefresh(z11);
            viewPager2.addOnAdapterChangeListener(this.adapterChangeListener);
            setScrollPosition(viewPager2.getCurrentItem(), 0.0f, true);
        } else {
            this.viewPager = null;
            setPagerAdapter((PagerAdapter) null, false);
        }
        this.setupViewPagerImplicitly = z12;
    }

    public void addTab(@NonNull Tab tab, boolean z11) {
        addTab(tab, this.tabs.size(), z11);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void addTab(@NonNull Tab tab, int i11, boolean z11) {
        if (tab.parent == this) {
            configureTab(tab, i11);
            addTabView(tab);
            if (z11) {
                tab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void setTabTextColors(int i11, int i12) {
        setTabTextColors(createColorStateList(i11, i12));
    }

    public void setSelectedTabIndicator(@DrawableRes int i11) {
        if (i11 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i11));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
