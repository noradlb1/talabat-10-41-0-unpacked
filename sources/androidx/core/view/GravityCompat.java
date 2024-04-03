package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static void a(int i11, int i12, int i13, Rect rect, int i14, int i15, Rect rect2, int i16) {
            Gravity.apply(i11, i12, i13, rect, i14, i15, rect2, i16);
        }

        @DoNotInline
        public static void b(int i11, int i12, int i13, Rect rect, Rect rect2, int i14) {
            Gravity.apply(i11, i12, i13, rect, rect2, i14);
        }

        @DoNotInline
        public static void c(int i11, Rect rect, Rect rect2, int i12) {
            Gravity.applyDisplay(i11, rect, rect2, i12);
        }
    }

    private GravityCompat() {
    }

    public static void apply(int i11, int i12, int i13, @NonNull Rect rect, @NonNull Rect rect2, int i14) {
        Api17Impl.b(i11, i12, i13, rect, rect2, i14);
    }

    public static void applyDisplay(int i11, @NonNull Rect rect, @NonNull Rect rect2, int i12) {
        Api17Impl.c(i11, rect, rect2, i12);
    }

    public static int getAbsoluteGravity(int i11, int i12) {
        return Gravity.getAbsoluteGravity(i11, i12);
    }

    public static void apply(int i11, int i12, int i13, @NonNull Rect rect, int i14, int i15, @NonNull Rect rect2, int i16) {
        Api17Impl.a(i11, i12, i13, rect, i14, i15, rect2, i16);
    }
}
