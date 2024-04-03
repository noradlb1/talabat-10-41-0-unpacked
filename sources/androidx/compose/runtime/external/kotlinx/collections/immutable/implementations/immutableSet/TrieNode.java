package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 _*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001_B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0002\u0010\u0007B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0004H\u0002J\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u0004H\u0002J#\u0010)\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u0015\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0015\u00102\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b3JE\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00028\u00002\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010:J=\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010?J3\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010AJ5\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D¢\u0006\u0002\u0010EJ6\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ+\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010JJ'\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002¢\u0006\u0002\u0010LJ,\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J'\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002¢\u0006\u0002\u0010LJ(\u0010O\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J\u001e\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J(\u0010Q\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J;\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010?J5\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D¢\u0006\u0002\u0010EJ2\u0010T\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ&\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J2\u0010W\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ,\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00109\u001a\u00020\tH\u0002J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002J)\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ\u001e\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J$\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006`"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "E", "", "bitmap", "", "buffer", "", "(I[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(I[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "getBitmap", "()I", "setBitmap", "(I)V", "getBuffer", "()[Ljava/lang/Object;", "setBuffer", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getOwnedBy", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnedBy", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "add", "elementHash", "element", "shift", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "addElementAt", "positionMask", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "calculateSize", "collisionAdd", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "collisionContainsElement", "", "(Ljava/lang/Object;)Z", "collisionRemove", "collisionRemoveElementAtIndex", "i", "contains", "(ILjava/lang/Object;I)Z", "containsAll", "otherNode", "elementAtIndex", "index", "(I)Ljava/lang/Object;", "elementsIdentityEquals", "hasNoCellAt", "indexOfCellAt", "indexOfCellAt$runtime_release", "makeNode", "elementHash1", "element1", "elementHash2", "element2", "owner", "(ILjava/lang/Object;ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "makeNodeAtIndex", "elementIndex", "newElementHash", "newElement", "(IILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "moveElementToNode", "(IILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAdd", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAddAll", "intersectionSizeRef", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableAddElementAt", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAdd", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAddAll", "mutableCollisionRemove", "mutableCollisionRemoveAll", "mutableCollisionRemoveElementAtIndex", "mutableCollisionRetainAll", "mutableMoveElementToNode", "mutableRemove", "mutableRemoveAll", "mutableRemoveCellAtIndex", "cellIndex", "mutableRetainAll", "mutableUpdateNodeAtIndex", "nodeIndex", "newNode", "nodeAtIndex", "remove", "removeCellAtIndex", "updateNodeAtIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TrieNode<E> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final TrieNode EMPTY = new TrieNode(0, new Object[0]);
    private int bitmap;
    @NotNull
    private Object[] buffer;
    @Nullable
    private MutabilityOwnership ownedBy;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.EMPTY;
        }
    }

    public TrieNode(int i11, @NotNull Object[] objArr, @Nullable MutabilityOwnership mutabilityOwnership) {
        Intrinsics.checkNotNullParameter(objArr, "buffer");
        this.bitmap = i11;
        this.buffer = objArr;
        this.ownedBy = mutabilityOwnership;
    }

    private final TrieNode<E> addElementAt(int i11, E e11) {
        return new TrieNode<>(i11 | this.bitmap, TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release(i11), e11));
    }

    private final int calculateSize() {
        int i11;
        if (this.bitmap == 0) {
            return this.buffer.length;
        }
        int i12 = 0;
        for (Object obj : this.buffer) {
            if (obj instanceof TrieNode) {
                i11 = ((TrieNode) obj).calculateSize();
            } else {
                i11 = 1;
            }
            i12 += i11;
        }
        return i12;
    }

    private final TrieNode<E> collisionAdd(E e11) {
        if (collisionContainsElement(e11)) {
            return this;
        }
        return new TrieNode<>(0, TrieNodeKt.addElementAtIndex(this.buffer, 0, e11));
    }

    private final boolean collisionContainsElement(E e11) {
        return ArraysKt___ArraysKt.contains((T[]) this.buffer, e11);
    }

    private final TrieNode<E> collisionRemove(E e11) {
        int indexOf = ArraysKt___ArraysKt.indexOf((T[]) this.buffer, e11);
        if (indexOf != -1) {
            return collisionRemoveElementAtIndex(indexOf);
        }
        return this;
    }

    private final TrieNode<E> collisionRemoveElementAtIndex(int i11) {
        return new TrieNode<>(0, TrieNodeKt.removeCellAtIndex(this.buffer, i11));
    }

    private final E elementAtIndex(int i11) {
        return this.buffer[i11];
    }

    private final boolean elementsIdentityEquals(TrieNode<E> trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.bitmap != trieNode.bitmap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (this.buffer[i11] != trieNode.buffer[i11]) {
                return false;
            }
        }
        return true;
    }

    private final boolean hasNoCellAt(int i11) {
        return (i11 & this.bitmap) == 0;
    }

    private final TrieNode<E> makeNode(int i11, E e11, int i12, E e12, int i13, MutabilityOwnership mutabilityOwnership) {
        int i14 = i13;
        MutabilityOwnership mutabilityOwnership2 = mutabilityOwnership;
        if (i14 > 30) {
            return new TrieNode<>(0, new Object[]{e11, e12}, mutabilityOwnership2);
        }
        int i15 = i11;
        int indexSegment = TrieNodeKt.indexSegment(i11, i14);
        int i16 = i12;
        int indexSegment2 = TrieNodeKt.indexSegment(i12, i14);
        if (indexSegment != indexSegment2) {
            return new TrieNode<>((1 << indexSegment) | (1 << indexSegment2), indexSegment < indexSegment2 ? new Object[]{e11, e12} : new Object[]{e12, e11}, mutabilityOwnership2);
        }
        return new TrieNode<>(1 << indexSegment, new Object[]{makeNode(i11, e11, i12, e12, i14 + 5, mutabilityOwnership)}, mutabilityOwnership2);
    }

    private final TrieNode<E> makeNodeAtIndex(int i11, int i12, E e11, int i13, MutabilityOwnership mutabilityOwnership) {
        int i14;
        Object elementAtIndex = elementAtIndex(i11);
        if (elementAtIndex != null) {
            i14 = elementAtIndex.hashCode();
        } else {
            i14 = 0;
        }
        return makeNode(i14, elementAtIndex, i12, e11, i13 + 5, mutabilityOwnership);
    }

    private final TrieNode<E> moveElementToNode(int i11, int i12, E e11, int i13) {
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i11] = makeNodeAtIndex(i11, i12, e11, i13, (MutabilityOwnership) null);
        return new TrieNode<>(this.bitmap, copyOf);
    }

    private final TrieNode<E> mutableAddElementAt(int i11, E e11, MutabilityOwnership mutabilityOwnership) {
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(i11);
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, e11);
            this.bitmap = i11 | this.bitmap;
            return this;
        }
        return new TrieNode<>(i11 | this.bitmap, TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, e11), mutabilityOwnership);
    }

    private final TrieNode<E> mutableCollisionAdd(E e11, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        if (collisionContainsElement(e11)) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
        if (this.ownedBy != persistentHashSetBuilder.getOwnership$runtime_release()) {
            return new TrieNode<>(0, TrieNodeKt.addElementAtIndex(this.buffer, 0, e11), persistentHashSetBuilder.getOwnership$runtime_release());
        }
        this.buffer = TrieNodeKt.addElementAtIndex(this.buffer, 0, e11);
        return this;
    }

    private final TrieNode<E> mutableCollisionAddAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        boolean z11;
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + trieNode.buffer.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Object[] objArr2 = trieNode.buffer;
        int length = this.buffer.length;
        int i11 = 0;
        for (int i12 = 0; i12 < objArr2.length; i12++) {
            boolean z12 = true;
            if (i11 <= i12) {
                z11 = true;
            } else {
                z11 = false;
            }
            CommonFunctionsKt.m2551assert(z11);
            if (!collisionContainsElement(objArr2[i12])) {
                copyOf[length + i11] = objArr2[i12];
                i11++;
                if (length + i11 > copyOf.length) {
                    z12 = false;
                }
                CommonFunctionsKt.m2551assert(z12);
            }
        }
        int length2 = i11 + this.buffer.length;
        deltaCounter.plusAssign(copyOf.length - length2);
        if (length2 == this.buffer.length) {
            return this;
        }
        if (length2 == trieNode.buffer.length) {
            return trieNode;
        }
        if (length2 != copyOf.length) {
            copyOf = Arrays.copyOf(copyOf, length2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        }
        if (!Intrinsics.areEqual((Object) this.ownedBy, (Object) mutabilityOwnership)) {
            return new TrieNode<>(0, copyOf, mutabilityOwnership);
        }
        this.buffer = copyOf;
        return this;
    }

    private final TrieNode<E> mutableCollisionRemove(E e11, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        int indexOf = ArraysKt___ArraysKt.indexOf((T[]) this.buffer, e11);
        if (indexOf == -1) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() - 1);
        return mutableCollisionRemoveElementAtIndex(indexOf, persistentHashSetBuilder.getOwnership$runtime_release());
    }

    private final Object mutableCollisionRemoveAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr;
        boolean z11;
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return EMPTY;
        }
        if (Intrinsics.areEqual((Object) mutabilityOwnership, (Object) this.ownedBy)) {
            objArr = this.buffer;
        } else {
            objArr = new Object[this.buffer.length];
        }
        Object[] objArr2 = this.buffer;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            boolean z12 = true;
            if (i11 >= objArr2.length) {
                break;
            }
            if (i12 <= i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            CommonFunctionsKt.m2551assert(z11);
            if (!trieNode.collisionContainsElement(objArr2[i11])) {
                objArr[0 + i12] = objArr2[i11];
                i12++;
                if (0 + i12 > objArr.length) {
                    z12 = false;
                }
                CommonFunctionsKt.m2551assert(z12);
            }
            i11++;
        }
        deltaCounter.plusAssign(this.buffer.length - i12);
        if (i12 == 0) {
            return EMPTY;
        }
        if (i12 == 1) {
            return objArr[0];
        }
        if (i12 == this.buffer.length) {
            return this;
        }
        if (i12 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i12);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, mutabilityOwnership);
    }

    private final TrieNode<E> mutableCollisionRemoveElementAtIndex(int i11, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(0, TrieNodeKt.removeCellAtIndex(this.buffer, i11), mutabilityOwnership);
        }
        this.buffer = TrieNodeKt.removeCellAtIndex(this.buffer, i11);
        return this;
    }

    private final Object mutableCollisionRetainAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr;
        boolean z11;
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        if (Intrinsics.areEqual((Object) mutabilityOwnership, (Object) this.ownedBy)) {
            objArr = this.buffer;
        } else {
            objArr = new Object[Math.min(this.buffer.length, trieNode.buffer.length)];
        }
        Object[] objArr2 = this.buffer;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            boolean z12 = true;
            if (i11 >= objArr2.length) {
                break;
            }
            if (i12 <= i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            CommonFunctionsKt.m2551assert(z11);
            if (trieNode.collisionContainsElement(objArr2[i11])) {
                objArr[0 + i12] = objArr2[i11];
                i12++;
                if (0 + i12 > objArr.length) {
                    z12 = false;
                }
                CommonFunctionsKt.m2551assert(z12);
            }
            i11++;
        }
        deltaCounter.plusAssign(i12);
        if (i12 == 0) {
            return EMPTY;
        }
        if (i12 == 1) {
            return objArr[0];
        }
        if (i12 == this.buffer.length) {
            return this;
        }
        if (i12 == trieNode.buffer.length) {
            return trieNode;
        }
        if (i12 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i12);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, mutabilityOwnership);
    }

    private final TrieNode<E> mutableMoveElementToNode(int i11, int i12, E e11, int i13, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer[i11] = makeNodeAtIndex(i11, i12, e11, i13, mutabilityOwnership);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i11] = makeNodeAtIndex(i11, i12, e11, i13, mutabilityOwnership);
        return new TrieNode<>(this.bitmap, copyOf, mutabilityOwnership);
    }

    private final TrieNode<E> mutableRemoveCellAtIndex(int i11, int i12, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = TrieNodeKt.removeCellAtIndex(this.buffer, i11);
            this.bitmap ^= i12;
            return this;
        }
        return new TrieNode<>(i12 ^ this.bitmap, TrieNodeKt.removeCellAtIndex(this.buffer, i11), mutabilityOwnership);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableUpdateNodeAtIndex(int r4, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r5, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r6) {
        /*
            r3 = this;
            java.lang.Object[] r0 = r5.buffer
            int r1 = r0.length
            r2 = 1
            if (r1 != r2) goto L_0x0018
            r1 = 0
            r0 = r0[r1]
            boolean r1 = r0 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r1 != 0) goto L_0x0018
            java.lang.Object[] r1 = r3.buffer
            int r1 = r1.length
            if (r1 != r2) goto L_0x0017
            int r4 = r3.bitmap
            r5.bitmap = r4
            return r5
        L_0x0017:
            r5 = r0
        L_0x0018:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r0 = r3.ownedBy
            if (r0 != r6) goto L_0x0021
            java.lang.Object[] r6 = r3.buffer
            r6[r4] = r5
            return r3
        L_0x0021:
            java.lang.Object[] r0 = r3.buffer
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.lang.String r1 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0[r4] = r5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r4 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r5 = r3.bitmap
            r4.<init>(r5, r0, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableUpdateNodeAtIndex(int, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    private final TrieNode<E> nodeAtIndex(int i11) {
        Object obj = this.buffer[i11];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        return (TrieNode) obj;
    }

    private final TrieNode<E> removeCellAtIndex(int i11, int i12) {
        return new TrieNode<>(i12 ^ this.bitmap, TrieNodeKt.removeCellAtIndex(this.buffer, i11));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> updateNodeAtIndex(int r4, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r5) {
        /*
            r3 = this;
            java.lang.Object[] r0 = r5.buffer
            int r1 = r0.length
            r2 = 1
            if (r1 != r2) goto L_0x0018
            r1 = 0
            r0 = r0[r1]
            boolean r1 = r0 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r1 != 0) goto L_0x0018
            java.lang.Object[] r1 = r3.buffer
            int r1 = r1.length
            if (r1 != r2) goto L_0x0017
            int r4 = r3.bitmap
            r5.bitmap = r4
            return r5
        L_0x0017:
            r5 = r0
        L_0x0018:
            java.lang.Object[] r0 = r3.buffer
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.lang.String r1 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0[r4] = r5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r4 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r5 = r3.bitmap
            r4.<init>(r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.updateNodeAtIndex(int, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    @NotNull
    public final TrieNode<E> add(int i11, E e11, int i12) {
        TrieNode trieNode;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasNoCellAt(indexSegment)) {
            return addElementAt(indexSegment, e11);
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (i12 == 30) {
                trieNode = nodeAtIndex.collisionAdd(e11);
            } else {
                trieNode = nodeAtIndex.add(i11, e11, i12 + 5);
            }
            if (nodeAtIndex == trieNode) {
                return this;
            }
            return updateNodeAtIndex(indexOfCellAt$runtime_release, trieNode);
        } else if (Intrinsics.areEqual((Object) e11, obj)) {
            return this;
        } else {
            return moveElementToNode(indexOfCellAt$runtime_release, i11, e11, i12);
        }
    }

    public final boolean contains(int i11, E e11, int i12) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasNoCellAt(indexSegment)) {
            return false;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (!(obj instanceof TrieNode)) {
            return Intrinsics.areEqual((Object) e11, obj);
        }
        TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
        if (i12 == 30) {
            return nodeAtIndex.collisionContainsElement(e11);
        }
        return nodeAtIndex.contains(i11, e11, i12 + 5);
    }

    public final boolean containsAll(@NotNull TrieNode<E> trieNode, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(trieNode, "otherNode");
        if (this == trieNode) {
            return true;
        }
        if (i11 > 30) {
            for (Object contains : trieNode.buffer) {
                if (!ArraysKt___ArraysKt.contains((T[]) this.buffer, contains)) {
                    return false;
                }
            }
            return true;
        }
        int i13 = this.bitmap;
        int i14 = trieNode.bitmap;
        int i15 = i13 & i14;
        if (i15 != i14) {
            return false;
        }
        while (i15 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i15);
            int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
            int indexOfCellAt$runtime_release2 = trieNode.indexOfCellAt$runtime_release(lowestOneBit);
            Object obj = this.buffer[indexOfCellAt$runtime_release];
            Object obj2 = trieNode.buffer[indexOfCellAt$runtime_release2];
            boolean z11 = obj instanceof TrieNode;
            boolean z12 = obj2 instanceof TrieNode;
            if (z11 && z12) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
                if (!((TrieNode) obj).containsAll((TrieNode) obj2, i11 + 5)) {
                    return false;
                }
            } else if (z11) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
                TrieNode trieNode2 = (TrieNode) obj;
                if (obj2 != null) {
                    i12 = obj2.hashCode();
                } else {
                    i12 = 0;
                }
                if (!trieNode2.contains(i12, obj2, i11 + 5)) {
                    return false;
                }
            } else if (z12 || !Intrinsics.areEqual(obj, obj2)) {
                return false;
            }
            i15 ^= lowestOneBit;
        }
        return true;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    @NotNull
    public final Object[] getBuffer() {
        return this.buffer;
    }

    @Nullable
    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    public final int indexOfCellAt$runtime_release(int i11) {
        return Integer.bitCount((i11 - 1) & this.bitmap);
    }

    @NotNull
    public final TrieNode<E> mutableAdd(int i11, E e11, int i12, @NotNull PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode<?> trieNode;
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasNoCellAt(indexSegment)) {
            persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
            return mutableAddElementAt(indexSegment, e11, persistentHashSetBuilder.getOwnership$runtime_release());
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode<?> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (i12 == 30) {
                trieNode = nodeAtIndex.mutableCollisionAdd(e11, persistentHashSetBuilder);
            } else {
                trieNode = nodeAtIndex.mutableAdd(i11, e11, i12 + 5, persistentHashSetBuilder);
            }
            if (nodeAtIndex == trieNode) {
                return this;
            }
            return mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, trieNode, persistentHashSetBuilder.getOwnership$runtime_release());
        } else if (Intrinsics.areEqual((Object) e11, obj)) {
            return this;
        } else {
            persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
            return mutableMoveElementToNode(indexOfCellAt$runtime_release, i11, e11, i12, persistentHashSetBuilder.getOwnership$runtime_release());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableAddAll(@org.jetbrains.annotations.NotNull androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r20, int r21, @org.jetbrains.annotations.NotNull androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter r22, @org.jetbrains.annotations.NotNull androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> r23) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
            java.lang.String r0 = "otherNode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "intersectionSizeRef"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "mutator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            if (r7 != r8) goto L_0x0028
            int r0 = r22.getCount()
            int r1 = r19.calculateSize()
            int r0 = r0 + r1
            r10.setCount(r0)
            return r7
        L_0x0028:
            r0 = 30
            if (r9 <= r0) goto L_0x0035
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r0 = r23.getOwnership$runtime_release()
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r7.mutableCollisionAddAll(r8, r10, r0)
            return r0
        L_0x0035:
            int r0 = r7.bitmap
            int r1 = r8.bitmap
            r1 = r1 | r0
            if (r1 != r0) goto L_0x004a
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r0 = r7.ownedBy
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r2 = r23.getOwnership$runtime_release()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x004a
            r12 = r7
            goto L_0x005a
        L_0x004a:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r2 = java.lang.Integer.bitCount(r1)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r3 = r23.getOwnership$runtime_release()
            r0.<init>(r1, r2, r3)
            r12 = r0
        L_0x005a:
            r13 = 0
            r14 = r1
            r15 = r13
        L_0x005d:
            if (r14 == 0) goto L_0x0144
            int r6 = java.lang.Integer.lowestOneBit(r14)
            int r0 = r7.indexOfCellAt$runtime_release(r6)
            int r1 = r8.indexOfCellAt$runtime_release(r6)
            java.lang.Object[] r5 = r12.buffer
            boolean r2 = r7.hasNoCellAt(r6)
            if (r2 == 0) goto L_0x007d
            java.lang.Object[] r0 = r8.buffer
            r0 = r0[r1]
        L_0x0077:
            r18 = r5
            r16 = r6
            goto L_0x013c
        L_0x007d:
            boolean r2 = r8.hasNoCellAt(r6)
            if (r2 == 0) goto L_0x0088
            java.lang.Object[] r1 = r7.buffer
            r0 = r1[r0]
            goto L_0x0077
        L_0x0088:
            java.lang.Object[] r2 = r7.buffer
            r2 = r2[r0]
            java.lang.Object[] r0 = r8.buffer
            r4 = r0[r1]
            boolean r0 = r2 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            boolean r1 = r4 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda-6>"
            if (r0 == 0) goto L_0x00ab
            if (r1 == 0) goto L_0x00ab
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r2 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r4 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r4
            int r0 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r2.mutableAddAll(r4, r0, r10, r11)
            goto L_0x0077
        L_0x00ab:
            if (r0 == 0) goto L_0x00d7
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r2 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r2
            int r0 = r23.size()
            if (r4 == 0) goto L_0x00bd
            int r1 = r4.hashCode()
            goto L_0x00be
        L_0x00bd:
            r1 = r13
        L_0x00be:
            int r3 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = r2.mutableAdd(r1, r4, r3, r11)
            int r2 = r23.size()
            if (r2 != r0) goto L_0x00d3
            int r0 = r22.getCount()
            int r0 = r0 + 1
            r10.setCount(r0)
        L_0x00d3:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x00d5:
            r0 = r1
            goto L_0x0077
        L_0x00d7:
            if (r1 == 0) goto L_0x0102
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r4 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r4
            int r0 = r23.size()
            if (r2 == 0) goto L_0x00e9
            int r1 = r2.hashCode()
            goto L_0x00ea
        L_0x00e9:
            r1 = r13
        L_0x00ea:
            int r3 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = r4.mutableAdd(r1, r2, r3, r11)
            int r2 = r23.size()
            if (r2 != r0) goto L_0x00ff
            int r0 = r22.getCount()
            int r0 = r0 + 1
            r10.setCount(r0)
        L_0x00ff:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x00d5
        L_0x0102:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x0116
            int r0 = r22.getCount()
            int r0 = r0 + 1
            r10.setCount(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = r2
            goto L_0x0077
        L_0x0116:
            if (r2 == 0) goto L_0x011e
            int r0 = r2.hashCode()
            r1 = r0
            goto L_0x011f
        L_0x011e:
            r1 = r13
        L_0x011f:
            if (r4 == 0) goto L_0x0127
            int r0 = r4.hashCode()
            r3 = r0
            goto L_0x0128
        L_0x0127:
            r3 = r13
        L_0x0128:
            int r16 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r17 = r23.getOwnership$runtime_release()
            r0 = r19
            r18 = r5
            r5 = r16
            r16 = r6
            r6 = r17
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r0.makeNode(r1, r2, r3, r4, r5, r6)
        L_0x013c:
            r18[r15] = r0
            int r15 = r15 + 1
            r14 = r14 ^ r16
            goto L_0x005d
        L_0x0144:
            boolean r0 = r7.elementsIdentityEquals(r12)
            if (r0 == 0) goto L_0x014c
            r12 = r7
            goto L_0x0153
        L_0x014c:
            boolean r0 = r8.elementsIdentityEquals(r12)
            if (r0 == 0) goto L_0x0153
            r12 = r8
        L_0x0153:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, int, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    @NotNull
    public final TrieNode<E> mutableRemove(int i11, E e11, int i12, @NotNull PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode<?> trieNode;
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasNoCellAt(indexSegment)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode<?> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (i12 == 30) {
                trieNode = nodeAtIndex.mutableCollisionRemove(e11, persistentHashSetBuilder);
            } else {
                trieNode = nodeAtIndex.mutableRemove(i11, e11, i12 + 5, persistentHashSetBuilder);
            }
            if (this.ownedBy == persistentHashSetBuilder.getOwnership$runtime_release() || nodeAtIndex != trieNode) {
                return mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, trieNode, persistentHashSetBuilder.getOwnership$runtime_release());
            }
            return this;
        } else if (!Intrinsics.areEqual((Object) e11, obj)) {
            return this;
        } else {
            persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() - 1);
            return mutableRemoveCellAtIndex(indexOfCellAt$runtime_release, indexSegment, persistentHashSetBuilder.getOwnership$runtime_release());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c0, code lost:
        if ((r13 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) == false) goto L_0x00ef;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object mutableRemoveAll(@org.jetbrains.annotations.NotNull androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r17, int r18, @org.jetbrains.annotations.NotNull androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter r19, @org.jetbrains.annotations.NotNull androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            java.lang.String r5 = "otherNode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.lang.String r5 = "intersectionSizeRef"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "mutator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            if (r0 != r1) goto L_0x0025
            int r1 = r16.calculateSize()
            r3.plusAssign(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = EMPTY
            return r1
        L_0x0025:
            r5 = 30
            if (r2 <= r5) goto L_0x0032
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r2 = r20.getOwnership$runtime_release()
            java.lang.Object r1 = r0.mutableCollisionRemoveAll(r1, r3, r2)
            return r1
        L_0x0032:
            int r5 = r0.bitmap
            int r6 = r1.bitmap
            r5 = r5 & r6
            if (r5 != 0) goto L_0x003a
            return r0
        L_0x003a:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r6 = r0.ownedBy
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r7 = r20.getOwnership$runtime_release()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0048
            r6 = r0
            goto L_0x005f
        L_0x0048:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r6 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r7 = r0.bitmap
            java.lang.Object[] r8 = r0.buffer
            int r9 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
            java.lang.String r9 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r9 = r20.getOwnership$runtime_release()
            r6.<init>(r7, r8, r9)
        L_0x005f:
            int r7 = r0.bitmap
        L_0x0061:
            if (r5 == 0) goto L_0x00fb
            int r10 = java.lang.Integer.lowestOneBit(r5)
            int r11 = r0.indexOfCellAt$runtime_release(r10)
            int r12 = r1.indexOfCellAt$runtime_release(r10)
            java.lang.Object[] r13 = r0.buffer
            r13 = r13[r11]
            java.lang.Object[] r14 = r1.buffer
            r12 = r14[r12]
            boolean r14 = r13 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            boolean r15 = r12 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            java.lang.String r8 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda-11$lambda-10>"
            if (r14 == 0) goto L_0x0092
            if (r15 == 0) goto L_0x0092
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r8)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r13 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r13
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r8)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r12 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r12
            int r8 = r2 + 5
            java.lang.Object r13 = r13.mutableRemoveAll(r12, r8, r3, r4)
            goto L_0x00ef
        L_0x0092:
            if (r14 == 0) goto L_0x00c5
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r8)
            r8 = r13
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r8 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r8
            int r14 = r20.size()
            if (r12 == 0) goto L_0x00a5
            int r15 = r12.hashCode()
            goto L_0x00a6
        L_0x00a5:
            r15 = 0
        L_0x00a6:
            int r9 = r2 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r8 = r8.mutableRemove(r15, r12, r9, r4)
            int r9 = r20.size()
            if (r14 == r9) goto L_0x00ef
            r9 = 1
            r3.plusAssign(r9)
            java.lang.Object[] r12 = r8.buffer
            int r13 = r12.length
            if (r13 != r9) goto L_0x00c3
            r9 = 0
            r13 = r12[r9]
            boolean r9 = r13 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r9 != 0) goto L_0x00c3
            goto L_0x00ef
        L_0x00c3:
            r13 = r8
            goto L_0x00ef
        L_0x00c5:
            if (r15 == 0) goto L_0x00e3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r8)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r12 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r12
            if (r13 == 0) goto L_0x00d3
            int r8 = r13.hashCode()
            goto L_0x00d4
        L_0x00d3:
            r8 = 0
        L_0x00d4:
            int r9 = r2 + 5
            boolean r8 = r12.contains(r8, r13, r9)
            if (r8 == 0) goto L_0x00ef
            r8 = 1
            r3.plusAssign(r8)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r13 = EMPTY
            goto L_0x00ef
        L_0x00e3:
            r8 = 1
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r12)
            if (r9 == 0) goto L_0x00ef
            r3.plusAssign(r8)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r13 = EMPTY
        L_0x00ef:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r8 = EMPTY
            if (r13 != r8) goto L_0x00f4
            r7 = r7 ^ r10
        L_0x00f4:
            java.lang.Object[] r8 = r6.buffer
            r8[r11] = r13
            r5 = r5 ^ r10
            goto L_0x0061
        L_0x00fb:
            int r1 = java.lang.Integer.bitCount(r7)
            if (r7 != 0) goto L_0x0105
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r6 = EMPTY
            goto L_0x0174
        L_0x0105:
            int r3 = r0.bitmap
            if (r7 != r3) goto L_0x0112
            boolean r1 = r6.elementsIdentityEquals(r0)
            if (r1 == 0) goto L_0x0174
            r6 = r0
            goto L_0x0174
        L_0x0112:
            r9 = 1
            if (r1 != r9) goto L_0x0133
            if (r2 == 0) goto L_0x0133
            java.lang.Object[] r1 = r6.buffer
            int r2 = r6.indexOfCellAt$runtime_release(r7)
            r6 = r1[r2]
            boolean r1 = r6 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r1 == 0) goto L_0x0174
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            java.lang.Object[] r2 = new java.lang.Object[r9]
            r3 = 0
            r2[r3] = r6
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r3 = r20.getOwnership$runtime_release()
            r1.<init>(r7, r2, r3)
            r6 = r1
            goto L_0x0174
        L_0x0133:
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.Object[] r3 = r6.buffer
            r5 = 0
            r6 = 0
        L_0x0139:
            int r8 = r3.length
            if (r5 >= r8) goto L_0x016b
            if (r6 > r5) goto L_0x0140
            r8 = r9
            goto L_0x0141
        L_0x0140:
            r8 = 0
        L_0x0141:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt.m2551assert(r8)
            r8 = r3[r5]
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode$Companion r10 = Companion
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r10 = r10.getEMPTY$runtime_release()
            if (r8 == r10) goto L_0x0150
            r8 = r9
            goto L_0x0151
        L_0x0150:
            r8 = 0
        L_0x0151:
            if (r8 == 0) goto L_0x0167
            r8 = 0
            int r10 = r8 + r6
            r11 = r3[r5]
            r2[r10] = r11
            int r6 = r6 + 1
            int r10 = r8 + r6
            if (r10 > r1) goto L_0x0162
            r10 = r9
            goto L_0x0163
        L_0x0162:
            r10 = r8
        L_0x0163:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt.m2551assert(r10)
            goto L_0x0168
        L_0x0167:
            r8 = 0
        L_0x0168:
            int r5 = r5 + 1
            goto L_0x0139
        L_0x016b:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r6 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r1 = r20.getOwnership$runtime_release()
            r6.<init>(r7, r2, r1)
        L_0x0174:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, int, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder):java.lang.Object");
    }

    @Nullable
    public final Object mutableRetainAll(@NotNull TrieNode<E> trieNode, int i11, @NotNull DeltaCounter deltaCounter, @NotNull PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode trieNode2;
        TrieNode trieNode3;
        boolean z11;
        boolean z12;
        boolean z13;
        int i12;
        int i13;
        TrieNode<E> trieNode4 = trieNode;
        int i14 = i11;
        DeltaCounter deltaCounter2 = deltaCounter;
        PersistentHashSetBuilder<?> persistentHashSetBuilder2 = persistentHashSetBuilder;
        Intrinsics.checkNotNullParameter(trieNode4, "otherNode");
        Intrinsics.checkNotNullParameter(deltaCounter2, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder2, "mutator");
        if (this == trieNode4) {
            deltaCounter2.plusAssign(calculateSize());
            return this;
        } else if (i14 > 30) {
            return mutableCollisionRetainAll(trieNode4, deltaCounter2, persistentHashSetBuilder.getOwnership$runtime_release());
        } else {
            int i15 = this.bitmap & trieNode4.bitmap;
            if (i15 == 0) {
                return EMPTY;
            }
            if (!Intrinsics.areEqual((Object) this.ownedBy, (Object) persistentHashSetBuilder.getOwnership$runtime_release()) || i15 != this.bitmap) {
                trieNode2 = new TrieNode(i15, new Object[Integer.bitCount(i15)], persistentHashSetBuilder.getOwnership$runtime_release());
            } else {
                trieNode2 = this;
            }
            int i16 = i15;
            int i17 = 0;
            int i18 = 0;
            while (i16 != 0) {
                int lowestOneBit = Integer.lowestOneBit(i16);
                int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
                int indexOfCellAt$runtime_release2 = trieNode4.indexOfCellAt$runtime_release(lowestOneBit);
                Object obj = this.buffer[indexOfCellAt$runtime_release];
                Object obj2 = trieNode4.buffer[indexOfCellAt$runtime_release2];
                boolean z14 = obj instanceof TrieNode;
                boolean z15 = obj2 instanceof TrieNode;
                if (z14 && z15) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                    obj = ((TrieNode) obj).mutableRetainAll((TrieNode) obj2, i14 + 5, deltaCounter2, persistentHashSetBuilder2);
                } else if (z14) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                    TrieNode trieNode5 = (TrieNode) obj;
                    if (obj2 != null) {
                        i13 = obj2.hashCode();
                    } else {
                        i13 = 0;
                    }
                    if (trieNode5.contains(i13, obj2, i14 + 5)) {
                        deltaCounter2.plusAssign(1);
                        obj = obj2;
                    } else {
                        obj = EMPTY;
                    }
                } else if (z15) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                    TrieNode trieNode6 = (TrieNode) obj2;
                    if (obj != null) {
                        i12 = obj.hashCode();
                    } else {
                        i12 = 0;
                    }
                    if (trieNode6.contains(i12, obj, i14 + 5)) {
                        deltaCounter2.plusAssign(1);
                    } else {
                        obj = EMPTY;
                    }
                } else if (Intrinsics.areEqual(obj, obj2)) {
                    deltaCounter2.plusAssign(1);
                } else {
                    obj = EMPTY;
                }
                if (obj != EMPTY) {
                    i17 |= lowestOneBit;
                }
                trieNode2.buffer[i18] = obj;
                i18++;
                i16 ^= lowestOneBit;
            }
            int bitCount = Integer.bitCount(i17);
            if (i17 == 0) {
                return EMPTY;
            }
            if (i17 != i15) {
                if (bitCount != 1 || i14 == 0) {
                    Object[] objArr = new Object[bitCount];
                    Object[] objArr2 = trieNode2.buffer;
                    int i19 = 0;
                    for (int i21 = 0; i21 < objArr2.length; i21++) {
                        if (i19 <= i21) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        CommonFunctionsKt.m2551assert(z11);
                        if (objArr2[i21] != Companion.getEMPTY$runtime_release()) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            objArr[0 + i19] = objArr2[i21];
                            i19++;
                            if (0 + i19 <= bitCount) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            CommonFunctionsKt.m2551assert(z13);
                        }
                    }
                    trieNode3 = new TrieNode(i17, objArr, persistentHashSetBuilder.getOwnership$runtime_release());
                } else {
                    Object obj3 = trieNode2.buffer[trieNode2.indexOfCellAt$runtime_release(i17)];
                    if (!(obj3 instanceof TrieNode)) {
                        return obj3;
                    }
                    trieNode3 = new TrieNode(i17, new Object[]{obj3}, persistentHashSetBuilder.getOwnership$runtime_release());
                }
                return trieNode3;
            } else if (trieNode2.elementsIdentityEquals(this)) {
                return this;
            } else {
                if (trieNode2.elementsIdentityEquals(trieNode4)) {
                    return trieNode4;
                }
                return trieNode2;
            }
        }
    }

    @NotNull
    public final TrieNode<E> remove(int i11, E e11, int i12) {
        TrieNode trieNode;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasNoCellAt(indexSegment)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (i12 == 30) {
                trieNode = nodeAtIndex.collisionRemove(e11);
            } else {
                trieNode = nodeAtIndex.remove(i11, e11, i12 + 5);
            }
            if (nodeAtIndex == trieNode) {
                return this;
            }
            return updateNodeAtIndex(indexOfCellAt$runtime_release, trieNode);
        } else if (Intrinsics.areEqual((Object) e11, obj)) {
            return removeCellAtIndex(indexOfCellAt$runtime_release, indexSegment);
        } else {
            return this;
        }
    }

    public final void setBitmap(int i11) {
        this.bitmap = i11;
    }

    public final void setBuffer(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.buffer = objArr;
    }

    public final void setOwnedBy(@Nullable MutabilityOwnership mutabilityOwnership) {
        this.ownedBy = mutabilityOwnership;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TrieNode(int i11, @NotNull Object[] objArr) {
        this(i11, objArr, (MutabilityOwnership) null);
        Intrinsics.checkNotNullParameter(objArr, "buffer");
    }
}
