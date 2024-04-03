package j$.sun.misc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static final b f28243b;

    /* renamed from: a  reason: collision with root package name */
    private final Unsafe f28244a;

    static {
        Field i11 = i();
        i11.setAccessible(true);
        try {
            f28243b = new b((Unsafe) i11.get((Object) null));
        } catch (IllegalAccessException e11) {
            throw new AssertionError("Couldn't get the Unsafe", e11);
        }
    }

    b(Unsafe unsafe) {
        this.f28244a = unsafe;
    }

    public static b h() {
        return f28243b;
    }

    private static Field i() {
        try {
            return Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e11) {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Unsafe.class.isAssignableFrom(field.getType())) {
                    return field;
                }
            }
            throw new AssertionError("Couldn't find the Unsafe", e11);
        }
    }

    public final int a(Class cls) {
        return this.f28244a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f28244a.arrayIndexScale(cls);
    }

    public final boolean c(Object obj, long j11, int i11, int i12) {
        return this.f28244a.compareAndSwapInt(obj, j11, i11, i12);
    }

    public final boolean d(Object obj, long j11, long j12, long j13) {
        return this.f28244a.compareAndSwapLong(obj, j11, j12, j13);
    }

    public final boolean e(Object obj, long j11, Object obj2, Object obj3) {
        return a.a(this.f28244a, obj, j11, obj2, obj3);
    }

    public final int f(Object obj, long j11) {
        int intVolatile;
        do {
            intVolatile = this.f28244a.getIntVolatile(obj, j11);
        } while (!this.f28244a.compareAndSwapInt(obj, j11, intVolatile, intVolatile - 4));
        return intVolatile;
    }

    public final Object g(Object obj, long j11) {
        return this.f28244a.getObjectVolatile(obj, j11);
    }

    public final long j(Class cls, String str) {
        try {
            return k(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e11) {
            throw new AssertionError("Cannot find field:", e11);
        }
    }

    public final long k(Field field) {
        return this.f28244a.objectFieldOffset(field);
    }

    public final void l(Object obj, long j11, Object obj2) {
        this.f28244a.putObjectVolatile(obj, j11, obj2);
    }
}
