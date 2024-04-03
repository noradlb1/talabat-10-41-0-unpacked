package j$.util.function;

public interface ToLongFunction<T> {

    public final /* synthetic */ class VivifiedWrapper implements ToLongFunction {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.ToLongFunction f28824a;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToLongFunction toLongFunction) {
            this.f28824a = toLongFunction;
        }

        public static /* synthetic */ ToLongFunction convert(java.util.function.ToLongFunction toLongFunction) {
            if (toLongFunction == null) {
                return null;
            }
            return toLongFunction instanceof O0 ? ((O0) toLongFunction).f28816a : new VivifiedWrapper(toLongFunction);
        }

        public final /* synthetic */ long applyAsLong(Object obj) {
            return this.f28824a.applyAsLong(obj);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f28824a;
            }
            return this.f28824a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f28824a.hashCode();
        }
    }

    long applyAsLong(T t11);
}
