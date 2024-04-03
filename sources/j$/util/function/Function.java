package j$.util.function;

import j$.util.function.UnaryOperator;
import java.util.Objects;
import java.util.function.UnaryOperator;

public interface Function<T, R> {

    /* renamed from: j$.util.function.Function$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<T, R> {
        public static Function $default$andThen(Function function, Function function2) {
            Objects.requireNonNull(function2);
            return new C(function, function2, 0);
        }

        public static Function $default$compose(Function function, Function function2) {
            Objects.requireNonNull(function2);
            return new C(function, function2, 1);
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements Function {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.Function f28799a;

        private /* synthetic */ VivifiedWrapper(java.util.function.Function function) {
            this.f28799a = function;
        }

        public static /* synthetic */ Function convert(java.util.function.Function function) {
            if (function == null) {
                return null;
            }
            return function instanceof D ? ((D) function).f28793a : function instanceof UnaryOperator ? UnaryOperator.VivifiedWrapper.convert((java.util.function.UnaryOperator) function) : new VivifiedWrapper(function);
        }

        public final /* synthetic */ Function andThen(Function function) {
            return convert(this.f28799a.andThen(D.a(function)));
        }

        public final /* synthetic */ Object apply(Object obj) {
            return this.f28799a.apply(obj);
        }

        public final /* synthetic */ Function compose(Function function) {
            return convert(this.f28799a.compose(D.a(function)));
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f28799a;
            }
            return this.f28799a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f28799a.hashCode();
        }
    }

    <V> Function<T, V> andThen(Function<? super R, ? extends V> function);

    R apply(T t11);

    <V> Function<V, R> compose(Function<? super V, ? extends T> function);
}
