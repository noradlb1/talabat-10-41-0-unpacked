package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

class AppCompatBackgroundHelper {
    private int mBackgroundResId = -1;
    private TintInfo mBackgroundTint;
    private final AppCompatDrawableManager mDrawableManager;
    private TintInfo mInternalBackgroundTint;
    private TintInfo mTmpInfo;
    @NonNull
    private final View mView;

    public AppCompatBackgroundHelper(@NonNull View view) {
        this.mView = view;
        this.mDrawableManager = AppCompatDrawableManager.get();
    }

    private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new TintInfo();
        }
        TintInfo tintInfo = this.mTmpInfo;
        tintInfo.a();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.mView);
        if (backgroundTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.mView);
        if (backgroundTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = backgroundTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.d(drawable, tintInfo, this.mView.getDrawableState());
        return true;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        return this.mInternalBackgroundTint != null;
    }

    public void a() {
        Drawable background = this.mView.getBackground();
        if (background == null) {
            return;
        }
        if (!shouldApplyFrameworkTintUsingColorFilter() || !applyFrameworkTintUsingColorFilter(background)) {
            TintInfo tintInfo = this.mBackgroundTint;
            if (tintInfo != null) {
                AppCompatDrawableManager.d(background, tintInfo, this.mView.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.mInternalBackgroundTint;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.d(background, tintInfo2, this.mView.getDrawableState());
            }
        }
    }

    public ColorStateList b() {
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public void d(@Nullable AttributeSet attributeSet, int i11) {
        Context context = this.mView.getContext();
        int[] iArr = R.styleable.ViewBackgroundHelper;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i11, 0);
        View view = this.mView;
        ViewCompat.saveAttributeDataForStyleable(view, view.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i11, 0);
        try {
            int i12 = R.styleable.ViewBackgroundHelper_android_background;
            if (obtainStyledAttributes.hasValue(i12)) {
                this.mBackgroundResId = obtainStyledAttributes.getResourceId(i12, -1);
                ColorStateList c11 = this.mDrawableManager.c(this.mView.getContext(), this.mBackgroundResId);
                if (c11 != null) {
                    g(c11);
                }
            }
            int i13 = R.styleable.ViewBackgroundHelper_backgroundTint;
            if (obtainStyledAttributes.hasValue(i13)) {
                ViewCompat.setBackgroundTintList(this.mView, obtainStyledAttributes.getColorStateList(i13));
            }
            int i14 = R.styleable.ViewBackgroundHelper_backgroundTintMode;
            if (obtainStyledAttributes.hasValue(i14)) {
                ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i14, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void e(Drawable drawable) {
        this.mBackgroundResId = -1;
        g((ColorStateList) null);
        a();
    }

    public void f(int i11) {
        ColorStateList colorStateList;
        this.mBackgroundResId = i11;
        AppCompatDrawableManager appCompatDrawableManager = this.mDrawableManager;
        if (appCompatDrawableManager != null) {
            colorStateList = appCompatDrawableManager.c(this.mView.getContext(), i11);
        } else {
            colorStateList = null;
        }
        g(colorStateList);
        a();
    }

    public void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalBackgroundTint == null) {
                this.mInternalBackgroundTint = new TintInfo();
            }
            TintInfo tintInfo = this.mInternalBackgroundTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.mInternalBackgroundTint = null;
        }
        a();
    }

    public void h(ColorStateList colorStateList) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        a();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        a();
    }
}
