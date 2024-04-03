package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\t\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\u000bR&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\r8\u0004X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00038\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\t\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b\t\u0010\u0019\u0012\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetIterator;", "E", "", "", "pathIndex", "moveToNextNodeWithData", "", "ensureNextElementIsReady", "", "hasNext", "next", "()Ljava/lang/Object;", "a", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNodeIterator;", "path", "Ljava/util/List;", "b", "()Ljava/util/List;", "pathLastIndex", "I", "getPathLastIndex", "()I", "c", "(I)V", "Z", "getHasNext$annotations", "()V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "node", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;)V", "runtime_release"}, k = 1, mv = {1, 7, 1})
public class PersistentHashSetIterator<E> implements Iterator<E>, KMappedMarker, j$.util.Iterator {
    private boolean hasNext = true;
    @NotNull
    private final List<TrieNodeIterator<E>> path;
    private int pathLastIndex;

    public PersistentHashSetIterator(@NotNull TrieNode<E> trieNode) {
        Intrinsics.checkNotNullParameter(trieNode, "node");
        List<TrieNodeIterator<E>> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TrieNodeIterator());
        this.path = mutableListOf;
        TrieNodeIterator.reset$default(mutableListOf.get(0), trieNode.getBuffer(), 0, 2, (Object) null);
        this.pathLastIndex = 0;
        ensureNextElementIsReady();
    }

    private final void ensureNextElementIsReady() {
        if (!this.path.get(this.pathLastIndex).hasNextElement()) {
            for (int i11 = this.pathLastIndex; -1 < i11; i11--) {
                int moveToNextNodeWithData = moveToNextNodeWithData(i11);
                if (moveToNextNodeWithData == -1 && this.path.get(i11).hasNextCell()) {
                    this.path.get(i11).moveToNextCell();
                    moveToNextNodeWithData = moveToNextNodeWithData(i11);
                }
                if (moveToNextNodeWithData != -1) {
                    this.pathLastIndex = moveToNextNodeWithData;
                    return;
                }
                if (i11 > 0) {
                    this.path.get(i11 - 1).moveToNextCell();
                }
                this.path.get(i11).reset(TrieNode.Companion.getEMPTY$runtime_release().getBuffer(), 0);
            }
            this.hasNext = false;
        }
    }

    private static /* synthetic */ void getHasNext$annotations() {
    }

    private final int moveToNextNodeWithData(int i11) {
        if (this.path.get(i11).hasNextElement()) {
            return i11;
        }
        if (!this.path.get(i11).hasNextNode()) {
            return -1;
        }
        TrieNode currentNode = this.path.get(i11).currentNode();
        int i12 = i11 + 1;
        if (i12 == this.path.size()) {
            this.path.add(new TrieNodeIterator());
        }
        TrieNodeIterator.reset$default(this.path.get(i12), currentNode.getBuffer(), 0, 2, (Object) null);
        return moveToNextNodeWithData(i12);
    }

    public final E a() {
        CommonFunctionsKt.m2551assert(hasNext());
        return this.path.get(this.pathLastIndex).currentElement();
    }

    @NotNull
    public final List<TrieNodeIterator<E>> b() {
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

    public E next() {
        if (this.hasNext) {
            E nextElement = this.path.get(this.pathLastIndex).nextElement();
            ensureNextElementIsReady();
            return nextElement;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
