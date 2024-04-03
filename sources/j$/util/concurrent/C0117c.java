package j$.util.concurrent;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: j$.util.concurrent.c  reason: case insensitive filesystem */
abstract class C0117c implements Collection, Serializable {
    private static final long serialVersionUID = 7249069246763182397L;

    /* renamed from: a  reason: collision with root package name */
    final ConcurrentHashMap f28705a;

    C0117c(ConcurrentHashMap concurrentHashMap) {
        this.f28705a = concurrentHashMap;
    }

    public final void clear() {
        this.f28705a.clear();
    }

    public abstract boolean contains(Object obj);

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean containsAll(java.util.Collection r2) {
        /*
            r1 = this;
            if (r2 == r1) goto L_0x001a
            java.util.Iterator r2 = r2.iterator()
        L_0x0006:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x001a
            java.lang.Object r0 = r2.next()
            if (r0 == 0) goto L_0x0018
            boolean r0 = r1.contains(r0)
            if (r0 != 0) goto L_0x0006
        L_0x0018:
            r2 = 0
            return r2
        L_0x001a:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.C0117c.containsAll(java.util.Collection):boolean");
    }

    public final boolean isEmpty() {
        return this.f28705a.isEmpty();
    }

    public abstract Iterator iterator();

    public abstract boolean remove(Object obj);

    public boolean removeAll(Collection collection) {
        collection.getClass();
        E[] eArr = this.f28705a.table;
        boolean z11 = false;
        if (eArr == null) {
            return false;
        }
        if (!(collection instanceof Set) || collection.size() <= eArr.length) {
            for (Object remove : collection) {
                z11 |= remove(remove);
            }
        } else {
            Iterator it = iterator();
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z11 = true;
                }
            }
        }
        return z11;
    }

    public final boolean retainAll(Collection collection) {
        collection.getClass();
        Iterator it = iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public final int size() {
        return this.f28705a.size();
    }

    public final Object[] toArray() {
        long mappingCount = this.f28705a.mappingCount();
        if (mappingCount <= 2147483639) {
            int i11 = (int) mappingCount;
            Object[] objArr = new Object[i11];
            Iterator it = iterator();
            int i12 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                if (i12 == i11) {
                    int i13 = 2147483639;
                    if (i11 < 2147483639) {
                        if (i11 < 1073741819) {
                            i13 = (i11 >>> 1) + 1 + i11;
                        }
                        objArr = Arrays.copyOf(objArr, i13);
                        i11 = i13;
                    } else {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                }
                objArr[i12] = next;
                i12++;
            }
            return i12 == i11 ? objArr : Arrays.copyOf(objArr, i12);
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    public final Object[] toArray(Object[] objArr) {
        long mappingCount = this.f28705a.mappingCount();
        if (mappingCount <= 2147483639) {
            int i11 = (int) mappingCount;
            Object[] objArr2 = objArr.length >= i11 ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i11);
            int length = objArr2.length;
            Iterator it = iterator();
            int i12 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                if (i12 == length) {
                    int i13 = 2147483639;
                    if (length < 2147483639) {
                        if (length < 1073741819) {
                            i13 = (length >>> 1) + 1 + length;
                        }
                        objArr2 = Arrays.copyOf(objArr2, i13);
                        length = i13;
                    } else {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                }
                objArr2[i12] = next;
                i12++;
            }
            if (objArr != objArr2 || i12 >= length) {
                return i12 == length ? objArr2 : Arrays.copyOf(objArr2, i12);
            }
            objArr2[i12] = null;
            return objArr2;
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        Iterator it = iterator();
        if (it.hasNext()) {
            while (true) {
                Object next = it.next();
                if (next == this) {
                    next = "(this Collection)";
                }
                sb2.append(next);
                if (!it.hasNext()) {
                    break;
                }
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }
}
