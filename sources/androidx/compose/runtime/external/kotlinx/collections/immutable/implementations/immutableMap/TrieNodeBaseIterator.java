package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\b\u0012\u0004\u0012\u00028\u00020\u0004B\u0007¢\u0006\u0004\b\"\u0010#J-\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ%\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u000eJ\u0006\u0010\u0010\u001a\u00020\u000fJ\r\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u0016\u0010\u0016\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u0015J\u0006\u0010\u0017\u001a\u00020\u000bJ\t\u0010\u0018\u001a\u00020\u000fH\u0002R4\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0004@BX\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\"\u0010\n\u001a\u00020\b8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "K", "V", "T", "", "", "", "buffer", "", "dataSize", "index", "", "reset", "([Ljava/lang/Object;II)V", "([Ljava/lang/Object;I)V", "", "hasNextKey", "currentKey", "()Ljava/lang/Object;", "moveToNextKey", "hasNextNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "currentNode", "moveToNextNode", "hasNext", "<set-?>", "[Ljava/lang/Object;", "a", "()[Ljava/lang/Object;", "I", "b", "()I", "c", "(I)V", "<init>", "()V", "runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class TrieNodeBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {
    @NotNull
    private Object[] buffer = TrieNode.Companion.getEMPTY$runtime_release().getBuffer$runtime_release();
    private int dataSize;
    private int index;

    @NotNull
    public final Object[] a() {
        return this.buffer;
    }

    public final int b() {
        return this.index;
    }

    public final void c(int i11) {
        this.index = i11;
    }

    public final K currentKey() {
        CommonFunctionsKt.m2551assert(hasNextKey());
        return this.buffer[this.index];
    }

    @NotNull
    public final TrieNode<? extends K, ? extends V> currentNode() {
        CommonFunctionsKt.m2551assert(hasNextNode());
        Object obj = this.buffer[this.index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        return (TrieNode) obj;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        return hasNextKey();
    }

    public final boolean hasNextKey() {
        return this.index < this.dataSize;
    }

    public final boolean hasNextNode() {
        boolean z11;
        if (this.index >= this.dataSize) {
            z11 = true;
        } else {
            z11 = false;
        }
        CommonFunctionsKt.m2551assert(z11);
        if (this.index < this.buffer.length) {
            return true;
        }
        return false;
    }

    public final void moveToNextKey() {
        CommonFunctionsKt.m2551assert(hasNextKey());
        this.index += 2;
    }

    public final void moveToNextNode() {
        CommonFunctionsKt.m2551assert(hasNextNode());
        this.index++;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void reset(@NotNull Object[] objArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(objArr, "buffer");
        this.buffer = objArr;
        this.dataSize = i11;
        this.index = i12;
    }

    public final void reset(@NotNull Object[] objArr, int i11) {
        Intrinsics.checkNotNullParameter(objArr, "buffer");
        reset(objArr, i11, 0);
    }
}
