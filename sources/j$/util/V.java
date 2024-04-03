package j$.util;

import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Objects;

final class V extends C0189n implements Spliterator {
    V() {
    }

    public final boolean a(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return false;
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
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
}
