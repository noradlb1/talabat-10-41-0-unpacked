package j$.util.function;

import j$.util.concurrent.S;
import java.util.Objects;

public interface Consumer<T> {

    /* renamed from: j$.util.function.Consumer$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static Consumer $default$andThen(Consumer consumer, Consumer consumer2) {
            Objects.requireNonNull(consumer2);
            return new S(3, consumer, consumer2);
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements Consumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.Consumer f28791a;

        private /* synthetic */ VivifiedWrapper(java.util.function.Consumer consumer) {
            this.f28791a = consumer;
        }

        public static /* synthetic */ Consumer convert(java.util.function.Consumer consumer) {
            if (consumer == null) {
                return null;
            }
            return consumer instanceof Wrapper ? Consumer.this : new VivifiedWrapper(consumer);
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f28791a.accept(obj);
        }

        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return convert(this.f28791a.andThen(Wrapper.convert(consumer)));
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f28791a;
            }
            return this.f28791a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f28791a.hashCode();
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.function.Consumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.Consumer convert(Consumer consumer) {
            if (consumer == null) {
                return null;
            }
            return consumer instanceof VivifiedWrapper ? ((VivifiedWrapper) consumer).f28791a : new Wrapper();
        }

        public final /* synthetic */ void accept(Object obj) {
            Consumer.this.accept(obj);
        }

        public final /* synthetic */ java.util.function.Consumer andThen(java.util.function.Consumer consumer) {
            return convert(Consumer.this.andThen(VivifiedWrapper.convert(consumer)));
        }

        public final /* synthetic */ boolean equals(Object obj) {
            Consumer consumer = Consumer.this;
            if (obj instanceof Wrapper) {
                obj = Consumer.this;
            }
            return consumer.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return Consumer.this.hashCode();
        }
    }

    void accept(T t11);

    Consumer<T> andThen(Consumer<? super T> consumer);
}
