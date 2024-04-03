package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B;\u0012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u001e\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00110\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u000f\u0010\u000b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00028\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\fR2\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00110\u00108\u0004X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00058\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u0012\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "K", "V", "T", "", "", "pathIndex", "moveToNextNodeWithData", "", "ensureNextEntryIsReady", "checkHasNext", "a", "()Ljava/lang/Object;", "", "hasNext", "next", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "path", "[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "b", "()[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "pathLastIndex", "I", "getPathLastIndex", "()I", "c", "(I)V", "Z", "getHasNext$annotations", "()V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "node", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {
    private boolean hasNext = true;
    @NotNull
    private final TrieNodeBaseIterator<K, V, T>[] path;
    private int pathLastIndex;

    public PersistentHashMapBaseIterator(@NotNull TrieNode<K, V> trieNode, @NotNull TrieNodeBaseIterator<K, V, T>[] trieNodeBaseIteratorArr) {
        Intrinsics.checkNotNullParameter(trieNode, "node");
        Intrinsics.checkNotNullParameter(trieNodeBaseIteratorArr, "path");
        this.path = trieNodeBaseIteratorArr;
        trieNodeBaseIteratorArr[0].reset(trieNode.getBuffer$runtime_release(), trieNode.entryCount$runtime_release() * 2);
        this.pathLastIndex = 0;
        ensureNextEntryIsReady();
    }

    private final void checkHasNext() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    private final void ensureNextEntryIsReady() {
        if (!this.path[this.pathLastIndex].hasNextKey()) {
            for (int i11 = this.pathLastIndex; -1 < i11; i11--) {
                int moveToNextNodeWithData = moveToNextNodeWithData(i11);
                if (moveToNextNodeWithData == -1 && this.path[i11].hasNextNode()) {
                    this.path[i11].moveToNextNode();
                    moveToNextNodeWithData = moveToNextNodeWithData(i11);
                }
                if (moveToNextNodeWithData != -1) {
                    this.pathLastIndex = moveToNextNodeWithData;
                    return;
                }
                if (i11 > 0) {
                    this.path[i11 - 1].moveToNextNode();
                }
                this.path[i11].reset(TrieNode.Companion.getEMPTY$runtime_release().getBuffer$runtime_release(), 0);
            }
            this.hasNext = false;
        }
    }

    private static /* synthetic */ void getHasNext$annotations() {
    }

    private final int moveToNextNodeWithData(int i11) {
        if (this.path[i11].hasNextKey()) {
            return i11;
        }
        if (!this.path[i11].hasNextNode()) {
            return -1;
        }
        TrieNode<? extends K, ? extends V> currentNode = this.path[i11].currentNode();
        if (i11 == 6) {
            this.path[i11 + 1].reset(currentNode.getBuffer$runtime_release(), currentNode.getBuffer$runtime_release().length);
        } else {
            this.path[i11 + 1].reset(currentNode.getBuffer$runtime_release(), currentNode.entryCount$runtime_release() * 2);
        }
        return moveToNextNodeWithData(i11 + 1);
    }

    public final K a() {
        checkHasNext();
        return this.path[this.pathLastIndex].currentKey();
    }

    @NotNull
    public final TrieNodeBaseIterator<K, V, T>[] b() {
        return this.path;
    }

    public final void c(int i11) {
        this.pathLastIndex = i11;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public T next() {
        checkHasNext();
        T next = this.path[this.pathLastIndex].next();
        ensureNextEntryIsReady();
        return next;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
