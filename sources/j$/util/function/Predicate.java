package j$.util.function;

import java.util.Objects;

public interface Predicate<T> {

    /* renamed from: j$.util.function.Predicate$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static Predicate $default$and(Predicate predicate, Predicate predicate2) {
            Objects.requireNonNull(predicate2);
            return new F0(predicate, predicate2, 0);
        }

        public static Predicate $default$negate(Predicate predicate) {
            return new C0145c(3, predicate);
        }

        public static Predicate $default$or(Predicate predicate, Predicate predicate2) {
            Objects.requireNonNull(predicate2);
            return new F0(predicate, predicate2, 1);
        }

        public static <T> Predicate<T> isEqual(Object obj) {
            return obj == null ? new E0() : new C0145c(2, obj);
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements Predicate {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.Predicate f28819a;

        private /* synthetic */ VivifiedWrapper(java.util.function.Predicate predicate) {
            this.f28819a = predicate;
        }

        public static /* synthetic */ Predicate convert(java.util.function.Predicate predicate) {
            if (predicate == null) {
                return null;
            }
            return predicate instanceof G0 ? ((G0) predicate).f28800a : new VivifiedWrapper(predicate);
        }

        public final /* synthetic */ Predicate and(Predicate predicate) {
            return convert(this.f28819a.and(G0.a(predicate)));
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f28819a;
            }
            return this.f28819a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f28819a.hashCode();
        }

        public final /* synthetic */ Predicate negate() {
            return convert(this.f28819a.negate());
        }

        public final /* synthetic */ Predicate or(Predicate predicate) {
            return convert(this.f28819a.or(G0.a(predicate)));
        }

        public final /* synthetic */ boolean test(Object obj) {
            return this.f28819a.test(obj);
        }
    }

    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> predicate);

    boolean test(T t11);
}
