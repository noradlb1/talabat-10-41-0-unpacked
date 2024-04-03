package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.ArrayDeque;

/* renamed from: j$.util.stream.k1  reason: case insensitive filesystem */
final class C0246k1 extends C0251l1 {
    C0246k1(H0 h02) {
        super(h02);
    }

    public final boolean a(Consumer consumer) {
        H0 f11;
        if (!h()) {
            return false;
        }
        boolean a11 = this.f29175d.a(consumer);
        if (!a11) {
            if (this.f29174c != null || (f11 = C0251l1.f(this.f29176e)) == null) {
                this.f29172a = null;
            } else {
                Spliterator spliterator = f11.spliterator();
                this.f29175d = spliterator;
                return spliterator.a(consumer);
            }
        }
        return a11;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (this.f29172a != null) {
            if (this.f29175d == null) {
                Spliterator spliterator = this.f29174c;
                if (spliterator == null) {
                    ArrayDeque g11 = g();
                    while (true) {
                        H0 f11 = C0251l1.f(g11);
                        if (f11 != null) {
                            f11.forEach(consumer);
                        } else {
                            this.f29172a = null;
                            return;
                        }
                    }
                } else {
                    spliterator.forEachRemaining(consumer);
                }
            } else {
                do {
                } while (a(consumer));
            }
        }
    }
}
