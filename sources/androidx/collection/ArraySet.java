package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = new int[0];
    private static final Object[] OBJECT = new Object[0];
    private static final String TAG = "ArraySet";
    @Nullable
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;
    @Nullable
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;

    /* renamed from: b  reason: collision with root package name */
    public Object[] f1020b;

    /* renamed from: c  reason: collision with root package name */
    public int f1021c;
    private MapCollections<E, E> mCollections;
    private int[] mHashes;

    public ArraySet() {
        this(0);
    }

    private void allocArrays(int i11) {
        if (i11 == 8) {
            synchronized (ArraySet.class) {
                Object[] objArr = sTwiceBaseCache;
                if (objArr != null) {
                    this.f1020b = objArr;
                    sTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    sTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i11 == 4) {
            synchronized (ArraySet.class) {
                Object[] objArr2 = sBaseCache;
                if (objArr2 != null) {
                    this.f1020b = objArr2;
                    sBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    sBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i11];
        this.f1020b = new Object[i11];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i11) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCacheSize < 10) {
                    objArr[0] = sTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i12 = i11 - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    sTwiceBaseCache = objArr;
                    sTwiceBaseCacheSize++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (sBaseCacheSize < 10) {
                    objArr[0] = sBaseCache;
                    objArr[1] = iArr;
                    for (int i13 = i11 - 1; i13 >= 2; i13--) {
                        objArr[i13] = null;
                    }
                    sBaseCache = objArr;
                    sBaseCacheSize++;
                }
            }
        }
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<E, E>() {
                public void a() {
                    ArraySet.this.clear();
                }

                public Object b(int i11, int i12) {
                    return ArraySet.this.f1020b[i11];
                }

                public Map<E, E> c() {
                    throw new UnsupportedOperationException("not a map");
                }

                public int d() {
                    return ArraySet.this.f1021c;
                }

                public int e(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                public int f(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                public void g(E e11, E e12) {
                    ArraySet.this.add(e11);
                }

                public void h(int i11) {
                    ArraySet.this.removeAt(i11);
                }

                public E i(int i11, E e11) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        return this.mCollections;
    }

    private int indexOf(Object obj, int i11) {
        int i12 = this.f1021c;
        if (i12 == 0) {
            return -1;
        }
        int a11 = ContainerHelpers.a(this.mHashes, i12, i11);
        if (a11 < 0 || obj.equals(this.f1020b[a11])) {
            return a11;
        }
        int i13 = a11 + 1;
        while (i13 < i12 && this.mHashes[i13] == i11) {
            if (obj.equals(this.f1020b[i13])) {
                return i13;
            }
            i13++;
        }
        int i14 = a11 - 1;
        while (i14 >= 0 && this.mHashes[i14] == i11) {
            if (obj.equals(this.f1020b[i14])) {
                return i14;
            }
            i14--;
        }
        return ~i13;
    }

    private int indexOfNull() {
        int i11 = this.f1021c;
        if (i11 == 0) {
            return -1;
        }
        int a11 = ContainerHelpers.a(this.mHashes, i11, 0);
        if (a11 < 0 || this.f1020b[a11] == null) {
            return a11;
        }
        int i12 = a11 + 1;
        while (i12 < i11 && this.mHashes[i12] == 0) {
            if (this.f1020b[i12] == null) {
                return i12;
            }
            i12++;
        }
        int i13 = a11 - 1;
        while (i13 >= 0 && this.mHashes[i13] == 0) {
            if (this.f1020b[i13] == null) {
                return i13;
            }
            i13--;
        }
        return ~i12;
    }

    public boolean add(@Nullable E e11) {
        int i11;
        int i12;
        if (e11 == null) {
            i12 = indexOfNull();
            i11 = 0;
        } else {
            int hashCode = e11.hashCode();
            i11 = hashCode;
            i12 = indexOf(e11, hashCode);
        }
        if (i12 >= 0) {
            return false;
        }
        int i13 = ~i12;
        int i14 = this.f1021c;
        int[] iArr = this.mHashes;
        if (i14 >= iArr.length) {
            int i15 = 8;
            if (i14 >= 8) {
                i15 = (i14 >> 1) + i14;
            } else if (i14 < 4) {
                i15 = 4;
            }
            Object[] objArr = this.f1020b;
            allocArrays(i15);
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1020b, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.f1021c);
        }
        int i16 = this.f1021c;
        if (i13 < i16) {
            int[] iArr3 = this.mHashes;
            int i17 = i13 + 1;
            System.arraycopy(iArr3, i13, iArr3, i17, i16 - i13);
            Object[] objArr2 = this.f1020b;
            System.arraycopy(objArr2, i13, objArr2, i17, this.f1021c - i13);
        }
        this.mHashes[i13] = i11;
        this.f1020b[i13] = e11;
        this.f1021c++;
        return true;
    }

    public void addAll(@NonNull ArraySet<? extends E> arraySet) {
        int i11 = arraySet.f1021c;
        ensureCapacity(this.f1021c + i11);
        if (this.f1021c != 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                add(arraySet.valueAt(i12));
            }
        } else if (i11 > 0) {
            System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, i11);
            System.arraycopy(arraySet.f1020b, 0, this.f1020b, 0, i11);
            this.f1021c = i11;
        }
    }

    public void clear() {
        int i11 = this.f1021c;
        if (i11 != 0) {
            freeArrays(this.mHashes, this.f1020b, i11);
            this.mHashes = INT;
            this.f1020b = OBJECT;
            this.f1021c = 0;
        }
    }

    public boolean contains(@Nullable Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity(int i11) {
        int[] iArr = this.mHashes;
        if (iArr.length < i11) {
            Object[] objArr = this.f1020b;
            allocArrays(i11);
            int i12 = this.f1021c;
            if (i12 > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i12);
                System.arraycopy(objArr, 0, this.f1020b, 0, this.f1021c);
            }
            freeArrays(iArr, objArr, this.f1021c);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i11 = 0;
            while (i11 < this.f1021c) {
                try {
                    if (!set.contains(valueAt(i11))) {
                        return false;
                    }
                    i11++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        int i11 = this.f1021c;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += iArr[i13];
        }
        return i12;
    }

    public boolean isEmpty() {
        return this.f1021c <= 0;
    }

    public Iterator<E> iterator() {
        return getCollection().getKeySet().iterator();
    }

    public boolean remove(@Nullable Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public boolean removeAll(@NonNull ArraySet<? extends E> arraySet) {
        int i11 = arraySet.f1021c;
        int i12 = this.f1021c;
        for (int i13 = 0; i13 < i11; i13++) {
            remove(arraySet.valueAt(i13));
        }
        if (i12 != this.f1021c) {
            return true;
        }
        return false;
    }

    public E removeAt(int i11) {
        E[] eArr = this.f1020b;
        E e11 = eArr[i11];
        int i12 = this.f1021c;
        if (i12 <= 1) {
            freeArrays(this.mHashes, eArr, i12);
            this.mHashes = INT;
            this.f1020b = OBJECT;
            this.f1021c = 0;
        } else {
            int[] iArr = this.mHashes;
            int i13 = 8;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                int i14 = i12 - 1;
                this.f1021c = i14;
                if (i11 < i14) {
                    int i15 = i11 + 1;
                    System.arraycopy(iArr, i15, iArr, i11, i14 - i11);
                    Object[] objArr = this.f1020b;
                    System.arraycopy(objArr, i15, objArr, i11, this.f1021c - i11);
                }
                this.f1020b[this.f1021c] = null;
            } else {
                if (i12 > 8) {
                    i13 = i12 + (i12 >> 1);
                }
                allocArrays(i13);
                this.f1021c--;
                if (i11 > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i11);
                    System.arraycopy(eArr, 0, this.f1020b, 0, i11);
                }
                int i16 = this.f1021c;
                if (i11 < i16) {
                    int i17 = i11 + 1;
                    System.arraycopy(iArr, i17, this.mHashes, i11, i16 - i11);
                    System.arraycopy(eArr, i17, this.f1020b, i11, this.f1021c - i11);
                }
            }
        }
        return e11;
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z11 = false;
        for (int i11 = this.f1021c - 1; i11 >= 0; i11--) {
            if (!collection.contains(this.f1020b[i11])) {
                removeAt(i11);
                z11 = true;
            }
        }
        return z11;
    }

    public int size() {
        return this.f1021c;
    }

    @NonNull
    public Object[] toArray() {
        int i11 = this.f1021c;
        Object[] objArr = new Object[i11];
        System.arraycopy(this.f1020b, 0, objArr, 0, i11);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f1021c * 14);
        sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i11 = 0; i11 < this.f1021c; i11++) {
            if (i11 > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            Object valueAt = valueAt(i11);
            if (valueAt != this) {
                sb2.append(valueAt);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append(AbstractJsonLexerKt.END_OBJ);
        return sb2.toString();
    }

    @Nullable
    public E valueAt(int i11) {
        return this.f1020b[i11];
    }

    public ArraySet(int i11) {
        if (i11 == 0) {
            this.mHashes = INT;
            this.f1020b = OBJECT;
        } else {
            allocArrays(i11);
        }
        this.f1021c = 0;
    }

    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.f1021c) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1021c);
        }
        System.arraycopy(this.f1020b, 0, tArr, 0, this.f1021c);
        int length = tArr.length;
        int i11 = this.f1021c;
        if (length > i11) {
            tArr[i11] = null;
        }
        return tArr;
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        boolean z11 = false;
        for (Object remove : collection) {
            z11 |= remove(remove);
        }
        return z11;
    }

    public ArraySet(@Nullable ArraySet<E> arraySet) {
        this();
        if (arraySet != null) {
            addAll(arraySet);
        }
    }

    public boolean addAll(@NonNull Collection<? extends E> collection) {
        ensureCapacity(this.f1021c + collection.size());
        boolean z11 = false;
        for (Object add : collection) {
            z11 |= add(add);
        }
        return z11;
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    public ArraySet(@Nullable Collection<E> collection) {
        this();
        if (collection != null) {
            addAll(collection);
        }
    }
}
