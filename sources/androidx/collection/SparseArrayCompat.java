package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    private void gc() {
        int i11 = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (obj != DELETED) {
                if (i13 != i12) {
                    iArr[i12] = iArr[i13];
                    objArr[i12] = obj;
                    objArr[i13] = null;
                }
                i12++;
            }
        }
        this.mGarbage = false;
        this.mSize = i12;
    }

    public void append(int i11, E e11) {
        int i12 = this.mSize;
        if (i12 == 0 || i11 > this.mKeys[i12 - 1]) {
            if (this.mGarbage && i12 >= this.mKeys.length) {
                gc();
            }
            int i13 = this.mSize;
            if (i13 >= this.mKeys.length) {
                int idealIntArraySize = ContainerHelpers.idealIntArraySize(i13 + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                int[] iArr2 = this.mKeys;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.mValues;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.mKeys = iArr;
                this.mValues = objArr;
            }
            this.mKeys[i13] = i11;
            this.mValues[i13] = e11;
            this.mSize = i13 + 1;
            return;
        }
        put(i11, e11);
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

    public boolean containsKey(int i11) {
        return indexOfKey(i11) >= 0;
    }

    public boolean containsValue(E e11) {
        return indexOfValue(e11) >= 0;
    }

    @Deprecated
    public void delete(int i11) {
        remove(i11);
    }

    @Nullable
    public E get(int i11) {
        return get(i11, (Object) null);
    }

    public int indexOfKey(int i11) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.a(this.mKeys, this.mSize, i11);
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

    public int keyAt(int i11) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i11];
    }

    public void put(int i11, E e11) {
        int a11 = ContainerHelpers.a(this.mKeys, this.mSize, i11);
        if (a11 >= 0) {
            this.mValues[a11] = e11;
            return;
        }
        int i12 = ~a11;
        int i13 = this.mSize;
        if (i12 < i13) {
            Object[] objArr = this.mValues;
            if (objArr[i12] == DELETED) {
                this.mKeys[i12] = i11;
                objArr[i12] = e11;
                return;
            }
        }
        if (this.mGarbage && i13 >= this.mKeys.length) {
            gc();
            i12 = ~ContainerHelpers.a(this.mKeys, this.mSize, i11);
        }
        int i14 = this.mSize;
        if (i14 >= this.mKeys.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i14 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr2 = new Object[idealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr;
            this.mValues = objArr2;
        }
        int i15 = this.mSize;
        if (i15 - i12 != 0) {
            int[] iArr3 = this.mKeys;
            int i16 = i12 + 1;
            System.arraycopy(iArr3, i12, iArr3, i16, i15 - i12);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i12, objArr4, i16, this.mSize - i12);
        }
        this.mKeys[i12] = i11;
        this.mValues[i12] = e11;
        this.mSize++;
    }

    public void putAll(@NonNull SparseArrayCompat<? extends E> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        for (int i11 = 0; i11 < size; i11++) {
            put(sparseArrayCompat.keyAt(i11), sparseArrayCompat.valueAt(i11));
        }
    }

    @Nullable
    public E putIfAbsent(int i11, E e11) {
        E e12 = get(i11);
        if (e12 == null) {
            put(i11, e11);
        }
        return e12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.mValues;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.mKeys
            int r1 = r3.mSize
            int r4 = androidx.collection.ContainerHelpers.a(r0, r1, r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.mValues
            r1 = r0[r4]
            java.lang.Object r2 = DELETED
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.mGarbage = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompat.remove(int):void");
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

    public void removeAtRange(int i11, int i12) {
        int min = Math.min(this.mSize, i12 + i11);
        while (i11 < min) {
            removeAt(i11);
            i11++;
        }
    }

    @Nullable
    public E replace(int i11, E e11) {
        int indexOfKey = indexOfKey(i11);
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

    public SparseArrayCompat(int i11) {
        this.mGarbage = false;
        if (i11 == 0) {
            this.mKeys = ContainerHelpers.f1023a;
            this.mValues = ContainerHelpers.f1025c;
            return;
        }
        int idealIntArraySize = ContainerHelpers.idealIntArraySize(i11);
        this.mKeys = new int[idealIntArraySize];
        this.mValues = new Object[idealIntArraySize];
    }

    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e11) {
            throw new AssertionError(e11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.mValues[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E get(int r3, E r4) {
        /*
            r2 = this;
            int[] r0 = r2.mKeys
            int r1 = r2.mSize
            int r3 = androidx.collection.ContainerHelpers.a(r0, r1, r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r0 = r2.mValues
            r3 = r0[r3]
            java.lang.Object r0 = DELETED
            if (r3 != r0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompat.get(int, java.lang.Object):java.lang.Object");
    }

    public boolean replace(int i11, E e11, E e12) {
        int indexOfKey = indexOfKey(i11);
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

    public boolean remove(int i11, Object obj) {
        int indexOfKey = indexOfKey(i11);
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
