package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u0005H\u0002JD\u0010\u001f\u001a\u00020\u001626\u0010 \u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00160!H\bø\u0001\u0000J\u0018\u0010%\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020\u0018J\u0006\u0010(\u001a\u00020\u0018J\u0013\u0010)\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJD\u0010*\u001a\u00020\u001626\u0010 \u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00180!H\bø\u0001\u0000J/\u0010+\u001a\u00020\u00162!\u0010 \u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00180,H\bø\u0001\u0000J\u001e\u0010-\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010.R$\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0006R$\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f\u0002\u0007\n\u0005\b20\u0001¨\u0006/"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayMap;", "Key", "", "Value", "capacity", "", "(I)V", "keys", "", "getKeys$runtime_release", "()[Ljava/lang/Object;", "setKeys$runtime_release", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "getSize$runtime_release", "()I", "setSize$runtime_release", "values", "getValues$runtime_release", "setValues$runtime_release", "clear", "", "contains", "", "key", "(Ljava/lang/Object;)Z", "find", "findExactIndex", "midIndex", "keyHash", "forEach", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "removeIf", "removeValueIf", "Lkotlin/Function1;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IdentityArrayMap<Key, Value> {
    @NotNull
    private Object[] keys;
    private int size;
    @NotNull
    private Object[] values;

    public IdentityArrayMap() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public IdentityArrayMap(int i11) {
        this.keys = new Object[i11];
        this.values = new Object[i11];
    }

    private final int find(Object obj) {
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i11 = this.size - 1;
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) >>> 1;
            Object obj2 = this.keys[i13];
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (identityHashCode2 < identityHashCode) {
                i12 = i13 + 1;
            } else if (identityHashCode2 > identityHashCode) {
                i11 = i13 - 1;
            } else if (obj == obj2) {
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

    public final void clear() {
        this.size = 0;
        ArraysKt___ArraysJvmKt.fill$default(this.keys, (Object) null, 0, 0, 6, (Object) null);
        ArraysKt___ArraysJvmKt.fill$default(this.values, (Object) null, 0, 0, 6, (Object) null);
    }

    public final boolean contains(@NotNull Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (find(key) >= 0) {
            return true;
        }
        return false;
    }

    public final void forEach(@NotNull Function2<? super Key, ? super Value, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        int size$runtime_release = getSize$runtime_release();
        for (int i11 = 0; i11 < size$runtime_release; i11++) {
            Object obj = getKeys$runtime_release()[i11];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            function2.invoke(obj, getValues$runtime_release()[i11]);
        }
    }

    @Nullable
    public final Value get(@NotNull Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find >= 0) {
            return this.values[find];
        }
        return null;
    }

    @NotNull
    public final Object[] getKeys$runtime_release() {
        return this.keys;
    }

    public final int getSize$runtime_release() {
        return this.size;
    }

    @NotNull
    public final Object[] getValues$runtime_release() {
        return this.values;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    public final boolean remove(@NotNull Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find < 0) {
            return false;
        }
        int i11 = this.size;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int i12 = find + 1;
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, find, i12, i11);
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr2, (T[]) objArr2, find, i12, i11);
        int i13 = i11 - 1;
        objArr[i13] = null;
        objArr2[i13] = null;
        this.size = i13;
        return true;
    }

    public final void removeIf(@NotNull Function2<? super Key, ? super Value, Boolean> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        int size$runtime_release = getSize$runtime_release();
        int i11 = 0;
        for (int i12 = 0; i12 < size$runtime_release; i12++) {
            Object obj = getKeys$runtime_release()[i12];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            if (!function2.invoke(obj, getValues$runtime_release()[i12]).booleanValue()) {
                if (i11 != i12) {
                    getKeys$runtime_release()[i11] = obj;
                    getValues$runtime_release()[i11] = getValues$runtime_release()[i12];
                }
                i11++;
            }
        }
        if (getSize$runtime_release() > i11) {
            int size$runtime_release2 = getSize$runtime_release();
            for (int i13 = i11; i13 < size$runtime_release2; i13++) {
                getKeys$runtime_release()[i13] = null;
                getValues$runtime_release()[i13] = null;
            }
            setSize$runtime_release(i11);
        }
    }

    public final void removeValueIf(@NotNull Function1<? super Value, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        int size$runtime_release = getSize$runtime_release();
        int i11 = 0;
        for (int i12 = 0; i12 < size$runtime_release; i12++) {
            Object obj = getKeys$runtime_release()[i12];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            if (!function1.invoke(getValues$runtime_release()[i12]).booleanValue()) {
                if (i11 != i12) {
                    getKeys$runtime_release()[i11] = obj;
                    getValues$runtime_release()[i11] = getValues$runtime_release()[i12];
                }
                i11++;
            }
        }
        if (getSize$runtime_release() > i11) {
            int size$runtime_release2 = getSize$runtime_release();
            for (int i13 = i11; i13 < size$runtime_release2; i13++) {
                getKeys$runtime_release()[i13] = null;
                getValues$runtime_release()[i13] = null;
            }
            setSize$runtime_release(i11);
        }
    }

    public final void set(@NotNull Key key, Value value) {
        boolean z11;
        Object[] objArr;
        Object[] objArr2;
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find >= 0) {
            this.values[find] = value;
            return;
        }
        int i11 = -(find + 1);
        int i12 = this.size;
        Object[] objArr3 = this.keys;
        if (i12 == objArr3.length) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            objArr = new Object[(i12 * 2)];
        } else {
            objArr = objArr3;
        }
        int i13 = i11 + 1;
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr3, (T[]) objArr, i13, i11, i12);
        if (z11) {
            Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto$default(this.keys, objArr, 0, 0, i11, 6, (Object) null);
        }
        objArr[i11] = key;
        this.keys = objArr;
        if (z11) {
            objArr2 = new Object[(this.size * 2)];
        } else {
            objArr2 = this.values;
        }
        Object[] unused3 = ArraysKt___ArraysJvmKt.copyInto((T[]) this.values, (T[]) objArr2, i13, i11, this.size);
        if (z11) {
            Object[] unused4 = ArraysKt___ArraysJvmKt.copyInto$default(this.values, objArr2, 0, 0, i11, 6, (Object) null);
        }
        objArr2[i11] = value;
        this.values = objArr2;
        this.size++;
    }

    public final void setKeys$runtime_release(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.keys = objArr;
    }

    public final void setSize$runtime_release(int i11) {
        this.size = i11;
    }

    public final void setValues$runtime_release(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.values = objArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IdentityArrayMap(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 16 : i11);
    }
}
