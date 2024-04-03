package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class MarginLayoutParamsCompat {

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        @DoNotInline
        public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        @DoNotInline
        public static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        @DoNotInline
        public static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        @DoNotInline
        public static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            marginLayoutParams.resolveLayoutDirection(i11);
        }

        @DoNotInline
        public static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            marginLayoutParams.setLayoutDirection(i11);
        }

        @DoNotInline
        public static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            marginLayoutParams.setMarginEnd(i11);
        }

        @DoNotInline
        public static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            marginLayoutParams.setMarginStart(i11);
        }
    }

    private MarginLayoutParamsCompat() {
    }

    public static int getLayoutDirection(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        int a11 = Api17Impl.a(marginLayoutParams);
        if (a11 == 0 || a11 == 1) {
            return a11;
        }
        return 0;
    }

    public static int getMarginEnd(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Api17Impl.b(marginLayoutParams);
    }

    public static int getMarginStart(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Api17Impl.c(marginLayoutParams);
    }

    public static boolean isMarginRelative(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Api17Impl.d(marginLayoutParams);
    }

    public static void resolveLayoutDirection(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
        Api17Impl.e(marginLayoutParams, i11);
    }

    public static void setLayoutDirection(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
        Api17Impl.f(marginLayoutParams, i11);
    }

    public static void setMarginEnd(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
        Api17Impl.g(marginLayoutParams, i11);
    }

    public static void setMarginStart(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
        Api17Impl.h(marginLayoutParams, i11);
    }
}
