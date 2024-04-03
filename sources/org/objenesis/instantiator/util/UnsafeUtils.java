package org.objenesis.instantiator.util;

import java.lang.reflect.Field;
import org.objenesis.ObjenesisException;
import sun.misc.Unsafe;

public final class UnsafeUtils {
    private static final Unsafe unsafe;

    static {
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            try {
                unsafe = (Unsafe) declaredField.get((Object) null);
            } catch (IllegalAccessException e11) {
                throw new ObjenesisException((Throwable) e11);
            }
        } catch (NoSuchFieldException e12) {
            throw new ObjenesisException((Throwable) e12);
        }
    }

    private UnsafeUtils() {
    }

    public static Unsafe getUnsafe() {
        return unsafe;
    }
}
