package androidx.core.graphics;

import android.graphics.Rect;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class Insets {
    @NonNull
    public static final Insets NONE = new Insets(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static android.graphics.Insets a(int i11, int i12, int i13, int i14) {
            return android.graphics.Insets.of(i11, i12, i13, i14);
        }
    }

    private Insets(int i11, int i12, int i13, int i14) {
        this.left = i11;
        this.top = i12;
        this.right = i13;
        this.bottom = i14;
    }

    @NonNull
    public static Insets add(@NonNull Insets insets, @NonNull Insets insets2) {
        return of(insets.left + insets2.left, insets.top + insets2.top, insets.right + insets2.right, insets.bottom + insets2.bottom);
    }

    @NonNull
    public static Insets max(@NonNull Insets insets, @NonNull Insets insets2) {
        return of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom));
    }

    @NonNull
    public static Insets min(@NonNull Insets insets, @NonNull Insets insets2) {
        return of(Math.min(insets.left, insets2.left), Math.min(insets.top, insets2.top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom));
    }

    @NonNull
    public static Insets of(int i11, int i12, int i13, int i14) {
        if (i11 == 0 && i12 == 0 && i13 == 0 && i14 == 0) {
            return NONE;
        }
        return new Insets(i11, i12, i13, i14);
    }

    @NonNull
    public static Insets subtract(@NonNull Insets insets, @NonNull Insets insets2) {
        return of(insets.left - insets2.left, insets.top - insets2.top, insets.right - insets2.right, insets.bottom - insets2.bottom);
    }

    @RequiresApi(api = 29)
    @NonNull
    public static Insets toCompatInsets(@NonNull android.graphics.Insets insets) {
        return of(insets.left, insets.top, insets.right, insets.bottom);
    }

    @RequiresApi(api = 29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NonNull
    @Deprecated
    public static Insets wrap(@NonNull android.graphics.Insets insets) {
        return toCompatInsets(insets);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        if (this.bottom == insets.bottom && this.left == insets.left && this.right == insets.right && this.top == insets.top) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    @RequiresApi(29)
    @NonNull
    public android.graphics.Insets toPlatformInsets() {
        return Api29Impl.a(this.left, this.top, this.right, this.bottom);
    }

    @NonNull
    public String toString() {
        return "Insets{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + AbstractJsonLexerKt.END_OBJ;
    }

    @NonNull
    public static Insets of(@NonNull Rect rect) {
        return of(rect.left, rect.top, rect.right, rect.bottom);
    }
}
