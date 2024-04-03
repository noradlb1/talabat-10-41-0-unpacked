package j$.util.stream;

import j$.util.J;
import j$.util.Spliterator;
import java.util.ArrayDeque;

/* renamed from: j$.util.stream.j1  reason: case insensitive filesystem */
abstract class C0241j1 extends C0251l1 implements J {
    C0241j1(G0 g02) {
        super(g02);
    }

    /* renamed from: forEachRemaining */
    public final void d(Object obj) {
        if (this.f29172a != null) {
            if (this.f29175d == null) {
                Spliterator spliterator = this.f29174c;
                if (spliterator == null) {
                    ArrayDeque g11 = g();
                    while (true) {
                        G0 g02 = (G0) C0251l1.f(g11);
                        if (g02 != null) {
                            g02.d(obj);
                        } else {
                            this.f29172a = null;
                            return;
                        }
                    }
                } else {
                    ((J) spliterator).forEachRemaining(obj);
                }
            } else {
                do {
                } while (o(obj));
            }
        }
    }

    /* renamed from: tryAdvance */
    public final boolean o(Object obj) {
        G0 g02;
        if (!h()) {
            return false;
        }
        boolean tryAdvance = ((J) this.f29175d).tryAdvance(obj);
        if (!tryAdvance) {
            if (this.f29174c != null || (g02 = (G0) C0251l1.f(this.f29176e)) == null) {
                this.f29172a = null;
            } else {
                J spliterator = g02.spliterator();
                this.f29175d = spliterator;
                return spliterator.tryAdvance(obj);
            }
        }
        return tryAdvance;
    }
}
