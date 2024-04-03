package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

class ViewUtils {
    private static final ViewUtilsBase IMPL;
    private static final String TAG = "ViewUtils";

    /* renamed from: a  reason: collision with root package name */
    public static final Property<View, Float> f37822a = new Property<View, Float>(Float.class, "translationAlpha") {
        public Float get(View view) {
            return Float.valueOf(ViewUtils.c(view));
        }

        public void set(View view, Float f11) {
            ViewUtils.h(view, f11.floatValue());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final Property<View, Rect> f37823b = new Property<View, Rect>(Rect.class, "clipBounds") {
        public Rect get(View view) {
            return ViewCompat.getClipBounds(view);
        }

        public void set(View view, Rect rect) {
            ViewCompat.setClipBounds(view, rect);
        }
    };

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            IMPL = new ViewUtilsApi29();
        } else {
            IMPL = new ViewUtilsApi23();
        }
    }

    private ViewUtils() {
    }

    public static void a(@NonNull View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    public static ViewOverlayImpl b(@NonNull View view) {
        return new ViewOverlayApi18(view);
    }

    public static float c(@NonNull View view) {
        return IMPL.getTransitionAlpha(view);
    }

    public static WindowIdImpl d(@NonNull View view) {
        return new WindowIdApi18(view);
    }

    public static void e(@NonNull View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    public static void f(@NonNull View view, @Nullable Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    public static void g(@NonNull View view, int i11, int i12, int i13, int i14) {
        IMPL.setLeftTopRightBottom(view, i11, i12, i13, i14);
    }

    public static void h(@NonNull View view, float f11) {
        IMPL.setTransitionAlpha(view, f11);
    }

    public static void i(@NonNull View view, int i11) {
        IMPL.setTransitionVisibility(view, i11);
    }

    public static void j(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    public static void k(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }
}
