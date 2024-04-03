package androidx.core.view;

import android.view.ScaleGestureDetector;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class ScaleGestureDetectorCompat {

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static boolean a(ScaleGestureDetector scaleGestureDetector) {
            return scaleGestureDetector.isQuickScaleEnabled();
        }

        @DoNotInline
        public static void b(ScaleGestureDetector scaleGestureDetector, boolean z11) {
            scaleGestureDetector.setQuickScaleEnabled(z11);
        }
    }

    private ScaleGestureDetectorCompat() {
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object obj) {
        return isQuickScaleEnabled((ScaleGestureDetector) obj);
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object obj, boolean z11) {
        setQuickScaleEnabled((ScaleGestureDetector) obj, z11);
    }

    public static boolean isQuickScaleEnabled(@NonNull ScaleGestureDetector scaleGestureDetector) {
        return Api19Impl.a(scaleGestureDetector);
    }

    public static void setQuickScaleEnabled(@NonNull ScaleGestureDetector scaleGestureDetector, boolean z11) {
        Api19Impl.b(scaleGestureDetector, z11);
    }
}
