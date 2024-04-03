package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.google.android.material.badge.BadgeDrawable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ToolbarWidgetWrapper implements DecorToolbar {
    private static final int AFFECTS_LOGO_MASK = 3;
    private static final long DEFAULT_FADE_DURATION_MS = 200;
    private static final String TAG = "ToolbarWidgetWrapper";

    /* renamed from: a  reason: collision with root package name */
    public Toolbar f911a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f912b;

    /* renamed from: c  reason: collision with root package name */
    public Window.Callback f913c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f914d;
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private int mDefaultNavigationContentDescription;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    private Drawable mNavIcon;
    private int mNavigationMode;
    private Spinner mSpinner;
    private CharSequence mSubtitle;
    private View mTabView;
    private boolean mTitleSet;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z11) {
        this(toolbar, z11, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    private int detectDisplayOptions() {
        if (this.f911a.getNavigationIcon() == null) {
            return 11;
        }
        this.mDefaultNavigationIcon = this.f911a.getNavigationIcon();
        return 15;
    }

    private void ensureSpinner() {
        if (this.mSpinner == null) {
            this.mSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R.attr.actionDropDownStyle);
            this.mSpinner.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    private void setTitleInt(CharSequence charSequence) {
        this.f912b = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.f911a.setTitle(charSequence);
            if (this.mTitleSet) {
                ViewCompat.setAccessibilityPaneTitle(this.f911a.getRootView(), charSequence);
            }
        }
    }

    private void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.mHomeDescription)) {
            this.f911a.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        } else {
            this.f911a.setNavigationContentDescription(this.mHomeDescription);
        }
    }

    private void updateNavigationIcon() {
        if ((this.mDisplayOpts & 4) != 0) {
            Toolbar toolbar = this.f911a;
            Drawable drawable = this.mNavIcon;
            if (drawable == null) {
                drawable = this.mDefaultNavigationIcon;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f911a.setNavigationIcon((Drawable) null);
    }

    private void updateToolbarLogo() {
        Drawable drawable;
        int i11 = this.mDisplayOpts;
        if ((i11 & 2) == 0) {
            drawable = null;
        } else if ((i11 & 1) != 0) {
            drawable = this.mLogo;
            if (drawable == null) {
                drawable = this.mIcon;
            }
        } else {
            drawable = this.mIcon;
        }
        this.f911a.setLogo(drawable);
    }

    public void animateToVisibility(int i11) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i11, 200);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    public boolean canShowOverflowMenu() {
        return this.f911a.canShowOverflowMenu();
    }

    public void collapseActionView() {
        this.f911a.collapseActionView();
    }

    public void dismissPopupMenus() {
        this.f911a.dismissPopupMenus();
    }

    public Context getContext() {
        return this.f911a.getContext();
    }

    public View getCustomView() {
        return this.mCustomView;
    }

    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    public int getDropdownItemCount() {
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            return spinner.getCount();
        }
        return 0;
    }

    public int getDropdownSelectedPosition() {
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    public int getHeight() {
        return this.f911a.getHeight();
    }

    public Menu getMenu() {
        return this.f911a.getMenu();
    }

    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    public CharSequence getSubtitle() {
        return this.f911a.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.f911a.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.f911a;
    }

    public int getVisibility() {
        return this.f911a.getVisibility();
    }

    public boolean hasEmbeddedTabs() {
        return this.mTabView != null;
    }

    public boolean hasExpandedActionView() {
        return this.f911a.hasExpandedActionView();
    }

    public boolean hasIcon() {
        return this.mIcon != null;
    }

    public boolean hasLogo() {
        return this.mLogo != null;
    }

    public boolean hideOverflowMenu() {
        return this.f911a.hideOverflowMenu();
    }

    public void initIndeterminateProgress() {
        Log.i(TAG, "Progress display unsupported");
    }

    public void initProgress() {
        Log.i(TAG, "Progress display unsupported");
    }

    public boolean isOverflowMenuShowPending() {
        return this.f911a.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.f911a.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        return this.f911a.isTitleTruncated();
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f911a.restoreHierarchyState(sparseArray);
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f911a.saveHierarchyState(sparseArray);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        ViewCompat.setBackground(this.f911a, drawable);
    }

    public void setCollapsible(boolean z11) {
        this.f911a.setCollapsible(z11);
    }

    public void setCustomView(View view) {
        View view2 = this.mCustomView;
        if (!(view2 == null || (this.mDisplayOpts & 16) == 0)) {
            this.f911a.removeView(view2);
        }
        this.mCustomView = view;
        if (view != null && (this.mDisplayOpts & 16) != 0) {
            this.f911a.addView(view);
        }
    }

    public void setDefaultNavigationContentDescription(int i11) {
        if (i11 != this.mDefaultNavigationContentDescription) {
            this.mDefaultNavigationContentDescription = i11;
            if (TextUtils.isEmpty(this.f911a.getNavigationContentDescription())) {
                setNavigationContentDescription(this.mDefaultNavigationContentDescription);
            }
        }
    }

    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.mDefaultNavigationIcon != drawable) {
            this.mDefaultNavigationIcon = drawable;
            updateNavigationIcon();
        }
    }

    public void setDisplayOptions(int i11) {
        View view;
        int i12 = this.mDisplayOpts ^ i11;
        this.mDisplayOpts = i11;
        if (i12 != 0) {
            if ((i12 & 4) != 0) {
                if ((i11 & 4) != 0) {
                    updateHomeAccessibility();
                }
                updateNavigationIcon();
            }
            if ((i12 & 3) != 0) {
                updateToolbarLogo();
            }
            if ((i12 & 8) != 0) {
                if ((i11 & 8) != 0) {
                    this.f911a.setTitle(this.f912b);
                    this.f911a.setSubtitle(this.mSubtitle);
                } else {
                    this.f911a.setTitle((CharSequence) null);
                    this.f911a.setSubtitle((CharSequence) null);
                }
            }
            if ((i12 & 16) != 0 && (view = this.mCustomView) != null) {
                if ((i11 & 16) != 0) {
                    this.f911a.addView(view);
                } else {
                    this.f911a.removeView(view);
                }
            }
        }
    }

    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        ensureSpinner();
        this.mSpinner.setAdapter(spinnerAdapter);
        this.mSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setDropdownSelectedPosition(int i11) {
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            spinner.setSelection(i11);
            return;
        }
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.mTabView;
        if (view != null && view.getParent() == (toolbar = this.f911a)) {
            toolbar.removeView(this.mTabView);
        }
        this.mTabView = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.mNavigationMode == 2) {
            this.f911a.addView(scrollingTabContainerView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void setHomeButtonEnabled(boolean z11) {
    }

    public void setIcon(int i11) {
        setIcon(i11 != 0 ? AppCompatResources.getDrawable(getContext(), i11) : null);
    }

    public void setLogo(int i11) {
        setLogo(i11 != 0 ? AppCompatResources.getDrawable(getContext(), i11) : null);
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.mActionMenuPresenter == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f911a.getContext());
            this.mActionMenuPresenter = actionMenuPresenter;
            actionMenuPresenter.setId(R.id.action_menu_presenter);
        }
        this.mActionMenuPresenter.setCallback(callback);
        this.f911a.setMenu((MenuBuilder) menu, this.mActionMenuPresenter);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f911a.setMenuCallbacks(callback, callback2);
    }

    public void setMenuPrepared() {
        this.f914d = true;
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.mHomeDescription = charSequence;
        updateHomeAccessibility();
    }

    public void setNavigationIcon(Drawable drawable) {
        this.mNavIcon = drawable;
        updateNavigationIcon();
    }

    public void setNavigationMode(int i11) {
        Toolbar toolbar;
        View view;
        Toolbar toolbar2;
        int i12 = this.mNavigationMode;
        if (i11 != i12) {
            if (i12 == 1) {
                Spinner spinner = this.mSpinner;
                if (spinner != null && spinner.getParent() == (toolbar = this.f911a)) {
                    toolbar.removeView(this.mSpinner);
                }
            } else if (i12 == 2 && (view = this.mTabView) != null && view.getParent() == (toolbar2 = this.f911a)) {
                toolbar2.removeView(this.mTabView);
            }
            this.mNavigationMode = i11;
            if (i11 == 0) {
                return;
            }
            if (i11 == 1) {
                ensureSpinner();
                this.f911a.addView(this.mSpinner, 0);
            } else if (i11 == 2) {
                View view2 = this.mTabView;
                if (view2 != null) {
                    this.f911a.addView(view2, 0);
                    Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    layoutParams.gravity = BadgeDrawable.BOTTOM_START;
                }
            } else {
                throw new IllegalArgumentException("Invalid navigation mode " + i11);
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.f911a.setSubtitle(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitleSet = true;
        setTitleInt(charSequence);
    }

    public void setVisibility(int i11) {
        this.f911a.setVisibility(i11);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.f913c = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.mTitleSet) {
            setTitleInt(charSequence);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int i11, long j11) {
        float f11;
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(this.f911a);
        if (i11 == 0) {
            f11 = 1.0f;
        } else {
            f11 = 0.0f;
        }
        return animate.alpha(f11).setDuration(j11).setListener(new ViewPropertyAnimatorListenerAdapter() {
            private boolean mCanceled = false;

            public void onAnimationCancel(View view) {
                this.mCanceled = true;
            }

            public void onAnimationEnd(View view) {
                if (!this.mCanceled) {
                    ToolbarWidgetWrapper.this.f911a.setVisibility(i11);
                }
            }

            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.f911a.setVisibility(0);
            }
        });
    }

    public boolean showOverflowMenu() {
        return this.f911a.showOverflowMenu();
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z11, int i11, int i12) {
        Drawable drawable;
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.f911a = toolbar;
        this.f912b = toolbar.getTitle();
        this.mSubtitle = toolbar.getSubtitle();
        this.mTitleSet = this.f912b != null;
        this.mNavIcon = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), (AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.mDefaultNavigationIcon = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
        if (z11) {
            CharSequence text = obtainStyledAttributes.getText(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_logo);
            if (drawable2 != null) {
                setLogo(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_icon);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.mNavIcon == null && (drawable = this.mDefaultNavigationIcon) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.f911a.getContext()).inflate(resourceId, this.f911a, false));
                setDisplayOptions(this.mDisplayOpts | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.f911a.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.f911a.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.f911a.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar2 = this.f911a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar3 = this.f911a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.f911a.setPopupTheme(resourceId4);
            }
        } else {
            this.mDisplayOpts = detectDisplayOptions();
        }
        obtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i11);
        this.mHomeDescription = this.f911a.getNavigationContentDescription();
        this.f911a.setNavigationOnClickListener(new View.OnClickListener() {

            /* renamed from: b  reason: collision with root package name */
            public final ActionMenuItem f915b;

            {
                this.f915b = new ActionMenuItem(ToolbarWidgetWrapper.this.f911a.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.f912b);
            }

            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.f913c;
                if (callback != null && toolbarWidgetWrapper.f914d) {
                    callback.onMenuItemSelected(0, this.f915b);
                }
            }
        });
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        updateToolbarLogo();
    }

    public void setLogo(Drawable drawable) {
        this.mLogo = drawable;
        updateToolbarLogo();
    }

    public void setNavigationContentDescription(int i11) {
        setNavigationContentDescription((CharSequence) i11 == 0 ? null : getContext().getString(i11));
    }

    public void setNavigationIcon(int i11) {
        setNavigationIcon(i11 != 0 ? AppCompatResources.getDrawable(getContext(), i11) : null);
    }
}
