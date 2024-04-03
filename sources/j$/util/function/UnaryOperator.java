package j$.util.function;

import j$.util.function.Function;

public interface UnaryOperator<T> extends Function<T, T> {

    public final /* synthetic */ class VivifiedWrapper implements UnaryOperator {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.UnaryOperator f28826a;

        private /* synthetic */ VivifiedWrapper(java.util.function.UnaryOperator unaryOperator) {
            this.f28826a = unaryOperator;
        }

        public static /* synthetic */ UnaryOperator convert(java.util.function.UnaryOperator unaryOperator) {
            if (unaryOperator == null) {
                return null;
            }
            return unaryOperator instanceof P0 ? ((P0) unaryOperator).f28818a : new VivifiedWrapper(unaryOperator);
        }

        public final /* synthetic */ Function andThen(Function function) {
            return Function.VivifiedWrapper.convert(this.f28826a.andThen(D.a(function)));
        }

        public final /* synthetic */ Object apply(Object obj) {
            return this.f28826a.apply(obj);
        }

        public final /* synthetic */ Function compose(Function function) {
            return Function.VivifiedWrapper.convert(this.f28826a.compose(D.a(function)));
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f28826a;
            }
            return this.f28826a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f28826a.hashCode();
        }
    }
}
