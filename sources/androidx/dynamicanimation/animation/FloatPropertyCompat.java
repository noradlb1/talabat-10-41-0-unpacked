package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> floatProperty) {
        return new FloatPropertyCompat<T>(floatProperty.getName()) {
            public float getValue(T t11) {
                return ((Float) floatProperty.get(t11)).floatValue();
            }

            public void setValue(T t11, float f11) {
                floatProperty.setValue(t11, f11);
            }
        };
    }

    public abstract float getValue(T t11);

    public abstract void setValue(T t11, float f11);
}
