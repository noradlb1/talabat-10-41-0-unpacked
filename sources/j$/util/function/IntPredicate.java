package j$.util.function;

import java.util.Objects;

public interface IntPredicate {

    /* renamed from: j$.util.function.IntPredicate$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static IntPredicate $default$and(IntPredicate intPredicate, IntPredicate intPredicate2) {
            Objects.requireNonNull(intPredicate2);
            return new M(intPredicate, intPredicate2, 1);
        }

        public static IntPredicate $default$negate(IntPredicate intPredicate) {
            return new C0145c(1, intPredicate);
        }

        public static IntPredicate $default$or(IntPredicate intPredicate, IntPredicate intPredicate2) {
            Objects.requireNonNull(intPredicate2);
            return new M(intPredicate, intPredicate2, 0);
        }
    }

    IntPredicate and(IntPredicate intPredicate);

    IntPredicate negate();

    IntPredicate or(IntPredicate intPredicate);

    boolean test(int i11);
}
