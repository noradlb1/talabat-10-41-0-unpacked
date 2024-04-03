package j$.util;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import j$.util.function.Consumer;
import j$.util.function.H;
import j$.util.function.K;
import java.util.NoSuchElementException;
import java.util.Objects;

final class M implements PrimitiveIterator$OfInt, K, Iterator {

    /* renamed from: a  reason: collision with root package name */
    boolean f28555a = false;

    /* renamed from: b  reason: collision with root package name */
    int f28556b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ D f28557c;

    M(D d11) {
        this.f28557c = d11;
    }

    public final void accept(int i11) {
        this.f28555a = true;
        this.f28556b = i11;
    }

    /* renamed from: c */
    public final void forEachRemaining(K k11) {
        Objects.requireNonNull(k11);
        while (hasNext()) {
            k11.accept(nextInt());
        }
    }

    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof K) {
            forEachRemaining((K) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!a0.f28601a) {
            while (hasNext()) {
                consumer.accept(Integer.valueOf(nextInt()));
            }
            return;
        }
        a0.a(M.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
        throw null;
    }

    public final boolean hasNext() {
        if (!this.f28555a) {
            this.f28557c.j(this);
        }
        return this.f28555a;
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }

    public final Integer next() {
        if (!a0.f28601a) {
            return Integer.valueOf(nextInt());
        }
        a0.a(M.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
        throw null;
    }

    public final int nextInt() {
        if (this.f28555a || hasNext()) {
            this.f28555a = false;
            return this.f28556b;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
    }
}
