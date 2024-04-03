package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS = {16843531};
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f35969a;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private SetIndicatorInfo mSetIndicatorInfo;
    private SlideDrawable mSlider;

    @Deprecated
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int i11);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i11);
    }

    @Deprecated
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    public static class SetIndicatorInfo {
    }

    public class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final boolean mHasMirroring = true;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect = new Rect();

        public SlideDrawable(Drawable drawable) {
            super(drawable, 0);
        }

        public void draw(@NonNull Canvas canvas) {
            boolean z11;
            copyBounds(this.mTmpRect);
            canvas.save();
            int i11 = 1;
            if (ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.f35969a.getWindow().getDecorView()) == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                i11 = -1;
            }
            float width = (float) this.mTmpRect.width();
            canvas.translate((-this.mOffset) * width * this.mPosition * ((float) i11), 0.0f);
            if (z11 && !this.mHasMirroring) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float f11) {
            this.mOffset = f11;
            invalidateSelf();
        }

        public void setPosition(float f11) {
            this.mPosition = f11;
            invalidateSelf();
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @DrawableRes int i11, @StringRes int i12, @StringRes int i13) {
        this(activity, drawerLayout, !assumeMaterial(activity), i11, i12, i13);
    }

    private static boolean assumeMaterial(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21;
    }

    private Drawable getThemeUpIndicator() {
        Context context;
        Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            return delegate.getThemeUpIndicator();
        }
        ActionBar actionBar = this.f35969a.getActionBar();
        if (actionBar != null) {
            context = actionBar.getThemedContext();
        } else {
            context = this.f35969a;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, THEME_ATTRS, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    private void setActionBarDescription(int i11) {
        Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarDescription(i11);
            return;
        }
        ActionBar actionBar = this.f35969a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i11);
        }
    }

    private void setActionBarUpIndicator(Drawable drawable, int i11) {
        Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarUpIndicator(drawable, i11);
            return;
        }
        ActionBar actionBar = this.f35969a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i11);
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        this.mDrawerImage = ContextCompat.getDrawable(this.f35969a, this.mDrawerImageResource);
        syncState();
    }

    public void onDrawerClosed(View view) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    public void onDrawerOpened(View view) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    public void onDrawerSlide(View view, float f11) {
        float f12;
        float position = this.mSlider.getPosition();
        if (f11 > 0.5f) {
            f12 = Math.max(position, Math.max(0.0f, f11 - 0.5f) * 2.0f);
        } else {
            f12 = Math.min(position, f11 * 2.0f);
        }
        this.mSlider.setPosition(f12);
    }

    public void onDrawerStateChanged(int i11) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != ID_HOME || !this.mDrawerIndicatorEnabled) {
            return false;
        }
        if (this.mDrawerLayout.isDrawerVisible((int) GravityCompat.START)) {
            this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
            return true;
        }
        this.mDrawerLayout.openDrawer((int) GravityCompat.START);
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean z11) {
        int i11;
        if (z11 != this.mDrawerIndicatorEnabled) {
            if (z11) {
                SlideDrawable slideDrawable = this.mSlider;
                if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
                    i11 = this.mCloseDrawerContentDescRes;
                } else {
                    i11 = this.mOpenDrawerContentDescRes;
                }
                setActionBarUpIndicator(slideDrawable, i11);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z11;
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable;
            this.mHasCustomUpIndicator = true;
        }
        if (!this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
    }

    public void syncState() {
        int i11;
        if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            this.mSlider.setPosition(1.0f);
        } else {
            this.mSlider.setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            SlideDrawable slideDrawable = this.mSlider;
            if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
                i11 = this.mCloseDrawerContentDescRes;
            } else {
                i11 = this.mOpenDrawerContentDescRes;
            }
            setActionBarUpIndicator(slideDrawable, i11);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z11, @DrawableRes int i11, @StringRes int i12, @StringRes int i13) {
        this.mDrawerIndicatorEnabled = true;
        this.f35969a = activity;
        if (activity instanceof DelegateProvider) {
            this.mActivityImpl = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = null;
        }
        this.mDrawerLayout = drawerLayout;
        this.mDrawerImageResource = i11;
        this.mOpenDrawerContentDescRes = i12;
        this.mCloseDrawerContentDescRes = i13;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(activity, i11);
        SlideDrawable slideDrawable = new SlideDrawable(this.mDrawerImage);
        this.mSlider = slideDrawable;
        slideDrawable.setOffset(z11 ? TOGGLE_DRAWABLE_OFFSET : 0.0f);
    }

    public void setHomeAsUpIndicator(int i11) {
        setHomeAsUpIndicator(i11 != 0 ? ContextCompat.getDrawable(this.f35969a, i11) : null);
    }
}
