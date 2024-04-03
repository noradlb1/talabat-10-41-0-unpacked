package androidx.core.util;

import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

public class ObjectsCompat {

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        @DoNotInline
        public static int b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    private ObjectsCompat() {
    }

    public static boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        return Api19Impl.a(obj, obj2);
    }

    public static int hash(@Nullable Object... objArr) {
        return Api19Impl.b(objArr);
    }

    public static int hashCode(@Nullable Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T t11) {
        t11.getClass();
        return t11;
    }

    @Nullable
    public static String toString(@Nullable Object obj, @Nullable String str) {
        return obj != null ? obj.toString() : str;
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T t11, @NonNull String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }
}
