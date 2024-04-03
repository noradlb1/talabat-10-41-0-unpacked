package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.functions.BiPredicate;
import java.util.Objects;

public final class ObjectHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final BiPredicate<Object, Object> f18816a = new BiObjectPredicate();

    public static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        public boolean test(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> BiPredicate<T, T> equalsPredicate() {
        return f18816a;
    }

    public static int verifyPositive(int i11, String str) {
        if (i11 > 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i11);
    }

    public static long verifyPositive(long j11, String str) {
        if (j11 > 0) {
            return j11;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j11);
    }
}
