package j$.util;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import j$.util.function.C0159j;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.NoSuchElementException;
import java.util.Objects;

final class O implements PrimitiveIterator$OfDouble, C0165m, Iterator {

    /* renamed from: a  reason: collision with root package name */
    boolean f28561a = false;

    /* renamed from: b  reason: collision with root package name */
    double f28562b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ A f28563c;

    O(A a11) {
        this.f28563c = a11;
    }

    public final void accept(double d11) {
        this.f28561a = true;
        this.f28562b = d11;
    }

    /* renamed from: d */
    public final void forEachRemaining(C0165m mVar) {
        Objects.requireNonNull(mVar);
        while (hasNext()) {
            mVar.accept(nextDouble());
        }
    }

    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof C0165m) {
            forEachRemaining((C0165m) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!a0.f28601a) {
            while (hasNext()) {
                consumer.accept(Double.valueOf(nextDouble()));
            }
            return;
        }
        a0.a(O.class, "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
        throw null;
    }

    public final boolean hasNext() {
        if (!this.f28561a) {
            this.f28563c.o(this);
        }
        return this.f28561a;
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }

    public final Double next() {
        if (!a0.f28601a) {
            return Double.valueOf(nextDouble());
        }
        a0.a(O.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
        throw null;
    }

    public final double nextDouble() {
        if (this.f28561a || hasNext()) {
            this.f28561a = false;
            return this.f28562b;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
    }
}
