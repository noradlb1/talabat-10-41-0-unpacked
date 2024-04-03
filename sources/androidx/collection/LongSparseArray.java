package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    private void gc() {
        int i11 = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (obj != DELETED) {
                if (i13 != i12) {
                    jArr[i12] = jArr[i13];
                    objArr[i12] = obj;
                    objArr[i13] = null;
                }
                i12++;
            }
        }
        this.mGarbage = false;
        this.mSize = i12;
    }

    public void append(long j11, E e11) {
        int i11 = this.mSize;
        if (i11 == 0 || j11 > this.mKeys[i11 - 1]) {
            if (this.mGarbage && i11 >= this.mKeys.length) {
                gc();
            }
            int i12 = this.mSize;
            if (i12 >= this.mKeys.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(i12 + 1);
                long[] jArr = new long[idealLongArraySize];
                Object[] objArr = new Object[idealLongArraySize];
                long[] jArr2 = this.mKeys;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.mValues;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.mKeys = jArr;
                this.mValues = objArr;
            }
            this.mKeys[i12] = j11;
            this.mValues[i12] = e11;
            this.mSize = i12 + 1;
            return;
        }
        put(j11, e11);
    }

    public void clear() {
        int i11 = this.mSize;
        Object[] objArr = this.mValues;
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public boolean containsKey(long j11) {
        return indexOfKey(j11) >= 0;
    }

    public boolean containsValue(E e11) {
        return indexOfValue(e11) >= 0;
    }

    @Deprecated
    public void delete(long j11) {
        remove(j11);
    }

    @Nullable
    public E get(long j11) {
        return get(j11, (Object) null);
    }

    public int indexOfKey(long j11) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.b(this.mKeys, this.mSize, j11);
    }

    public int indexOfValue(E e11) {
        if (this.mGarbage) {
            gc();
        }
        for (int i11 = 0; i11 < this.mSize; i11++) {
            if (this.mValues[i11] == e11) {
                return i11;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i11) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i11];
    }

    public void put(long j11, E e11) {
        int b11 = ContainerHelpers.b(this.mKeys, this.mSize, j11);
        if (b11 >= 0) {
            this.mValues[b11] = e11;
            return;
        }
        int i11 = ~b11;
        int i12 = this.mSize;
        if (i11 < i12) {
            Object[] objArr = this.mValues;
            if (objArr[i11] == DELETED) {
                this.mKeys[i11] = j11;
                objArr[i11] = e11;
                return;
            }
        }
        if (this.mGarbage && i12 >= this.mKeys.length) {
            gc();
            i11 = ~ContainerHelpers.b(this.mKeys, this.mSize, j11);
        }
        int i13 = this.mSize;
        if (i13 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i13 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr2 = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = jArr;
            this.mValues = objArr2;
        }
        int i14 = this.mSize;
        if (i14 - i11 != 0) {
            long[] jArr3 = this.mKeys;
            int i15 = i11 + 1;
            System.arraycopy(jArr3, i11, jArr3, i15, i14 - i11);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i11, objArr4, i15, this.mSize - i11);
        }
        this.mKeys[i11] = j11;
        this.mValues[i11] = e11;
        this.mSize++;
    }

    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            put(longSparseArray.keyAt(i11), longSparseArray.valueAt(i11));
        }
    }

    @Nullable
    public E putIfAbsent(long j11, E e11) {
        E e12 = get(j11);
        if (e12 == null) {
            put(j11, e11);
        }
        return e12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.mValues;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.mKeys
            int r1 = r2.mSize
            int r3 = androidx.collection.ContainerHelpers.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.mValues
            r0 = r4[r3]
            java.lang.Object r1 = DELETED
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.mGarbage = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSparseArray.remove(long):void");
    }

    public void removeAt(int i11) {
        Object[] objArr = this.mValues;
        Object obj = objArr[i11];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i11] = obj2;
            this.mGarbage = true;
        }
    }

    @Nullable
    public E replace(long j11, E e11) {
        int indexOfKey = indexOfKey(j11);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = this.mValues;
        E e12 = eArr[indexOfKey];
        eArr[indexOfKey] = e11;
        return e12;
    }

    public void setValueAt(int i11, E e11) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i11] = e11;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.mSize * 28);
        sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i11 = 0; i11 < this.mSize; i11++) {
            if (i11 > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(keyAt(i11));
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

    public E valueAt(int i11) {
        if (this.mGarbage) {
            gc();
        }
        return this.mValues[i11];
    }

    public LongSparseArray(int i11) {
        this.mGarbage = false;
        if (i11 == 0) {
            this.mKeys = ContainerHelpers.f1024b;
            this.mValues = ContainerHelpers.f1025c;
            return;
        }
        int idealLongArraySize = ContainerHelpers.idealLongArraySize(i11);
        this.mKeys = new long[idealLongArraySize];
        this.mValues = new Object[idealLongArraySize];
    }

    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e11) {
            throw new AssertionError(e11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.mValues[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E get(long r3, E r5) {
        /*
            r2 = this;
            long[] r0 = r2.mKeys
            int r1 = r2.mSize
            int r3 = androidx.collection.ContainerHelpers.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r4 = r2.mValues
            r3 = r4[r3]
            java.lang.Object r4 = DELETED
            if (r3 != r4) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSparseArray.get(long, java.lang.Object):java.lang.Object");
    }

    public boolean replace(long j11, E e11, E e12) {
        int indexOfKey = indexOfKey(j11);
        if (indexOfKey < 0) {
            return false;
        }
        E e13 = this.mValues[indexOfKey];
        if (e13 != e11 && (e11 == null || !e11.equals(e13))) {
            return false;
        }
        this.mValues[indexOfKey] = e12;
        return true;
    }

    public boolean remove(long j11, Object obj) {
        int indexOfKey = indexOfKey(j11);
        if (indexOfKey < 0) {
            return false;
        }
        Object valueAt = valueAt(indexOfKey);
        if (obj != valueAt && (obj == null || !obj.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }
}
