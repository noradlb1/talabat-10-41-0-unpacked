package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class PathInterpolatorCompat {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static PathInterpolator a(float f11, float f12) {
            return new PathInterpolator(f11, f12);
        }

        @DoNotInline
        public static PathInterpolator b(float f11, float f12, float f13, float f14) {
            return new PathInterpolator(f11, f12, f13, f14);
        }

        @DoNotInline
        public static PathInterpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return Api21Impl.c(path);
    }

    @NonNull
    public static Interpolator create(float f11, float f12) {
        return Api21Impl.a(f11, f12);
    }

    @NonNull
    public static Interpolator create(float f11, float f12, float f13, float f14) {
        return Api21Impl.b(f11, f12, f13, f14);
    }
}
