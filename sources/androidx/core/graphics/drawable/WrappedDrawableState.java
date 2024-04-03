package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class WrappedDrawableState extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public int f11302a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable.ConstantState f11303b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f11304c = null;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f11305d = WrappedDrawableApi14.f11299d;

    public WrappedDrawableState(@Nullable WrappedDrawableState wrappedDrawableState) {
        if (wrappedDrawableState != null) {
            this.f11302a = wrappedDrawableState.f11302a;
            this.f11303b = wrappedDrawableState.f11303b;
            this.f11304c = wrappedDrawableState.f11304c;
            this.f11305d = wrappedDrawableState.f11305d;
        }
    }

    public boolean a() {
        return this.f11303b != null;
    }

    public int getChangingConfigurations() {
        int i11;
        int i12 = this.f11302a;
        Drawable.ConstantState constantState = this.f11303b;
        if (constantState != null) {
            i11 = constantState.getChangingConfigurations();
        } else {
            i11 = 0;
        }
        return i12 | i11;
    }

    @NonNull
    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    @NonNull
    public Drawable newDrawable(@Nullable Resources resources) {
        return new WrappedDrawableApi21(this, resources);
    }
}
