package j$.util.stream;

import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import java.util.Collection;
import java.util.Objects;

final class L0 implements H0 {

    /* renamed from: a  reason: collision with root package name */
    private final Collection f28967a;

    L0(Collection collection) {
        this.f28967a = collection;
    }

    public final H0 a(int i11) {
        throw new IndexOutOfBoundsException();
    }

    public final long count() {
        return (long) this.f28967a.size();
    }

    public final void e(Object[] objArr, int i11) {
        for (Object obj : this.f28967a) {
            objArr[i11] = obj;
            i11++;
        }
    }

    public final void forEach(Consumer consumer) {
        Collection<Object> collection = this.f28967a;
        if (collection instanceof j$.util.Collection) {
            ((j$.util.Collection) collection).forEach(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        for (Object accept : collection) {
            consumer.accept(accept);
        }
    }

    public final /* synthetic */ int j() {
        return 0;
    }

    public final Object[] o(IntFunction intFunction) {
        Collection collection = this.f28967a;
        return collection.toArray((Object[]) intFunction.apply(collection.size()));
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.w0(this, j11, j12, intFunction);
    }

    public final Spliterator spliterator() {
        return Collection.EL.stream(this.f28967a).spliterator();
    }

    public final String toString() {
        java.util.Collection collection = this.f28967a;
        return String.format("CollectionNode[%d][%s]", new Object[]{Integer.valueOf(collection.size()), collection});
    }
}
