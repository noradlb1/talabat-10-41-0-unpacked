package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static int a(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        @DoNotInline
        public static int b(TypedArray typedArray, int i11) {
            return typedArray.getType(i11);
        }
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i11, boolean z11) {
        return this.mWrapped.getBoolean(i11, z11);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return Api21Impl.a(this.mWrapped);
    }

    public int getColor(int i11, int i12) {
        return this.mWrapped.getColor(i11, i12);
    }

    public ColorStateList getColorStateList(int i11) {
        int resourceId;
        ColorStateList colorStateList;
        if (!this.mWrapped.hasValue(i11) || (resourceId = this.mWrapped.getResourceId(i11, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) {
            return this.mWrapped.getColorStateList(i11);
        }
        return colorStateList;
    }

    public float getDimension(int i11, float f11) {
        return this.mWrapped.getDimension(i11, f11);
    }

    public int getDimensionPixelOffset(int i11, int i12) {
        return this.mWrapped.getDimensionPixelOffset(i11, i12);
    }

    public int getDimensionPixelSize(int i11, int i12) {
        return this.mWrapped.getDimensionPixelSize(i11, i12);
    }

    public Drawable getDrawable(int i11) {
        int resourceId;
        if (!this.mWrapped.hasValue(i11) || (resourceId = this.mWrapped.getResourceId(i11, 0)) == 0) {
            return this.mWrapped.getDrawable(i11);
        }
        return AppCompatResources.getDrawable(this.mContext, resourceId);
    }

    public Drawable getDrawableIfKnown(int i11) {
        int resourceId;
        if (!this.mWrapped.hasValue(i11) || (resourceId = this.mWrapped.getResourceId(i11, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().b(this.mContext, resourceId, true);
    }

    public float getFloat(int i11, float f11) {
        return this.mWrapped.getFloat(i11, f11);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i11, int i12, @Nullable ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.mWrapped.getResourceId(i11, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        return ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i12, fontCallback);
    }

    public float getFraction(int i11, int i12, int i13, float f11) {
        return this.mWrapped.getFraction(i11, i12, i13, f11);
    }

    public int getIndex(int i11) {
        return this.mWrapped.getIndex(i11);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int i11, int i12) {
        return this.mWrapped.getInt(i11, i12);
    }

    public int getInteger(int i11, int i12) {
        return this.mWrapped.getInteger(i11, i12);
    }

    public int getLayoutDimension(int i11, String str) {
        return this.mWrapped.getLayoutDimension(i11, str);
    }

    public String getNonResourceString(int i11) {
        return this.mWrapped.getNonResourceString(i11);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int i11, int i12) {
        return this.mWrapped.getResourceId(i11, i12);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int i11) {
        return this.mWrapped.getString(i11);
    }

    public CharSequence getText(int i11) {
        return this.mWrapped.getText(i11);
    }

    public CharSequence[] getTextArray(int i11) {
        return this.mWrapped.getTextArray(i11);
    }

    public int getType(int i11) {
        return Api21Impl.b(this.mWrapped, i11);
    }

    public boolean getValue(int i11, TypedValue typedValue) {
        return this.mWrapped.getValue(i11, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int i11) {
        return this.mWrapped.hasValue(i11);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int i11) {
        return this.mWrapped.peekValue(i11);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i11, int i12) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i11, i12));
    }

    public int getLayoutDimension(int i11, int i12) {
        return this.mWrapped.getLayoutDimension(i11, i12);
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i11, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i11, iArr));
    }
}
