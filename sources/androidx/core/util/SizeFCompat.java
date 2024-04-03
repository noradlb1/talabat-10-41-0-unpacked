package androidx.core.util;

import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.huawei.hms.flutter.map.constants.Param;

public final class SizeFCompat {
    private final float mHeight;
    private final float mWidth;

    @RequiresApi(21)
    public static final class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        @NonNull
        public static SizeF a(@NonNull SizeFCompat sizeFCompat) {
            Preconditions.checkNotNull(sizeFCompat);
            return new SizeF(sizeFCompat.getWidth(), sizeFCompat.getHeight());
        }

        @DoNotInline
        @NonNull
        public static SizeFCompat b(@NonNull SizeF sizeF) {
            Preconditions.checkNotNull(sizeF);
            return new SizeFCompat(sizeF.getWidth(), sizeF.getHeight());
        }
    }

    public SizeFCompat(float f11, float f12) {
        this.mWidth = Preconditions.checkArgumentFinite(f11, "width");
        this.mHeight = Preconditions.checkArgumentFinite(f12, "height");
    }

    @RequiresApi(21)
    @NonNull
    public static SizeFCompat toSizeFCompat(@NonNull SizeF sizeF) {
        return Api21Impl.b(sizeF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeFCompat)) {
            return false;
        }
        SizeFCompat sizeFCompat = (SizeFCompat) obj;
        if (sizeFCompat.mWidth == this.mWidth && sizeFCompat.mHeight == this.mHeight) {
            return true;
        }
        return false;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.mWidth) ^ Float.floatToIntBits(this.mHeight);
    }

    @RequiresApi(21)
    @NonNull
    public SizeF toSizeF() {
        return Api21Impl.a(this);
    }

    @NonNull
    public String toString() {
        return this.mWidth + Param.X + this.mHeight;
    }
}
