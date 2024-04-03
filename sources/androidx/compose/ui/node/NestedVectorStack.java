package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u000b\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/node/NestedVectorStack;", "T", "", "()V", "current", "", "indexes", "", "lastIndex", "vectors", "Landroidx/compose/runtime/collection/MutableVector;", "isNotEmpty", "", "pop", "()Ljava/lang/Object;", "push", "", "vector", "pushIndex", "value", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NestedVectorStack<T> {
    private int current = -1;
    @NotNull
    private int[] indexes = new int[16];
    private int lastIndex;
    @NotNull
    private final MutableVector<MutableVector<T>> vectors = new MutableVector<>(new MutableVector[16], 0);

    private final void pushIndex(int i11) {
        int i12 = this.lastIndex;
        int[] iArr = this.indexes;
        if (i12 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.indexes = copyOf;
        }
        int[] iArr2 = this.indexes;
        int i13 = this.lastIndex;
        this.lastIndex = i13 + 1;
        iArr2[i13] = i11;
    }

    public final boolean isNotEmpty() {
        int i11 = this.current;
        return i11 >= 0 && this.indexes[i11] >= 0;
    }

    public final T pop() {
        int i11 = this.current;
        int i12 = this.indexes[i11];
        MutableVector mutableVector = (MutableVector) this.vectors.getContent()[i11];
        if (i12 > 0) {
            int[] iArr = this.indexes;
            iArr[i11] = iArr[i11] - 1;
        } else if (i12 == 0) {
            this.vectors.removeAt(i11);
            this.current--;
        }
        return mutableVector.getContent()[i12];
    }

    public final void push(@NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "vector");
        if (mutableVector.isNotEmpty()) {
            this.vectors.add(mutableVector);
            pushIndex(mutableVector.getSize() - 1);
            this.current++;
        }
    }
}
