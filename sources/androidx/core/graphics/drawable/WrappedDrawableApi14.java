package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {

    /* renamed from: d  reason: collision with root package name */
    public static final PorterDuff.Mode f11299d = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    public WrappedDrawableState f11300b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f11301c;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private PorterDuff.Mode mCurrentMode;
    private boolean mMutated;

    public WrappedDrawableApi14(@NonNull WrappedDrawableState wrappedDrawableState, @Nullable Resources resources) {
        this.f11300b = wrappedDrawableState;
        updateLocalState(resources);
    }

    @NonNull
    private WrappedDrawableState mutateConstantState() {
        return new WrappedDrawableState(this.f11300b);
    }

    private void updateLocalState(@Nullable Resources resources) {
        Drawable.ConstantState constantState;
        WrappedDrawableState wrappedDrawableState = this.f11300b;
        if (wrappedDrawableState != null && (constantState = wrappedDrawableState.f11303b) != null) {
            setWrappedDrawable(constantState.newDrawable(resources));
        }
    }

    private boolean updateTint(int[] iArr) {
        if (!a()) {
            return false;
        }
        WrappedDrawableState wrappedDrawableState = this.f11300b;
        ColorStateList colorStateList = wrappedDrawableState.f11304c;
        PorterDuff.Mode mode = wrappedDrawableState.f11305d;
        if (colorStateList == null || mode == null) {
            this.mColorFilterSet = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.mColorFilterSet && colorForState == this.mCurrentColor && mode == this.mCurrentMode)) {
                setColorFilter(colorForState, mode);
                this.mCurrentColor = colorForState;
                this.mCurrentMode = mode;
                this.mColorFilterSet = true;
                return true;
            }
        }
        return false;
    }

    public boolean a() {
        return true;
    }

    public void draw(@NonNull Canvas canvas) {
        this.f11301c.draw(canvas);
    }

    public int getChangingConfigurations() {
        int i11;
        int changingConfigurations = super.getChangingConfigurations();
        WrappedDrawableState wrappedDrawableState = this.f11300b;
        if (wrappedDrawableState != null) {
            i11 = wrappedDrawableState.getChangingConfigurations();
        } else {
            i11 = 0;
        }
        return changingConfigurations | i11 | this.f11301c.getChangingConfigurations();
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState wrappedDrawableState = this.f11300b;
        if (wrappedDrawableState == null || !wrappedDrawableState.a()) {
            return null;
        }
        this.f11300b.f11302a = getChangingConfigurations();
        return this.f11300b;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.f11301c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f11301c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f11301c.getIntrinsicWidth();
    }

    @RequiresApi(23)
    public int getLayoutDirection() {
        return DrawableCompat.getLayoutDirection(this.f11301c);
    }

    public int getMinimumHeight() {
        return this.f11301c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f11301c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f11301c.getOpacity();
    }

    public boolean getPadding(@NonNull Rect rect) {
        return this.f11301c.getPadding(rect);
    }

    @NonNull
    public int[] getState() {
        return this.f11301c.getState();
    }

    public Region getTransparentRegion() {
        return this.f11301c.getTransparentRegion();
    }

    public final Drawable getWrappedDrawable() {
        return this.f11301c;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    @RequiresApi(19)
    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.f11301c);
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        WrappedDrawableState wrappedDrawableState;
        if (!a() || (wrappedDrawableState = this.f11300b) == null) {
            colorStateList = null;
        } else {
            colorStateList = wrappedDrawableState.f11304c;
        }
        if ((colorStateList == null || !colorStateList.isStateful()) && !this.f11301c.isStateful()) {
            return false;
        }
        return true;
    }

    public void jumpToCurrentState() {
        this.f11301c.jumpToCurrentState();
    }

    @NonNull
    public Drawable mutate() {
        Drawable.ConstantState constantState;
        if (!this.mMutated && super.mutate() == this) {
            this.f11300b = mutateConstantState();
            Drawable drawable = this.f11301c;
            if (drawable != null) {
                drawable.mutate();
            }
            WrappedDrawableState wrappedDrawableState = this.f11300b;
            if (wrappedDrawableState != null) {
                Drawable drawable2 = this.f11301c;
                if (drawable2 != null) {
                    constantState = drawable2.getConstantState();
                } else {
                    constantState = null;
                }
                wrappedDrawableState.f11303b = constantState;
            }
            this.mMutated = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f11301c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @RequiresApi(23)
    public boolean onLayoutDirectionChanged(int i11) {
        return DrawableCompat.setLayoutDirection(this.f11301c, i11);
    }

    public boolean onLevelChange(int i11) {
        return this.f11301c.setLevel(i11);
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j11) {
        scheduleSelf(runnable, j11);
    }

    public void setAlpha(int i11) {
        this.f11301c.setAlpha(i11);
    }

    @RequiresApi(19)
    public void setAutoMirrored(boolean z11) {
        DrawableCompat.setAutoMirrored(this.f11301c, z11);
    }

    public void setChangingConfigurations(int i11) {
        this.f11301c.setChangingConfigurations(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11301c.setColorFilter(colorFilter);
    }

    public void setDither(boolean z11) {
        this.f11301c.setDither(z11);
    }

    public void setFilterBitmap(boolean z11) {
        this.f11301c.setFilterBitmap(z11);
    }

    public boolean setState(@NonNull int[] iArr) {
        boolean state = this.f11301c.setState(iArr);
        if (updateTint(iArr) || state) {
            return true;
        }
        return false;
    }

    public void setTint(int i11) {
        setTintList(ColorStateList.valueOf(i11));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f11300b.f11304c = colorStateList;
        updateTint(getState());
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.f11300b.f11305d = mode;
        updateTint(getState());
    }

    public boolean setVisible(boolean z11, boolean z12) {
        return super.setVisible(z11, z12) || this.f11301c.setVisible(z11, z12);
    }

    public final void setWrappedDrawable(Drawable drawable) {
        Drawable drawable2 = this.f11301c;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f11301c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            WrappedDrawableState wrappedDrawableState = this.f11300b;
            if (wrappedDrawableState != null) {
                wrappedDrawableState.f11303b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
