package j$.util.function;

public interface IntFunction<R> {

    public final /* synthetic */ class VivifiedWrapper implements IntFunction {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.IntFunction f28806a;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntFunction intFunction) {
            this.f28806a = intFunction;
        }

        public static /* synthetic */ IntFunction convert(java.util.function.IntFunction intFunction) {
            if (intFunction == null) {
                return null;
            }
            return intFunction instanceof L ? ((L) intFunction).f28809a : new VivifiedWrapper(intFunction);
        }

        public final /* synthetic */ Object apply(int i11) {
            return this.f28806a.apply(i11);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f28806a;
            }
            return this.f28806a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f28806a.hashCode();
        }
    }

    R apply(int i11);
}
