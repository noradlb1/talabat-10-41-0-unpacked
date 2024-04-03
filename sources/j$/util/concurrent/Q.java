package j$.util.concurrent;

import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import java.util.Iterator;

final class Q extends C0117c implements Collection {
    private static final long serialVersionUID = 2249069246763182397L;

    Q(ConcurrentHashMap concurrentHashMap) {
        super(concurrentHashMap);
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(Object obj) {
        return this.f28705a.containsValue(obj);
    }

    public final void forEach(Consumer consumer) {
        consumer.getClass();
        E[] eArr = this.f28705a.table;
        if (eArr != null) {
            N n11 = new N(eArr, eArr.length, 0, eArr.length);
            while (true) {
                E f11 = n11.f();
                if (f11 != null) {
                    consumer.accept(f11.f28633c);
                } else {
                    return;
                }
            }
        }
    }

    public final /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f28705a;
        E[] eArr = concurrentHashMap.table;
        int length = eArr == null ? 0 : eArr.length;
        return new C0126l(eArr, length, length, concurrentHashMap, 1);
    }

    public final boolean remove(Object obj) {
        C0115a aVar;
        if (obj == null) {
            return false;
        }
        Iterator it = iterator();
        do {
            aVar = (C0115a) it;
            if (!aVar.hasNext()) {
                return false;
            }
        } while (!obj.equals(((C0126l) it).next()));
        aVar.remove();
        return true;
    }

    public final boolean removeAll(java.util.Collection collection) {
        collection.getClass();
        Iterator it = iterator();
        boolean z11 = false;
        while (true) {
            C0115a aVar = (C0115a) it;
            if (!aVar.hasNext()) {
                return z11;
            }
            if (collection.contains(((C0126l) it).next())) {
                aVar.remove();
                z11 = true;
            }
        }
    }

    public final boolean removeIf(Predicate predicate) {
        return this.f28705a.removeValueIf(predicate);
    }

    public final /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
        return removeIf(Predicate.VivifiedWrapper.convert(predicate));
    }

    public final Spliterator spliterator() {
        ConcurrentHashMap concurrentHashMap = this.f28705a;
        long sumCount = concurrentHashMap.sumCount();
        E[] eArr = concurrentHashMap.table;
        int length = eArr == null ? 0 : eArr.length;
        long j11 = 0;
        if (sumCount >= 0) {
            j11 = sumCount;
        }
        return new C0127m(eArr, length, 0, length, j11, 1);
    }

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, intFunction);
    }

    public final /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, IntFunction.VivifiedWrapper.convert(intFunction));
    }
}
