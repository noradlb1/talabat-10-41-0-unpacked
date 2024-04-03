package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B9\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u001e\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00028\u0002H\u0002¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J5\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\r2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001b2\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0001¢\u0006\u0002\u0010!R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderBaseIterator;", "K", "V", "T", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "expectedModCount", "", "lastIteratedKey", "Ljava/lang/Object;", "nextWasInvoked", "", "checkForComodification", "", "checkNextWasInvoked", "next", "()Ljava/lang/Object;", "remove", "resetPath", "keyHash", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "key", "pathIndex", "(ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;Ljava/lang/Object;I)V", "setValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class PersistentHashMapBuilderBaseIterator<K, V, T> extends PersistentHashMapBaseIterator<K, V, T> implements KMutableIterator {
    @NotNull
    private final PersistentHashMapBuilder<K, V> builder;
    private int expectedModCount;
    @Nullable
    private K lastIteratedKey;
    private boolean nextWasInvoked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersistentHashMapBuilderBaseIterator(@NotNull PersistentHashMapBuilder<K, V> persistentHashMapBuilder, @NotNull TrieNodeBaseIterator<K, V, T>[] trieNodeBaseIteratorArr) {
        super(persistentHashMapBuilder.getNode$runtime_release(), trieNodeBaseIteratorArr);
        Intrinsics.checkNotNullParameter(persistentHashMapBuilder, "builder");
        Intrinsics.checkNotNullParameter(trieNodeBaseIteratorArr, "path");
        this.builder = persistentHashMapBuilder;
        this.expectedModCount = persistentHashMapBuilder.getModCount$runtime_release();
    }

    private final void checkForComodification() {
        if (this.builder.getModCount$runtime_release() != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void checkNextWasInvoked() {
        if (!this.nextWasInvoked) {
            throw new IllegalStateException();
        }
    }

    private final void resetPath(int i11, TrieNode<?, ?> trieNode, K k11, int i12) {
        int i13 = i12 * 5;
        if (i13 > 30) {
            b()[i12].reset(trieNode.getBuffer$runtime_release(), trieNode.getBuffer$runtime_release().length, 0);
            while (!Intrinsics.areEqual(b()[i12].currentKey(), (Object) k11)) {
                b()[i12].moveToNextKey();
            }
            c(i12);
            return;
        }
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i13);
        if (trieNode.hasEntryAt$runtime_release(indexSegment)) {
            b()[i12].reset(trieNode.getBuffer$runtime_release(), trieNode.entryCount$runtime_release() * 2, trieNode.entryKeyIndex$runtime_release(indexSegment));
            c(i12);
            return;
        }
        int nodeIndex$runtime_release = trieNode.nodeIndex$runtime_release(indexSegment);
        TrieNode<?, ?> nodeAtIndex$runtime_release = trieNode.nodeAtIndex$runtime_release(nodeIndex$runtime_release);
        b()[i12].reset(trieNode.getBuffer$runtime_release(), trieNode.entryCount$runtime_release() * 2, nodeIndex$runtime_release);
        resetPath(i11, nodeAtIndex$runtime_release, k11, i12 + 1);
    }

    public T next() {
        checkForComodification();
        this.lastIteratedKey = a();
        this.nextWasInvoked = true;
        return super.next();
    }

    public void remove() {
        int i11;
        checkNextWasInvoked();
        if (hasNext()) {
            Object a11 = a();
            TypeIntrinsics.asMutableMap(this.builder).remove(this.lastIteratedKey);
            if (a11 != null) {
                i11 = a11.hashCode();
            } else {
                i11 = 0;
            }
            resetPath(i11, this.builder.getNode$runtime_release(), a11, 0);
        } else {
            TypeIntrinsics.asMutableMap(this.builder).remove(this.lastIteratedKey);
        }
        this.lastIteratedKey = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getModCount$runtime_release();
    }

    public final void setValue(K k11, V v11) {
        int i11;
        if (this.builder.containsKey(k11)) {
            if (hasNext()) {
                Object a11 = a();
                this.builder.put(k11, v11);
                if (a11 != null) {
                    i11 = a11.hashCode();
                } else {
                    i11 = 0;
                }
                resetPath(i11, this.builder.getNode$runtime_release(), a11, 0);
            } else {
                this.builder.put(k11, v11);
            }
            this.expectedModCount = this.builder.getModCount$runtime_release();
        }
    }
}
