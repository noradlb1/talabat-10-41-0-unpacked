package j$.util.stream;

import j$.util.A;
import j$.util.D;
import j$.util.G;
import j$.util.Spliterator;
import j$.util.function.Supplier;
import java.util.Objects;

public final class StreamSupport {
    public static DoubleStream a(A a11) {
        return new C(a11, C0213d3.h(a11));
    }

    public static IntStream b(D d11) {
        return new C0210d0(d11, C0213d3.h(d11));
    }

    public static LongStream c(G g11) {
        return new C0245k0(g11, C0213d3.h(g11));
    }

    public static <T> Stream<T> stream(Spliterator<T> spliterator, boolean z11) {
        Objects.requireNonNull(spliterator);
        return new C0217e2((Spliterator) spliterator, C0213d3.h(spliterator), z11);
    }

    public static <T> Stream<T> stream(Supplier<? extends Spliterator<T>> supplier, int i11, boolean z11) {
        Objects.requireNonNull(supplier);
        return new C0217e2((Supplier) supplier, i11 & C0213d3.f29109f, z11);
    }
}
