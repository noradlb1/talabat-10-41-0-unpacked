package j$.util;

import j$.util.function.Consumer;
import j$.util.function.K;
import java.util.Comparator;
import java.util.Objects;

final class T extends C0189n implements D {
    T() {
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.n(this, consumer);
    }

    public final void c(K k11) {
        Objects.requireNonNull(k11);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.g(this, consumer);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    public final boolean j(K k11) {
        Objects.requireNonNull(k11);
        return false;
    }
}
