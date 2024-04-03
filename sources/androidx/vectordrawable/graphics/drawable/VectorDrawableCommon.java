package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;

abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable {

    /* renamed from: b  reason: collision with root package name */
    public Drawable f37852b;

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.applyTheme(drawable, theme);
        }
    }

    public void clearColorFilter() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumHeight() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.jumpToCurrentState(drawable);
        }
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public boolean onLevelChange(int i11) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.setLevel(i11);
        }
        return super.onLevelChange(i11);
    }

    public void setChangingConfigurations(int i11) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.setChangingConfigurations(i11);
        } else {
            super.setChangingConfigurations(i11);
        }
    }

    public void setColorFilter(int i11, PorterDuff.Mode mode) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.setColorFilter(i11, mode);
        } else {
            super.setColorFilter(i11, mode);
        }
    }

    public void setFilterBitmap(boolean z11) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.setFilterBitmap(z11);
        }
    }

    public void setHotspot(float f11, float f12) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f11, f12);
        }
    }

    public void setHotspotBounds(int i11, int i12, int i13, int i14) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.setHotspotBounds(drawable, i11, i12, i13, i14);
        }
    }

    public boolean setState(int[] iArr) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return super.setState(iArr);
    }
}
