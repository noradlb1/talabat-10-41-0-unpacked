package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a7\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\"\u0004\b\u0000\u0010\u000b*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\f\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\r\u001aL\u0010\u000e\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00130\u0012H\b¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"LOG_MAX_BRANCHING_FACTOR", "", "MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "addElementAtIndex", "", "", "E", "element", "([Ljava/lang/Object;ILjava/lang/Object;)[Ljava/lang/Object;", "filterTo", "newArray", "newArrayOffset", "predicate", "Lkotlin/Function1;", "", "([Ljava/lang/Object;[Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)I", "removeCellAtIndex", "cellIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TrieNodeKt {
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    /* access modifiers changed from: private */
    public static final <E> Object[] addElementAtIndex(Object[] objArr, int i11, E e11) {
        Object[] objArr2 = new Object[(objArr.length + 1)];
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i11, 6, (Object) null);
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr2, i11 + 1, i11, objArr.length);
        objArr2[i11] = e11;
        return objArr2;
    }

    private static final int filterTo(Object[] objArr, Object[] objArr2, int i11, Function1<Object, Boolean> function1) {
        boolean z11;
        int i12 = 0;
        for (int i13 = 0; i13 < objArr.length; i13++) {
            boolean z12 = true;
            if (i12 <= i13) {
                z11 = true;
            } else {
                z11 = false;
            }
            CommonFunctionsKt.m2551assert(z11);
            if (function1.invoke(objArr[i13]).booleanValue()) {
                objArr2[i11 + i12] = objArr[i13];
                i12++;
                if (i11 + i12 > objArr2.length) {
                    z12 = false;
                }
                CommonFunctionsKt.m2551assert(z12);
            }
        }
        return i12;
    }

    public static final int indexSegment(int i11, int i12) {
        return (i11 >> i12) & 31;
    }

    /* access modifiers changed from: private */
    public static final Object[] removeCellAtIndex(Object[] objArr, int i11) {
        Object[] objArr2 = new Object[(objArr.length - 1)];
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i11, 6, (Object) null);
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr2, i11, i11 + 1, objArr.length);
        return objArr2;
    }
}
