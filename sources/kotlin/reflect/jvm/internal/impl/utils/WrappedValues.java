package kotlin.reflect.jvm.internal.impl.utils;

import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WrappedValues {
    private static final Object NULL_VALUE = new Object() {
        public String toString() {
            return "NULL_VALUE";
        }
    };
    public static volatile boolean throwWrappedProcessCanceledException = false;

    public static final class ThrowableWrapper {
        private final Throwable throwable;

        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            String str = i11 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i11 != 1 ? 3 : 2)];
            if (i11 != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i11 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i11 != 1) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            }
            String format = String.format(str, objArr);
            throw (i11 != 1 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        @NotNull
        public Throwable getThrowable() {
            Throwable th2 = this.throwable;
            if (th2 == null) {
                $$$reportNull$$$0(1);
            }
            return th2;
        }

        public String toString() {
            return this.throwable.toString();
        }

        private ThrowableWrapper(@NotNull Throwable th2) {
            if (th2 == null) {
                $$$reportNull$$$0(0);
            }
            this.throwable = th2;
        }
    }

    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th2) {
            super("Rethrow stored exception", th2);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = (i11 == 1 || i11 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i11 == 1 || i11 == 2) ? 2 : 3)];
        if (i11 == 1 || i11 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i11 != 3) {
            objArr[0] = "value";
        } else {
            objArr[0] = "throwable";
        }
        if (i11 == 1 || i11 == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (!(i11 == 1 || i11 == 2)) {
            if (i11 == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i11 != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String format = String.format(str, objArr);
        throw ((i11 == 1 || i11 == 2) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    @NotNull
    public static <V> Object escapeNull(@Nullable V v11) {
        if (v11 == null && (v11 = NULL_VALUE) == null) {
            $$$reportNull$$$0(1);
        }
        return v11;
    }

    @NotNull
    public static Object escapeThrowable(@NotNull Throwable th2) {
        if (th2 == null) {
            $$$reportNull$$$0(3);
        }
        return new ThrowableWrapper(th2);
    }

    @Nullable
    public static <V> V unescapeExceptionOrNull(@NotNull Object obj) {
        if (obj == null) {
            $$$reportNull$$$0(4);
        }
        return unescapeNull(unescapeThrowable(obj));
    }

    @Nullable
    public static <V> V unescapeNull(@NotNull Object obj) {
        if (obj == null) {
            $$$reportNull$$$0(0);
        }
        if (obj == NULL_VALUE) {
            return null;
        }
        return obj;
    }

    @Nullable
    public static <V> V unescapeThrowable(@Nullable Object obj) {
        if (!(obj instanceof ThrowableWrapper)) {
            return obj;
        }
        Throwable throwable = ((ThrowableWrapper) obj).getThrowable();
        if (!throwWrappedProcessCanceledException || !ExceptionUtilsKt.isProcessCanceledException(throwable)) {
            throw ExceptionUtilsKt.rethrow(throwable);
        }
        throw new WrappedProcessCanceledException(throwable);
    }
}
