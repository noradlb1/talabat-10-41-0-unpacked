package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\fJ&\u0010\u001c\u001a\u00020\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d0\u001fH\bø\u0001\u0000J\u0012\u0010 \u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\"\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010#\u001a\u00020\fH\u0002J&\u0010$\u001a\u00020%2\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020%0\u001fH\bø\u0001\u0000J\u0011\u0010'\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0001H\u0002J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0001J&\u0010)\u001a\u00020%2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d0\u001fH\bø\u0001\u0000R.\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u0010\n\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00138\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0002\u0007\n\u0005\b20\u0001¨\u0006*"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "", "()V", "keys", "", "getKeys$annotations", "getKeys", "()[Ljava/lang/Object;", "setKeys", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "", "getSize$annotations", "getSize", "()I", "setSize", "(I)V", "values", "", "getValues$annotations", "getValues", "()[I", "setValues", "([I)V", "add", "key", "value", "any", "", "predicate", "Lkotlin/Function2;", "find", "findExactIndex", "midIndex", "valueHash", "forEach", "", "block", "get", "remove", "removeValueIf", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IdentityArrayIntMap {
    @NotNull
    private Object[] keys = new Object[4];
    private int size;
    @NotNull
    private int[] values = new int[4];

    private final int find(Object obj) {
        int i11 = this.size - 1;
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) >>> 1;
            Object obj2 = this.keys[i13];
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (identityHashCode2 < identityHashCode) {
                i12 = i13 + 1;
            } else if (identityHashCode2 > identityHashCode) {
                i11 = i13 - 1;
            } else if (obj2 == obj) {
                return i13;
            } else {
                return findExactIndex(i13, obj, identityHashCode);
            }
        }
        return -(i12 + 1);
    }

    private final int findExactIndex(int i11, Object obj, int i12) {
        for (int i13 = i11 - 1; -1 < i13; i13--) {
            Object obj2 = this.keys[i13];
            if (obj2 == obj) {
                return i13;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj2) != i12) {
                break;
            }
        }
        int i14 = i11 + 1;
        int i15 = this.size;
        while (true) {
            if (i14 >= i15) {
                i14 = this.size;
                break;
            }
            Object obj3 = this.keys[i14];
            if (obj3 == obj) {
                return i14;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i12) {
                break;
            }
            i14++;
        }
        return -(i14 + 1);
    }

    @PublishedApi
    public static /* synthetic */ void getKeys$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSize$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getValues$annotations() {
    }

    public final int add(@NotNull Object obj, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(obj, "key");
        if (this.size > 0) {
            i12 = find(obj);
            if (i12 >= 0) {
                int[] iArr = this.values;
                int i13 = iArr[i12];
                iArr[i12] = i11;
                return i13;
            }
        } else {
            i12 = -1;
        }
        int i14 = -(i12 + 1);
        int i15 = this.size;
        Object[] objArr = this.keys;
        if (i15 == objArr.length) {
            Object[] objArr2 = new Object[(objArr.length * 2)];
            int[] iArr2 = new int[(objArr.length * 2)];
            int i16 = i14 + 1;
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr2, i16, i14, i15);
            int[] unused2 = ArraysKt___ArraysJvmKt.copyInto(this.values, iArr2, i16, i14, this.size);
            int i17 = i14;
            Object[] unused3 = ArraysKt___ArraysJvmKt.copyInto$default(this.keys, objArr2, 0, 0, i17, 6, (Object) null);
            int[] unused4 = ArraysKt___ArraysJvmKt.copyInto$default(this.values, iArr2, 0, 0, i17, 6, (Object) null);
            this.keys = objArr2;
            this.values = iArr2;
        } else {
            int i18 = i14 + 1;
            Object[] unused5 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, i18, i14, i15);
            int[] iArr3 = this.values;
            int[] unused6 = ArraysKt___ArraysJvmKt.copyInto(iArr3, iArr3, i18, i14, this.size);
        }
        this.keys[i14] = obj;
        this.values[i14] = i11;
        this.size++;
        return -1;
    }

    public final boolean any(@NotNull Function2<Object, ? super Integer, Boolean> function2) {
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int size2 = getSize();
        for (int i11 = 0; i11 < size2; i11++) {
            Object obj = getKeys()[i11];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            if (function2.invoke(obj, Integer.valueOf(getValues()[i11])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void forEach(@NotNull Function2<Object, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        int size2 = getSize();
        for (int i11 = 0; i11 < size2; i11++) {
            Object obj = getKeys()[i11];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            function2.invoke(obj, Integer.valueOf(getValues()[i11]));
        }
    }

    public final int get(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "key");
        int find = find(obj);
        if (find >= 0) {
            return this.values[find];
        }
        throw new IllegalStateException("Key not found".toString());
    }

    @NotNull
    public final Object[] getKeys() {
        return this.keys;
    }

    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final int[] getValues() {
        return this.values;
    }

    public final boolean remove(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "key");
        int find = find(obj);
        if (find < 0) {
            return false;
        }
        int i11 = this.size;
        if (find < i11 - 1) {
            Object[] objArr = this.keys;
            int i12 = find + 1;
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, find, i12, i11);
            int[] iArr = this.values;
            int[] unused2 = ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, find, i12, this.size);
        }
        int i13 = this.size - 1;
        this.size = i13;
        this.keys[i13] = null;
        return true;
    }

    public final void removeValueIf(@NotNull Function2<Object, ? super Integer, Boolean> function2) {
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int size2 = getSize();
        int i11 = 0;
        for (int i12 = 0; i12 < size2; i12++) {
            Object obj = getKeys()[i12];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            int i13 = getValues()[i12];
            if (!function2.invoke(obj, Integer.valueOf(i13)).booleanValue()) {
                if (i11 != i12) {
                    getKeys()[i11] = obj;
                    getValues()[i11] = i13;
                }
                i11++;
            }
        }
        int size3 = getSize();
        for (int i14 = i11; i14 < size3; i14++) {
            getKeys()[i14] = null;
        }
        setSize(i11);
    }

    public final void setKeys(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.keys = objArr;
    }

    public final void setSize(int i11) {
        this.size = i11;
    }

    public final void setValues(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.values = iArr;
    }
}
