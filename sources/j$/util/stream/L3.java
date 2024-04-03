package j$.util.stream;

import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Objects;

final class L3 extends N3 implements Spliterator, Consumer {

    /* renamed from: f  reason: collision with root package name */
    Object f28972f;

    L3(Spliterator spliterator, long j11, long j12) {
        super(spliterator, j11, j12);
    }

    L3(Spliterator spliterator, L3 l32) {
        super(spliterator, l32);
    }

    public final boolean a(Consumer consumer) {
        Objects.requireNonNull(consumer);
        while (s() != M3.NO_MORE && this.f28989a.a(this)) {
            if (q(1) == 1) {
                consumer.accept(this.f28972f);
                this.f28972f = null;
                return true;
            }
        }
        return false;
    }

    public final void accept(Object obj) {
        this.f28972f = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        C0248k3 k3Var = null;
        while (true) {
            M3 s11 = s();
            if (s11 != M3.NO_MORE) {
                M3 m32 = M3.MAYBE_MORE;
                Spliterator spliterator = this.f28989a;
                if (s11 == m32) {
                    int i11 = this.f28991c;
                    if (k3Var == null) {
                        k3Var = new C0248k3(i11);
                    } else {
                        k3Var.f29178a = 0;
                    }
                    long j11 = 0;
                    while (spliterator.a(k3Var)) {
                        j11++;
                        if (j11 >= ((long) i11)) {
                            break;
                        }
                    }
                    if (j11 != 0) {
                        long q11 = q(j11);
                        for (int i12 = 0; ((long) i12) < q11; i12++) {
                            consumer.accept(k3Var.f29170b[i12]);
                        }
                    } else {
                        return;
                    }
                } else {
                    spliterator.forEachRemaining(consumer);
                    return;
                }
            } else {
                return;
            }
        }
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

    /* access modifiers changed from: protected */
    public final Spliterator r(Spliterator spliterator) {
        return new L3(spliterator, this);
    }
}
