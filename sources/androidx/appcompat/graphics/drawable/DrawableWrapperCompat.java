package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableWrapperCompat extends Drawable implements Drawable.Callback {
    private Drawable mDrawable;

    public DrawableWrapperCompat(Drawable drawable) {
        setDrawable(drawable);
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    @Nullable
    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    public void onBoundsChange(Rect rect) {
        this.mDrawable.setBounds(rect);
    }

    public boolean onLevelChange(int i11) {
        return this.mDrawable.setLevel(i11);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
        scheduleSelf(runnable, j11);
    }

    public void setAlpha(int i11) {
        this.mDrawable.setAlpha(i11);
    }

    public void setAutoMirrored(boolean z11) {
        DrawableCompat.setAutoMirrored(this.mDrawable, z11);
    }

    public void setChangingConfigurations(int i11) {
        this.mDrawable.setChangingConfigurations(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public void setDither(boolean z11) {
        this.mDrawable.setDither(z11);
    }

    public void setDrawable(@Nullable Drawable drawable) {
        Drawable drawable2 = this.mDrawable;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void setFilterBitmap(boolean z11) {
        this.mDrawable.setFilterBitmap(z11);
    }

    public void setHotspot(float f11, float f12) {
        DrawableCompat.setHotspot(this.mDrawable, f11, f12);
    }

    public void setHotspotBounds(int i11, int i12, int i13, int i14) {
        DrawableCompat.setHotspotBounds(this.mDrawable, i11, i12, i13, i14);
    }

    public boolean setState(int[] iArr) {
        return this.mDrawable.setState(iArr);
    }

    public void setTint(int i11) {
        DrawableCompat.setTint(this.mDrawable, i11);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.mDrawable, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        DrawableCompat.setTintMode(this.mDrawable, mode);
    }

    public boolean setVisible(boolean z11, boolean z12) {
        return super.setVisible(z11, z12) || this.mDrawable.setVisible(z11, z12);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
