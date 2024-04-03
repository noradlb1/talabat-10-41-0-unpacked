package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int DEF_STYLE_RES = R.style.Widget_Design_NavigationView;
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private boolean bottomInsetScrimEnabled;
    @Px
    private int drawerLayoutCornerSize;
    private int layoutGravity;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    @NonNull
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    /* access modifiers changed from: private */
    public final NavigationMenuPresenter presenter;
    private final RectF shapeClipBounds;
    @Nullable
    private Path shapeClipPath;
    /* access modifiers changed from: private */
    public final int[] tmpLocation;
    private boolean topInsetScrimEnabled;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    public NavigationView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @Nullable
    private ColorStateList createDefaultColorStateList(int i11) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i11, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i12 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i12, defaultColor});
    }

    @NonNull
    private final Drawable createDefaultItemBackground(@NonNull TintTypedArray tintTypedArray) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        materialShapeDrawable.setFillColor(MaterialResources.getColorStateList(getContext(), tintTypedArray, R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable(materialShapeDrawable, tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    private boolean hasShapeAppearance(@NonNull TintTypedArray tintTypedArray) {
        if (tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearance) || tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearanceOverlay)) {
            return true;
        }
        return false;
    }

    private void maybeUpdateCornerSizeForDrawerLayout(@Px int i11, @Px int i12) {
        if (!(getParent() instanceof DrawerLayout) || this.drawerLayoutCornerSize <= 0 || !(getBackground() instanceof MaterialShapeDrawable)) {
            this.shapeClipPath = null;
            this.shapeClipBounds.setEmpty();
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        if (GravityCompat.getAbsoluteGravity(this.layoutGravity, ViewCompat.getLayoutDirection(this)) == 3) {
            builder.setTopRightCornerSize((float) this.drawerLayoutCornerSize);
            builder.setBottomRightCornerSize((float) this.drawerLayoutCornerSize);
        } else {
            builder.setTopLeftCornerSize((float) this.drawerLayoutCornerSize);
            builder.setBottomLeftCornerSize((float) this.drawerLayoutCornerSize);
        }
        materialShapeDrawable.setShapeAppearanceModel(builder.build());
        if (this.shapeClipPath == null) {
            this.shapeClipPath = new Path();
        }
        this.shapeClipPath.reset();
        this.shapeClipBounds.set(0.0f, 0.0f, (float) i11, (float) i12);
        ShapeAppearancePathProvider.getInstance().calculatePath(materialShapeDrawable.getShapeAppearanceModel(), materialShapeDrawable.getInterpolation(), this.shapeClipBounds, this.shapeClipPath);
        invalidate();
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                boolean z11;
                boolean z12;
                boolean z13;
                boolean z14;
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.tmpLocation);
                boolean z15 = true;
                if (NavigationView.this.tmpLocation[1] == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                NavigationView.this.presenter.setBehindStatusBar(z11);
                NavigationView navigationView2 = NavigationView.this;
                if (!z11 || !navigationView2.isTopInsetScrimEnabled()) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                navigationView2.setDrawTopInsetForeground(z12);
                Activity activity = ContextUtils.getActivity(NavigationView.this.getContext());
                if (activity != null) {
                    if (activity.findViewById(16908290).getHeight() == NavigationView.this.getHeight()) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    NavigationView navigationView3 = NavigationView.this;
                    if (!z13 || !z14 || !navigationView3.isBottomInsetScrimEnabled()) {
                        z15 = false;
                    }
                    navigationView3.setDrawBottomInsetForeground(z15);
                }
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void addHeaderView(@NonNull View view) {
        this.presenter.addHeaderView(view);
    }

    public void dispatchDraw(@NonNull Canvas canvas) {
        if (this.shapeClipPath == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.shapeClipPath);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.presenter.getDividerInsetEnd();
    }

    @Px
    public int getDividerInsetStart() {
        return this.presenter.getDividerInsetStart();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int i11) {
        return this.presenter.getHeaderView(i11);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    @Px
    public int getItemVerticalPadding() {
        return this.presenter.getItemVerticalPadding();
    }

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.presenter.getSubheaderInsetEnd();
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.presenter.getSubheaderInsetStart();
    }

    public View inflateHeaderView(@LayoutRes int i11) {
        return this.presenter.inflateHeaderView(i11);
    }

    public void inflateMenu(int i11) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i11, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.bottomInsetScrimEnabled;
    }

    public boolean isTopInsetScrimEnabled() {
        return this.topInsetScrimEnabled;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onInsetsChanged(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.presenter.dispatchApplyWindowInsets(windowInsetsCompat);
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i11), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        }
        super.onMeasure(i11, i12);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuState);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        maybeUpdateCornerSizeForDrawerLayout(i11, i12);
    }

    public void removeHeaderView(@NonNull View view) {
        this.presenter.removeHeaderView(view);
    }

    public void setBottomInsetScrimEnabled(boolean z11) {
        this.bottomInsetScrimEnabled = z11;
    }

    public void setCheckedItem(@IdRes int i11) {
        MenuItem findItem = this.menu.findItem(i11);
        if (findItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) findItem);
        }
    }

    public void setDividerInsetEnd(@Px int i11) {
        this.presenter.setDividerInsetEnd(i11);
    }

    public void setDividerInsetStart(@Px int i11) {
        this.presenter.setDividerInsetStart(i11);
    }

    public void setElevation(float f11) {
        super.setElevation(f11);
        MaterialShapeUtils.setElevation(this, f11);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i11) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i11));
    }

    public void setItemHorizontalPadding(@Dimension int i11) {
        this.presenter.setItemHorizontalPadding(i11);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i11) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i11));
    }

    public void setItemIconPadding(@Dimension int i11) {
        this.presenter.setItemIconPadding(i11);
    }

    public void setItemIconPaddingResource(int i11) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i11));
    }

    public void setItemIconSize(@Dimension int i11) {
        this.presenter.setItemIconSize(i11);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public void setItemMaxLines(int i11) {
        this.presenter.setItemMaxLines(i11);
    }

    public void setItemTextAppearance(@StyleRes int i11) {
        this.presenter.setItemTextAppearance(i11);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public void setItemVerticalPadding(@Px int i11) {
        this.presenter.setItemVerticalPadding(i11);
    }

    public void setItemVerticalPaddingResource(@DimenRes int i11) {
        this.presenter.setItemVerticalPadding(getResources().getDimensionPixelSize(i11));
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    public void setOverScrollMode(int i11) {
        super.setOverScrollMode(i11);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i11);
        }
    }

    public void setSubheaderInsetEnd(@Px int i11) {
        this.presenter.setSubheaderInsetStart(i11);
    }

    public void setSubheaderInsetStart(@Px int i11) {
        this.presenter.setSubheaderInsetStart(i11);
    }

    public void setTopInsetScrimEnabled(boolean z11) {
        this.topInsetScrimEnabled = z11;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @NonNull
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }

            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Nullable
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        @Nullable
        public Bundle menuState;

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeBundle(this.menuState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavigationView(@androidx.annotation.NonNull android.content.Context r12, @androidx.annotation.Nullable android.util.AttributeSet r13, int r14) {
        /*
            r11 = this;
            int r6 = DEF_STYLE_RES
            android.content.Context r12 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r12, r13, r14, r6)
            r11.<init>(r12, r13, r14)
            com.google.android.material.internal.NavigationMenuPresenter r12 = new com.google.android.material.internal.NavigationMenuPresenter
            r12.<init>()
            r11.presenter = r12
            r0 = 2
            int[] r0 = new int[r0]
            r11.tmpLocation = r0
            r7 = 1
            r11.topInsetScrimEnabled = r7
            r11.bottomInsetScrimEnabled = r7
            r8 = 0
            r11.layoutGravity = r8
            r11.drawerLayoutCornerSize = r8
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r11.shapeClipBounds = r0
            android.content.Context r9 = r11.getContext()
            com.google.android.material.internal.NavigationMenu r10 = new com.google.android.material.internal.NavigationMenu
            r10.<init>(r9)
            r11.menu = r10
            int[] r2 = com.google.android.material.R.styleable.NavigationView
            int[] r5 = new int[r8]
            r0 = r9
            r1 = r13
            r3 = r14
            r4 = r6
            androidx.appcompat.widget.TintTypedArray r0 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.NavigationView_android_background
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x004c
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)
            androidx.core.view.ViewCompat.setBackground(r11, r1)
        L_0x004c:
            int r1 = com.google.android.material.R.styleable.NavigationView_drawerLayoutCornerSize
            int r1 = r0.getDimensionPixelSize(r1, r8)
            r11.drawerLayoutCornerSize = r1
            int r1 = com.google.android.material.R.styleable.NavigationView_android_layout_gravity
            int r1 = r0.getInt(r1, r8)
            r11.layoutGravity = r1
            android.graphics.drawable.Drawable r1 = r11.getBackground()
            if (r1 == 0) goto L_0x006a
            android.graphics.drawable.Drawable r1 = r11.getBackground()
            boolean r1 = r1 instanceof android.graphics.drawable.ColorDrawable
            if (r1 == 0) goto L_0x0092
        L_0x006a:
            com.google.android.material.shape.ShapeAppearanceModel$Builder r13 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r9, (android.util.AttributeSet) r13, (int) r14, (int) r6)
            com.google.android.material.shape.ShapeAppearanceModel r13 = r13.build()
            android.graphics.drawable.Drawable r14 = r11.getBackground()
            com.google.android.material.shape.MaterialShapeDrawable r1 = new com.google.android.material.shape.MaterialShapeDrawable
            r1.<init>((com.google.android.material.shape.ShapeAppearanceModel) r13)
            boolean r13 = r14 instanceof android.graphics.drawable.ColorDrawable
            if (r13 == 0) goto L_0x008c
            android.graphics.drawable.ColorDrawable r14 = (android.graphics.drawable.ColorDrawable) r14
            int r13 = r14.getColor()
            android.content.res.ColorStateList r13 = android.content.res.ColorStateList.valueOf(r13)
            r1.setFillColor(r13)
        L_0x008c:
            r1.initializeElevationOverlay(r9)
            androidx.core.view.ViewCompat.setBackground(r11, r1)
        L_0x0092:
            int r13 = com.google.android.material.R.styleable.NavigationView_elevation
            boolean r14 = r0.hasValue(r13)
            if (r14 == 0) goto L_0x00a2
            int r13 = r0.getDimensionPixelSize(r13, r8)
            float r13 = (float) r13
            r11.setElevation(r13)
        L_0x00a2:
            int r13 = com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows
            boolean r13 = r0.getBoolean(r13, r8)
            r11.setFitsSystemWindows(r13)
            int r13 = com.google.android.material.R.styleable.NavigationView_android_maxWidth
            int r13 = r0.getDimensionPixelSize(r13, r8)
            r11.maxWidth = r13
            int r13 = com.google.android.material.R.styleable.NavigationView_subheaderColor
            boolean r14 = r0.hasValue(r13)
            r1 = 0
            if (r14 == 0) goto L_0x00c1
            android.content.res.ColorStateList r13 = r0.getColorStateList(r13)
            goto L_0x00c2
        L_0x00c1:
            r13 = r1
        L_0x00c2:
            int r14 = com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance
            boolean r2 = r0.hasValue(r14)
            if (r2 == 0) goto L_0x00cf
            int r14 = r0.getResourceId(r14, r8)
            goto L_0x00d0
        L_0x00cf:
            r14 = r8
        L_0x00d0:
            r2 = 16842808(0x1010038, float:2.3693715E-38)
            if (r14 != 0) goto L_0x00db
            if (r13 != 0) goto L_0x00db
            android.content.res.ColorStateList r13 = r11.createDefaultColorStateList(r2)
        L_0x00db:
            int r3 = com.google.android.material.R.styleable.NavigationView_itemIconTint
            boolean r4 = r0.hasValue(r3)
            if (r4 == 0) goto L_0x00e8
            android.content.res.ColorStateList r2 = r0.getColorStateList(r3)
            goto L_0x00ec
        L_0x00e8:
            android.content.res.ColorStateList r2 = r11.createDefaultColorStateList(r2)
        L_0x00ec:
            int r3 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance
            boolean r4 = r0.hasValue(r3)
            if (r4 == 0) goto L_0x00f9
            int r3 = r0.getResourceId(r3, r8)
            goto L_0x00fa
        L_0x00f9:
            r3 = r8
        L_0x00fa:
            int r4 = com.google.android.material.R.styleable.NavigationView_itemIconSize
            boolean r5 = r0.hasValue(r4)
            if (r5 == 0) goto L_0x0109
            int r4 = r0.getDimensionPixelSize(r4, r8)
            r11.setItemIconSize(r4)
        L_0x0109:
            int r4 = com.google.android.material.R.styleable.NavigationView_itemTextColor
            boolean r5 = r0.hasValue(r4)
            if (r5 == 0) goto L_0x0115
            android.content.res.ColorStateList r1 = r0.getColorStateList(r4)
        L_0x0115:
            if (r3 != 0) goto L_0x0120
            if (r1 != 0) goto L_0x0120
            r1 = 16842806(0x1010036, float:2.369371E-38)
            android.content.res.ColorStateList r1 = r11.createDefaultColorStateList(r1)
        L_0x0120:
            int r4 = com.google.android.material.R.styleable.NavigationView_itemBackground
            android.graphics.drawable.Drawable r4 = r0.getDrawable(r4)
            if (r4 != 0) goto L_0x0132
            boolean r5 = r11.hasShapeAppearance(r0)
            if (r5 == 0) goto L_0x0132
            android.graphics.drawable.Drawable r4 = r11.createDefaultItemBackground(r0)
        L_0x0132:
            int r5 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding
            boolean r6 = r0.hasValue(r5)
            if (r6 == 0) goto L_0x0141
            int r5 = r0.getDimensionPixelSize(r5, r8)
            r11.setItemHorizontalPadding(r5)
        L_0x0141:
            int r5 = com.google.android.material.R.styleable.NavigationView_itemVerticalPadding
            boolean r6 = r0.hasValue(r5)
            if (r6 == 0) goto L_0x0150
            int r5 = r0.getDimensionPixelSize(r5, r8)
            r11.setItemVerticalPadding(r5)
        L_0x0150:
            int r5 = com.google.android.material.R.styleable.NavigationView_dividerInsetStart
            int r5 = r0.getDimensionPixelSize(r5, r8)
            r11.setDividerInsetStart(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_dividerInsetEnd
            int r5 = r0.getDimensionPixelSize(r5, r8)
            r11.setDividerInsetEnd(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_subheaderInsetStart
            int r5 = r0.getDimensionPixelSize(r5, r8)
            r11.setSubheaderInsetStart(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_subheaderInsetEnd
            int r5 = r0.getDimensionPixelSize(r5, r8)
            r11.setSubheaderInsetEnd(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_topInsetScrimEnabled
            boolean r6 = r11.topInsetScrimEnabled
            boolean r5 = r0.getBoolean(r5, r6)
            r11.setTopInsetScrimEnabled(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_bottomInsetScrimEnabled
            boolean r6 = r11.bottomInsetScrimEnabled
            boolean r5 = r0.getBoolean(r5, r6)
            r11.setBottomInsetScrimEnabled(r5)
            int r5 = com.google.android.material.R.styleable.NavigationView_itemIconPadding
            int r5 = r0.getDimensionPixelSize(r5, r8)
            int r6 = com.google.android.material.R.styleable.NavigationView_itemMaxLines
            int r6 = r0.getInt(r6, r7)
            r11.setItemMaxLines(r6)
            com.google.android.material.navigation.NavigationView$1 r6 = new com.google.android.material.navigation.NavigationView$1
            r6.<init>()
            r10.setCallback(r6)
            r12.setId(r7)
            r12.initForMenu(r9, r10)
            if (r14 == 0) goto L_0x01ac
            r12.setSubheaderTextAppearance(r14)
        L_0x01ac:
            r12.setSubheaderColor(r13)
            r12.setItemIconTintList(r2)
            int r13 = r11.getOverScrollMode()
            r12.setOverScrollMode(r13)
            if (r3 == 0) goto L_0x01be
            r12.setItemTextAppearance(r3)
        L_0x01be:
            r12.setItemTextColor(r1)
            r12.setItemBackground(r4)
            r12.setItemIconPadding(r5)
            r10.addMenuPresenter(r12)
            androidx.appcompat.view.menu.MenuView r12 = r12.getMenuView(r11)
            android.view.View r12 = (android.view.View) r12
            r11.addView(r12)
            int r12 = com.google.android.material.R.styleable.NavigationView_menu
            boolean r13 = r0.hasValue(r12)
            if (r13 == 0) goto L_0x01e2
            int r12 = r0.getResourceId(r12, r8)
            r11.inflateMenu(r12)
        L_0x01e2:
            int r12 = com.google.android.material.R.styleable.NavigationView_headerLayout
            boolean r13 = r0.hasValue(r12)
            if (r13 == 0) goto L_0x01f1
            int r12 = r0.getResourceId(r12, r8)
            r11.inflateHeaderView(r12)
        L_0x01f1:
            r0.recycle()
            r11.setupInsetScrimsListener()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.menu.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
