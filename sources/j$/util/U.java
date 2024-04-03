package j$.util;

import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Objects;

final class U extends C0189n implements G {
    U() {
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.p(this, consumer);
    }

    public final void b(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
    }

    public final boolean e(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return false;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.h(this, consumer);
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
