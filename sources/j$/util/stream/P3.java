package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Objects;

final class P3 extends C0223f3 {
    P3(C0314y0 y0Var, Spliterator spliterator, boolean z11) {
        super(y0Var, spliterator, z11);
    }

    P3(C0314y0 y0Var, C0194a aVar, boolean z11) {
        super(y0Var, aVar, z11);
    }

    public final boolean a(Consumer consumer) {
        Object obj;
        Objects.requireNonNull(consumer);
        boolean f11 = f();
        if (f11) {
            Z2 z22 = (Z2) this.f29150h;
            long j11 = this.f29149g;
            if (z22.f29133c == 0) {
                if (j11 < ((long) z22.f29132b)) {
                    obj = z22.f29075e[(int) j11];
                } else {
                    throw new IndexOutOfBoundsException(Long.toString(j11));
                }
            } else if (j11 < z22.count()) {
                int i11 = 0;
                while (i11 <= z22.f29133c) {
                    long j12 = z22.f29134d[i11];
                    Object[] objArr = z22.f29076f[i11];
                    if (j11 < ((long) objArr.length) + j12) {
                        obj = objArr[(int) (j11 - j12)];
                    } else {
                        i11++;
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(j11));
            } else {
                throw new IndexOutOfBoundsException(Long.toString(j11));
            }
            consumer.accept(obj);
        }
        return f11;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (this.f29150h != null || this.f29151i) {
            do {
            } while (a(consumer));
            return;
        }
        Objects.requireNonNull(consumer);
        h();
        O3 o32 = new O3(consumer, 1);
        this.f29144b.g1(this.f29146d, o32);
        this.f29151i = true;
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        Z2 z22 = new Z2();
        this.f29150h = z22;
        this.f29147e = this.f29144b.h1(new O3(z22, 0));
        this.f29148f = new C0194a(9, this);
    }

    /* access modifiers changed from: package-private */
    public final C0223f3 k(Spliterator spliterator) {
        return new P3(this.f29144b, spliterator, this.f29143a);
    }
}
