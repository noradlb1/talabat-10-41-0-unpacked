package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class ObjectAnimatorUtils {
    private ObjectAnimatorUtils() {
    }

    public static <T> ObjectAnimator a(T t11, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t11, property, (TypeConverter) null, path);
    }
}
