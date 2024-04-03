package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0006\u0010\f\u001a\u00020\tJ \u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0006\u0010\u0011\u001a\u00020\u0003J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003J&\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003J \u0010\u001c\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0006\u0010\u001d\u001a\u00020\u0013J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/ui/node/IntStack;", "", "initialCapacity", "", "(I)V", "lastIndex", "stack", "", "compareDiagonal", "", "a", "b", "isNotEmpty", "partition", "start", "end", "elSize", "pop", "pushDiagonal", "", "x", "y", "size", "pushRange", "oldStart", "oldEnd", "newStart", "newEnd", "quickSort", "sortDiagonals", "swapDiagonal", "i", "j", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class IntStack {
    private int lastIndex;
    @NotNull
    private int[] stack;

    public IntStack(int i11) {
        this.stack = new int[i11];
    }

    private final boolean compareDiagonal(int i11, int i12) {
        int[] iArr = this.stack;
        int i13 = iArr[i11];
        int i14 = iArr[i12];
        if (i13 < i14) {
            return true;
        }
        if (i13 != i14 || iArr[i11 + 1] > iArr[i12 + 1]) {
            return false;
        }
        return true;
    }

    private final int partition(int i11, int i12, int i13) {
        int i14 = i11 - i13;
        while (i11 < i12) {
            if (compareDiagonal(i11, i12)) {
                i14 += i13;
                swapDiagonal(i14, i11);
            }
            i11 += i13;
        }
        int i15 = i14 + i13;
        swapDiagonal(i15, i12);
        return i15;
    }

    private final void quickSort(int i11, int i12, int i13) {
        if (i11 < i12) {
            int partition = partition(i11, i12, i13);
            quickSort(i11, partition - i13, i13);
            quickSort(partition + i13, i12, i13);
        }
    }

    private final void swapDiagonal(int i11, int i12) {
        int[] iArr = this.stack;
        MyersDiffKt.swap(iArr, i11, i12);
        MyersDiffKt.swap(iArr, i11 + 1, i12 + 1);
        MyersDiffKt.swap(iArr, i11 + 2, i12 + 2);
    }

    public final boolean isNotEmpty() {
        return this.lastIndex != 0;
    }

    public final int pop() {
        int[] iArr = this.stack;
        int i11 = this.lastIndex - 1;
        this.lastIndex = i11;
        return iArr[i11];
    }

    public final void pushDiagonal(int i11, int i12, int i13) {
        int i14 = this.lastIndex;
        int i15 = i14 + 3;
        int[] iArr = this.stack;
        if (i15 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.stack = copyOf;
        }
        int[] iArr2 = this.stack;
        iArr2[i14 + 0] = i11 + i13;
        iArr2[i14 + 1] = i12 + i13;
        iArr2[i14 + 2] = i13;
        this.lastIndex = i15;
    }

    public final void pushRange(int i11, int i12, int i13, int i14) {
        int i15 = this.lastIndex;
        int i16 = i15 + 4;
        int[] iArr = this.stack;
        if (i16 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.stack = copyOf;
        }
        int[] iArr2 = this.stack;
        iArr2[i15 + 0] = i11;
        iArr2[i15 + 1] = i12;
        iArr2[i15 + 2] = i13;
        iArr2[i15 + 3] = i14;
        this.lastIndex = i16;
    }

    public final void sortDiagonals() {
        boolean z11;
        int i11 = this.lastIndex;
        if (i11 % 3 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (i11 > 3) {
            quickSort(0, i11 - 3, 3);
        }
    }
}
