package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Supplier;

/* renamed from: j$.util.stream.e2  reason: case insensitive filesystem */
final class C0217e2 extends C0232h2 {
    C0217e2(Spliterator spliterator, int i11, boolean z11) {
        super(spliterator, i11, z11);
    }

    C0217e2(Supplier supplier, int i11, boolean z11) {
        super(supplier, i11, z11);
    }

    public final void forEach(Consumer consumer) {
        if (!isParallel()) {
            x1().forEachRemaining(consumer);
        } else {
            super.forEach(consumer);
        }
    }

    public final void forEachOrdered(Consumer consumer) {
        if (!isParallel()) {
            x1().forEachRemaining(consumer);
        } else {
            super.forEachOrdered(consumer);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean u1() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        throw new UnsupportedOperationException();
    }
}
