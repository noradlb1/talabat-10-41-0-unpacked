package j$.util;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.NoSuchElementException;
import java.util.Objects;

final class N implements PrimitiveIterator$OfLong, C0152f0, Iterator {

    /* renamed from: a  reason: collision with root package name */
    boolean f28558a = false;

    /* renamed from: b  reason: collision with root package name */
    long f28559b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ G f28560c;

    N(G g11) {
        this.f28560c = g11;
    }

    public final void accept(long j11) {
        this.f28558a = true;
        this.f28559b = j11;
    }

    /* renamed from: b */
    public final void forEachRemaining(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        while (hasNext()) {
            f0Var.accept(nextLong());
        }
    }

    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof C0152f0) {
            forEachRemaining((C0152f0) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!a0.f28601a) {
            while (hasNext()) {
                consumer.accept(Long.valueOf(nextLong()));
            }
            return;
        }
        a0.a(N.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
        throw null;
    }

    public final boolean hasNext() {
        if (!this.f28558a) {
            this.f28560c.e(this);
        }
        return this.f28558a;
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }

    public final Long next() {
        if (!a0.f28601a) {
            return Long.valueOf(nextLong());
        }
        a0.a(N.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
        throw null;
    }

    public final long nextLong() {
        if (this.f28558a || hasNext()) {
            this.f28558a = false;
            return this.f28559b;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
    }
}
