package j$.util.stream;

import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Objects;

final class T3 implements Consumer, Spliterator {

    /* renamed from: a  reason: collision with root package name */
    int f29041a = -2;

    /* renamed from: b  reason: collision with root package name */
    Object f29042b;

    /* renamed from: c  reason: collision with root package name */
    Z2 f29043c;

    T3(Object obj) {
        this.f29042b = obj;
    }

    public final boolean a(Consumer consumer) {
        Objects.requireNonNull(consumer);
        if (this.f29041a != -2) {
            return false;
        }
        consumer.accept(this.f29042b);
        this.f29041a = -1;
        return true;
    }

    public final void accept(Object obj) {
        int i11 = this.f29041a;
        if (i11 == 0) {
            this.f29042b = obj;
            this.f29041a = i11 + 1;
        } else if (i11 > 0) {
            if (this.f29043c == null) {
                Z2 z22 = new Z2();
                this.f29043c = z22;
                z22.accept(this.f29042b);
                this.f29041a++;
            }
            this.f29043c.accept(obj);
        } else {
            throw new IllegalStateException();
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final /* bridge */ /* synthetic */ int characteristics() {
        return 17488;
    }

    public final long estimateSize() {
        return (long) ((-this.f29041a) - 1);
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        if (this.f29041a == -2) {
            consumer.accept(this.f29042b);
            this.f29041a = -1;
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

    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return null;
    }
}
