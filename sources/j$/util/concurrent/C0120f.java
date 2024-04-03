package j$.util.concurrent;

import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: j$.util.concurrent.f  reason: case insensitive filesystem */
final class C0120f extends C0117c implements Set, j$.util.Set {
    private static final long serialVersionUID = 2249069246763182397L;

    C0120f(ConcurrentHashMap concurrentHashMap) {
        super(concurrentHashMap);
    }

    public final boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        return this.f28705a.putVal(entry.getKey(), entry.getValue(), false) == null;
    }

    public final boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (this.f28705a.putVal(entry.getKey(), entry.getValue(), false) == null) {
                z11 = true;
            }
        }
        return z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r2.f28705a.get((r0 = r3.getKey()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        r3 = (r3 = (java.util.Map.Entry) r3).getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean contains(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof java.util.Map.Entry
            if (r0 == 0) goto L_0x0024
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r0 = r3.getKey()
            if (r0 == 0) goto L_0x0024
            j$.util.concurrent.ConcurrentHashMap r1 = r2.f28705a
            java.lang.Object r0 = r1.get(r0)
            if (r0 == 0) goto L_0x0024
            java.lang.Object r3 = r3.getValue()
            if (r3 == 0) goto L_0x0024
            if (r3 == r0) goto L_0x0022
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0024
        L_0x0022:
            r3 = 1
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.C0120f.contains(java.lang.Object):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = (java.util.Set) r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r2) {
        /*
            r1 = this;
            boolean r0 = r2 instanceof java.util.Set
            if (r0 == 0) goto L_0x0016
            java.util.Set r2 = (java.util.Set) r2
            if (r2 == r1) goto L_0x0014
            boolean r0 = r1.containsAll(r2)
            if (r0 == 0) goto L_0x0016
            boolean r2 = r2.containsAll(r1)
            if (r2 == 0) goto L_0x0016
        L_0x0014:
            r2 = 1
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.C0120f.equals(java.lang.Object):boolean");
    }

    public final void forEach(Consumer consumer) {
        consumer.getClass();
        E[] eArr = this.f28705a.table;
        if (eArr != null) {
            N n11 = new N(eArr, eArr.length, 0, eArr.length);
            while (true) {
                E f11 = n11.f();
                if (f11 != null) {
                    consumer.accept(new C0128n(f11.f28632b, f11.f28633c, this.f28705a));
                } else {
                    return;
                }
            }
        }
    }

    public final /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final int hashCode() {
        E[] eArr = this.f28705a.table;
        int i11 = 0;
        if (eArr != null) {
            N n11 = new N(eArr, eArr.length, 0, eArr.length);
            while (true) {
                E f11 = n11.f();
                if (f11 == null) {
                    break;
                }
                i11 += f11.hashCode();
            }
        }
        return i11;
    }

    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f28705a;
        E[] eArr = concurrentHashMap.table;
        int length = eArr == null ? 0 : eArr.length;
        return new C0119e(eArr, length, length, concurrentHashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r3 = (java.util.Map.Entry) r3;
        r0 = r3.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r3 = r3.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof java.util.Map.Entry
            if (r0 == 0) goto L_0x001c
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r0 = r3.getKey()
            if (r0 == 0) goto L_0x001c
            java.lang.Object r3 = r3.getValue()
            if (r3 == 0) goto L_0x001c
            j$.util.concurrent.ConcurrentHashMap r1 = r2.f28705a
            boolean r3 = r1.remove(r0, r3)
            if (r3 == 0) goto L_0x001c
            r3 = 1
            goto L_0x001d
        L_0x001c:
            r3 = 0
        L_0x001d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.C0120f.remove(java.lang.Object):boolean");
    }

    public final boolean removeIf(Predicate predicate) {
        return this.f28705a.removeEntryIf(predicate);
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
        return new C0121g(eArr, length, 0, length, j11, concurrentHashMap);
    }

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, intFunction);
    }

    public final /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, IntFunction.VivifiedWrapper.convert(intFunction));
    }
}
