package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "", "()V", "firstFreeHandle", "", "handles", "", "index", "<set-?>", "size", "getSize", "()I", "values", "add", "value", "allocateHandle", "ensure", "", "atLeast", "freeHandle", "handle", "lowestOrDefault", "default", "remove", "shiftDown", "shiftUp", "swap", "a", "b", "validate", "validateHandle", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SnapshotDoubleIndexHeap {
    private int firstFreeHandle;
    @NotNull
    private int[] handles;
    @NotNull
    private int[] index = new int[16];
    private int size;
    @NotNull
    private int[] values = new int[16];

    public SnapshotDoubleIndexHeap() {
        int[] iArr = new int[16];
        int i11 = 0;
        while (i11 < 16) {
            int i12 = i11 + 1;
            iArr[i11] = i12;
            i11 = i12;
        }
        this.handles = iArr;
    }

    private final int allocateHandle() {
        int length = this.handles.length;
        if (this.firstFreeHandle >= length) {
            int i11 = length * 2;
            int[] iArr = new int[i11];
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 + 1;
                iArr[i12] = i13;
                i12 = i13;
            }
            int[] unused = ArraysKt___ArraysJvmKt.copyInto$default(this.handles, iArr, 0, 0, 0, 14, (Object) null);
            this.handles = iArr;
        }
        int i14 = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[i14];
        return i14;
    }

    private final void ensure(int i11) {
        int[] iArr = this.values;
        int length = iArr.length;
        if (i11 > length) {
            int i12 = length * 2;
            int[] iArr2 = new int[i12];
            int[] iArr3 = new int[i12];
            int[] unused = ArraysKt___ArraysJvmKt.copyInto$default(iArr, iArr2, 0, 0, 0, 14, (Object) null);
            int[] unused2 = ArraysKt___ArraysJvmKt.copyInto$default(this.index, iArr3, 0, 0, 0, 14, (Object) null);
            this.values = iArr2;
            this.index = iArr3;
        }
    }

    private final void freeHandle(int i11) {
        this.handles[i11] = this.firstFreeHandle;
        this.firstFreeHandle = i11;
    }

    public static /* synthetic */ int lowestOrDefault$default(SnapshotDoubleIndexHeap snapshotDoubleIndexHeap, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        return snapshotDoubleIndexHeap.lowestOrDefault(i11);
    }

    private final void shiftDown(int i11) {
        int i12;
        int[] iArr = this.values;
        int i13 = this.size >> 1;
        while (i11 < i13) {
            int i14 = (i11 + 1) << 1;
            int i15 = i14 - 1;
            if (i14 >= this.size || (i12 = iArr[i14]) >= iArr[i15]) {
                if (iArr[i15] < iArr[i11]) {
                    swap(i15, i11);
                    i11 = i15;
                } else {
                    return;
                }
            } else if (i12 < iArr[i11]) {
                swap(i14, i11);
                i11 = i14;
            } else {
                return;
            }
        }
    }

    private final void shiftUp(int i11) {
        int[] iArr = this.values;
        int i12 = iArr[i11];
        while (i11 > 0) {
            int i13 = ((i11 + 1) >> 1) - 1;
            if (iArr[i13] > i12) {
                swap(i13, i11);
                i11 = i13;
            } else {
                return;
            }
        }
    }

    private final void swap(int i11, int i12) {
        int[] iArr = this.values;
        int[] iArr2 = this.index;
        int[] iArr3 = this.handles;
        int i13 = iArr[i11];
        iArr[i11] = iArr[i12];
        iArr[i12] = i13;
        int i14 = iArr2[i11];
        iArr2[i11] = iArr2[i12];
        iArr2[i12] = i14;
        iArr3[iArr2[i11]] = i11;
        iArr3[iArr2[i12]] = i12;
    }

    public final int add(int i11) {
        ensure(this.size + 1);
        int i12 = this.size;
        this.size = i12 + 1;
        int allocateHandle = allocateHandle();
        this.values[i12] = i11;
        this.index[i12] = allocateHandle;
        this.handles[allocateHandle] = i12;
        shiftUp(i12);
        return allocateHandle;
    }

    public final int getSize() {
        return this.size;
    }

    public final int lowestOrDefault(int i11) {
        return this.size > 0 ? this.values[0] : i11;
    }

    public final void remove(int i11) {
        int i12 = this.handles[i11];
        swap(i12, this.size - 1);
        this.size--;
        shiftUp(i12);
        shiftDown(i12);
        freeHandle(i11);
    }

    public final void validate() {
        int i11 = this.size;
        int i12 = 1;
        while (i12 < i11) {
            int i13 = i12 + 1;
            int[] iArr = this.values;
            if (iArr[(i13 >> 1) - 1] <= iArr[i12]) {
                i12 = i13;
            } else {
                throw new IllegalStateException(("Index " + i12 + " is out of place").toString());
            }
        }
    }

    public final void validateHandle(int i11, int i12) {
        int i13 = this.handles[i11];
        if (this.index[i13] != i11) {
            throw new IllegalStateException(("Index for handle " + i11 + " is corrupted").toString());
        } else if (this.values[i13] != i12) {
            throw new IllegalStateException(("Value for handle " + i11 + " was " + this.values[i13] + " but was supposed to be " + i12).toString());
        }
    }
}
