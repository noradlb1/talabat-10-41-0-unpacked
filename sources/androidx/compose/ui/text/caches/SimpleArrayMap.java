package androidx.compose.ui.text.caches;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0010\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0013\b\u0017\u0012\b\b\u0002\u0010A\u001a\u00020\u0005¢\u0006\u0004\bB\u0010=B\u001f\b\u0016\u0012\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000¢\u0006\u0004\bB\u0010DJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0004J\b\u0010\b\u001a\u00020\u0005H\u0004J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005J\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0001H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ\u001a\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001dJ\u001d\u0010\u001f\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010!\u001a\u00020\rJ\u001f\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b\"\u0010\u001aJ\u001e\u0010$\u001a\u00020\t2\u0016\u0010#\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u0000J\u001f\u0010%\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b%\u0010\u001aJ\u0017\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b&\u0010\u0017J\u001d\u0010&\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b(\u0010\u001dJ\u001f\u0010)\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b)\u0010\u001aJ%\u0010)\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u00012\u0006\u0010+\u001a\u00028\u0001¢\u0006\u0004\b)\u0010,J\u0013\u0010.\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u000200H\u0016R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001e\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\"\u00108\u001a\u00020\u00058\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0017\u0010>\u001a\u00020\u00058G¢\u0006\f\u0012\u0004\b?\u0010@\u001a\u0004\b>\u0010;¨\u0006E"}, d2 = {"Landroidx/compose/ui/text/caches/SimpleArrayMap;", "K", "V", "", "key", "", "hash", "a", "b", "", "clear", "minimumCapacity", "ensureCapacity", "", "containsKey", "(Ljava/lang/Object;)Z", "indexOfKey", "value", "indexOfValue$ui_text_release", "(Ljava/lang/Object;)I", "indexOfValue", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "defaultValue", "getOrDefault", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "index", "keyAt", "(I)Ljava/lang/Object;", "valueAt", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "isEmpty", "put", "array", "putAll", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "other", "equals", "hashCode", "", "toString", "", "hashes", "[I", "", "keyValues", "[Ljava/lang/Object;", "_size", "I", "get_size", "()I", "set_size", "(I)V", "size", "size$annotations", "()V", "capacity", "<init>", "map", "(Landroidx/compose/ui/text/caches/SimpleArrayMap;)V", "ui-text_release"}, k = 1, mv = {1, 7, 1})
public final class SimpleArrayMap<K, V> {
    private int _size;
    @NotNull
    private int[] hashes;
    @NotNull
    private Object[] keyValues;

    @JvmOverloads
    public SimpleArrayMap() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public SimpleArrayMap(int i11) {
        if (i11 == 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.keyValues = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            this.hashes = new int[i11];
            this.keyValues = new Object[(i11 << 1)];
        }
        this._size = 0;
    }

    public static /* synthetic */ void size$annotations() {
    }

    public final int a(@NotNull Object obj, int i11) {
        Intrinsics.checkNotNullParameter(obj, "key");
        int i12 = this._size;
        if (i12 == 0) {
            return -1;
        }
        int binarySearchInternal = ContainerHelpersKt.binarySearchInternal(this.hashes, i12, i11);
        if (binarySearchInternal < 0 || Intrinsics.areEqual(obj, this.keyValues[binarySearchInternal << 1])) {
            return binarySearchInternal;
        }
        int i13 = binarySearchInternal + 1;
        while (i13 < i12 && this.hashes[i13] == i11) {
            if (Intrinsics.areEqual(obj, this.keyValues[i13 << 1])) {
                return i13;
            }
            i13++;
        }
        int i14 = binarySearchInternal - 1;
        while (i14 >= 0 && this.hashes[i14] == i11) {
            if (Intrinsics.areEqual(obj, this.keyValues[i14 << 1])) {
                return i14;
            }
            i14--;
        }
        return ~i13;
    }

    public final int b() {
        int i11 = this._size;
        if (i11 == 0) {
            return -1;
        }
        int binarySearchInternal = ContainerHelpersKt.binarySearchInternal(this.hashes, i11, 0);
        if (binarySearchInternal < 0 || this.keyValues[binarySearchInternal << 1] == null) {
            return binarySearchInternal;
        }
        int i12 = binarySearchInternal + 1;
        while (i12 < i11 && this.hashes[i12] == 0) {
            if (this.keyValues[i12 << 1] == null) {
                return i12;
            }
            i12++;
        }
        int i13 = binarySearchInternal - 1;
        while (i13 >= 0 && this.hashes[i13] == 0) {
            if (this.keyValues[i13 << 1] == null) {
                return i13;
            }
            i13--;
        }
        return ~i12;
    }

    public final void clear() {
        if (this._size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.keyValues = ContainerHelpersKt.EMPTY_OBJECTS;
            this._size = 0;
        }
        if (this._size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(K k11) {
        return indexOfKey(k11) >= 0;
    }

    public final boolean containsValue(V v11) {
        return indexOfValue$ui_text_release(v11) >= 0;
    }

    public final void ensureCapacity(int i11) {
        int i12 = this._size;
        int[] iArr = this.hashes;
        if (iArr.length < i11) {
            int[] copyOf = Arrays.copyOf(iArr, i11);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.keyValues, i11 << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.keyValues = copyOf2;
        }
        if (this._size != i12) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i11 = this._size;
                if (i11 != simpleArrayMap._size) {
                    return false;
                }
                for (int i12 = 0; i12 < i11; i12++) {
                    Object keyAt = keyAt(i12);
                    Object valueAt = valueAt(i12);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(valueAt, obj2)) {
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof Map) || this._size != ((Map) obj).size()) {
                return false;
            } else {
                int i13 = this._size;
                for (int i14 = 0; i14 < i13; i14++) {
                    Object keyAt2 = keyAt(i14);
                    Object valueAt2 = valueAt(i14);
                    Object obj3 = ((Map) obj).get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !((Map) obj).containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(valueAt2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    @Nullable
    public final V get(K k11) {
        int indexOfKey = indexOfKey(k11);
        if (indexOfKey >= 0) {
            return this.keyValues[(indexOfKey << 1) + 1];
        }
        return null;
    }

    public final V getOrDefault(K k11, V v11) {
        int indexOfKey = indexOfKey(k11);
        if (indexOfKey >= 0) {
            return this.keyValues[(indexOfKey << 1) + 1];
        }
        return v11;
    }

    public int hashCode() {
        int i11;
        int[] iArr = this.hashes;
        Object[] objArr = this.keyValues;
        int i12 = this._size;
        int i13 = 1;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i12) {
            Object obj = objArr[i13];
            int i16 = iArr[i14];
            if (obj != null) {
                i11 = obj.hashCode();
            } else {
                i11 = 0;
            }
            i15 += i11 ^ i16;
            i14++;
            i13 += 2;
        }
        return i15;
    }

    public final int indexOfKey(@Nullable Object obj) {
        return obj == null ? b() : a(obj, obj.hashCode());
    }

    public final int indexOfValue$ui_text_release(V v11) {
        int i11 = this._size << 1;
        Object[] objArr = this.keyValues;
        if (v11 == null) {
            for (int i12 = 1; i12 < i11; i12 += 2) {
                if (objArr[i12] == null) {
                    return i12 >> 1;
                }
            }
            return -1;
        }
        for (int i13 = 1; i13 < i11; i13 += 2) {
            if (Intrinsics.areEqual((Object) v11, objArr[i13])) {
                return i13 >> 1;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this._size <= 0;
    }

    public final K keyAt(int i11) {
        return this.keyValues[i11 << 1];
    }

    @Nullable
    public final V put(K k11, V v11) {
        int i11;
        int i12;
        int i13 = this._size;
        if (k11 == null) {
            i12 = b();
            i11 = 0;
        } else {
            i11 = k11.hashCode();
            i12 = a(k11, i11);
        }
        if (i12 >= 0) {
            int i14 = (i12 << 1) + 1;
            V[] vArr = this.keyValues;
            V v12 = vArr[i14];
            vArr[i14] = v11;
            return v12;
        }
        int i15 = ~i12;
        int[] iArr = this.hashes;
        if (i13 >= iArr.length) {
            int i16 = 8;
            if (i13 >= 8) {
                i16 = (i13 >> 1) + i13;
            } else if (i13 < 4) {
                i16 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i16);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.keyValues, i16 << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.keyValues = copyOf2;
            if (i13 != this._size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i15 < i13) {
            int[] iArr2 = this.hashes;
            int i17 = i15 + 1;
            int[] unused = ArraysKt___ArraysJvmKt.copyInto(iArr2, iArr2, i17, i15, i13);
            Object[] objArr = this.keyValues;
            Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, i17 << 1, i15 << 1, this._size << 1);
        }
        int i18 = this._size;
        if (i13 == i18) {
            int[] iArr3 = this.hashes;
            if (i15 < iArr3.length) {
                iArr3[i15] = i11;
                Object[] objArr2 = this.keyValues;
                int i19 = i15 << 1;
                objArr2[i19] = k11;
                objArr2[i19 + 1] = v11;
                this._size = i18 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final void putAll(@NotNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        Intrinsics.checkNotNullParameter(simpleArrayMap, "array");
        int i11 = simpleArrayMap._size;
        ensureCapacity(this._size + i11);
        if (this._size != 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                put(simpleArrayMap.keyAt(i12), simpleArrayMap.valueAt(i12));
            }
        } else if (i11 > 0) {
            int[] unused = ArraysKt___ArraysJvmKt.copyInto(simpleArrayMap.hashes, this.hashes, 0, 0, i11);
            Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) simpleArrayMap.keyValues, (T[]) this.keyValues, 0, 0, i11 << 1);
            this._size = i11;
        }
    }

    @Nullable
    public final V putIfAbsent(K k11, V v11) {
        V v12 = get(k11);
        if (v12 == null) {
            return put(k11, v11);
        }
        return v12;
    }

    @Nullable
    public final V remove(K k11) {
        int indexOfKey = indexOfKey(k11);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    @Nullable
    public final V removeAt(int i11) {
        V[] vArr = this.keyValues;
        int i12 = i11 << 1;
        V v11 = vArr[i12 + 1];
        int i13 = this._size;
        if (i13 <= 1) {
            clear();
        } else {
            int i14 = i13 - 1;
            int[] iArr = this.hashes;
            int i15 = 8;
            if (iArr.length <= 8 || i13 >= iArr.length / 3) {
                if (i11 < i14) {
                    int i16 = i11 + 1;
                    int i17 = i14 + 1;
                    int[] unused = ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i11, i16, i17);
                    Object[] objArr = this.keyValues;
                    Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, i12, i16 << 1, i17 << 1);
                }
                Object[] objArr2 = this.keyValues;
                int i18 = i14 << 1;
                objArr2[i18] = null;
                objArr2[i18 + 1] = null;
            } else {
                if (i13 > 8) {
                    i15 = i13 + (i13 >> 1);
                }
                int[] iArr2 = new int[i15];
                this.hashes = iArr2;
                this.keyValues = new Object[(i15 << 1)];
                if (i11 > 0) {
                    int[] unused3 = ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, 0, 0, i11);
                    Object[] unused4 = ArraysKt___ArraysJvmKt.copyInto((T[]) vArr, (T[]) this.keyValues, 0, 0, i12);
                }
                if (i11 < i14) {
                    int i19 = i11 + 1;
                    int i21 = i14 + 1;
                    int[] unused5 = ArraysKt___ArraysJvmKt.copyInto(iArr, this.hashes, i11, i19, i21);
                    Object[] unused6 = ArraysKt___ArraysJvmKt.copyInto((T[]) vArr, (T[]) this.keyValues, i12, i19 << 1, i21 << 1);
                }
            }
            if (i13 == this._size) {
                this._size = i14;
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return v11;
    }

    @Nullable
    public final V replace(K k11, V v11) {
        int indexOfKey = indexOfKey(k11);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v11);
        }
        return null;
    }

    public final V setValueAt(int i11, V v11) {
        int i12 = (i11 << 1) + 1;
        V[] vArr = this.keyValues;
        V v12 = vArr[i12];
        vArr[i12] = v11;
        return v12;
    }

    @JvmName(name = "size")
    public final int size() {
        return this._size;
    }

    @NotNull
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this._size * 28);
        sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
        int i11 = this._size;
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            Object keyAt = keyAt(i12);
            if (keyAt != this) {
                sb2.append(keyAt);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append(SignatureVisitor.INSTANCEOF);
            Object valueAt = valueAt(i12);
            if (valueAt != this) {
                sb2.append(valueAt);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append(AbstractJsonLexerKt.END_OBJ);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "buffer.toString()");
        return sb3;
    }

    public final V valueAt(int i11) {
        return this.keyValues[(i11 << 1) + 1];
    }

    public final boolean remove(K k11, V v11) {
        int indexOfKey = indexOfKey(k11);
        if (indexOfKey < 0 || !Intrinsics.areEqual((Object) v11, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public final boolean replace(K k11, V v11, V v12) {
        int indexOfKey = indexOfKey(k11);
        if (indexOfKey < 0 || valueAt(indexOfKey) != v11) {
            return false;
        }
        setValueAt(indexOfKey, v12);
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleArrayMap(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }

    public SimpleArrayMap(@Nullable SimpleArrayMap<K, V> simpleArrayMap) {
        this(0, 1, (DefaultConstructorMarker) null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
