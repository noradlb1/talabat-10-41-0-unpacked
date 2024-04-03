package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B-\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\r\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u000e\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010J\r\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J7\u0010\u0018\u001a\u00020\u00122\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0019\u0010\nR\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "root", "", "", "index", "", "size", "height", "([Ljava/lang/Object;III)V", "isInRightEdge", "", "path", "[Ljava/lang/Object;", "elementAtCurrentIndex", "()Ljava/lang/Object;", "fillPath", "", "startLevel", "fillPathIfNeeded", "indexPredicate", "next", "previous", "reset", "reset$runtime_release", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TrieIterator<E> extends AbstractListIterator<E> {
    private int height;
    private boolean isInRightEdge;
    @NotNull
    private Object[] path;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrieIterator(@NotNull Object[] objArr, int i11, int i12, int i13) {
        super(i11, i12);
        boolean z11;
        Intrinsics.checkNotNullParameter(objArr, "root");
        this.height = i13;
        Object[] objArr2 = new Object[i13];
        this.path = objArr2;
        if (i11 == i12) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.isInRightEdge = z11;
        objArr2[0] = objArr;
        fillPath(i11 - (z11 ? 1 : 0), 1);
    }

    private final E elementAtCurrentIndex() {
        Object obj = this.path[this.height - 1];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return ((Object[]) obj)[getIndex() & 31];
    }

    private final void fillPath(int i11, int i12) {
        int i13 = (this.height - i12) * 5;
        while (i12 < this.height) {
            Object[] objArr = this.path;
            Object[] objArr2 = objArr[i12 - 1];
            Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr[i12] = objArr2[UtilsKt.indexSegment(i11, i13)];
            i13 -= 5;
            i12++;
        }
    }

    private final void fillPathIfNeeded(int i11) {
        int i12 = 0;
        while (UtilsKt.indexSegment(getIndex(), i12) == i11) {
            i12 += 5;
        }
        if (i12 > 0) {
            fillPath(getIndex(), ((this.height - 1) - (i12 / 5)) + 1);
        }
    }

    public E next() {
        if (hasNext()) {
            E elementAtCurrentIndex = elementAtCurrentIndex();
            setIndex(getIndex() + 1);
            if (getIndex() == getSize()) {
                this.isInRightEdge = true;
                return elementAtCurrentIndex;
            }
            fillPathIfNeeded(0);
            return elementAtCurrentIndex;
        }
        throw new NoSuchElementException();
    }

    public E previous() {
        if (hasPrevious()) {
            setIndex(getIndex() - 1);
            if (this.isInRightEdge) {
                this.isInRightEdge = false;
                return elementAtCurrentIndex();
            }
            fillPathIfNeeded(31);
            return elementAtCurrentIndex();
        }
        throw new NoSuchElementException();
    }

    public final void reset$runtime_release(@NotNull Object[] objArr, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(objArr, "root");
        setIndex(i11);
        setSize(i12);
        this.height = i13;
        if (this.path.length < i13) {
            this.path = new Object[i13];
        }
        boolean z11 = false;
        this.path[0] = objArr;
        if (i11 == i12) {
            z11 = true;
        }
        this.isInRightEdge = z11;
        fillPath(i11 - (z11 ? 1 : 0), 1);
    }
}
