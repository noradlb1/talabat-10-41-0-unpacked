package j$.util;

import j$.util.function.C0152f0;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import j$.util.function.K;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.SortedSet;

/* renamed from: j$.util.n  reason: case insensitive filesystem */
public abstract /* synthetic */ class C0189n {
    public static void f(A a11, Consumer consumer) {
        if (consumer instanceof C0165m) {
            a11.d((C0165m) consumer);
        } else if (!a0.f28601a) {
            Objects.requireNonNull(consumer);
            a11.d(new C0188m(consumer));
        } else {
            a0.a(a11.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
            throw null;
        }
    }

    public static void g(D d11, Consumer consumer) {
        if (consumer instanceof K) {
            d11.c((K) consumer);
        } else if (!a0.f28601a) {
            Objects.requireNonNull(consumer);
            d11.c(new C0192q(consumer));
        } else {
            a0.a(d11.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
            throw null;
        }
    }

    public static void h(G g11, Consumer consumer) {
        if (consumer instanceof C0152f0) {
            g11.b((C0152f0) consumer);
        } else if (!a0.f28601a) {
            Objects.requireNonNull(consumer);
            g11.b(new C0321t(consumer));
        } else {
            a0.a(g11.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
            throw null;
        }
    }

    public static long i(Spliterator spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1;
        }
        return spliterator.estimateSize();
    }

    public static boolean k(Spliterator spliterator, int i11) {
        return (spliterator.characteristics() & i11) == i11;
    }

    public static Spliterator l(SortedSet sortedSet) {
        return new C0325x(sortedSet, sortedSet);
    }

    public static boolean m(A a11, Consumer consumer) {
        if (consumer instanceof C0165m) {
            return a11.o((C0165m) consumer);
        }
        if (!a0.f28601a) {
            Objects.requireNonNull(consumer);
            return a11.o(new C0188m(consumer));
        }
        a0.a(a11.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
        throw null;
    }

    public static boolean n(D d11, Consumer consumer) {
        if (consumer instanceof K) {
            return d11.j((K) consumer);
        }
        if (!a0.f28601a) {
            Objects.requireNonNull(consumer);
            return d11.j(new C0192q(consumer));
        }
        a0.a(d11.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
        throw null;
    }

    public static boolean p(G g11, Consumer consumer) {
        if (consumer instanceof C0152f0) {
            return g11.e((C0152f0) consumer);
        }
        if (!a0.f28601a) {
            Objects.requireNonNull(consumer);
            return g11.e(new C0321t(consumer));
        }
        a0.a(g11.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
        throw null;
    }

    public static Spliterator q(LinkedHashSet linkedHashSet) {
        Objects.requireNonNull(linkedHashSet);
        return new X(17, (Collection) linkedHashSet);
    }

    public int characteristics() {
        return 16448;
    }

    public long estimateSize() {
        return 0;
    }

    public void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
    }

    public boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        return false;
    }

    public Spliterator trySplit() {
        return null;
    }
}
