package com.nineoldandroids.util;

public abstract class IntProperty<T> extends Property<T, Integer> {
    public IntProperty(String str) {
        super(Integer.class, str);
    }

    public abstract void setValue(T t11, int i11);

    public final void set(T t11, Integer num) {
        set(t11, Integer.valueOf(num.intValue()));
    }
}
