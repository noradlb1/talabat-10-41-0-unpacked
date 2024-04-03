package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static void a(@NonNull Window window, boolean z11) {
            int i11;
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z11) {
                i11 = systemUiVisibility & -1793;
            } else {
                i11 = systemUiVisibility | 1792;
            }
            decorView.setSystemUiVisibility(i11);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static <T> T a(Window window, int i11) {
            return window.requireViewById(i11);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static void a(@NonNull Window window, boolean z11) {
            window.setDecorFitsSystemWindows(z11);
        }
    }

    private WindowCompat() {
    }

    @NonNull
    public static WindowInsetsControllerCompat getInsetsController(@NonNull Window window, @NonNull View view) {
        return new WindowInsetsControllerCompat(window, view);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Window window, @IdRes int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) Api28Impl.a(window, i11);
        }
        T findViewById = window.findViewById(i11);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    }

    public static void setDecorFitsSystemWindows(@NonNull Window window, boolean z11) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(window, z11);
        } else {
            Api16Impl.a(window, z11);
        }
    }
}
