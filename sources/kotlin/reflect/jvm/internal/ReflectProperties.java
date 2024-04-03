package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReflectProperties {

    public static class LazySoftVal<T> extends Val<T> implements Function0<T> {
        private final Function0<T> initializer;
        private volatile SoftReference<Object> value;

        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", MethodDescription.CONSTRUCTOR_INTERNAL_NAME}));
        }

        public LazySoftVal(@Nullable T t11, @NotNull Function0<T> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = function0;
            if (t11 != null) {
                this.value = new SoftReference<>(a(t11));
            }
        }

        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.value;
            if (softReference != null && (obj = softReference.get()) != null) {
                return b(obj);
            }
            T invoke = this.initializer.invoke();
            this.value = new SoftReference<>(a(invoke));
            return invoke;
        }
    }

    public static class LazyVal<T> extends Val<T> {
        private final Function0<T> initializer;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", MethodDescription.CONSTRUCTOR_INTERNAL_NAME}));
        }

        public LazyVal(@NotNull Function0<T> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = function0;
        }

        public T invoke() {
            Object obj = this.value;
            if (obj != null) {
                return b(obj);
            }
            T invoke = this.initializer.invoke();
            this.value = a(invoke);
            return invoke;
        }
    }

    public static abstract class Val<T> {
        private static final Object NULL_VALUE = new Object() {
        };

        public Object a(T t11) {
            return t11 == null ? NULL_VALUE : t11;
        }

        public T b(Object obj) {
            if (obj == NULL_VALUE) {
                return null;
            }
            return obj;
        }

        public final T getValue(Object obj, Object obj2) {
            return invoke();
        }

        public abstract T invoke();
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i11 == 1 || i11 == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @NotNull
    public static <T> LazyVal<T> lazy(@NotNull Function0<T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(0);
        }
        return new LazyVal<>(function0);
    }

    @NotNull
    public static <T> LazySoftVal<T> lazySoft(@Nullable T t11, @NotNull Function0<T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(1);
        }
        return new LazySoftVal<>(t11, function0);
    }

    @NotNull
    public static <T> LazySoftVal<T> lazySoft(@NotNull Function0<T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(2);
        }
        return lazySoft((Object) null, function0);
    }
}
