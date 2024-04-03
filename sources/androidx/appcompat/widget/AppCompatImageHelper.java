package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private int mLevel = 0;
    private TintInfo mTmpInfo;
    @NonNull
    private final ImageView mView;

    public AppCompatImageHelper(@NonNull ImageView imageView) {
        this.mView = imageView;
    }

    private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new TintInfo();
        }
        TintInfo tintInfo = this.mTmpInfo;
        tintInfo.a();
        ColorStateList imageTintList = ImageViewCompat.getImageTintList(this.mView);
        if (imageTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = imageTintList;
        }
        PorterDuff.Mode imageTintMode = ImageViewCompat.getImageTintMode(this.mView);
        if (imageTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = imageTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.d(drawable, tintInfo, this.mView.getDrawableState());
        return true;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        return this.mInternalImageTint != null;
    }

    public void a() {
        if (this.mView.getDrawable() != null) {
            this.mView.getDrawable().setLevel(this.mLevel);
        }
    }

    public void b() {
        Drawable drawable = this.mView.getDrawable();
        if (drawable != null) {
            DrawableUtils.a(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!shouldApplyFrameworkTintUsingColorFilter() || !applyFrameworkTintUsingColorFilter(drawable)) {
            TintInfo tintInfo = this.mImageTint;
            if (tintInfo != null) {
                AppCompatDrawableManager.d(drawable, tintInfo, this.mView.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.mInternalImageTint;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.d(drawable, tintInfo2, this.mView.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        TintInfo tintInfo = this.mImageTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        TintInfo tintInfo = this.mImageTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public boolean e() {
        if (this.mView.getBackground() instanceof RippleDrawable) {
            return false;
        }
        return true;
    }

    public void f(@NonNull Drawable drawable) {
        this.mLevel = drawable.getLevel();
    }

    public void g(ColorStateList colorStateList) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        b();
    }

    public void h(PorterDuff.Mode mode) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        b();
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i11) {
        int resourceId;
        Context context = this.mView.getContext();
        int[] iArr = R.styleable.AppCompatImageView;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i11, 0);
        ImageView imageView = this.mView;
        ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i11, 0);
        try {
            Drawable drawable = this.mView.getDrawable();
            if (!(drawable != null || (resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = AppCompatResources.getDrawable(this.mView.getContext(), resourceId)) == null)) {
                this.mView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.a(drawable);
            }
            int i12 = R.styleable.AppCompatImageView_tint;
            if (obtainStyledAttributes.hasValue(i12)) {
                ImageViewCompat.setImageTintList(this.mView, obtainStyledAttributes.getColorStateList(i12));
            }
            int i13 = R.styleable.AppCompatImageView_tintMode;
            if (obtainStyledAttributes.hasValue(i13)) {
                ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i13, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setImageResource(int i11) {
        if (i11 != 0) {
            Drawable drawable = AppCompatResources.getDrawable(this.mView.getContext(), i11);
            if (drawable != null) {
                DrawableUtils.a(drawable);
            }
            this.mView.setImageDrawable(drawable);
        } else {
            this.mView.setImageDrawable((Drawable) null);
        }
        b();
    }
}
