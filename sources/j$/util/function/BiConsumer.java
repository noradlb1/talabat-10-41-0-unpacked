package j$.util.function;

import j$.util.concurrent.S;
import java.util.Objects;

public interface BiConsumer<T, U> {

    /* renamed from: j$.util.function.BiConsumer$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<T, U> {
        public static BiConsumer $default$andThen(BiConsumer biConsumer, BiConsumer biConsumer2) {
            Objects.requireNonNull(biConsumer2);
            return new S(1, biConsumer, biConsumer2);
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements BiConsumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.BiConsumer f28784a;

        private /* synthetic */ VivifiedWrapper(java.util.function.BiConsumer biConsumer) {
            this.f28784a = biConsumer;
        }

        public static /* synthetic */ BiConsumer convert(java.util.function.BiConsumer biConsumer) {
            if (biConsumer == null) {
                return null;
            }
            return biConsumer instanceof Wrapper ? BiConsumer.this : new VivifiedWrapper(biConsumer);
        }

        public final /* synthetic */ void accept(Object obj, Object obj2) {
            this.f28784a.accept(obj, obj2);
        }

        public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return convert(this.f28784a.andThen(Wrapper.convert(biConsumer)));
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f28784a;
            }
            return this.f28784a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f28784a.hashCode();
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.function.BiConsumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.BiConsumer convert(BiConsumer biConsumer) {
            if (biConsumer == null) {
                return null;
            }
            return biConsumer instanceof VivifiedWrapper ? ((VivifiedWrapper) biConsumer).f28784a : new Wrapper();
        }

        public final /* synthetic */ void accept(Object obj, Object obj2) {
            BiConsumer.this.accept(obj, obj2);
        }

        public final /* synthetic */ java.util.function.BiConsumer andThen(java.util.function.BiConsumer biConsumer) {
            return convert(BiConsumer.this.andThen(VivifiedWrapper.convert(biConsumer)));
        }

        public final /* synthetic */ boolean equals(Object obj) {
            BiConsumer biConsumer = BiConsumer.this;
            if (obj instanceof Wrapper) {
                obj = BiConsumer.this;
            }
            return biConsumer.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return BiConsumer.this.hashCode();
        }
    }

    void accept(T t11, U u11);

    BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> biConsumer);
}
