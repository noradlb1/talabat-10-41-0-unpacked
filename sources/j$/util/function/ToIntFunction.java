package j$.util.function;

public interface ToIntFunction<T> {

    public final /* synthetic */ class VivifiedWrapper implements ToIntFunction {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.ToIntFunction f28823a;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToIntFunction toIntFunction) {
            this.f28823a = toIntFunction;
        }

        public static /* synthetic */ ToIntFunction convert(java.util.function.ToIntFunction toIntFunction) {
            if (toIntFunction == null) {
                return null;
            }
            return toIntFunction instanceof M0 ? ((M0) toIntFunction).f28813a : new VivifiedWrapper(toIntFunction);
        }

        public final /* synthetic */ int applyAsInt(Object obj) {
            return this.f28823a.applyAsInt(obj);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f28823a;
            }
            return this.f28823a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f28823a.hashCode();
        }
    }

    int applyAsInt(T t11);
}
