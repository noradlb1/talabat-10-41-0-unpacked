package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBarDrawerToggleHoneycomb;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f496a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f497b;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private final DrawerLayout mDrawerLayout;
    private boolean mDrawerSlideAnimationEnabled;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private DrawerArrowDrawable mSlider;
    private boolean mWarnedForDisplayHomeAsUp;

    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@StringRes int i11);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i11);
    }

    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    public static class FrameworkActionBarDelegate implements Delegate {
        private final Activity mActivity;
        private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

        @RequiresApi(18)
        public static class Api18Impl {
            private Api18Impl() {
            }

            @DoNotInline
            public static void a(ActionBar actionBar, int i11) {
                actionBar.setHomeActionContentDescription(i11);
            }

            @DoNotInline
            public static void b(ActionBar actionBar, Drawable drawable) {
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }

        public FrameworkActionBarDelegate(Activity activity) {
            this.mActivity = activity;
        }

        public Context getActionBarThemedContext() {
            ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.mActivity;
        }

        public Drawable getThemeUpIndicator() {
            TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes((AttributeSet) null, new int[]{16843531}, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public boolean isNavigationVisible() {
            ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) {
                return false;
            }
            return true;
        }

        public void setActionBarDescription(int i11) {
            ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                Api18Impl.a(actionBar, i11);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i11) {
            ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                Api18Impl.b(actionBar, drawable);
                Api18Impl.a(actionBar, i11);
            }
        }
    }

    public static class ToolbarCompatDelegate implements Delegate {

        /* renamed from: a  reason: collision with root package name */
        public final Toolbar f499a;

        /* renamed from: b  reason: collision with root package name */
        public final Drawable f500b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f501c;

        public ToolbarCompatDelegate(Toolbar toolbar) {
            this.f499a = toolbar;
            this.f500b = toolbar.getNavigationIcon();
            this.f501c = toolbar.getNavigationContentDescription();
        }

        public Context getActionBarThemedContext() {
            return this.f499a.getContext();
        }

        public Drawable getThemeUpIndicator() {
            return this.f500b;
        }

        public boolean isNavigationVisible() {
            return true;
        }

        public void setActionBarDescription(@StringRes int i11) {
            if (i11 == 0) {
                this.f499a.setNavigationContentDescription(this.f501c);
            } else {
                this.f499a.setNavigationContentDescription(i11);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, @StringRes int i11) {
            this.f499a.setNavigationIcon(drawable);
            setActionBarDescription(i11);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @StringRes int i11, @StringRes int i12) {
        this(activity, (Toolbar) null, drawerLayout, (DrawerArrowDrawable) null, i11, i12);
    }

    private void setPosition(float f11) {
        if (f11 == 1.0f) {
            this.mSlider.setVerticalMirror(true);
        } else if (f11 == 0.0f) {
            this.mSlider.setVerticalMirror(false);
        }
        this.mSlider.setProgress(f11);
    }

    public Drawable a() {
        return this.mActivityImpl.getThemeUpIndicator();
    }

    public void b(int i11) {
        this.mActivityImpl.setActionBarDescription(i11);
    }

    public void c(Drawable drawable, int i11) {
        if (!this.mWarnedForDisplayHomeAsUp && !this.mActivityImpl.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.mWarnedForDisplayHomeAsUp = true;
        }
        this.mActivityImpl.setActionBarUpIndicator(drawable, i11);
    }

    public void d() {
        int drawerLockMode = this.mDrawerLayout.getDrawerLockMode((int) GravityCompat.START);
        if (this.mDrawerLayout.isDrawerVisible((int) GravityCompat.START) && drawerLockMode != 2) {
            this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
        } else if (drawerLockMode != 1) {
            this.mDrawerLayout.openDrawer((int) GravityCompat.START);
        }
    }

    @NonNull
    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.f497b;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f496a;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.mDrawerSlideAnimationEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = a();
        }
        syncState();
    }

    public void onDrawerClosed(View view) {
        setPosition(0.0f);
        if (this.f496a) {
            b(this.mOpenDrawerContentDescRes);
        }
    }

    public void onDrawerOpened(View view) {
        setPosition(1.0f);
        if (this.f496a) {
            b(this.mCloseDrawerContentDescRes);
        }
    }

    public void onDrawerSlide(View view, float f11) {
        if (this.mDrawerSlideAnimationEnabled) {
            setPosition(Math.min(1.0f, Math.max(0.0f, f11)));
        } else {
            setPosition(0.0f);
        }
    }

    public void onDrawerStateChanged(int i11) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f496a) {
            return false;
        }
        d();
        return true;
    }

    public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable drawerArrowDrawable) {
        this.mSlider = drawerArrowDrawable;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean z11) {
        int i11;
        if (z11 != this.f496a) {
            if (z11) {
                DrawerArrowDrawable drawerArrowDrawable = this.mSlider;
                if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
                    i11 = this.mCloseDrawerContentDescRes;
                } else {
                    i11 = this.mOpenDrawerContentDescRes;
                }
                c(drawerArrowDrawable, i11);
            } else {
                c(this.mHomeAsUpIndicator, 0);
            }
            this.f496a = z11;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean z11) {
        this.mDrawerSlideAnimationEnabled = z11;
        if (!z11) {
            setPosition(0.0f);
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.mHomeAsUpIndicator = a();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable;
            this.mHasCustomUpIndicator = true;
        }
        if (!this.f496a) {
            c(this.mHomeAsUpIndicator, 0);
        }
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.f497b = onClickListener;
    }

    public void syncState() {
        int i11;
        if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            setPosition(1.0f);
        } else {
            setPosition(0.0f);
        }
        if (this.f496a) {
            DrawerArrowDrawable drawerArrowDrawable = this.mSlider;
            if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
                i11 = this.mCloseDrawerContentDescRes;
            } else {
                i11 = this.mOpenDrawerContentDescRes;
            }
            c(drawerArrowDrawable, i11);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int i11, @StringRes int i12) {
        this(activity, toolbar, drawerLayout, (DrawerArrowDrawable) null, i11, i12);
    }

    public ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, @StringRes int i11, @StringRes int i12) {
        this.mDrawerSlideAnimationEnabled = true;
        this.f496a = true;
        this.mWarnedForDisplayHomeAsUp = false;
        if (toolbar != null) {
            this.mActivityImpl = new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ActionBarDrawerToggle actionBarDrawerToggle = ActionBarDrawerToggle.this;
                    if (actionBarDrawerToggle.f496a) {
                        actionBarDrawerToggle.d();
                        return;
                    }
                    View.OnClickListener onClickListener = actionBarDrawerToggle.f497b;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.mActivityImpl = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = new FrameworkActionBarDelegate(activity);
        }
        this.mDrawerLayout = drawerLayout;
        this.mOpenDrawerContentDescRes = i11;
        this.mCloseDrawerContentDescRes = i12;
        if (drawerArrowDrawable == null) {
            this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
        } else {
            this.mSlider = drawerArrowDrawable;
        }
        this.mHomeAsUpIndicator = a();
    }

    public void setHomeAsUpIndicator(int i11) {
        setHomeAsUpIndicator(i11 != 0 ? this.mDrawerLayout.getResources().getDrawable(i11) : null);
    }
}
