package j$.util.function;

public interface ToDoubleFunction<T> {

    public final /* synthetic */ class VivifiedWrapper implements ToDoubleFunction {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.ToDoubleFunction f28822a;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToDoubleFunction toDoubleFunction) {
            this.f28822a = toDoubleFunction;
        }

        public static /* synthetic */ ToDoubleFunction convert(java.util.function.ToDoubleFunction toDoubleFunction) {
            if (toDoubleFunction == null) {
                return null;
            }
            return toDoubleFunction instanceof K0 ? ((K0) toDoubleFunction).f28808a : new VivifiedWrapper(toDoubleFunction);
        }

        public final /* synthetic */ double applyAsDouble(Object obj) {
            return this.f28822a.applyAsDouble(obj);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f28822a;
            }
            return this.f28822a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f28822a.hashCode();
        }
    }

    double applyAsDouble(Object obj);
}
