package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020(J\u0011\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0002H\u0002J\u0012\u0010+\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020\u000eH\u0002J7\u0010/\u001a\u00020(2\u0006\u0010$\u001a\u00020\u00022!\u00100\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020(01H\bø\u0001\u0000J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010$\u001a\u00020\u0002H\u0002J\u001b\u00105\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0002\u0010&J\u0013\u00106\u001a\u00020(2\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0002\u00107J/\u00108\u001a\u00020(2!\u00109\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020#01H\bø\u0001\u0000J#\u0010:\u001a\u00020(2\u0018\u0010;\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020(01H\bJ\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010=\u001a\u00020\u000eH\u0002J\u0011\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u000eH\bR4\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u00058\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u0010\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00158\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR.\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00058\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u0002\u0007\n\u0005\b20\u0001¨\u0006?"}, d2 = {"Landroidx/compose/runtime/collection/IdentityScopeMap;", "T", "", "()V", "scopeSets", "", "Landroidx/compose/runtime/collection/IdentityArraySet;", "getScopeSets$annotations", "getScopeSets", "()[Landroidx/compose/runtime/collection/IdentityArraySet;", "setScopeSets", "([Landroidx/compose/runtime/collection/IdentityArraySet;)V", "[Landroidx/compose/runtime/collection/IdentityArraySet;", "size", "", "getSize$annotations", "getSize", "()I", "setSize", "(I)V", "valueOrder", "", "getValueOrder$annotations", "getValueOrder", "()[I", "setValueOrder", "([I)V", "values", "getValues$annotations", "getValues", "()[Ljava/lang/Object;", "setValues", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "add", "", "value", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "", "contains", "element", "find", "findExactIndex", "midIndex", "valueHash", "forEachScopeOf", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getOrCreateIdentitySet", "remove", "removeScope", "(Ljava/lang/Object;)V", "removeValueIf", "predicate", "removingScopes", "removalOperation", "scopeSetAt", "index", "valueAt", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IdentityScopeMap<T> {
    @NotNull
    private IdentityArraySet<T>[] scopeSets;
    private int size;
    @NotNull
    private int[] valueOrder;
    @NotNull
    private Object[] values;

    public IdentityScopeMap() {
        int[] iArr = new int[50];
        for (int i11 = 0; i11 < 50; i11++) {
            iArr[i11] = i11;
        }
        this.valueOrder = iArr;
        this.values = new Object[50];
        this.scopeSets = new IdentityArraySet[50];
    }

    /* access modifiers changed from: private */
    public final int find(Object obj) {
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i11 = this.size - 1;
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) >>> 1;
            Object obj2 = this.values[this.valueOrder[i13]];
            Intrinsics.checkNotNull(obj2);
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
            Object obj2 = this.values[this.valueOrder[i13]];
            Intrinsics.checkNotNull(obj2);
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
            Object obj3 = this.values[this.valueOrder[i14]];
            Intrinsics.checkNotNull(obj3);
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

    private final IdentityArraySet<T> getOrCreateIdentitySet(Object obj) {
        int i11;
        if (this.size > 0) {
            i11 = find(obj);
            if (i11 >= 0) {
                return scopeSetAt(i11);
            }
        } else {
            i11 = -1;
        }
        int i12 = -(i11 + 1);
        int i13 = this.size;
        int[] iArr = this.valueOrder;
        if (i13 < iArr.length) {
            int i14 = iArr[i13];
            this.values[i14] = obj;
            IdentityArraySet<T> identityArraySet = this.scopeSets[i14];
            if (identityArraySet == null) {
                identityArraySet = new IdentityArraySet<>();
                this.scopeSets[i14] = identityArraySet;
            }
            int i15 = this.size;
            if (i12 < i15) {
                int[] iArr2 = this.valueOrder;
                int[] unused = ArraysKt___ArraysJvmKt.copyInto(iArr2, iArr2, i12 + 1, i12, i15);
            }
            this.valueOrder[i12] = i14;
            this.size++;
            return identityArraySet;
        }
        int length = iArr.length * 2;
        Object[] copyOf = Arrays.copyOf(this.scopeSets, length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        this.scopeSets = (IdentityArraySet[]) copyOf;
        IdentityArraySet<T> identityArraySet2 = new IdentityArraySet<>();
        this.scopeSets[i13] = identityArraySet2;
        Object[] copyOf2 = Arrays.copyOf(this.values, length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        this.values = copyOf2;
        copyOf2[i13] = obj;
        int[] iArr3 = new int[length];
        int i16 = this.size;
        while (true) {
            i16++;
            if (i16 >= length) {
                break;
            }
            iArr3[i16] = i16;
        }
        int i17 = this.size;
        if (i12 < i17) {
            int[] unused2 = ArraysKt___ArraysJvmKt.copyInto(this.valueOrder, iArr3, i12 + 1, i12, i17);
        }
        iArr3[i12] = i13;
        if (i12 > 0) {
            int[] unused3 = ArraysKt___ArraysJvmKt.copyInto$default(this.valueOrder, iArr3, 0, 0, i12, 6, (Object) null);
        }
        this.valueOrder = iArr3;
        this.size++;
        return identityArraySet2;
    }

    @PublishedApi
    public static /* synthetic */ void getScopeSets$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSize$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getValueOrder$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getValues$annotations() {
    }

    private final void removingScopes(Function1<? super IdentityArraySet<T>, Unit> function1) {
        int size2 = getSize();
        int i11 = 0;
        for (int i12 = 0; i12 < size2; i12++) {
            int i13 = getValueOrder()[i12];
            IdentityArraySet identityArraySet = getScopeSets()[i13];
            Intrinsics.checkNotNull(identityArraySet);
            function1.invoke(identityArraySet);
            if (identityArraySet.size() > 0) {
                if (i11 != i12) {
                    int i14 = getValueOrder()[i11];
                    getValueOrder()[i11] = i13;
                    getValueOrder()[i12] = i14;
                }
                i11++;
            }
        }
        int size3 = getSize();
        for (int i15 = i11; i15 < size3; i15++) {
            getValues()[getValueOrder()[i15]] = null;
        }
        setSize(i11);
    }

    /* access modifiers changed from: private */
    public final IdentityArraySet<T> scopeSetAt(int i11) {
        IdentityArraySet<T> identityArraySet = this.scopeSets[this.valueOrder[i11]];
        Intrinsics.checkNotNull(identityArraySet);
        return identityArraySet;
    }

    private final Object valueAt(int i11) {
        Object obj = this.values[this.valueOrder[i11]];
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    public final boolean add(@NotNull Object obj, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(obj, "value");
        Intrinsics.checkNotNullParameter(t11, "scope");
        return getOrCreateIdentitySet(obj).add(t11);
    }

    public final void clear() {
        int length = this.scopeSets.length;
        for (int i11 = 0; i11 < length; i11++) {
            IdentityArraySet<T> identityArraySet = this.scopeSets[i11];
            if (identityArraySet != null) {
                identityArraySet.clear();
            }
            this.valueOrder[i11] = i11;
            this.values[i11] = null;
        }
        this.size = 0;
    }

    public final boolean contains(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "element");
        if (find(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final void forEachScopeOf(@NotNull Object obj, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(obj, "value");
        Intrinsics.checkNotNullParameter(function1, "block");
        int access$find = find(obj);
        if (access$find >= 0) {
            IdentityArraySet access$scopeSetAt = scopeSetAt(access$find);
            int size2 = access$scopeSetAt.size();
            for (int i11 = 0; i11 < size2; i11++) {
                function1.invoke(access$scopeSetAt.get(i11));
            }
        }
    }

    @NotNull
    public final IdentityArraySet<T>[] getScopeSets() {
        return this.scopeSets;
    }

    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final int[] getValueOrder() {
        return this.valueOrder;
    }

    @NotNull
    public final Object[] getValues() {
        return this.values;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r1 = r4.valueOrder[r5];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(@org.jetbrains.annotations.NotNull java.lang.Object r5, @org.jetbrains.annotations.NotNull T r6) {
        /*
            r4 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r5 = r4.find(r5)
            r0 = 0
            if (r5 < 0) goto L_0x0043
            int[] r1 = r4.valueOrder
            r1 = r1[r5]
            androidx.compose.runtime.collection.IdentityArraySet<T>[] r2 = r4.scopeSets
            r2 = r2[r1]
            if (r2 != 0) goto L_0x001c
            return r0
        L_0x001c:
            boolean r6 = r2.remove(r6)
            int r0 = r2.size()
            if (r0 != 0) goto L_0x0042
            int r0 = r5 + 1
            int r2 = r4.size
            if (r0 >= r2) goto L_0x0031
            int[] r3 = r4.valueOrder
            int[] unused = kotlin.collections.ArraysKt___ArraysJvmKt.copyInto((int[]) r3, (int[]) r3, (int) r5, (int) r0, (int) r2)
        L_0x0031:
            int[] r5 = r4.valueOrder
            int r0 = r4.size
            int r2 = r0 + -1
            r5[r2] = r1
            java.lang.Object[] r5 = r4.values
            r2 = 0
            r5[r1] = r2
            int r0 = r0 + -1
            r4.size = r0
        L_0x0042:
            return r6
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.IdentityScopeMap.remove(java.lang.Object, java.lang.Object):boolean");
    }

    public final void removeScope(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "scope");
        int size2 = getSize();
        int i11 = 0;
        for (int i12 = 0; i12 < size2; i12++) {
            int i13 = getValueOrder()[i12];
            IdentityArraySet identityArraySet = getScopeSets()[i13];
            Intrinsics.checkNotNull(identityArraySet);
            identityArraySet.remove(t11);
            if (identityArraySet.size() > 0) {
                if (i11 != i12) {
                    int i14 = getValueOrder()[i11];
                    getValueOrder()[i11] = i13;
                    getValueOrder()[i12] = i14;
                }
                i11++;
            }
        }
        int size3 = getSize();
        for (int i15 = i11; i15 < size3; i15++) {
            getValues()[getValueOrder()[i15]] = null;
        }
        setSize(i11);
    }

    public final void removeValueIf(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size2 = getSize();
        int i11 = 0;
        for (int i12 = 0; i12 < size2; i12++) {
            int i13 = getValueOrder()[i12];
            IdentityArraySet identityArraySet = getScopeSets()[i13];
            Intrinsics.checkNotNull(identityArraySet);
            int size3 = identityArraySet.size();
            int i14 = 0;
            for (int i15 = 0; i15 < size3; i15++) {
                Object obj = identityArraySet.getValues()[i15];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (!function1.invoke(obj).booleanValue()) {
                    if (i14 != i15) {
                        identityArraySet.getValues()[i14] = obj;
                    }
                    i14++;
                }
            }
            int size4 = identityArraySet.size();
            for (int i16 = i14; i16 < size4; i16++) {
                identityArraySet.getValues()[i16] = null;
            }
            identityArraySet.setSize(i14);
            if (identityArraySet.size() > 0) {
                if (i11 != i12) {
                    int i17 = getValueOrder()[i11];
                    getValueOrder()[i11] = i13;
                    getValueOrder()[i12] = i17;
                }
                i11++;
            }
        }
        int size5 = getSize();
        for (int i18 = i11; i18 < size5; i18++) {
            getValues()[getValueOrder()[i18]] = null;
        }
        setSize(i11);
    }

    public final void setScopeSets(@NotNull IdentityArraySet<T>[] identityArraySetArr) {
        Intrinsics.checkNotNullParameter(identityArraySetArr, "<set-?>");
        this.scopeSets = identityArraySetArr;
    }

    public final void setSize(int i11) {
        this.size = i11;
    }

    public final void setValueOrder(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.valueOrder = iArr;
    }

    public final void setValues(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.values = objArr;
    }
}
