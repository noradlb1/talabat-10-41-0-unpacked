package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi(21)
class WrappedDrawableApi21 extends WrappedDrawableApi14 {
    private static final String TAG = "WrappedDrawableApi21";
    private static Method sIsProjectedDrawableMethod;

    public WrappedDrawableApi21(WrappedDrawableState wrappedDrawableState, Resources resources) {
        super(wrappedDrawableState, resources);
        findAndCacheIsProjectedDrawableMethod();
    }

    private void findAndCacheIsProjectedDrawableMethod() {
        if (sIsProjectedDrawableMethod == null) {
            try {
                sIsProjectedDrawableMethod = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e11) {
                Log.w(TAG, "Failed to retrieve Drawable#isProjected() method", e11);
            }
        }
    }

    public boolean a() {
        return false;
    }

    @NonNull
    public Rect getDirtyBounds() {
        return this.f11301c.getDirtyBounds();
    }

    public void getOutline(@NonNull Outline outline) {
        this.f11301c.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f11301c;
        if (!(drawable == null || (method = sIsProjectedDrawableMethod) == null)) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e11) {
                Log.w(TAG, "Error calling Drawable#isProjected() method", e11);
            }
        }
        return false;
    }

    public void setHotspot(float f11, float f12) {
        this.f11301c.setHotspot(f11, f12);
    }

    public void setHotspotBounds(int i11, int i12, int i13, int i14) {
        this.f11301c.setHotspotBounds(i11, i12, i13, i14);
    }

    public boolean setState(@NonNull int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i11) {
        if (a()) {
            super.setTint(i11);
        } else {
            this.f11301c.setTint(i11);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (a()) {
            super.setTintList(colorStateList);
        } else {
            this.f11301c.setTintList(colorStateList);
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (a()) {
            super.setTintMode(mode);
        } else {
            this.f11301c.setTintMode(mode);
        }
    }
}
