package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

public final class ObjectHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final BiPredicate<Object, Object> f14529a = new BiObjectPredicate();

    public static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        public boolean test(Object obj, Object obj2) {
            return ObjectHelper.equals(obj, obj2);
        }
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static int compare(int i11, int i12) {
        if (i11 < i12) {
            return -1;
        }
        return i11 > i12 ? 1 : 0;
    }

    public static int compare(long j11, long j12) {
        int i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
        if (i11 < 0) {
            return -1;
        }
        return i11 > 0 ? 1 : 0;
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> BiPredicate<T, T> equalsPredicate() {
        return f14529a;
    }

    public static int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static <T> T requireNonNull(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static int verifyPositive(int i11, String str) {
        if (i11 > 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i11);
    }

    @Deprecated
    public static long requireNonNull(long j11, String str) {
        throw new InternalError("Null check on a primitive: " + str);
    }

    public static long verifyPositive(long j11, String str) {
        if (j11 > 0) {
            return j11;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j11);
    }
}
