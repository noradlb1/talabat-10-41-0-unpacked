package com.nineoldandroids.util;

public abstract class FloatProperty<T> extends Property<T, Float> {
    public FloatProperty(String str) {
        super(Float.class, str);
    }

    public abstract void setValue(T t11, float f11);

    public final void set(T t11, Float f11) {
        setValue(t11, f11.floatValue());
    }
}
