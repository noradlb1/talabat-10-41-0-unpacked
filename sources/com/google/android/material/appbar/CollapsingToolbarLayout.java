package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CollapsingToolbarLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_CollapsingToolbar;
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;
    @NonNull
    final CollapsingTextHelper collapsingTextHelper;
    private boolean collapsingTitleEnabled;
    @Nullable
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;
    @NonNull
    final ElevationOverlayProvider elevationOverlayProvider;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    private int extraMultilineHeight;
    private boolean extraMultilineHeightEnabled;
    private boolean forceApplySystemWindowInsetTop;
    @Nullable
    WindowInsetsCompat lastInsets;
    private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;
    @Nullable
    Drawable statusBarScrim;
    private int titleCollapseMode;
    private final Rect tmpRect;
    @Nullable
    private ViewGroup toolbar;
    @Nullable
    private View toolbarDirectChild;
    private int toolbarId;
    private int topInsetApplied;

    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        public OffsetUpdateListener() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
            int i12;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.currentOffset = i11;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.lastInsets;
            if (windowInsetsCompat != null) {
                i12 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i12 = 0;
            }
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i13);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                int i14 = layoutParams.collapseMode;
                if (i14 == 1) {
                    viewOffsetHelper.setTopAndBottomOffset(MathUtils.clamp(-i11, 0, CollapsingToolbarLayout.this.getMaxOffsetForPinChild(childAt)));
                } else if (i14 == 2) {
                    viewOffsetHelper.setTopAndBottomOffset(Math.round(((float) (-i11)) * layoutParams.parallaxMult));
                }
            }
            CollapsingToolbarLayout.this.updateScrimVisibility();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.statusBarScrim != null && i12 > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int minimumHeight = (height - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - i12;
            float f11 = (float) minimumHeight;
            CollapsingToolbarLayout.this.collapsingTextHelper.setFadeModeStartFraction(Math.min(1.0f, ((float) (height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger())) / f11));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.collapsingTextHelper.setCurrentOffsetY(collapsingToolbarLayout3.currentOffset + minimumHeight);
            CollapsingToolbarLayout.this.collapsingTextHelper.setExpansionFraction(((float) Math.abs(i11)) / f11);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TitleCollapseMode {
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateScrim(int i11) {
        TimeInterpolator timeInterpolator;
        ensureToolbar();
        ValueAnimator valueAnimator = this.scrimAnimator;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.scrimAnimator = valueAnimator2;
            if (i11 > this.scrimAlpha) {
                timeInterpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            } else {
                timeInterpolator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            }
            valueAnimator2.setInterpolator(timeInterpolator);
            this.scrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.scrimAnimator.cancel();
        }
        this.scrimAnimator.setDuration(this.scrimAnimationDuration);
        this.scrimAnimator.setIntValues(new int[]{this.scrimAlpha, i11});
        this.scrimAnimator.start();
    }

    private void disableLiftOnScrollIfNeeded(AppBarLayout appBarLayout) {
        if (isTitleCollapseFadeMode()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ensureToolbar() {
        /*
            r6 = this;
            boolean r0 = r6.refreshToolbar
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.toolbar = r0
            r6.toolbarDirectChild = r0
            int r1 = r6.toolbarId
            r2 = -1
            if (r1 == r2) goto L_0x001f
            android.view.View r1 = r6.findViewById(r1)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r6.toolbar = r1
            if (r1 == 0) goto L_0x001f
            android.view.View r1 = r6.findDirectChild(r1)
            r6.toolbarDirectChild = r1
        L_0x001f:
            android.view.ViewGroup r1 = r6.toolbar
            r2 = 0
            if (r1 != 0) goto L_0x003e
            int r1 = r6.getChildCount()
            r3 = r2
        L_0x0029:
            if (r3 >= r1) goto L_0x003c
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = isToolbar(r4)
            if (r5 == 0) goto L_0x0039
            r0 = r4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x003c
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x003c:
            r6.toolbar = r0
        L_0x003e:
            r6.updateDummyView()
            r6.refreshToolbar = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.ensureToolbar():void");
    }

    @NonNull
    private View findDirectChild(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    private static int getHeightWithMargins(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static CharSequence getToolbarTitle(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @NonNull
    public static ViewOffsetHelper getViewOffsetHelper(@NonNull View view) {
        int i11 = R.id.view_offset_helper;
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(i11);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(i11, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    private boolean isTitleCollapseFadeMode() {
        return this.titleCollapseMode == 1;
    }

    private static boolean isToolbar(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    private boolean isToolbarChild(View view) {
        View view2 = this.toolbarDirectChild;
        if (view2 == null || view2 == this) {
            if (view == this.toolbar) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private void updateCollapsedBounds(boolean z11) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        View view = this.toolbarDirectChild;
        if (view == null) {
            view = this.toolbar;
        }
        int maxOffsetForPinChild = getMaxOffsetForPinChild(view);
        DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
        ViewGroup viewGroup = this.toolbar;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar2 = (Toolbar) viewGroup;
            i13 = toolbar2.getTitleMarginStart();
            i12 = toolbar2.getTitleMarginEnd();
            i11 = toolbar2.getTitleMarginTop();
            i14 = toolbar2.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            i13 = 0;
            i14 = 0;
            i12 = 0;
            i11 = 0;
        } else {
            android.widget.Toolbar toolbar3 = (android.widget.Toolbar) viewGroup;
            i13 = toolbar3.getTitleMarginStart();
            i12 = toolbar3.getTitleMarginEnd();
            i11 = toolbar3.getTitleMarginTop();
            i14 = toolbar3.getTitleMarginBottom();
        }
        CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
        Rect rect = this.tmpRect;
        int i16 = rect.left;
        if (z11) {
            i15 = i12;
        } else {
            i15 = i13;
        }
        int i17 = i16 + i15;
        int i18 = rect.top + maxOffsetForPinChild + i11;
        int i19 = rect.right;
        if (!z11) {
            i13 = i12;
        }
        collapsingTextHelper2.setCollapsedBounds(i17, i18, i19 - i13, (rect.bottom + maxOffsetForPinChild) - i14);
    }

    private void updateContentDescriptionFromTitle() {
        setContentDescription(getTitle());
    }

    private void updateContentScrimBounds(@NonNull Drawable drawable, int i11, int i12) {
        updateContentScrimBounds(drawable, this.toolbar, i11, i12);
    }

    private void updateDummyView() {
        View view;
        if (!this.collapsingTitleEnabled && (view = this.dummyView) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.dummyView);
            }
        }
        if (this.collapsingTitleEnabled && this.toolbar != null) {
            if (this.dummyView == null) {
                this.dummyView = new View(getContext());
            }
            if (this.dummyView.getParent() == null) {
                this.toolbar.addView(this.dummyView, -1, -1);
            }
        }
    }

    private void updateTextBounds(int i11, int i12, int i13, int i14, boolean z11) {
        View view;
        boolean z12;
        int i15;
        int i16;
        if (this.collapsingTitleEnabled && (view = this.dummyView) != null) {
            boolean z13 = false;
            if (!ViewCompat.isAttachedToWindow(view) || this.dummyView.getVisibility() != 0) {
                z12 = false;
            } else {
                z12 = true;
            }
            this.drawCollapsingTitle = z12;
            if (z12 || z11) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    z13 = true;
                }
                updateCollapsedBounds(z13);
                CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
                if (z13) {
                    i15 = this.expandedMarginEnd;
                } else {
                    i15 = this.expandedMarginStart;
                }
                int i17 = this.tmpRect.top + this.expandedMarginTop;
                int i18 = i13 - i11;
                if (z13) {
                    i16 = this.expandedMarginStart;
                } else {
                    i16 = this.expandedMarginEnd;
                }
                collapsingTextHelper2.setExpandedBounds(i15, i17, i18 - i16, (i14 - i12) - this.expandedMarginBottom);
                this.collapsingTextHelper.recalculate(z11);
            }
        }
    }

    private void updateTitleFromToolbarIfNeeded() {
        if (this.toolbar != null && this.collapsingTitleEnabled && TextUtils.isEmpty(this.collapsingTextHelper.getText())) {
            setTitle(getToolbarTitle(this.toolbar));
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void draw(@NonNull Canvas canvas) {
        int i11;
        Drawable drawable;
        super.draw(canvas);
        ensureToolbar();
        if (this.toolbar == null && (drawable = this.contentScrim) != null && this.scrimAlpha > 0) {
            drawable.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
        }
        if (this.collapsingTitleEnabled && this.drawCollapsingTitle) {
            if (this.toolbar == null || this.contentScrim == null || this.scrimAlpha <= 0 || !isTitleCollapseFadeMode() || this.collapsingTextHelper.getExpansionFraction() >= this.collapsingTextHelper.getFadeModeThresholdFraction()) {
                this.collapsingTextHelper.draw(canvas);
            } else {
                int save = canvas.save();
                canvas.clipRect(this.contentScrim.getBounds(), Region.Op.DIFFERENCE);
                this.collapsingTextHelper.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.statusBarScrim != null && this.scrimAlpha > 0) {
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            if (windowInsetsCompat != null) {
                i11 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i11 = 0;
            }
            if (i11 > 0) {
                this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), i11 - this.currentOffset);
                this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
                this.statusBarScrim.draw(canvas);
            }
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j11) {
        boolean z11;
        if (this.contentScrim == null || this.scrimAlpha <= 0 || !isToolbarChild(view)) {
            z11 = false;
        } else {
            updateContentScrimBounds(this.contentScrim, view, getWidth(), getHeight());
            this.contentScrim.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
            z11 = true;
        }
        if (super.drawChild(canvas, view, j11) || z11) {
            return true;
        }
        return false;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarScrim;
        boolean z11 = false;
        if (drawable != null && drawable.isStateful()) {
            z11 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != null && drawable2.isStateful()) {
            z11 |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
        if (collapsingTextHelper2 != null) {
            z11 |= collapsingTextHelper2.setState(drawableState);
        }
        if (z11) {
            invalidate();
        }
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTextHelper.getCollapsedTextGravity();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTextHelper.getCollapsedTypeface();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTextHelper.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.collapsingTextHelper.getExpandedTypeface();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.collapsingTextHelper.getHyphenationFrequency();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.collapsingTextHelper.getLineCount();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.collapsingTextHelper.getLineSpacingAdd();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.collapsingTextHelper.getLineSpacingMultiplier();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.collapsingTextHelper.getMaxLines();
    }

    public final int getMaxOffsetForPinChild(@NonNull View view) {
        return ((getHeight() - getViewOffsetHelper(view).getLayoutTop()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int i11;
        int i12 = this.scrimVisibleHeightTrigger;
        if (i12 >= 0) {
            return i12 + this.topInsetApplied + this.extraMultilineHeight;
        }
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            i11 = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            i11 = 0;
        }
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + i11, getHeight());
        }
        return getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.collapsingTitleEnabled) {
            return this.collapsingTextHelper.getText();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.titleCollapseMode;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.collapsingTextHelper.getPositionInterpolator();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isExtraMultilineHeightEnabled() {
        return this.extraMultilineHeightEnabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isForceApplySystemWindowInsetTop() {
        return this.forceApplySystemWindowInsetTop;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.collapsingTextHelper.isRtlTextDirectionHeuristicsEnabled();
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            disableLiftOnScrollIfNeeded(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.onOffsetChangedListener == null) {
                this.onOffsetChangedListener = new OffsetUpdateListener();
            }
            appBarLayout.addOnOffsetChangedListener(this.onOffsetChangedListener);
            ViewCompat.requestApplyInsets(this);
        }
    }

    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener2 = this.onOffsetChangedListener;
        if (onOffsetChangedListener2 != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener2);
        }
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt = getChildAt(i15);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            getViewOffsetHelper(getChildAt(i16)).onViewLayout();
        }
        updateTextBounds(i11, i12, i13, i14, false);
        updateTitleFromToolbarIfNeeded();
        updateScrimVisibility();
        int childCount3 = getChildCount();
        for (int i17 = 0; i17 < childCount3; i17++) {
            getViewOffsetHelper(getChildAt(i17)).applyOffsets();
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        ensureToolbar();
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i12);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            i13 = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            i13 = 0;
        }
        if ((mode == 0 || this.forceApplySystemWindowInsetTop) && i13 > 0) {
            this.topInsetApplied = i13;
            super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + i13, 1073741824));
        }
        if (this.extraMultilineHeightEnabled && this.collapsingTextHelper.getMaxLines() > 1) {
            updateTitleFromToolbarIfNeeded();
            updateTextBounds(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int expandedLineCount = this.collapsingTextHelper.getExpandedLineCount();
            if (expandedLineCount > 1) {
                this.extraMultilineHeight = Math.round(this.collapsingTextHelper.getExpandedTextFullHeight()) * (expandedLineCount - 1);
                super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.extraMultilineHeight, 1073741824));
            }
        }
        ViewGroup viewGroup = this.toolbar;
        if (viewGroup != null) {
            View view = this.toolbarDirectChild;
            if (view == null || view == this) {
                setMinimumHeight(getHeightWithMargins(viewGroup));
            } else {
                setMinimumHeight(getHeightWithMargins(view));
            }
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        Drawable drawable = this.contentScrim;
        if (drawable != null) {
            updateContentScrimBounds(drawable, i11, i12);
        }
    }

    public WindowInsetsCompat onWindowInsetChanged(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.getFitsSystemWindows(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.equals(this.lastInsets, windowInsetsCompat2)) {
            this.lastInsets = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void setCollapsedTitleGravity(int i11) {
        this.collapsingTextHelper.setCollapsedTextGravity(i11);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i11) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i11);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i11) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.collapsingTextHelper.setCollapsedTypeface(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.contentScrim = drawable3;
            if (drawable3 != null) {
                updateContentScrimBounds(drawable3, getWidth(), getHeight());
                this.contentScrim.setCallback(this);
                this.contentScrim.setAlpha(this.scrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i11) {
        setContentScrim(new ColorDrawable(i11));
    }

    public void setContentScrimResource(@DrawableRes int i11) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i11));
    }

    public void setExpandedTitleColor(@ColorInt int i11) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setExpandedTitleGravity(int i11) {
        this.collapsingTextHelper.setExpandedTextGravity(i11);
    }

    public void setExpandedTitleMargin(int i11, int i12, int i13, int i14) {
        this.expandedMarginStart = i11;
        this.expandedMarginTop = i12;
        this.expandedMarginEnd = i13;
        this.expandedMarginBottom = i14;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i11) {
        this.expandedMarginBottom = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i11) {
        this.expandedMarginEnd = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i11) {
        this.expandedMarginStart = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i11) {
        this.expandedMarginTop = i11;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i11) {
        this.collapsingTextHelper.setExpandedTextAppearance(i11);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.collapsingTextHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.collapsingTextHelper.setExpandedTypeface(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z11) {
        this.extraMultilineHeightEnabled = z11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z11) {
        this.forceApplySystemWindowInsetTop = z11;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i11) {
        this.collapsingTextHelper.setHyphenationFrequency(i11);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f11) {
        this.collapsingTextHelper.setLineSpacingAdd(f11);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f11) {
        this.collapsingTextHelper.setLineSpacingMultiplier(f11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i11) {
        this.collapsingTextHelper.setMaxLines(i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z11) {
        this.collapsingTextHelper.setRtlTextDirectionHeuristicsEnabled(z11);
    }

    public void setScrimAlpha(int i11) {
        ViewGroup viewGroup;
        if (i11 != this.scrimAlpha) {
            if (!(this.contentScrim == null || (viewGroup = this.toolbar) == null)) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.scrimAlpha = i11;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j11) {
        this.scrimAnimationDuration = j11;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i11) {
        if (this.scrimVisibleHeightTrigger != i11) {
            this.scrimVisibleHeightTrigger = i11;
            updateScrimVisibility();
        }
    }

    public void setScrimsShown(boolean z11) {
        setScrimsShown(z11, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        boolean z11;
        Drawable drawable2 = this.statusBarScrim;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.statusBarScrim = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.statusBarScrim.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.statusBarScrim, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.statusBarScrim;
                if (getVisibility() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                drawable4.setVisible(z11, false);
                this.statusBarScrim.setCallback(this);
                this.statusBarScrim.setAlpha(this.scrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i11) {
        setStatusBarScrim(new ColorDrawable(i11));
    }

    public void setStatusBarScrimResource(@DrawableRes int i11) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i11));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.collapsingTextHelper.setText(charSequence);
        updateContentDescriptionFromTitle();
    }

    public void setTitleCollapseMode(int i11) {
        this.titleCollapseMode = i11;
        boolean isTitleCollapseFadeMode = isTitleCollapseFadeMode();
        this.collapsingTextHelper.setFadeModeEnabled(isTitleCollapseFadeMode);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            disableLiftOnScrollIfNeeded((AppBarLayout) parent);
        }
        if (isTitleCollapseFadeMode && this.contentScrim == null) {
            setContentScrimColor(this.elevationOverlayProvider.compositeOverlayWithThemeSurfaceColorIfNeeded(getResources().getDimension(R.dimen.design_appbar_elevation)));
        }
    }

    public void setTitleEnabled(boolean z11) {
        if (z11 != this.collapsingTitleEnabled) {
            this.collapsingTitleEnabled = z11;
            updateContentDescriptionFromTitle();
            updateDummyView();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.collapsingTextHelper.setPositionInterpolator(timeInterpolator);
    }

    public void setVisibility(int i11) {
        boolean z11;
        super.setVisibility(i11);
        if (i11 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Drawable drawable = this.statusBarScrim;
        if (!(drawable == null || drawable.isVisible() == z11)) {
            this.statusBarScrim.setVisible(z11, false);
        }
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != null && drawable2.isVisible() != z11) {
            this.contentScrim.setVisible(z11, false);
        }
    }

    public final void updateScrimVisibility() {
        boolean z11;
        if (this.contentScrim != null || this.statusBarScrim != null) {
            if (getHeight() + this.currentOffset < getScrimVisibleHeightTrigger()) {
                z11 = true;
            } else {
                z11 = false;
            }
            setScrimsShown(z11);
        }
    }

    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.contentScrim || drawable == this.statusBarScrim;
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    private void updateContentScrimBounds(@NonNull Drawable drawable, @Nullable View view, int i11, int i12) {
        if (isTitleCollapseFadeMode() && view != null && this.collapsingTitleEnabled) {
            i12 = view.getBottom();
        }
        drawable.setBounds(0, 0, i11, i12);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
    }

    public void setScrimsShown(boolean z11, boolean z12) {
        if (this.scrimsAreShown != z11) {
            int i11 = 255;
            if (z12) {
                if (!z11) {
                    i11 = 0;
                }
                animateScrim(i11);
            } else {
                if (!z11) {
                    i11 = 0;
                }
                setScrimAlpha(i11);
            }
            this.scrimsAreShown = z11;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r11 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r11, r12, r13, r4)
            r10.<init>(r11, r12, r13)
            r11 = 1
            r10.refreshToolbar = r11
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.tmpRect = r0
            r6 = -1
            r10.scrimVisibleHeightTrigger = r6
            r7 = 0
            r10.topInsetApplied = r7
            r10.extraMultilineHeight = r7
            android.content.Context r8 = r10.getContext()
            com.google.android.material.internal.CollapsingTextHelper r9 = new com.google.android.material.internal.CollapsingTextHelper
            r9.<init>(r10)
            r10.collapsingTextHelper = r9
            android.animation.TimeInterpolator r0 = com.google.android.material.animation.AnimationUtils.DECELERATE_INTERPOLATOR
            r9.setTextSizeInterpolator(r0)
            r9.setRtlTextDirectionHeuristicsEnabled(r7)
            com.google.android.material.elevation.ElevationOverlayProvider r0 = new com.google.android.material.elevation.ElevationOverlayProvider
            r0.<init>(r8)
            r10.elevationOverlayProvider = r0
            int[] r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout
            int[] r5 = new int[r7]
            r0 = r8
            r1 = r12
            r3 = r13
            android.content.res.TypedArray r12 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleGravity
            r0 = 8388691(0x800053, float:1.175506E-38)
            int r13 = r12.getInt(r13, r0)
            r9.setExpandedTextGravity(r13)
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedTitleGravity
            r0 = 8388627(0x800013, float:1.175497E-38)
            int r13 = r12.getInt(r13, r0)
            r9.setCollapsedTextGravity(r13)
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMargin
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.expandedMarginBottom = r13
            r10.expandedMarginEnd = r13
            r10.expandedMarginTop = r13
            r10.expandedMarginStart = r13
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0074
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.expandedMarginStart = r13
        L_0x0074:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0082
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.expandedMarginEnd = r13
        L_0x0082:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0090
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.expandedMarginTop = r13
        L_0x0090:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x009e
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.expandedMarginBottom = r13
        L_0x009e:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_titleEnabled
            boolean r13 = r12.getBoolean(r13, r11)
            r10.collapsingTitleEnabled = r13
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_title
            java.lang.CharSequence r13 = r12.getText(r13)
            r10.setTitle(r13)
            int r13 = com.google.android.material.R.style.TextAppearance_Design_CollapsingToolbar_Expanded
            r9.setExpandedTextAppearance(r13)
            int r13 = androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title
            r9.setCollapsedTextAppearance(r13)
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00c8
            int r13 = r12.getResourceId(r13, r7)
            r9.setExpandedTextAppearance(r13)
        L_0x00c8:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00d7
            int r13 = r12.getResourceId(r13, r7)
            r9.setCollapsedTextAppearance(r13)
        L_0x00d7:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleTextColor
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00e6
            android.content.res.ColorStateList r13 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r8, (android.content.res.TypedArray) r12, (int) r13)
            r9.setExpandedTextColor(r13)
        L_0x00e6:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00f5
            android.content.res.ColorStateList r13 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r8, (android.content.res.TypedArray) r12, (int) r13)
            r9.setCollapsedTextColor(r13)
        L_0x00f5:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger
            int r13 = r12.getDimensionPixelSize(r13, r6)
            r10.scrimVisibleHeightTrigger = r13
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_maxLines
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x010c
            int r11 = r12.getInt(r13, r11)
            r9.setMaxLines(r11)
        L_0x010c:
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_titlePositionInterpolator
            boolean r13 = r12.hasValue(r11)
            if (r13 == 0) goto L_0x011f
            int r11 = r12.getResourceId(r11, r7)
            android.view.animation.Interpolator r11 = android.view.animation.AnimationUtils.loadInterpolator(r8, r11)
            r9.setPositionInterpolator(r11)
        L_0x011f:
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_scrimAnimationDuration
            r13 = 600(0x258, float:8.41E-43)
            int r11 = r12.getInt(r11, r13)
            long r0 = (long) r11
            r10.scrimAnimationDuration = r0
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_contentScrim
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r11)
            r10.setContentScrim(r11)
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_statusBarScrim
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r11)
            r10.setStatusBarScrim(r11)
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_titleCollapseMode
            int r11 = r12.getInt(r11, r7)
            r10.setTitleCollapseMode(r11)
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_toolbarId
            int r11 = r12.getResourceId(r11, r6)
            r10.toolbarId = r11
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop
            boolean r11 = r12.getBoolean(r11, r7)
            r10.forceApplySystemWindowInsetTop = r11
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled
            boolean r11 = r12.getBoolean(r11, r7)
            r10.extraMultilineHeightEnabled = r11
            r12.recycle()
            r10.setWillNotDraw(r7)
            com.google.android.material.appbar.CollapsingToolbarLayout$1 r11 = new com.google.android.material.appbar.CollapsingToolbarLayout$1
            r11.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode = 0;
        float parallaxMult = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }

        public void setCollapseMode(int i11) {
            this.collapseMode = i11;
        }

        public void setParallaxMultiplier(float f11) {
            this.parallaxMult = f11;
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(int i11, int i12, int i13) {
            super(i11, i12, i13);
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
