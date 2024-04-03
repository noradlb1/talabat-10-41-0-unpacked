package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001aE\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\f2\u0006\u0010\u0010\u001a\u0002H\rH\u0002¢\u0006\u0002\u0010\u0011\u001a)\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0013\u001a)\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0013\u001aA\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u000e\u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0018H\u0002¢\u0006\u0002\u0010\u0019\u001aM\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\f2\u0006\u0010\u0010\u001a\u0002H\rH\u0002¢\u0006\u0002\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"ENTRY_SIZE", "", "LOG_MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "insertEntryAtIndex", "", "", "K", "V", "keyIndex", "key", "value", "([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "removeEntryAtIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "removeNodeAtIndex", "nodeIndex", "replaceEntryWithNode", "newNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)[Ljava/lang/Object;", "replaceNodeWithEntry", "([Ljava/lang/Object;IILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TrieNodeKt {
    public static final int ENTRY_SIZE = 2;
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    public static final int indexSegment(int i11, int i12) {
        return (i11 >> i12) & 31;
    }

    /* access modifiers changed from: private */
    public static final <K, V> Object[] insertEntryAtIndex(Object[] objArr, int i11, K k11, V v11) {
        Object[] objArr2 = new Object[(objArr.length + 2)];
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i11, 6, (Object) null);
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr2, i11 + 2, i11, objArr.length);
        objArr2[i11] = k11;
        objArr2[i11 + 1] = v11;
        return objArr2;
    }

    /* access modifiers changed from: private */
    public static final Object[] removeEntryAtIndex(Object[] objArr, int i11) {
        Object[] objArr2 = new Object[(objArr.length - 2)];
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i11, 6, (Object) null);
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr2, i11, i11 + 2, objArr.length);
        return objArr2;
    }

    /* access modifiers changed from: private */
    public static final Object[] removeNodeAtIndex(Object[] objArr, int i11) {
        Object[] objArr2 = new Object[(objArr.length - 1)];
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i11, 6, (Object) null);
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr2, i11, i11 + 1, objArr.length);
        return objArr2;
    }

    /* access modifiers changed from: private */
    public static final Object[] replaceEntryWithNode(Object[] objArr, int i11, int i12, TrieNode<?, ?> trieNode) {
        int i13 = i12 - 2;
        Object[] objArr2 = new Object[((objArr.length - 2) + 1)];
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i11, 6, (Object) null);
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr2, i11, i11 + 2, i12);
        objArr2[i13] = trieNode;
        Object[] unused3 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr2, i13 + 1, i12, objArr.length);
        return objArr2;
    }

    /* access modifiers changed from: private */
    public static final <K, V> Object[] replaceNodeWithEntry(Object[] objArr, int i11, int i12, K k11, V v11) {
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) copyOf, (T[]) copyOf, i11 + 2, i11 + 1, objArr.length);
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) copyOf, (T[]) copyOf, i12 + 2, i12, i11);
        copyOf[i12] = k11;
        copyOf[i12 + 1] = v11;
        return copyOf;
    }
}
