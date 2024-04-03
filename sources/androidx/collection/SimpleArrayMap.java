package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    @Nullable
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    @Nullable
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.f1023a;
        this.mArray = ContainerHelpers.f1025c;
        this.mSize = 0;
    }

    private void allocArrays(int i11) {
        if (i11 == 8) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr = mTwiceBaseCache;
                if (objArr != null) {
                    this.mArray = objArr;
                    mTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i11 == 4) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr2 = mBaseCache;
                if (objArr2 != null) {
                    this.mArray = objArr2;
                    mBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i11];
        this.mArray = new Object[(i11 << 1)];
    }

    private static int binarySearchHashes(int[] iArr, int i11, int i12) {
        try {
            return ContainerHelpers.a(iArr, i11, i12);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i11) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i12 = (i11 << 1) - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i13 = (i11 << 1) - 1; i13 >= 2; i13--) {
                        objArr[i13] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public void clear() {
        int i11 = this.mSize;
        if (i11 > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = ContainerHelpers.f1023a;
            this.mArray = ContainerHelpers.f1025c;
            this.mSize = 0;
            freeArrays(iArr, objArr, i11);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public void ensureCapacity(int i11) {
        int i12 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i11) {
            Object[] objArr = this.mArray;
            allocArrays(i11);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i12);
                System.arraycopy(objArr, 0, this.mArray, 0, i12 << 1);
            }
            freeArrays(iArr, objArr, i12);
        }
        if (this.mSize != i12) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            int i11 = 0;
            while (i11 < this.mSize) {
                try {
                    Object keyAt = keyAt(i11);
                    Object valueAt = valueAt(i11);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                    i11++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i12 = 0;
            while (i12 < this.mSize) {
                try {
                    Object keyAt2 = keyAt(i12);
                    Object valueAt2 = valueAt(i12);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                    i12++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    @Nullable
    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v11) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.mArray[(indexOfKey << 1) + 1];
        }
        return v11;
    }

    public int hashCode() {
        int i11;
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i12 = this.mSize;
        int i13 = 1;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i12) {
            Object obj = objArr[i13];
            int i16 = iArr[i14];
            if (obj == null) {
                i11 = 0;
            } else {
                i11 = obj.hashCode();
            }
            i15 += i11 ^ i16;
            i14++;
            i13 += 2;
        }
        return i15;
    }

    /* access modifiers changed from: package-private */
    public int indexOf(Object obj, int i11) {
        int i12 = this.mSize;
        if (i12 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i12, i11);
        if (binarySearchHashes < 0 || obj.equals(this.mArray[binarySearchHashes << 1])) {
            return binarySearchHashes;
        }
        int i13 = binarySearchHashes + 1;
        while (i13 < i12 && this.mHashes[i13] == i11) {
            if (obj.equals(this.mArray[i13 << 1])) {
                return i13;
            }
            i13++;
        }
        int i14 = binarySearchHashes - 1;
        while (i14 >= 0 && this.mHashes[i14] == i11) {
            if (obj.equals(this.mArray[i14 << 1])) {
                return i14;
            }
            i14--;
        }
        return ~i13;
    }

    public int indexOfKey(@Nullable Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    public int indexOfNull() {
        int i11 = this.mSize;
        if (i11 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i11, 0);
        if (binarySearchHashes < 0 || this.mArray[binarySearchHashes << 1] == null) {
            return binarySearchHashes;
        }
        int i12 = binarySearchHashes + 1;
        while (i12 < i11 && this.mHashes[i12] == 0) {
            if (this.mArray[i12 << 1] == null) {
                return i12;
            }
            i12++;
        }
        int i13 = binarySearchHashes - 1;
        while (i13 >= 0 && this.mHashes[i13] == 0) {
            if (this.mArray[i13 << 1] == null) {
                return i13;
            }
            i13--;
        }
        return ~i12;
    }

    /* access modifiers changed from: package-private */
    public int indexOfValue(Object obj) {
        int i11 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i12 = 1; i12 < i11; i12 += 2) {
                if (objArr[i12] == null) {
                    return i12 >> 1;
                }
            }
            return -1;
        }
        for (int i13 = 1; i13 < i11; i13 += 2) {
            if (obj.equals(objArr[i13])) {
                return i13 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public K keyAt(int i11) {
        return this.mArray[i11 << 1];
    }

    @Nullable
    public V put(K k11, V v11) {
        int i11;
        int i12;
        int i13 = this.mSize;
        if (k11 == null) {
            i12 = indexOfNull();
            i11 = 0;
        } else {
            int hashCode = k11.hashCode();
            i11 = hashCode;
            i12 = indexOf(k11, hashCode);
        }
        if (i12 >= 0) {
            int i14 = (i12 << 1) + 1;
            V[] vArr = this.mArray;
            V v12 = vArr[i14];
            vArr[i14] = v11;
            return v12;
        }
        int i15 = ~i12;
        int[] iArr = this.mHashes;
        if (i13 >= iArr.length) {
            int i16 = 8;
            if (i13 >= 8) {
                i16 = (i13 >> 1) + i13;
            } else if (i13 < 4) {
                i16 = 4;
            }
            Object[] objArr = this.mArray;
            allocArrays(i16);
            if (i13 == this.mSize) {
                int[] iArr2 = this.mHashes;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
                }
                freeArrays(iArr, objArr, i13);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i15 < i13) {
            int[] iArr3 = this.mHashes;
            int i17 = i15 + 1;
            System.arraycopy(iArr3, i15, iArr3, i17, i13 - i15);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i15 << 1, objArr2, i17 << 1, (this.mSize - i15) << 1);
        }
        int i18 = this.mSize;
        if (i13 == i18) {
            int[] iArr4 = this.mHashes;
            if (i15 < iArr4.length) {
                iArr4[i15] = i11;
                Object[] objArr3 = this.mArray;
                int i19 = i15 << 1;
                objArr3[i19] = k11;
                objArr3[i19 + 1] = v11;
                this.mSize = i18 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i11 = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i11);
        if (this.mSize != 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                put(simpleArrayMap.keyAt(i12), simpleArrayMap.valueAt(i12));
            }
        } else if (i11 > 0) {
            System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i11);
            System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i11 << 1);
            this.mSize = i11;
        }
    }

    @Nullable
    public V putIfAbsent(K k11, V v11) {
        V v12 = get(k11);
        if (v12 == null) {
            return put(k11, v11);
        }
        return v12;
    }

    @Nullable
    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i11) {
        V[] vArr = this.mArray;
        int i12 = i11 << 1;
        V v11 = vArr[i12 + 1];
        int i13 = this.mSize;
        int i14 = 0;
        if (i13 <= 1) {
            freeArrays(this.mHashes, vArr, i13);
            this.mHashes = ContainerHelpers.f1023a;
            this.mArray = ContainerHelpers.f1025c;
        } else {
            int i15 = i13 - 1;
            int[] iArr = this.mHashes;
            int i16 = 8;
            if (iArr.length <= 8 || i13 >= iArr.length / 3) {
                if (i11 < i15) {
                    int i17 = i11 + 1;
                    int i18 = i15 - i11;
                    System.arraycopy(iArr, i17, iArr, i11, i18);
                    Object[] objArr = this.mArray;
                    System.arraycopy(objArr, i17 << 1, objArr, i12, i18 << 1);
                }
                Object[] objArr2 = this.mArray;
                int i19 = i15 << 1;
                objArr2[i19] = null;
                objArr2[i19 + 1] = null;
            } else {
                if (i13 > 8) {
                    i16 = i13 + (i13 >> 1);
                }
                allocArrays(i16);
                if (i13 == this.mSize) {
                    if (i11 > 0) {
                        System.arraycopy(iArr, 0, this.mHashes, 0, i11);
                        System.arraycopy(vArr, 0, this.mArray, 0, i12);
                    }
                    if (i11 < i15) {
                        int i21 = i11 + 1;
                        int i22 = i15 - i11;
                        System.arraycopy(iArr, i21, this.mHashes, i11, i22);
                        System.arraycopy(vArr, i21 << 1, this.mArray, i12, i22 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i14 = i15;
        }
        if (i13 == this.mSize) {
            this.mSize = i14;
            return v11;
        }
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V replace(K k11, V v11) {
        int indexOfKey = indexOfKey(k11);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v11);
        }
        return null;
    }

    public V setValueAt(int i11, V v11) {
        int i12 = (i11 << 1) + 1;
        V[] vArr = this.mArray;
        V v12 = vArr[i12];
        vArr[i12] = v11;
        return v12;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.mSize * 28);
        sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i11 = 0; i11 < this.mSize; i11++) {
            if (i11 > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            Object keyAt = keyAt(i11);
            if (keyAt != this) {
                sb2.append(keyAt);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append(SignatureVisitor.INSTANCEOF);
            Object valueAt = valueAt(i11);
            if (valueAt != this) {
                sb2.append(valueAt);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append(AbstractJsonLexerKt.END_OBJ);
        return sb2.toString();
    }

    public V valueAt(int i11) {
        return this.mArray[(i11 << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey < 0) {
            return false;
        }
        Object valueAt = valueAt(indexOfKey);
        if (obj2 != valueAt && (obj2 == null || !obj2.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(K k11, V v11, V v12) {
        int indexOfKey = indexOfKey(k11);
        if (indexOfKey < 0) {
            return false;
        }
        V valueAt = valueAt(indexOfKey);
        if (valueAt != v11 && (v11 == null || !v11.equals(valueAt))) {
            return false;
        }
        setValueAt(indexOfKey, v12);
        return true;
    }

    public SimpleArrayMap(int i11) {
        if (i11 == 0) {
            this.mHashes = ContainerHelpers.f1023a;
            this.mArray = ContainerHelpers.f1025c;
        } else {
            allocArrays(i11);
        }
        this.mSize = 0;
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
