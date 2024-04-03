package j$.util;

import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Objects;

final class S extends C0189n implements A {
    S() {
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.m(this, consumer);
    }

    public final void d(C0165m mVar) {
        Objects.requireNonNull(mVar);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.f(this, consumer);
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

    public final boolean o(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return false;
    }
}
