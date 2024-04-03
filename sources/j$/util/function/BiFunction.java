package j$.util.function;

import j$.util.concurrent.S;
import java.util.Objects;
import java.util.function.BinaryOperator;

public interface BiFunction<T, U, R> {

    /* renamed from: j$.util.function.BiFunction$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<T, U, R> {
        public static BiFunction $default$andThen(BiFunction biFunction, Function function) {
            Objects.requireNonNull(function);
            return new S(biFunction, function);
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements BiFunction {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.BiFunction f28786a;

        private /* synthetic */ VivifiedWrapper(java.util.function.BiFunction biFunction) {
            this.f28786a = biFunction;
        }

        public static /* synthetic */ BiFunction convert(java.util.function.BiFunction biFunction) {
            if (biFunction == null) {
                return null;
            }
            return biFunction instanceof C0141a ? ((C0141a) biFunction).f28830a : biFunction instanceof BinaryOperator ? C0149e.a((BinaryOperator) biFunction) : new VivifiedWrapper(biFunction);
        }

        public final /* synthetic */ BiFunction andThen(Function function) {
            return convert(this.f28786a.andThen(D.a(function)));
        }

        public final /* synthetic */ Object apply(Object obj, Object obj2) {
            return this.f28786a.apply(obj, obj2);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f28786a;
            }
            return this.f28786a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f28786a.hashCode();
        }
    }

    <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> function);

    R apply(T t11, U u11);
}
