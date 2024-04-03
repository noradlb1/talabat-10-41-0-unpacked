package j$.util.function;

import java.util.Objects;

public interface BiPredicate<T, U> {

    /* renamed from: j$.util.function.BiPredicate$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<T, U> {
        public static BiPredicate $default$and(BiPredicate biPredicate, BiPredicate biPredicate2) {
            Objects.requireNonNull(biPredicate2);
            return new C0143b(biPredicate, biPredicate2, 0);
        }

        public static BiPredicate $default$negate(BiPredicate biPredicate) {
            return new C0145c(0, biPredicate);
        }

        public static BiPredicate $default$or(BiPredicate biPredicate, BiPredicate biPredicate2) {
            Objects.requireNonNull(biPredicate2);
            return new C0143b(biPredicate, biPredicate2, 1);
        }
    }

    BiPredicate<T, U> and(BiPredicate<? super T, ? super U> biPredicate);

    BiPredicate<T, U> negate();

    BiPredicate<T, U> or(BiPredicate<? super T, ? super U> biPredicate);

    boolean test(T t11, U u11);
}
